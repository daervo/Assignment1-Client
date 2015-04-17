package au.edu.unsw.soacourse.topdownclient;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import au.edu.unsw.soacourse.topdown.*;

@Controller
public class MarketServiceController {

	// TODO: Add the TopDownSimpleService interface as a member of the controller
	@Autowired
	private TopDownSimpleService simple; //this is instantiated by jaxws:client id=simple in dispatcher-servlet.xml
	//private MarketDataUtilService util; //this is instantiated by jaxws:client id=util in dispatcher-servlet.xml

	String EventSetIds = "";

	//@RequestMapping("/importMarket")
	public String processImportMarketData(ModelMap model) throws Exception {
		// TODO: Add the creation of an impoartMarketData request type and populate it
		ImportMarketDataRequest request = new ImportMarketDataRequest();
		request.setSec("ABC");
		request.setStartDate("01-DEC-2014");	  
		request.setEndDate("01-DEC-2014");	
		request.setDataSource("http://www.example.org.ss/marketfile");

		// TODO: Call the web service      
		ImportMarketDataResponse response = simple.importMarketData(request);

		// TODO: Replace null with the results from the web service response.
		model.addAttribute("returnData", response.getReturnData());

		// View we are returning to, in this case processImportMarketData.jsp 
		return "processImportMarketData";
	}

	//@RequestMapping("/downloadFile")
	public String processDownloadFile(ModelMap model) throws Exception {
		// TODO: Add the creation of a DownloadFile request type and populate it
		DownloadFileRequest request = new DownloadFileRequest();
		request.setEventSetID("abc-abc-111");

		// TODO: Call the web service 
		DownloadFileResponse response = simple.downloadFile(request);

		// TODO: Replace null with the results from the web service response.
		model.addAttribute("returnData", response.getDataURL());

		// View we are returning to, in this case processImportMarketData.jsp 
		return "processDownloadFile";
	}

	@RequestMapping(value="/importMarket", method=RequestMethod.POST)
	public String importMarket(HttpServletRequest req, ModelMap model,@ModelAttribute("importMarketBean")ImportMarketBean importMarketBean){
		if (importMarketBean!=null){
			System.out.println("Sec: " + importMarketBean.getSec());
			System.out.println("start: " + importMarketBean.getStartDate());
			System.out.println("end: " + importMarketBean.getEndDate());
			System.out.println("url: " + importMarketBean.getDataSourceURL());

			//create request
			ImportMarketDataRequest request = new ImportMarketDataRequest();
			request.setSec(importMarketBean.getSec());
			request.setStartDate(importMarketBean.getStartDate());
			request.setEndDate(importMarketBean.getEndDate());
			request.setDataSource(importMarketBean.getDataSourceURL());

			//call the web service
			try {
				ImportMarketDataResponse response = simple.importMarketData(request);
				EventSetIds += response.getReturnData() + ", ";
				req.getSession().setAttribute("eventSetIDs", EventSetIds);
			} catch (ImportMarketFaultMsg e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			System.out.println("importMarketBean is null");
		}
		return "redirect:index";
	}

	@RequestMapping(value="/downloadFile", method=RequestMethod.POST)
	public String downloadFile(HttpServletRequest req, ModelMap model, @ModelAttribute("downloadFileBean")DownloadFileBean downloadFileBean){
		if (downloadFileBean != null){
			System.out.println("eventsetid: " + downloadFileBean.getEventSetID());
			
			//create request
			DownloadFileRequest request = new DownloadFileRequest();
			request.setEventSetID(downloadFileBean.getEventSetID());
			
			// Call the web service 
			try {
				DownloadFileResponse response = simple.downloadFile(request);
				req.getSession().setAttribute("downloadURL", response.getDataURL());
			} catch (DownloadFileFaultMsg e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			System.out.println("importMarketBean is null");
		}
		return "redirect:index";
	}

	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String indexGET(HttpServletRequest request, ModelMap model){
		model.addAttribute("downloadFileBean", new DownloadFileBean());
		model.addAttribute("importMarketBean", new ImportMarketBean());
		
		//Show eventsetIDs if available
		String sessionEventSetIDs = (String) request.getSession().getAttribute("eventSetIDs");
		if (sessionEventSetIDs != null){
			request.setAttribute("eventSetIDs", sessionEventSetIDs);
		}
		
		//Show downloadURL if available
		String sessionDownloadURL = (String) request.getSession().getAttribute("downloadURL");
		if (sessionDownloadURL != null){
			request.setAttribute("downloadURL", sessionDownloadURL);
		}
		return "index";
	}

}
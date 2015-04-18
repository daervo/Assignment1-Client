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
	private MarketDataUtilService util; //this is instantiated by jaxws:client id=util in dispatcher-servlet.xml

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
	public String importMarket(HttpServletRequest httpRequest){
			System.out.println("Sec: " + httpRequest.getParameter("sec"));
			System.out.println("start: " + httpRequest.getParameter("startDate"));
			System.out.println("end: " + httpRequest.getParameter("endDate"));
			System.out.println("url: " + httpRequest.getParameter("dataSourceURL"));

			//create request
			ImportMarketDataRequest request = new ImportMarketDataRequest();
			request.setSec((String) httpRequest.getParameter("sec"));
			request.setStartDate((String) httpRequest.getParameter("startDate"));
			request.setEndDate((String) httpRequest.getParameter("endDate"));
			request.setDataSource((String) httpRequest.getParameter("dataSourceURL"));

			//call the web service
			try {
				ImportMarketDataResponse response = simple.importMarketData(request);
				EventSetIds += response.getReturnData() + ", ";
				httpRequest.getSession().setAttribute("eventSetIDs", EventSetIds);
				httpRequest.getSession().setAttribute("importMarketStatus", "Success!");
			} catch (ImportMarketFaultMsg e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				httpRequest.getSession().setAttribute("importMarketStatus", e.getLocalizedMessage());
			}
		return "redirect:index";
	}

	@RequestMapping(value="/downloadFile", method=RequestMethod.POST)
	public String downloadFile(HttpServletRequest httpRequest){
			System.out.println("eventsetid: " + httpRequest.getParameter("eventSetID"));
			
			//create request
			DownloadFileRequest request = new DownloadFileRequest();
			request.setEventSetID((String)httpRequest.getParameter("eventSetID"));
			
			// Call the web service 
			try {
				DownloadFileResponse response = simple.downloadFile(request);
				httpRequest.getSession().setAttribute("downloadURL", response.getDataURL());
			} catch (DownloadFileFaultMsg e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				httpRequest.getSession().setAttribute("downloadURL", e.getLocalizedMessage());
			}
		return "redirect:index";
	}

	@RequestMapping(value="/summariseMarketData", method=RequestMethod.POST)
	public String summariseMarketData(HttpServletRequest httpRequest){
			System.out.println("eventsetid: " + httpRequest.getParameter("eventSetID"));
			
			//create request
			SummariseMarketDataRequest request = new SummariseMarketDataRequest();
			request.setEventSetID((String)httpRequest.getParameter("eventSetID"));
			
			if (util != null){
			// Call the web service 
			try {
				SummariseMarketDataResponse response = util.summariseMarketData(request);
				httpRequest.getSession().setAttribute("summariseMarketData_eventSetID", response.getEventSetId());
				httpRequest.getSession().setAttribute("summariseMarketData_sec", response.getSec());
				httpRequest.getSession().setAttribute("summariseMarketData_startDate", response.getStartDate());
				httpRequest.getSession().setAttribute("summariseMarketData_endDate", response.getEndDate());
				httpRequest.getSession().setAttribute("summariseMarketData_currencyCode", response.getCurrencyCode());
				httpRequest.getSession().setAttribute("summariseMarketData_fileSize", response.getFileSize());
			} catch (SummariseMarketFaultMsg e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				httpRequest.getSession().setAttribute("summariseMarketData_error", e.getLocalizedMessage());
			}
			}else{
				System.out.println("util is null");
			}
		return "redirect:util";
	}

	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String indexGET(HttpServletRequest request){
		
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
	
	@RequestMapping(value="/utilPage", method=RequestMethod.GET)
	public String utilPageGET(HttpServletRequest request){
		
		//Show eventsetIDs if available
		String sessionEventSetIDs = (String) request.getSession().getAttribute("eventSetIDs");
		if (sessionEventSetIDs != null){
			request.setAttribute("eventSetIDs", sessionEventSetIDs);
		}
			
		return "util";
	}

}
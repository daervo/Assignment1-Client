package au.edu.unsw.soacourse.topdownclient;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;

import au.edu.unsw.soacourse.topdown.*;

@Controller
public class MarketServiceController {

	// TODO: Add the TopDownSimpleService interface as a member of the controller
	@Autowired
	private TopDownSimpleService simple; //this is instantiated by jaxws:client id=simple in dispatcher-servlet.xml
	//private MarketDataUtilService util; //this is instantiated by jaxws:client id=util in dispatcher-servlet.xml

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

	@RequestMapping(value="/index", method=RequestMethod.POST)
	public String showIndex(ModelMap model,@ModelAttribute("action")String action){
		if (action!=null){
			System.out.println("action is " + action);
			if (model.get("action").equals("importMarket")){
				System.out.println("importMarket");
			}else if (model.get("action").equals("downloadFile")){
				System.out.println("downloadFile");
			}
		}else{
			System.out.println("does not contain an action");
		}
		return "index";
	}
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String indexGET(){
		return "index";
	}

}
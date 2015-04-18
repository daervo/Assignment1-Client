package au.edu.unsw.soacourse.topdown;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.0.4
 * 2015-04-18T21:26:05.894+10:00
 * Generated source version: 3.0.4
 * 
 */
@WebService(targetNamespace = "http://topdown.soacourse.unsw.edu.au", name = "TopDownSimpleService")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface TopDownSimpleService {

    @WebResult(name = "downloadFileResponse", targetNamespace = "http://topdown.soacourse.unsw.edu.au", partName = "parameters")
    @WebMethod(action = "http://topdown.soacourse.unsw.edu.au/downloadFile")
    public DownloadFileResponse downloadFile(
        @WebParam(partName = "parameters", name = "downloadFileRequest", targetNamespace = "http://topdown.soacourse.unsw.edu.au")
        DownloadFileRequest parameters
    ) throws DownloadFileFaultMsg;

    @WebResult(name = "summariseMarketDataResponse", targetNamespace = "http://topdown.soacourse.unsw.edu.au", partName = "parameters")
    @WebMethod(action = "http://topdown.soacourse.unsw.edu.au/summariseMarketData")
    public SummariseMarketDataResponse summariseMarketData(
        @WebParam(partName = "parameters", name = "summariseMarketDataRequest", targetNamespace = "http://topdown.soacourse.unsw.edu.au")
        SummariseMarketDataRequest parameters
    ) throws SummariseMarketFaultMsg;

    @WebResult(name = "visualiseMarketDataResponse", targetNamespace = "http://topdown.soacourse.unsw.edu.au", partName = "parameters")
    @WebMethod(action = "http://topdown.soacourse.unsw.edu.au/visualiseMarketData")
    public VisualiseMarketDataResponse visualiseMarketData(
        @WebParam(partName = "parameters", name = "visualiseMarketDataRequest", targetNamespace = "http://topdown.soacourse.unsw.edu.au")
        VisualiseMarketDataRequest parameters
    ) throws VisualiseMarketFaultMsg;

    @WebResult(name = "convertMarketDataResponse", targetNamespace = "http://topdown.soacourse.unsw.edu.au", partName = "parameters")
    @WebMethod(action = "http://topdown.soacourse.unsw.edu.au/convertMarketData")
    public ConvertMarketDataResponse convertMarketData(
        @WebParam(partName = "parameters", name = "convertMarketDataRequest", targetNamespace = "http://topdown.soacourse.unsw.edu.au")
        ConvertMarketDataRequest parameters
    ) throws ConvertMarketFaultMsg;

    @WebResult(name = "importMarketDataResponse", targetNamespace = "http://topdown.soacourse.unsw.edu.au", partName = "parameters")
    @WebMethod(action = "http://topdown.soacourse.unsw.edu.au/importMarketData")
    public ImportMarketDataResponse importMarketData(
        @WebParam(partName = "parameters", name = "importMarketDataRequest", targetNamespace = "http://topdown.soacourse.unsw.edu.au")
        ImportMarketDataRequest parameters
    ) throws ImportMarketFaultMsg;
}

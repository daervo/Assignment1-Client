package au.edu.unsw.soacourse.topdown;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.0.4
 * 2015-04-16T23:23:08.814+10:00
 * Generated source version: 3.0.4
 * 
 */
@WebServiceClient(name = "TopDownSimpleServiceImplService", 
                  wsdlLocation = "http://localhost:8080/Assignment1/TopDownSimpleService?wsdl",
                  targetNamespace = "http://topdown.soacourse.unsw.edu.au/") 
public class TopDownSimpleServiceImplService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://topdown.soacourse.unsw.edu.au/", "TopDownSimpleServiceImplService");
    public final static QName TopDownSimpleServiceImplPort = new QName("http://topdown.soacourse.unsw.edu.au/", "TopDownSimpleServiceImplPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/Assignment1/TopDownSimpleService?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(TopDownSimpleServiceImplService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/Assignment1/TopDownSimpleService?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public TopDownSimpleServiceImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public TopDownSimpleServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TopDownSimpleServiceImplService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public TopDownSimpleServiceImplService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public TopDownSimpleServiceImplService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public TopDownSimpleServiceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    

    /**
     *
     * @return
     *     returns TopDownSimpleService
     */
    @WebEndpoint(name = "TopDownSimpleServiceImplPort")
    public TopDownSimpleService getTopDownSimpleServiceImplPort() {
        return super.getPort(TopDownSimpleServiceImplPort, TopDownSimpleService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns TopDownSimpleService
     */
    @WebEndpoint(name = "TopDownSimpleServiceImplPort")
    public TopDownSimpleService getTopDownSimpleServiceImplPort(WebServiceFeature... features) {
        return super.getPort(TopDownSimpleServiceImplPort, TopDownSimpleService.class, features);
    }

}

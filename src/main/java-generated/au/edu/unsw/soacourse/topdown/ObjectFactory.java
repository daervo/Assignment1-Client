
package au.edu.unsw.soacourse.topdown;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the au.edu.unsw.soacourse.topdown package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ConvertMarketFault_QNAME = new QName("http://topdown.soacourse.unsw.edu.au", "convertMarketFault");
    private final static QName _SummariseMarketFault_QNAME = new QName("http://topdown.soacourse.unsw.edu.au", "summariseMarketFault");
    private final static QName _VisualiseMarketFault_QNAME = new QName("http://topdown.soacourse.unsw.edu.au", "visualiseMarketFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: au.edu.unsw.soacourse.topdown
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConvertMarketDataRequest }
     * 
     */
    public ConvertMarketDataRequest createConvertMarketDataRequest() {
        return new ConvertMarketDataRequest();
    }

    /**
     * Create an instance of {@link ConvertMarketDataResponse }
     * 
     */
    public ConvertMarketDataResponse createConvertMarketDataResponse() {
        return new ConvertMarketDataResponse();
    }

    /**
     * Create an instance of {@link ServiceFaultType }
     * 
     */
    public ServiceFaultType createServiceFaultType() {
        return new ServiceFaultType();
    }

    /**
     * Create an instance of {@link DownloadFileResponse }
     * 
     */
    public DownloadFileResponse createDownloadFileResponse() {
        return new DownloadFileResponse();
    }

    /**
     * Create an instance of {@link ImportMarketDataResponse }
     * 
     */
    public ImportMarketDataResponse createImportMarketDataResponse() {
        return new ImportMarketDataResponse();
    }

    /**
     * Create an instance of {@link SummariseMarketDataRequest }
     * 
     */
    public SummariseMarketDataRequest createSummariseMarketDataRequest() {
        return new SummariseMarketDataRequest();
    }

    /**
     * Create an instance of {@link SummariseMarketDataResponse }
     * 
     */
    public SummariseMarketDataResponse createSummariseMarketDataResponse() {
        return new SummariseMarketDataResponse();
    }

    /**
     * Create an instance of {@link VisualiseMarketDataRequest }
     * 
     */
    public VisualiseMarketDataRequest createVisualiseMarketDataRequest() {
        return new VisualiseMarketDataRequest();
    }

    /**
     * Create an instance of {@link VisualiseMarketDataResponse }
     * 
     */
    public VisualiseMarketDataResponse createVisualiseMarketDataResponse() {
        return new VisualiseMarketDataResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceFaultType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://topdown.soacourse.unsw.edu.au", name = "convertMarketFault")
    public JAXBElement<ServiceFaultType> createConvertMarketFault(ServiceFaultType value) {
        return new JAXBElement<ServiceFaultType>(_ConvertMarketFault_QNAME, ServiceFaultType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceFaultType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://topdown.soacourse.unsw.edu.au", name = "summariseMarketFault")
    public JAXBElement<ServiceFaultType> createSummariseMarketFault(ServiceFaultType value) {
        return new JAXBElement<ServiceFaultType>(_SummariseMarketFault_QNAME, ServiceFaultType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceFaultType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://topdown.soacourse.unsw.edu.au", name = "visualiseMarketFault")
    public JAXBElement<ServiceFaultType> createVisualiseMarketFault(ServiceFaultType value) {
        return new JAXBElement<ServiceFaultType>(_VisualiseMarketFault_QNAME, ServiceFaultType.class, null, value);
    }

}

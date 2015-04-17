
package au.edu.unsw.soacourse.topdown;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.0.4
 * 2015-04-17T13:11:36.382+10:00
 * Generated source version: 3.0.4
 */

@WebFault(name = "summariseMarketFault", targetNamespace = "http://topdown.soacourse.unsw.edu.au")
public class SummariseMarketFaultMsg extends Exception {
    
    private au.edu.unsw.soacourse.topdown.ServiceFaultType summariseMarketFault;

    public SummariseMarketFaultMsg() {
        super();
    }
    
    public SummariseMarketFaultMsg(String message) {
        super(message);
    }
    
    public SummariseMarketFaultMsg(String message, Throwable cause) {
        super(message, cause);
    }

    public SummariseMarketFaultMsg(String message, au.edu.unsw.soacourse.topdown.ServiceFaultType summariseMarketFault) {
        super(message);
        this.summariseMarketFault = summariseMarketFault;
    }

    public SummariseMarketFaultMsg(String message, au.edu.unsw.soacourse.topdown.ServiceFaultType summariseMarketFault, Throwable cause) {
        super(message, cause);
        this.summariseMarketFault = summariseMarketFault;
    }

    public au.edu.unsw.soacourse.topdown.ServiceFaultType getFaultInfo() {
        return this.summariseMarketFault;
    }
}

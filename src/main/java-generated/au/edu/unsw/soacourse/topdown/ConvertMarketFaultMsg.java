
package au.edu.unsw.soacourse.topdown;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.0.4
 * 2015-04-18T23:04:54.222+10:00
 * Generated source version: 3.0.4
 */

@WebFault(name = "convertMarketFault", targetNamespace = "http://topdown.soacourse.unsw.edu.au")
public class ConvertMarketFaultMsg extends Exception {
    
    private au.edu.unsw.soacourse.topdown.ServiceFaultType convertMarketFault;

    public ConvertMarketFaultMsg() {
        super();
    }
    
    public ConvertMarketFaultMsg(String message) {
        super(message);
    }
    
    public ConvertMarketFaultMsg(String message, Throwable cause) {
        super(message, cause);
    }

    public ConvertMarketFaultMsg(String message, au.edu.unsw.soacourse.topdown.ServiceFaultType convertMarketFault) {
        super(message);
        this.convertMarketFault = convertMarketFault;
    }

    public ConvertMarketFaultMsg(String message, au.edu.unsw.soacourse.topdown.ServiceFaultType convertMarketFault, Throwable cause) {
        super(message, cause);
        this.convertMarketFault = convertMarketFault;
    }

    public au.edu.unsw.soacourse.topdown.ServiceFaultType getFaultInfo() {
        return this.convertMarketFault;
    }
}

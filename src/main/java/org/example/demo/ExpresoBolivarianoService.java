package org.example.demo;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.4
 * 2018-05-11T17:08:58.713-05:00
 * Generated source version: 3.2.4
 *
 */
@WebServiceClient(name = "ExpresoBolivarianoService",
                  wsdlLocation = "file:/D:/oxygen/eclipse-workspace/ExpBolivarianoSOAPService/src/main/resources/wsdl/expresobolivariano.wsdl",
                  targetNamespace = "http://www.example.org/demo/")
public class ExpresoBolivarianoService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.example.org/demo/", "ExpresoBolivarianoService");
    public final static QName ExpresoBolivarianoServicesEndpoint = new QName("http://www.example.org/demo/", "ExpresoBolivarianoServicesEndpoint");
    static {
        URL url = null;
        try {
            url = new URL("file:/D:/oxygen/eclipse-workspace/ExpBolivarianoSOAPService/src/main/resources/wsdl/expresobolivariano.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(ExpresoBolivarianoService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "file:/D:/oxygen/eclipse-workspace/ExpBolivarianoSOAPService/src/main/resources/wsdl/expresobolivariano.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public ExpresoBolivarianoService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ExpresoBolivarianoService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ExpresoBolivarianoService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public ExpresoBolivarianoService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public ExpresoBolivarianoService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public ExpresoBolivarianoService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns ExpresoBolivarianoSystemServices
     */
    @WebEndpoint(name = "ExpresoBolivarianoServicesEndpoint")
    public ExpresoBolivarianoSystemServices getExpresoBolivarianoServicesEndpoint() {
        return super.getPort(ExpresoBolivarianoServicesEndpoint, ExpresoBolivarianoSystemServices.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ExpresoBolivarianoSystemServices
     */
    @WebEndpoint(name = "ExpresoBolivarianoServicesEndpoint")
    public ExpresoBolivarianoSystemServices getExpresoBolivarianoServicesEndpoint(WebServiceFeature... features) {
        return super.getPort(ExpresoBolivarianoServicesEndpoint, ExpresoBolivarianoSystemServices.class, features);
    }

}
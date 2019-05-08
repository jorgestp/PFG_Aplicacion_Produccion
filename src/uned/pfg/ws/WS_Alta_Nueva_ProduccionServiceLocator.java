/**
 * WS_Alta_Nueva_ProduccionServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package uned.pfg.ws;

public class WS_Alta_Nueva_ProduccionServiceLocator extends org.apache.axis.client.Service implements uned.pfg.ws.WS_Alta_Nueva_ProduccionService {

    public WS_Alta_Nueva_ProduccionServiceLocator() {
    }


    public WS_Alta_Nueva_ProduccionServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WS_Alta_Nueva_ProduccionServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WS_Alta_Nueva_Produccion
    private java.lang.String WS_Alta_Nueva_Produccion_address = "http://localhost:8080/Aplicacion_Web/services/WS_Alta_Nueva_Produccion";

    public java.lang.String getWS_Alta_Nueva_ProduccionAddress() {
        return WS_Alta_Nueva_Produccion_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WS_Alta_Nueva_ProduccionWSDDServiceName = "WS_Alta_Nueva_Produccion";

    public java.lang.String getWS_Alta_Nueva_ProduccionWSDDServiceName() {
        return WS_Alta_Nueva_ProduccionWSDDServiceName;
    }

    public void setWS_Alta_Nueva_ProduccionWSDDServiceName(java.lang.String name) {
        WS_Alta_Nueva_ProduccionWSDDServiceName = name;
    }

    public uned.pfg.ws.WS_Alta_Nueva_Produccion getWS_Alta_Nueva_Produccion() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WS_Alta_Nueva_Produccion_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWS_Alta_Nueva_Produccion(endpoint);
    }

    public uned.pfg.ws.WS_Alta_Nueva_Produccion getWS_Alta_Nueva_Produccion(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            uned.pfg.ws.WS_Alta_Nueva_ProduccionSoapBindingStub _stub = new uned.pfg.ws.WS_Alta_Nueva_ProduccionSoapBindingStub(portAddress, this);
            _stub.setPortName(getWS_Alta_Nueva_ProduccionWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWS_Alta_Nueva_ProduccionEndpointAddress(java.lang.String address) {
        WS_Alta_Nueva_Produccion_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (uned.pfg.ws.WS_Alta_Nueva_Produccion.class.isAssignableFrom(serviceEndpointInterface)) {
                uned.pfg.ws.WS_Alta_Nueva_ProduccionSoapBindingStub _stub = new uned.pfg.ws.WS_Alta_Nueva_ProduccionSoapBindingStub(new java.net.URL(WS_Alta_Nueva_Produccion_address), this);
                _stub.setPortName(getWS_Alta_Nueva_ProduccionWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("WS_Alta_Nueva_Produccion".equals(inputPortName)) {
            return getWS_Alta_Nueva_Produccion();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.pfg.uned", "WS_Alta_Nueva_ProduccionService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.pfg.uned", "WS_Alta_Nueva_Produccion"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WS_Alta_Nueva_Produccion".equals(portName)) {
            setWS_Alta_Nueva_ProduccionEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}

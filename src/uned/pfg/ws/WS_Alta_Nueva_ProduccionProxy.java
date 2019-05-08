package uned.pfg.ws;

public class WS_Alta_Nueva_ProduccionProxy implements uned.pfg.ws.WS_Alta_Nueva_Produccion {
  private String _endpoint = null;
  private uned.pfg.ws.WS_Alta_Nueva_Produccion wS_Alta_Nueva_Produccion = null;
  
  public WS_Alta_Nueva_ProduccionProxy() {
    _initWS_Alta_Nueva_ProduccionProxy();
  }
  
  public WS_Alta_Nueva_ProduccionProxy(String endpoint) {
    _endpoint = endpoint;
    _initWS_Alta_Nueva_ProduccionProxy();
  }
  
  private void _initWS_Alta_Nueva_ProduccionProxy() {
    try {
      wS_Alta_Nueva_Produccion = (new uned.pfg.ws.WS_Alta_Nueva_ProduccionServiceLocator()).getWS_Alta_Nueva_Produccion();
      if (wS_Alta_Nueva_Produccion != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wS_Alta_Nueva_Produccion)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wS_Alta_Nueva_Produccion)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wS_Alta_Nueva_Produccion != null)
      ((javax.xml.rpc.Stub)wS_Alta_Nueva_Produccion)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public uned.pfg.ws.WS_Alta_Nueva_Produccion getWS_Alta_Nueva_Produccion() {
    if (wS_Alta_Nueva_Produccion == null)
      _initWS_Alta_Nueva_ProduccionProxy();
    return wS_Alta_Nueva_Produccion;
  }
  
  public java.lang.String nuevaAltaProduccion(java.lang.String articuloPedido) throws java.rmi.RemoteException{
    if (wS_Alta_Nueva_Produccion == null)
      _initWS_Alta_Nueva_ProduccionProxy();
    return wS_Alta_Nueva_Produccion.nuevaAltaProduccion(articuloPedido);
  }
  
  
}
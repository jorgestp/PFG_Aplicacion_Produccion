package uned.pfg.ws;

public class WS_ArticulosSinRealizarProxy implements uned.pfg.ws.WS_ArticulosSinRealizar {
  private String _endpoint = null;
  private uned.pfg.ws.WS_ArticulosSinRealizar wS_ArticulosSinRealizar = null;
  
  public WS_ArticulosSinRealizarProxy() {
    _initWS_ArticulosSinRealizarProxy();
  }
  
  public WS_ArticulosSinRealizarProxy(String endpoint) {
    _endpoint = endpoint;
    _initWS_ArticulosSinRealizarProxy();
  }
  
  private void _initWS_ArticulosSinRealizarProxy() {
    try {
      wS_ArticulosSinRealizar = (new uned.pfg.ws.WS_ArticulosSinRealizarServiceLocator()).getWS_ArticulosSinRealizar();
      if (wS_ArticulosSinRealizar != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wS_ArticulosSinRealizar)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wS_ArticulosSinRealizar)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wS_ArticulosSinRealizar != null)
      ((javax.xml.rpc.Stub)wS_ArticulosSinRealizar)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public uned.pfg.ws.WS_ArticulosSinRealizar getWS_ArticulosSinRealizar() {
    if (wS_ArticulosSinRealizar == null)
      _initWS_ArticulosSinRealizarProxy();
    return wS_ArticulosSinRealizar;
  }
  
  public java.lang.String enviarArticulosSinRealizar() throws java.rmi.RemoteException{
    if (wS_ArticulosSinRealizar == null)
      _initWS_ArticulosSinRealizarProxy();
    return wS_ArticulosSinRealizar.enviarArticulosSinRealizar();
  }
  
  
}
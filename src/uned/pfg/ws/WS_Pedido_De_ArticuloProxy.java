package uned.pfg.ws;

public class WS_Pedido_De_ArticuloProxy implements uned.pfg.ws.WS_Pedido_De_Articulo {
  private String _endpoint = null;
  private uned.pfg.ws.WS_Pedido_De_Articulo wS_Pedido_De_Articulo = null;
  
  public WS_Pedido_De_ArticuloProxy() {
    _initWS_Pedido_De_ArticuloProxy();
  }
  
  public WS_Pedido_De_ArticuloProxy(String endpoint) {
    _endpoint = endpoint;
    _initWS_Pedido_De_ArticuloProxy();
  }
  
  private void _initWS_Pedido_De_ArticuloProxy() {
    try {
      wS_Pedido_De_Articulo = (new uned.pfg.ws.WS_Pedido_De_ArticuloServiceLocator()).getWS_Pedido_De_Articulo();
      if (wS_Pedido_De_Articulo != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wS_Pedido_De_Articulo)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wS_Pedido_De_Articulo)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wS_Pedido_De_Articulo != null)
      ((javax.xml.rpc.Stub)wS_Pedido_De_Articulo)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public uned.pfg.ws.WS_Pedido_De_Articulo getWS_Pedido_De_Articulo() {
    if (wS_Pedido_De_Articulo == null)
      _initWS_Pedido_De_ArticuloProxy();
    return wS_Pedido_De_Articulo;
  }
  
  public java.lang.String envioPedido(java.lang.String id) throws java.rmi.RemoteException{
    if (wS_Pedido_De_Articulo == null)
      _initWS_Pedido_De_ArticuloProxy();
    return wS_Pedido_De_Articulo.envioPedido(id);
  }
  
  
}
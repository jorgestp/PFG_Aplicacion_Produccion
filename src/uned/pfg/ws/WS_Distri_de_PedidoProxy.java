package uned.pfg.ws;

public class WS_Distri_de_PedidoProxy implements uned.pfg.ws.WS_Distri_de_Pedido {
  private String _endpoint = null;
  private uned.pfg.ws.WS_Distri_de_Pedido wS_Distri_de_Pedido = null;
  
  public WS_Distri_de_PedidoProxy() {
    _initWS_Distri_de_PedidoProxy();
  }
  
  public WS_Distri_de_PedidoProxy(String endpoint) {
    _endpoint = endpoint;
    _initWS_Distri_de_PedidoProxy();
  }
  
  private void _initWS_Distri_de_PedidoProxy() {
    try {
      wS_Distri_de_Pedido = (new uned.pfg.ws.WS_Distri_de_PedidoServiceLocator()).getWS_Distri_de_Pedido();
      if (wS_Distri_de_Pedido != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wS_Distri_de_Pedido)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wS_Distri_de_Pedido)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wS_Distri_de_Pedido != null)
      ((javax.xml.rpc.Stub)wS_Distri_de_Pedido)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public uned.pfg.ws.WS_Distri_de_Pedido getWS_Distri_de_Pedido() {
    if (wS_Distri_de_Pedido == null)
      _initWS_Distri_de_PedidoProxy();
    return wS_Distri_de_Pedido;
  }
  
  public java.lang.String envioDistribuidor(java.lang.String id) throws java.rmi.RemoteException{
    if (wS_Distri_de_Pedido == null)
      _initWS_Distri_de_PedidoProxy();
    return wS_Distri_de_Pedido.envioDistribuidor(id);
  }
  
  
}
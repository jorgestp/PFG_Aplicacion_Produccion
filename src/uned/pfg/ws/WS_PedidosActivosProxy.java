package uned.pfg.ws;

public class WS_PedidosActivosProxy implements uned.pfg.ws.WS_PedidosActivos {
  private String _endpoint = null;
  private uned.pfg.ws.WS_PedidosActivos wS_PedidosActivos = null;
  
  public WS_PedidosActivosProxy() {
    _initWS_PedidosActivosProxy();
  }
  
  public WS_PedidosActivosProxy(String endpoint) {
    _endpoint = endpoint;
    _initWS_PedidosActivosProxy();
  }
  
  private void _initWS_PedidosActivosProxy() {
    try {
      wS_PedidosActivos = (new uned.pfg.ws.WS_PedidosActivosServiceLocator()).getWS_PedidosActivos();
      if (wS_PedidosActivos != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wS_PedidosActivos)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wS_PedidosActivos)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wS_PedidosActivos != null)
      ((javax.xml.rpc.Stub)wS_PedidosActivos)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public uned.pfg.ws.WS_PedidosActivos getWS_PedidosActivos() {
    if (wS_PedidosActivos == null)
      _initWS_PedidosActivosProxy();
    return wS_PedidosActivos;
  }
  
  public java.lang.String envioPedido(java.lang.String id_dist) throws java.rmi.RemoteException{
    if (wS_PedidosActivos == null)
      _initWS_PedidosActivosProxy();
    return wS_PedidosActivos.envioPedido(id_dist);
  }
  
  
}
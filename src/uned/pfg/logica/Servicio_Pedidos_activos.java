package uned.pfg.logica;

import java.rmi.RemoteException;

import uned.pfg.ws.WS_PedidosActivos;
import uned.pfg.ws.WS_PedidosActivosProxy;

public class Servicio_Pedidos_activos {
	
	public Servicio_Pedidos_activos() {

	
	}

	public String cogerServicio(int id_distribuidor) {

		WS_PedidosActivos ws = new WS_PedidosActivosProxy("http://localhost:8080/Aplicacion_Web/services/WS_PedidosActivos");
		
		try {
			String respuesta = ws.envioPedido(String.valueOf(id_distribuidor));
			
			return respuesta;
		} catch (RemoteException e) {
			
			e.printStackTrace();
			
			return "-1";
		}
		
	}

}

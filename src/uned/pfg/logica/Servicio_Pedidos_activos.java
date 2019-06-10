package uned.pfg.logica;

import java.rmi.RemoteException;

import uned.pfg.ws.WS_PedidosActivos;
import uned.pfg.ws.WS_PedidosActivosProxy;

/**
 * Clase que consume el servicio web del servidor, de modo que, recoge todos los
 * pedidos que se encuentran activos en el sistema de un determinado usuario.
 * Por pedido activo se refiere a que se encuentra en estado "En Tramite"
 * 
 * 
 * @author JORGE VILLALBA RUIZ 47536486V
 * @version 1.0
 */
public class Servicio_Pedidos_activos {

	/**
	 * Constructor por defecto
	 */
	public Servicio_Pedidos_activos() {

	}

	/**
	 * Funcion que consume el sevicio web, de modo que se le pasa el identificador
	 * del distribuidor para ver cuantos pedidos tiene activos. La respuesta del
	 * servicio web es un valor numerico parseado a String
	 * 
	 * @param id_distribuidor Identificador del distribuidor
	 * @return String que representa el numero de pedidos activos que tiene el
	 *         distribuidor. Si no tiene ninguno el valor es -1
	 */
	public String cogerServicio(int id_distribuidor) {

		WS_PedidosActivos ws = new WS_PedidosActivosProxy(
				"http://localhost:8080/Aplicacion_Web/services/WS_PedidosActivos");

		try {
			String respuesta = ws.envioPedido(String.valueOf(id_distribuidor));

			return respuesta;
		} catch (RemoteException e) {

			e.printStackTrace();

			return "-1";
		}

	}

}

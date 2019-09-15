package uned.pfg.test;

import static org.junit.Assert.*;

import org.junit.Test;


import java.util.Iterator;
import java.util.List;



import uned.pfg.bean.Pedido;
import uned.pfg.logica.ServicioPedido;

public class ServicioPedidoTest {



	
	@Test
	public void obtencionPedidosTest() {
		
		ServicioPedido serv = new ServicioPedido();
		
		List<Pedido> lista = serv.parseXMLtoList();
		
		Iterator<Pedido> it =lista.iterator();
		
		while(it.hasNext()) {
			
			Pedido ped = it.next();
			assertNotNull(ped);
		}
		serv = null;
	}

}

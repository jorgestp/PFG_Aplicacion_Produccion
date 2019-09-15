package uned.pfg.test;

import static org.junit.Assert.*;

import org.junit.Test;

import uned.pfg.bean.Articulo;
import uned.pfg.bean.ArticuloPedido;
import uned.pfg.logica.Servicio_Nueva_produccion;

public class Servicio_Nueva_Produccion_Test {

	@Test
	public void test() {
		
		ArticuloPedido artPed = new ArticuloPedido(new Articulo(10), 100);
		Servicio_Nueva_produccion serv = new Servicio_Nueva_produccion(artPed);
		
		String respuesta = null;
		
		respuesta = serv.cogerServicio();
		
		System.out.println(respuesta);
		
		assertNotNull(respuesta);
	}

}

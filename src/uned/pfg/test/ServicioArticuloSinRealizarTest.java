package uned.pfg.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import uned.pfg.bean.ArticuloPedido;
import uned.pfg.logica.Servicio_Art_Sin_Realizar;

public class ServicioArticuloSinRealizarTest {

	@Test
	public void test() {
		Servicio_Art_Sin_Realizar serv = new Servicio_Art_Sin_Realizar();
		
		List<ArticuloPedido> list = serv.parseXMLtoList();
		
		assertNotNull(list);
	}

}

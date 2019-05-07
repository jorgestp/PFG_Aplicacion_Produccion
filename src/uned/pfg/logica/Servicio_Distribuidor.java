package uned.pfg.logica;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import uned.pfg.bean.Distribuidor;
import uned.pfg.bean.Pedido;
import uned.pfg.ws.WS_Distri_de_Pedido;
import uned.pfg.ws.WS_Distri_de_PedidoProxy;

public class Servicio_Distribuidor {
	
	private static final String ARCHIVO = "ditribuidor_pedido.xml";
	
	public Servicio_Distribuidor(int id_distri) {

		cogerServicio(id_distri);
	}

	private void cogerServicio(int id_distri) {

		WS_Distri_de_Pedido ws = new WS_Distri_de_PedidoProxy("http://localhost:8080/Aplicacion_Web/services/WS_Distri_de_Pedido");
		
        try (FileWriter file = new FileWriter(ARCHIVO)) {
            PrintWriter p = new PrintWriter(file);
            p.print(ws.envioDistribuidor(String.valueOf(id_distri)));
            p.close();
        }catch(Exception e){
            
            e.printStackTrace();
        }
	}
	
	
	public Distribuidor parseXMLtoList(){
	       
		Distribuidor d = null;
	       Pedido p = null;
	       try {
	   
	           String [] aux; 
	           aux = new String[2];
	   
	   
	   
	   DocumentBuilderFactory fabricaCreadorDocumento = DocumentBuilderFactory.newInstance();
	   DocumentBuilder creadorDocumento = fabricaCreadorDocumento.newDocumentBuilder();
	   Document documento = creadorDocumento.parse(ARCHIVO);
	   
	   Element raiz = documento.getDocumentElement();

	   //Obtener la lista de nodos que tienen etiqueta "reserva"
	   NodeList listaEmpleados = raiz.getElementsByTagName("distribuidor");
	   //Recorrer la lista de reserva

	   for(int i=0; i<listaEmpleados.getLength(); i++) {   
	       
	       Node empleado = listaEmpleados.item(i);
	   

	       
	       NodeList datosEmpleado = empleado.getChildNodes();
	       
	       for(int j=0; j<datosEmpleado.getLength(); j++) {
	           //Obtener de la lista de datos un dato tras otro
	           Node dato = datosEmpleado.item(j);

	           //Comprobar que el dato se trata de un nodo de tipo Element
	           if(dato.getNodeType()==Node.ELEMENT_NODE) {

	               Node datoContenido = dato.getFirstChild();                        
	               //Mostrar el valor contenido en el nodo que debe ser de tipo Text
	               if(datoContenido!=null && datoContenido.getNodeType()==Node.TEXT_NODE)
	                
	                aux[j] = datoContenido.getNodeValue();
	           } 
	       }
	       
	       	d = new Distribuidor(Integer.parseInt(aux[0]), aux[1]);
	   }
	   

	} catch (Exception ex) {
	   
	   ex.printStackTrace();
	} 
	       
	       return d;
	   }

}

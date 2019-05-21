package uned.pfg.logica;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import uned.pfg.bean.Articulo;
import uned.pfg.bean.Pedido;
import uned.pfg.ws.WS_Pedido_De_Articulo;
import uned.pfg.ws.WS_Pedido_De_ArticuloProxy;

public class Servicio_Pedidos_conArticulo {

	private static final String ARCHIVO = "XML_pedidos_con_Art_id.xml";
	
	public Servicio_Pedidos_conArticulo(int id_articulo) {

		cogerServicio(id_articulo);
	
	}

	private void cogerServicio(int id_articulo) {

		WS_Pedido_De_Articulo ws = new WS_Pedido_De_ArticuloProxy("http://localhost:8080/Aplicacion_Web/services/WS_Pedido_De_Articulo");
		
        try (FileWriter file = new FileWriter(ARCHIVO)) {
            PrintWriter p = new PrintWriter(file);
            p.print(ws.envioPedido(String.valueOf(id_articulo)));
            p.close();
        }catch(Exception e){
            
            e.printStackTrace();
        }
	}
	
	
	public List<Pedido> parseXMLtoList(){
	       
		List<Pedido> lista = new ArrayList<Pedido>();
	       Pedido p = null;
	       try {
	   
	           String [] aux; 
	           aux = new String[5];
	   
	   
	   
	   DocumentBuilderFactory fabricaCreadorDocumento = DocumentBuilderFactory.newInstance();
	   DocumentBuilder creadorDocumento = fabricaCreadorDocumento.newDocumentBuilder();
	   Document documento = creadorDocumento.parse(ARCHIVO);
	   
	   Element raiz = documento.getDocumentElement();

	   //Obtener la lista de nodos que tienen etiqueta "reserva"
	   NodeList listaEmpleados = raiz.getElementsByTagName("pedido");
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
	       
	       	p = new Pedido(Integer.parseInt(aux[0]), Integer.parseInt(aux[1]));

	       
	       lista.add(p);
	          
	          
	       
	   }
	   

	} catch (Exception ex) {
	   
	   ex.printStackTrace();
	} 
			File fichero = new File(ARCHIVO);
			fichero.delete();
	       return lista;
	   }
}

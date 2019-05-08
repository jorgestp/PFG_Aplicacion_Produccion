package uned.pfg.logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import uned.pfg.bean.ArticuloPedido;
import uned.pfg.ws.WS_Alta_Nueva_Produccion;
import uned.pfg.ws.WS_Alta_Nueva_ProduccionProxy;

public class Servicio_Nueva_produccion {


	private static final String SEND = "XML_altaProduccion.xml";
	private ArticuloPedido artPed;
	
	public Servicio_Nueva_produccion(ArticuloPedido artPed) {
		
		this.artPed = artPed;
		
	}

	public String cogerServicio() {

		WS_Alta_Nueva_Produccion ws = new WS_Alta_Nueva_ProduccionProxy("http://localhost:8080/Aplicacion_Web/services/WS_Alta_Nueva_Produccion");
		String respuesta="error";
		try {
			 respuesta = ws.nuevaAltaProduccion(crearXML_Articulos());
			 return respuesta;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return respuesta;
			
		}
		
	}
	
	private String crearXML_Articulos() {
		
		
		 String s = "";
	        String line;
	          
	      try{
	           
	              DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	              DocumentBuilder builder = factory.newDocumentBuilder();
	              Document document = builder.newDocument();
	              
	              Element root = document.createElement("articulosPedidos");
	              document.appendChild(root);
	              	                  
	                  Element art = document.createElement("articuloPedido");
	                  root.appendChild(art);
	                 
	                  Element id_articulo = document. createElement("id_articulo");
	                  art.appendChild(id_articulo);
	                  id_articulo.appendChild(document.createTextNode(String.valueOf(artPed.getArticulo().getId_articulo())));
	                  
	                  
	                  Element cantidad = document.createElement("cantidad");
	                  art.appendChild(cantidad);
	                  cantidad.appendChild(document.createTextNode(String.valueOf(artPed.getCant())));
      
	              
	              TransformerFactory tFactory = TransformerFactory.newInstance();
	              Transformer transformer = tFactory.newTransformer();
	              DOMSource source = new DOMSource(document);
	              StreamResult result = new StreamResult(new File(SEND));

	              transformer.transform(source, result);
	              
	              File ar = new File(SEND);
	              FileReader f = new FileReader(ar);
	              BufferedReader b = new BufferedReader(f); 
	              while((line = b.readLine())!=null) {
	                  s= s + line +"\n";
	                  
	              } 
	              
	              System.out.println(ar.getAbsolutePath());
	              
	          }catch( IOException | ParserConfigurationException | TransformerException | DOMException e){
	              
	              e.printStackTrace();
	          }
	     
	          
	          return s;
	}
	
	
}

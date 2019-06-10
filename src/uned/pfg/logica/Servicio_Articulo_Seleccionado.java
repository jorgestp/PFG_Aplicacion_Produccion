package uned.pfg.logica;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import uned.pfg.bean.Articulo;
import uned.pfg.ws.WS_ArtSeleccionado;
import uned.pfg.ws.WS_ArtSeleccionadoProxy;

/**
 * Clase que consume el servicio web del servidor, de modo que, recoge el
 * articulo que ha sido seleccionado mediante su identificador
 * 
 * @author JORGE VILLALBA RUIZ 47536486V
 * @version 1.0
 */
public class Servicio_Articulo_Seleccionado {

	private static final String ARCHIVO = "XML_art_selec.xml";

	/**
	 * Constructor que llama al metodo privado encargado de consumir el servicio
	 * web, pasandole el parametro
	 * 
	 * @param id Identificador del articulo que estamos buscando
	 */
	public Servicio_Articulo_Seleccionado(int id) {

		cogerServicio(String.valueOf(id));
	}

	/**
	 * Funcion privada que se encarga de consumir el servicio web, pasandole el
	 * identificador del articulo que andamos buscando, y el resultado del web
	 * service se almacena en un archivo con extension XML
	 * 
	 * @param id String que representa el identificador del articulo que buscamos
	 */
	private void cogerServicio(String id) {

		WS_ArtSeleccionado ws = new WS_ArtSeleccionadoProxy(
				"http://localhost:8080/Aplicacion_Web/services/WS_ArtSeleccionado");

		try (FileWriter file = new FileWriter(ARCHIVO)) {
			PrintWriter p = new PrintWriter(file);
			p.print(ws.enviarArticuloSeleccionado(id));
			p.close();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	/**
	 * Funcion que se encarga de recorrer el archivo que ha sido escrito con la
	 * respuesta de Web Service, y parsea su contenido a un objeto de tipo Articulo
	 * para su manipulación
	 * 
	 * @return Objeto que representa al articulo que estamos buscando
	 */
	public Articulo parseXMLtoArticulo() {

		Articulo a = null;
		try {

			String[] aux;
			aux = new String[4];

			DocumentBuilderFactory fabricaCreadorDocumento = DocumentBuilderFactory.newInstance();
			DocumentBuilder creadorDocumento = fabricaCreadorDocumento.newDocumentBuilder();
			Document documento = creadorDocumento.parse(ARCHIVO);

			Element raiz = documento.getDocumentElement();

			// Obtener la lista de nodos que tienen etiqueta "reserva"
			NodeList listaEmpleados = raiz.getElementsByTagName("articulo");
			// Recorrer la lista de reserva

			for (int i = 0; i < listaEmpleados.getLength(); i++) {

				Node empleado = listaEmpleados.item(i);

				NodeList datosEmpleado = empleado.getChildNodes();

				for (int j = 0; j < datosEmpleado.getLength(); j++) {
					// Obtener de la lista de datos un dato tras otro
					Node dato = datosEmpleado.item(j);

					// Comprobar que el dato se trata de un nodo de tipo Element
					if (dato.getNodeType() == Node.ELEMENT_NODE) {

						Node datoContenido = dato.getFirstChild();
						// Mostrar el valor contenido en el nodo que debe ser de tipo Text
						if (datoContenido != null && datoContenido.getNodeType() == Node.TEXT_NODE)

							aux[j] = datoContenido.getNodeValue();
					}
				}

				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
				Date date_entrada = formatter.parse(aux[2]);
				a = new Articulo(Integer.parseInt(aux[0]), aux[1], date_entrada, Double.parseDouble(aux[3]));

			}

		} catch (Exception ex) {

			ex.printStackTrace();
		}
		File fichero = new File(ARCHIVO);
		fichero.delete();
		return a;
	}

}

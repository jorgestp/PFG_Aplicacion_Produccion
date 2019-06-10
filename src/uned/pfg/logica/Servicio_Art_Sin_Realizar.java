package uned.pfg.logica;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import uned.pfg.bean.Articulo;
import uned.pfg.bean.ArticuloPedido;
import uned.pfg.ws.WS_ArticulosSinRealizar;
import uned.pfg.ws.WS_ArticulosSinRealizarProxy;

/**
 * Clase que consume el servicio web del servidor, de modo que, recoge todos los
 * articulos que estan sin realizar de los pedidos que hay en el sistema.
 * 
 * 
 * @author JORGE VILLALBA RUIZ 47536486V
 * @version 1.0
 */
public class Servicio_Art_Sin_Realizar {

	private static final String ARCHIVO = "XML_art_sinRealizar.xml";

	/**
	 * Constructor por defecto que llama a metodo privado el cual consume el WS del
	 * servidor
	 */
	public Servicio_Art_Sin_Realizar() {
		cogerServicio();

	}

	/**
	 * Funcion que consume el servicio web del servidor, recogiendo todos los
	 * articulos que estan sin realizar de los pedidos que hay en el sistema, y su
	 * cantidad, escribiendolos en formato XML en un archivo
	 */
	private void cogerServicio() {

		WS_ArticulosSinRealizar ws = new WS_ArticulosSinRealizarProxy(
				"http://localhost:8080/Aplicacion_Web/services/WS_ArticulosSinRealizar");

		try (FileWriter file = new FileWriter(ARCHIVO)) {
			PrintWriter p = new PrintWriter(file);
			p.print(ws.enviarArticulosSinRealizar());
			p.close();
		} catch (Exception e) {

			// e.printStackTrace();
			JOptionPane.showMessageDialog(null,
					"No se puede " + "obtener los articulos de la base de datos." + " Compruebe su funcionamiento",
					"Ventas", 2);
		}

	}

	/**
	 * Funcion que se encarga de coger el archivo donde está los articulos y su
	 * cantidad sin realizar en formato XML y lo parsea a un objeto de tipo
	 * colección.
	 * 
	 * @return Lista de Articulos de los pedidos con su cantidad
	 */
	public List<ArticuloPedido> parseXMLtoList() {

		List<ArticuloPedido> lista = new ArrayList<ArticuloPedido>();
		try {

			String[] aux;
			aux = new String[2];

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

				ArticuloPedido artPed = new ArticuloPedido(new Articulo(Integer.parseInt(aux[0])),
						Integer.parseInt(aux[1]));

				lista.add(artPed);
			}

		} catch (Exception ex) {

			// ex.printStackTrace();
		}
		File fichero = new File(ARCHIVO);
		fichero.delete();
		return lista;
	}

}

package uned.pfg.main;

import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import uned.pfg.bean.Articulo;
import uned.pfg.bean.ArticuloPedido;
import uned.pfg.logica.ServicioArticulos;
import uned.pfg.logica.Servicio_Nueva_produccion;

/**
 * Clase que representa a la interfaz grafica para dar entrada a una nueva
 * produccion en el sistema
 *
 * @author JORGE VILLALBA RUIZ 47536486V
 * @version 1.0
 */
public class Gui_AltaProductos extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor por defecto
	 */
	public Gui_AltaProductos() {
		initComponents();
	}

	/**
	 * Funcion privada que se encarga de inicializar los componentes de la interfaz
	 * grafica y cargar los datos oportunos
	 */
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		infoSeleccion = new javax.swing.JLabel();
		seleccionID = new javax.swing.JComboBox<>();
		infoCantidad = new javax.swing.JLabel();
		cantidad = new javax.swing.JTextField();
		unidades = new javax.swing.JLabel();
		guardar = new javax.swing.JButton();
		borrar = new javax.swing.JButton();

		setTitle("PRODUCCIÓN - Nueva Producción");
		
		infoSeleccion.setText("SELECCIONE ARTICULO PARA DAR NUEVA PRODUCCION");

		seleccionID.setModel(new javax.swing.DefaultComboBoxModel<>(Articulos()));

		infoCantidad.setText("SELECCIONE CANTIDAD PRODUCIDA");

		unidades.setText("Unidad/es");

		guardar.setText("Guardar");
		guardar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				guardarActionPerformed(evt);
			}
		});

		borrar.setText("Borrar");
		borrar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				borrarActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(33, 33, 33).addGroup(jPanel1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup()
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel1Layout.createSequentialGroup()
												.addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 151,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(34, 34, 34).addComponent(borrar,
														javax.swing.GroupLayout.PREFERRED_SIZE, 144,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addComponent(seleccionID, javax.swing.GroupLayout.PREFERRED_SIZE, 320,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(jPanel1Layout.createSequentialGroup().addGap(63, 63, 63).addComponent(
												infoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 223,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(43, Short.MAX_VALUE))
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
								.addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 110,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addComponent(unidades, javax.swing.GroupLayout.PREFERRED_SIZE, 73,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(72, 72, 72))))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel1Layout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(infoSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 318,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(32, 32, 32)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(21, 21, 21).addComponent(infoSeleccion)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(seleccionID, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(37, 37, 37).addComponent(infoCantidad)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(unidades))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jPanel1,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jPanel1,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));

		pack();
	}// </editor-fold>

	/**
	 * Funcion que se encarga de enviar mediante la clase que consume el servicio
	 * web, los datos del tipo de producto y cantidad que se quiere dar de entrada
	 * en el almacen.
	 * 
	 * @param evt
	 */
	private void guardarActionPerformed(java.awt.event.ActionEvent evt) {

		String cant = cantidad.getText();

		if (isNumero(cant) && !seleccionID.getSelectedItem().toString().equals("Selec. Artículo")) {

			int num = Integer.parseInt(cant);

			if (num <= 0) {

				JOptionPane.showMessageDialog(null, "No se puede introducir cantidad 0 o menor a 0",
						"Produccion - Alta Produccion", 3);

			} else {

				ArticuloPedido artPed = new ArticuloPedido(buscaArticulo(seleccionID.getSelectedItem().toString()),
						Integer.parseInt(cant));

				Servicio_Nueva_produccion serv = new Servicio_Nueva_produccion(artPed);

				String respuesta = serv.cogerServicio();

				if (respuesta.equals("exito")) {

					JOptionPane.showMessageDialog(null, "Entrada a " + seleccionID.getSelectedItem().toString()
							+ " y cantidad " + cant + " con EXITO", "Produccion - Alta Produccion", 2);

				} else {

					JOptionPane.showMessageDialog(null, "No se pudo dar entrada a ese articulo y esa cantidad...",
							"Produccion - Alta Produccion", 3);
				}

			}

		} else {

			JOptionPane.showMessageDialog(null,
					"Introduce una cantidad numerica," + " o un articulo correcto por favor",
					"Produccion - Alta producto", 2);
		}

	}

	/**
	 * Funcion privada que comprueba si el valor pasado por parametro pertenece a un
	 * Entero
	 * 
	 * @param cant String que representa el valor a comprobar
	 * @return true, si el valor pasado por parametro es de tipo Entero, false en
	 *         caso contrario
	 */
	private boolean isNumero(String cant) {

		try {
			Integer.parseInt(cant);

			return true;

		} catch (Exception e) {
			return false;

		}

	}

	/**
	 * Funcion que vacía el campo de la cantidad a dar de alta
	 * 
	 * @param evt Evento que se desencadena al hacer click
	 */
	private void borrarActionPerformed(java.awt.event.ActionEvent evt) {

		cantidad.setText("");
	}

	/**
	 * Funcion privada que llama a la clase que consume el servicio web
	 * correspondiente y devuelve todos los articulos que hay en el sistema, de modo
	 * que se va rellenando la pestaña con esos articulos que han sido devueltos
	 * desde el servidor
	 * 
	 * @return Array de String que representa a los articulos que hay en el sistema
	 */
	private String[] Articulos() {

		ServicioArticulos servicioArt = new ServicioArticulos();

		listaArt = servicioArt.parseXMLtoList();
		Iterator<Articulo> it = listaArt.iterator();

		String[] articulos = new String[listaArt.size() + 1];
		articulos[0] = "Selec. Artículo";
		int i = 1;
		while (it.hasNext()) {

			Articulo a = it.next();
			articulos[i] = a.getNombre();
			i++;
		}

		return articulos;
	}

	/**
	 * Funcion que se encarga de buscar en la lista de articulos, el articulo cuyo
	 * nombre es pasado por parametro
	 * 
	 * @param nombre String que representa al nombre del articulo
	 * @return Objeto de tipo Articulo y que representa al que estamos buscando.
	 */
	private Articulo buscaArticulo(String nombre) {

		Articulo art = null;
		;
		Iterator<Articulo> it = listaArt.iterator();

		while (it.hasNext()) {

			Articulo a = it.next();

			if (a.getNombre().equals(nombre)) {

				art = a;

			}

		}

		return art;

	}

	// Variables declaration - do not modify
	private javax.swing.JButton borrar;
	private javax.swing.JTextField cantidad;
	private javax.swing.JButton guardar;
	private javax.swing.JLabel infoCantidad;
	private javax.swing.JLabel infoSeleccion;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JComboBox<String> seleccionID;
	private javax.swing.JLabel unidades;
	List<Articulo> listaArt;
	// End of variables declaration
}
package uned.pfg.main;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import uned.pfg.bean.Articulo;
import uned.pfg.bean.ArticuloPedido;
import uned.pfg.bean.Distribuidor;
import uned.pfg.bean.Pedido;


import uned.pfg.logica.Servicio_Art_Sin_Realizar;
import uned.pfg.logica.Servicio_Articulo_Seleccionado;
import uned.pfg.logica.Servicio_Distribuidor;
import uned.pfg.logica.Servicio_Pedidos_conArticulo;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;




/**
*
* @author Windows
*/
public class Gui_Produccion extends javax.swing.JFrame {

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/**
    * Creates new form Gui_Produccion
    */
   public Gui_Produccion() {
       initComponents();
   }

   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   
   // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
   private void initComponents() {

       jPanel1 = new javax.swing.JPanel();
       scroll = new javax.swing.JScrollPane();
       tabla = new javax.swing.JTable();
       actualizar = new javax.swing.JButton();
       consultaPedido = new javax.swing.JButton();
       altaArti = new javax.swing.JButton();
       infoArticulo = new javax.swing.JLabel();
       InfoNombreArt = new javax.swing.JLabel();
       infoCombo = new javax.swing.JLabel();
       comoIdPedido = new javax.swing.JComboBox<String>();

       nombreArti = new javax.swing.JTextField();
       infoDisti = new javax.swing.JLabel();
       infoNombreDistr = new javax.swing.JLabel();
       nombreDist = new javax.swing.JTextField();
       infoActivos = new javax.swing.JLabel();
       numPedidos = new javax.swing.JLabel();
       lista = new ArrayList<Pedido>();
       setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
       setTitle("VENTAS ");

       modelo = new DefaultTableModel(filas, columnas);
       tabla.setModel(modelo);
       scroll.setViewportView(tabla);
       DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
       centerRenderer.setHorizontalAlignment( JLabel.CENTER );
       tabla.setDefaultRenderer(String.class, centerRenderer);
       
       rellenarTabla();

       tabla.addMouseListener(new java.awt.event.MouseAdapter() {
           public void mouseClicked(java.awt.event.MouseEvent evt) {
               tablaMouseClicked(evt);
           }
       });
      

       actualizar.setText("Actualizar tabla");
       actualizar.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               actualizarActionPerformed(evt);
           }
       });
       
       comoIdPedido.addActionListener(new ActionListener() {
          	public void actionPerformed(ActionEvent arg0) {
          		String id_pedido = comoIdPedido.getSelectedItem().toString();
          		
          		Iterator<Pedido> it = lista.iterator();
          		
          		while(it.hasNext()) {
          			Pedido p = it.next();
          			if(p.getId_pedido() == Integer.parseInt(id_pedido)) {
          				
          				buscaDistribuidor(p.getId_distribuidor());
          			}
          		}
          	}


          });

       javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
       jPanel1.setLayout(jPanel1Layout);
       jPanel1Layout.setHorizontalGroup(
           jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(jPanel1Layout.createSequentialGroup()
               .addContainerGap()
               .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                   .addGroup(jPanel1Layout.createSequentialGroup()
                       .addComponent(actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addGap(0, 0, Short.MAX_VALUE))
                   .addComponent(scroll))
               .addContainerGap())
       );
       jPanel1Layout.setVerticalGroup(
           jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(jPanel1Layout.createSequentialGroup()
               .addContainerGap()
               .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
               .addComponent(actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addContainerGap())
       );

       consultaPedido.setText("Consultar Pedidos");
       consultaPedido.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               consultaPedidoActionPerformed(evt);
           }
       });

       altaArti.setText("Alta Articulo Fabricado");
       altaArti.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               altaArtiActionPerformed(evt);
           }
       });

       infoArticulo.setText("ARTICULO SELECCIONADO");

       InfoNombreArt.setText("NOMBRE");

       infoCombo.setText("PEDIDOS CON ESTE ARTICULO");


       infoDisti.setText("INFORMACION DEL PEDIDO");

       infoNombreDistr.setText("DISTRIBUIDOR");

       infoActivos.setText("PEDIDOS ACTIVOS");

       numPedidos.setText(" ");

       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
       layout.setHorizontalGroup(
       	layout.createParallelGroup(Alignment.LEADING)
       		.addGroup(layout.createSequentialGroup()
       			.addContainerGap()
       			.addGroup(layout.createParallelGroup(Alignment.LEADING)
       				.addComponent(jPanel1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 799, Short.MAX_VALUE)
       				.addGroup(layout.createSequentialGroup()
       					.addGap(12)
       					.addGroup(layout.createParallelGroup(Alignment.LEADING)
       						.addComponent(comoIdPedido, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
       						.addGroup(layout.createSequentialGroup()
       							.addGroup(layout.createParallelGroup(Alignment.LEADING)
       								.addComponent(InfoNombreArt, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
       								.addComponent(infoCombo, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
       								.addComponent(infoArticulo, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
       							.addGap(28)
       							.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
       								.addComponent(infoNombreDistr, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
       								.addComponent(infoActivos, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
       							.addPreferredGap(ComponentPlacement.UNRELATED)
       							.addGroup(layout.createParallelGroup(Alignment.LEADING)
       								.addComponent(numPedidos, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
       								.addComponent(nombreDist, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)))
       						.addComponent(nombreArti, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
       					.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
       					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
       						.addComponent(altaArti, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
       						.addComponent(consultaPedido, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE))
       					.addContainerGap())))
       		.addGroup(layout.createSequentialGroup()
       			.addGap(355)
       			.addComponent(infoDisti, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
       			.addContainerGap(266, Short.MAX_VALUE))
       );
       layout.setVerticalGroup(
       	layout.createParallelGroup(Alignment.LEADING)
       		.addGroup(layout.createSequentialGroup()
       			.addContainerGap()
       			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
       			.addPreferredGap(ComponentPlacement.RELATED)
       			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
       				.addComponent(infoDisti)
       				.addComponent(infoArticulo))
       			.addGroup(layout.createParallelGroup(Alignment.LEADING)
       				.addGroup(layout.createSequentialGroup()
       					.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
       					.addComponent(consultaPedido, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
       					.addPreferredGap(ComponentPlacement.RELATED))
       				.addGroup(layout.createSequentialGroup()
       					.addPreferredGap(ComponentPlacement.UNRELATED)
       					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
       						.addComponent(infoNombreDistr)
       						.addComponent(nombreDist, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
       						.addComponent(InfoNombreArt))
       					.addPreferredGap(ComponentPlacement.RELATED)
       					.addComponent(nombreArti, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
       					.addGap(6)))
       			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
       				.addGroup(layout.createSequentialGroup()
       					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
       						.addComponent(infoActivos)
       						.addComponent(numPedidos))
       					.addGap(13))
       				.addGroup(layout.createSequentialGroup()
       					.addComponent(infoCombo)
       					.addPreferredGap(ComponentPlacement.RELATED)))
       			.addGroup(layout.createParallelGroup(Alignment.LEADING)
       				.addComponent(altaArti, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
       				.addComponent(comoIdPedido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
       );
       getContentPane().setLayout(layout);

       pack();
   }// </editor-fold>                        

   private void rellenarTabla() {
	
  
	   Servicio_Art_Sin_Realizar articulos_Pedido = new Servicio_Art_Sin_Realizar();
	   List<ArticuloPedido> list = articulos_Pedido.parseXMLtoList();
	   Iterator<ArticuloPedido> it  =list.iterator();
	   
	   while(it.hasNext()) {
		   
		   ArticuloPedido artP = it.next();
		   
           Object [] row = {artP.getArticulo().getId_articulo(), artP.getCant()};
           
           modelo.addRow(row);
	   }
	
}

private void tablaMouseClicked(java.awt.event.MouseEvent evt) {                                   
       
	int num = tabla.rowAtPoint(evt.getPoint());
	int id_art = (int) tabla.getValueAt(num, 0);
	
	Servicio_Articulo_Seleccionado serv = new Servicio_Articulo_Seleccionado(id_art);
	
	Articulo art = serv.parseXMLtoArticulo();
	
	nombreArti.setText(art.getNombre());
	
	//hay que poner los id_pedidos que tienen ese articulo
	
    comoIdPedido.setModel(new javax.swing.DefaultComboBoxModel<String>(pedidosPorId(id_art)));

	
   }                                  

   private String[] pedidosPorId(int id_art) {
	
	   Servicio_Pedidos_conArticulo servicio = new Servicio_Pedidos_conArticulo(id_art);
	   lista = servicio.parseXMLtoList();
	   
	   String[] pedidos = new String[lista.size()+1];
	   
	   Iterator<Pedido> it = lista.iterator();
	   pedidos[0] = "--Pedidos encontrados--";
	   int i =1;
	   while(it.hasNext()) {
		   
		   Pedido p = it.next();
		   pedidos[i] = String.valueOf(p.getId_pedido());
		   i++;
	   }
	   
	   
	   
	return pedidos;
	    
	   
	
}

private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {                                           
       
	   modelo.setRowCount(0);
	   rellenarTabla();
   }                                          

   private void consultaPedidoActionPerformed(java.awt.event.ActionEvent evt) {                                               
      
	   new Gui_Pedido().setVisible(true);
   }                                              

   private void altaArtiActionPerformed(java.awt.event.ActionEvent evt) {                                         
       // TODO add your handling code here:
   }                           
   
   
	private void buscaDistribuidor(int id_distribuidor) {
		
			Servicio_Distribuidor serv = new Servicio_Distribuidor(id_distribuidor);
			
			nombreDist.setText(serv.parseXMLtoList().getNombre());
		
		
	}

 

   // Variables declaration - do not modify                     
   private javax.swing.JLabel InfoNombreArt;
   private javax.swing.JButton actualizar;
   private javax.swing.JButton altaArti;
   private javax.swing.JComboBox<String> comoIdPedido;
   private javax.swing.JButton consultaPedido;
   private javax.swing.JLabel infoActivos;
   private javax.swing.JLabel infoArticulo;
   private javax.swing.JLabel infoCombo;
   private javax.swing.JLabel infoDisti;
   private javax.swing.JLabel infoNombreDistr;
   private javax.swing.JPanel jPanel1;
   private javax.swing.JTextField nombreArti;
   private javax.swing.JTextField nombreDist;
   private javax.swing.JLabel numPedidos;
   private javax.swing.JScrollPane scroll;
   private javax.swing.JTable tabla;
   private Object [][]filas;
   private Object [] columnas = {"ID ARTICULO","CANTIDAD A REALIZAR"};
   private DefaultTableModel modelo; 
   List<Pedido>lista;
   // End of variables declaration                   
}
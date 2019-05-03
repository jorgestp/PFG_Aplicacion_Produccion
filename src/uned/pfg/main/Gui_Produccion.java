package uned.pfg.main;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

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
   @SuppressWarnings("unchecked")
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
       comoIdDistri = new javax.swing.JComboBox<>();
       nombreArti = new javax.swing.JTextField();
       infoDisti = new javax.swing.JLabel();
       infoNombreDistr = new javax.swing.JLabel();
       nombreDist = new javax.swing.JTextField();
       infoActivos = new javax.swing.JLabel();
       numPedidos = new javax.swing.JLabel();

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

       comoIdDistri.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID Pedido", "1", "2", "3" }));

       infoDisti.setText("INFORMACION DEL PEDIDO");

       infoNombreDistr.setText("DISTRIBUIDOR");

       infoActivos.setText("PEDIDOS ACTIVOS");

       numPedidos.setText(" ");

       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
       getContentPane().setLayout(layout);
       layout.setHorizontalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addContainerGap()
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                   .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                   .addGroup(layout.createSequentialGroup()
                       .addGap(12, 12, 12)
                       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                           .addComponent(comoIdDistri, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                           .addGroup(layout.createSequentialGroup()
                               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addGroup(layout.createSequentialGroup()
                                       .addComponent(InfoNombreArt, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                       .addComponent(nombreArti, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                   .addComponent(infoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                               .addGap(18, 18, 18)
                               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                   .addComponent(infoNombreDistr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                   .addComponent(infoActivos, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
                               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addComponent(numPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(nombreDist, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                           .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                               .addGap(0, 0, Short.MAX_VALUE)
                               .addComponent(altaArti, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                           .addGroup(layout.createSequentialGroup()
                               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                               .addComponent(consultaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                       .addContainerGap())))
           .addGroup(layout.createSequentialGroup()
               .addGap(73, 73, 73)
               .addComponent(infoArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGap(64, 64, 64)
               .addComponent(infoDisti, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGap(0, 0, Short.MAX_VALUE))
       );
       layout.setVerticalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addContainerGap()
               .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                   .addComponent(infoArticulo)
                   .addComponent(infoDisti))
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                   .addGroup(layout.createSequentialGroup()
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                       .addComponent(consultaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                   .addGroup(layout.createSequentialGroup()
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                           .addComponent(InfoNombreArt)
                           .addComponent(nombreArti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                           .addComponent(infoNombreDistr)
                           .addComponent(nombreDist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                   .addComponent(infoCombo)
                   .addComponent(infoActivos)
                   .addComponent(numPedidos))
               .addGap(13, 13, 13)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                   .addComponent(altaArti, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                   .addComponent(comoIdDistri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
       );

       pack();
   }// </editor-fold>                        

   private void rellenarTabla() {
	// TODO Auto-generated method stub
	
}

private void tablaMouseClicked(java.awt.event.MouseEvent evt) {                                   
       // TODO add your handling code here:
   }                                  

   private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {                                           
       // TODO add your handling code here:
   }                                          

   private void consultaPedidoActionPerformed(java.awt.event.ActionEvent evt) {                                               
       // TODO add your handling code here:
   }                                              

   private void altaArtiActionPerformed(java.awt.event.ActionEvent evt) {                                         
       // TODO add your handling code here:
   }                                        

 

   // Variables declaration - do not modify                     
   private javax.swing.JLabel InfoNombreArt;
   private javax.swing.JButton actualizar;
   private javax.swing.JButton altaArti;
   private javax.swing.JComboBox<String> comoIdDistri;
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
   // End of variables declaration                   
}
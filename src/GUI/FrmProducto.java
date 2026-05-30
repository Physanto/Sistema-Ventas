/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 *
 * @author mamia
 */
public class FrmProducto extends javax.swing.JFrame {
  JLabel titulo, lblLista;

    JLabel lblId, lblNombre, lblStock;
    JLabel lblPrecio, lblMinimo;
    JLabel lblFecha, lblUbicacion;

    JTextField txtId, txtNombre, txtStock;
    JTextField txtPrecio, txtMinimo;
    JTextField txtFecha, txtUbicacion;

    JButton btnAgregar, btnActualizar, btnEliminar;
    JButton btnBuscar, btnListar;

    JTable tablaProductos;
    JScrollPane scrollTabla;


    public FrmProducto() {
        initComponents();
  setTitle("GESTIÓN DE PRODUCTOS");
        setSize(1000, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        getContentPane().setBackground(new Color(25,25,40));

        titulo = new JLabel("GESTIÓN DE PRODUCTOS");
        titulo.setBounds(280,20,450,40);
        titulo.setFont(new Font("Arial", Font.BOLD, 28));
        titulo.setForeground(new Color(0,255,200));

        add(titulo);

        lblId = new JLabel("ID Producto:");
        lblNombre = new JLabel("Nombre:");
        lblStock = new JLabel("Stock Actual:");
        lblPrecio = new JLabel("Precio Venta:");
        lblMinimo = new JLabel("Stock Mínimo:");
        lblFecha = new JLabel("Fecha Vencimiento:");
        lblUbicacion = new JLabel("Ubicación:");

        JLabel[] labels = {
                lblId,lblNombre,lblStock,
                lblPrecio,lblMinimo,
                lblFecha,lblUbicacion
        };

        for(JLabel lbl : labels){

            lbl.setForeground(Color.WHITE);
            lbl.setFont(new Font("Segoe UI", Font.BOLD, 14));

            add(lbl);
        }

        txtId = new JTextField();
        txtNombre = new JTextField();
        txtStock = new JTextField();
        txtPrecio = new JTextField();
        txtMinimo = new JTextField();
        txtFecha = new JTextField();
        txtUbicacion = new JTextField();

        JTextField[] campos = {
                txtId,txtNombre,txtStock,
                txtPrecio,txtMinimo,
                txtFecha,txtUbicacion
        };

        for(JTextField txt : campos){

            txt.setBackground(new Color(40,40,60));
            txt.setForeground(Color.WHITE);
            txt.setCaretColor(Color.WHITE);

            txt.setBorder(
                    BorderFactory.createLineBorder(
                            new Color(0,255,200),2));

            add(txt);
        }

        lblId.setBounds(50,100,150,25);
        txtId.setBounds(220,100,220,30);

        lblNombre.setBounds(50,150,150,25);
        txtNombre.setBounds(220,150,220,30);

        lblStock.setBounds(50,200,150,25);
        txtStock.setBounds(220,200,220,30);

        lblPrecio.setBounds(50,250,150,25);
        txtPrecio.setBounds(220,250,220,30);

        lblMinimo.setBounds(50,300,150,25);
        txtMinimo.setBounds(220,300,220,30);

        lblFecha.setBounds(50,350,150,25);
        txtFecha.setBounds(220,350,220,30);

        lblUbicacion.setBounds(50,400,150,25);
        txtUbicacion.setBounds(220,400,220,30);

        btnAgregar = new JButton("Agregar");
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");
        btnBuscar = new JButton("Buscar");
        btnListar = new JButton("Listar");

        btnAgregar.setBackground(new Color(0,180,120));
        btnActualizar.setBackground(new Color(0,120,255));
        btnEliminar.setBackground(new Color(220,50,50));
        btnBuscar.setBackground(new Color(255,140,0));
        btnListar.setBackground(new Color(128,0,255));

        JButton[] botones = {
                btnAgregar,
                btnActualizar,
                btnEliminar,
                btnBuscar,
                btnListar
        };

        for(JButton btn : botones){

            btn.setForeground(Color.WHITE);
            btn.setFocusPainted(false);
            btn.setFont(new Font("Segoe UI",Font.BOLD,14));

            add(btn);
        }

        btnAgregar.setBounds(50,500,120,40);
        btnActualizar.setBounds(190,500,120,40);
        btnEliminar.setBounds(330,500,120,40);
        btnBuscar.setBounds(470,500,120,40);
        btnListar.setBounds(610,500,120,40);

        lblLista = new JLabel("LISTA DE PRODUCTOS");
        lblLista.setBounds(330,560,350,30);
        lblLista.setForeground(new Color(128,0,255));
        lblLista.setFont(new Font("Arial",Font.BOLD,22));

        add(lblLista);

        tablaProductos = new JTable();

        tablaProductos.setModel(
                new DefaultTableModel(
                        new Object[][]{},
                        new String[]{
                                "ID",
                                "Nombre",
                                "Stock",
                                "Precio",
                                "Stock Mínimo",
                                "Vencimiento",
                                "Ubicación"
                        }
                )
        );

        tablaProductos.setBackground(new Color(35,35,55));
        tablaProductos.setForeground(Color.WHITE);

        tablaProductos.setGridColor(
                new Color(0,255,200));

        tablaProductos.setSelectionBackground(
                new Color(0,255,200));

        tablaProductos.setSelectionForeground(
                Color.BLACK);

        tablaProductos.setRowHeight(28);

        tablaProductos.getTableHeader().setBackground(
                new Color(0,255,200));

        tablaProductos.getTableHeader().setForeground(
                Color.BLACK);

        tablaProductos.getTableHeader().setFont(
                new Font("Segoe UI",Font.BOLD,14));

        scrollTabla = new JScrollPane(tablaProductos);

        scrollTabla.setBounds(20,600,940,140);

        scrollTabla.setBorder(
                BorderFactory.createLineBorder(
                        new Color(0,255,200),3));

        add(scrollTabla);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
           FrmProducto formularioP = new FrmProducto();
        formularioP.setVisible(true);
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

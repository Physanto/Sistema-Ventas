/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author mamia
 */
public class FrmProducto extends javax.swing.JFrame {

    JLabel titulo;
    JLabel lblId, lblNombre, lblStock, lblPrecio;
    JLabel lblMinimo, lblFecha, lblUbicacion, lblCategoria;

    JTextField txtId, txtNombre, txtStock, txtPrecio;
    JTextField txtMinimo, txtFecha, txtUbicacion, txtCategoria;

    JButton btnAgregar, btnActualizar, btnEliminar;

    public FrmProducto() {
        initComponents();
         setTitle("CRUD PRODUCTOS");
        setSize(500, 620);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        // COLOR DE FONDO
        getContentPane().setBackground(new Color(25, 25, 40));

        // TITULO
        titulo = new JLabel("GESTIÓN DE PRODUCTOS");
        titulo.setBounds(70, 20, 350, 40);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(new Color(0, 255, 200));

        // LABELS
        lblId = new JLabel("ID Producto:");
        lblNombre = new JLabel("Nombre:");
        lblStock = new JLabel("Stock Actual:");
        lblPrecio = new JLabel("Precio Venta:");
        lblMinimo = new JLabel("Stock Mínimo:");
        lblFecha = new JLabel("Fecha Vencimiento:");
        lblUbicacion = new JLabel("Ubicación:");
        lblCategoria = new JLabel("ID Categoría:");

        JLabel[] labels = {
            lblId, lblNombre, lblStock, lblPrecio,
            lblMinimo, lblFecha, lblUbicacion, lblCategoria
        };

        for (JLabel lbl : labels) {

            lbl.setForeground(Color.WHITE);
            lbl.setFont(new Font("Segoe UI", Font.BOLD, 14));

        }

        // TEXTFIELDS
        txtId = new JTextField();
        txtNombre = new JTextField();
        txtStock = new JTextField();
        txtPrecio = new JTextField();
        txtMinimo = new JTextField();
        txtFecha = new JTextField();
        txtUbicacion = new JTextField();
        txtCategoria = new JTextField();

        JTextField[] campos = {
            txtId, txtNombre, txtStock, txtPrecio,
            txtMinimo, txtFecha, txtUbicacion, txtCategoria
        };

        for (JTextField txt : campos) {

            txt.setBackground(new Color(40, 40, 60));
            txt.setForeground(Color.WHITE);
            txt.setCaretColor(Color.WHITE);

            txt.setBorder(
                    BorderFactory.createLineBorder(
                            new Color(0, 255, 200), 2));

            txt.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        }

        // BOTONES
        btnAgregar = new JButton("Agregar");
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");

        JButton[] botones = {
            btnAgregar, btnActualizar, btnEliminar
        };

        for (JButton btn : botones) {

            btn.setFocusPainted(false);
            btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
            btn.setForeground(Color.WHITE);
            btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        }

        btnAgregar.setBackground(new Color(0, 180, 120));
        btnActualizar.setBackground(new Color(0, 120, 255));
        btnEliminar.setBackground(new Color(220, 50, 50));

        // POSICIONES

        lblId.setBounds(40, 90, 150, 25);
        txtId.setBounds(220, 90, 200, 30);

        lblNombre.setBounds(40, 140, 150, 25);
        txtNombre.setBounds(220, 140, 200, 30);

        lblStock.setBounds(40, 190, 150, 25);
        txtStock.setBounds(220, 190, 200, 30);

        lblPrecio.setBounds(40, 240, 150, 25);
        txtPrecio.setBounds(220, 240, 200, 30);

        lblMinimo.setBounds(40, 290, 150, 25);
        txtMinimo.setBounds(220, 290, 200, 30);

        lblFecha.setBounds(40, 340, 150, 25);
        txtFecha.setBounds(220, 340, 200, 30);

        lblUbicacion.setBounds(40, 390, 150, 25);
        txtUbicacion.setBounds(220, 390, 200, 30);

        lblCategoria.setBounds(40, 440, 150, 25);
        txtCategoria.setBounds(220, 440, 200, 30);

        btnAgregar.setBounds(30, 520, 120, 40);
        btnActualizar.setBounds(180, 520, 120, 40);
        btnEliminar.setBounds(330, 520, 120, 40);

        // AGREGAR COMPONENTES

        add(titulo);

        add(lblId);
        add(txtId);

        add(lblNombre);
        add(txtNombre);

        add(lblStock);
        add(txtStock);

        add(lblPrecio);
        add(txtPrecio);

        add(lblMinimo);
        add(txtMinimo);

        add(lblFecha);
        add(txtFecha);

        add(lblUbicacion);
        add(txtUbicacion);

        add(lblCategoria);
        add(txtCategoria);

        add(btnAgregar);
        add(btnActualizar);
        add(btnEliminar);
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

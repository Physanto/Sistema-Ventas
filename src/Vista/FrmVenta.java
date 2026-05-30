/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

/**
 *
 * @author mamia
 */


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import Modelo.Cliente;
import Modelo.Producto;

public class FrmVenta extends javax.swing.JFrame {

    JLabel titulo, lblLista, lblDetalle;
    JLabel lblFecha, lblTotal, lblMetodo, lblCliente;
    JLabel lblProducto, lblCantidad;

    JTextField txtFecha, txtTotal, txtMetodo, txtCantidad;
    JComboBox<Cliente> cmbCliente;
    JComboBox<Producto> cmbProducto;

    JButton btnAgregar, btnEliminar, btnListar, btnLimpiar;
    JButton btnAgregarDetalle, btnEliminarDetalle;

    JTable tablaVentas, tablaDetalles;
    JScrollPane scrollVentas, scrollDetalles;

    public FrmVenta() {
        initComponents();
        setTitle("GESTIÓN DE VENTAS");
        setSize(1000, 900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        getContentPane().setBackground(new Color(25, 25, 40));

        // TÍTULO
        titulo = new JLabel("GESTIÓN DE VENTAS");
        titulo.setBounds(300, 15, 400, 40);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 28));
        titulo.setForeground(new Color(0, 255, 200));
        add(titulo);

        // LABELS VENTA
        lblFecha   = new JLabel("Fecha (AAAA-MM-DD):");
        lblTotal   = new JLabel("Total Venta:");
        lblMetodo  = new JLabel("Método Pago:");
        lblCliente = new JLabel("Cliente:");

        JLabel[] labels = {lblFecha, lblTotal, lblMetodo, lblCliente};
        for (JLabel lbl : labels) {
            lbl.setForeground(Color.WHITE);
            lbl.setFont(new Font("Segoe UI", Font.BOLD, 14));
            add(lbl);
        }

        // CAMPOS VENTA
        txtFecha  = new JTextField();
        txtTotal  = new JTextField();
        txtMetodo = new JTextField();
        cmbCliente = new JComboBox<>();

        JTextField[] campos = {txtFecha, txtTotal, txtMetodo};
        for (JTextField txt : campos) {
            txt.setBackground(new Color(40, 40, 60));
            txt.setForeground(Color.WHITE);
            txt.setCaretColor(Color.WHITE);
            txt.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 200), 2));
            add(txt);
        }

        lblFecha.setBounds(280, 70, 200, 25);
        txtFecha.setBounds(490, 70, 180, 30);

        lblTotal.setBounds(280, 110, 200, 25);
        txtTotal.setBounds(490, 110, 180, 30);

        lblMetodo.setBounds(280, 150, 200, 25);
        txtMetodo.setBounds(490, 150, 180, 30);

        lblCliente.setBounds(280, 190, 200, 25);
        cmbCliente.setBackground(new Color(40, 40, 60));
        cmbCliente.setForeground(Color.WHITE);
        cmbCliente.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        cmbCliente.setBounds(490, 190, 180, 30);
        add(cmbCliente);

        // BOTONES VENTA
        btnAgregar  = new JButton("Agregar Venta");
        btnEliminar = new JButton("Eliminar");
        btnListar   = new JButton("Listar");
        btnLimpiar  = new JButton("Limpiar");

        btnAgregar.setBackground(new Color(0, 180, 120));
        btnEliminar.setBackground(new Color(220, 50, 50));
        btnListar.setBackground(new Color(128, 0, 255));
        btnLimpiar.setBackground(new Color(120, 120, 120));

        JButton[] botones = {btnAgregar, btnEliminar, btnListar, btnLimpiar};
        for (JButton btn : botones) {
            btn.setForeground(Color.WHITE);
            btn.setFocusPainted(false);
            btn.setFont(new Font("Segoe UI", Font.BOLD, 13));
            add(btn);
        }

        // BOTONES VENTA CENTRADOS
        btnAgregar.setBounds(232, 240, 140, 38);
        btnEliminar.setBounds(387, 240, 120, 38);
        btnListar.setBounds(522, 240, 120, 38);
        btnLimpiar.setBounds(657, 240, 120, 38);


        // TABLA VENTAS
        // TABLA VENTAS - TÍTULO CENTRADO
        lblLista = new JLabel("LISTA DE VENTAS");
        lblLista.setBounds(350, 288, 300, 25);
        lblLista.setHorizontalAlignment(SwingConstants.CENTER); 
        lblLista.setForeground(new Color(128, 0, 255));
        lblLista.setFont(new Font("Arial", Font.BOLD, 18));
        add(lblLista);


        tablaVentas = new JTable();
        tablaVentas.setModel(new DefaultTableModel(
            new Object[][]{},
            new String[]{"ID", "Fecha", "Total", "Método Pago", "ID Cliente"}
        ));
        estilizarTabla(tablaVentas);

        scrollVentas = new JScrollPane(tablaVentas);
        scrollVentas.setBounds(20, 318, 955, 140);
        scrollVentas.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 200), 2));
        add(scrollVentas);

        // SECCIÓN DETALLE
        // SECCIÓN DETALLE - TÍTULO CENTRADO
        JLabel separador = new JLabel("DETALLE DE LA VENTA SELECCIONADA");
        separador.setBounds(200, 468, 600, 25);
        separador.setHorizontalAlignment(SwingConstants.CENTER); 
        separador.setForeground(new Color(0, 255, 200));
        separador.setFont(new Font("Segoe UI", Font.BOLD, 14));
        add(separador);


        lblProducto  = new JLabel("Producto:");
        lblCantidad  = new JLabel("Cantidad:");
        lblProducto.setForeground(Color.WHITE);
        lblCantidad.setForeground(Color.WHITE);
        lblProducto.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblCantidad.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblProducto.setBounds(100, 505, 120, 25);
        lblCantidad.setBounds(480, 505, 100, 25);
        add(lblProducto);
        add(lblCantidad);

        cmbProducto = new JComboBox<>();
        cmbProducto.setBackground(new Color(40, 40, 60));
        cmbProducto.setForeground(Color.WHITE);
        cmbProducto.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        cmbProducto.setBounds(220, 503, 220, 30);
        add(cmbProducto);

        txtCantidad = new JTextField();
        txtCantidad.setBackground(new Color(40, 40, 60));
        txtCantidad.setForeground(Color.WHITE);
        txtCantidad.setCaretColor(Color.WHITE);
        txtCantidad.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 200), 2));
        txtCantidad.setBounds(580, 503, 100, 30);
        add(txtCantidad);

        btnAgregarDetalle  = new JButton("+ Agregar");
        btnEliminarDetalle = new JButton("- Eliminar");
        btnAgregarDetalle.setBackground(new Color(0, 180, 120));
        btnEliminarDetalle.setBackground(new Color(220, 50, 50));

        JButton[] botonesDetalle = {btnAgregarDetalle, btnEliminarDetalle};
        for (JButton btn : botonesDetalle) {
            btn.setForeground(Color.WHITE);
            btn.setFocusPainted(false);
            btn.setFont(new Font("Segoe UI", Font.BOLD, 13));
            add(btn);
        }

        btnAgregarDetalle.setBounds(700, 500, 110, 35);
        btnEliminarDetalle.setBounds(820, 500, 110, 35);

        // TABLA DETALLES
        // TABLA DETALLES - TÍTULO CENTRADO
        lblDetalle = new JLabel("PRODUCTOS EN ESTA VENTA");
        lblDetalle.setBounds(300, 545, 400, 25);
        lblDetalle.setHorizontalAlignment(SwingConstants.CENTER); 
        lblDetalle.setForeground(new Color(0, 255, 200));
        lblDetalle.setFont(new Font("Arial", Font.BOLD, 16));
        add(lblDetalle);


        tablaDetalles = new JTable();
        tablaDetalles.setModel(new DefaultTableModel(
            new Object[][]{},
            new String[]{"ID Detalle", "Producto", "Cantidad", "Precio Venta"}
        ));
        estilizarTabla(tablaDetalles);

        scrollDetalles = new JScrollPane(tablaDetalles);
        scrollDetalles.setBounds(20, 575, 955, 270);
        scrollDetalles.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 200), 2));
        add(scrollDetalles);
    }

    private void estilizarTabla(JTable tabla) {
        tabla.setBackground(new Color(35, 35, 55));
        tabla.setForeground(Color.WHITE);
        tabla.setGridColor(new Color(0, 255, 200));
        tabla.setSelectionBackground(new Color(0, 255, 200));
        tabla.setSelectionForeground(Color.BLACK);
        tabla.setRowHeight(26);
        tabla.getTableHeader().setBackground(new Color(0, 255, 200));
        tabla.getTableHeader().setForeground(Color.BLACK);
        tabla.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
    }

    public void limpiarCampos() {
        txtFecha.setText("");
        txtTotal.setText("");
        txtMetodo.setText("");
        txtCantidad.setText("");
        if (cmbCliente.getItemCount() > 0)  cmbCliente.setSelectedIndex(0);
        if (cmbProducto.getItemCount() > 0) cmbProducto.setSelectedIndex(0);
    }

    // Getters
    public JTextField getTxtFecha()    { return txtFecha; }
    public JTextField getTxtTotal()    { return txtTotal; }
    public JTextField getTxtMetodo()   { return txtMetodo; }
    public JTextField getTxtCantidad() { return txtCantidad; }
    public JComboBox<Cliente>  getCmbCliente()  { return cmbCliente; }
    public JComboBox<Producto> getCmbProducto() { return cmbProducto; }
    public JTable getTablaVentas()     { return tablaVentas; }
    public JTable getTablaDetalles()   { return tablaDetalles; }
    public JButton getBtnAgregar()     { return btnAgregar; }
    public JButton getBtnEliminar()    { return btnEliminar; }
    public JButton getBtnListar()      { return btnListar; }
    public JButton getBtnLimpiar()     { return btnLimpiar; }
    public JButton getBtnAgregarDetalle()  { return btnAgregarDetalle; }
    public JButton getBtnEliminarDetalle() { return btnEliminarDetalle; }


   

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
        java.awt.EventQueue.invokeLater(() -> {
            new FrmVenta().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import Modelo.Categoria;
import Controlador.ControladorProducto;
/**
 *
 * @author mamia
 */
public class FrmProducto extends javax.swing.JFrame {
  JLabel titulo, lblLista;

    JLabel lblNombre, lblStock;
    JLabel lblPrecio, lblMinimo;
    JLabel lblFecha, lblUbicacion, lblCategoria;
    
    JComboBox<Categoria> cmbCategoria;

    JTextField txtNombre, txtStock;
    JTextField txtPrecio, txtMinimo;
    JTextField txtFecha, txtUbicacion;

    JButton btnAgregar, btnActualizar, btnEliminar;
    JButton btnListar, btnLimpiar;

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
        titulo.setBounds(300, 20, 400, 40);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 28));
        titulo.setForeground(new Color(0,255,200));

        add(titulo);

        
        lblNombre = new JLabel("Nombre:");
        lblStock = new JLabel("Stock Actual:");
        lblPrecio = new JLabel("Precio Venta:");
        lblMinimo = new JLabel("Stock Mínimo:");
        lblFecha = new JLabel("Fecha Vencimiento:");
        lblUbicacion = new JLabel("Ubicación:");
        lblCategoria = new JLabel("Categoría:");

        JLabel[] labels = {
            lblNombre,
            lblStock,
            lblPrecio,
            lblMinimo,
            lblFecha,
            lblUbicacion,
            lblCategoria
        };

        for(JLabel lbl : labels){

            lbl.setForeground(Color.WHITE);
            lbl.setFont(new Font("Segoe UI", Font.BOLD, 14));

            add(lbl);
        }

        
        txtNombre = new JTextField();
        txtStock = new JTextField();
        txtPrecio = new JTextField();
        txtMinimo = new JTextField();
        txtFecha = new JTextField();
        txtUbicacion = new JTextField();
        cmbCategoria = new JComboBox<>();

        JTextField[] campos = {
                txtNombre,txtStock,
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

        

        

        lblNombre.setBounds(300, 150, 150, 25);
        txtNombre.setBounds(470, 150, 220, 30);

        lblStock.setBounds(300, 200, 150, 25);
        txtStock.setBounds(470, 200, 220, 30);

        lblPrecio.setBounds(300, 250, 150, 25);
        txtPrecio.setBounds(470, 250, 220, 30);

        lblMinimo.setBounds(300, 300, 150, 25);
        txtMinimo.setBounds(470, 300, 220, 30);

        lblFecha.setBounds(300, 350, 150, 25);
        txtFecha.setBounds(470, 350, 220, 30);

        lblUbicacion.setBounds(300, 400, 150, 25);
        txtUbicacion.setBounds(470, 400, 220, 30);
        
        lblCategoria = new JLabel("Categoría:");
        lblCategoria.setForeground(Color.WHITE);
        lblCategoria.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblCategoria.setBounds(300, 450, 150, 25); // Corregido a X=300
        add(lblCategoria);

        cmbCategoria = new JComboBox<>();
        cmbCategoria.setBackground(new Color(40,40,60));
        cmbCategoria.setForeground(Color.WHITE);
        cmbCategoria.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        cmbCategoria.setBounds(470, 450, 220, 30); // Corregido a X=470
        add(cmbCategoria);



        btnAgregar = new JButton("Agregar");
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");
        btnLimpiar = new JButton("Limpiar");
        btnListar = new JButton("Listar");

        btnAgregar.setBackground(new Color(0,180,120));
        btnActualizar.setBackground(new Color(0,120,255));
        btnEliminar.setBackground(new Color(220,50,50));
        btnLimpiar.setBackground(new Color(120,120,120));
        btnListar.setBackground(new Color(128,0,255));

        JButton[] botones = {
            btnAgregar,
            btnActualizar,
            btnEliminar,
            btnListar,
            btnLimpiar
        };

        for(JButton btn : botones){

            btn.setForeground(Color.WHITE);
            btn.setFocusPainted(false);
            btn.setFont(new Font("Segoe UI",Font.BOLD,14));

            add(btn);
        }

        
        btnAgregar.setBounds(160,550,120,40);
        btnActualizar.setBounds(300,550,120,40);
        btnEliminar.setBounds(440,550,120,40);
        btnListar.setBounds(580,550,120,40);
        btnLimpiar.setBounds(720,550,120,40);


        lblLista = new JLabel("LISTA DE PRODUCTOS");
        lblLista.setBounds(330,610,350,30);
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

        scrollTabla.setBounds(20,650,940,140);

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
        new ControladorProducto(formularioP);
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

    public void limpiarCampos(){

        txtNombre.setText("");
        txtStock.setText("");
        txtPrecio.setText("");
        txtMinimo.setText("");
        txtFecha.setText("");
        txtUbicacion.setText("");
        cmbCategoria.setSelectedIndex(0);

    }
    
    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public JButton getBtnListar() {
        return btnListar;
    }

    public JButton getBtnLimpiar() {
        return btnLimpiar;
    }
    
    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public JTextField getTxtStock() {
        return txtStock;
    }

    public JTextField getTxtPrecio() {
        return txtPrecio;
    }

    public JTextField getTxtMinimo() {
        return txtMinimo;
    }

    public JTextField getTxtFecha() {
        return txtFecha;
    }

    public JTextField getTxtUbicacion() {
        return txtUbicacion;
    }
    
    public JTable getTablaProductos() {
        return tablaProductos;
    }
    
    public JComboBox<Categoria> getCmbCategoria() {
        return cmbCategoria;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mamia
 */
public class FrmCliente extends javax.swing.JFrame {

    JLabel titulo, lblLista;

    JLabel lblId, lblEmail, lblNombre, lblApellido;
    JLabel lblFecha, lblCarrera, lblCalle, lblNumero, lblBarrio;

    JTextField txtId, txtEmail, txtNombre, txtApellido;
    JTextField txtFecha, txtCarrera, txtCalle, txtNumero, txtBarrio;

    JButton btnAgregar, btnActualizar, btnEliminar;
    JButton btnBuscar, btnListar;

    JTable tablaClientes;
    JScrollPane scrollTabla;
    public FrmCliente() {
        initComponents();
        
   
       setTitle("GESTIÓN DE CLIENTES");
        setSize(1000, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        getContentPane().setBackground(new Color(25,25,40));

        titulo = new JLabel("GESTIÓN DE CLIENTES");
        titulo.setBounds(300,20,400,40);
        titulo.setFont(new Font("Arial", Font.BOLD, 28));
        titulo.setForeground(new Color(0,255,200));

        add(titulo);

        lblId = new JLabel("ID Cliente:");
        lblEmail = new JLabel("Email:");
        lblNombre = new JLabel("Nombre:");
        lblApellido = new JLabel("Apellido:");
        lblFecha = new JLabel("Fecha Nacimiento:");
        lblCarrera = new JLabel("Carrera:");
        lblCalle = new JLabel("Calle:");
        lblNumero = new JLabel("Número:");
        lblBarrio = new JLabel("Barrio:");

        JLabel[] labels = {
                lblId,lblEmail,lblNombre,lblApellido,
                lblFecha,lblCarrera,lblCalle,lblNumero,lblBarrio
        };

        for(JLabel lbl : labels){
            lbl.setForeground(Color.WHITE);
            lbl.setFont(new Font("Segoe UI", Font.BOLD, 14));
            add(lbl);
        }

        txtId = new JTextField();
        txtEmail = new JTextField();
        txtNombre = new JTextField();
        txtApellido = new JTextField();
        txtFecha = new JTextField();
        txtCarrera = new JTextField();
        txtCalle = new JTextField();
        txtNumero = new JTextField();
        txtBarrio = new JTextField();

        JTextField[] campos = {
                txtId,txtEmail,txtNombre,txtApellido,
                txtFecha,txtCarrera,txtCalle,
                txtNumero,txtBarrio
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

        lblEmail.setBounds(50,140,150,25);
        txtEmail.setBounds(220,140,220,30);

        lblNombre.setBounds(50,180,150,25);
        txtNombre.setBounds(220,180,220,30);

        lblApellido.setBounds(50,220,150,25);
        txtApellido.setBounds(220,220,220,30);

        lblFecha.setBounds(50,260,150,25);
        txtFecha.setBounds(220,260,220,30);

        lblCarrera.setBounds(50,300,150,25);
        txtCarrera.setBounds(220,300,220,30);

        lblCalle.setBounds(50,340,150,25);
        txtCalle.setBounds(220,340,220,30);

        lblNumero.setBounds(50,380,150,25);
        txtNumero.setBounds(220,380,220,30);

        lblBarrio.setBounds(50,420,150,25);
        txtBarrio.setBounds(220,420,220,30);

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
                btnAgregar,btnActualizar,
                btnEliminar,btnBuscar,btnListar
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

        lblLista = new JLabel("LISTA DE CLIENTES");
        lblLista.setBounds(350,560,300,30);
        lblLista.setForeground(new Color(128,0,255));
        lblLista.setFont(new Font("Arial",Font.BOLD,22));

        add(lblLista);

        tablaClientes = new JTable();

        tablaClientes.setModel(
                new DefaultTableModel(
                        new Object[][]{},
                        new String[]{
                                "ID",
                                "Email",
                                "Nombre",
                                "Apellido",
                                "Fecha",
                                "Carrera",
                                "Calle",
                                "Número",
                                "Barrio"
                        }
                )
        );

        tablaClientes.setBackground(new Color(35,35,55));
        tablaClientes.setForeground(Color.WHITE);

        tablaClientes.setGridColor(
                new Color(0,255,200));

        tablaClientes.setSelectionBackground(
                new Color(0,255,200));

        tablaClientes.setSelectionForeground(
                Color.BLACK);

        tablaClientes.setRowHeight(28);

        tablaClientes.getTableHeader().setBackground(
                new Color(0,255,200));

        tablaClientes.getTableHeader().setForeground(
                Color.BLACK);

        tablaClientes.getTableHeader().setFont(
                new Font("Segoe UI",Font.BOLD,14));

        scrollTabla = new JScrollPane(tablaClientes);

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
            .addGap(0, 716, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 563, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        
        FrmCliente formulario = new FrmCliente();
        formulario.setVisible(true);
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
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author hitim
 */


import Vista.FrmCliente;
import Modelo.Cliente;
import Modelo.ClienteDAO;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

public class ControladorCliente {

    private FrmCliente vista;
    private ClienteDAO dao;
    private int idClienteSeleccionado = -1;

    public ControladorCliente(FrmCliente vista) {

        this.vista = vista;
        this.dao = new ClienteDAO();

        iniciarEventos();
    }

    private void iniciarEventos() {

    vista.getBtnAgregar().addActionListener(e -> agregarCliente());

    vista.getBtnListar().addActionListener(e -> listarClientes());

    vista.getBtnActualizar().addActionListener(
            e -> actualizarCliente()
    );

    vista.getBtnEliminar().addActionListener(
            e -> eliminarCliente()
    );

    vista.getBtnLimpiar().addActionListener(
            e -> vista.limpiarCampos()
    );

    vista.getTablaClientes().getSelectionModel()
            .addListSelectionListener(
                    e -> cargarClienteSeleccionado()
            );

    }

    private void agregarCliente() {

        try {

            Cliente c = new Cliente();

            c.setEmail(vista.getTxtEmail().getText());
            c.setNombre(vista.getTxtNombre().getText());
            c.setApellido(vista.getTxtApellido().getText());

            c.setFechaNacimiento(
                    Date.valueOf(
                            vista.getTxtFecha().getText()
                    )
            );

            c.setCarrera(vista.getTxtCarrera().getText());
            c.setCalle(vista.getTxtCalle().getText());
            c.setNumero(vista.getTxtNumero().getText());
            c.setBarrio(vista.getTxtBarrio().getText());

            if(dao.insertarCliente(c)){

                vista.limpiarCampos();

            }

        } catch (Exception e) {

            javax.swing.JOptionPane.showMessageDialog(
                    null,
                    "Verifique los datos.\nLa fecha debe tener formato AAAA-MM-DD"
            );

        }

    }
    
    private void listarClientes() {

    ArrayList<Cliente> lista = dao.listarClientes();

    DefaultTableModel modelo =
            (DefaultTableModel) vista.getTablaClientes().getModel();

    modelo.setRowCount(0);

    for(Cliente c : lista){

        Object[] fila = {

                c.getIdCliente(),
                c.getEmail(),
                c.getNombre(),
                c.getApellido(),
                c.getFechaNacimiento(),
                c.getCarrera(),
                c.getCalle(),
                c.getNumero(),
                c.getBarrio()

        };

        modelo.addRow(fila);

    }

    }
    
    private void cargarClienteSeleccionado() {

    int fila = vista.getTablaClientes().getSelectedRow();

    if(fila == -1){

        return;

    }
    
    idClienteSeleccionado =
        Integer.parseInt(
                vista.getTablaClientes()
                     .getValueAt(fila,0)
                     .toString()
        );
    
    vista.getTxtEmail().setText(
            vista.getTablaClientes().getValueAt(fila,1).toString()
    );

    vista.getTxtNombre().setText(
            vista.getTablaClientes().getValueAt(fila,2).toString()
    );

    vista.getTxtApellido().setText(
            vista.getTablaClientes().getValueAt(fila,3).toString()
    );

    vista.getTxtFecha().setText(
            vista.getTablaClientes().getValueAt(fila,4).toString()
    );

    vista.getTxtCarrera().setText(
            vista.getTablaClientes().getValueAt(fila,5).toString()
    );

    vista.getTxtCalle().setText(
            vista.getTablaClientes().getValueAt(fila,6).toString()
    );

    vista.getTxtNumero().setText(
            vista.getTablaClientes().getValueAt(fila,7).toString()
    );

    vista.getTxtBarrio().setText(
            vista.getTablaClientes().getValueAt(fila,8).toString()
    );

    }
    
    private void actualizarCliente() {

    if(idClienteSeleccionado == -1){

        javax.swing.JOptionPane.showMessageDialog(
                null,
                "Seleccione un cliente primero"
        );

        return;
    }

    try{

        Cliente c = new Cliente();

        c.setIdCliente(idClienteSeleccionado);

        c.setEmail(vista.getTxtEmail().getText());
        c.setNombre(vista.getTxtNombre().getText());
        c.setApellido(vista.getTxtApellido().getText());

        c.setFechaNacimiento(
                java.sql.Date.valueOf(
                        vista.getTxtFecha().getText()
                )
        );

        c.setCarrera(vista.getTxtCarrera().getText());
        c.setCalle(vista.getTxtCalle().getText());
        c.setNumero(vista.getTxtNumero().getText());
        c.setBarrio(vista.getTxtBarrio().getText());

        dao.actualizarCliente(c);

        listarClientes();

    }catch(Exception e){

        javax.swing.JOptionPane.showMessageDialog(
                null,
                "Error al actualizar"
        );

    }

    }
    
    private void eliminarCliente() {

    if(idClienteSeleccionado == -1){

        javax.swing.JOptionPane.showMessageDialog(
                null,
                "Seleccione un cliente"
        );

        return;
    }

    int opcion = javax.swing.JOptionPane.showConfirmDialog(
            null,
            "¿Desea eliminar este cliente?",
            "Confirmar eliminación",
            javax.swing.JOptionPane.YES_NO_OPTION
    );

    if(opcion == javax.swing.JOptionPane.YES_OPTION){

        dao.eliminarCliente(idClienteSeleccionado);

        listarClientes();

        vista.limpiarCampos();

        idClienteSeleccionado = -1;

    }

    }

}

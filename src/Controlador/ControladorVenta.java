/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author hitim
 */
import Vista.FrmVenta;
import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Venta;
import Modelo.VentaDAO;
import Modelo.DetalleVenta;
import Modelo.DetalleVentaDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

public class ControladorVenta implements ActionListener {

    FrmVenta vista;
    VentaDAO dao;
    ClienteDAO clienteDAO;
    ProductoDAO productoDAO;
    DetalleVentaDAO detalleDAO;

    private int idVentaSeleccionada = -1;
    private int idDetalleSeleccionado = -1;

    public ControladorVenta(FrmVenta vista) {
        this.vista = vista;
        this.dao = new VentaDAO();
        this.clienteDAO = new ClienteDAO();
        this.productoDAO = new ProductoDAO();
        this.detalleDAO = new DetalleVentaDAO();

        // Botones de venta
        vista.getBtnAgregar().addActionListener(this);
        vista.getBtnEliminar().addActionListener(this);
        vista.getBtnListar().addActionListener(this);
        vista.getBtnLimpiar().addActionListener(this);

        // Botones de detalle
        vista.getBtnAgregarDetalle().addActionListener(this);
        vista.getBtnEliminarDetalle().addActionListener(this);

        // Al seleccionar una venta → cargar sus detalles
        vista.getTablaVentas().getSelectionModel()
            .addListSelectionListener(e -> cargarDesdeTabla());

        // Al seleccionar un detalle → guardar su ID
        vista.getTablaDetalles().getSelectionModel()
            .addListSelectionListener(e -> {
                int fila = vista.getTablaDetalles().getSelectedRow();
                if (fila >= 0) {
                    idDetalleSeleccionado = Integer.parseInt(
                        vista.getTablaDetalles().getValueAt(fila, 0).toString()
                    );
                }
            });

        cargarClientes();
        cargarProductos();
    }

    private void cargarClientes() {
        ArrayList<Cliente> lista = clienteDAO.listarClientes();
        vista.getCmbCliente().removeAllItems();
        for (Cliente c : lista) {
            vista.getCmbCliente().addItem(c);
        }
    }

    private void cargarProductos() {
        ArrayList<Producto> lista = productoDAO.listarProductos();
        vista.getCmbProducto().removeAllItems();
        for (Producto p : lista) {
            vista.getCmbProducto().addItem(p);
        }
    }

    private void listar() {
        DefaultTableModel model = (DefaultTableModel) vista.getTablaVentas().getModel();
        model.setRowCount(0);
        idVentaSeleccionada = -1;

        // Limpiar tabla de detalles también
        ((DefaultTableModel) vista.getTablaDetalles().getModel()).setRowCount(0);

        ArrayList<Venta> lista = dao.listarVentas();
        for (Venta v : lista) {
            model.addRow(new Object[]{
                v.getIdVenta(),
                v.getFecha(),
                v.getTotalVenta(),
                v.getMetodoPago(),
                v.getIdCliente()
            });
        }
    }

    private void agregar() {
        try {
            Cliente clienteSeleccionado = (Cliente) vista.getCmbCliente().getSelectedItem();
            if (clienteSeleccionado == null) {
                JOptionPane.showMessageDialog(null, "Selecciona un cliente.");
                return;
            }

            Venta v = new Venta();
            v.setFecha(Date.valueOf(vista.getTxtFecha().getText()));
            v.setTotalVenta(Double.parseDouble(vista.getTxtTotal().getText()));
            v.setMetodoPago(vista.getTxtMetodo().getText());
            v.setIdCliente(clienteSeleccionado.getIdCliente());
            v.setIdUsuarioSistema(3);

            dao.insertarVenta(v);
            listar();
            vista.limpiarCampos();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                "Verifique los datos.\nLa fecha debe tener formato AAAA-MM-DD");
        }
    }

    private void eliminar() {
        if (idVentaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "Selecciona una venta primero.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(null,
            "¿Seguro que deseas eliminar esta venta y todos sus detalles?",
            "Confirmar", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            dao.eliminarVenta(idVentaSeleccionada);
            listar();
            vista.limpiarCampos();
            idVentaSeleccionada = -1;
        }
    }

    private void cargarDesdeTabla() {
        int fila = vista.getTablaVentas().getSelectedRow();
        if (fila == -1) return;

        idVentaSeleccionada = Integer.parseInt(
            vista.getTablaVentas().getValueAt(fila, 0).toString()
        );

        vista.getTxtFecha().setText(
            vista.getTablaVentas().getValueAt(fila, 1).toString());
        vista.getTxtTotal().setText(
            vista.getTablaVentas().getValueAt(fila, 2).toString());
        vista.getTxtMetodo().setText(
            vista.getTablaVentas().getValueAt(fila, 3).toString());

        // Cargar detalles de esa venta
        cargarDetalles(idVentaSeleccionada);
    }

    private void cargarDetalles(int idVenta) {
        DefaultTableModel model = (DefaultTableModel) vista.getTablaDetalles().getModel();
        model.setRowCount(0);

        ArrayList<DetalleVenta> lista = detalleDAO.listarDetallesVenta();
        for (DetalleVenta dv : lista) {
            if (dv.getIdVenta() == idVenta) {
                // Buscar nombre del producto
                String nombreProducto = buscarNombreProducto(dv.getIdProducto());
                model.addRow(new Object[]{
                    dv.getIdDetalleVenta(),
                    nombreProducto,
                    dv.getCantidad(),
                    dv.getPrecioVenta()
                });
            }
        }
    }

    private String buscarNombreProducto(int idProducto) {
        ArrayList<Producto> lista = productoDAO.listarProductos();
        for (Producto p : lista) {
            if (p.getIdProducto() == idProducto) {
                return p.getNombre();
            }
        }
        return "ID: " + idProducto;
    }

    private void agregarDetalle() {
        if (idVentaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null,
                "Primero selecciona una venta de la tabla.");
            return;
        }

        try {
            Producto productoSeleccionado =
                (Producto) vista.getCmbProducto().getSelectedItem();

            if (productoSeleccionado == null) {
                JOptionPane.showMessageDialog(null, "Selecciona un producto.");
                return;
            }

            int cantidad = Integer.parseInt(vista.getTxtCantidad().getText());

            DetalleVenta dv = new DetalleVenta();
            dv.setIdVenta(idVentaSeleccionada);
            dv.setIdProducto(productoSeleccionado.getIdProducto());
            dv.setCantidad(cantidad);
            dv.setPrecioVenta(productoSeleccionado.getPrecioVenta());

            detalleDAO.insertarDetalleVenta(dv);
            cargarDetalles(idVentaSeleccionada);
            vista.getTxtCantidad().setText("");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                "Error al agregar detalle: " + e.getMessage());
        }
    }

    private void eliminarDetalle() {
        if (idDetalleSeleccionado == -1) {
            JOptionPane.showMessageDialog(null,
                "Selecciona un detalle de la tabla primero.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(null,
            "¿Eliminar este detalle?", "Confirmar",
            JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            detalleDAO.eliminarDetalleVenta(idDetalleSeleccionado);
            cargarDetalles(idVentaSeleccionada);
            idDetalleSeleccionado = -1;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if      (e.getSource() == vista.getBtnAgregar())         agregar();
        else if (e.getSource() == vista.getBtnEliminar())        eliminar();
        else if (e.getSource() == vista.getBtnListar())          listar();
        else if (e.getSource() == vista.getBtnLimpiar())         vista.limpiarCampos();
        else if (e.getSource() == vista.getBtnAgregarDetalle())  agregarDetalle();
        else if (e.getSource() == vista.getBtnEliminarDetalle()) eliminarDetalle();
    }
}

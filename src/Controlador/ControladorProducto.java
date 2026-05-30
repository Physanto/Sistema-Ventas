/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author hitim
 */

import Vista.FrmProducto;
import Modelo.Categoria;
import Modelo.CategoriaDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

public class ControladorProducto implements ActionListener {

    FrmProducto vista;
    ProductoDAO dao;
    CategoriaDAO categoriaDAO;

    public ControladorProducto(FrmProducto vista) {
        this.vista = vista;
        this.dao = new ProductoDAO();
        this.categoriaDAO = new CategoriaDAO();

        // Conectar botones
        vista.getBtnAgregar().addActionListener(this);
        vista.getBtnActualizar().addActionListener(this);
        vista.getBtnEliminar().addActionListener(this);
        vista.getBtnListar().addActionListener(this);
        vista.getBtnLimpiar().addActionListener(this);

        // Al hacer clic en una fila, cargar datos en los campos
        vista.getTablaProductos().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                cargarDesdeTabla();
            }
        });

        // Llenar el ComboBox con categorías desde MySQL
        cargarCategorias();
    }

    private void cargarCategorias() {
        ArrayList<Categoria> lista = categoriaDAO.listarCategorias();
        vista.getCmbCategoria().removeAllItems();
        for (Categoria c : lista) {
            vista.getCmbCategoria().addItem(c);
        }
    }

    private void listar() {
        DefaultTableModel model = (DefaultTableModel) vista.getTablaProductos().getModel();
        model.setRowCount(0);

        ArrayList<Producto> lista = dao.listarProductos();
        for (Producto p : lista) {
            model.addRow(new Object[]{
                p.getIdProducto(),
                p.getNombre(),
                p.getStockActual(),
                p.getPrecioVenta(),
                p.getStockMinimo(),
                p.getFechaVencimiento(),
                p.getUbicacion()
            });
        }
    }

    private void agregar() {
        try {
            Producto p = new Producto();
            p.setNombre(vista.getTxtNombre().getText());
            p.setStockActual(Integer.parseInt(vista.getTxtStock().getText()));
            p.setPrecioVenta(Double.parseDouble(vista.getTxtPrecio().getText()));
            p.setStockMinimo(Integer.parseInt(vista.getTxtMinimo().getText()));
            p.setFechaVencimiento(Date.valueOf(vista.getTxtFecha().getText()));
            p.setUbicacion(vista.getTxtUbicacion().getText());

            Categoria catSeleccionada = (Categoria) vista.getCmbCategoria().getSelectedItem();
            p.setIdCategoria(catSeleccionada.getIdCategoria());

            dao.insertarProducto(p);
            listar();
            vista.limpiarCampos();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar: " + e.getMessage());
        }
    }

    private void actualizar() {
        try {
            int fila = vista.getTablaProductos().getSelectedRow();
            if (fila < 0) {
                JOptionPane.showMessageDialog(null, "Selecciona un producto de la tabla primero.");
                return;
            }

            int id = Integer.parseInt(
                vista.getTablaProductos().getValueAt(fila, 0).toString()
            );

            Producto p = new Producto();
            p.setIdProducto(id);
            p.setNombre(vista.getTxtNombre().getText());
            p.setStockActual(Integer.parseInt(vista.getTxtStock().getText()));
            p.setPrecioVenta(Double.parseDouble(vista.getTxtPrecio().getText()));
            p.setStockMinimo(Integer.parseInt(vista.getTxtMinimo().getText()));
            p.setFechaVencimiento(Date.valueOf(vista.getTxtFecha().getText()));
            p.setUbicacion(vista.getTxtUbicacion().getText());

            Categoria catSeleccionada = (Categoria) vista.getCmbCategoria().getSelectedItem();
            p.setIdCategoria(catSeleccionada.getIdCategoria());

            dao.actualizarProducto(p);
            listar();
            vista.limpiarCampos();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar: " + e.getMessage());
        }
    }

    private void eliminar() {
        try {
            int fila = vista.getTablaProductos().getSelectedRow();
            if (fila < 0) {
                JOptionPane.showMessageDialog(null, "Selecciona un producto de la tabla primero.");
                return;
            }

            int id = Integer.parseInt(
                vista.getTablaProductos().getValueAt(fila, 0).toString()
            );

            int confirm = JOptionPane.showConfirmDialog(null,
                    "¿Seguro que deseas eliminar este producto?",
                    "Confirmar", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                dao.eliminarProducto(id);
                listar();
                vista.limpiarCampos();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar: " + e.getMessage());
        }
    }

    private void cargarDesdeTabla() {
        int fila = vista.getTablaProductos().getSelectedRow();
        if (fila >= 0) {
            vista.getTxtNombre().setText(
                vista.getTablaProductos().getValueAt(fila, 1).toString());
            vista.getTxtStock().setText(
                vista.getTablaProductos().getValueAt(fila, 2).toString());
            vista.getTxtPrecio().setText(
                vista.getTablaProductos().getValueAt(fila, 3).toString());
            vista.getTxtMinimo().setText(
                vista.getTablaProductos().getValueAt(fila, 4).toString());
            vista.getTxtFecha().setText(
                vista.getTablaProductos().getValueAt(fila, 5).toString());
            vista.getTxtUbicacion().setText(
                vista.getTablaProductos().getValueAt(fila, 6).toString());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnAgregar()) agregar();
        else if (e.getSource() == vista.getBtnActualizar()) actualizar();
        else if (e.getSource() == vista.getBtnEliminar()) eliminar();
        else if (e.getSource() == vista.getBtnListar()) listar();
        else if (e.getSource() == vista.getBtnLimpiar()) vista.limpiarCampos();
    }
}

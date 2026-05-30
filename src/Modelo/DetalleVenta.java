/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author hitim
 */


public class DetalleVenta {

    private int idDetalleVenta;
    private int cantidad;
    private double precioVenta;
    private int idProducto;
    private int idVenta;

    public DetalleVenta() {
    }

    public DetalleVenta(int idDetalleVenta,
                        int cantidad,
                        double precioVenta,
                        int idProducto,
                        int idVenta) {

        this.idDetalleVenta = idDetalleVenta;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.idProducto = idProducto;
        this.idVenta = idVenta;
    }

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }
}

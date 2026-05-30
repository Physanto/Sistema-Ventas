/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.sql.Date;
/**
 *
 * @author hitim
 */


public class Venta {

    private int idVenta;
    private Date fecha;
    private double totalVenta;
    private String metodoPago;
    private int idCliente;
    private int idUsuarioSistema;

    public Venta() {
    }

    public Venta(int idVenta, Date fecha, double totalVenta,
                 String metodoPago,
                 int idCliente,
                 int idUsuarioSistema) {

        this.idVenta = idVenta;
        this.fecha = fecha;
        this.totalVenta = totalVenta;
        this.metodoPago = metodoPago;
        this.idCliente = idCliente;
        this.idUsuarioSistema = idUsuarioSistema;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdUsuarioSistema() {
        return idUsuarioSistema;
    }

    public void setIdUsuarioSistema(int idUsuarioSistema) {
        this.idUsuarioSistema = idUsuarioSistema;
    }
}
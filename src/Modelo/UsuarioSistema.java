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
public class UsuarioSistema {

    private int idUsuarioSistema;
    private String email;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String carrera;
    private String calle;
    private String numero;
    private String barrio;
    private String rol;
    private String contraseña;

    public UsuarioSistema() {
    }

    public UsuarioSistema(int idUsuarioSistema, String email, String nombre, String apellido, Date fechaNacimiento, String carrera, String calle, String numero, String barrio, String rol, String contraseña) {
        this.idUsuarioSistema = idUsuarioSistema;
        this.email = email;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.carrera = carrera;
        this.calle = calle;
        this.numero = numero;
        this.barrio = barrio;
        this.rol = rol;
        this.contraseña = contraseña;
    }

    public int getIdUsuarioSistema() {
        return idUsuarioSistema;
    }

    public void setIdUsuarioSistema(int idUsuarioSistema) {
        this.idUsuarioSistema = idUsuarioSistema;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    
}


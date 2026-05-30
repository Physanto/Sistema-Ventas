/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author hitim
 */
public class ClienteDAO {
    
    Connection con;
    PreparedStatement ps;
    
    public boolean insertarCliente(Cliente c){

    String query = "INSERT INTO cliente "
            + "(email, nombre, apellido, fecha_nacimiento, carrera, calle, numero, barrio) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    try{

        con = Conexion.conectar();

        ps = con.prepareStatement(query);

        ps.setString(1, c.getEmail());
        ps.setString(2, c.getNombre());
        ps.setString(3, c.getApellido());
        ps.setDate(4, c.getFechaNacimiento());
        ps.setString(5, c.getCarrera());
        ps.setString(6, c.getCalle());
        ps.setString(7, c.getNumero());
        ps.setString(8, c.getBarrio());

        ps.executeUpdate();

        JOptionPane.showMessageDialog(null, "Cliente guardado");

        return true;

    }catch(SQLException e){

        JOptionPane.showMessageDialog(null, "Error al guardar cliente: " + e);

        return false;

    }
    
}

    public ArrayList<Cliente> listarClientes(){

    ArrayList<Cliente> listaClientes = new ArrayList<>();

    String query = "SELECT * FROM cliente";

    try{

        con = Conexion.conectar();

        ps = con.prepareStatement(query);

        ResultSet rs = ps.executeQuery();

        while(rs.next()){

            Cliente c = new Cliente();

            c.setIdCliente(rs.getInt("id_cliente"));
            c.setEmail(rs.getString("email"));
            c.setNombre(rs.getString("nombre"));
            c.setApellido(rs.getString("apellido"));
            c.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
            c.setCarrera(rs.getString("carrera"));
            c.setCalle(rs.getString("calle"));
            c.setNumero(rs.getString("numero"));
            c.setBarrio(rs.getString("barrio"));

            listaClientes.add(c);

        }

    }catch(SQLException e){

        JOptionPane.showMessageDialog(null, "Error al listar clientes: " + e);

    }

    return listaClientes;

}
    
    public boolean actualizarCliente(Cliente c){

    String query = "UPDATE cliente SET "
            + "email = ?, "
            + "nombre = ?, "
            + "apellido = ?, "
            + "fecha_nacimiento = ?, "
            + "carrera = ?, "
            + "calle = ?, "
            + "numero = ?, "
            + "barrio = ? "
            + "WHERE id_cliente = ?";

    try{

        con = Conexion.conectar();

        ps = con.prepareStatement(query);

        ps.setString(1, c.getEmail());
        ps.setString(2, c.getNombre());
        ps.setString(3, c.getApellido());
        ps.setDate(4, c.getFechaNacimiento());
        ps.setString(5, c.getCarrera());
        ps.setString(6, c.getCalle());
        ps.setString(7, c.getNumero());
        ps.setString(8, c.getBarrio());

        ps.setInt(9, c.getIdCliente());

        ps.executeUpdate();

        JOptionPane.showMessageDialog(null, "Cliente actualizado");

        return true;

    }catch(SQLException e){

        JOptionPane.showMessageDialog(null, "Error al actualizar cliente: " + e);

        return false;

    }

}
    public boolean eliminarCliente(int idCliente){

    String query = "DELETE FROM cliente WHERE id_cliente = ?";

    try{

        con = Conexion.conectar();

        ps = con.prepareStatement(query);

        ps.setInt(1, idCliente);

        ps.executeUpdate();

        JOptionPane.showMessageDialog(null, "Cliente eliminado");

        return true;

    }catch(SQLException e){

        JOptionPane.showMessageDialog(null, "Error al eliminar cliente: " + e);

        return false;

    }

}
}
    


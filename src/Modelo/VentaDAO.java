/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author hitim
 */
public class VentaDAO {
    
    Connection con;
    PreparedStatement ps;
    
    public boolean insertarVenta(Venta v){

    String query = "INSERT INTO venta "
            + "(fecha, total_venta, metodo_pago, id_cliente, id_usuario_sistema) "
            + "VALUES (?, ?, ?, ?, ?)";

    try{

        con = Conexion.conectar();

        ps = con.prepareStatement(query);

        ps.setDate(1, v.getFecha());
        ps.setDouble(2, v.getTotalVenta());
        ps.setString(3, v.getMetodoPago());
        ps.setInt(4, v.getIdCliente());
        ps.setInt(5, v.getIdUsuarioSistema());

        ps.executeUpdate();

        JOptionPane.showMessageDialog(null, "Venta guardada");

        return true;

    }catch(SQLException e){

        JOptionPane.showMessageDialog(null, "Error al guardar venta: " + e);

        return false;

    }

}
    
    public ArrayList<Venta> listarVentas(){

    ArrayList<Venta> listaVentas = new ArrayList<>();

    String query = "SELECT * FROM venta";

    try{

        con = Conexion.conectar();

        ps = con.prepareStatement(query);

        ResultSet rs = ps.executeQuery();

        while(rs.next()){

            Venta v = new Venta();

            v.setIdVenta(rs.getInt("id_venta"));
            v.setFecha(rs.getDate("fecha"));
            v.setTotalVenta(rs.getDouble("total_venta"));
            v.setMetodoPago(rs.getString("metodo_pago"));
            v.setIdCliente(rs.getInt("id_cliente"));
            v.setIdUsuarioSistema(rs.getInt("id_usuario_sistema"));

            listaVentas.add(v);

        }

    }catch(SQLException e){

        JOptionPane.showMessageDialog(null, "Error al listar ventas: " + e);

    }

    return listaVentas;

}
    
    public boolean actualizarVenta(Venta v){

    String query = "UPDATE venta SET "
            + "fecha = ?, "
            + "total_venta = ?, "
            + "metodo_pago = ?, "
            + "id_cliente = ?, "
            + "id_usuario_sistema = ? "
            + "WHERE id_venta = ?";

    try{

        con = Conexion.conectar();

        ps = con.prepareStatement(query);

        ps.setDate(1, v.getFecha());
        ps.setDouble(2, v.getTotalVenta());
        ps.setString(3, v.getMetodoPago());
        ps.setInt(4, v.getIdCliente());
        ps.setInt(5, v.getIdUsuarioSistema());

        ps.setInt(6, v.getIdVenta());

        ps.executeUpdate();

        JOptionPane.showMessageDialog(null, "Venta actualizada");

        return true;

    }catch(SQLException e){

        JOptionPane.showMessageDialog(null, "Error al actualizar venta: " + e);

        return false;

    }

}
    
    public boolean eliminarVenta(int idVenta){

    String query = "DELETE FROM venta WHERE id_venta = ?";

    try{

        con = Conexion.conectar();

        ps = con.prepareStatement(query);

        ps.setInt(1, idVenta);

        ps.executeUpdate();

        JOptionPane.showMessageDialog(null, "Venta eliminada");

        return true;

    }catch(SQLException e){

        JOptionPane.showMessageDialog(null, "Error al eliminar venta: " + e);

        return false;

    }

}
}

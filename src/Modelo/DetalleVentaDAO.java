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
public class DetalleVentaDAO {
    
    Connection con;
    PreparedStatement ps;
    
    public boolean insertarDetalleVenta(DetalleVenta dv){

    String query = "INSERT INTO detalle_venta "
            + "(cantidad, precio_venta, id_producto, id_venta) "
            + "VALUES (?, ?, ?, ?)";

    try{

        con = Conexion.conectar();

        ps = con.prepareStatement(query);

        ps.setInt(1, dv.getCantidad());
        ps.setDouble(2, dv.getPrecioVenta());
        ps.setInt(3, dv.getIdProducto());
        ps.setInt(4, dv.getIdVenta());

        ps.executeUpdate();

        JOptionPane.showMessageDialog(null, "Detalle de venta guardado");

        return true;

    }catch(SQLException e){

        JOptionPane.showMessageDialog(null, "Error al guardar detalle: " + e);

        return false;

    }

}
    
    public ArrayList<DetalleVenta> listarDetallesVenta(){

    ArrayList<DetalleVenta> listaDetalles = new ArrayList<>();

    String query = "SELECT * FROM detalle_venta";

    try{

        con = Conexion.conectar();

        ps = con.prepareStatement(query);

        ResultSet rs = ps.executeQuery();

        while(rs.next()){

            DetalleVenta dv = new DetalleVenta();

            dv.setIdDetalleVenta(rs.getInt("id_detalle_venta"));
            dv.setCantidad(rs.getInt("cantidad"));
            dv.setPrecioVenta(rs.getDouble("precio_venta"));
            dv.setIdProducto(rs.getInt("id_producto"));
            dv.setIdVenta(rs.getInt("id_venta"));

            listaDetalles.add(dv);

        }

    }catch(SQLException e){

        JOptionPane.showMessageDialog(null, "Error al listar detalles: " + e);

    }

    return listaDetalles;

}
    
    public boolean actualizarDetalleVenta(DetalleVenta dv){

    String query = "UPDATE detalle_venta SET "
            + "cantidad = ?, "
            + "precio_venta = ?, "
            + "id_producto = ?, "
            + "id_venta = ? "
            + "WHERE id_detalle_venta = ?";

    try{

        con = Conexion.conectar();

        ps = con.prepareStatement(query);

        ps.setInt(1, dv.getCantidad());
        ps.setDouble(2, dv.getPrecioVenta());
        ps.setInt(3, dv.getIdProducto());
        ps.setInt(4, dv.getIdVenta());

        ps.setInt(5, dv.getIdDetalleVenta());

        ps.executeUpdate();

        JOptionPane.showMessageDialog(null, "Detalle actualizado");

        return true;

    }catch(SQLException e){

        JOptionPane.showMessageDialog(null, "Error al actualizar detalle: " + e);

        return false;

    }

}
    
    public boolean eliminarDetalleVenta(int idDetalleVenta){

    String query = "DELETE FROM detalle_venta WHERE id_detalle_venta = ?";

    try{

        con = Conexion.conectar();

        ps = con.prepareStatement(query);

        ps.setInt(1, idDetalleVenta);

        ps.executeUpdate();

        JOptionPane.showMessageDialog(null, "Detalle eliminado");

        return true;

    }catch(SQLException e){

        JOptionPane.showMessageDialog(null, "Error al eliminar detalle: " + e);

        return false;

    }

}
}

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
public class ProductoDAO {
   
    Connection con;
    PreparedStatement ps;
    
    public boolean insertarProducto(Producto p){

    String query = "INSERT INTO producto "
            + "(nombre, stock_actual, precio_venta, stock_minimo, "
            + "fecha_vencimiento, ubicacion, id_categoria) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?)";

    try{

        con = Conexion.conectar();

        ps = con.prepareStatement(query);

        ps.setString(1, p.getNombre());
        ps.setInt(2, p.getStockActual());
        ps.setDouble(3, p.getPrecioVenta());
        ps.setInt(4, p.getStockMinimo());
        ps.setDate(5, p.getFechaVencimiento());
        ps.setString(6, p.getUbicacion());
        ps.setInt(7, p.getIdCategoria());

        ps.executeUpdate();

        JOptionPane.showMessageDialog(null, "Producto guardado");

        return true;

    }catch(SQLException e){

        JOptionPane.showMessageDialog(null, "Error al guardar producto: " + e);

        return false;

    }

}
    
    public ArrayList<Producto> listarProductos(){

    ArrayList<Producto> listaProductos = new ArrayList<>();

    String query = "SELECT * FROM producto";

    try{

        con = Conexion.conectar();

        ps = con.prepareStatement(query);

        ResultSet rs = ps.executeQuery();

        while(rs.next()){

            Producto p = new Producto();

            p.setIdProducto(rs.getInt("id_producto"));
            p.setNombre(rs.getString("nombre"));
            p.setStockActual(rs.getInt("stock_actual"));
            p.setPrecioVenta(rs.getDouble("precio_venta"));
            p.setStockMinimo(rs.getInt("stock_minimo"));
            p.setFechaVencimiento(rs.getDate("fecha_vencimiento"));
            p.setUbicacion(rs.getString("ubicacion"));
            p.setIdCategoria(rs.getInt("id_categoria"));

            listaProductos.add(p);

        }

    }catch(SQLException e){

        JOptionPane.showMessageDialog(null, "Error al listar productos: " + e);

    }

    return listaProductos;

}
    
    public boolean actualizarProducto(Producto p){

    String query = "UPDATE producto SET "
            + "nombre = ?, "
            + "stock_actual = ?, "
            + "precio_venta = ?, "
            + "stock_minimo = ?, "
            + "fecha_vencimiento = ?, "
            + "ubicacion = ?, "
            + "id_categoria = ? "
            + "WHERE id_producto = ?";

    try{

        con = Conexion.conectar();

        ps = con.prepareStatement(query);

        ps.setString(1, p.getNombre());
        ps.setInt(2, p.getStockActual());
        ps.setDouble(3, p.getPrecioVenta());
        ps.setInt(4, p.getStockMinimo());
        ps.setDate(5, p.getFechaVencimiento());
        ps.setString(6, p.getUbicacion());
        ps.setInt(7, p.getIdCategoria());

        ps.setInt(8, p.getIdProducto());

        ps.executeUpdate();

        JOptionPane.showMessageDialog(null, "Producto actualizado");

        return true;

    }catch(SQLException e){

        JOptionPane.showMessageDialog(null, "Error al actualizar producto: " + e);

        return false;

    }

}
    
    
    public boolean eliminarProducto(int idProducto){

    String query = "DELETE FROM producto WHERE id_producto = ?";

    try{

        con = Conexion.conectar();

        ps = con.prepareStatement(query);

        ps.setInt(1, idProducto);

        ps.executeUpdate();

        JOptionPane.showMessageDialog(null, "Producto eliminado");

        return true;

    }catch(SQLException e){

        JOptionPane.showMessageDialog(null, "Error al eliminar producto: " + e);

        return false;

    }

}
}

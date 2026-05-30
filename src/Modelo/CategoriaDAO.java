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
public class CategoriaDAO {
    
    Connection con;
    PreparedStatement ps;
    
    public boolean insertarCategoria(Categoria c){

    String query = "INSERT INTO categoria(nombre) VALUES(?)";

    try{

        con = Conexion.conectar();

        ps = con.prepareStatement(query);

        ps.setString(1, c.getNombre());

        ps.executeUpdate();

        JOptionPane.showMessageDialog(null, "Categoría guardada");

        return true;

    }catch(SQLException e){

        JOptionPane.showMessageDialog(null, "Error al guardar categoría: " + e);

        return false;

    }

}
    
    public ArrayList<Categoria> listarCategorias(){

    ArrayList<Categoria> listaCategorias = new ArrayList<>();

    String query = "SELECT * FROM categoria";

    try{

        con = Conexion.conectar();

        ps = con.prepareStatement(query);

        ResultSet rs = ps.executeQuery();

        while(rs.next()){

            Categoria c = new Categoria();

            c.setIdCategoria(rs.getInt("id_categoria"));
            c.setNombre(rs.getString("nombre"));

            listaCategorias.add(c);

        }

    }catch(SQLException e){

        JOptionPane.showMessageDialog(null, "Error al listar categorías: " + e);

    }

    return listaCategorias;

}
    
    public boolean actualizarCategoria(Categoria c){

    String query = "UPDATE categoria SET nombre = ? WHERE id_categoria = ?";

    try{

        con = Conexion.conectar();

        ps = con.prepareStatement(query);

        ps.setString(1, c.getNombre());
        ps.setInt(2, c.getIdCategoria());

        ps.executeUpdate();

        JOptionPane.showMessageDialog(null, "Categoría actualizada");

        return true;

    }catch(SQLException e){

        JOptionPane.showMessageDialog(null, "Error al actualizar categoría: " + e);

        return false;

    }

}
    
    
    public boolean eliminarCategoria(int idCategoria){

    String query = "DELETE FROM categoria WHERE id_categoria = ?";

    try{

        con = Conexion.conectar();

        ps = con.prepareStatement(query);

        ps.setInt(1, idCategoria);

        ps.executeUpdate();

        JOptionPane.showMessageDialog(null, "Categoría eliminada");

        return true;

    }catch(SQLException e){

        JOptionPane.showMessageDialog(null, "Error al eliminar categoría: " + e);

        return false;

    }

}
    
    
}

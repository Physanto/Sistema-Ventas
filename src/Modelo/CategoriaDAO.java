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

    public ArrayList<Categoria> listarCategorias(){

        ArrayList<Categoria> lista = new ArrayList<>();

        String query = "SELECT * FROM categoria";

        try{

            con = Conexion.conectar();

            ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                Categoria c = new Categoria();

                c.setIdCategoria(rs.getInt("id_categoria"));
                c.setNombre(rs.getString("nombre"));

                lista.add(c);
            }

        }catch(Exception e){

            JOptionPane.showMessageDialog(
                    null,
                    "Error al listar categorías: " + e
            );
        }

        return lista;
    }
}

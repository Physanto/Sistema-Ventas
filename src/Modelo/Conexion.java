package Modelo;
import java.sql.*;

/**
 *
 * @author mamia
 */
public class Conexion {
    
    static String url = "jdbc:mysql://localhost:3306/multibelleza";
    static String user = "root";
    static String pass = "root";
    
    public static Connection conectar(){
        Connection con = null;
        try{
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexión Exitosa");
        }catch(SQLException e){
            System.out.println("Error en la conexion");
        }
        return con;
    }
    
}

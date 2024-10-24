package zona_fit.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    public static Connection getConnection(){
        Connection conexion = null;
        final String baseDatos = "zona_fit";
        final String URL = "jdbc:postgresql://localhost:5432/"+baseDatos;
        final String USER = "postgres";
        final String PASSWORD = "admin";
        try {
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
        }catch (Exception e){
            System.out.println("error al conectarse a la base de datos" + e.getMessage());
        }
        return conexion;
    }

    public static void main(String[] args) {
        var conexion = Conexion.getConnection();

        if( conexion != null){
            System.out.println("conectado");
            return;
        }
        System.out.println("error");
    }
}

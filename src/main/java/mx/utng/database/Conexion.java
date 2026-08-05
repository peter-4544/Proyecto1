package mx.utng.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    private static final String URL ="jdbc:mysql://localhost:3306/music";

    private static final String USER = "root";

    private static final String PASSWORD = "";

    public static Connection conectar() {
        Connection con=null;

        try {
            con=DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa");

            return con;

        } catch (SQLException e) {

            e.printStackTrace();

            return null;

        }

    }


}

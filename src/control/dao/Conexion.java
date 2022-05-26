package Control.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    String bd = "bjp8dzxiiskz6ufo6f1a";
    String user = "u2zzzqov1pat9no3";
    String password = "7420x1zxcZtLzXt3FyOi";
    String url = bd + "-mysql.services.clever-cloud.com";
    String port = "3306";
    Connection con = null;

    public Conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://" + url + ":" + port + "/" + bd, user, password);
            if (con != null) {
                System.out.println("Conexión a base de datos " + bd + " OK\n");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Connection getConnection() {
        return con;
    }

    public void desconectar() {
        try {
            System.out.println("Cerrando conexion");
            con.close();
        } catch (SQLException ex) {
            ex.getMessage();
        }
    }
}

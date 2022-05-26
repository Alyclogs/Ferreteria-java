package Control.dao;

import Modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControlUsuario {

    String[] usuario;

    public String[] leerUsuario() {
        usuario = new String[2];
        Conexion conec = new Conexion();
        String sql = "SELECT * FROM usuario;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                Usuario user = new Usuario();
                user.setNombreUsuario(rs.getString(1));
                user.setPassword(rs.getString(2));
                usuario[0] = user.getNombreUsuario();
                usuario[1] = user.getPassword();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                conec.desconectar();
            } catch (Exception ex) {
                ex.getMessage();
            }
        }
        return usuario;
    }

    public void modificarUsuario(Usuario user) {
        Conexion conec = new Conexion();
        String sql = "UPDATE usuario SET nombreUsuario = ?, password = ?;";
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, user.getNombreUsuario());
            ps.setString(2, user.getPassword());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                conec.desconectar();
            } catch (Exception ex) {
                ex.getMessage();
            }
        }
    }

}

package Control.dao;

import Modelo.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControlProductos {

    public ArrayList<Producto> leerProductos(String order) {
        ArrayList<Producto> list = new ArrayList<Producto>();
        Conexion conec = new Conexion();
        String sql = "SELECT * FROM productos ORDER BY " + order + ";";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setID(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setPrecio(rs.getDouble(3));
                p.setStock(rs.getInt(4));
                list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                rs.close();
                conec.desconectar();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        return list;
    }

    public void agregarProducto(Producto p) {
        Conexion conec = new Conexion();
        String sql = "INSERT INTO productos (id, nombre, precio, stock)\n"
                + "VALUES (NULL,?,?,?);";
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setDouble(2, p.getPrecio());
            ps.setInt(3, p.getStock());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("A " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("B " + ex.getMessage());
        } finally {
            try {
                ps.close();
                conec.desconectar();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }

    public void modificarProducto(Producto p) {
        Conexion conec = new Conexion();
        String sql = "UPDATE productos SET nombre = ?, precio = ?, stock = ?\n"
                + "WHERE id = ?;";
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setDouble(2, p.getPrecio());
            ps.setInt(3, p.getStock());
            ps.setInt(4, p.getID());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                conec.desconectar();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }
    
    public void eliminarProducto(Producto p) {
        Conexion conec = new Conexion();
        String sql = "DELETE FROM productos WHERE id = ?;";
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            ps.setInt(1, p.getID());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                conec.desconectar();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }

}

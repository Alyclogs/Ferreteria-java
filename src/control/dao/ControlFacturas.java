package Control.dao;

import Modelo.Factura;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControlFacturas {

    public ArrayList<Factura> leerFacturas(String order) {
        ArrayList<Factura> list = new ArrayList();
        Conexion conec = new Conexion();
        String sql = "SELECT * FROM facturas ORDER BY " + order + ";";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Factura f = new Factura();
                f.setID(rs.getInt(1));
                f.setNombre(rs.getString(2));
                f.setNombreProducto(rs.getString(3));
                f.setCantidadVendida(rs.getInt(4));
                f.setMontoVendido(rs.getDouble(5));
                list.add(f);
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
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        return list;
    }

    public void agregarFactura(Factura f, int idProducto, int nuevoStock) {
        Conexion conec = new Conexion();
        System.out.println(idProducto + " " + nuevoStock);
        String sql = "INSERT INTO facturas (id, nomCliente, nomProducto, cantProducto, montoVenta)\n"
                + "VALUES (NULL,?,?,?,?);";
        String sql2 = "UPDATE productos SET stock = " + nuevoStock + "\n"
                + "WHERE id = " + idProducto + ";";
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            ps2 = conec.getConnection().prepareStatement(sql2);

            ps.setString(1, f.getNombre());
            ps.setString(2, f.getNombreProducto());
            ps.setInt(3, f.getCantidadVendida());
            ps.setDouble(4, f.getMontoVendido());
            
            ps.executeUpdate();
            ps2.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("A " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("B " + ex.getMessage());
        } finally {
            try {
                ps.close();
                ps2.close();
                conec.desconectar();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }

    public void modificarFactura(Factura f, int idProducto, int nuevoStock) {
        Conexion conec = new Conexion();
        String sql = "UPDATE facturas SET nomCliente = ?, nomProducto = ?, cantProducto = ?, montoVenta = ?\n"
                + "WHERE id = ?;";
        String sql2 = "UPDATE productos SET stock = " + nuevoStock + "\n"
                + "WHERE id = " + idProducto + ";";
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            ps2 = conec.getConnection().prepareStatement(sql2);

            ps.setString(1, f.getNombre());
            ps.setString(2, f.getNombreProducto());
            ps.setInt(3, f.getCantidadVendida());
            ps.setDouble(4, f.getMontoVendido());

            ps.executeUpdate();
            ps2.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                ps2.close();
                conec.desconectar();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }

    public void eliminarFactura(Factura f) {
        Conexion conec = new Conexion();
        String sql = "DELETE FROM facturas WHERE id = ?;";
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(sql);
            ps.setInt(1, f.getID());
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

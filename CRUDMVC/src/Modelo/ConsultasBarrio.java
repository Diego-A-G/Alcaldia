package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasBarrio extends Conexion{
    

    public boolean registrar(Barrio barrio) {
        PreparedStatement ps = null;
        Connection conexion = getConexion();

        String sql = "INSERT INTO barrio (id, nombre, estrato, area) VALUES(?,?,?,?)";

        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, barrio.getId());
            ps.setString(2, barrio.getNombre());
            ps.setInt(3, barrio.getEstrato());
            ps.setString(4, barrio.getArea());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean modificar(Barrio barrio) {
        PreparedStatement ps = null;
        Connection conexion = getConexion();

        String sql = "UPDATE barrio SET nombre=?, estrato=?, area=? WHERE id=? ";

        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, barrio.getId());
            ps.setString(2, barrio.getNombre());
            ps.setInt(3, barrio.getEstrato());
            ps.setString(4, barrio.getArea());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean eliminar(Barrio barrio) {
        PreparedStatement ps = null;
        Connection conexion = getConexion();

        String sql = "DELETE FROM barrio WHERE id=? ";

        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, barrio.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean buscar(Barrio barrio) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conexion = getConexion();

        String sql = "SELECT * FROM barrio WHERE id=? ";

        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, barrio.getId());
            rs = ps.executeQuery();
            
            if(rs.next())
            {
               barrio.setId( Integer.parseInt(rs.getString("id")));
               barrio.setNombre(rs.getString("nombre"));
               barrio.setEstrato(Integer.parseInt(rs.getString("estrato")));
               barrio.setArea(rs.getString("area"));
               return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
}

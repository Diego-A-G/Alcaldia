
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConsultasInstitucion extends Conexion{
    

    public boolean registrar(Institucion institucion) {
        PreparedStatement ps = null;
        Connection conexion = getConexion();

        String sql = "INSERT INTO institucion (id, razon_social,actividad_económica) VALUES(?,?,?)";

        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, institucion.getId());
            ps.setString(2, institucion.getRazonSocial());
            ps.setString(3, institucion.getActividadEconomica());
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
    
    public boolean modificar(Institucion institucion) {
        PreparedStatement ps = null;
        Connection conexion = getConexion();

        String sql = "UPDATE institucion SET razon_social=?, actividad_economica=? WHERE id=? ";

        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, institucion.getRazonSocial());
            ps.setString(2, institucion.getActividadEconomica());
            ps.setInt(3, institucion.getId());
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

    public boolean eliminar(Institucion institucion) {
        PreparedStatement ps = null;
        Connection conexion = getConexion();

        String sql = "DELETE FROM institucion WHERE id=? ";

        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, institucion.getId());
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
    
    public boolean buscar(Institucion institucion) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conexion = getConexion();

        String sql = "SELECT * FROM institucion WHERE id=? ";

        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, institucion.getId());
            rs = ps.executeQuery();
            
            if(rs.next())
            {
               institucion.setId( Integer.parseInt(rs.getString("id")));
               institucion.setRazonSocial(rs.getString("razon_social"));
               institucion.setActividadEconomica(rs.getString("actividad_economica"));
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

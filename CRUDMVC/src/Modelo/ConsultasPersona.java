package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasPersona extends Conexion {

    public boolean registrar(Persona persona) {
        PreparedStatement ps = null;
        Connection conexion = getConexion();

        String sql = "INSERT INTO persona (id, nombre, apellido, ciudad, documento, edad) VALUES(?,?,?,?,?,?)";

        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, persona.getId());
            ps.setString(2, persona.getNombre());
            ps.setString(3, persona.getApellido());
            ps.setString(4, persona.getCiudad());
            ps.setString(5, persona.getDocumento());
            ps.setInt(6, persona.getEdad());
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
    
    public boolean modificar(Persona persona) {
        PreparedStatement ps = null;
        Connection conexion = getConexion();

        String sql = "UPDATE persona SET nombre=?, apellido=?, ciudad=?, documento=?, edad=? WHERE id=? ";

        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getApellido());
            ps.setString(3, persona.getCiudad());
            ps.setString(4, persona.getDocumento());
            ps.setInt(5, persona.getEdad());
            ps.setInt(6, persona.getId());
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

    public boolean eliminar(Persona persona) {
        PreparedStatement ps = null;
        Connection conexion = getConexion();

        String sql = "DELETE FROM persona WHERE id=? ";

        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, persona.getId());
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
    
    public boolean buscar(Persona persona) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conexion = getConexion();

        String sql = "SELECT * FROM persona WHERE id=? ";

        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, persona.getId());
            rs = ps.executeQuery();
            
            if(rs.next())
            {
               persona.setId( Integer.parseInt(rs.getString("id")));
               persona.setNombre(rs.getString("nombre"));
               persona.setApellido(rs.getString("apellido"));
               persona.setCiudad(rs.getString("ciudad"));
               persona.setDocumento(rs.getString("documento"));
               persona.setEdad(Integer.parseInt(rs.getString("edad")));
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

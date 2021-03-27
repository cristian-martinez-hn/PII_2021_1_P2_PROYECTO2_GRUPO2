package Datos.Abogados;
import Datos.Conexion.Conexion;
import Recursos.Clases.Abogados;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AbogadosDatos {
    public static List<Abogados> LeerAbogado(){
        List<Abogados> ListaAbogados = new ArrayList<Abogados>();
        try{
            Connection cn = Conexion.obtenerConexion();
            Statement st = cn.createStatement();
            String sql = "SELECT Id, Nombre, FechaNacimiento, Domicilio FROM Abogado";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                Abogados abogado = new Abogados();
                abogado.setId(rs.getLong(1));
                abogado.setNombre(rs.getString(2));
                abogado.setFechaNacimiento(rs.getDate(3));
                abogado.setDomicilio(rs.getString(4));
                ListaAbogados.add(abogado);
            }
            cn.close();
        }catch (Exception e){

        }
        return ListaAbogados;
    }
    public static String InsertarAbogado(Abogados abogado){
        try{
            Connection cn = Conexion.obtenerConexion();
            Statement st = cn.createStatement();
            String sql = "INSET INTO Abogados VALUES (?,?,?,?) FROM Abogados";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setLong(1,abogado.getId());
            ps.setString(2,abogado.getNombre());
            ps.setDate(3,new java.sql.Date(abogado.getFechaNacimiento().getTime()));
            ps.setString(4,abogado.getDomicilio());
            ps.execute();
            ps.close();
            cn.close();
        }catch (Exception e){
            e.printStackTrace();
            return "Error: " +e.getMessage();
        }
        return null;
    }
    public static String ActualizarAbogado(Abogados abogado){
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "UPDATE Abogados SET Nombre =?, Domicilio =?, FechaNacimiento =? WHERE Id =?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setLong(1,abogado.getId());
            ps.setString(2,abogado.getNombre());
            ps.setDate(3,new java.sql.Date(abogado.getFechaNacimiento().getTime()));
            ps.setString(4,abogado.getDomicilio());
            ps.execute();
            ps.close();
            cn.close();
        }catch (Exception e){
            e.printStackTrace();
            return "Error: " +e.getMessage();
        }
        return null;
    }
    public static String EliminarAbogado(Abogados abogado){
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "DELETE FROM Abogado WHERE Id = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setLong(1,abogado.getId());
            ps.setString(2,abogado.getNombre());
            ps.setDate(3,new java.sql.Date(abogado.getFechaNacimiento().getTime()));
            ps.setString(4,abogado.getDomicilio());
            ps.execute();
            ps.close();
            cn.close();
        }catch (Exception e){
            e.printStackTrace();
            return "Error: " +e.getMessage();
        }
        return null;
    }
    public static List<Abogados> BuscarAbogado(Abogados abogado) throws SQLException{
        List<Abogados> ListaAbogados = new ArrayList<Abogados>();
        try{
            Connection cn = Conexion.obtenerConexion();
            Statement st = cn.createStatement();
            String sql = "SELECT Id, Nombre, FechaNacimiento, Domicilio FROM Abogado WHERE UPPER(Nombre) Line ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setLong(1,  abogado.getId());
            ps.setString(2,abogado.getNombre());
            ps.setDate(3,new java.sql.Date(abogado.getFechaNacimiento().getTime()));
            ps.setString(4,abogado.getDomicilio());
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                do{
                    Abogados abogadoObjeto = new Abogados();
                    abogadoObjeto.setId(rs.getLong(1));
                    abogadoObjeto.setNombre(rs.getString(2));
                    abogadoObjeto.setFechaNacimiento(rs.getDate(3));
                    abogadoObjeto.setDomicilio(rs.getString(4));
                }while(rs.next());
            }
            else{
                throw new SQLException("Error no se encontro coincidencia");
            }
            ps.execute();
            cn.close();
            rs.close();
            ps.close();
        }catch (Exception e){
            e.printStackTrace();
            throw new SQLException(e.getMessage());
        }
        return ListaAbogados;
    }
}

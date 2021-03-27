package Datos.Administrativo;
import Datos.Conexion.Conexion;
import Recursos.Clases.Administrativo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdministrativoDatos {
    public static List<Administrativo> LeerAdministrativo(){
        List<Administrativo> ListaAdministrativo = new ArrayList<Administrativo>();
        try{
            Connection cn = Conexion.obtenerConexion();
            Statement st = cn.createStatement();
            String sql = "SELECT Solicitud, Certificado, Acta, Circular,Oficio FROM Curriculum";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                Administrativo  Administrativo = new Administrativo();
                Administrativo.setSolicitud(rs.getString(1));
                Administrativo.setCertificado(rs.getString(2));
                Administrativo.setActa(rs.getString(3));
                Administrativo.setCircular(rs.getString(4));
                Administrativo.setOficio(rs.getString(5));
                Administrativo.setCurriculum(rs.getString(4));

                ListaAdministrativo.add(Administrativo);
            }
            cn.close();
        }catch (Exception e){

        }
        return ListaAdministrativo;
    }
    public static String InsertarAbogadoAdministrativo (Administrativo abogadoadministrativo){
        try{
            Connection cn = Conexion.obtenerConexion();
            Statement st = cn.createStatement();
            String sql = "INSET INTO Administrativo VALUES (?,?,?,?) FROM administrativo";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,abogadoadministrativo.getSolicitud());
            ps.setString(2,abogadoadministrativo.getCertificado());
            ps.setString(3,abogadoadministrativo.getActa());
            ps.setString(4,abogadoadministrativo.getOficio());
            ps.setString(5,abogadoadministrativo.getCircular());
            ps.setString(6,abogadoadministrativo.getCurriculum());

            ps.execute();
            ps.close();
            cn.close();
        }catch (Exception e){
            e.printStackTrace();
            return "Error: " +e.getMessage();
        }
        return null;
    }
    public static String ActualizarAbogadoAdministrativo (Administrativo abogadoadministrativo){
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "UPDATE AbogadosAdministrativo SET Solicitud=?, Certificado =?, Acta =?, Circular =?," +
                    " Oficio =?" + "WHERE Curriculum =?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,abogadoadministrativo.getSolicitud());
            ps.setString(2,abogadoadministrativo.getCertificado());
            ps.setString(3,abogadoadministrativo.getActa());
            ps.setString(4,abogadoadministrativo.getOficio());
            ps.setString(5,abogadoadministrativo.getCircular());
            ps.setString(6,abogadoadministrativo.getCurriculum());
            ps.execute();
            ps.close();
            cn.close();
        }catch (Exception e){
            e.printStackTrace();
            return "Error: " +e.getMessage();
        }
        return null;
    }
    public static String EliminarAbogadoAdministrativo(Administrativo abogadoadministrativo){
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "DELETE FROM Administrativo WHERE Id = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,abogadoadministrativo.getSolicitud());
            ps.setString(2,abogadoadministrativo.getCertificado());
            ps.setString(3,abogadoadministrativo.getActa());
            ps.setString(4,abogadoadministrativo.getOficio());
            ps.setString(5,abogadoadministrativo.getCircular());
            ps.setString(6,abogadoadministrativo.getCurriculum());
            ps.execute();
            ps.close();
            cn.close();
        }catch (Exception e){
            e.printStackTrace();
            return "Error: " +e.getMessage();
        }
        return null;
    }
    public static List<Administrativo> BuscarAbogadoAdministrativo(Administrativo abogadoadministrativo) throws SQLException{
        List<Administrativo> ListaAdministrativo = new ArrayList<Administrativo>();
        try{
            Connection cn = Conexion.obtenerConexion();
            Statement st = cn.createStatement();
            String sql = "SELECT Solicitud, Certificado, Acta, Circular,Oficio,Curriculum FROM " +
                    "Administrativo WHERE UPPER(Nombre) Line ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,abogadoadministrativo.getSolicitud());
            ps.setString(2,abogadoadministrativo.getCertificado());
            ps.setString(3,abogadoadministrativo.getActa());
            ps.setString(4,abogadoadministrativo.getOficio());
            ps.setString(5,abogadoadministrativo.getCircular());
            ps.setString(6,abogadoadministrativo.getCurriculum());

            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                do{
                    Administrativo administrativoObjeto = new Administrativo();
                    administrativoObjeto.setSolicitud(rs.getString(1));
                    administrativoObjeto.setCertificado(rs.getString(2));
                    administrativoObjeto.setActa(rs.getString(3));
                    administrativoObjeto.setCircular(rs.getString(4));
                    administrativoObjeto.setOficio(rs.getString(5));
                    administrativoObjeto.setCurriculum(rs.getString(6));

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
        return ListaAdministrativo;
    }
}

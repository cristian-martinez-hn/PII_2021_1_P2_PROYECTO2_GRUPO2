package Datos.Casos;
import Datos.Conexion.Conexion;
import Recursos.Clases.Casos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CasosDatos {
    public static List<Casos> LeerCasos(){
        List<Casos> ListaCasos = new ArrayList<>();
        try{
            Connection cn = Conexion.obtenerConexion();
            Statement st = cn.createStatement();
            String sql = "SELECT AbogadoLaboralista, AbogadoFamiliar, AbogadoPenalista, AbogadoCiviles, AbogadoAdministrativo FROM Casos";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                Casos casos = new Casos();
                casos.setAbogadoLaboralista(rs.getString(1));
                casos.setAbogadoFamiliar(rs.getString(2));
                casos.setAbogadoPenalista(rs.getString(3));
                casos.setAbogadoCiviles(rs.getString(4));
                casos.setAbogadoAdministrativo(rs.getString(5));
                ListaCasos.add(casos);
            }
            cn.close();
        }catch (Exception e){

        }
        return ListaCasos;
    }
    public static String InsertarCasos(Casos casos){
        try{
            Connection cn = Conexion.obtenerConexion();
            Statement st = cn.createStatement();
            String sql = "INSET INTO Casos VALUES (?,?,?,?) FROM Casos";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,casos.getAbogadoLaboralista());
            ps.setString(2,casos.getAbogadoFamiliar());
            ps.setString(3,casos.getAbogadoPenalista());
            ps.setString(4,casos.getAbogadoCiviles());
            ps.setString(5,casos.getAbogadoAdministrativo());
            ps.execute();
            ps.close();
            cn.close();
        }catch (Exception e){
            e.printStackTrace();
            return "Error: " +e.getMessage();
        }
        return null;
    }
    public static String ActualizarCasos(Casos casos){
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "UPDATE Casos SET AbogadoFamiliar =?, AbogadoPenalista =?, AbogadoCiviles =? , AbogadoAdministrativo =? WHERE AbogadoLaboralista =?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,casos.getAbogadoLaboralista());
            ps.setString(2,casos.getAbogadoFamiliar());
            ps.setString(3,casos.getAbogadoPenalista());
            ps.setString(4,casos.getAbogadoCiviles());
            ps.setString(5,casos.getAbogadoAdministrativo());
            ps.execute();
            ps.close();
            cn.close();
        }catch (Exception e){
            e.printStackTrace();
            return "Error: " +e.getMessage();
        }
        return null;
    }
    public static String EliminarCasos(Casos casos){
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "DELETE FROM Casos WHERE AbogadoLaboralista = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,casos.getAbogadoLaboralista());
            ps.setString(2,casos.getAbogadoFamiliar());
            ps.setString(3,casos.getAbogadoPenalista());
            ps.setString(4,casos.getAbogadoCiviles());
            ps.setString(5,casos.getAbogadoAdministrativo());
            ps.execute();
            ps.close();
            cn.close();
        }catch (Exception e){
            e.printStackTrace();
            return "Error: " +e.getMessage();
        }
        return null;
    }
    public static List<Casos> BuscarCasos(Casos casos) throws SQLException{
        List<Casos> ListaCasos = new ArrayList<Casos>();
        try{
            Connection cn = Conexion.obtenerConexion();
            Statement st = cn.createStatement();
            String sql = "SELECT AbogadoLaboralista, AbogadoFamiliar, AbogadoPenalista, AbogadoCiviles, AbogadoAdministrativo FROM Abogado WHERE UPPER(Nombre) Line ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,casos.getAbogadoLaboralista());
            ps.setString(2,casos.getAbogadoFamiliar());
            ps.setString(3,casos.getAbogadoPenalista());
            ps.setString(4,casos.getAbogadoCiviles());
            ps.setString(5,casos.getAbogadoAdministrativo());
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                do{
                    Casos casosObjeto = new Casos();
                    casosObjeto.setAbogadoLaboralista(rs.getString(1));
                    casosObjeto.setAbogadoFamiliar(rs.getString(2));
                    casosObjeto.setAbogadoPenalista(rs.getString(3));
                    casosObjeto.setAbogadoCiviles(rs.getString(4));
                    casosObjeto.setAbogadoAdministrativo(rs.getString(5));
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
        return ListaCasos;
    }
}

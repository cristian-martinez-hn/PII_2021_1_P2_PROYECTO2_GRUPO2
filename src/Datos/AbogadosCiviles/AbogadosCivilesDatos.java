package Datos.AbogadosCiviles;
import Datos.Conexion.Conexion;
import Recursos.Clases.Civiles;
import Recursos.Clases.Laboralistas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AbogadosCivilesDatos {
    public static List<Civiles> LeerCiviles(){
        List<Civiles> ListaAbogadosCiviles = new ArrayList<Civiles>();
        try{
            Connection cn = Conexion.obtenerConexion();
            Statement st = cn.createStatement();
            String sql = "SELECT Manutenciones, Incapacitaciones, Impago, AcosoLaboralMobbing, NegociacionConveniosColectivos, AsesoramientoDerechoLaboral FROM AbogadoLaboralista";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                Civiles abogadosciviles = new Civiles();
                abogadosciviles.setManutenciones(rs.getString(1));
                abogadosciviles.setIncapacitaciones(rs.getString(2));
                abogadosciviles.setHerenciasSucesiones(rs.getString(3));
                abogadosciviles.setReclamoDeudas(rs.getString(4));
                ListaAbogadosCiviles.add(abogadosciviles);
            }
            cn.close();
        }catch (Exception e){

        }
        return ListaAbogadosCiviles;
    }
    public static String InsertarAbogadosCiviles(Civiles abogadosciviles){
        try{
            Connection cn = Conexion.obtenerConexion();
            Statement st = cn.createStatement();
            String sql = "INSET INTO AbogadosCiviles VALUES (?,?,?,?) FROM AbogadosCiviles";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,abogadosciviles.getManutenciones());
            ps.setString(2,abogadosciviles.getIncapacitaciones());
            ps.setString(3,abogadosciviles.getHerenciasSucesiones());
            ps.setString(4,abogadosciviles.getReclamoDeudas());
            ps.execute();
            ps.close();
            cn.close();
        }catch (Exception e){
            e.printStackTrace();
            return "Error: " +e.getMessage();
        }
        return null;
    }
    public static String ActualizarAbogadosCiviles(Civiles abogadosciviles){
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "UPDATE AbogadosCiviles SET Manutenciones =?, Incapacitaciones =?, HerenciasSucesiones =? WHERE ReclamoDeudas =?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,abogadosciviles.getManutenciones());
            ps.setString(2,abogadosciviles.getIncapacitaciones());
            ps.setString(3,abogadosciviles.getHerenciasSucesiones());
            ps.setString(4,abogadosciviles.getReclamoDeudas());
            ps.execute();
            ps.close();
            cn.close();
        }catch (Exception e){
            e.printStackTrace();
            return "Error: " +e.getMessage();
        }
        return null;
    }
    public static String EliminarAbogadosCiviles(Civiles abogadosciviles){
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "DELETE FROM AbogadosCiviles WHERE ReclamoDeudas = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,abogadosciviles.getManutenciones());
            ps.setString(2,abogadosciviles.getIncapacitaciones());
            ps.setString(3,abogadosciviles.getHerenciasSucesiones());
            ps.setString(4,abogadosciviles.getReclamoDeudas());
            ps.execute();
            ps.close();
            cn.close();
        }catch (Exception e){
            e.printStackTrace();
            return "Error: " +e.getMessage();
        }
        return null;
    }
    public static List<Civiles> BuscarAbogadosCiviles(Civiles abogadosciviles) throws SQLException{
        List<Civiles> ListaAbogadosCiviles = new ArrayList<Civiles>();
        try{
            Connection cn = Conexion.obtenerConexion();
            Statement st = cn.createStatement();
            String sql = "SELECT Manutenciones, Incapacitaciones, HerenciasSucesiones FROM AbogadosCiviles WHERE UPPER(Nombre) Line ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setLong(1, Long.parseLong("%" +abogadosciviles.getReclamoDeudas().toUpperCase()+ "%"));
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                do{
                    Civiles abogadoscivilesObjeto = new Civiles();
                    abogadoscivilesObjeto.setManutenciones(rs.getString(1));
                    abogadoscivilesObjeto.setIncapacitaciones(rs.getString(2));
                    abogadoscivilesObjeto.setHerenciasSucesiones(rs.getString(3));
                    abogadoscivilesObjeto.setReclamoDeudas(rs.getString(4));
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
        return ListaAbogadosCiviles;
    }
}

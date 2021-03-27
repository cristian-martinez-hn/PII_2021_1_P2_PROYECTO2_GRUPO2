package Datos.AbogadoLaboralista;
import Datos.Conexion.Conexion;
import Recursos.Clases.Laboralistas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AbogadoLaboralistaDatos {
    public static List<Laboralistas> LeerLaboralistas(){
        List<Laboralistas> ListaAbogadoLaboralista = new ArrayList<Laboralistas>();
        try{
            Connection cn = Conexion.obtenerConexion();
            Statement st = cn.createStatement();
            String sql = "SELECT Despidos, AccidentesDeTrabajo, Impago, AcosoLaboralMobbing, NegociacionConveniosColectivos, AsesoramientoDerechoLaboral FROM AbogadoLaboralista";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                Laboralistas abogadolaboralista = new Laboralistas();
                abogadolaboralista.setDespidos(rs.getString(1));
                abogadolaboralista.setAccidentesDeTrabajo(rs.getString(2));
                abogadolaboralista.setImpago(rs.getString(3));
                abogadolaboralista.setAcosoLaboralMobbing(rs.getString(4));
                abogadolaboralista.setNegociacionConveniosColectivos(rs.getString(5));
                abogadolaboralista.setAsesoramientoDerechoLaboral(rs.getString(6));
                ListaAbogadoLaboralista.add(abogadolaboralista);
            }
            cn.close();
        }catch (Exception e){

        }
        return ListaAbogadoLaboralista;
    }
    public static String InsertarAbogadoLaboralista(Laboralistas abogadolaboralista){
        try{
            Connection cn = Conexion.obtenerConexion();
            Statement st = cn.createStatement();
            String sql = "INSET INTO AbogadoLaboralista VALUES (?,?,?,?) FROM AbogadoLaboralista";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,abogadolaboralista.getDespidos());
            ps.setString(2,abogadolaboralista.getAccidentesDeTrabajo());
            ps.setString(3,abogadolaboralista.getImpago());
            ps.setString(4,abogadolaboralista.getAcosoLaboralMobbing());
            ps.setString(5,abogadolaboralista.getNegociacionConveniosColectivos());
            ps.setString(6,abogadolaboralista.getAsesoramientoDerechoLaboral());
            ps.execute();
            ps.close();
            cn.close();
        }catch (Exception e){
            e.printStackTrace();
            return "Error: " +e.getMessage();
        }
        return null;
    }
    public static String ActualizarAbogadoLaboralista(Laboralistas abogadolaboralista){
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "UPDATE AbogadoLaborista SET AccidentesDeTrabajo =?, Impago =?, AcosoLaboralMobbing =?, NegociacionConveniosColectivos =?, AsesoramientoDerechoLaboral =? WHERE Despidos =?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,abogadolaboralista.getDespidos());
            ps.setString(2,abogadolaboralista.getAccidentesDeTrabajo());
            ps.setString(3,abogadolaboralista.getImpago());
            ps.setString(4,abogadolaboralista.getAcosoLaboralMobbing());
            ps.setString(5,abogadolaboralista.getNegociacionConveniosColectivos());
            ps.setString(6,abogadolaboralista.getAsesoramientoDerechoLaboral());
            ps.execute();
            ps.close();
            cn.close();
        }catch (Exception e){
            e.printStackTrace();
            return "Error: " +e.getMessage();
        }
        return null;
    }
    public static String EliminarAbogadoLaboralista(Laboralistas abogadolaboralista){
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "DELETE FROM AbogadoLaboralista WHERE Despidos = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,abogadolaboralista.getDespidos());
            ps.setString(2,abogadolaboralista.getAccidentesDeTrabajo());
            ps.setString(3,abogadolaboralista.getImpago());
            ps.setString(4,abogadolaboralista.getAcosoLaboralMobbing());
            ps.setString(5,abogadolaboralista.getNegociacionConveniosColectivos());
            ps.setString(6,abogadolaboralista.getAsesoramientoDerechoLaboral());
            ps.execute();
            ps.close();
            cn.close();
        }catch (Exception e){
            e.printStackTrace();
            return "Error: " +e.getMessage();
        }
        return null;
    }
    public static List<Laboralistas> BuscarAbogadoLaboralista(Laboralistas abogadolaboralista) throws SQLException{
        List<Laboralistas> ListaAbogadoLaboralista = new ArrayList<Laboralistas>();
        try{
            Connection cn = Conexion.obtenerConexion();
            Statement st = cn.createStatement();
            String sql = "SELECT Despidos, AccidentesDeTrabajo, Impago FROM AbogadoLaboralista WHERE UPPER(Nombre) Line ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setLong(1, Long.parseLong("%" +abogadolaboralista.getDespidos().toUpperCase()+ "%"));
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                do{
                    Laboralistas abogadolaboralistaObjeto = new Laboralistas();
                    abogadolaboralistaObjeto.setDespidos(rs.getString(1));
                    abogadolaboralistaObjeto.setAccidentesDeTrabajo(rs.getString(2));
                    abogadolaboralistaObjeto.setImpago(rs.getString(3));
                    abogadolaboralistaObjeto.setAcosoLaboralMobbing(rs.getString(4));
                    abogadolaboralistaObjeto.setNegociacionConveniosColectivos(rs.getString(5));
                    abogadolaboralistaObjeto.setAsesoramientoDerechoLaboral(rs.getString(6));
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
        return ListaAbogadoLaboralista;
    }
}

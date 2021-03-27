package Datos.Clientes;
import Datos.Conexion.Conexion;
import Recursos.Clases.Cliente;
import Recursos.Clases.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDatos {
    public static List<Cliente> LeerCliente(){
        List<Cliente> ListaCliente = new ArrayList<Cliente>();
        try{
            Connection cn = Conexion.obtenerConexion();
            Statement st = cn.createStatement();
            String sql = "SELECT Nombre, Id, FechaNacimiento FROM Cliente";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                Cliente cliente = new Cliente();
                cliente.setNombre(rs.getString(1));
                cliente.setId(rs.getLong(2));
                cliente.setFechaNacimiento(rs.getDate(3));
                ListaCliente.add(cliente);
            }
            cn.close();
        }catch (Exception e){

        }
        return ListaCliente;
    }
    public static String InsertarCliente(Cliente cliente){
        try{
            Connection cn = Conexion.obtenerConexion();
            Statement st = cn.createStatement();
            String sql = "INSET INTO Cliente VALUES (?,?,?,?) FROM Cliente";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,cliente.getNombre());
            ps.setLong(2,cliente.getId());
            ps.setDate(3,new java.sql.Date(cliente.getFechaNacimiento().getTime()));
            ps.execute();
            ps.close();
            cn.close();
        }catch (Exception e){
            e.printStackTrace();
            return "Error: " +e.getMessage();
        }
        return null;
    }
    public static String ActualizarCliente(Cliente cliente){
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "UPDATE Abogado SET Nombre =?, FechaNacimiento =? WHERE Id =?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,cliente.getNombre());
            ps.setLong(2,cliente.getId());
            ps.setDate(3,new java.sql.Date(cliente.getFechaNacimiento().getTime()));
            ps.execute();
            ps.close();
            cn.close();
        }catch (Exception e){
            e.printStackTrace();
            return "Error: " +e.getMessage();
        }
        return null;
    }
    public static String EliminarCliente(Cliente cliente){
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "DELETE FROM Cliente WHERE Id = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,cliente.getNombre());
            ps.setLong(2,cliente.getId());
            ps.setDate(3,new java.sql.Date(cliente.getFechaNacimiento().getTime()));
            ps.execute();
            ps.close();
            cn.close();
        }catch (Exception e){
            e.printStackTrace();
            return "Error: " +e.getMessage();
        }
        return null;
    }
    public static List<Cliente> BuscarCliente(Cliente cliente) throws SQLException{
        List<Cliente> ListaCliente = new ArrayList<Cliente>();
        try{
            Connection cn = Conexion.obtenerConexion();
            Statement st = cn.createStatement();
            String sql = "SELECT Id, Nombre, FechaNacimiento FROM Abogado WHERE UPPER(Nombre) Line ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setLong(1,   +cliente.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                do{
                    Cliente clienteObjeto = new Cliente();
                    clienteObjeto.setNombre(rs.getString(1));
                    clienteObjeto.setId(rs.getLong(2));
                    clienteObjeto.setFechaNacimiento(rs.getDate(3));
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
        return ListaCliente;
    }

}

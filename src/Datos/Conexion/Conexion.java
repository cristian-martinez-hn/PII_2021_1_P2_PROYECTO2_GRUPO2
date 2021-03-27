package Datos.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private static final String USUARIO = "sa";
    private static final String CLAVE = "Diosguiamispasos";
    public static Connection obtenerConexion(){
        try{
            String URL = "jdbc:sqlserver://192.168.1.6:1433:databaseName=PII_2021_1_P2_PROYECTO2";
            Connection cn = DriverManager.getConnection(URL,USUARIO,CLAVE);
            return cn;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

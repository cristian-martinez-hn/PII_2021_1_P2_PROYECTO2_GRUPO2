package Recursos.Clases;
import java.util.Date;

public class Abogados {
    private long Id;
    private String Nombre;
    private Date FechaNacimiento;
    private String Domicilio;

    public Abogados(){

    }
    public Abogados(long Id, String Nombre, Date FechaNacimiento, String Domicilio){
        this.Id = Id;
        this.Nombre = Nombre;
        this.FechaNacimiento = FechaNacimiento;
        this.Domicilio = Domicilio;
    }

    public long getId(){
        return Id;
    }
    public void setId(long Id){
        this.Id = Id;
    }

    public String getNombre(){
        return Nombre;
    }
    public void setNombre(String Nombre){
        this.Nombre = Nombre;
    }

    public Date getFechaNacimiento(){
        return FechaNacimiento;
    }
    public void setFechaNacimiento(Date FechaNacimiento){
        this.FechaNacimiento = FechaNacimiento;
    }

    public String getDomicilio(){
        return Domicilio;
    }
    public void setDomicilio(String Domicilio){
        this.Domicilio = Domicilio;
    }
}

package Recursos.Clases;

import java.util.Date;

public class Cliente {
    private String Nombre;
    private long Id;
    private Date FechaNacimiento;
    public Cliente(){

    }
    public Cliente(String Nombre, long Id, Date FechaNacimiento){
        this.Nombre = Nombre;
        this.Id = Id;
        this.FechaNacimiento = FechaNacimiento;

    }

    public String getNombre(){
        return Nombre;
    }
    public void setNombre(String Nombre){
        this.Nombre = Nombre;
    }

    public long getId(){ return Id; }
    public void setId(long Id){ this.Id = Id; }

    public Date getFechaNacimiento(){
        return FechaNacimiento;
    }
    public void setFechaNacimiento(Date FechaNacimiento){
        this.FechaNacimiento = FechaNacimiento;
    }

}

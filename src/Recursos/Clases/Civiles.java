package Recursos.Clases;

public class Civiles {
    private String Manutenciones;
    private String Incapacitaciones;
    private String HerenciasSucesiones;
    private String ReclamoDeudas;
    public Civiles(){

    }
    public Civiles(String Manutenciones, String Incapacitaciones, String HerenciasSucesiones, String ReclamoDeudas){
        this.Manutenciones = Manutenciones;
        this.Incapacitaciones = Incapacitaciones;
        this.HerenciasSucesiones = HerenciasSucesiones;
        this.ReclamoDeudas = ReclamoDeudas;


    }

    public String getManutenciones(){
        return Manutenciones;
    }
    public void setManutenciones(String Manutenciones){
        this.Manutenciones = Manutenciones;
    }

    public String getIncapacitaciones(){ return Incapacitaciones; }
    public void setIncapacitaciones(String CIncapacitaciones){ this.Incapacitaciones = Incapacitaciones; }

    public String getHerenciasSucesiones(){
        return HerenciasSucesiones;
    }
    public void setHerenciasSucesiones(String HerenciasSucesiones){
        this.HerenciasSucesiones = HerenciasSucesiones;
    }

    public String getReclamoDeudas(){
        return ReclamoDeudas;
    }
    public void setReclamoDeudas(String ReclamoDeudas){ this.ReclamoDeudas = ReclamoDeudas; }


}

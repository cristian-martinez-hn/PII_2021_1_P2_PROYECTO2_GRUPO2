package Recursos.Clases;

public class Laboralistas {
    private String Despidos;
    private String AccidentesDeTrabajo;
    private String Impago;
    private String AcosoLaboralMobbing;
    private String NegociacionConveniosColectivos;
    private String AsesoramientoDerechoLaboral;
    public Laboralistas(){

    }
    public Laboralistas(String Despidos, String AccidentesDeTrabajo, String Impago, String AcosoLaboralMobbing,String NegociacionConveniosColectivos,String AsesoramientoDerechoLaboral){
        this.Despidos = Despidos;
        this.AccidentesDeTrabajo = AccidentesDeTrabajo;
        this.Impago = Impago;
        this.AcosoLaboralMobbing = AcosoLaboralMobbing;
        this.NegociacionConveniosColectivos = NegociacionConveniosColectivos;
        this.AsesoramientoDerechoLaboral = AsesoramientoDerechoLaboral;

    }

    public String getDespidos(){
        return Despidos;
    }
    public void setDespidos(String Despidos){
        this.Despidos = Despidos;
    }

    public String getAccidentesDeTrabajo(){ return AccidentesDeTrabajo; }
    public void setAccidentesDeTrabajo(String AccidentesDeTrabajo){ this.AccidentesDeTrabajo = AccidentesDeTrabajo; }

    public String getImpago(){
        return Impago;
    }
    public void setImpago(String Impago){
        this.Impago = Impago;
    }

    public String getAcosoLaboralMobbing(){
        return AcosoLaboralMobbing;
    }
    public void setAcosoLaboralMobbing(String AcosoLaboralMobbing){ this.AcosoLaboralMobbing = AcosoLaboralMobbing; }

    public String getNegociacionConveniosColectivos(){
        return NegociacionConveniosColectivos;
    }
    public void setNegociacionConveniosColectivos(String NegociacionConveniosColectivos){ this.NegociacionConveniosColectivos = NegociacionConveniosColectivos; }

    public String getAsesoramientoDerechoLaboral(){
        return AsesoramientoDerechoLaboral;
    }
    public void setAsesoramientoDerechoLaboral(String AsesoramientoDerechoLaboral){ this.AsesoramientoDerechoLaboral = AsesoramientoDerechoLaboral; }
}

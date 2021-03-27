package Recursos.Clases;

public class Familiar {
    private String Divorcio;
    private String CustodiaDeHijos;
    private String PencionAlimenticia;
    private String AcuerdoPrematrimoniales;
    private String LiquidacionHerencia;
    private String Tutela;
    public Familiar(){

    }
    public Familiar(String Divorcio, String CustodiaDeHijos, String PencionAlimenticia, String AcuerdoPrematrimoniales,String LiquidacionHerencia,String Tutela){
        this.Divorcio = Divorcio;
        this.CustodiaDeHijos = CustodiaDeHijos;
        this.PencionAlimenticia = PencionAlimenticia;
        this.AcuerdoPrematrimoniales = AcuerdoPrematrimoniales;
        this.LiquidacionHerencia = LiquidacionHerencia;
        this.Tutela = Tutela;

    }

    public String getDivorcio(){
        return Divorcio;
    }
    public void setDivorcio(String Divorcio){
        this.Divorcio = Divorcio;
    }

    public String getCustodiaDeHijos(){ return CustodiaDeHijos; }
    public void setCustodiaDeHijos(String CustodiaDeHijos){ this.CustodiaDeHijos = CustodiaDeHijos; }

    public String getPencionAlimenticia(){
        return PencionAlimenticia;
    }
    public void setPencionAlimenticia(String PencionAlimenticia){
        this.PencionAlimenticia = PencionAlimenticia;
    }

    public String getAcuerdoPrematrimoniales(){
        return AcuerdoPrematrimoniales;
    }
    public void setAcuerdoPrematrimoniales(String AcuerdoPrematrimoniales){ this.AcuerdoPrematrimoniales = AcuerdoPrematrimoniales; }

    public String getLiquidacionHerencia(){
        return LiquidacionHerencia;
    }
    public void setLiquidacionHerencia(String LiquidacionHerencia){
        this.LiquidacionHerencia = LiquidacionHerencia;
    }

    public String getTutela(){
        return Tutela;
    }
    public void setTutela(String Tutela){
        this.Tutela = Tutela;
    }

}

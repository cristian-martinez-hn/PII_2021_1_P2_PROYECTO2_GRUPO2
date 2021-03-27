package Recursos.Clases;

public class Casos {
    private String AbogadoLaboralista;
    private String AbogadoFamiliar;
    private String AbogadoPenalista;
    private String AbogadoCiviles;
    private String AbogadoAdministrativo;
    public Casos(){

    }
    public Casos(String AbogadoLaboralisa, String AbogadoFamiliar, String AbogadoPenalista, String AbogadoCiviles, String AbogadoAdministrativo){
        this.AbogadoLaboralista = AbogadoLaboralisa;
        this.AbogadoFamiliar = AbogadoFamiliar;
        this.AbogadoPenalista = AbogadoPenalista;
        this.AbogadoCiviles = AbogadoCiviles;
        this.AbogadoAdministrativo = AbogadoAdministrativo;


    }

    public String getAbogadoLaboralista(){
        return AbogadoLaboralista;
    }
    public void setAbogadoLaboralista(String AbogadoLaboralista){
        this.AbogadoLaboralista = AbogadoLaboralista;
    }

    public String getAbogadoFamiliar(){ return AbogadoFamiliar; }
    public void setAbogadoFamiliar(String AbogadoFamiliar){ this.AbogadoFamiliar = AbogadoFamiliar; }

    public String getAbogadoPenalista(){
        return AbogadoPenalista;
    }
    public void setAbogadoPenalista(String AbogadoPenalista){
        this.AbogadoPenalista = AbogadoPenalista;
    }

    public String getAbogadoCiviles(){
        return AbogadoCiviles;
    }
    public void setAbogadoCiviles(String AbogadoCiviles){ this.AbogadoCiviles = AbogadoCiviles; }

    public String getAbogadoAdministrativo(){
        return AbogadoAdministrativo;
    }
    public void setAbogadoAdministrativo(String AbogadoAdministrativo){ this.AbogadoAdministrativo = AbogadoCiviles; }
}

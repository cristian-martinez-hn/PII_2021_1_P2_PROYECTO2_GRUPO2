package Recursos.Clases;

public class Penalista {
    private  String   PersonasYVida;
    private  String   ContraPatrimonio;
    private  String   DelitoEconomico;

    public Penalista(String PersonaYVida, String ContraPatrimonio, String DelitoEconomico, String ContraAdministracion){
        this.PersonasYVida         = PersonaYVida;
        this.ContraPatrimonio      = ContraPatrimonio;
        this.DelitoEconomico       = DelitoEconomico;

    }

    public String getPersonasYVida(){
        return PersonasYVida;
    }

    public void setPersonasYVida(String personasYVida) {
        this.PersonasYVida = personasYVida;
    }

    public String getContraPatrimononio(){
        return ContraPatrimonio;
    }
    public void setContraPatrimonio(String ContraPatrimonio){
        this.ContraPatrimonio = ContraPatrimonio;
    }


    public String getDelitoEconomico(){
        return DelitoEconomico;
    }
    public void setDelitoEconomico(String DelitoEconomico){
        this.DelitoEconomico = DelitoEconomico;
    }
}

package Recursos.Clases;

public class Agenda {
    private long NumeroJuicios;
    private String Citas;
    private String NombreClientes;

    public Agenda(){
    }

    public Agenda(long NumeroJuicios, String Citas, String NombreClientes) {
        this.NumeroJuicios = NumeroJuicios;
        this.Citas = Citas;
        this.NombreClientes = NombreClientes;
    }

    public long  getNumeroJuicios() {
        return NumeroJuicios;
    }

    public void setNumeroJuicios(long NumeroJuicio) {
        this.NumeroJuicios = NumeroJuicio;
    }

    public String getCitas() {
        return Citas;
    }

    public void setCitas(String Citas) {
        this.Citas = Citas;
    }

    public String getNombreClientes() {
        return NombreClientes;
    }

    public void setNombreClientes(String NombreClientes) {
        this.NombreClientes = NombreClientes;
    }
}

package Recursos.Clases;

public class Administrativo {
    private String Solicitud;
    private String Certificado;
    private String Acta;
    private String Circular;
    private String Oficio;
    private String Curriculum;

    public Administrativo(){
    }

    public Administrativo(String Solicitud, String Certificado, String Acta, String Circular, String Oficio, String Curriculum){
        this.Solicitud   = Solicitud;
        this.Certificado = Certificado;
        this.Acta        = Acta;
        this.Circular    = Circular;
        this.Oficio      = Oficio;
        this.Curriculum  = Curriculum;
    }

    public String getSolicitud() {
        return Solicitud;
    }

    public void setSolicitud(String solicitud) {
        Solicitud = solicitud;
    }

    public String getCertificado() {
        return Certificado;
    }

    public void setCertificado(String certificado) {
        Certificado = certificado;
    }

    public String getActa() {
        return Acta;
    }

    public void setActa(String Acta) {
        Acta = Acta;
    }

    public String getCircular() {
        return Circular;
    }

    public void setCircular(String circular) {
        Circular = circular;
    }

    public String getOficio() {
        return Oficio;
    }

    public void setOficio(String oficio) {
        Oficio = oficio;
    }

    public String getCurriculum() {
        return Curriculum;
    }

    public void setCurriculum(String curriculum) {
        Curriculum = curriculum;
    }
}

package model;

public class Valor {
    private int id;
    private double multa;
    private double limiteLivros;
    private double prazo;

    public Valor(int id, double multa, double limiteLivros, double prazo) {
        this.id = id;
        this.multa = multa;
        this.limiteLivros = limiteLivros;
        this.prazo = prazo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    public double getLimiteLivros() {
        return limiteLivros;
    }

    public void setLimiteLivros(double limiteLivros) {
        this.limiteLivros = limiteLivros;
    }

    public double getPrazo() {
        return prazo;
    }

    public void setPrazo(double prazo) {
        this.prazo = prazo;
    }
            
}

package model.bean;

public class Acervo {
    
    private int id, ano, estante, prateleira, status;
    private String titulo, editora;
    
    
    public Acervo(){}

    public Acervo(int id, int ano, int estante, int prateleira, int status, String titulo, String editora) {
        this.id = id;
        this.ano = ano;
        this.estante = estante;
        this.prateleira = prateleira;
        this.status = status;
        this.titulo = titulo;
        this.editora = editora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getEstante() {
        return estante;
    }

    public void setEstante(int estante) {
        this.estante = estante;
    }

    public int getPrateleira() {
        return prateleira;
    }

    public void setPrateleira(int prateleira) {
        this.prateleira = prateleira;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }
    
    
    
    
}

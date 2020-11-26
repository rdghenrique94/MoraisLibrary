package model;

public class Livros {
    
    private String titulo, editora, setor;
    private int ano;
    private char prateleira;
    private boolean status; 

    public Livros(String titulo, String editora, String setor, int ano, char prateleira, boolean status) {
        this.titulo = titulo;
        this.editora = editora;
        this.setor = setor;
        this.ano = ano;
        this.prateleira = prateleira;
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

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public char getPrateleira() {
        return prateleira;
    }

    public void setPrateleira(char prateleira) {
        this.prateleira = prateleira;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
    
}

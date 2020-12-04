package model.bean;

public class Acervo {
    
    private int id, ano, status;
    private String titulo, editora, estante, prateleira;
    
    
    public Acervo(){
        this.id = -1;
        this.titulo = "Sem Titulo";
        this.editora = "Sem Autor";
    }  

    public Acervo(int id, int ano, int status, String titulo, String editora, String estante, String prateleira) {
        this.id = id;
        this.ano = ano;
        this.status = status;
        this.titulo = titulo;
        this.editora = editora;
        this.estante = estante;
        this.prateleira = prateleira;
    }

    public String getEstante() {
        return estante;
    }

    public void setEstante(String estante) {
        this.estante = estante;
    }

    public String getPrateleira() {
        return prateleira;
    }

    public void setPrateleira(String prateleira) {
        this.prateleira = prateleira;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setId(String id){
        if(this.id==-1){
            this.id = Integer.parseInt(id);
        }
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
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

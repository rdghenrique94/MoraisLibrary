package model;

public class Pessoa {
    
    private String nome;
    private String senha;
    private Double matricula;
    
    public Pessoa(){
        
    }

    public Pessoa(String nome, String senha, Double matricula) {
        this.nome = nome;
        this.senha = senha;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Double getMatricula() {
        return matricula;
    }

    public void setMatricula(Double matricula) {
        this.matricula = matricula;
    }
}


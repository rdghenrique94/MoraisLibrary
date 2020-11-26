package model;

public class Pessoa {
    
    private String nome;
    private int cpf;
    private double matricula;
    

    public Pessoa(String nome, int cpf, double matricula) {
        this.nome = nome;
        this.cpf = cpf;
        this.matricula = matricula;
        
    }
    
    public Pessoa(){
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public double getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString(){
        return "Nome: "+this.nome+", CPF: "+this.cpf;
    }

   
}


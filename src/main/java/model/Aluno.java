package model;

public class Aluno extends Pessoa {
    
 private Valor valor;
 private double aluno;

    public Aluno(Valor valor) {
        this.valor = valor;
    }

    public Aluno(Valor valor, String nome, String senha, Double matricula) {
        super(nome, senha, matricula);
        this.valor = valor;
    }
    public void valorMulta(){
        if (valor.getPrazo() > 2){
            this.aluno = valor.getMulta() *2;
        }
    }

    public Valor getValor() {
        return valor;
    }

    public void setValor(Valor valor) {
        this.valor = valor;
    }
    
}
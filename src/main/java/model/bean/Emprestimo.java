package model.bean;

import model.*;

public class Emprestimo {
    
    private int id;
    private Acervo titulo;
    private Pessoa matricula;
    private Acervo funcao;
    private String dataEmprestimo;
    private String dataDevolvido;

    public Emprestimo(int id, Acervo titulo, model.bean.Pessoa matricula, Acervo funcao, String dataEmprestimo, String dataDevolvido) {
        this.id = id;
        this.titulo = titulo;
        this.matricula = matricula;
        this.funcao = funcao;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolvido = dataDevolvido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Acervo getTitulo() {
        return titulo;
    }

    public void setTitulo(Acervo titulo) {
        this.titulo = titulo;
    }

    public model.bean.Pessoa getMatricula() {
        return matricula;
    }

    public void setMatricula(model.bean.Pessoa matricula) {
        this.matricula = matricula;
    }

    public Acervo getFuncao() {
        return funcao;
    }

    public void setFuncao(Acervo funcao) {
        this.funcao = funcao;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public String getDataDevolvido() {
        return dataDevolvido;
    }

    public void setDataDevolvido(String dataDevolvido) {
        this.dataDevolvido = dataDevolvido;
    }

   
    
            
}

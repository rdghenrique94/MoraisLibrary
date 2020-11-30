package model.bean;

public class Pessoa {

    private int id;
    private String nome;
    private String cpf;
    private String matricula;
    private String curso;
    private String psw;
    private int funcao;

    public Pessoa(){}
    
    public Pessoa(int id, String nome, String cpf, String matricula, String curso, String psw, int funcao) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.matricula = matricula;
        this.curso = curso;
        this.psw = psw;
        this.funcao = funcao;
    }
    
    
    public Pessoa(String nome, String cpf, String matricula, String curso, String psw, int funcao) {
        
        this.nome = nome;
        this.cpf = cpf;
        this.matricula = matricula;
        this.curso = curso;
        this.psw = psw;
        this.funcao = funcao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public int getFuncao() {
        return funcao;
    }

    public void setFuncao(int funcao) {
        this.funcao = funcao;
    }
    public String toString(){
        return "Nome: "+this.nome+", CPF: "+this.cpf+", Matricula: "+this.matricula+", Curso: "+this.curso+" PSW: "+this.psw+""
                + ", Função: "+this.funcao;
    }

  
  

    

   
}


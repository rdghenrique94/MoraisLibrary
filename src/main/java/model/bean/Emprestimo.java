package model.bean;

public class Emprestimo {
    
    private int id;
    private String matricula;
    private String titulo;
    private int funcao;
    private String dataEmprestimo;
    private String dataDevolucao;
    private int status;
    
    public Emprestimo(){
        
    }

    public Emprestimo(int id, String titulo, String matricula, int funcao, String dataEmprestimo, String dataDevolucao, int status) {
        this.id = id;
        this.titulo = titulo;
        this.matricula = matricula;
        this.funcao = funcao;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getFuncao() {
        return funcao;
    }

    public void setFuncao(int funcao) {
        this.funcao = funcao;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    

   
    
            
}

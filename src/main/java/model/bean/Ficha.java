/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author rodri
 */
public class Ficha {
    
    private int id;
    private String nome;
    private String titulo;
    private int ano;
    private String curso;
    private String tipoTrabalho;
    private int status;
    
    public Ficha(){}

    public Ficha(int id, String nome, String titulo, int ano, String curso, String tipoTrabalho, int status) {
        this.id = id;
        this.nome = nome;
        this.titulo = titulo;
        this.ano = ano;
        this.curso = curso;
        this.tipoTrabalho = tipoTrabalho;
        this.status = status;
    }
    
    
    public Ficha(int id, String nome, String titulo, int ano, String curso, String tipoTrabalho) {
        this.id = id;
        this.nome = nome;
        this.titulo = titulo;
        this.ano = ano;
        this.curso = curso;
        this.tipoTrabalho = tipoTrabalho;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipoTrabalho() {
        return tipoTrabalho;
    }

    public void setTipoTrabalho(String tipoTrabalho) {
        this.tipoTrabalho = tipoTrabalho;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}

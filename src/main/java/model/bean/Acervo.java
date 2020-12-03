package model.bean;

import database.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Acervo {
    
    private int id, ano, estante, prateleira, status;
    private String titulo, editora;
    
    
    public Acervo(){
        this.id = -1;
        this.titulo = "Sem Titulo";
        this.editora = "Sem Autor";
    }  

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

//    public boolean emprestar(String nome, String matricula){
//        this.salvar();
//        Aluguel aluguel = new Aluguel();
//        return acervo.salvar();
//    }
    public static Acervo getAcervo(String id){
        
        try(Connection conn = DataBase.connect();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM ACERVO WHERE id="+id+" LIMIT 1");) {
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                Acervo acervo = new Acervo();
                acervo.setId(rs.getString("ID"));
                acervo.setTitulo(rs.getString("TITULO"));
                acervo.setAno(rs.getInt("ANO"));
                acervo.setEstante(rs.getInt("ESTANTE"));
                acervo.setPrateleira(rs.getInt("PRATELEIRA"));
                acervo.setStatus(rs.getInt("STATUS"));
                return acervo;
            }
            else{
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Acervo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static Acervo getAcervo(int id){
        
        try(Connection conn = DataBase.connect();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM ACERVO WHERE id="+id+" LIMIT 1");) {
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                Acervo acervo = new Acervo();
                acervo.setId(rs.getInt("ID"));
                acervo.setTitulo(rs.getString("TITULO"));
                acervo.setAno(rs.getInt("ANO"));
                acervo.setEstante(rs.getInt("ESTANTE"));
                acervo.setPrateleira(rs.getInt("PRATELEIRA"));
                acervo.setStatus(rs.getInt("STATUS"));
                return acervo;
            }
            else{
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Acervo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    
   
}

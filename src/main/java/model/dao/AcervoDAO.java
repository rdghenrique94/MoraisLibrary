/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import database.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.Acervo;
import model.bean.Pessoa;

/**
 *
 * @author rodri
 */
public class AcervoDAO {
    DataBase app = new DataBase();
    
    public void create(Acervo ac){
        
        app.insertT_Acervo(ac.getTitulo(), ac.getEditora(), ac.getAno(), ac.getEstante(), ac.getPrateleira(), ac.getStatus());
    }
    public void update(Acervo ac){
        
        app.updateT_Acervo(ac.getId(), ac.getTitulo(), ac.getEditora(), ac.getAno(), ac.getEstante(), ac.getPrateleira());
    }
    public void delete(Acervo ac){
        
        app.deleteT_Acervo(ac.getId(), ac.getAno());
    }
    public List<Acervo> read(){
        
        List<Acervo> acervos = new ArrayList<>();
        
        try (Connection conn = DataBase.connect();
            PreparedStatement pstmt = conn.prepareStatement("SELECT *FROM ACERVO")){
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                Acervo acervo = new Acervo();
                acervo.setId(rs.getInt("ID_ACERVO"));
                acervo.setTitulo(rs.getString("TITULO"));
                acervo.setEditora(rs.getString("EDITORA"));
                acervo.setAno(rs.getInt("ANO"));
                acervo.setEstante(rs.getInt("ESTANTE"));
                acervo.setPrateleira(rs.getInt("PRATELEIRA"));
                acervo.setStatus(rs.getInt("STATUS"));
                
                acervos.add(acervo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return acervos;
    }
    }         


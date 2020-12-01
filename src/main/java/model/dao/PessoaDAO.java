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
import model.bean.Pessoa;

/**
 *
 * @author rodri
 */
public class PessoaDAO {
    DataBase app = new DataBase();
    
    public void create(Pessoa p){
        
        app.insertT_Pessoa(p.getNome(), p.getCpf(), p.getMatricula(), p.getCurso(), p.getPsw(), p.getFuncao());
    }
    public void update(Pessoa p){
        
        app.updateT_Pessoa(p.getNome(), p.getCpf(), p.getMatricula(), p.getCurso(), p.getPsw(), p.getId());
    }
    public void delete(Pessoa p){
        
        app.deleteT_Pessoa(p.getMatricula());
    }
    public List<Pessoa> read(){
        
        List<Pessoa> pessoas = new ArrayList<>();
        
        try (Connection conn = DataBase.connect();
            PreparedStatement pstmt = conn.prepareStatement("SELECT *FROM PESSOA")){
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                Pessoa pessoa = new Pessoa();
                pessoa.setId(rs.getInt("ID"));
                pessoa.setNome(rs.getString("NOME"));
                pessoa.setCpf(rs.getString("CPF"));
                pessoa.setMatricula(rs.getString("MATRICULA"));
                pessoa.setCurso(rs.getString("CURSO"));
                pessoa.setPsw(rs.getString("PSW"));
                pessoa.setFuncao(rs.getInt("FUNCAO"));
                pessoas.add(pessoa);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pessoas;
    }
    }         
        
    
    
    

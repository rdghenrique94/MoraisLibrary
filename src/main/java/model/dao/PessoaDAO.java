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
    
    public void create(Pessoa p){
        
        DataBase app = new DataBase();
        app.insertT_Pessoa(p.getNome(), p.getCpf(), p.getMatricula(), p.getCurso(), p.getPsw(), p.getFuncao());
        //DataBase.closeConnection(conn, pstmt);
    }
    public List<Pessoa> read(){
        Connection conn = DataBase.connect();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        List<Pessoa> pessoas = new ArrayList<>();
        
        try {
            pstmt = conn.prepareStatement("SELECT *FROM PESSOA");
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                Pessoa pessoa = new Pessoa();
                pessoa.setMatricula(rs.getString("MATRICULA"));
                pessoa.setPsw(rs.getString("PSW"));
                pessoa.setFuncao(rs.getInt("FUNCAO"));
                pessoas.add(pessoa);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
        DataBase.closeConnection(conn, pstmt, rs);
    }
        return pessoas;
    }
        
        
    }
    
    

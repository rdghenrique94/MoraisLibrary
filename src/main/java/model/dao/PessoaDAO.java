/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import database.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Pessoa;

/**
 *
 * @author rodri
 */
public class PessoaDAO {
    
    public void create(Pessoa p){
        
        Connection conn = DataBase.connect();
        PreparedStatement pstmt = null;
        
        DataBase app = new DataBase();
        app.insertT_Pessoa(p.getNome(), p.getCpf(), p.getMatricula(), p.getCurso(), p.getPsw(), p.getFuncao());
        

        DataBase.closeConnection(conn, pstmt);
    }
    }
    
//            pstmt = conn.prepareStatement("INSERT INTO pessoa"
//                    + "(id,nome,cpf,matricula,curso,psw,funcao"
//                    + "VALUES(?,?,?,?,?,?,?)");
//            pstmt.setInt(1, p.getId());
//            pstmt.setString(2, p.getNome());
//            pstmt.setString(3, p.getCpf());
//            pstmt.setString(4, p.getMatricula());
//            pstmt.setString(5, p.getCurso());
//            pstmt.setString(6, p.getPsw());
//            pstmt.setInt(7, p.getFuncao());
//            pstmt.executeUpdate();

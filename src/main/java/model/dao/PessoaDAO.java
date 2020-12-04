/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import database.DataBase;
import static database.DataBase.closeConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Pessoa;

/**
 *
 * @author rodri
 */

public class PessoaDAO {
    
    public void selectT_Pessoa(){
            //String sql = "select * from ACERVO WHERE EDITORA = '?'";
            String buscaNome = "SELECT * FROM PESSOA";
            try (Connection conn = DataBase.connect();                
            PreparedStatement pstmt = conn.prepareStatement(buscaNome)){
            ResultSet rs = pstmt.executeQuery();           
            while (rs.next()){
                String nome = rs.getString("NOME");
                String cpf = rs.getString("CPF");
                Integer matricula = rs.getInt("MATRICULA");
                Integer curso  = rs.getInt("CURSO");
                Integer senha = rs.getInt("PSW");
                Integer funcao = rs.getInt("FUNCAO");
                //System.out.println(nome+ "|" + matricula + "|" + matricula + "|" + curso + "|" + senha + "|" + funcao);
            }
            pstmt.executeUpdate();
            //closeConnection(conn, pstmt, resultSet);
        }catch (SQLException e) {
            System.out.println(e.getMessage());           
        }
    }
    public void insertT_Pessoa(String nome, String cpf,String matricula, String curso, String psw, int funcao) {
        String sql = "INSERT INTO PESSOA(NOME, CPF, MATRICULA, CURSO, PSW, FUNCAO) VALUES (?,?,?,?,?,?)";
        try (Connection conn = DataBase.connect();          
            PreparedStatement pstmt = conn.prepareStatement(sql)){            
            pstmt.setString(1, nome);
            pstmt.setString(2, cpf);
            pstmt.setString(3, matricula);
            pstmt.setString(4, curso);
            pstmt.setString(5, psw);
            pstmt.setInt(6, funcao);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuário Cadastrado com Sucesso!");
            closeConnection(conn, pstmt);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error ao Cadastrar!");
        }
    }
    public void updateT_Pessoa(String NOME, String CPF, String MATRICULA, String CURSO, String PSW, int ID) {
        String sql = "UPDATE PESSOA SET NOME = ?, CPF = ?, MATRICULA = ?, CURSO = ?, PSW = ? WHERE ID = ?";
        try (Connection conn = DataBase.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, NOME);
            pstmt.setString(2, CPF);
            pstmt.setString(3, MATRICULA);
            pstmt.setString(4, CURSO);
            pstmt.setString(5, PSW);
            pstmt.setInt(6, ID);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados do Usuário Atualizados!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error ao Atualizar!");
        }
    }
    public void deleteT_Pessoa(String MATRICULA) {
        String sql = "DELETE FROM PESSOA WHERE MATRICULA = ?";
        try (Connection conn = DataBase.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, MATRICULA);
            //pstmt.setFloat(2, CPF);
            //pstmt.setInt(3, ID);
            //pstmt.setInt(4, MATRICULA);
            //pstmt.setString(2, CURSO);
            JOptionPane.showMessageDialog(null, "Usuário Removido com Sucesso!");
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error ao Remover!");
        }
    }
    public void create(Pessoa p){
        
        insertT_Pessoa(p.getNome(), p.getCpf(), p.getMatricula(), p.getCurso(), p.getPsw(), p.getFuncao());
    }
    public void update(Pessoa p){
        
        updateT_Pessoa(p.getNome(), p.getCpf(), p.getMatricula(), p.getCurso(), p.getPsw(), p.getId());
    }
    public void delete(Pessoa p){
        
        deleteT_Pessoa(p.getMatricula());
    }
    public void select(Pessoa p){
        
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


        
    
    
    

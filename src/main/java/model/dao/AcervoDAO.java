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
import model.bean.Acervo;

/**
 *
 * @author rodri
 */
public class AcervoDAO {
    
    public void selectT_Acervo(){
            //String sql = "select * from ACERVO WHERE EDITORA = '?'";
            String buscaNome = "SELECT * FROM ACERVO";
            try (Connection conn = DataBase.connect();                
            PreparedStatement pstmt = conn.prepareStatement(buscaNome)){
            ResultSet rs = pstmt.executeQuery();           
            while (rs.next()){
                String titulo = rs.getString("TITULO");
                String editora = rs.getString("EDITORA");
                Integer ano = rs.getInt("ANO");
                Integer estante  = rs.getInt("ESTANTE");
                Integer prateleira = rs.getInt("PRATELEIRA");
                Integer status = rs.getInt("STATUS");
                System.out.println(titulo + "|" + editora + "|" + ano + "|" + estante + "|" + prateleira + "|" + status);
            }
            pstmt.executeUpdate();
            //closeConnection(conn, pstmt, resultSet);
        }catch (SQLException e) {
            System.out.println(e.getMessage());           
        }
    }
        public void selectAcervo(String tituloBusca){
            //String sql = "select * from ACERVO WHERE EDITORA = '?'";
            String sql = "SELECT * FROM ACERVO,PRATELEIRA,ESTANTES  where TITULO = (?)";
            try (Connection conn = DataBase.connect();                
            PreparedStatement acervo = conn.prepareStatement(sql)){
            acervo.setString(1,tituloBusca);
            ResultSet acerv = acervo.executeQuery();
            
            while (acerv.next()){
                String titulo = acerv.getString("TITULO");
                String editora = acerv.getString("EDITORA");
                Integer ano = acerv.getInt("ANO");
                String estante  = acerv.getString("ESTANTE");
                String prateleira = acerv.getString("PRATELEIRA");
                Integer status = acerv.getInt("STATUS");
                //System.out.println(titulo + "|" + editora + "|" + ano + "|" + estante + "|" + prateleira + "|" + status);
            //return;
            }
            acervo.executeUpdate();
            //closeConnection(conn, pstmt, resultSet);
        }catch (SQLException e) {
            System.out.println(e.getMessage());           
        }     
}
    public void selectAcervo(int ID_ACERVO){
            //String sql = "select * from ACERVO WHERE EDITORA = '?'";
            String sql = "SELECT * FROM ACERVO,PRATELEIRA,ESTANTES  where ID_ACERVO = (?)";
            try (Connection conn = DataBase.connect();                
            PreparedStatement acervo = conn.prepareStatement(sql)){
            acervo.setInt(1,ID_ACERVO);
            ResultSet acerv = acervo.executeQuery();
            
            while (acerv.next()){
                String titulo = acerv.getString("TITULO");
                String editora = acerv.getString("EDITORA");
                Integer ano = acerv.getInt("ANO");
                String estante  = acerv.getString("ESTANTE");
                String prateleira = acerv.getString("PRATELEIRA");
                Integer status = acerv.getInt("STATUS");
                System.out.println(titulo + "|" + editora + "|" + ano + "|" + estante + "|" + prateleira + "|" + status);
            }
            acervo.executeUpdate();
            //closeConnection(conn, pstmt, resultSet);
        }catch (SQLException e) {
            System.out.println(e.getMessage());           
        }
    }
    public void insertT_Acervo(String titulo, String editora, int ano,String estante,String prateleira, int status) {
        String sql = "INSERT INTO ACERVO(TITULO, EDITORA, ANO, ESTANTE, PRATELEIRA, STATUS) VALUES (?,?,?,?,?,1)";
        try (Connection conn = DataBase.connect();          
            PreparedStatement pstmt = conn.prepareStatement(sql)){            
            pstmt.setString(1, titulo);
            pstmt.setString(2, editora);
            pstmt.setInt(3, ano);
            pstmt.setString(4, estante);
            pstmt.setString(5, prateleira);
            //pstmt.setInt(6, status);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Exito ao Cadastrado!");
            closeConnection(conn, pstmt);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error ao Cadastrar!");
        }
    }
    public void updateT_Acervo(int ID, String TITULO, String EDITORA, int ANO, String ESTANTE, String PRATELEIRA) {
        String sql = "UPDATE ACERVO SET TITULO = ?," + "EDITORA = ?," + "ANO = ?," + "ESTANTE = ?," + "PRATELEIRA = ?," + "STATUS = 1 " + "WHERE ID_ACERVO = ?";
        try (Connection conn = DataBase.connect();
            PreparedStatement altA = conn.prepareStatement(sql)) {
            altA.setString(1, TITULO);
            altA.setString(2, EDITORA);
            altA.setInt(3, ANO);
            altA.setString(4, ESTANTE);
            altA.setString(5, PRATELEIRA);
            altA.setInt(6, ID);
            altA.executeUpdate();
            JOptionPane.showMessageDialog(null, "Informações do Livro Selecionado Atualizadas!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error ao Atualizar Informações do Livro Selecionado!");
        }    
    }
    public void deleteT_Acervo(int ID_ACERVO,int ANO) {
        String sql = "DELETE FROM ACERVO WHERE ID_ACERVO = ? and ANO = ?";
        try (Connection conn = DataBase.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, ID_ACERVO);
            pstmt.setInt(2, ANO);
            //pstmt.setInt(3, ID);
            //pstmt.setInt(4, MATRICULA);
            //pstmt.setString(2, CURSO);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Exito ao Remover o Livro Selecionado!!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error ao Remover o Livro Selecionado!");
        }
    }
    public void create(Acervo ac){
        
        insertT_Acervo(ac.getTitulo(), ac.getEditora(), ac.getAno(), ac.getEstante(), ac.getPrateleira(), ac.getStatus());
    }
    public void update(Acervo ac){
        
        updateT_Acervo(ac.getId(), ac.getTitulo(), ac.getEditora(), ac.getAno(), ac.getEstante(), ac.getPrateleira());
    }
    public void delete(Acervo ac){
        
        deleteT_Acervo(ac.getId(), ac.getAno());
    }
    public List<Acervo> read(){
        
        List<Acervo> acervos = new ArrayList<>();
        
        try (Connection conn = DataBase.connect();
            PreparedStatement pstmt = conn.prepareStatement("SELECT ID_ACERVO, TITULO, EDITORA, ANO, ESTANTE, PRATELEIRA, STATUS FROM ACERVO"
                    + " INNER JOIN ESTANTES ON ACERVO.ESTANTE = ESTANTES.ESTANTES"
                    + " LEFT JOIN PRATELEIRA ON ACERVO.PRATELEIRA = PRATELEIRA.PRATELEIRAS"
            )){
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                Acervo acervo = new Acervo();
                acervo.setId(rs.getInt("ID_ACERVO"));
                acervo.setTitulo(rs.getString("TITULO"));
                acervo.setEditora(rs.getString("EDITORA"));
                acervo.setAno(rs.getInt("ANO"));
                acervo.setEstante(rs.getString("ESTANTE"));
                acervo.setPrateleira(rs.getString("PRATELEIRA"));
                acervo.setStatus(rs.getInt("STATUS"));
                
                acervos.add(acervo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return acervos;
    }
    public List<Acervo> readTitulo(){
        
        List<Acervo> acervos = new ArrayList<>();
        
        try (Connection conn = DataBase.connect();
            PreparedStatement pstmt = conn.prepareStatement("SELECT ID_ACERVO, TITULO, EDITORA, ANO, ESTANTE, PRATELEIRA, STATUS FROM ACERVO"
                    + " INNER JOIN ESTANTES ON ACERVO.ESTANTE = ESTANTES.ESTANTES"
                    + " LEFT JOIN PRATELEIRA ON ACERVO.PRATELEIRA = PRATELEIRA.PRATELEIRAS"
                    + " INNER JOIN STATUS ON ACERVO.STATUS = STATUS.STATUS_MOVE"
            )){
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                Acervo acervo = new Acervo();
                acervo.setId(rs.getInt("ID_ACERVO"));
                acervo.setTitulo(rs.getString("TITULO"));
                acervo.setEditora(rs.getString("EDITORA"));
                acervo.setAno(rs.getInt("ANO"));
                acervo.setEstante(rs.getString("ESTANTE"));
                acervo.setPrateleira(rs.getString("PRATELEIRA"));
                acervo.setStatus(rs.getInt("STATUS"));
                
                acervos.add(acervo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return acervos;
    }
}
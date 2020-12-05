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
import model.bean.Ficha;

/**
 *
 * @author rodri
 */
public class FichaDAO {
    
    public void selectT_Pessoa(){
            //String sql = "select * from ACERVO WHERE EDITORA = '?'";
            String buscaNome = "SELECT * FROM FICHA_CAT";
            try (Connection conn = DataBase.connect();                
            PreparedStatement pstmt = conn.prepareStatement(buscaNome)){
            ResultSet rs = pstmt.executeQuery();           
            while (rs.next()){
                String nome = rs.getString("NOME");
                String titulo = rs.getString("TITULO");
                Integer ano = rs.getInt("ANO");
                Integer curso  = rs.getInt("CURSO");
                Integer tp_trabalho = rs.getInt("TP_TRABALHO");
                //System.out.println(nome+ "|" + matricula + "|" + matricula + "|" + curso + "|" + senha + "|" + funcao);
            }
            pstmt.executeUpdate();
            //closeConnection(conn, pstmt, resultSet);
        }catch (SQLException e) {
            System.out.println(e.getMessage());           
        }
    }
    public void insertT_Ficha(String nome, String titulo, int ano, String tp_trabalho, String curso, int status) {
        String sql = "INSERT INTO FICHA_CAT(NOME, TITULO, ANO, CURSO, TP_TRABALHO, ST_FICHA_CAT) VALUES (?,?,?,?,?,1)";
        try (Connection conn = DataBase.connect();          
            PreparedStatement pstmt = conn.prepareStatement(sql)){            
            pstmt.setString(1, nome);
            pstmt.setString(2, titulo);
            pstmt.setInt(3, ano);
            pstmt.setString(4, curso);
            pstmt.setString(5, tp_trabalho);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Solicitação Enviada!!");
            closeConnection(conn, pstmt);
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error ao Solicitar!");
        }
    }
    public void updateT_Ficha(String nome, String titulo, int ano, String curso, String tp_trabalho, int status, int id) {
        String sql = "UPDATE FICHA_CAT SET NOME = ?, TITULO= ?, ANO = ?, CURSO = ?, TP_TRABALHO= ?, ST_FICHA_CAT = ? WHERE ID_FICHA_CAT = ?";
        try (Connection conn = DataBase.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nome);
            pstmt.setString(2, titulo);
            pstmt.setInt(3, ano);
            pstmt.setString(4, curso);
            pstmt.setString(5, tp_trabalho);
            pstmt.setInt(6, status);
            pstmt.setInt(7, id);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Ficha Gerada!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao Gerar Ficha!");
        }    
    }
    public void create(Ficha fic){
        
        insertT_Ficha(fic.getNome(), fic.getTitulo(), fic.getAno(), fic.getTipoTrabalho(), fic.getCurso(), fic.getStatus());
    }
    public void update(Ficha fic){
        
    }
    public List<Ficha> read(){
        
        List<Ficha> fichas = new ArrayList<>();
        
        try (Connection conn = DataBase.connect();
            PreparedStatement pstmt = conn.prepareStatement("SELECT "
                    + "ID_FICHA_CAT, "
                    + "NOME, "
                    + "TITULO, "
                    + "ANO, "
                    + "CURSO, "
                    + "TP_TRABALHO, "
                    + "ST_FICHA_CAT "
                    + "FROM FICHA_CAT "   
            )){
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                Ficha fic = new Ficha();
                fic.setId(rs.getInt("ID_FICHA_CAT"));
                fic.setNome(rs.getString("NOME"));
                fic.setTitulo(rs.getString("TITULO"));
                fic.setAno(rs.getInt("ANO"));
                fic.setCurso(rs.getString("CURSO"));
                fic.setTipoTrabalho(rs.getString("TP_TRABALHO"));
                fic.setStatus(rs.getInt("ST_FICHA_CAT"));
                
                fichas.add(fic);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fichas;
    }
    
}

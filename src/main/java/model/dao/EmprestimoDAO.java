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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Acervo;
import model.bean.Emprestimo;

/**
 *
 * @author rodri
 */
public class EmprestimoDAO {
        LocalDate ld = LocalDate.now();
        LocalDate ldt = LocalDate.now().plusWeeks(2L);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String dateForm = dtf.format(ldt);
        String dateUser = dtf.format(ld);
        String sql = "INSERT INTO EMPRESTIMO(MATRICULA, TITULO, FUNCAO, DATA_DEVOLUCAO, DATA_EMPRESTIMO, STATUS) VALUES (?,?,?,?,?,2)";
    public void insertT_Emprestimo(String matricula, String titulo, int funcao) {
        try (Connection conn = DataBase.connect();          
            PreparedStatement pstmt = conn.prepareStatement(sql)){            
            pstmt.setString(1, matricula);
            pstmt.setString(2, titulo);
            pstmt.setInt(3, funcao);
            pstmt.setString(4, dateForm);
            pstmt.setString(5, dateUser);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Exito ao Alugar!");
            closeConnection(conn, pstmt);
        } catch (SQLException e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "Error ao Alugar!");
        }
    }
    public void update(Emprestimo ep){
        
        //insertT_Emprestimo(ep.getId(), ep.getMatricula(), ep.getTitulo(), ep.getDataDevolucao(), ep.getDataEmprestimo(), ep.getStatus());
    }
        public List<Acervo> read(){
        
        List<Acervo> acervos = new ArrayList<>();
        
        try (Connection conn = DataBase.connect();
            PreparedStatement pstmt = conn.prepareStatement("SELECT *FROM ACERVO")){
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                Acervo ac = new Acervo();
                ac.setId(rs.getInt("ID_ACERVO"));
                ac.setTitulo(rs.getString("TITULO"));
                ac.setEditora(rs.getString("EDITORA"));
                ac.setAno(rs.getInt("ANO"));
                ac.setEstante(rs.getInt("ESTANTE"));
                ac.setPrateleira(rs.getInt("PRATELEIRA"));
                ac.setStatus(rs.getInt("STATUS"));
                
                acervos.add(ac);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return acervos;
    }
    
        public List<Emprestimo> readEmprestimo(){
        
        List<Emprestimo> emprestimos = new ArrayList<>();
        
        try (Connection conn = DataBase.connect();
            PreparedStatement pstmt = conn.prepareStatement("SELECT *FROM EMPRESTIMO")){
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                Emprestimo ep = new Emprestimo();
                ep.setId(rs.getInt("ID_EMPRESTIMO"));
                ep.setMatricula(rs.getString("MATRICULA"));
                ep.setTitulo(rs.getString("TITULO"));
                ep.setFuncao(rs.getInt("FUNCAO"));
                ep.setDataDevolucao(rs.getString("DATA_DEVOLUCAO"));
                ep.setDataEmprestimo(rs.getString("DATA_EMPRESTIMO"));
                ep.setStatus(rs.getInt("STATUS"));
                
                emprestimos.add(ep);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return emprestimos;
    }
        
//        public static List<Emprestimo> getEmprestimosByLivro(int livro){
//        List<Emprestimo> emprestimos = new ArrayList();
//        String sql = "SELECT * FROM EMPRESTIMO WHERE Livro_id="+livro;
//        ConjuntoResultados lista = mysql.executaSelect(sql);
//        while(lista.next()){
//            Emprestimo emprestimo = new Emprestimo();
//            emprestimo.setID(lista.getString("id"));
//            emprestimo.setNome(lista.getString("nome"));
//            emprestimo.setTelefone(lista.getString("telefone"));
//            emprestimo.setDevolvido(lista.getString("devolvido"));
//            emprestimo.setLivro(lista.getString("Livro_id"));
//            emprestimos.add(emprestimo);
//        }
//        return emprestimos;
//    }
    }


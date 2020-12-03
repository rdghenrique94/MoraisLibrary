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
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author rodri
 */
public class EmprestimoDAO {
    
    public void insertT_Emprestimo(int id, String matricula, String titulo, String dataDevolucao, String dataEmprestimo, int status) {
        LocalDate ld = LocalDate.now();
        LocalDate ldt = LocalDate.now().plusWeeks(2L);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String dateForm = dtf.format(ld);
        String sql = "INSERT INTO EMPRESTIMO(ID, MATRICULA, TITULO, DATA_DEVOLUCAO, DATA_EMPRESTIMO, STATUS) VALUES (?,?,?,?,?,2)";
        try (Connection conn = DataBase.connect();          
            PreparedStatement pstmt = conn.prepareStatement(sql)){            
            pstmt.setString(1, matricula);
            pstmt.setString(2, titulo);
            pstmt.setString(3, dataDevolucao);
            pstmt.setString(4, dataEmprestimo);
            pstmt.setInt(5, status);
            //pstmt.setInt(6, status);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Exito ao Alugar!");
            closeConnection(conn, pstmt);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error ao Alugar!");
        }
    }
}

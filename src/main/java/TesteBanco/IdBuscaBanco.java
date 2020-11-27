package TesteBanco;

import database.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IdBuscaBanco {
    
    public static void main(String[] args) {

        
        
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        
        String sql = "SELECT * "
                + " FROM PESSOA"
                + " WHERE MATRICULA, PSW = ?,?";

        try (Connection conn = DataBase.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            
            preparedStatement.setString(1, "201910021223");
            preparedStatement.setString(2, "123456");
            
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.first()) {
                
                System.out.println("PESSOA SELECIONADA");
                System.out.println("Matricula = " + resultSet.getString("MATRICULA"));
                
            }
            DataBase.closeConnection(conn, preparedStatement, resultSet);
    
        }catch(SQLException e){
            e.printStackTrace();
        }    
}
}

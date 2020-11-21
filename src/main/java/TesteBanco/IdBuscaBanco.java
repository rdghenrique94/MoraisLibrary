package TesteBanco;

import conexoes.ConexaoSQLite;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IdBuscaBanco {
    
    public static void main(String[] args) {

        ConexaoSQLite conexaoSQLite = new ConexaoSQLite();

        conexaoSQLite.conectar();
        
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        
        String sql = "SELECT * "
                + " FROM tbl_pessoa"
                + " WHERE id = ?;";

        try{
            
            int idPessoa = 10;
            
            preparedStatement = conexaoSQLite.criarPreparedStatement(sql);
            preparedStatement.setInt(1, idPessoa);
            
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                
                System.out.println("PESSOA SELECIONADA");
                System.out.println("ID = " + resultSet.getInt("id"));
                System.out.println("NOME = " + resultSet.getString("nome"));
                System.out.println("IDADE = " + resultSet.getInt("idade"));
                
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                resultSet.close();
                preparedStatement.close();
                conexaoSQLite.desconectar();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        
    }
}

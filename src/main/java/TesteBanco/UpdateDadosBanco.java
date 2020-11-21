package TesteBanco;

import conexoes.ConexaoSQLite;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UpdateDadosBanco {
    
    public static void main(String[] args) {
        
        ConexaoSQLite conexaoSQLite = new ConexaoSQLite();
        
        conexaoSQLite.conectar();
        
        PreparedStatement preparedStatement = null;
        
        String sql = "UPDATE tbl_pessoa"
                + " SET "
                + " nome = ?,"
                + " idade = ?,"
                + " WHERE id = ?";
        
        try{
            
            preparedStatement = conexaoSQLite.criarPreparedStatement(sql);
            preparedStatement.setString(1, "Alana Morais");
            preparedStatement.setInt(2, 30);
            preparedStatement.setInt(3, 1);
            
            preparedStatement.executeUpdate();
            
            System.out.println("PESSOA ATUALIZADA");
            
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                preparedStatement.close();
                conexaoSQLite.desconectar();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }       
}

package TesteBanco;

import conexoes.ConexaoSQLite;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BuscarBanco {
    
    public static void main(String[] args) {
        
        ConexaoSQLite conexaoSQLite = new ConexaoSQLite();
        
        ResultSet resultSet = null;
        Statement statement = null;
        
        conexaoSQLite.conectar();
        
        String query = "SELECT * FROM tbl_pessoa;";
        
        statement = conexaoSQLite.criarStatement();
        
        try{
            resultSet = statement.executeQuery(query);
            
            while (resultSet.next()){
                System.out.println("DADOS DAS PESSOAS");
                System.out.println("ID "+resultSet.getInt("id"));
                System.out.println("NOME "+resultSet.getString("nome"));
                System.out.println("IDADE "+resultSet.getInt("idade"));
                System.out.println("----------------------");
                
            }
        }catch(SQLException e){
            System.out.println("Error");
        }finally{
            try{
                resultSet.close();
                statement.close();
                conexaoSQLite.desconectar();
            }catch(SQLException ex){
                System.out.println("Erro ao fechar");
            }
            
        }
                
    }
    
}

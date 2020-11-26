package TesteBanco;
 
import conexoes.ConexaoSQLite;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class InserirBanco {

    public static void main(String[] args) {

        ConexaoSQLite conexaoSQLite = new ConexaoSQLite();
        CriarBancoSQLite criarBancoSQLite = new CriarBancoSQLite(conexaoSQLite);

        criarBancoSQLite.criarTabelaPessoa();

        Produto pessoa1 = new Produto();
        pessoa1.setId(20);
        pessoa1.setNome("Rodrigo");
        pessoa1.setIdade(26);

        conexaoSQLite.conectar();

        String sqlInsert = " INSERT INTO tbl_pessoa ("
                + "id,"
                + "nome,"
                + "idade"
                + ") VALUES(?,?,?)"
                + ";";

        PreparedStatement preparedStatement = conexaoSQLite.criarPreparedStatement(sqlInsert);

        try {

            preparedStatement.setInt(1, pessoa1.getId());
            preparedStatement.setString(2, pessoa1.getNome());
            preparedStatement.setInt(3, pessoa1.getIdade());

            int resultado = preparedStatement.executeUpdate();

            if (resultado == 1) {
                System.out.println("Pessoa inserida!");
            } else {
                System.out.println("Pessoa não inserida! =[");
            }

        } catch (SQLException e) {
            System.out.println("Pessoa não inserida! =[");
        } finally{
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(InserirBanco.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            conexaoSQLite.desconectar();
        }

    }
    
}

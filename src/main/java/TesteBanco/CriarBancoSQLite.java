package TesteBanco;

import conexoes.ConexaoSQLite;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarBancoSQLite {

    private final ConexaoSQLite conexaoSQLite;

    public CriarBancoSQLite(ConexaoSQLite pConexaoSQLite) {
        this.conexaoSQLite = pConexaoSQLite;
    }

    public void criarTabelaPessoa() {

        String sql = "CREATE TABLE IF NOT EXISTS produto"
                + "("
                + "id integer PRIMARY KEY,"
                + "nome text NOT NULL,"
                + "cpf integer"
                + "matricula text NOT NULL"
                + ");";

        //executando o sql de criar tabelas
        boolean conectou = false;

        try {
            conectou = this.conexaoSQLite.conectar();
            
            Statement stmt = this.conexaoSQLite.criarStatement();
            
            stmt.execute(sql);
            
            System.out.println("Tabela pessoa criada!");

        } catch (SQLException e) {
            System.out.println("Error!");
        } finally {
            if(conectou){
                this.conexaoSQLite.desconectar();
            }
        }

    }

}

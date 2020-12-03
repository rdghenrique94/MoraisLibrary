package database;

import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import viewAluno.TelaAluno;
import viewFuncionario.TelaFuncionario;

public class DataBase {    
    
    private final String url = "jdbc:sqlite:banco_de_dados/DataBase.db";
    
    public static Connection connect() {
        String url = "jdbc:sqlite:banco_de_dados/DataBase.db";
        Connection conn = null;
        try{conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    public static void closeConnection(Connection conn){
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public static void closeConnection(Connection conn, PreparedStatement pstmt){
        closeConnection(conn);
            try {
                if (pstmt!=null){
                pstmt.close();
               }
            } catch (SQLException ex) {
                Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    public static void closeConnection(Connection conn, PreparedStatement pstmt, ResultSet rs){
        closeConnection(conn, pstmt);
            try {
                if (rs!=null){
                    rs.close();
                }        
            } catch (SQLException ex) {
                Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    public void criaT_Pessoa() {        
        try (Connection conn = DriverManager.getConnection(url)) {
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS PESSOA(ID_PESSOA INTEGER not null PRIMARY KEY AUTOINCREMENT, NOME VARCHAR not null, CPF INTEGER (11,11)not null UNIQUE, MATRICULA STRING not null, CURSO STRING, PSW INTEGER not null,FUNCAO INTEGER not null)");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void criaT_Acervo(){
        try (Connection connection = DriverManager.getConnection(url)) {
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS ACERVO(ID_ACERVO INTEGER not null PRIMARY KEY AUTOINCREMENT,TITULO STRING not null,EDITORA STRING not null,ANO INTEGER not null, ESTANTE INTEGER not null, PRATELEIRA INTEGER not null, STATUS INTEGER not null)");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }    
    
    public void criaT_Regras(){
        try(Connection connection = DriverManager.getConnection(url)){
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS REGRAS(ID_REGRAS INTEGER not null PRIMARY KEY AUTOINCREMENT, VALOR_ALUGUEL INTEGER not null, VALOR_MULTA INTEGER not null, NOME STRING not null, MATRICULA STRING not null, STATUS INTEGER not null, FUNCAO INTEGER not null, DIAS_ALUGADO INTEGER not null, DATA_HORA DATETIME not null)");
        }catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void criaT_Status(){
        try (Connection connection = DriverManager.getConnection(url)){
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS STATUS(STATUS STRING not null, ID_STATUS INTEGER not null PRIMARY KEY AUTOINCREMENT)");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }        
    }
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
    
    public void insertT_Acervo(String titulo, String editora, int ano,int estante,int prateleira, int status) {
        String sql = "INSERT INTO ACERVO(TITULO, EDITORA, ANO, ESTANTE, PRATELEIRA, STATUS) VALUES (?,?,?,?,?,1)";
        try (Connection conn = DataBase.connect();          
            PreparedStatement pstmt = conn.prepareStatement(sql)){            
            pstmt.setString(1, titulo);
            pstmt.setString(2, editora);
            pstmt.setInt(3, ano);
            pstmt.setInt(4, estante);
            pstmt.setInt(5, prateleira);
            //pstmt.setInt(6, status);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Exito ao Cadastrado!");
            closeConnection(conn, pstmt);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error ao Cadastrar!");
        }
    }
    
    public void updateT_Acervo(int ID, String TITULO, String EDITORA, int ANO, int ESTANTE, int PRATELEIRA) {
        String sql = "UPDATE ACERVO SET TITULO = ?," + "EDITORA = ?," + "ANO = ?," + "ESTANTE = ?," + "PRATELEIRA = ?," + "STATUS = 1 " + "WHERE ID_ACERVO = ?";
        try (Connection conn = DataBase.connect();
            PreparedStatement altA = conn.prepareStatement(sql)) {
            altA.setString(1, TITULO);
            altA.setString(2, EDITORA);
            altA.setInt(3, ANO);
            altA.setInt(4, ESTANTE);
            altA.setInt(5, PRATELEIRA);
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
    public void insertT_Funcao(String funcao, int id) {
        String sql = "INSERT INTO FUNCAO(FUNCAO, ID_FUNCAO) VALUES (?,?)";
        try (Connection conn = DataBase.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, funcao);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void selectT_Pessoa(){
            //String sql = "select * from ACERVO WHERE EDITORA = '?'";
            String buscaNome = "SELECT * FROM PESSOA";
            try (Connection conn = DataBase.connect();                
            PreparedStatement pstmt = conn.prepareStatement(buscaNome)){
            ResultSet rs = pstmt.executeQuery();           
            while (rs.next()){
                String nome = rs.getString("NOME");
                String cpf = rs.getString("CPF");
                Integer matricula = rs.getInt("MATRICULA");
                Integer curso  = rs.getInt("CURSO");
                Integer senha = rs.getInt("PSW");
                Integer funcao = rs.getInt("FUNCAO");
                //System.out.println(nome+ "|" + matricula + "|" + matricula + "|" + curso + "|" + senha + "|" + funcao);
            }
            pstmt.executeUpdate();
            //closeConnection(conn, pstmt, resultSet);
        }catch (SQLException e) {
            System.out.println(e.getMessage());           
        }
    }
    public void insertT_Pessoa(String nome, String cpf,String matricula, String curso, String psw, int funcao) {
        String sql = "INSERT INTO PESSOA(NOME, CPF, MATRICULA, CURSO, PSW, FUNCAO) VALUES (?,?,?,?,?,?)";
        try (Connection conn = DataBase.connect();          
            PreparedStatement pstmt = conn.prepareStatement(sql)){            
            pstmt.setString(1, nome);
            pstmt.setString(2, cpf);
            pstmt.setString(3, matricula);
            pstmt.setString(4, curso);
            pstmt.setString(5, psw);
            pstmt.setInt(6, funcao);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario Cadastrado!");
            closeConnection(conn, pstmt);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error ao Cadastrar!");
        }
    }
    public void updateT_Pessoa(String NOME, String CPF, String MATRICULA, String CURSO, String PSW, int ID) {
        String sql = "UPDATE PESSOA SET NOME = ?, CPF = ?, MATRICULA = ?, CURSO = ?, PSW = ? WHERE ID = ?";
        try (Connection conn = DataBase.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, NOME);
            pstmt.setString(2, CPF);
            pstmt.setString(3, MATRICULA);
            pstmt.setString(4, CURSO);
            pstmt.setString(5, PSW);
            pstmt.setInt(6, ID);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Exito ao Aatualizar!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error ao Atualizar!");
        }
    }
    public void deleteT_Pessoa(String MATRICULA) {
        String sql = "DELETE FROM PESSOA WHERE MATRICULA = ?";
        try (Connection conn = DataBase.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, MATRICULA);
            //pstmt.setFloat(2, CPF);
            //pstmt.setInt(3, ID);
            //pstmt.setInt(4, MATRICULA);
            //pstmt.setString(2, CURSO);
            JOptionPane.showMessageDialog(null, "Exito ao Remover!");
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error ao Remover!");
        }
    }
    
    public void insertT_Status(String status,int id){
        String sql = "INSERT INTO STATUS(STATUS, ID_STATUS) VALUES(?,?)";
        try (Connection conn = DataBase.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, status);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void insertT_Pessoa() {        
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:banco_de_dados/DataBase.db")) {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO PESSOAS( ID, NOME, CPF) VALUES (1, 'Marlyson', 05967762418)");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void sele_UserSenha(String matricula, String senha) {        
        String buscaNome = "SELECT * FROM PESSOA";
        try (Connection conn = DataBase.connect();                
            PreparedStatement pstmt = conn.prepareStatement(buscaNome)){
            ResultSet resultSet = pstmt.executeQuery();           
            //PreparedStatement pst = conn.prepareStatement(buscaSenha));
            while (resultSet.next()){
                String mat = resultSet.getString("MATRICULA");
                String pass = resultSet.getString("PSW");
                Integer func = resultSet.getInt("FUNCAO");
                String nom = resultSet.getString("NOME");
                
                if(matricula.equals(mat)&&senha.equals(pass)&& func==1){
                    JOptionPane.showMessageDialog(null,"Seja Bem Vindo!!! \n"+ nom);
                    TelaAluno ta = new TelaAluno();
                    ta.setVisible(true);
                }                
                else if(matricula.equals(mat)&&senha.equals(pass)&& func==2){
                    JOptionPane.showMessageDialog(null,"Seja Bem Vindo!!!  \n"+ nom);
                    TelaAluno ta = new TelaAluno();
                    ta.setVisible(true);
                }
                else if(matricula.equals(mat)&&senha.equals(pass)&& func==3){
                    JOptionPane.showMessageDialog(null,"Seja Bem Vindo!!!  \n"+ nom);
                    TelaAluno ta = new TelaAluno();
                    ta.setVisible(true);
                }
                else if(matricula.equals(mat)&&senha.equals(pass)&&func==4){
                    JOptionPane.showMessageDialog(null,"Seja Bem Vindo!!!  \n"+ nom);
                    TelaFuncionario tf = new TelaFuncionario();
                    tf.setVisible(true);                    
                }
                
            }
            pstmt.executeUpdate();
            //closeConnection(conn, pstmt, resultSet);
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null,"Usuario ou Senha Incorretos!");
        }
    }
    public void criaT_Aluguel(){
        try (Connection connection = DriverManager.getConnection(url)){
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS ALUGUEL(STATUS STRING not null, "
                    + "ID_STATUS INTEGER not null PRIMARY KEY AUTOINCREMENT"
                    + "MATRICULA"
                    + "TITULO"
                    + ")"
                    + "");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }        
    }
    
    public static void main(String[] args) {
        DataBase app = new DataBase();
        //app.criaT_Aluno();
        //app.criaT_Acervo();
        //app.criaT_Funcionarios();
        //app.criaT_Funcao();
        //app.criaT_Setor();
        //app.criaT_Setores();
        //app.criaT_Status();
        //app.updateT_Aluno(1, "Marlyson", 123123123, 9999,"ADM");
        //app.insertT_Aluno(1,"Marlyson T Xavier", "05967762418",20191022,"TI");
        //app.insertT_Funcao("", 6);
        //app.sele_UserSenha("20191022006","32072133");
        //app.insertT_Status("ATRASO", 4);
        //app.criaT_Regras();
        
        //app.criaT_Pessoa();
        //app.insertT_Pessoa("Gilson","324.629.304-12","20201023320","ADM","32072133",2);
        //app.updateT_Pessoa("Marlyson Xavier", "Sistemas Da Informação",1);
        //app.deleteT_Pessoa("32154787851");
        //app.selectT_Pessoa();
        
        //app.criaT_Acervo();
        //app.updateT_Acervo(1, "ÁPIS LÍNGUA PORTUGUESA - 1º ANO", "EDITORA ATICA S/A", 2019, 1, 1);
        //app.insertT_Acervo("Marlyson Xavier", "Jampa.Com", 2020, 1, 1, 1);
        //app.deleteT_Acervo(30001,2020);
        //app.selectT_Acervo();
    }
}

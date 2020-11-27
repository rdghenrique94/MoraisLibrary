package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import viewAluno.TelaAluno;
import viewFuncionario.TelaFuncionario;

public class DataBase {    
    
    private String url = "jdbc:sqlite:banco_de_dados/DataBase.db";
    
    public static Connection connect() {
        String url = "jdbc:sqlite:banco_de_dados/DataBase.db";
        Connection conn = null;
        try{conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }public static void closeConnection(Connection conn){
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
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:banco_de_dados/DataBase.db")) {
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS PESSOA(ID INTEGER not null PRIMARY KEY AUTOINCREMENT, NOME VARCHAR not null, CPF INTEGER (11,11)not null UNIQUE, MATRICULA STRING not null, CURSO STRING, PSW INTEGER not null,FUNCAO INTEGER not null)");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    /*
    public void criaT_Funcao() {        
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:banco_de_dados/DataBase.db")) {
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS FUNCAO(FUNCAO STRING not null UNIQUE, ID INTEGER not null PRIMARY KEY)");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void criaT_Aluno() {        
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:banco_de_dados/DataBase.db")) {
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS ALUNO( ID INTEGER not null, NOME VARCHAR not null, CPF INTEGER not null PRIMARY KEY, MATRICULA STRING not null UNIQUE, CURSO STRING not null)");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    */
    public void criaT_Acervo(){
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:banco_de_dados/DataBase.db")) {
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS ACERVO(TITULO STRING not null UNIQUE,EDITORA STRING not null,ANO INTEGER not null,ID INT not null PRIMARY KEY, ESTANTE STRING not null, PRATELEIRA STANTE not null, STATUS INTEGER not null)");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void criaT_Status(){
        try (Connection connection = DriverManager.getConnection(url)){
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS STATUS(STATUS STRING not null, ID INTEGER not null PRIMARY KEY)");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }        
    }
    
    /*
    public void criaT_Funcionarios(){
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:banco_de_dados/DataBase.db")) {
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS FUNCIONARIO( ID INTEGER not null, NOME STRING not null, CPF STRING not null, SENHA INT not null, SETOR STRING not null, TIPO INT not null)");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void criaT_Setor(){
        try(Connection connection = DriverManager.getConnection(this.url)){
        Statement statemant = connection.createStatement();
        statemant.execute("CREATE TABLE IF NOT EXISTS SETORE(ID INTEGER PRIMARY KEY not null, SETOR STRING not null)");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void updateT_Aluno(int ID, String NOME, float CPF, int MATRICULA, String CURSO) {
        String sql = "UPDATE ALUNO SET NOME = ?," + "CURSO = ?" + "WHERE ID = ?";
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, NOME);
            pstmt.setFloat(2, CPF);
            pstmt.setInt(3, ID);
            //pstmt.setInt(4, MATRICULA);
            //pstmt.setString(5, CURSO);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    */
    public void insertT_Funcao(String funcao, int id) {
        String sql = "INSERT INTO FUNCAO(FUNCAO, ID) VALUES (?,?)";
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, funcao);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void insertT_Status(String status,int id){
        String sql = "INSERT INTO STATUS(STATUS, ID) VALUES(?,?)";
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, status);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void insertT_Pessoa(String nome, String cpf,String matricula, String curso, String psw, int funcao) {
        String sql = "INSERT INTO PESSOA(NOME, CPF, MATRICULA, CURSO, PSW, FUNCAO) VALUES (?,?,?,?,?,?)";
        try (Connection conn = this.connect();          
            PreparedStatement pstmt = conn.prepareStatement(sql)){   
            
            pstmt.setString(1, nome);
            pstmt.setString(2, cpf);
            pstmt.setString(3, matricula);
            pstmt.setString(4, curso);
            pstmt.setString(5, psw);
            pstmt.setInt(6, funcao);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    /*
    public void insertT_Aluno(int ID, String NOME, String CPF, float MATRICULA, String CURSO ) {
        String sql = "INSERT INTO ALUNO(ID, NOME, CPF, MATRICULA, CURSO) VALUES (?,?,?,?,?)";
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, ID);
            pstmt.setString(2, NOME);
            pstmt.setString(3, CPF);
            pstmt.setFloat(4, MATRICULA);
            pstmt.setString(5, CURSO);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void selectT_Acervo_Editora(int ID, String NOME){
            String sql = "select * from ACERVO WHERE EDITORA = '?'";
            try (Connection conn = this.connect();
                    PreparedStatement pstmt = conn.prepareStatement(sql)){
                pstmt.getInteger(1, ID);
                pstmt.getSrintg(2, NOME);
                //Integer id = resultSet.getInt("ID");
                //String nome = resultSet.getString("NOME");
                System.out.println( id + " - " + nome);
            }
        }
            
    //select * from ACERVO WHERE EDITORA = 'EDITORA ATICA S/A'
    
    
    
    
    public static void insertT_Pessoa() {        
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:banco_de_dados/DataBase.db")) {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO PESSOAS( ID, NOME, CPF) VALUES (1, 'Marlyson', 05967762418)");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    */    
    
    public void sele_UserSenha(String matricula, String senha) {        
        String buscaNome = "SELECT * FROM PESSOA";
        try (Connection conn = this.connect();                
            PreparedStatement pstmt = conn.prepareStatement(buscaNome)){
            ResultSet resultSet = pstmt.executeQuery();           
            //PreparedStatement pst = conn.prepareStatement(buscaSenha));
            while (resultSet.next()){
                String mat = resultSet.getString("MATRICULA");
                String pass = resultSet.getString("PSW");
                Integer func = resultSet.getInt("FUNCAO");
            
                if(matricula.equals(mat)&&senha.equals(pass)&&func==4){
                    JOptionPane.showMessageDialog(null, "Logado com sucesso!");
                    TelaFuncionario tf = new TelaFuncionario();
                    tf.setVisible(true);
                    
                }else if(matricula.equals(mat)&&senha.equals(pass)&& func==3 || func==2 || func==1) {
                    JOptionPane.showMessageDialog(null, "Logado com sucesso!");
                    TelaAluno ta = new TelaAluno();
                    ta.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Dados Informados Incorretos!");
                    
                }
                //System.out.println(mat+pass+func);
            }
            pstmt.executeUpdate();            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        DataBase app = new DataBase();
        //app.criaT_Aluno();
        //app.criaT_Acervo();
        //app.criaT_Funcionarios();
        //app.criaT_Pessoa();
        //app.criaT_Funcao();
        //app.criaT_Setor();
        //app.criaT_Setores();
        //app.criaT_Status();
        //app.updateT_Aluno(1, "Marlyson", 123123123, 9999,"ADM");
        //app.insertT_Aluno(1,"Marlyson T Xavier", "05967762418",20191022,"TI");
        //app.insertT_Funcao("", 6);
        //app.criaT_Acervo();
        //app.sele_UserSenha();
        //app.insertT_Pessoa("Gilson","324.629.304-12","20201023320","ADM","32072133",2);
        //app.insertT_Status("ATRASO", 4);
    }
}

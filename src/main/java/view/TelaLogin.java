package view;

import java.sql.*;
import database.DataBase;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import viewFuncionario.TelaFuncionario;
import viewAluno.TelaAluno;

public class TelaLogin extends javax.swing.JFrame {

    public String matricula;
    public String senha;
      
    public TelaLogin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        btEntrar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        txtMatricula = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Matricula");

        jLabel2.setText("Senha");

        txtSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSenhaKeyPressed(evt);
            }
        });

        btEntrar.setText("Entrar");
        btEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEntrarActionPerformed(evt);
            }
        });

        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        try {
            txtMatricula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                        .addComponent(btEntrar))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSenha, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMatricula))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btEntrar)
                    .addComponent(btSair))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    public boolean checkLogin(String login, String senha){
        return login.equals(txtMatricula.getText()) && senha.equals(txtSenha.getPassword());
}
    private void btEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEntrarActionPerformed
            DataBase db = new DataBase();
            String mat = txtMatricula.getText();
            String pass = String.valueOf(txtSenha.getPassword());            
            String buscaNome = "SELECT * FROM PESSOA";
            try (Connection conn = DataBase.connect();                
                PreparedStatement pstmt = conn.prepareStatement(buscaNome)){
                ResultSet resultSet = pstmt.executeQuery();           
                while (resultSet.next()){
                    String matricula = resultSet.getString("MATRICULA");
                    String password = resultSet.getString("PSW");
                    Integer func = resultSet.getInt("FUNCAO");
                    String nom = resultSet.getString("NOME");
                    if(mat.equals(matricula)&&pass.equals(password)&& func==1){
                        JOptionPane.showMessageDialog(null,"Seja Bem Vindo!!!  "+ nom);
                        TelaAluno ta = new TelaAluno();
                        ta.setVisible(true);
                        dispose();
                        break;
                    }                
                    else if(mat.equals(matricula)&&pass.equals(password)&& func==2){
                        JOptionPane.showMessageDialog(null,"Seja Bem Vindo!!!  "+ nom);
                        TelaAluno ta = new TelaAluno();
                        ta.setVisible(true);
                        dispose();
                        break;
                    }
                    else if(mat.equals(matricula)&&pass.equals(password)&& func==3){
                        JOptionPane.showMessageDialog(null,"Seja Bem Vindo!!!  "+ nom);
                        TelaAluno ta = new TelaAluno();
                        ta.setVisible(true);
                        dispose();
                        break;
                    }
                    else if(mat.equals(matricula)&&pass.equals(password)&&func==4){
                        JOptionPane.showMessageDialog(null,"Seja Bem Vindo!!!  "+ nom);
                        TelaFuncionario tf = new TelaFuncionario();
                        tf.setVisible(true);
                        dispose();
                        break;
                    }
                    else if(mat != (matricula) && pass != (password)){
                        JOptionPane.showMessageDialog(null,"Login ou senha Incorreto!!!");
                        break;
                    }
                }
                pstmt.executeUpdate();
                //closeConnection(conn, pstmt, resultSet);
            }catch (SQLException e) {
                
                //JOptionPane.showMessageDialog(null,"Usuario ou Senha Incorretos!");
            }        
    }//GEN-LAST:event_btEntrarActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btSairActionPerformed

    private void txtSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSenhaKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER ){
            DataBase db = new DataBase();
            String mat = txtMatricula.getText();
            String pass = String.valueOf(txtSenha.getPassword());            
            String buscaNome = "SELECT * FROM PESSOA";
            try (Connection conn = DataBase.connect();                
                PreparedStatement pstmt = conn.prepareStatement(buscaNome)){
                ResultSet resultSet = pstmt.executeQuery();           
                while (resultSet.next()){
                    String matricula = resultSet.getString("MATRICULA");
                    String password = resultSet.getString("PSW");
                    Integer func = resultSet.getInt("FUNCAO");
                    String nom = resultSet.getString("NOME");
                    if(mat.equals(matricula)&&pass.equals(password)&& func==1){
                        JOptionPane.showMessageDialog(null,"Seja Bem Vindo!!!  "+ nom);
                        TelaAluno ta = new TelaAluno();
                        ta.setVisible(true);
                        dispose();
                        break;
                    }                
                    else if(mat.equals(matricula)&&pass.equals(password)&& func==2){
                        JOptionPane.showMessageDialog(null,"Seja Bem Vindo!!!  "+ nom);
                        TelaAluno ta = new TelaAluno();
                        ta.setVisible(true);
                        dispose();
                        break;
                    }
                    else if(mat.equals(matricula)&&pass.equals(password)&& func==3){
                        JOptionPane.showMessageDialog(null,"Seja Bem Vindo!!!  "+ nom);
                        TelaAluno ta = new TelaAluno();
                        ta.setVisible(true);
                        dispose();
                        break;
                    }
                    else if(mat.equals(matricula)&&pass.equals(password)&&func==4){
                        JOptionPane.showMessageDialog(null,"Seja Bem Vindo!!!  "+ nom);
                        TelaFuncionario tf = new TelaFuncionario();
                        tf.setVisible(true);
                        dispose();
                        break;
                    }
                    else if(mat != (matricula) && pass != (password)){
                        JOptionPane.showMessageDialog(null,"Login ou senha Incorreto!!!");
                        break;
                    }
                }
                pstmt.executeUpdate();
                //closeConnection(conn, pstmt, resultSet);
            }catch (SQLException e) {
                
                //JOptionPane.showMessageDialog(null,"Usuario ou Senha Incorretos!");
            }
        }
    }//GEN-LAST:event_txtSenhaKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEntrar;
    private javax.swing.JButton btSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JFormattedTextField txtMatricula;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}

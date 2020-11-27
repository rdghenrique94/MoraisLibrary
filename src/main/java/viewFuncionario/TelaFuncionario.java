package viewFuncionario;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.TelaLogin;


public class TelaFuncionario extends javax.swing.JFrame {

    public TelaFuncionario() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopFuncionario = new javax.swing.JDesktopPane();
        menuCadUser = new javax.swing.JMenuBar();
        menuArquivo = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenuItem();
        menuUser = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        menuLivro = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Area do Funcionario");

        javax.swing.GroupLayout desktopFuncionarioLayout = new javax.swing.GroupLayout(desktopFuncionario);
        desktopFuncionario.setLayout(desktopFuncionarioLayout);
        desktopFuncionarioLayout.setHorizontalGroup(
            desktopFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1026, Short.MAX_VALUE)
        );
        desktopFuncionarioLayout.setVerticalGroup(
            desktopFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 762, Short.MAX_VALUE)
        );

        menuArquivo.setIcon(new javax.swing.ImageIcon("C:\\Users\\rodri\\Documents\\NetBeansProjects\\MoraisLibrary\\src\\main\\resouces\\icons\\folder.png")); // NOI18N
        menuArquivo.setText("Iniciar");

        jMenu1.setIcon(new javax.swing.ImageIcon("C:\\Users\\rodri\\Documents\\NetBeansProjects\\MoraisLibrary\\src\\main\\resouces\\icons\\chat-list.png")); // NOI18N
        jMenu1.setText("Relatórios");

        jMenuItem8.setIcon(new javax.swing.ImageIcon("C:\\Users\\rodri\\Documents\\NetBeansProjects\\MoraisLibrary\\src\\main\\resouces\\icons\\chat-list.png")); // NOI18N
        jMenuItem8.setText("Gerar Relatório");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);

        menuArquivo.add(jMenu1);

        jMenu2.setText("Eventos");

        jMenuItem10.setText("Adicionar Eventos");
        jMenu2.add(jMenuItem10);

        menuArquivo.add(jMenu2);

        menuSair.setIcon(new javax.swing.ImageIcon("C:\\Users\\rodri\\Documents\\NetBeansProjects\\MoraisLibrary\\src\\main\\resouces\\icons\\door_out.png")); // NOI18N
        menuSair.setText("Logout");
        menuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairActionPerformed(evt);
            }
        });
        menuArquivo.add(menuSair);

        menuCadUser.add(menuArquivo);

        menuUser.setIcon(new javax.swing.ImageIcon("C:\\Users\\rodri\\Documents\\NetBeansProjects\\MoraisLibrary\\src\\main\\resouces\\icons\\user.png")); // NOI18N
        menuUser.setText("Usuario");

        jMenuItem2.setIcon(new javax.swing.ImageIcon("C:\\Users\\rodri\\Documents\\NetBeansProjects\\MoraisLibrary\\src\\main\\resouces\\icons\\user_add.png")); // NOI18N
        jMenuItem2.setText("Cadastrar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuUser.add(jMenuItem2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon("C:\\Users\\rodri\\Documents\\NetBeansProjects\\MoraisLibrary\\src\\main\\resouces\\icons\\user_edit.png")); // NOI18N
        jMenuItem3.setText("Editar");
        menuUser.add(jMenuItem3);

        jMenuItem4.setIcon(new javax.swing.ImageIcon("C:\\Users\\rodri\\Documents\\NetBeansProjects\\MoraisLibrary\\src\\main\\resouces\\icons\\user_delete.png")); // NOI18N
        jMenuItem4.setText("Excluir");
        menuUser.add(jMenuItem4);

        jMenuItem5.setIcon(new javax.swing.ImageIcon("C:\\Users\\rodri\\Documents\\NetBeansProjects\\MoraisLibrary\\src\\main\\resouces\\icons\\user_comment.png")); // NOI18N
        jMenuItem5.setText("Pesquisar");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        menuUser.add(jMenuItem5);

        menuCadUser.add(menuUser);

        menuLivro.setIcon(new javax.swing.ImageIcon("C:\\Users\\rodri\\Documents\\NetBeansProjects\\MoraisLibrary\\src\\main\\resouces\\icons\\book.png")); // NOI18N
        menuLivro.setText("Livros");

        jMenuItem6.setIcon(new javax.swing.ImageIcon("C:\\Users\\rodri\\Documents\\NetBeansProjects\\MoraisLibrary\\src\\main\\resouces\\icons\\book_add.png")); // NOI18N
        jMenuItem6.setText("Cadastrar Livros");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        menuLivro.add(jMenuItem6);

        jMenuItem9.setIcon(new javax.swing.ImageIcon("C:\\Users\\rodri\\Documents\\NetBeansProjects\\MoraisLibrary\\src\\main\\resouces\\icons\\book_addresses.png")); // NOI18N
        jMenuItem9.setText("Alugar Livro");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        menuLivro.add(jMenuItem9);

        jMenuItem7.setIcon(new javax.swing.ImageIcon("C:\\Users\\rodri\\Documents\\NetBeansProjects\\MoraisLibrary\\src\\main\\resouces\\icons\\book_open.png")); // NOI18N
        jMenuItem7.setText("Ficha Catalográfica");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        menuLivro.add(jMenuItem7);

        menuCadUser.add(menuLivro);

        jMenu4.setIcon(new javax.swing.ImageIcon("C:\\Users\\rodri\\Documents\\NetBeansProjects\\MoraisLibrary\\src\\main\\resouces\\icons\\exclamation.png")); // NOI18N
        jMenu4.setText("Sobre");

        jMenuItem1.setIcon(new javax.swing.ImageIcon("C:\\Users\\rodri\\Documents\\NetBeansProjects\\MoraisLibrary\\src\\main\\resouces\\icons\\information.png")); // NOI18N
        jMenuItem1.setText("Informações");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem1);

        menuCadUser.add(jMenu4);

        setJMenuBar(menuCadUser);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopFuncionario)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopFuncionario)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        TelaCadastroUsusario telaCadUser = new TelaCadastroUsusario();
        desktopFuncionario.add(telaCadUser);
        telaCadUser.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void menuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairActionPerformed
        JOptionPane.showMessageDialog(null, "Usuario Deslogado \nVoltando Para Tela de Login");
        TelaLogin tl = new TelaLogin();
        tl.setVisible(true);
        this.dispose();
        //System.exit(0);  
    }//GEN-LAST:event_menuSairActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        
        JOptionPane.showMessageDialog(null, "MORAIS LIBRARY"
                + "\n"
                + "\n"
                + "Idealizadora: Dr. Alana Morais"
                + "\n"
                + "\n"
                + "Desenvolvedores: Rodrigo Andrade, Marlyson Xavier"
                + "\n"
                + "\n"
                + "Projeto apresentado referente a nota da segunda avaliação da cadeira: Linguagem de Programação II"
                + " onde devemos criar um software que controle e organize uma biblioteca"
                + "\n"
                + "\n"
                + "Agradeço a Deus e a meus colegas por todo o trabalho desempenhado e todo o tempo gasto. ");
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        LivroAdd tabelaLiv = new LivroAdd();
        desktopFuncionario.add(tabelaLiv);
        tabelaLiv.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed

        FichaCatalografica fch = new FichaCatalografica();
        desktopFuncionario.add(fch);
        fch.setVisible(true);

    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed

        Document document = new Document();                                     //GERAR PDF 
        try {
            PdfWriter.getInstance(document, new FileOutputStream("Relatório.pdf"));
            document.open();
            document.add(new Paragraph("Teste"));
        } catch (FileNotFoundException | DocumentException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }finally{
            document.close();
        }
        try {
            Desktop.getDesktop().open(new File("Relatório.pdf"));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }
        

    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopFuncionario;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenu menuArquivo;
    private javax.swing.JMenuBar menuCadUser;
    private javax.swing.JMenu menuLivro;
    private javax.swing.JMenuItem menuSair;
    private javax.swing.JMenu menuUser;
    // End of variables declaration//GEN-END:variables
}

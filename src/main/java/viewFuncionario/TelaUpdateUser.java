package viewFuncionario;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.bean.Pessoa;
import model.dao.PessoaDAO;

public class TelaUpdateUser extends javax.swing.JInternalFrame {

    public TelaUpdateUser() {
        initComponents();
        
        DefaultTableModel modelo = (DefaultTableModel) tableUpdateUser.getModel(); // FAZER ORDENAÇÃO NA TABELA
        tableUpdateUser.setRowSorter(new TableRowSorter(modelo));
        readTabela();
    }
public void cleanFields(){
        txtNome.setText("");
        txtCpf.setText("");
        txtMatricula.setText("");
        txtCurso.setText("");
        txtSenha.setText("");
        txtFuncao.setText("");

    }
    
    public void readTabela(){
        DefaultTableModel modelo = (DefaultTableModel) tableUpdateUser.getModel();
        modelo.setNumRows(0);
        PessoaDAO pdao = new PessoaDAO();
        
        for (Pessoa p: pdao.read()){
            
            modelo.addRow(new Object[]{
                p.getId(),
                p.getNome(),
                p.getCpf(),
                p.getMatricula(),
                p.getCurso(),
                p.getPsw(),
                p.getFuncao()
            });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtCpf = new javax.swing.JFormattedTextField();
        txtSenha = new javax.swing.JTextField();
        txtFuncao = new javax.swing.JTextField();
        txtCurso = new javax.swing.JTextField();
        txtMatricula = new javax.swing.JFormattedTextField();
        btnAtualizar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableUpdateUser = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro de Livros"));
        setClosable(true);

        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jLabel1.setText("NOME");

        jLabel2.setText("CPF");

        jLabel3.setText("MATRICULA");

        jLabel4.setText("CURSO");

        jLabel5.setText("SENHA");

        jLabel6.setText("FUNÇÃO");

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtMatricula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnAtualizar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        tableUpdateUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOME", "CPF", "MATRICULA", "CURSO", "SENHA", "FUNÇÃO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableUpdateUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableUpdateUserMouseClicked(evt);
            }
        });
        tableUpdateUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tableUpdateUserKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tableUpdateUser);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtNome)
                                .addGap(18, 18, 18)
                                .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(370, 370, 370))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(233, 233, 233))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(222, 222, 222)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3)
                                    .addComponent(txtMatricula)
                                    .addComponent(jLabel6)
                                    .addComponent(txtFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(67, 67, 67))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableUpdateUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableUpdateUserMouseClicked

        if (tableUpdateUser.getSelectedRow() != -1){
            txtNome.setText(tableUpdateUser.getValueAt(tableUpdateUser.getSelectedRow(), 1).toString());
            txtCpf.setText(tableUpdateUser.getValueAt(tableUpdateUser.getSelectedRow(), 2).toString());
            txtMatricula.setText(tableUpdateUser.getValueAt(tableUpdateUser.getSelectedRow(), 3).toString());
            txtCurso.setText(tableUpdateUser.getValueAt(tableUpdateUser.getSelectedRow(), 4).toString());
            txtSenha.setText(tableUpdateUser.getValueAt(tableUpdateUser.getSelectedRow(), 5).toString());
            txtFuncao.setText(tableUpdateUser.getValueAt(tableUpdateUser.getSelectedRow(), 6).toString());
        }else{
            JOptionPane.showMessageDialog(null, "Selecione Um Livro para Excluir ");
        }

    }//GEN-LAST:event_tableUpdateUserMouseClicked

    private void tableUpdateUserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableUpdateUserKeyReleased
         if (tableUpdateUser.getSelectedRow() != -1){
            txtNome.setText(tableUpdateUser.getValueAt(tableUpdateUser.getSelectedRow(), 1).toString());
            txtCpf.setText(tableUpdateUser.getValueAt(tableUpdateUser.getSelectedRow(), 2).toString());
            txtMatricula.setText(tableUpdateUser.getValueAt(tableUpdateUser.getSelectedRow(), 3).toString());
            txtCurso.setText(tableUpdateUser.getValueAt(tableUpdateUser.getSelectedRow(), 4).toString());
            txtSenha.setText(tableUpdateUser.getValueAt(tableUpdateUser.getSelectedRow(), 5).toString());
            txtFuncao.setText(tableUpdateUser.getValueAt(tableUpdateUser.getSelectedRow(), 6).toString());
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma Pessoa para Editar ");
        }


    }//GEN-LAST:event_tableUpdateUserKeyReleased

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
            Pessoa p = new Pessoa();
            PessoaDAO dao = new PessoaDAO();
        if (tableUpdateUser.getSelectedRow() != -1){
            p.setNome(txtNome.getText());
            p.setCpf(txtCpf.getText());
            p.setMatricula(txtMatricula.getText());
            p.setCurso(txtCurso.getText());
            p.setPsw(txtSenha.getText());
            p.setId((int)tableUpdateUser.getValueAt(tableUpdateUser.getSelectedRow(),0));
            dao.update(p);
            readTabela();
            cleanFields();
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma Pessoa para Editar ");
            
        }
    }//GEN-LAST:event_btnAtualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tableUpdateUser;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtCurso;
    private javax.swing.JTextField txtFuncao;
    private javax.swing.JFormattedTextField txtMatricula;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtSenha;
    // End of variables declaration//GEN-END:variables
}

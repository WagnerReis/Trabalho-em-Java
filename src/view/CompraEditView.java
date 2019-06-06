package view;

import control.CompraController;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.Compra;
import model.Fornecedor;
import model.Funcionario;
import util.DateTimeUtil;

public class CompraEditView extends javax.swing.JDialog {

    public CompraEditView() {
        initComponents();
   
     List<Fornecedor> fornecedor = CompraController.getInstance().buscarTodasFornecedor();
        jcbFornecedor.setModel(new DefaultComboBoxModel(fornecedor.toArray()));
        jcbFornecedor.setSelectedIndex(-1);
        
        
         List<Funcionario> funcionario = CompraController.getInstance().buscarTodasFuncionario();
        jcbFuncionario.setModel(new DefaultComboBoxModel(funcionario.toArray()));
        jcbFuncionario.setSelectedIndex(-1);
    }

      @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jData = new javax.swing.JLabel();
        jFuncionario = new javax.swing.JLabel();
        jtfCodigo = new javax.swing.JTextField();
        jtfData = new javax.swing.JTextField();
        jcbFuncionario = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jFornecedor = new javax.swing.JLabel();
        jcbFornecedor = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jbCancelar = new javax.swing.JButton();
        jbSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jData.setText("Data");

        jFuncionario.setText("Funcionario");

        jtfCodigo.setEnabled(false);
        jtfCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCodigoActionPerformed(evt);
            }
        });

        jtfData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfDataActionPerformed(evt);
            }
        });

        jcbFuncionario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbFuncionarioActionPerformed(evt);
            }
        });

        jLabel1.setText("Codigo");

        jFornecedor.setText("Fornecedor");

        jcbFornecedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbFornecedorActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(102, 0, 0));

        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jbSalvar.setText("Salvar");
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(216, Short.MAX_VALUE)
                .addComponent(jbCancelar)
                .addGap(26, 26, 26)
                .addComponent(jbSalvar)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCancelar)
                    .addComponent(jbSalvar))
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jFornecedor)
                        .addGap(18, 18, 18)
                        .addComponent(jcbFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFuncionario)
                            .addComponent(jLabel1)
                            .addComponent(jData))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfData, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(jtfCodigo)
                            .addComponent(jcbFuncionario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(143, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jData)
                    .addComponent(jtfData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFornecedor)
                    .addComponent(jcbFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFuncionario)
                    .addComponent(jcbFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCodigoActionPerformed

    private void jtfDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfDataActionPerformed

    private void jcbFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbFuncionarioActionPerformed

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        if (validarCamposObrigatorios()) { // Valida campos obrigatorios
            try {
                // Pega os dados informados nos campos cria um objeto aluno e dispara o metodo de persitêcia na tela
                CompraController.getInstance().persistir(getDados());

                JOptionPane.showMessageDialog(this, "Salvo com sucesso!");
                //Fecha a tela
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Ocorreu o seguinte erro na gravação dos dados: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jcbFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbFornecedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbFornecedorActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CompraEditView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jData;
    private javax.swing.JLabel jFornecedor;
    private javax.swing.JLabel jFuncionario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JComboBox<String> jcbFornecedor;
    private javax.swing.JComboBox<String> jcbFuncionario;
    private javax.swing.JTextField jtfCodigo;
    private javax.swing.JTextField jtfData;
    // End of variables declaration//GEN-END:variables
private boolean validarCamposObrigatorios() {
    
     
        if (jtfData.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Data é de preenchimento obrigatório");
            jtfData.requestFocus();
            return false;
        }

        if (jcbFornecedor.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(this, "Fornecedor é de preenchimento obrigatório");
            jcbFornecedor.requestFocus();
            return false;
        }
         if (jcbFuncionario.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(this, "Funcionarioa é de preenchimento obrigatório");
            jcbFuncionario.requestFocus();
            return false;
        }

        return true;
    }

    public Compra getDados() {
        Compra ic = new Compra();

        if (!jtfCodigo.getText().equals("")) {
            ic.setId(Long.parseLong(jtfCodigo.getText()));
        }
        
       ic.setData(DateTimeUtil.getInstance().parseDate(jtfData.getText()));
       ic.setFornecedor((Fornecedor) jcbFornecedor.getSelectedItem());
        ic.setFuncionario((Funcionario) jcbFuncionario.getSelectedItem());

        return ic;
    }

    public void setDados(Compra compra) {

        jtfCodigo.setText( compra.getId().toString());
        jtfData.setText(DateTimeUtil.getInstance().parseDate(compra.getData()));      
        jcbFornecedor.setSelectedItem( compra.getFornecedor());
        jcbFuncionario.setSelectedItem( compra.getFuncionario());
        
 
    }
}

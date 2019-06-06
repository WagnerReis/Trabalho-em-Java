package view;

import control.FornecedorController;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Fornecedor;

public class FornecedorSearchView extends javax.swing.JFrame {

    public FornecedorSearchView() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtPesquisar = new javax.swing.JTable();
        jpPesquisar = new javax.swing.JPanel();
        jlPesquisar = new javax.swing.JLabel();
        jtfPesquisar = new javax.swing.JTextField();
        jbPesquisar2 = new javax.swing.JButton();
        jbSair = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbAlterar = new javax.swing.JButton();
        jbInseir1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jtPesquisar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtPesquisar);

        jpPesquisar.setBackground(new java.awt.Color(102, 0, 0));
        jpPesquisar.setForeground(new java.awt.Color(51, 51, 51));

        jlPesquisar.setBackground(new java.awt.Color(255, 255, 255));
        jlPesquisar.setForeground(new java.awt.Color(255, 255, 255));
        jlPesquisar.setText("Pesquise  aqui");

        jtfPesquisar.setToolTipText("Digite aqui...");
        jtfPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfPesquisarActionPerformed(evt);
            }
        });

        jbPesquisar2.setText("Pesquisar");
        jbPesquisar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPesquisar2ActionPerformed(evt);
            }
        });

        jbSair.setText("Sair");
        jbSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSairActionPerformed(evt);
            }
        });

        jbExcluir.setText("Excluir");
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jbAlterar.setText("Alterar");
        jbAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAlterarActionPerformed(evt);
            }
        });

        jbInseir1.setText("Inserir");
        jbInseir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInseir1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpPesquisarLayout = new javax.swing.GroupLayout(jpPesquisar);
        jpPesquisar.setLayout(jpPesquisarLayout);
        jpPesquisarLayout.setHorizontalGroup(
            jpPesquisarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPesquisarLayout.createSequentialGroup()
                .addGroup(jpPesquisarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPesquisarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jtfPesquisar))
                    .addGroup(jpPesquisarLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jbPesquisar2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                        .addComponent(jbInseir1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbExcluir)
                        .addGap(70, 70, 70)
                        .addComponent(jbSair)))
                .addContainerGap())
            .addGroup(jpPesquisarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpPesquisarLayout.setVerticalGroup(
            jpPesquisarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPesquisarLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jlPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpPesquisarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbPesquisar2)
                    .addComponent(jbSair)
                    .addComponent(jbExcluir)
                    .addComponent(jbAlterar)
                    .addComponent(jbInseir1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfPesquisarActionPerformed

    private void jbPesquisar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPesquisar2ActionPerformed

        List<Fornecedor> fornecedor = FornecedorController.getInstance().pesquisar(jtfPesquisar.getText());

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Codigo(ID)");
        modelo.addColumn("telefone");
        modelo.addColumn("celular");
        modelo.addColumn("razao_social");
        modelo.addColumn("cnpj");
        modelo.addColumn("estado");
        modelo.addColumn("cidade");
        modelo.addColumn("bairro");
        modelo.addColumn("rua");
        modelo.addColumn("numero");

        for (Fornecedor i : fornecedor) {
            modelo.addRow(new Object[]{i.getId(), i.getTelefone(), i.getCelular(),i.getRazaoSocial(), i.getCnpj(),i.getEstado(), i.getCidade(),i.getBairro(),i.getRua(), i.getNumero()  });
        }
        jtPesquisar.removeAll();
        jtPesquisar.setModel(modelo);

        jtPesquisar.getColumnModel().getColumn(1).setPreferredWidth(85);
        jtPesquisar.getColumnModel().getColumn(1).setPreferredWidth(360);
    }//GEN-LAST:event_jbPesquisar2ActionPerformed

    private void jbSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSairActionPerformed
        dispose();
    }//GEN-LAST:event_jbSairActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        int linha = jtPesquisar.getSelectedRow();

        if (linha > 0) {
            if (JOptionPane.showConfirmDialog(this, "Deseja deletar?", "Deletar registro", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                Long id = (Long) jtPesquisar.getValueAt(linha, 0);

                if (FornecedorController.getInstance().deletar(id)) {
                    JOptionPane.showMessageDialog(this, "Deletado com sucesso.");
                    jbPesquisar2.doClick();

                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao deletar o Registro.");
                }

            }
        }
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlterarActionPerformed

        int linha = jtPesquisar.getSelectedRow();

        if (linha > 0)
        {

            Long id = (Long) jtPesquisar.getValueAt(linha, 0);

            Fornecedor i = FornecedorController.getInstance().buscarID(id);

            FornecedorEditView view = new FornecedorEditView();
            view.setDados(i);
            view.setLocationRelativeTo(null);
            view.setModal(true);                
            view.setVisible(true);
            jbPesquisar2.doClick();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Erro ao alterar o Registro.");
        }
    }//GEN-LAST:event_jbAlterarActionPerformed

    private void jbInseir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInseir1ActionPerformed
        FornecedorEditView view = new FornecedorEditView();
        view.setLocationRelativeTo(null);
        view.setModal(true);
        view.setVisible(true);
        jbPesquisar2.doClick();
    }//GEN-LAST:event_jbInseir1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FornecedorSearchView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAlterar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbInseir1;
    private javax.swing.JButton jbPesquisar2;
    private javax.swing.JButton jbSair;
    private javax.swing.JLabel jlPesquisar;
    private javax.swing.JPanel jpPesquisar;
    private javax.swing.JTable jtPesquisar;
    private javax.swing.JTextField jtfPesquisar;
    // End of variables declaration//GEN-END:variables
}

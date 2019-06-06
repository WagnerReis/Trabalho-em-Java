package view;

import control.ContaPagarController;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ContaPagar;

public class ContaPagarSearchView extends javax.swing.JFrame {

    public ContaPagarSearchView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtPesquisar = new javax.swing.JTable();
        jpPesquisar2 = new javax.swing.JPanel();
        jlPesquisar2 = new javax.swing.JLabel();
        jtfPesquisar = new javax.swing.JTextField();
        jbPesquisar2 = new javax.swing.JButton();
        jbSair2 = new javax.swing.JButton();
        jbExcluir2 = new javax.swing.JButton();
        jbAlterar2 = new javax.swing.JButton();
        jbInseir3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jpPesquisar2.setBackground(new java.awt.Color(102, 0, 0));
        jpPesquisar2.setForeground(new java.awt.Color(51, 51, 51));

        jlPesquisar2.setBackground(new java.awt.Color(255, 255, 255));
        jlPesquisar2.setForeground(new java.awt.Color(255, 255, 255));
        jlPesquisar2.setText("Pesquise  aqui");

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

        jbSair2.setText("Sair");
        jbSair2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSair2ActionPerformed(evt);
            }
        });

        jbExcluir2.setText("Excluir");
        jbExcluir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluir2ActionPerformed(evt);
            }
        });

        jbAlterar2.setText("Alterar");
        jbAlterar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAlterar2ActionPerformed(evt);
            }
        });

        jbInseir3.setText("Inserir");
        jbInseir3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInseir3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpPesquisar2Layout = new javax.swing.GroupLayout(jpPesquisar2);
        jpPesquisar2.setLayout(jpPesquisar2Layout);
        jpPesquisar2Layout.setHorizontalGroup(
            jpPesquisar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPesquisar2Layout.createSequentialGroup()
                .addGroup(jpPesquisar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPesquisar2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jtfPesquisar))
                    .addGroup(jpPesquisar2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jbPesquisar2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbInseir3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbAlterar2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbExcluir2)
                        .addGap(70, 70, 70)
                        .addComponent(jbSair2)))
                .addContainerGap())
            .addGroup(jpPesquisar2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlPesquisar2, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpPesquisar2Layout.setVerticalGroup(
            jpPesquisar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPesquisar2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jlPesquisar2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpPesquisar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbPesquisar2)
                    .addComponent(jbSair2)
                    .addComponent(jbExcluir2)
                    .addComponent(jbAlterar2)
                    .addComponent(jbInseir3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
            .addComponent(jpPesquisar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpPesquisar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfPesquisarActionPerformed

    private void jbPesquisar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPesquisar2ActionPerformed

        List<ContaPagar> contaPagar = ContaPagarController.getInstance().pesquisar(jtfPesquisar.getText());

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Valor");
        modelo.addColumn("Data");
         modelo.addColumn("compra");
         
        for (ContaPagar i : contaPagar) {
            modelo.addRow(new Object[]{i.getId(), i.getValor(), i.getData(), i.getCompra() });
        }
        jtPesquisar.removeAll();
        jtPesquisar.setModel(modelo);

        jtPesquisar.getColumnModel().getColumn(1).setPreferredWidth(85);
        jtPesquisar.getColumnModel().getColumn(1).setPreferredWidth(360);
    }//GEN-LAST:event_jbPesquisar2ActionPerformed

    private void jbSair2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSair2ActionPerformed
        dispose();
    }//GEN-LAST:event_jbSair2ActionPerformed

    private void jbExcluir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluir2ActionPerformed
        int linha = jtPesquisar.getSelectedRow();

        if (linha > 0) {
            if (JOptionPane.showConfirmDialog(this, "Deseja deletar?", "Deletar registro", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                Long id = (Long) jtPesquisar.getValueAt(linha, 0);

                if (ContaPagarController.getInstance().deletar(id)) {
                    JOptionPane.showMessageDialog(this, "Deletado com sucesso.");
                    jbPesquisar2.doClick();

                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao deletar o Registro.");
                }

            }
        }
    }//GEN-LAST:event_jbExcluir2ActionPerformed

    private void jbAlterar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlterar2ActionPerformed

        int linha = jtPesquisar.getSelectedRow();

        if (linha > 0)
        {

            Long id = (Long) jtPesquisar.getValueAt(linha, 0);

            ContaPagar i = ContaPagarController.getInstance().buscarID(id);

            ContaPagarEditView view = new ContaPagarEditView();
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

    }//GEN-LAST:event_jbAlterar2ActionPerformed

    private void jbInseir3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInseir3ActionPerformed
        ContaPagarEditView view = new ContaPagarEditView();
        view.setLocationRelativeTo(null);
        view.setModal(true);                                         
        view.setVisible(true);
        jbPesquisar2.doClick();
    }//GEN-LAST:event_jbInseir3ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ContaPagarSearchView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAlterar2;
    private javax.swing.JButton jbExcluir2;
    private javax.swing.JButton jbInseir3;
    private javax.swing.JButton jbPesquisar2;
    private javax.swing.JButton jbSair2;
    private javax.swing.JLabel jlPesquisar2;
    private javax.swing.JPanel jpPesquisar2;
    private javax.swing.JTable jtPesquisar;
    private javax.swing.JTextField jtfPesquisar;
    // End of variables declaration//GEN-END:variables
}

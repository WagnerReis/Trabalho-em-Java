package view;

import control.ContaReceberController;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ContaReceber;

public class ContaReceberSearchView extends javax.swing.JFrame {

      public ContaReceberSearchView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtContaReceber = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jbInserir = new javax.swing.JButton();
        jbAlterar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbSair = new javax.swing.JButton();
        jtfOpcoes = new javax.swing.JTextField();
        jbConsultar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jtContaReceber.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtContaReceber);

        jPanel1.setBackground(new java.awt.Color(102, 0, 0));
        jPanel1.setForeground(new java.awt.Color(102, 102, 102));

        jbInserir.setText("Inserir");
        jbInserir.setToolTipText("Clique aqui para Inserir");
        jbInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInserirActionPerformed(evt);
            }
        });

        jbAlterar.setText("Alterar");
        jbAlterar.setToolTipText("Clique aqui para Alterar");
        jbAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAlterarActionPerformed(evt);
            }
        });

        jbExcluir.setText("Excluir");
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jbSair.setText("Sair");
        jbSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSairActionPerformed(evt);
            }
        });

        jtfOpcoes.setToolTipText("Digite aqui o valor para pesquisar");

        jbConsultar.setText("Consultar");
        jbConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConsultarActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Pesquise aqui");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfOpcoes)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbConsultar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
                        .addComponent(jbInserir)
                        .addGap(18, 18, 18)
                        .addComponent(jbAlterar)
                        .addGap(18, 18, 18)
                        .addComponent(jbExcluir)
                        .addGap(50, 50, 50)
                        .addComponent(jbSair, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfOpcoes, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbConsultar)
                    .addComponent(jbInserir)
                    .addComponent(jbAlterar)
                    .addComponent(jbExcluir)
                    .addComponent(jbSair))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInserirActionPerformed
        ContaReceberEditView cr = new ContaReceberEditView();
        cr.setLocationRelativeTo(null);
        cr.setModal(true);
        cr.setVisible(true);

        jbConsultar.doClick();
    }//GEN-LAST:event_jbInserirActionPerformed

    private void jbAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlterarActionPerformed
        int linha = jtContaReceber.getSelectedRow();

        if (linha >= 0) {
            Long id = (Long) jtContaReceber.getValueAt(linha, 0);

            ContaReceber conta = ContaReceberController.getInstance().buscarID(id);

            ContaReceberEditView cr =  new ContaReceberEditView();
            cr.setModal(true);
            cr.setLocationRelativeTo(null);
            cr.setDados(conta);
            cr.setVisible(true);

            jbConsultar.doClick();

        }else{
            JOptionPane.showMessageDialog(this, "Nenhum Registro foi selecionado.. seu burro.");
        }
    }//GEN-LAST:event_jbAlterarActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        int linha = jtContaReceber.getSelectedRow();

        if (linha >= 0) {

            if (JOptionPane.showConfirmDialog(this, "Deseja deletar?",
                "Opção", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

            Long id = (Long) jtContaReceber.getValueAt(linha, 0);

            if (ContaReceberController.getInstance().deletar(id)) {
                JOptionPane.showMessageDialog(this, "Registro deletado com sucesso.");

                jbConsultar.doClick();
            } else {
                JOptionPane.showMessageDialog(this, "Erro na deleção do Registro.");
            }
        }
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum registro selecionado.");
        }
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSairActionPerformed
        dispose();
    }//GEN-LAST:event_jbSairActionPerformed

    private void jbConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConsultarActionPerformed

        List<ContaReceber> contas = ContaReceberController.getInstance().pesquisar(jtfOpcoes.getText());

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Código (ID)");
        modelo.addColumn("Valor");
        modelo.addColumn("Data");
        modelo.addColumn("Venda");

        for (ContaReceber cr : contas) {
            modelo.addRow(new Object[]{cr.getId(), cr.getValor(), cr.getData(), cr.getVenda()});
        }
        jtContaReceber.removeAll();
        jtContaReceber.setModel(modelo);

        jtContaReceber.getColumnModel().getColumn(0).setPreferredWidth(60);
        jtContaReceber.getColumnModel().getColumn(1).setPreferredWidth(360);
    }//GEN-LAST:event_jbConsultarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ContaReceberSearchView cr = new ContaReceberSearchView();
                cr.setVisible(true);
                cr.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAlterar;
    private javax.swing.JButton jbConsultar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbInserir;
    private javax.swing.JButton jbSair;
    private javax.swing.JTable jtContaReceber;
    private javax.swing.JTextField jtfOpcoes;
    // End of variables declaration//GEN-END:variables
}

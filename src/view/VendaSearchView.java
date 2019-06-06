package view;

import control.VendaController;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Venda;

public class VendaSearchView extends javax.swing.JFrame {

    public VendaSearchView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jbInserir = new javax.swing.JButton();
        jbAlterar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbSair = new javax.swing.JButton();
        jtfOpcoes = new javax.swing.JTextField();
        jbConsultar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtVenda = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pesquise aqui");

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
                        .addComponent(jbInserir)
                        .addGap(18, 18, 18)
                        .addComponent(jbAlterar)
                        .addGap(18, 18, 18)
                        .addComponent(jbExcluir)
                        .addGap(50, 50, 50)
                        .addComponent(jbSair, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jtfOpcoes, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbExcluir)
                    .addComponent(jbAlterar)
                    .addComponent(jbInserir)
                    .addComponent(jbConsultar)
                    .addComponent(jbSair))
                .addContainerGap())
        );

        jtVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtVenda);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInserirActionPerformed
        VendaEditView v = new VendaEditView();
        v.setLocationRelativeTo(null);
        v.setModal(true);
        v.setVisible(true);

        jbConsultar.doClick();
    }//GEN-LAST:event_jbInserirActionPerformed

    private void jbAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlterarActionPerformed
        int linha = jtVenda.getSelectedRow();

        if (linha >= 0) {
            Long id = (Long) jtVenda.getValueAt(linha, 0);

            Venda venda = VendaController.getInstance().buscarID(id);

            VendaEditView v = new VendaEditView();
            v.setModal(true);
            v.setLocationRelativeTo(null);
            v.setDados(venda);
            v.setVisible(true);

            jbConsultar.doClick();

        } else {
            JOptionPane.showMessageDialog(this, "Nenhum Registro foi selecionado.");
        }
    }//GEN-LAST:event_jbAlterarActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        int linha = jtVenda.getSelectedRow();

        if (linha >= 0) {

            if (JOptionPane.showConfirmDialog(this, "Deseja deletar?",
                    "Opção", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                Long id = (Long) jtVenda.getValueAt(linha, 0);

                if (VendaController.getInstance().deletar(id)) {
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

        List<Venda> venda = VendaController.getInstance().pesquisar(jtfOpcoes.getText());

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Código (ID)");
        modelo.addColumn("Data");
        modelo.addColumn("id_cliente");
        modelo.addColumn("id_funcionario");

        for (Venda v : venda) {
            modelo.addRow(new Object[]{v.getId(), v.getData(), v.getCliente(), v.getFuncionario()});
        }
        jtVenda.removeAll();
        jtVenda.setModel(modelo);
        jtVenda.getColumnModel().getColumn(0).setPreferredWidth(60);
        jtVenda.getColumnModel().getColumn(1).setPreferredWidth(360);

    }//GEN-LAST:event_jbConsultarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VendaSearchView v = new VendaSearchView();
                v.setVisible(true);
                v.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAlterar;
    private javax.swing.JButton jbConsultar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbInserir;
    private javax.swing.JButton jbSair;
    private javax.swing.JTable jtVenda;
    private javax.swing.JTextField jtfOpcoes;
    // End of variables declaration//GEN-END:variables
}

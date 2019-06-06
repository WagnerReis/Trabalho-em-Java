
package view;

import control.ItemVendaController;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ItemVenda;

public class ItemVendaSearchView extends javax.swing.JFrame {

    public ItemVendaSearchView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtItemVenda = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jbInserir = new javax.swing.JButton();
        jbAlterar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbSair = new javax.swing.JButton();
        jtfOpcoes = new javax.swing.JTextField();
        jbConsultar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtItemVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtItemVenda);

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jbConsultar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                        .addComponent(jbInserir)
                        .addGap(18, 18, 18)
                        .addComponent(jbAlterar)
                        .addGap(18, 18, 18)
                        .addComponent(jbExcluir)
                        .addGap(48, 48, 48)
                        .addComponent(jbSair, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jtfOpcoes)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInserirActionPerformed
        ItemVendaEditView iv = new ItemVendaEditView();
        iv.setLocationRelativeTo(null);
        iv.setModal(true);
        iv.setVisible(true);

        jbConsultar.doClick();
    }//GEN-LAST:event_jbInserirActionPerformed

    private void jbAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlterarActionPerformed
        int linha = jtItemVenda.getSelectedRow();

        //Verifica se existe alguem selecionado
        if (linha >= 0) {
            Long id = (Long) jtItemVenda.getValueAt(linha, 0);

            ItemVenda item = ItemVendaController.getInstance().buscarID(id);

            ItemVendaEditView it =  new ItemVendaEditView();
            it.setModal(true);
            it.setLocationRelativeTo(null);
            it.setDados(item);
            it.setVisible(true);

            jbConsultar.doClick();

        }else{
            JOptionPane.showMessageDialog(this, "Nenhum Registro foi selecionado.");
        }
    }//GEN-LAST:event_jbAlterarActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        int linha = jtItemVenda.getSelectedRow();

        //Verifica se existe alguem selecionado
        if (linha >= 0) {

            if (JOptionPane.showConfirmDialog(this, "Deseja deletar?",
                "Opção", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

            // Pega o valor da primeira coluna o ID do aluno
            Long id = (Long) jtItemVenda.getValueAt(linha, 0);

            //Dispar o metodo de deleçao do a partir do ID do aluno passado
            if (ItemVendaController.getInstance().deletar(id)) {
                JOptionPane.showMessageDialog(this, "Registro deletado com sucesso.");

                //jbOkActionPerformed(evt); ou
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

        List<ItemVenda> itemVenda = ItemVendaController.getInstance().pesquisar(jtfOpcoes.getText());

        // Cria um defaultTableModel para ser usado na JTable com os campos que serão exibidos na tela
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Código (ID)");
        modelo.addColumn("Quantidade");
        modelo.addColumn("Valor");
        modelo.addColumn("Produto");
        modelo.addColumn("Venda");

        for (ItemVenda iv : itemVenda) {
            // Seta os valores do objeto para o JTableModel
            modelo.addRow(new Object[]{iv.getId(), iv.getQuantidade(), iv.getValor(), iv.getProduto(), iv.getVenda()});
        }
        //Limpa a JTable (Grid)
        jtItemVenda.removeAll();
        //Seta o modelo para a Grid
        jtItemVenda.setModel(modelo);

        //Ajusta o tamanho da primeira coluna
        jtItemVenda.getColumnModel().getColumn(0).setPreferredWidth(60);
        jtItemVenda.getColumnModel().getColumn(1).setPreferredWidth(360);

        //Ocutar coluna ID
        ///jtAluno.getColumnModel().getColumn(0).setMinWidth(0);
        //jtAluno.getColumnModel().getColumn(0).setMaxWidth(0);
        //jtAluno.getColumnModel().getColumn(0).setWidth(0);
    }//GEN-LAST:event_jbConsultarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ItemVendaSearchView iv = new ItemVendaSearchView();
                iv.setVisible(true);
                iv.setLocationRelativeTo(null);
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
    private javax.swing.JTable jtItemVenda;
    private javax.swing.JTextField jtfOpcoes;
    // End of variables declaration//GEN-END:variables
}

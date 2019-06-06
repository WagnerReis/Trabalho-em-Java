package view;

import control.FornecedorController;
import javax.swing.JOptionPane;
import model.Fornecedor;

public class FornecedorEditView extends javax.swing.JDialog {

    public FornecedorEditView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfCodigo = new javax.swing.JTextField();
        jtfTelefone = new javax.swing.JTextField();
        jtfCnpj = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTelefone = new javax.swing.JLabel();
        jCelular = new javax.swing.JLabel();
        jCnpj = new javax.swing.JLabel();
        jtfRazaoSocial = new javax.swing.JTextField();
        jtfCelular = new javax.swing.JTextField();
        jRazaoSocial = new javax.swing.JLabel();
        jCidade = new javax.swing.JLabel();
        jtfCidade = new javax.swing.JTextField();
        jtfEstado = new javax.swing.JTextField();
        jEstado = new javax.swing.JLabel();
        jRua = new javax.swing.JLabel();
        jtfRua = new javax.swing.JTextField();
        jtfBairro = new javax.swing.JTextField();
        jBairro = new javax.swing.JLabel();
        jNumero = new javax.swing.JLabel();
        jtfNumero = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jbCancelar = new javax.swing.JButton();
        jbSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jtfCodigo.setEnabled(false);
        jtfCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCodigoActionPerformed(evt);
            }
        });

        jtfCnpj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCnpjActionPerformed(evt);
            }
        });

        jLabel1.setText("Codigo");

        jTelefone.setText("Telefone");

        jCelular.setText("Celular");

        jCnpj.setText("Cnpj");

        jtfCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCelularActionPerformed(evt);
            }
        });

        jRazaoSocial.setText("Razao Social");

        jCidade.setText("Cidade");

        jtfEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfEstadoActionPerformed(evt);
            }
        });

        jEstado.setText("Estado");

        jRua.setText("Rua");

        jtfBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfBairroActionPerformed(evt);
            }
        });

        jBairro.setText("Bairro");

        jNumero.setText("Numero");

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbCancelar)
                .addGap(41, 41, 41)
                .addComponent(jbSalvar)
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCancelar)
                    .addComponent(jbSalvar))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTelefone)
                                        .addComponent(jCelular)
                                        .addComponent(jLabel1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jCidade)
                                            .addComponent(jEstado)
                                            .addComponent(jBairro, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(11, 11, 11)))
                                .addGap(22, 22, 22))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCnpj)
                                    .addComponent(jRazaoSocial))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfBairro, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                            .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                            .addComponent(jtfCidade, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                            .addComponent(jtfRazaoSocial)
                            .addComponent(jtfTelefone)
                            .addComponent(jtfCelular, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                            .addComponent(jtfCnpj)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jNumero)
                            .addGap(32, 32, 32)
                            .addComponent(jtfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jRua)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtfRua, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(27, 186, Short.MAX_VALUE))
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
                    .addComponent(jTelefone)
                    .addComponent(jtfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCelular)
                    .addComponent(jtfCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRazaoSocial)
                    .addComponent(jtfRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCnpj)
                    .addComponent(jtfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jEstado))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCidade))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBairro))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRua)
                    .addComponent(jtfRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jNumero)
                    .addComponent(jtfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCodigoActionPerformed

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        if (validarCamposObrigatorios()) { // Valida campos obrigatorios
            try {
                FornecedorController.getInstance().persistir(getDados());

                JOptionPane.showMessageDialog(this, "Salvo com sucesso!");
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Ocorreu o seguinte erro na gravação dos dados: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jtfBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfBairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfBairroActionPerformed

    private void jtfEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfEstadoActionPerformed

    private void jtfCnpjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCnpjActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCnpjActionPerformed

    private void jtfCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCelularActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FornecedorEditView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jBairro;
    private javax.swing.JLabel jCelular;
    private javax.swing.JLabel jCidade;
    private javax.swing.JLabel jCnpj;
    private javax.swing.JLabel jEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jNumero;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jRazaoSocial;
    private javax.swing.JLabel jRua;
    private javax.swing.JLabel jTelefone;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JTextField jtfBairro;
    private javax.swing.JTextField jtfCelular;
    private javax.swing.JTextField jtfCidade;
    private javax.swing.JTextField jtfCnpj;
    private javax.swing.JTextField jtfCodigo;
    private javax.swing.JTextField jtfEstado;
    private javax.swing.JTextField jtfNumero;
    private javax.swing.JTextField jtfRazaoSocial;
    private javax.swing.JTextField jtfRua;
    private javax.swing.JTextField jtfTelefone;
    // End of variables declaration//GEN-END:variables
private boolean validarCamposObrigatorios() {

        if (jtfTelefone.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Telefone é de preenchimento obrigatório");
            jtfTelefone.requestFocus();
            return false;
        }

        if (jtfCelular.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "celular é de preenchimento obrigatório");
            jtfCelular.requestFocus();
            return false;
        }

        if (jtfRazaoSocial.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Razao Social é de preenchimento obrigatório");
            jtfRazaoSocial.requestFocus();
            return false;
        }

        if (jtfCnpj.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Cnpj é de preenchimento obrigatório");
            jtfCnpj.requestFocus();
            return false;
        }

        if (jtfEstado.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Estado é de preenchimento obrigatório");
            jtfEstado.requestFocus();
            return false;
        }

        if (jtfCidade.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Cidade é de preenchimento obrigatório");
            jtfCidade.requestFocus();
            return false;
        }

        if (jtfBairro.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Bairroé de preenchimento obrigatório");
            jtfBairro.requestFocus();
            return false;
        }

        if (jtfRua.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Rua é de preenchimento obrigatório");
            jtfRua.requestFocus();
            return false;
        }

        if (jtfNumero.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Numero é de preenchimento obrigatório");
            jtfNumero.requestFocus();
            return false;
        }

        return true;
    }

    public Fornecedor getDados() {
        Fornecedor i = new Fornecedor();

        if (!jtfCodigo.getText().equals("")) {
            i.setId(Long.parseLong(jtfCodigo.getText()));
        }
        i.setTelefone(jtfTelefone.getText());
        i.setCelular(jtfCelular.getText());
        i.setRazaoSocial(jtfRazaoSocial.getText());
        i.setCnpj(jtfCnpj.getText());
        i.setEstado(jtfEstado.getText());
        i.setCidade(jtfCidade.getText());      
        i.setBairro(jtfBairro.getText());
        i.setRua(jtfRua.getText());
        i.setNumero(Integer.parseInt( jtfNumero.getText()));
       
        return i;
    }
    public void setDados(Fornecedor fornecedor) {

        jtfCodigo.setText(fornecedor.getId().toString());
 
        jtfTelefone.setText( fornecedor.getTelefone().toString());
        jtfCelular.setText( fornecedor.getCelular().toString());
        jtfRazaoSocial.setText( fornecedor.getRazaoSocial().toString());
        jtfCnpj.setText( fornecedor.getCnpj().toString());
        jtfEstado.setText( fornecedor.getEstado().toString());
        jtfCidade.setText( fornecedor.getCidade().toString());
        jtfBairro.setText( fornecedor.getBairro().toString());
        jtfRua.setText( fornecedor.getRua().toString());
        jtfNumero.setText(fornecedor.getNumero().toString());
        
    }

}



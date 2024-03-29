/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.*;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.text.*;

/**
 *
 * @author aluno
 */
public class FrmItemVenda extends javax.swing.JDialog {

    ArrayList<DaoProduto> pro;

    NumberFormatter nfPreco;

    NumberFormatter nfNumero;

    private static DaoItemVenda itemRetorno;

    /**
     * Creates new form FrmItemVenda
     */
    private FrmItemVenda(DaoItemVenda item) throws SQLException, ClassNotFoundException {

        initComponents();

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

        int x = (screen.width - this.getWidth()) / 2;

        int y = (screen.height - this.getHeight()) / 2;

        setBounds(x, y, this.getWidth(), this.getHeight());

        txtNumVenda.setText(String.valueOf(item.getNumVenda()));

        setModal(true);
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);

        try {

            DecimalFormat df = new DecimalFormat("R$ #,##0.00;-R$ #,##0.00");

            nfPreco = new NumberFormatter(df);
            nfPreco.setValueClass(Integer.class);

            /*
            DecimalFormat dfn = new DecimalFormat("###0");
            nfNumero = new NumberFormatter(dfn);
            nfNumero.setValueClass(Integer.class);
            DefaultFormatterFactory dffQtd = new DefaultFormatterFactory(nfNumero);
            txtQuantidade.setFormatterFactory(dffQtd);
             */
            DaoProduto produto = new DaoProduto();
            pro = new ArrayList<DaoProduto>();
            cmbProduto.removeAllItems();
            pro.addAll(produto.pesquisar(produto));

            for (DaoProduto daoPro : pro) {
                cmbProduto.addItem(String.valueOf(daoPro.getCodPro()));
            }
            if (item.getCodPro() != 0) {
                cmbProduto.setSelectedIndex(item.getCodPro());

                txtQuantidade.setValue(item.getQuantidade());
            } else {
                cmbProduto.setSelectedIndex(0);
            }
            setVisible(true);
        } catch (SQLException ex) {

            throw new SQLException("ocorreu um erro no banco de dados\n"
                    + ex.getMessage(), "Erro");

        } catch (ClassNotFoundException ex) {

            throw new ClassNotFoundException("ocorreu um erro no formulario de item\n"
                    + ex.getMessage());

        }
    }

    public static DaoItemVenda showItemVenda(DaoItemVenda item) throws SQLException,
            ClassNotFoundException {

        FrmItemVenda frmItemVenda = new FrmItemVenda(item);
        return itemRetorno;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNumVenda = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cmbProduto = new javax.swing.JComboBox<>();
        txtDescricao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtPrecoUnit = new javax.swing.JTextField();
        txtSubtotal = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtQuantidade = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Venda:");

        jLabel2.setText("Produto:");

        cmbProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProdutoActionPerformed(evt);
            }
        });

        jLabel3.setText("Quantidade:");

        jLabel4.setText("Preço Unitário:");

        jLabel5.setText("SubTotal:");

        jButton1.setMnemonic('C');
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setMnemonic('O');
        jButton2.setText("OK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtQuantidade.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                txtQuantidadeStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNumVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtQuantidade, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtSubtotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                        .addComponent(txtPrecoUnit, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNumVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPrecoUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProdutoActionPerformed
        // TODO add your handling code here:

        try {

            txtDescricao.setText(pro.get(cmbProduto.getSelectedIndex()).getDescricao());
            txtQuantidade.setValue(1);
            txtPrecoUnit.setText(nfPreco.valueToString(
                    pro.get(cmbProduto.getSelectedIndex()).getPrecoUnit()));
            txtSubtotal.setText(nfPreco.valueToString(Integer.valueOf(
                    txtQuantidade.getValue().toString()) * pro.get(
                            cmbProduto.getSelectedIndex()).getPrecoUnit()));

        } catch (ArrayIndexOutOfBoundsException ex) {

            /*
            JOptionPane.showMessageDialog(null, "ocorreu um erro ao selecionar um produto:\n"
                    + "O código digitado não corresponde a nenhum produto!\n"
                    + "Valor: " + ex.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
             */
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "ocorreu um erro ao selecionar um produto:\n"
                    + ex.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();

        }

    }//GEN-LAST:event_cmbProdutoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        itemRetorno = null;
        dispose();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        itemRetorno = new DaoItemVenda();
        try {

            itemRetorno.setNumVenda(Integer.valueOf(txtNumVenda.getText()));
            itemRetorno.setCodPro((pro.get(cmbProduto.getSelectedIndex()).getCodPro()));
            itemRetorno.setDescricao(pro.get(cmbProduto.getSelectedIndex()).getDescricao());
            itemRetorno.setQuantidade(Integer.valueOf(txtQuantidade.getValue().toString()));
            itemRetorno.setPrecoUnit(pro.get(cmbProduto.getSelectedIndex()).getPrecoUnit());
            itemRetorno.setSubtotal(Integer.valueOf(txtQuantidade.getValue().toString())
                    * pro.get(cmbProduto.getSelectedIndex()).getPrecoUnit());

            dispose();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "ocorreu um erro ao retornar o NOVO"
                    + " item para essa venda:\n" + ex.getMessage(), "Erro:",
                    JOptionPane.ERROR_MESSAGE);

        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtQuantidadeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_txtQuantidadeStateChanged
        // TODO add your handling code here:
        try{
            
            txtSubtotal.setText(nfPreco.valueToString(Integer.valueOf(
                    txtQuantidade.getValue().toString()) * pro.get(
                            cmbProduto.getSelectedIndex()).getPrecoUnit()));
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "ocorreu um erro ao retornar o subtotal"
                    + " item para essa venda:\n" + ex.getMessage(), "Erro:",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtQuantidadeStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbProduto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtNumVenda;
    private javax.swing.JTextField txtPrecoUnit;
    private javax.swing.JSpinner txtQuantidade;
    private javax.swing.JTextField txtSubtotal;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import dao.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author aluno
 */
public class FrmCliente extends javax.swing.JInternalFrame {

    MaskFormatter mfUf;
    MaskFormatter mfCep;
    MaskFormatter mfTel;
    MaskFormatter mfData;

    boolean gravar;
    boolean editar;

    /**
     * Creates new form FrmCliente
     */
    public FrmCliente() {

        try {

            initComponents();

            mfUf = new MaskFormatter("UU");
            mfUf.setPlaceholderCharacter('_');
            mfUf.setValueContainsLiteralCharacters(false);
            mfUf.setValueClass(String.class);
            DefaultFormatterFactory dffUf = new DefaultFormatterFactory(mfUf);
            txtUf.setFormatterFactory(dffUf);

            mfCep = new MaskFormatter("#####-###");
            mfCep.setPlaceholderCharacter('_');
            mfCep.setValueContainsLiteralCharacters(false);
            mfCep.setValueClass(String.class);
            DefaultFormatterFactory dffCep = new DefaultFormatterFactory(mfCep);
            txtCep.setFormatterFactory(dffCep);

            mfTel = new MaskFormatter("(##)#####-####");
            mfTel.setPlaceholderCharacter('_');
            mfTel.setValueContainsLiteralCharacters(false);
            mfTel.setValueClass(String.class);
            DefaultFormatterFactory dffTel = new DefaultFormatterFactory(mfTel);
            txtTelefone.setFormatterFactory(dffTel);

            mfData = new MaskFormatter("##/##/####");
            mfData.setPlaceholderCharacter('_');
            mfData.setValueContainsLiteralCharacters(true);
            mfData.setValueClass(String.class);
            DefaultFormatterFactory dffData = new DefaultFormatterFactory(mfData);
            txtDataNasc.setFormatterFactory(dffData);

        } catch (Exception ex) {

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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        btnIncluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        btnGravar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCep = new javax.swing.JFormattedTextField();
        txtTelefone = new javax.swing.JFormattedTextField();
        txtUf = new javax.swing.JFormattedTextField();
        txtDataNasc = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Cadastro de Cliente");
        setFrameIcon(null);
        setPreferredSize(new java.awt.Dimension(570, 370));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        btnIncluir.setText("Incluir");
        btnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnGravar.setText("Gravar");
        btnGravar.setEnabled(false);
        btnGravar.setNextFocusableComponent(btnCancelar);
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.setNextFocusableComponent(txtNome);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel1.setText("Código");

        txtCodigo.setEnabled(false);

        jLabel2.setText("Nome");

        txtNome.setEnabled(false);
        txtNome.setNextFocusableComponent(txtEndereco);

        jLabel3.setText("Endereço");

        txtEndereco.setEnabled(false);
        txtEndereco.setNextFocusableComponent(txtCidade);

        jLabel4.setText("Cidade");

        txtCidade.setEnabled(false);
        txtCidade.setNextFocusableComponent(txtBairro);

        jLabel5.setText("Bairro");

        txtBairro.setEnabled(false);
        txtBairro.setNextFocusableComponent(txtUf);

        jLabel6.setText("UF");

        jLabel7.setText("CEP");

        jLabel8.setText("Telefone");

        jLabel9.setText("Nascimento");

        txtCep.setEnabled(false);
        txtCep.setNextFocusableComponent(txtTelefone);

        txtTelefone.setEnabled(false);
        txtTelefone.setNextFocusableComponent(txtDataNasc);

        txtUf.setEnabled(false);
        txtUf.setNextFocusableComponent(txtCep);

        txtDataNasc.setEnabled(false);
        txtDataNasc.setNextFocusableComponent(btnGravar);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(txtEndereco)
                    .addComponent(txtBairro, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(txtCidade)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCep)
                    .addComponent(txtTelefone)
                    .addComponent(txtUf, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Endereço", "Cidade", "Bairro", "UF", "CEP", "Telefone", "Data de Nascimento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblClientes.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblClientes);
        if (tblClientes.getColumnModel().getColumnCount() > 0) {
            tblClientes.getColumnModel().getColumn(0).setResizable(false);
            tblClientes.getColumnModel().getColumn(1).setResizable(false);
            tblClientes.getColumnModel().getColumn(2).setResizable(false);
            tblClientes.getColumnModel().getColumn(3).setResizable(false);
            tblClientes.getColumnModel().getColumn(4).setResizable(false);
            tblClientes.getColumnModel().getColumn(5).setResizable(false);
            tblClientes.getColumnModel().getColumn(6).setResizable(false);
            tblClientes.getColumnModel().getColumn(7).setResizable(false);
            tblClientes.getColumnModel().getColumn(8).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btnIncluir)
                        .addGap(24, 24, 24)
                        .addComponent(btnAlterar)
                        .addGap(24, 24, 24)
                        .addComponent(btnExcluir)
                        .addGap(24, 24, 24)
                        .addComponent(btnPesquisar)
                        .addGap(24, 24, 24)
                        .addComponent(btnGravar)
                        .addGap(24, 24, 24)
                        .addComponent(btnCancelar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIncluir)
                    .addComponent(btnAlterar)
                    .addComponent(btnExcluir)
                    .addComponent(btnPesquisar)
                    .addComponent(btnGravar)
                    .addComponent(btnCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:

        DaoCliente c = new DaoCliente();

        c.setNome("");

        ArrayList<DaoCliente> ListaCliente;
        try {

            ListaCliente = c.pesquisar(c);
            AtualizaTable(ListaCliente);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro no Banco "
                    + "de dados" + ex.getMessage(),
                    "Erro:", JOptionPane.ERROR_MESSAGE);

        } catch (ClassNotFoundException ex) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao carregar "
                    + "o driver do BD" + ex.getMessage(),
                    "Erro:", JOptionPane.ERROR_MESSAGE);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro" + ex.getMessage(),
                    "Erro:", JOptionPane.ERROR_MESSAGE);

        }

    }//GEN-LAST:event_formWindowOpened

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        try {
            int codigo = Integer.parseInt(tblClientes.getValueAt(tblClientes.getSelectedRow(), 0).toString());

            Object[] opt = {" SIM ", " NÃO "};
            if (JOptionPane.showOptionDialog(this, "Deseja mesmo excluir esse cliente?", "Aviso",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    opt, opt[1]) == JOptionPane.YES_OPTION) {

                DaoCliente dc = new DaoCliente();
                dc.setCodCli(codigo);
                dc.excluir();
                formWindowOpened(null);
            }

            System.out.println("Codigo: " + codigo);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro\n" + ex.getMessage(),
                    "Erro:", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed
        // TODO add your handling code here:

        HabilitarBotoes(false);
        HabilitarCampos(true);
        txtCodigo.setEnabled(false);
        LimpaCampos();

        txtNome.requestFocus();
        gravar = true;

    }//GEN-LAST:event_btnIncluirActionPerformed

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        // TODO add your handling code here:

        try {

            DaoCliente dCli = new DaoCliente();

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            dCli.setNome(txtNome.getText());
            dCli.setEndereco(txtEndereco.getText());
            dCli.setCidade(txtCidade.getText());
            dCli.setBairro(txtBairro.getText());
            dCli.setUf(txtUf.getText());
            dCli.setCep(txtCep.getValue().toString());
            dCli.setTelefone(txtTelefone.getValue().toString());
            dCli.setDataNasc(sdf.parse(txtDataNasc.getText()));

            if (gravar) {

                dCli.incluir();

            } else {

                dCli.setCodCli(Integer.valueOf(txtCodigo.getText()));
                dCli.alterar();

            }

            HabilitarBotoes(true);
            HabilitarCampos(false);

            gravar = false;
            editar = false;
            LimpaCampos();

            formWindowOpened(null);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro no Banco "
                    + "de dados" + ex.getMessage(),
                    "Erro:", JOptionPane.ERROR_MESSAGE);

        } catch (ClassNotFoundException ex) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao carregar "
                    + "o driver do BD" + ex.getMessage(),
                    "Erro:", JOptionPane.ERROR_MESSAGE);

        } catch (ParseException ex) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro de conversão"
                    + ex.getMessage(),
                    "Erro:", JOptionPane.ERROR_MESSAGE);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro" + ex.getMessage(),
                    "Erro:", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_btnGravarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        // TODO add your handling code here:
        HabilitarBotoes(false);
        HabilitarCampos(true);
        LimpaCampos();
        txtCodigo.setEnabled(false);
        txtNome.requestFocus();
        editar = true;
        try {

            if (tblClientes.getRowCount() > 0) {

                int posLinha = tblClientes.getSelectedRow();

                if (posLinha >= 0) {

                    txtCodigo.setText(tblClientes.getValueAt(posLinha, 0).toString());
                    txtNome.setText(tblClientes.getValueAt(posLinha, 1).toString());
                    txtEndereco.setText(tblClientes.getValueAt(posLinha, 2).toString());
                    txtCidade.setText(tblClientes.getValueAt(posLinha, 3).toString());
                    txtBairro.setText(tblClientes.getValueAt(posLinha, 4).toString());

                    txtUf.setValue(tblClientes.getValueAt(posLinha, 5).toString());
                    txtCep.setValue(tblClientes.getValueAt(posLinha, 6).toString());

                    if (tblClientes.getValueAt(posLinha, 7).toString()
                            .equals("(__)_____-____")) {

                        txtTelefone.setValue("");

                    } else {

                        txtTelefone.setValue(
                                mfTel.stringToValue(tblClientes
                                        .getValueAt(posLinha, 7).toString()).toString());

                    }

                    txtDataNasc.setValue(tblClientes.getValueAt(posLinha, 8).toString());

                } else {

                    JOptionPane.showMessageDialog(null, "Selecione um cliente para alterar",
                            "Erro:", JOptionPane.ERROR_MESSAGE);
                    btnCancelarActionPerformed(null);

                }
            } else {

                JOptionPane.showMessageDialog(null, "Não existem clientes cadastrados!",
                        "Erro:", JOptionPane.ERROR_MESSAGE);
                btnCancelarActionPerformed(null);
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro" + ex.getMessage(),
                    "Erro:", JOptionPane.ERROR_MESSAGE);

        }

    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        // TODO add your handling code here:
        DaoCliente c = new DaoCliente();
        String nome = JOptionPane.showInputDialog(null, "informe o nome do cliente"
                + "ou parte dele: ", "Pesquisar", JOptionPane.QUESTION_MESSAGE);
        if (nome != null) {
            c.setNome(nome);
            btnCancelar.setEnabled(true);
        }else{
            c.setNome("");
        }

        try {

            ArrayList<DaoCliente> ListaClientes = c.pesquisar(c);
            AtualizaTable(ListaClientes);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro no Banco "
                    + "de dados" + ex.getMessage(),
                    "Erro:", JOptionPane.ERROR_MESSAGE);

        } catch (ClassNotFoundException ex) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao carregar "
                    + "o driver do BD" + ex.getMessage(),
                    "Erro:", JOptionPane.ERROR_MESSAGE);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro" + ex.getMessage(),
                    "Erro:", JOptionPane.ERROR_MESSAGE);

        }

    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        HabilitarBotoes(true);
        HabilitarCampos(false);
        LimpaCampos();
        gravar = false;
        editar = false;
        formInternalFrameOpened(null);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
        formWindowOpened(null);
    }//GEN-LAST:event_formInternalFrameOpened

    private void LimpaTable() {

        DefaultTableModel model = (DefaultTableModel) tblClientes.getModel();

        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }

    }

    private void AtualizaTable(ArrayList<DaoCliente> clientes) {

        LimpaTable();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        if (!clientes.isEmpty()) {

            DefaultTableModel dadosClientes = (DefaultTableModel) tblClientes.getModel();

            String Linha[] = new String[]{"", "", "", "", "", "", "", "", ""};

            try {

                int pos = -1;

                for (DaoCliente cliente : clientes) {

                    pos++;

                    dadosClientes.addRow(Linha);

                    dadosClientes.setValueAt(cliente.getCodCli(), pos, 0);
                    dadosClientes.setValueAt(cliente.getNome(), pos, 1);
                    dadosClientes.setValueAt(cliente.getEndereco(), pos, 2);
                    dadosClientes.setValueAt(cliente.getCidade(), pos, 3);
                    dadosClientes.setValueAt(cliente.getBairro(), pos, 4);
                    dadosClientes.setValueAt(cliente.getUf().toUpperCase(), pos, 5);
                    dadosClientes.setValueAt(cliente.getCep(), pos, 6);

                    dadosClientes.setValueAt(mfTel.valueToString(cliente.getTelefone()), pos, 7);

                    dadosClientes.setValueAt(sdf.format(cliente.getDataNasc()), pos, 8);

                }

                tblClientes.setModel(dadosClientes);

            } catch (Exception ex) {

            }

        }

    }

    private void HabilitarBotoes(boolean hab) {

        btnIncluir.setEnabled(hab);
        btnAlterar.setEnabled(hab);
        btnExcluir.setEnabled(hab);
        btnPesquisar.setEnabled(hab);
        btnGravar.setEnabled(!hab);
        btnCancelar.setEnabled(!hab);

    }

    private void HabilitarCampos(boolean hab) {

        txtCodigo.setEnabled(hab);
        txtNome.setEnabled(hab);
        txtEndereco.setEnabled(hab);
        txtCidade.setEnabled(hab);
        txtBairro.setEnabled(hab);
        txtUf.setEnabled(hab);
        txtCep.setEnabled(hab);
        txtTelefone.setEnabled(hab);
        txtDataNasc.setEnabled(hab);

    }

    private void LimpaCampos() {

        txtCodigo.setText("");
        txtBairro.setText("");
        txtCep.setText("");
        txtCidade.setText("");
        txtDataNasc.setText("");
        txtEndereco.setText("");
        txtNome.setText("");
        txtTelefone.setText("");
        txtUf.setText("");

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnGravar;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtCep;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JFormattedTextField txtDataNasc;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtTelefone;
    private javax.swing.JFormattedTextField txtUf;
    // End of variables declaration//GEN-END:variables
}

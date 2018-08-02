/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import ctrl.ClienteCtrl;
import ctrl.FamiliaCliCtrl;
import ctrl.DocumentJTextFIXACtrl;
import ctrl.DocumentJTextNumerosCtrl;
import dao.ClienteDao;
import dao.ContasDao;
import dao.FamiliaCliDAO;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import formularios.SisPrinc;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import sisvenda.SistemaVendas;

/**
 *
 * @author Adm
 */
public class GerirCliente extends javax.swing.JFrame {
    
    public GerirCliente() {
        initComponents();
        
        
        System.out.println("consulta cod_cli gereir cliente = "+SisPrinc.codCli);
        
        if(SisPrinc.codCli > 0){
        //formulario de consulta de clientes
            jbCadastrar.setEnabled(false);
            jbEdit.setEnabled(true);
            ClienteDao objDao = new ClienteDao();
            ResultSet objRs = objDao.selecionarCliente(String.valueOf(SisPrinc.codCli));
            System.out.println("consulta = "+SisPrinc.codCli);

            try {

               objRs.first();
               
                //DADOS PESSOAS
                    edtNomeCli.setText(objRs.getString("NOME"));
                    System.out.println(objRs.getString("NOME"));
                    edtApelidoCli.setText(objRs.getString("APELIDO"));
                    edtDNcli.setText(objRs.getString("DATA_NASC"));
                    cbECcli.setSelectedItem(objRs.getString("ESTADO_CIVIL"));
                //CONTATOS 
                    edtCellCLi.setText(objRs.getString("CELULAR"));
                    edtTelResiCli.setText(objRs.getString("TEL_RESI"));
                    edtTelComerCli.setText(objRs.getString("TEL_COMER"));
                    edtEmailCli.setText(objRs.getString("EMAIL"));
                //ENDEREÇO
                    edtCepCli.setText(objRs.getString("CEP"));
                    edtRuaCli.setText(objRs.getString("RUA"));
                    edtNumCli.setText(objRs.getString("NUMERO"));
                    edtCompCLi.setText(objRs.getString("COMPLEMENTO"));
                    edtBairroCli.setText(objRs.getString("BAIRRO"));
                    edtCidadeCli.setText(objRs.getString("CIDADE"));
                    edtEstadoCli.setText(objRs.getString("ESTADO"));
                    edtReferCli.setText(objRs.getString("REFERENCIA"));
                //DOCUMENTOS
                    edtRGcli.setText(objRs.getString("DOCUMENTO"));
                    edtCnpjCpfCli.setText(objRs.getString("CPF_CNPJ")); 
                    if(objRs.getString("CPF_OR_CNPJ").equals("CPF")){
                        radioCpf.setSelected(true);
                        radioCnpj.setSelected(false);
                    }else{
                        radioCpf.setSelected(false);
                        radioCnpj.setSelected(true);

                    }

                //CREDITO
                    edtCreditoCli.setText(objRs.getString("VALOR_CREDITO"));
                //FAMÍLIA
                    FamiliaCliDAO objFamilyDao = new FamiliaCliDAO();
                    ResultSet objFamilyRs = objFamilyDao.selectFamilyPorCli(SisPrinc.codCli);
                    System.out.println("consulta = "+SisPrinc.codCli);

                    DefaultTableModel  objTMfamily = (DefaultTableModel) tableFamiliaCli.getModel();

                    try {
                        while(objFamilyRs.next()){
                            String linha[] = {
                                objFamilyRs.getString("NOME"),
                                objFamilyRs.getString("RG"),
                                objFamilyRs.getString("CPF"),
                                objFamilyRs.getString("RELACAO")
                            };
                            objTMfamily.addRow(linha);
                        }
                    }catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "erro ao fazer cunsulta de Familia de clientes: "+ex);
                    }
                    btnAddFamiliaCli.setEnabled(false);                      
                    btnExcluirFamiliaCli.setEnabled(false);

                //ANOTAÇÕES
                    txtObsCli.setText(objRs.getString("OBS"));
                //FOTO
                        
                } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "erro ao fazer cunsulta de clientes GerirCliente: "+ex);
            }
        }else{
        //formulario de cadastro de clientes
        
                edtNomeCli.setEditable(true);
                edtApelidoCli.setEditable(true);
                edtDNcli.setEditable(true);
                cbECcli.setEnabled(true);
            //CONTATOS 
                edtCellCLi.setEditable(true);
                edtTelResiCli.setEditable(true);
                edtTelComerCli.setEditable(true);
                edtEmailCli.setEditable(true);
            //ENDEREÇO
                edtCepCli.setEditable(true);
                edtRuaCli.setEditable(true);
                edtNumCli.setEditable(true);
                edtCompCLi.setEditable(true);
                edtBairroCli.setEditable(true);
                edtCidadeCli.setEditable(true);
                edtEstadoCli.setEditable(true);
                edtReferCli.setEditable(true);
            //DOCUMENTOS
                edtRGcli.setEditable(true);
                edtCnpjCpfCli.setEditable(true);
                radioCpf.setEnabled(true);
                radioCnpj.setEnabled(true);

            //CREDITO
                edtCreditoCli.setEditable(true);
            //FAMÍLIA
                btnAddFamiliaCli.setEnabled(true);       
                btnExcluirFamiliaCli.setEnabled(true);
                cbRalacaoCli.setEnabled(true);
                edtNomeFamiliaCli.setEditable(true);
                edtRgFamiliaCli.setEditable(true);
                edtCpfFamiliaCli.setEditable(true);

            //ANOTAÇÕES
                txtObsCli.setEditable(true);
        
            edtNomeCli.selectAll();
            edtNomeCli.setFocusable(true);            
            jbCadastrar.setEnabled(true);
            jbEdit.setEnabled(false);
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

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jbCadastrar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jbEdit = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        edtNomeCli = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        edtApelidoCli = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        edtCellCLi = new javax.swing.JFormattedTextField();
        edtTelResiCli = new javax.swing.JFormattedTextField();
        edtTelComerCli = new javax.swing.JFormattedTextField();
        edtDNcli = new javax.swing.JFormattedTextField();
        edtEmailCli = new javax.swing.JTextField();
        labelFoto = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        edtRGcli = new javax.swing.JTextField();
        edtCnpjCpfCli = new javax.swing.JTextField();
        radioCnpj = new javax.swing.JRadioButton();
        radioCpf = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        edtCepCli = new javax.swing.JFormattedTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        edtRuaCli = new javax.swing.JTextField();
        edtNumCli = new javax.swing.JTextField();
        edtCompCLi = new javax.swing.JTextField();
        edtBairroCli = new javax.swing.JTextField();
        edtCidadeCli = new javax.swing.JTextField();
        edtEstadoCli = new javax.swing.JTextField();
        edtReferCli = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        edtCreditoCli = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        edtCpfFamiliaCli = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        cbECcli = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObsCli = new javax.swing.JTextArea();
        jLabel31 = new javax.swing.JLabel();
        btnExcluirFamiliaCli = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableFamiliaCli = new javax.swing.JTable();
        edtNomeFamiliaCli = new javax.swing.JTextField();
        jlMenssager = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        edtRgFamiliaCli = new javax.swing.JTextField();
        cbRalacaoCli = new javax.swing.JComboBox<>();
        btnAddFamiliaCli = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setFocusTraversalPolicyProvider(true);
        setLocation(new java.awt.Point(200, 10));
        setUndecorated(true);
        setOpacity(0.96F);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.BorderLayout(0, 3));

        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel3.setNextFocusableComponent(edtNomeCli);
        jPanel3.setLayout(new java.awt.BorderLayout());

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CADASTRO DE CLIENTE");
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(222, 35));
        jLabel1.setVerifyInputWhenFocusTarget(false);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel3.add(jLabel1, java.awt.BorderLayout.NORTH);

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jbCadastrar.setBackground(new java.awt.Color(32, 32, 32));
        jbCadastrar.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jbCadastrar.setForeground(new java.awt.Color(239, 239, 239));
        jbCadastrar.setText("CADASTRAR");
        jbCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(32, 32, 32));
        jButton2.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(239, 239, 239));
        jButton2.setText("CANCELAR");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton2MousePressed(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jbEdit.setBackground(new java.awt.Color(32, 32, 32));
        jbEdit.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jbEdit.setForeground(new java.awt.Color(239, 239, 239));
        jbEdit.setText("EDITAR");
        jbEdit.setAlignmentY(0.0F);
        jbEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addComponent(jbEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(jbCadastrar)
                .addGap(65, 65, 65)
                .addComponent(jButton2)
                .addContainerGap(182, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        jPanel3.add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setPreferredSize(new java.awt.Dimension(913, 610));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("CONTATOS:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 155, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("DADOS PESSOAIS");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 366, -1));

        edtNomeCli.setEditable(false);
        edtNomeCli.setDocument(new DocumentJTextFIXACtrl());
        edtNomeCli.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtNomeCli.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                edtNomeCliFocusGained(evt);
            }
        });
        edtNomeCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtNomeCliActionPerformed(evt);
            }
        });
        edtNomeCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                edtNomeCliKeyPressed(evt);
            }
        });
        jPanel1.add(edtNomeCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 250, -1));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel4.setLayout(new java.awt.BorderLayout());
        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 667, 875, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Nome Completo: ");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Apelido:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 96, -1));

        edtApelidoCli.setEditable(false);
        edtApelidoCli.setDocument(new DocumentJTextFIXACtrl());
        edtApelidoCli.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtApelidoCli.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                edtApelidoCliFocusGained(evt);
            }
        });
        edtApelidoCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtApelidoCliActionPerformed(evt);
            }
        });
        edtApelidoCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                edtApelidoCliKeyPressed(evt);
            }
        });
        jPanel1.add(edtApelidoCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 250, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Data Nascimento:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Estado Civil:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 79, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("E-mail:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 270, 79, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Telefone Comer.:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 241, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Telefone Reside.:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 212, 104, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("Celular:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 183, 104, -1));

        edtCellCLi.setEditable(false);
        edtCellCLi.setDocument(new DocumentJTextNumerosCtrl());
        try {
            edtCellCLi.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        edtCellCLi.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtCellCLi.setToolTipText("");
        edtCellCLi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtCellCLi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtCellCLiActionPerformed(evt);
            }
        });
        edtCellCLi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                edtCellCLiKeyPressed(evt);
            }
        });
        jPanel1.add(edtCellCLi, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 178, 250, -1));

        edtTelResiCli.setEditable(false);
        edtTelResiCli.setDocument(new DocumentJTextNumerosCtrl());
        try {
            edtTelResiCli.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        edtTelResiCli.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtTelResiCli.setToolTipText("");
        edtTelResiCli.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtTelResiCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                edtTelResiCliKeyPressed(evt);
            }
        });
        jPanel1.add(edtTelResiCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 207, 250, -1));

        edtTelComerCli.setEditable(false);
        edtTelComerCli.setDocument(new DocumentJTextNumerosCtrl());
        try {
            edtTelComerCli.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        edtTelComerCli.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtTelComerCli.setToolTipText("");
        edtTelComerCli.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtTelComerCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                edtTelComerCliKeyPressed(evt);
            }
        });
        jPanel1.add(edtTelComerCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 236, 250, -1));

        edtDNcli.setEditable(false);
        edtDNcli.setDocument(new DocumentJTextNumerosCtrl());
        try {
            edtDNcli.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        edtDNcli.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtDNcli.setToolTipText("");
        edtDNcli.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtDNcli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtDNcliActionPerformed(evt);
            }
        });
        edtDNcli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                edtDNcliKeyPressed(evt);
            }
        });
        jPanel1.add(edtDNcli, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 250, -1));

        edtEmailCli.setEditable(false);
        edtEmailCli.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtEmailCli.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                edtEmailCliFocusGained(evt);
            }
        });
        edtEmailCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtEmailCliActionPerformed(evt);
            }
        });
        edtEmailCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                edtEmailCliKeyPressed(evt);
            }
        });
        jPanel1.add(edtEmailCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 268, 250, -1));

        labelFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelFoto.setText("FOTO");
        labelFoto.setToolTipText("");
        labelFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        labelFoto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(labelFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 40, 130, 120));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("DOCUMENTOS:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 132, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("FOTO:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, 132, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("Identidade:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 103, -1));

        edtRGcli.setEditable(false);
        edtRGcli.setDocument(new DocumentJTextNumerosCtrl());
        edtRGcli.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtRGcli.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                edtRGcliFocusGained(evt);
            }
        });
        edtRGcli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtRGcliActionPerformed(evt);
            }
        });
        edtRGcli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                edtRGcliKeyPressed(evt);
            }
        });
        jPanel1.add(edtRGcli, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, 149, -1));

        edtCnpjCpfCli.setEditable(false);
        edtCnpjCpfCli.setDocument(new DocumentJTextNumerosCtrl());
        edtCnpjCpfCli.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtCnpjCpfCli.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                edtCnpjCpfCliFocusGained(evt);
            }
        });
        edtCnpjCpfCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtCnpjCpfCliActionPerformed(evt);
            }
        });
        edtCnpjCpfCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                edtCnpjCpfCliKeyPressed(evt);
            }
        });
        jPanel1.add(edtCnpjCpfCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, 149, -1));

        radioCnpj.setText("CNPJ");
        radioCnpj.setEnabled(false);
        radioCnpj.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radioCnpjItemStateChanged(evt);
            }
        });
        radioCnpj.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                radioCnpjStateChanged(evt);
            }
        });
        radioCnpj.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioCnpjMouseClicked(evt);
            }
        });
        jPanel1.add(radioCnpj, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, -1, -1));

        radioCpf.setText("CPF");
        radioCpf.setEnabled(false);
        radioCpf.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radioCpfItemStateChanged(evt);
            }
        });
        radioCpf.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                radioCpfStateChanged(evt);
            }
        });
        radioCpf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioCpfMouseClicked(evt);
            }
        });
        jPanel1.add(radioCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("ENDEREÇO:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 297, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setText("CEP:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 104, 25));

        edtCepCli.setEditable(false);
        edtCepCli.setDocument(new DocumentJTextNumerosCtrl());
        try {
            edtCepCli.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        edtCepCli.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edtCepCli.setToolTipText("");
        edtCepCli.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtCepCli.setMargin(new java.awt.Insets(1, 1, 1, 1));
        edtCepCli.setMinimumSize(new java.awt.Dimension(58, 24));
        edtCepCli.setPreferredSize(new java.awt.Dimension(59, 25));
        edtCepCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                edtCepCliKeyPressed(evt);
            }
        });
        jPanel1.add(edtCepCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 250, 25));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setText("Rua:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 104, 25));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setText("Numero:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 104, 25));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setText("Complemento:");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 104, 25));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel22.setText("Bairro:");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 104, 25));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setText("Cidade:");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 104, 25));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel24.setText("Estado:");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 104, 25));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel25.setText("Referência:");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, 104, 25));

        edtRuaCli.setEditable(false);
        edtRuaCli.setDocument(new DocumentJTextFIXACtrl());
        edtRuaCli.setMargin(new java.awt.Insets(1, 1, 1, 1));
        edtRuaCli.setMinimumSize(new java.awt.Dimension(58, 24));
        edtRuaCli.setPreferredSize(new java.awt.Dimension(59, 25));
        edtRuaCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtRuaCliActionPerformed(evt);
            }
        });
        edtRuaCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                edtRuaCliKeyPressed(evt);
            }
        });
        jPanel1.add(edtRuaCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, 250, 25));

        edtNumCli.setEditable(false);
        edtNumCli.setMargin(new java.awt.Insets(1, 1, 1, 1));
        edtNumCli.setMinimumSize(new java.awt.Dimension(58, 24));
        edtNumCli.setPreferredSize(new java.awt.Dimension(59, 25));
        edtNumCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtNumCliActionPerformed(evt);
            }
        });
        edtNumCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                edtNumCliKeyPressed(evt);
            }
        });
        jPanel1.add(edtNumCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, 250, 25));

        edtCompCLi.setEditable(false);
        edtCompCLi.setDocument(new DocumentJTextFIXACtrl());
        edtCompCLi.setMargin(new java.awt.Insets(1, 1, 1, 1));
        edtCompCLi.setMinimumSize(new java.awt.Dimension(58, 24));
        edtCompCLi.setPreferredSize(new java.awt.Dimension(59, 25));
        edtCompCLi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtCompCLiActionPerformed(evt);
            }
        });
        edtCompCLi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                edtCompCLiKeyPressed(evt);
            }
        });
        jPanel1.add(edtCompCLi, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, 250, 25));

        edtBairroCli.setEditable(false);
        edtBairroCli.setDocument(new DocumentJTextFIXACtrl());
        edtBairroCli.setMargin(new java.awt.Insets(1, 1, 1, 1));
        edtBairroCli.setMinimumSize(new java.awt.Dimension(58, 24));
        edtBairroCli.setPreferredSize(new java.awt.Dimension(59, 25));
        edtBairroCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtBairroCliActionPerformed(evt);
            }
        });
        edtBairroCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                edtBairroCliKeyPressed(evt);
            }
        });
        jPanel1.add(edtBairroCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 440, 250, 25));

        edtCidadeCli.setEditable(false);
        edtCidadeCli.setDocument(new DocumentJTextFIXACtrl());
        edtCidadeCli.setMargin(new java.awt.Insets(1, 1, 1, 1));
        edtCidadeCli.setMinimumSize(new java.awt.Dimension(58, 24));
        edtCidadeCli.setPreferredSize(new java.awt.Dimension(59, 25));
        edtCidadeCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtCidadeCliActionPerformed(evt);
            }
        });
        edtCidadeCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                edtCidadeCliKeyPressed(evt);
            }
        });
        jPanel1.add(edtCidadeCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 470, 250, 25));

        edtEstadoCli.setEditable(false);
        edtEstadoCli.setDocument(new DocumentJTextFIXACtrl());
        edtEstadoCli.setMargin(new java.awt.Insets(1, 1, 1, 1));
        edtEstadoCli.setMinimumSize(new java.awt.Dimension(58, 24));
        edtEstadoCli.setPreferredSize(new java.awt.Dimension(59, 25));
        edtEstadoCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtEstadoCliActionPerformed(evt);
            }
        });
        edtEstadoCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                edtEstadoCliKeyPressed(evt);
            }
        });
        jPanel1.add(edtEstadoCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 500, 250, 25));

        edtReferCli.setEditable(false);
        edtReferCli.setDocument(new DocumentJTextFIXACtrl());
        edtReferCli.setMargin(new java.awt.Insets(1, 1, 1, 1));
        edtReferCli.setMinimumSize(new java.awt.Dimension(58, 24));
        edtReferCli.setPreferredSize(new java.awt.Dimension(59, 25));
        edtReferCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtReferCliActionPerformed(evt);
            }
        });
        edtReferCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                edtReferCliKeyPressed(evt);
            }
        });
        jPanel1.add(edtReferCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 530, 250, 25));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setText("FAMÍLIA:");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, -1, -1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel27.setText("Nome Completo:");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, -1, -1));

        edtCreditoCli.setEditable(false);
        edtCreditoCli.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)));
        edtCreditoCli.setPreferredSize(new java.awt.Dimension(59, 23));
        edtCreditoCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtCreditoCliActionPerformed(evt);
            }
        });
        edtCreditoCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                edtCreditoCliKeyPressed(evt);
            }
        });
        jPanel1.add(edtCreditoCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, 170, -1));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel28.setText("Identidade:");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, 104, -1));

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel29.setText("CPF:");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 210, -1, -1));

        edtCpfFamiliaCli.setEditable(false);
        edtCpfFamiliaCli.setDocument(new DocumentJTextNumerosCtrl());
        edtCpfFamiliaCli.setPreferredSize(new java.awt.Dimension(60, 23));
        edtCpfFamiliaCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtCpfFamiliaCliActionPerformed(evt);
            }
        });
        edtCpfFamiliaCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                edtCpfFamiliaCliKeyPressed(evt);
            }
        });
        jPanel1.add(edtCpfFamiliaCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(726, 210, 150, -1));

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel30.setText("Relação:");
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 250, 70, -1));

        cbECcli.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SOLTEIRO(A)", "NOIVO(A)", "CASADO(A)", "VIUVO(A)" }));
        cbECcli.setEnabled(false);
        cbECcli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbECcliActionPerformed(evt);
            }
        });
        cbECcli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbECcliKeyPressed(evt);
            }
        });
        jPanel1.add(cbECcli, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 250, 25));

        txtObsCli.setEditable(false);
        txtObsCli.setColumns(20);
        txtObsCli.setDocument(new DocumentJTextFIXACtrl());
        txtObsCli.setRows(5);
        txtObsCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtObsCliKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(txtObsCli);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 430, 460, 120));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel31.setText("CRÉDITO:");
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, -1, -1));

        btnExcluirFamiliaCli.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnExcluirFamiliaCli.setText("Excluir");
        btnExcluirFamiliaCli.setEnabled(false);
        btnExcluirFamiliaCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirFamiliaCliActionPerformed(evt);
            }
        });
        jPanel1.add(btnExcluirFamiliaCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(807, 240, -1, 40));

        tableFamiliaCli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Identidade", "CPF", "Relação"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableFamiliaCli.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tableFamiliaCli);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 290, 461, 100));

        edtNomeFamiliaCli.setEditable(false);
        edtNomeFamiliaCli.setDocument(new DocumentJTextFIXACtrl());
        edtNomeFamiliaCli.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtNomeFamiliaCli.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                edtNomeFamiliaCliFocusGained(evt);
            }
        });
        edtNomeFamiliaCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtNomeFamiliaCliActionPerformed(evt);
            }
        });
        edtNomeFamiliaCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                edtNomeFamiliaCliKeyPressed(evt);
            }
        });
        jPanel1.add(edtNomeFamiliaCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 180, 340, -1));

        jlMenssager.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        jlMenssager.setForeground(new java.awt.Color(255, 51, 51));
        jlMenssager.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlMenssager.setText("---<Cadastrando Cliente>---");
        jlMenssager.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jlMenssager.setNextFocusableComponent(edtNomeCli);
        jPanel1.add(jlMenssager, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 900, 50));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel32.setText("ANOTAÇÕES");
        jPanel1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 400, -1, -1));

        edtRgFamiliaCli.setEditable(false);
        edtRgFamiliaCli.setDocument(new DocumentJTextNumerosCtrl());
        edtRgFamiliaCli.setPreferredSize(new java.awt.Dimension(59, 23));
        edtRgFamiliaCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtRgFamiliaCliActionPerformed(evt);
            }
        });
        edtRgFamiliaCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                edtRgFamiliaCliKeyPressed(evt);
            }
        });
        jPanel1.add(edtRgFamiliaCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 210, 127, -1));

        cbRalacaoCli.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PAI", "MÃE", "ESPOSO(A)", "TIO(A)", "OUTRO" }));
        cbRalacaoCli.setEnabled(false);
        cbRalacaoCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRalacaoCliActionPerformed(evt);
            }
        });
        jPanel1.add(cbRalacaoCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 245, 150, 25));

        btnAddFamiliaCli.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAddFamiliaCli.setText("Adicionar");
        btnAddFamiliaCli.setEnabled(false);
        btnAddFamiliaCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFamiliaCliActionPerformed(evt);
            }
        });
        jPanel1.add(btnAddFamiliaCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 240, 90, 40));

        jPanel3.add(jPanel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        getAccessibleContext().setAccessibleParent(edtNomeCli);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarActionPerformed
        ClienteCtrl objCliente = new ClienteCtrl();
        ClienteDao objDao = new ClienteDao();
        
        String limCompra = edtCreditoCli.getText();
        limCompra = limCompra.replace(",", ".");
        
        int cod_cli = -1;
        //DADOS PESSOAIS
        objCliente.setId(0);
        objCliente.setNome(edtNomeCli.getText());
        objCliente.setApelido(edtApelidoCli.getText());
        objCliente.setData_nasc(edtDNcli.getText());
        objCliente.setEstado_civil(cbECcli.getItemAt(cbECcli.getSelectedIndex()));
        
        //CONTATOS
        objCliente.setCelular(edtCellCLi.getText());
        objCliente.setTel_resi(edtTelResiCli.getText());
        objCliente.setTel_comer(edtTelComerCli.getText());
        objCliente.setEmail(edtEmailCli.getText());
        
        //ENDEREÇOS
        String[] cep = edtCepCli.getText().split("-");
        if(edtCepCli.getText().equals("") || edtCepCli.getText().equals("-"))objCliente.setCep(0);
        else objCliente.setCep(Integer.parseInt(cep[0]+cep[1]));
        objCliente.setRua(edtRuaCli.getText());
        if(edtNumCli.getText().equals("")) objCliente.setNumero(0);
        else objCliente.setNumero(Integer.parseInt(edtNumCli.getText()));
        objCliente.setComplem(edtCompCLi.getText());
        objCliente.setBairro(edtBairroCli.getText());
        objCliente.setCidade(edtCidadeCli.getText());
        objCliente.setEstado(edtEstadoCli.getText());
        objCliente.setReferencia(edtReferCli.getText());
        
        //DOCUMENTOS
        if(edtRGcli.getText().equals("")) objCliente.setRg(0);
        else objCliente.setRg(Integer.parseInt(edtRGcli.getText()));
        if(edtCnpjCpfCli.getText().equals("")) objCliente.setCpf_cnpj(0);
        else objCliente.setCpf_cnpj(Integer.parseInt(edtCnpjCpfCli.getText()));
        if(radioCpf.isSelected()){
            objCliente.setCpf_or_cnpj("CPF");
        }else{
            objCliente.setCpf_or_cnpj("CNPJ");
        }
        //CREDITO
        objCliente.setValor_credito(Double.valueOf(limCompra));
        
        //FOTO
        objCliente.setFoto(null);
        
        //ANOTAÇÕES
        objCliente.setObs(txtObsCli.getText());
        
        if(edtNomeCli.getText().equals("") || edtCnpjCpfCli.getText().equals("") || 
            edtRGcli.getText().equals("") )
        {   jlMenssager.setText("Preencha todos os Dados Pessoais"); 
        }else if(objDao.verificarRgCpf(edtRGcli.getText(),edtCnpjCpfCli.getText())){
            jlMenssager.setText("Cliente já cadastrado"); 
            cbECcli.nextFocus();
            edtRGcli.selectAll();
        }else{    
            cod_cli = objDao.inserir(objCliente);    
        }
        System.out.println("codCLi: "+cod_cli);
                        
        //FAMILIA
        boolean isFamilyAdd = (false);
        if(cod_cli != -1){
            if(tableFamiliaCli.getRowCount() > 0){
                FamiliaCliCtrl familiaCli = new FamiliaCliCtrl();
                FamiliaCliDAO objFamilyDao = new FamiliaCliDAO();

                for(int x=0; x < tableFamiliaCli.getRowCount(); x++){
                    familiaCli.setNome(tableFamiliaCli.getValueAt(x,0).toString());
                    familiaCli.setRg(Integer.parseInt(tableFamiliaCli.getValueAt(x,1).toString()));
                    familiaCli.setCpf(Integer.parseInt(tableFamiliaCli.getValueAt(x,2).toString()));
                    familiaCli.setRelacao(tableFamiliaCli.getValueAt(x,3).toString());
                    familiaCli.setCod_cli(cod_cli);
                    
                    isFamilyAdd = objFamilyDao.inserir(familiaCli);
                }

            }
            
                    jlMenssager.setText("Cliente cadastrado com Sucesso!!!"); 
        }
            if(isFamilyAdd) setVisible(false);
    }//GEN-LAST:event_jbCadastrarActionPerformed

    private void edtNomeCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtNomeCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtNomeCliActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void edtNomeCliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtNomeCliKeyPressed
       if(evt.getKeyCode()==KeyEvent.VK_ENTER){
           
              jlMenssager.setText("---<Cadastrando Cliente>---"); 
              edtNomeCli.setNextFocusableComponent(edtApelidoCli);
              edtNomeCli.nextFocus();
           
       }
    }//GEN-LAST:event_edtNomeCliKeyPressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    private void jButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MousePressed

    private void edtNomeCliFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_edtNomeCliFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_edtNomeCliFocusGained

    private void edtApelidoCliFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_edtApelidoCliFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_edtApelidoCliFocusGained

    private void edtApelidoCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtApelidoCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtApelidoCliActionPerformed

    private void edtApelidoCliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtApelidoCliKeyPressed
       if(evt.getKeyCode()==KeyEvent.VK_ENTER){ 
            edtApelidoCli.setNextFocusableComponent(edtDNcli);
            edtApelidoCli.nextFocus();
        }
    }//GEN-LAST:event_edtApelidoCliKeyPressed

    private void edtCellCLiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtCellCLiKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            edtCellCLi.setNextFocusableComponent(edtTelResiCli);
            edtCellCLi.nextFocus();

        }
    }//GEN-LAST:event_edtCellCLiKeyPressed

    private void edtTelResiCliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtTelResiCliKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            edtTelResiCli.setNextFocusableComponent(edtTelComerCli);
            edtTelResiCli.nextFocus();

        }
    }//GEN-LAST:event_edtTelResiCliKeyPressed

    private void edtTelComerCliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtTelComerCliKeyPressed
       if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            edtTelResiCli.setNextFocusableComponent(edtEmailCli);
            edtTelResiCli.nextFocus();

        }
    }//GEN-LAST:event_edtTelComerCliKeyPressed

    private void edtDNcliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtDNcliKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            edtDNcli.setNextFocusableComponent(cbECcli);
            edtDNcli.nextFocus();
        }
    }//GEN-LAST:event_edtDNcliKeyPressed

    private void edtEmailCliFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_edtEmailCliFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_edtEmailCliFocusGained

    private void edtEmailCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtEmailCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtEmailCliActionPerformed

    private void edtEmailCliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtEmailCliKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            edtEmailCli.setNextFocusableComponent(edtEmailCli);
            edtEmailCli.nextFocus();

        }
    }//GEN-LAST:event_edtEmailCliKeyPressed

    private void edtRGcliFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_edtRGcliFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_edtRGcliFocusGained

    private void edtRGcliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtRGcliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtRGcliActionPerformed

    private void edtRGcliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtRGcliKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            ClienteDao objDao = new ClienteDao();
            if(objDao.verificarRgCpf(edtRGcli.getText(),"")){
                jlMenssager.setText("IDENTIDADE já cadastrado"); 
                cbECcli.nextFocus();
                edtRGcli.selectAll();
            }else{
                edtRGcli.setNextFocusableComponent(edtCnpjCpfCli);
                edtRGcli.nextFocus();
            }
        }
    }//GEN-LAST:event_edtRGcliKeyPressed

    private void edtCnpjCpfCliFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_edtCnpjCpfCliFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_edtCnpjCpfCliFocusGained

    private void edtCnpjCpfCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtCnpjCpfCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtCnpjCpfCliActionPerformed

    private void edtCnpjCpfCliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtCnpjCpfCliKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
           ClienteDao objDao = new ClienteDao();
            if(objDao.verificarRgCpf("",edtCnpjCpfCli.getText())){
                jlMenssager.setText("CPF já cadastrado"); 
                edtRGcli.nextFocus();
                edtCnpjCpfCli.selectAll();
            }else{
                edtCnpjCpfCli.setNextFocusableComponent(edtCreditoCli);
                edtCnpjCpfCli.nextFocus();
            }
        }
    }//GEN-LAST:event_edtCnpjCpfCliKeyPressed

    private void edtCepCliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtCepCliKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            edtCepCli.setNextFocusableComponent(edtRuaCli);
            edtCepCli.nextFocus();
        }
    }//GEN-LAST:event_edtCepCliKeyPressed

    private void edtRuaCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtRuaCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtRuaCliActionPerformed

    private void edtNumCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtNumCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtNumCliActionPerformed

    private void edtCompCLiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtCompCLiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtCompCLiActionPerformed

    private void edtBairroCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtBairroCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtBairroCliActionPerformed

    private void edtCidadeCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtCidadeCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtCidadeCliActionPerformed

    private void edtEstadoCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtEstadoCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtEstadoCliActionPerformed

    private void edtReferCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtReferCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtReferCliActionPerformed

    private void edtCreditoCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtCreditoCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtCreditoCliActionPerformed

    private void edtCpfFamiliaCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtCpfFamiliaCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtCpfFamiliaCliActionPerformed

    private void edtNomeFamiliaCliFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_edtNomeFamiliaCliFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_edtNomeFamiliaCliFocusGained

    private void edtNomeFamiliaCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtNomeFamiliaCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtNomeFamiliaCliActionPerformed

    private void edtNomeFamiliaCliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtNomeFamiliaCliKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            edtNomeFamiliaCli.setNextFocusableComponent(edtRgFamiliaCli);
            edtNomeFamiliaCli.nextFocus();
        }
    }//GEN-LAST:event_edtNomeFamiliaCliKeyPressed

    private void edtRgFamiliaCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtRgFamiliaCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtRgFamiliaCliActionPerformed

    private void edtCellCLiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtCellCLiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtCellCLiActionPerformed

    private void edtDNcliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtDNcliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtDNcliActionPerformed

    private void cbECcliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbECcliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbECcliActionPerformed

    private void cbECcliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbECcliKeyPressed
       if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            cbECcli.setNextFocusableComponent(edtRGcli);
            cbECcli.nextFocus();
        }
    }//GEN-LAST:event_cbECcliKeyPressed

    private void edtCreditoCliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtCreditoCliKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
           edtCreditoCli.setText(edtCreditoCli.getText().replace(",", "."));
           edtCreditoCli.setText(String.format("%.2f",Double.valueOf(edtCreditoCli.getText())));
           
            edtCreditoCli.setNextFocusableComponent(edtCellCLi);
            edtCreditoCli.nextFocus();
        }
    }//GEN-LAST:event_edtCreditoCliKeyPressed

    private void edtRuaCliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtRuaCliKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            edtRuaCli.setNextFocusableComponent(edtNumCli);
            edtRuaCli.nextFocus();
        }
    }//GEN-LAST:event_edtRuaCliKeyPressed

    private void edtNumCliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtNumCliKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            edtNumCli.setNextFocusableComponent(edtCompCLi);
            edtNumCli.nextFocus();
        }
    }//GEN-LAST:event_edtNumCliKeyPressed

    private void edtCompCLiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtCompCLiKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            edtCompCLi.setNextFocusableComponent(edtBairroCli);
            edtCompCLi.nextFocus();
        }
    }//GEN-LAST:event_edtCompCLiKeyPressed

    private void edtBairroCliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtBairroCliKeyPressed
         if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            edtBairroCli.setNextFocusableComponent(edtCidadeCli);
            edtBairroCli.nextFocus();
        }
    }//GEN-LAST:event_edtBairroCliKeyPressed

    private void edtCidadeCliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtCidadeCliKeyPressed
         if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            edtCidadeCli.setNextFocusableComponent(edtEstadoCli);
            edtCidadeCli.nextFocus();
        }
    }//GEN-LAST:event_edtCidadeCliKeyPressed

    private void edtEstadoCliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtEstadoCliKeyPressed
         if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            edtEstadoCli.setNextFocusableComponent(edtReferCli);
            edtEstadoCli.nextFocus();
        }
    }//GEN-LAST:event_edtEstadoCliKeyPressed

    private void edtReferCliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtReferCliKeyPressed
         if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            edtReferCli.setNextFocusableComponent(edtNomeFamiliaCli);
            edtReferCli.nextFocus();
        }
    }//GEN-LAST:event_edtReferCliKeyPressed

    private void edtRgFamiliaCliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtRgFamiliaCliKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            edtRgFamiliaCli.setNextFocusableComponent(edtCpfFamiliaCli);
            edtRgFamiliaCli.nextFocus();
        }
    }//GEN-LAST:event_edtRgFamiliaCliKeyPressed

    private void edtCpfFamiliaCliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtCpfFamiliaCliKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            edtCpfFamiliaCli.setNextFocusableComponent(cbRalacaoCli);
            edtCpfFamiliaCli.nextFocus();
        }
    }//GEN-LAST:event_edtCpfFamiliaCliKeyPressed

    private void btnExcluirFamiliaCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirFamiliaCliActionPerformed
     if(tableFamiliaCli.getSelectedRow() != -1){
           DefaultTableModel objTM = (DefaultTableModel) tableFamiliaCli.getModel();
           objTM.removeRow(tableFamiliaCli.getSelectedRow());
           btnExcluirFamiliaCli.setNextFocusableComponent(edtNomeFamiliaCli);
           btnExcluirFamiliaCli.nextFocus();
       }else JOptionPane.showMessageDialog(null, "Selecione um LINHA para EXCLUIR!!!");
        
    }//GEN-LAST:event_btnExcluirFamiliaCliActionPerformed

    private void jbEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditActionPerformed
        if(jbEdit.getText().equals("EDITAR")){
            //editar
                edtNomeCli.setEditable(true);
                edtApelidoCli.setEditable(true);
                edtDNcli.setEditable(true);
                cbECcli.setEditable(true);
            //CONTATOS 
                edtCellCLi.setEditable(true);
                edtTelResiCli.setEditable(true);
                edtTelComerCli.setEditable(true);
                edtEmailCli.setEditable(true);
            //ENDEREÇO
                edtCepCli.setEditable(true);
                edtRuaCli.setEditable(true);
                edtNumCli.setEditable(true);
                edtCompCLi.setEditable(true);
                edtBairroCli.setEditable(true);
                edtCidadeCli.setEditable(true);
                edtEstadoCli.setEditable(true);
                edtReferCli.setEditable(true);
            //DOCUMENTOS
                edtRGcli.setEditable(true);
                edtCnpjCpfCli.setEditable(true);
                radioCpf.setEnabled(true);
                radioCnpj.setEnabled(true);

            //CREDITO
                edtCreditoCli.setEditable(true);
            //FAMÍLIA
                btnAddFamiliaCli.setEnabled(true);       
                btnExcluirFamiliaCli.setEnabled(true);
                cbRalacaoCli.setEnabled(true);
                edtNomeFamiliaCli.setEditable(true);
                edtRgFamiliaCli.setEditable(true);
                edtCpfFamiliaCli.setEditable(true);

            //ANOTAÇÕES
                txtObsCli.setEditable(true);
        
            edtNomeCli.selectAll();
            edtNomeCli.setFocusable(true);            
            jbCadastrar.setEnabled(false);
            jbEdit.setEnabled(true);
            jbEdit.setText("SALVAR");
        }else if(jbEdit.getText().equals("SALVAR")){
            //salvar
            ClienteCtrl objCliente = new ClienteCtrl();
        ClienteDao objDao = new ClienteDao();
        
        String limCompra = edtCreditoCli.getText();
        limCompra = limCompra.replace(",", ".");
        
        //DADOS PESSOAIS
        objCliente.setId(SisPrinc.codCli);
        objCliente.setNome(edtNomeCli.getText());
        objCliente.setApelido(edtApelidoCli.getText());
        objCliente.setData_nasc(edtDNcli.getText());
        objCliente.setEstado_civil(cbECcli.getItemAt(cbECcli.getSelectedIndex()));
        
        //CONTATOS
        objCliente.setCelular(edtCellCLi.getText());
        objCliente.setTel_resi(edtTelResiCli.getText());
        objCliente.setTel_comer(edtTelComerCli.getText());
        objCliente.setEmail(edtEmailCli.getText());
        
        //ENDEREÇOS
        String[] cep = edtCepCli.getText().split("-");
        if(edtCepCli.getText().equals("") || edtCepCli.getText().equals("-"))objCliente.setCep(0);
        else objCliente.setCep(Integer.parseInt(cep[0]+cep[1]));
        objCliente.setRua(edtRuaCli.getText());
        if(edtNumCli.getText().equals("")) objCliente.setNumero(0);
        else objCliente.setNumero(Integer.parseInt(edtNumCli.getText()));
        objCliente.setComplem(edtCompCLi.getText());
        objCliente.setBairro(edtBairroCli.getText());
        objCliente.setCidade(edtCidadeCli.getText());
        objCliente.setEstado(edtEstadoCli.getText());
        objCliente.setReferencia(edtReferCli.getText());
        
        //DOCUMENTOS
        if(edtRGcli.getText().equals("")) objCliente.setRg(0);
        else objCliente.setRg(Integer.parseInt(edtRGcli.getText()));
        if(edtCnpjCpfCli.getText().equals("")) objCliente.setCpf_cnpj(0);
        else objCliente.setCpf_cnpj(Integer.parseInt(edtCnpjCpfCli.getText()));
        if(radioCpf.isSelected()){
            objCliente.setCpf_or_cnpj("CPF");
        }else{
            objCliente.setCpf_or_cnpj("CNPJ");
        }
        //CREDITO
        objCliente.setValor_credito(Double.valueOf(limCompra));
        
        //FOTO
        objCliente.setFoto(null);
        
        //ANOTAÇÕES
        objCliente.setObs(txtObsCli.getText());
        
        if(edtNomeCli.getText().equals("") || edtCnpjCpfCli.getText().equals("") || 
            edtRGcli.getText().equals("") )
        {   jlMenssager.setText("Preencha todos os Dados Pessoais"); 
        }else{    
            objDao.alterar(objCliente);    
        }
        System.out.println("codCLi: "+ SisPrinc.codCli);
                        
        //FAMILIA
        boolean isFamilyAdd = false;
            if(tableFamiliaCli.getRowCount() > 0){
                FamiliaCliCtrl familiaCli = new FamiliaCliCtrl();
                FamiliaCliDAO objFamilyDao = new FamiliaCliDAO();
                
                objFamilyDao.deletar(SisPrinc.codCli);

                for(int x=0; x < tableFamiliaCli.getRowCount(); x++){
                    familiaCli.setNome(tableFamiliaCli.getValueAt(x,0).toString());
                    familiaCli.setRg(Integer.parseInt(tableFamiliaCli.getValueAt(x,1).toString()));
                    familiaCli.setCpf(Integer.parseInt(tableFamiliaCli.getValueAt(x,2).toString()));
                    familiaCli.setRelacao(tableFamiliaCli.getValueAt(x,3).toString());
                    familiaCli.setCod_cli(SisPrinc.codCli);
                    
                    isFamilyAdd = objFamilyDao.inserir(familiaCli);
                }

            }
          jlMenssager.setText("Cliente cadastrado com Sucesso!!!"); 
            jbEdit.setText("EDITAR");
            if(isFamilyAdd) setVisible(false);
       }
    }//GEN-LAST:event_jbEditActionPerformed

    private void btnAddFamiliaCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFamiliaCliActionPerformed
        btnAddFamiliaCli.setNextFocusableComponent(tableFamiliaCli);
        btnAddFamiliaCli.nextFocus();
        DefaultTableModel objTM = (DefaultTableModel) tableFamiliaCli.getModel();
        String linha[] = {
                     edtNomeFamiliaCli.getText(),
                     ""+edtRgFamiliaCli.getText(),
                     ""+edtCpfFamiliaCli.getText(),
                     ""+cbRalacaoCli.getItemAt(cbRalacaoCli.getSelectedIndex())
                };             
         objTM.addRow(linha);
         
        edtNomeFamiliaCli.setText("");
        edtRgFamiliaCli.setText("");
        edtCpfFamiliaCli.setText("");
    }//GEN-LAST:event_btnAddFamiliaCliActionPerformed

    private void radioCnpjMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioCnpjMouseClicked

    }//GEN-LAST:event_radioCnpjMouseClicked

    private void radioCpfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioCpfMouseClicked

    }//GEN-LAST:event_radioCpfMouseClicked

    private void radioCnpjStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_radioCnpjStateChanged
  
    }//GEN-LAST:event_radioCnpjStateChanged

    private void radioCpfStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_radioCpfStateChanged
 
    }//GEN-LAST:event_radioCpfStateChanged

    private void radioCnpjItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radioCnpjItemStateChanged
        radioCpf.setSelected(false);
    }//GEN-LAST:event_radioCnpjItemStateChanged

    private void radioCpfItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radioCpfItemStateChanged
         radioCnpj.setSelected(false);
    }//GEN-LAST:event_radioCpfItemStateChanged

    private void cbRalacaoCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRalacaoCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbRalacaoCliActionPerformed

    private void txtObsCliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtObsCliKeyPressed
       if(evt.getKeyCode()==KeyEvent.VK_ENTER){
           try {
               SisPrinc.class.newInstance().clickBtnCli();
           } catch (InstantiationException ex) {
               Logger.getLogger(GerirCliente.class.getName()).log(Level.SEVERE, null, ex);
           } catch (IllegalAccessException ex) {
               Logger.getLogger(GerirCliente.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
    }//GEN-LAST:event_txtObsCliKeyPressed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddFamiliaCli;
    private javax.swing.JButton btnExcluirFamiliaCli;
    private javax.swing.JComboBox<String> cbECcli;
    private javax.swing.JComboBox<String> cbRalacaoCli;
    private javax.swing.JTextField edtApelidoCli;
    private javax.swing.JTextField edtBairroCli;
    private javax.swing.JFormattedTextField edtCellCLi;
    private javax.swing.JFormattedTextField edtCepCli;
    private javax.swing.JTextField edtCidadeCli;
    private javax.swing.JTextField edtCnpjCpfCli;
    private javax.swing.JTextField edtCompCLi;
    private javax.swing.JTextField edtCpfFamiliaCli;
    private javax.swing.JTextField edtCreditoCli;
    private javax.swing.JFormattedTextField edtDNcli;
    private javax.swing.JTextField edtEmailCli;
    private javax.swing.JTextField edtEstadoCli;
    private javax.swing.JTextField edtNomeCli;
    private javax.swing.JTextField edtNomeFamiliaCli;
    private javax.swing.JTextField edtNumCli;
    private javax.swing.JTextField edtRGcli;
    private javax.swing.JTextField edtReferCli;
    private javax.swing.JTextField edtRgFamiliaCli;
    private javax.swing.JTextField edtRuaCli;
    private javax.swing.JFormattedTextField edtTelComerCli;
    private javax.swing.JFormattedTextField edtTelResiCli;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbCadastrar;
    private javax.swing.JButton jbEdit;
    private javax.swing.JLabel jlMenssager;
    private javax.swing.JLabel labelFoto;
    private javax.swing.JRadioButton radioCnpj;
    private javax.swing.JRadioButton radioCpf;
    private javax.swing.JTable tableFamiliaCli;
    private javax.swing.JTextArea txtObsCli;
    // End of variables declaration//GEN-END:variables
}

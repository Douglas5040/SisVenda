/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import ctrl.ClienteCtrl;
import ctrl.ControleProCtrl;
import ctrl.DocumentJTextFIXACtrl;
import ctrl.FornecedorCtrl;
import ctrl.OrdemServiceCtrl;
import ctrl.SaidaProCtrl;
import ctrl.UsuarioCtrl;
import dao.ControleProDAO;
import dao.OrdemServiceDao;
import dao.ProdutoDao;
import dao.SaidaProDao;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Douglas
 */
public class OperationsEstoque extends javax.swing.JFrame {

    public int codPro, qtd, codOpera, codOs, codUser;
    public ClienteCtrl cliCtrl;
    public FornecedorCtrl forneceCtrl;
    
    
    /**
     * Creates new form AddProsutos
     */
    public OperationsEstoque() {
        initComponents();
        ProdutoDao proDao = new ProdutoDao();
        
        jtCodPro.setText(""+codPro);
        try {
           if(codPro != 0 || codPro != -1) jtNomePro.setText(proDao.selecionarPro(""+codPro).getString("NOME"));
        } catch (SQLException ex) {
            Logger.getLogger(OperationsEstoque.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erro consulta Produto, "+ex);
        }
        jtQtd.setText(""+qtd);
        if(codOpera!=0 || codOpera != -1) jcbOperation.setSelectedIndex(codOpera);
        jtOS.setText(""+codOs);
        jtUser.setText(SisPrinc.userlogin.getCargo());
        if(cliCtrl != null) jtCli.setText(cliCtrl.getNome());
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtCodPro = new javax.swing.JTextField();
        jtQtd = new javax.swing.JTextField();
        jtNomePro = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtOS = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtUser = new javax.swing.JTextField();
        jcbOperation = new javax.swing.JComboBox<>();
        jPanel62 = new javax.swing.JPanel();
        jtCli = new javax.swing.JTextField();
        jcbCli = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jbOK = new javax.swing.JButton();
        jbCancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaObs = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ENTRADA EM ESTOQUE");
        setAlwaysOnTop(true);
        setLocation(new java.awt.Point(450, 250));
        setUndecorated(true);
        setOpacity(0.9F);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "OPERAÇÕES DE ESTOQUE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 1, 18))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Codigo:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Nome:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Quantidade:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Operação:");

        jtCodPro.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtCodPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtCodProActionPerformed(evt);
            }
        });

        jtQtd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jtNomePro.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtNomePro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtNomeProActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("OS.:");

        jtOS.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Usuario:");

        jtUser.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtUserActionPerformed(evt);
            }
        });

        jcbOperation.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jcbOperation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Operações Estoque", "ENTRADA_NOVO", "ENTRADA_COMPRA", "ENTRADA_DEVOLUÇÃO", "SAIDA_INVALIDO", "SAIDA_EXCLUSÃO", "ALTERAR_DADOS" }));
        jcbOperation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbOperationActionPerformed(evt);
            }
        });

        jPanel62.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jPanel62.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtCli.setDocument(new DocumentJTextFIXACtrl());
        jtCli.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jtCli.setBorder(null);
        jtCli.setPreferredSize(new java.awt.Dimension(100, 23));
        jtCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtCliActionPerformed(evt);
            }
        });
        jtCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtCliKeyPressed(evt);
            }
        });
        jPanel62.add(jtCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 1, 320, 22));

        jcbCli.setEditable(true);
        jcbCli.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jcbCli.setPreferredSize(new java.awt.Dimension(6, 21));
        jcbCli.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jcbCliComponentResized(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jcbCliComponentShown(evt);
            }
        });
        jcbCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbCliActionPerformed(evt);
            }
        });
        jcbCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jcbCliKeyReleased(evt);
            }
        });
        jPanel62.add(jcbCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 342, 24));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Cliente: ");
        jPanel62.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 20));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtOS))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtCodPro)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbOperation, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtNomePro, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel62, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jtCodPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtNomePro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jcbOperation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel62, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 450, 130));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Observação sobre a operação:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 210, 30));

        jbOK.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jbOK.setText("CONCLUIR");
        jbOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbOKActionPerformed(evt);
            }
        });
        jPanel2.add(jbOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 150, 50));

        jbCancel.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jbCancel.setText("CANCELAR");
        jbCancel.setPreferredSize(new java.awt.Dimension(143, 35));
        jbCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelActionPerformed(evt);
            }
        });
        jPanel2.add(jbCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, 150, 50));

        jtaObs.setEditable(false);
        jtaObs.setColumns(20);
        jtaObs.setDocument(new DocumentJTextFIXACtrl());
        jtaObs.setLineWrap(true);
        jtaObs.setRows(5);
        jtaObs.setTabSize(2);
        jtaObs.setWrapStyleWord(true);
        jtaObs.setMaximumSize(new java.awt.Dimension(10, 10));
        jScrollPane1.setViewportView(jtaObs);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 410, 100));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtUserActionPerformed

    private void jcbOperationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbOperationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbOperationActionPerformed

    private void jtCodProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtCodProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtCodProActionPerformed

    private void jbCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelActionPerformed
        GerirPro.okOperation = false;
    }//GEN-LAST:event_jbCancelActionPerformed

    private void jbOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbOKActionPerformed
        switch(jcbOperation.getSelectedIndex()){
            case 1: operationCadNovo(); break;
            case 2: operationAddPro(); break;
            case 3: operationDevolu(); break;
            case 4: operationSaidaInvalid(); break;
            case 5: operationAltDados(); break;
            default : JOptionPane.showMessageDialog(null, "Ecolha uma Operação de Estoque!!!");
        }
    }//GEN-LAST:event_jbOKActionPerformed

    private void jcbCliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcbCliKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbCliKeyReleased

    private void jcbCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbCliActionPerformed

    private void jcbCliComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jcbCliComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbCliComponentShown

    private void jcbCliComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jcbCliComponentResized
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbCliComponentResized

    private void jtCliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtCliKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtCliKeyPressed

    private void jtCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtCliActionPerformed

    private void jtNomeProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtNomeProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtNomeProActionPerformed

    public void operationCadNovo(){
        ControleProDAO ctrlProDao = new ControleProDAO();
        ControleProCtrl ctrlProCtrl = new ControleProCtrl();
        
        ctrlProCtrl.setCodPro(Integer.parseInt(jtCodPro.getText()));
        ctrlProCtrl.setCodOpera(6);
        ctrlProCtrl.setCodUser(SisPrinc.userlogin.getId());
        ctrlProCtrl.setCodCli(-1);
        ctrlProCtrl.setCodFornece(forneceCtrl.getID());
        ctrlProCtrl.setQtd(Integer.parseInt(jtCodPro.getText()));
        ctrlProCtrl.setDate(SisPrinc.hora);
        Date dataSistema = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        ctrlProCtrl.setHora(formato.format(dataSistema));
        ctrlProCtrl.setObs(jtaObs.getText());
        
        ctrlProDao.inserir(ctrlProCtrl);
        
        GerirPro.okOperation = true;
        setVisible(false);

    }

    public void operationAddPro(){
        ControleProDAO ctrlProDao = new ControleProDAO();
        ProdutoDao proDao = new ProdutoDao();
        ControleProCtrl ctrlProCtrl = new ControleProCtrl();
        
        ctrlProCtrl.setCodPro(Integer.parseInt(jtCodPro.getText()));
        ctrlProCtrl.setCodOpera(Integer.parseInt(jtCodPro.getText()));
        ctrlProCtrl.setCodUser(SisPrinc.userlogin.getId());
        ctrlProCtrl.setCodCli(-1);
        ctrlProCtrl.setCodFornece(forneceCtrl.getID());
        ctrlProCtrl.setQtd(Integer.parseInt(jtCodPro.getText()));
        ctrlProCtrl.setDate(SisPrinc.hora);
        Date dataSistema = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        ctrlProCtrl.setHora(formato.format(dataSistema));
        ctrlProCtrl.setObs(jtaObs.getText());
        
        
        if(proDao.alterarQtdPro(proDao.qtdPro(""+ctrlProCtrl.getCodPro())
                                                +ctrlProCtrl.getQtd(),
                                                ""+ctrlProCtrl.getCodPro()))
                                                ctrlProDao.inserir(ctrlProCtrl);
        
        ctrlProDao.inserir(ctrlProCtrl);
        setVisible(false);
    }    
 
    public void operationDevolu(){
        ControleProDAO ctrlProDao = new ControleProDAO();
        ProdutoDao proDao = new ProdutoDao();
        ControleProCtrl ctrlProCtrl = new ControleProCtrl();
        OrdemServiceCtrl osCtrl = new OrdemServiceCtrl();
        OrdemServiceDao osDao = new OrdemServiceDao();
        SaidaProCtrl spCtrl = new SaidaProCtrl();
        SaidaProDao spDao = new SaidaProDao();

        ctrlProCtrl.setCodPro(Integer.parseInt(jtCodPro.getText()));
        ctrlProCtrl.setCodOpera(2);
        ctrlProCtrl.setCodCli(cliCtrl.getId());
        ctrlProCtrl.setCodFornece(-1);
        ctrlProCtrl.setQtd(Integer.parseInt(jtCodPro.getText()));
        ctrlProCtrl.setDate(SisPrinc.hora);
        Date dataSistema = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        ctrlProCtrl.setHora(formato.format(dataSistema));
        ctrlProCtrl.setObs(jtaObs.getText());


        if(proDao.alterarQtdPro(proDao.qtdPro(""+ctrlProCtrl.getCodPro())
                                                +ctrlProCtrl.getQtd(),
                                                ""+ctrlProCtrl.getCodPro()))
                                                ctrlProDao.inserir(ctrlProCtrl);
        
        ResultSet rsOs = osDao.selecionarOS(jtOS.getText());
        
        try {
            rsOs.first();
            osCtrl.setId(rsOs.getInt("ID"));
            osCtrl.setCod_cli(rsOs.getInt("COD_CLI"));
            osCtrl.setValor(rsOs.getInt("VALOR"));
            osCtrl.setData_hora_opem(rsOs.getString("DATA_HORA_OPEM"));
            osCtrl.setData_hora_close(rsOs.getString("DATA_HORA_CLOSE"));
            osCtrl.setCod_vendedor(rsOs.getInt("COD_VENDEDOR"));
            osCtrl.setDescont(rsOs.getInt("DESCONT"));
            osCtrl.setCod_status_os(rsOs.getInt("COD_STATUS_OS"));
            osCtrl.setObs(rsOs.getString("OBS"));
            
            
            ResultSet rsSp = spDao.selecionarSPporOs(jtOS.getText(), jtCodPro.getText());

            spCtrl.setCOD_PRO(codPro);
            spCtrl.setVALOR_PRO(codPro);
            spCtrl.setQTD(codPro);
            spCtrl.setVALOR_TOTAL(codPro);
            spCtrl.setDESCONT(codPro);
            spCtrl.setCOD_OS(codPro);
            spCtrl.setCOD_STATUS_SP(codPro);
            
            
            double valorTotPro = 0;
            
            if(Integer.parseInt(jtQtd.getText()) < spCtrl.getQTD())
            {
                valorTotPro = spCtrl.getVALOR_PRO()*Integer.parseInt(jtQtd.getText());
                spCtrl.setQTD(spCtrl.getQTD()-Integer.parseInt(jtQtd.getText()));
                spCtrl.setVALOR_TOTAL(valorTotPro);
                osCtrl.setValor(osCtrl.getValor()-spCtrl.getVALOR_TOTAL());
                osDao.altStatusOS(osCtrl.getId(), 5);
                
                
            }else if(Integer.parseInt(jtQtd.getText()) > spCtrl.getQTD()){
                JOptionPane.showMessageDialog(null, "Clinte não comprou toda essa QUANTIDADE de produto!!!");
                jtNomePro.setNextFocusableComponent(jtQtd);
                jtNomePro.nextFocus();
                jtQtd.selectAll();
            }else{
                osCtrl.setValor(osCtrl.getValor()-spCtrl.getVALOR_TOTAL());
                spDao.altStatusSP(2, Integer.parseInt(jtCodPro.getText()));
                osDao.altStatusOS(osCtrl.getId(), 5);
            }
            if(osCtrl.getValor() < 1) 
                osDao.altStatusOS(osCtrl.getId(), 3);
        
        } catch (SQLException ex) {
            Logger.getLogger(OperationsEstoque.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro na OPERAÇÃO DE ESTOQUE, "+ex);
        }
        
        ctrlProDao.inserir(ctrlProCtrl);
        setVisible(false);
    }
    
    public void operationSaidaInvalid(){
        ControleProDAO ctrlProDao = new ControleProDAO();
        ProdutoDao proDao = new ProdutoDao();
        ControleProCtrl ctrlProCtrl = new ControleProCtrl();

        proDao.deletar(Integer.parseInt(jtCodPro.getText()), jtNomePro.getText());
        ctrlProCtrl.setCodPro(Integer.parseInt(jtCodPro.getText()));
        if(jcbOperation.getSelectedIndex() == 4)ctrlProCtrl.setCodOpera(4);
        if(jcbOperation.getSelectedIndex() == 5)ctrlProCtrl.setCodOpera(7);
        ctrlProCtrl.setCodCli(cliCtrl.getId());
        ctrlProCtrl.setCodFornece(-1);
        ctrlProCtrl.setQtd(Integer.parseInt(jtCodPro.getText()));
        ctrlProCtrl.setDate(SisPrinc.hora);
        Date dataSistema = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        ctrlProCtrl.setHora(formato.format(dataSistema));
        ctrlProCtrl.setObs(jtaObs.getText());
        
        ctrlProDao.inserir(ctrlProCtrl);
        setVisible(false);
    }
    //verificar função no gerir pro
    public void operationAltDados(){
        ControleProDAO ctrlProDao = new ControleProDAO();
        ProdutoDao proDao = new ProdutoDao();
        ControleProCtrl ctrlProCtrl = new ControleProCtrl();

        ctrlProCtrl.setCodPro(Integer.parseInt(jtCodPro.getText()));
        ctrlProCtrl.setCodOpera(5);
        ctrlProCtrl.setCodCli(cliCtrl.getId());
        ctrlProCtrl.setCodFornece(forneceCtrl.getID());
        ctrlProCtrl.setQtd(Integer.parseInt(jtCodPro.getText()));
        ctrlProCtrl.setDate(SisPrinc.hora);
        Date dataSistema = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        ctrlProCtrl.setHora(formato.format(dataSistema));
        ctrlProCtrl.setObs(jtaObs.getText());
        
        
        ctrlProDao.inserir(ctrlProCtrl);
        GerirPro.okOperation = true;
        setVisible(false);
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
            java.util.logging.Logger.getLogger(OperationsEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OperationsEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OperationsEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OperationsEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OperationsEstoque().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbCancel;
    private javax.swing.JButton jbOK;
    private javax.swing.JComboBox<String> jcbCli;
    private javax.swing.JComboBox<String> jcbOperation;
    private javax.swing.JTextField jtCli;
    private javax.swing.JTextField jtCodPro;
    private javax.swing.JTextField jtNomePro;
    private javax.swing.JTextField jtOS;
    private javax.swing.JTextField jtQtd;
    private javax.swing.JTextField jtUser;
    private javax.swing.JTextArea jtaObs;
    // End of variables declaration//GEN-END:variables
}

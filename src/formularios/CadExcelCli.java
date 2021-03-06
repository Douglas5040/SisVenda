/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import ctrl.ClienteCtrl;
import ctrl.FamiliaCliCtrl;
import ctrl.FormatacaoConteudoCtrl;
import dao.ClienteDao;
import dao.FamiliaCliDAO;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.formula.FormulaParseException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Douglas
 */
public class CadExcelCli extends javax.swing.JFrame {

    /**
     * Creates new form CadExcelCli
     */
    public CadExcelCli() {
        initComponents();
        jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jtableExcelCli.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        //jScrollPane1.setHorizontalScrollBar(new JScrollBar());
        try{
            
            XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(SisPrinc.fileExportCli));
            
            
            DefaultTableModel objTM = (DefaultTableModel) jtableExcelCli.getModel();
            objTM.setRowCount(0);
            Sheet sheet = workbook.getSheetAt(0);
            System.out.println("linhas: "+sheet.getPhysicalNumberOfRows());

            String sCPF_CNPJ = "";
            String sNOME_RAZAO = "";
            String sENDER_RUA = "";
            String sNUMERO = "";
            String sBAIRRO = "";
            String sCOMPLEM = "";
            String sCEP = "";
            String sCIDADE = "";
            String sESTADO = "";
            String sTELE = "";
            String sCELU = "";
            String sTELE_COMER = "";
            String sEMAIL = "";
            String sRG = "";
            String sOBS = "";
            String sESTADO_CIVIL = "";
            String sDATA_NASC = "";
            String sREFERENCIA = "";
            
            Iterator<Row> linhas = sheet.rowIterator();
            linhas.next();
            while (linhas.hasNext()) {
                XSSFRow linha = (XSSFRow) linhas.next();
                Iterator<Cell> celulas = linha.cellIterator();
                
                    while (celulas.hasNext()) {
                        XSSFCell celula = (XSSFCell) celulas.next();
                        int z = celula.getColumnIndex();
                        if (celula.getCellType()==XSSFCell.CELL_TYPE_BLANK) {
                            //Mensagem de célula vazia
                            System.out.println("indice vazia: "+celula.toString()+" - "+celula.getColumnIndex()+", "+linha.getRowNum());
                        }
                        switch (z) {
                            case 4:
                                sCPF_CNPJ = celula.toString();
                            break;
                            case 5:
                                sNOME_RAZAO = celula.toString();
                            break;
                            case 7:
                                sENDER_RUA = celula.toString();
                            break;
                            case 8:
                                sNUMERO = celula.toString();
                            break;
                            case 9:
                                sBAIRRO = celula.toString();
                            break;
                            case 10:
                                sCOMPLEM = celula.toString();
                            break;
                            case 11:
                                sCEP = celula.toString();
                            break;
                            case 12:
                                sCIDADE = celula.toString();
                            break;
                            case 14:
                                sESTADO = celula.toString();
                            break;
                            case 17:
                                sTELE = celula.toString();
                            break;
                            case 19:
                                sCELU = celula.toString();
                            break;
                            case 21:
                                sTELE_COMER = celula.toString();
                            break;
                            case 23:
                                sEMAIL = celula.toString();
                            break;
                            case 24:
                                sRG = celula.toString();
                            break;
                            case 37:
                                sOBS = celula.toString();
                            break;
                            case 33:
                                sESTADO_CIVIL = celula.toString();
                            break;
                            case 34:
                                sDATA_NASC = celula.toString();
                            break;
                            case 35:
                                sREFERENCIA = celula.toString();
                            break;
                            default: 
                                System.out.println("Indice fora: "+z);
                            break;
                        }
                    }
                    if(sNUMERO.isEmpty()) sNUMERO="0";
                        String linhaTable[] = {
                             ""+sNOME_RAZAO,
                             "",
                             "",
                             "",
                             "",
                             ""+sDATA_NASC,
                             ""+sESTADO_CIVIL,
                             ""+sRG,
                             "CPF",
                             ""+sCPF_CNPJ,
                             ""+sCEP,
                             ""+sENDER_RUA,
                             ""+Math.round(Double.valueOf(sNUMERO)),
                             ""+sBAIRRO,
                             ""+sCOMPLEM,
                             ""+sCIDADE,
                             ""+sESTADO,
                             ""+sREFERENCIA,
                             ""+sCELU,
                             ""+sTELE,
                             ""+sTELE_COMER,
                             ""+sEMAIL,
                             ""+sOBS
                        };
                        objTM.addRow(linhaTable);
                        for(int l=1; l < objTM.getRowCount(); l++){
                            System.out.println("linha deletada: "+l);
                            if(objTM.getValueAt(l, 0).equals(objTM.getValueAt(l-1, 0)) && objTM.getValueAt(l, 9).equals(objTM.getValueAt(l-1, 9))){
                                objTM.removeRow(l);
                            }

                        }
                        
                        //System.out.println(linha.getRowNum()+""+Arrays.toString(linhaTable));

            }
            
        } catch (IOException ex) {
           Logger.getLogger(SisPrinc.class.getName()).log(Level.SEVERE, null, ex);
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
        jtableExcelCli = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jbCadClientes = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setExtendedState(MAXIMIZED_BOTH);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setToolTipText("");
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setAutoscrolls(true);

        jtableExcelCli.setAutoCreateRowSorter(true);
        jtableExcelCli.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtableExcelCli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"oçp", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"iopio", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "NOME", "APELIDO", "CREDITO R$", "BONUS", "FOTO", "NASCIMENTO", "ESTADO CIVIL", "RG", "TIPO", "CPF/CNPJ", "CEP", "RUA", "NUMERO", "BAIRRO", "COMPLEMENTO", "CIDADE", "ESTADO", "REFERENCIA", "CELULAR", "TELEFONE 1", "TELEFONE 2", "EMAIL", "OBSERVAÇÃO"
            }
        ));
        jtableExcelCli.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtableExcelCli.setDragEnabled(true);
        jtableExcelCli.setRowHeight(25);
        jtableExcelCli.setRowMargin(2);
        jtableExcelCli.getTableHeader().setResizingAllowed(false);
        jtableExcelCli.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtableExcelCli);
        if (jtableExcelCli.getColumnModel().getColumnCount() > 0) {
            jtableExcelCli.getColumnModel().getColumn(0).setMinWidth(195);
            jtableExcelCli.getColumnModel().getColumn(0).setPreferredWidth(195);
            jtableExcelCli.getColumnModel().getColumn(0).setMaxWidth(195);
            jtableExcelCli.getColumnModel().getColumn(1).setMinWidth(150);
            jtableExcelCli.getColumnModel().getColumn(1).setPreferredWidth(150);
            jtableExcelCli.getColumnModel().getColumn(1).setMaxWidth(150);
            jtableExcelCli.getColumnModel().getColumn(2).setMinWidth(90);
            jtableExcelCli.getColumnModel().getColumn(2).setPreferredWidth(90);
            jtableExcelCli.getColumnModel().getColumn(2).setMaxWidth(90);
            jtableExcelCli.getColumnModel().getColumn(3).setMinWidth(90);
            jtableExcelCli.getColumnModel().getColumn(3).setPreferredWidth(90);
            jtableExcelCli.getColumnModel().getColumn(3).setMaxWidth(90);
            jtableExcelCli.getColumnModel().getColumn(4).setMinWidth(60);
            jtableExcelCli.getColumnModel().getColumn(4).setPreferredWidth(60);
            jtableExcelCli.getColumnModel().getColumn(4).setMaxWidth(60);
            jtableExcelCli.getColumnModel().getColumn(5).setMinWidth(130);
            jtableExcelCli.getColumnModel().getColumn(5).setPreferredWidth(130);
            jtableExcelCli.getColumnModel().getColumn(5).setMaxWidth(130);
            jtableExcelCli.getColumnModel().getColumn(6).setMinWidth(130);
            jtableExcelCli.getColumnModel().getColumn(6).setPreferredWidth(130);
            jtableExcelCli.getColumnModel().getColumn(6).setMaxWidth(130);
            jtableExcelCli.getColumnModel().getColumn(7).setMinWidth(120);
            jtableExcelCli.getColumnModel().getColumn(7).setPreferredWidth(120);
            jtableExcelCli.getColumnModel().getColumn(7).setMaxWidth(102);
            jtableExcelCli.getColumnModel().getColumn(8).setMinWidth(90);
            jtableExcelCli.getColumnModel().getColumn(8).setPreferredWidth(90);
            jtableExcelCli.getColumnModel().getColumn(8).setMaxWidth(90);
            jtableExcelCli.getColumnModel().getColumn(9).setMinWidth(150);
            jtableExcelCli.getColumnModel().getColumn(9).setPreferredWidth(150);
            jtableExcelCli.getColumnModel().getColumn(9).setMaxWidth(150);
            jtableExcelCli.getColumnModel().getColumn(10).setMinWidth(140);
            jtableExcelCli.getColumnModel().getColumn(10).setPreferredWidth(140);
            jtableExcelCli.getColumnModel().getColumn(10).setMaxWidth(140);
            jtableExcelCli.getColumnModel().getColumn(11).setMinWidth(170);
            jtableExcelCli.getColumnModel().getColumn(11).setPreferredWidth(170);
            jtableExcelCli.getColumnModel().getColumn(11).setMaxWidth(170);
            jtableExcelCli.getColumnModel().getColumn(12).setMinWidth(70);
            jtableExcelCli.getColumnModel().getColumn(12).setPreferredWidth(70);
            jtableExcelCli.getColumnModel().getColumn(12).setMaxWidth(70);
            jtableExcelCli.getColumnModel().getColumn(13).setMinWidth(150);
            jtableExcelCli.getColumnModel().getColumn(13).setPreferredWidth(150);
            jtableExcelCli.getColumnModel().getColumn(13).setMaxWidth(150);
            jtableExcelCli.getColumnModel().getColumn(14).setMinWidth(170);
            jtableExcelCli.getColumnModel().getColumn(14).setPreferredWidth(170);
            jtableExcelCli.getColumnModel().getColumn(14).setMaxWidth(170);
            jtableExcelCli.getColumnModel().getColumn(15).setMinWidth(100);
            jtableExcelCli.getColumnModel().getColumn(15).setPreferredWidth(100);
            jtableExcelCli.getColumnModel().getColumn(15).setMaxWidth(100);
            jtableExcelCli.getColumnModel().getColumn(16).setMinWidth(90);
            jtableExcelCli.getColumnModel().getColumn(16).setPreferredWidth(90);
            jtableExcelCli.getColumnModel().getColumn(16).setMaxWidth(90);
            jtableExcelCli.getColumnModel().getColumn(17).setMinWidth(90);
            jtableExcelCli.getColumnModel().getColumn(17).setPreferredWidth(90);
            jtableExcelCli.getColumnModel().getColumn(17).setMaxWidth(90);
            jtableExcelCli.getColumnModel().getColumn(18).setMinWidth(150);
            jtableExcelCli.getColumnModel().getColumn(18).setPreferredWidth(150);
            jtableExcelCli.getColumnModel().getColumn(18).setMaxWidth(150);
            jtableExcelCli.getColumnModel().getColumn(19).setMinWidth(150);
            jtableExcelCli.getColumnModel().getColumn(19).setPreferredWidth(150);
            jtableExcelCli.getColumnModel().getColumn(19).setMaxWidth(150);
            jtableExcelCli.getColumnModel().getColumn(20).setMinWidth(150);
            jtableExcelCli.getColumnModel().getColumn(20).setPreferredWidth(150);
            jtableExcelCli.getColumnModel().getColumn(20).setMaxWidth(150);
            jtableExcelCli.getColumnModel().getColumn(21).setMinWidth(150);
            jtableExcelCli.getColumnModel().getColumn(21).setPreferredWidth(150);
            jtableExcelCli.getColumnModel().getColumn(21).setMaxWidth(105);
            jtableExcelCli.getColumnModel().getColumn(22).setMinWidth(200);
            jtableExcelCli.getColumnModel().getColumn(22).setPreferredWidth(200);
            jtableExcelCli.getColumnModel().getColumn(22).setMaxWidth(200);
        }

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jLabel7.setBackground(new java.awt.Color(51, 51, 51));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(219, 218, 218));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Listas de Cliente");
        jLabel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel7.setOpaque(true);
        jLabel7.setPreferredSize(new java.awt.Dimension(138, 60));
        getContentPane().add(jLabel7, java.awt.BorderLayout.PAGE_START);

        jPanel1.setPreferredSize(new java.awt.Dimension(946, 80));

        jSplitPane1.setBorder(null);
        jSplitPane1.setDividerSize(50);

        jbCadClientes.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jbCadClientes.setText("CADASTRAR");
        jbCadClientes.setPreferredSize(new java.awt.Dimension(200, 65));
        jbCadClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadClientesActionPerformed(evt);
            }
        });
        jSplitPane1.setLeftComponent(jbCadClientes);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton2.setText("CANCELAR");
        jButton2.setPreferredSize(new java.awt.Dimension(200, 65));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jSplitPane1.setRightComponent(jButton2);

        jPanel1.add(jSplitPane1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jbCadClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadClientesActionPerformed
        DefaultTableModel objTM = (DefaultTableModel) jtableExcelCli.getModel();
        ClienteCtrl objCliente = new ClienteCtrl();
        ClienteDao objDao = new ClienteDao();
        int codCli=0, tamTable = objTM.getRowCount(), posiLinha = 0;
        boolean isCad = false;
        System.out.println("tamanho Tabela: "+tamTable);
        for(int l = 0; l < tamTable; l++){
        try{   
            System.out.println("indice Tabela: "+l);

                //DADOS PESSOAIS
                objCliente.setId(0);
                objCliente.setNome(objTM.getValueAt(posiLinha, 0).toString());
                objCliente.setApelido(objTM.getValueAt(posiLinha, 1).toString());
                objCliente.setData_nasc(objTM.getValueAt(posiLinha, 5).toString());
                objCliente.setEstado_civil(objTM.getValueAt(posiLinha, 6).toString());

                //CONTATOS
                objCliente.setCelular(objTM.getValueAt(posiLinha, 18).toString());
                objCliente.setTel_resi(objTM.getValueAt(posiLinha, 19).toString());
                objCliente.setTel_comer(objTM.getValueAt(posiLinha, 20).toString());
                objCliente.setEmail(objTM.getValueAt(posiLinha, 21).toString());

                //ENDEREÇOS
                objCliente.setCep(Integer.parseInt(objTM.getValueAt(posiLinha, 10).toString()));
                objCliente.setRua(objTM.getValueAt(posiLinha, 11).toString());
                if(objTM.getValueAt(posiLinha, 12).toString().equals("")) objCliente.setNumero(0);
                else objCliente.setNumero(Integer.parseInt(objTM.getValueAt(posiLinha, 12).toString()));
                objCliente.setComplem(objTM.getValueAt(posiLinha, 14).toString());
                objCliente.setBairro(objTM.getValueAt(posiLinha, 13).toString());
                objCliente.setCidade(objTM.getValueAt(posiLinha, 15).toString());
                objCliente.setEstado(objTM.getValueAt(posiLinha, 16).toString());
                objCliente.setReferencia(objTM.getValueAt(posiLinha, 17).toString());

                //DOCUMENTOS
                if(objTM.getValueAt(posiLinha, 7).toString().equals("")) objCliente.setRg(0);
                else{
                    String[] rg = objTM.getValueAt(posiLinha, 7).toString().split("[-]");
                    if(rg.length > 1){
                        objCliente.setRg(Integer.parseInt(rg[0]+rg[1]));
                    }else objCliente.setRg(Integer.parseInt(objTM.getValueAt(posiLinha, 7).toString()));
                }
                if(objTM.getValueAt(posiLinha, 9).toString().equals("")){
                    objCliente.setCpf_cnpj(0);
                }else{
                    String[] cpf = objTM.getValueAt(posiLinha, 9).toString().split("[-]");
                    String[] cpf_1 = cpf[0].split("[.]");
                    objCliente.setCpf_cnpj(Long.parseLong(""+cpf_1[0]+cpf_1[1]+cpf_1[2]+cpf[1]));
                }
                if(objTM.getValueAt(posiLinha, 8).toString().equals("CPF")){
                    objCliente.setCpf_or_cnpj("CPF");
                }else{
                    objCliente.setCpf_or_cnpj("CNPJ");
                }
                //CREDITO
                if(objTM.getValueAt(posiLinha, 2).toString().equals("")){
                    objCliente.setValor_credito(0.0);                                       
                }else{
                    String limCompra = objTM.getValueAt(posiLinha, 2).toString();
                    limCompra = limCompra.replace(",", ".");
                    objCliente.setValor_credito(Double.valueOf(limCompra));                   
                }

                //FOTO
                objCliente.setFoto(null);

                //ANOTAÇÕES
                objCliente.setObs(objTM.getValueAt(posiLinha, 22).toString());

                 if(objDao.verificarRgCpf(objTM.getValueAt(posiLinha, 7).toString(),objTM.getValueAt(posiLinha, 9).toString())){
                    posiLinha++;
                    isCad = true;
                }else{    
                    codCli = objDao.inserir(objCliente);    
                    objTM.removeRow(posiLinha);
                }
                System.out.println("codCLi: "+codCli);
        }catch(Exception e){System.out.println("Error no inserir: "+e);}
        }
        if(isCad){
            JOptionPane.showMessageDialog(this, "Os Clientes que estão na Lista já foram cadastrados noSistema!!!");
            isCad = false;
        }
        if(objTM.getRowCount()<0) {
            try {
            SisPrinc.class.newInstance().clickBtnCli();
        } catch (InstantiationException ex) {
            Logger.getLogger(CadExcelCli.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CadExcelCli.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_jbCadClientesActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        try {
            SisPrinc.class.newInstance().clickBtnCli();
        } catch (InstantiationException ex) {
            Logger.getLogger(CadExcelCli.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CadExcelCli.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(CadExcelCli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadExcelCli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadExcelCli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadExcelCli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadExcelCli().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton jbCadClientes;
    private javax.swing.JTable jtableExcelCli;
    // End of variables declaration//GEN-END:variables
}

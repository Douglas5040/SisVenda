/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import ctrl.ClienteCtrl;
import ctrl.FamiliaCliCtrl;
import ctrl.FormatacaoConteudoCtrl;
import ctrl.ProdutoCtrl;
import dao.ClienteDao;
import dao.FamiliaCliDAO;
import dao.ProdutoDao;
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
public class CadExcelPro extends javax.swing.JFrame {

    /**
     * Creates new form CadExcelCli
     */
    public CadExcelPro() {
        initComponents();
        jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jtableExcelPro.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        //jScrollPane1.setHorizontalScrollBar(new JScrollBar());
        try{
            
            XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(SisPrinc.fileExportPro));
            
            
            DefaultTableModel objTM = (DefaultTableModel) jtableExcelPro.getModel();
            objTM.setRowCount(0);
            Sheet sheet = workbook.getSheetAt(0);
            System.out.println("linhas: "+sheet.getPhysicalNumberOfRows());

            String sCOD_BARRAS = "";
            String sNOME = "";
            String sESTOQ_MIN = "";
            String sESTOQ_MAX = "";
            String sESTOQ_ATUAL = "";
            String sCUSTO_FAB = "";
            String sPRECO_VARE = "";
            String sPRECO_ATAC = "";
            String sPESO = "";
            String sBONUS = "";
            String sVALOR_BONUS = "";
            String sLUCRO = "";
            String sIPI = "";
            String sCEST = "";
            String sICMS = "";
            String sNCM = "";
            String sFORNECEDOR = "";
            String sUND_MED = "";
            String sMARCA = "";
            String sCATEGORIA = "";
            String sDATA_FAB = "";
            String sVALIDADE = "";
            String sDESCRI = "";
            
            Iterator<Row> linhas = sheet.rowIterator();
            linhas.next();
            while (linhas.hasNext()) {
                XSSFRow linha = (XSSFRow) linhas.next();
                Iterator<Cell> celulas = linha.cellIterator();
                
                    while (celulas.hasNext()) {
                        XSSFCell celula = (XSSFCell) celulas.next();
                        int z = celula.getColumnIndex();
                        if (celula.toString().isEmpty()) {
                            //Mensagem de célula vazia
                            System.out.println("indice vazia: "+celula.toString()+" - "+celula.getColumnIndex()+", "+linha.getRowNum());
                        }
                        switch (z) {
                            case 1:
                                sMARCA = celula.toString();
                            break;
                            case 3:
                                sNOME = celula.toString();
                            break;
                            case 4:
                                sESTOQ_MIN = celula.toString();
                            break;
                            case 5:
                                sESTOQ_MAX = celula.toString();
                            break;
                            case 6:
                                sESTOQ_ATUAL = celula.toString();
                            break;
                            case 7:
                                sUND_MED = celula.toString();
                            break;
                            case 8:
                                sPRECO_VARE = celula.toString();
                            break;
                            case 9:
                                sPRECO_ATAC = celula.toString();
                            break;
                            case 10:
                                sCUSTO_FAB = celula.toString();
                            break;
                            case 11:
                                sPESO = celula.toString();
                            break;
                            case 12:
                                sIPI = celula.toString();
                            break;
                            case 13:
                                sICMS = celula.toString();
                            break;
                            case 14:
                                sNCM = celula.toString();
                            break;
                            case 16:
                                sCOD_BARRAS = celula.toString();
                            break;
                            case 17:
                                sCATEGORIA = celula.toString();
                            break;
                            case 18:
                                sDESCRI = celula.toString();
                            break;
                            case 21:
                                sLUCRO = celula.toString();
                            break;
                            case 25:
                                sCEST = celula.toString();
                            break;
                            default: 
                                System.out.println("Indice fora: "+z);
                            break;
                        }
                    }
                        String linhaTable[] = {
                             ""+sCOD_BARRAS,
                             ""+sNOME,
                             ""+sESTOQ_MIN,
                             ""+sESTOQ_MAX,
                             ""+sESTOQ_ATUAL,
                             ""+sCUSTO_FAB,
                             ""+sPRECO_VARE,
                             ""+sPRECO_ATAC,
                             ""+sPESO,
                             ""+sBONUS,
                             ""+sVALOR_BONUS,
                             ""+sLUCRO,
                             ""+sIPI,
                             ""+sCEST,
                             ""+sICMS,
                             ""+sNCM,
                             ""+sFORNECEDOR,
                             ""+sUND_MED,
                             ""+sMARCA,
                             ""+sCATEGORIA,
                             ""+sDATA_FAB,
                             ""+sVALIDADE,
                             ""+sDESCRI 
                        };
                        objTM.addRow(linhaTable);
//                        for(int l=1; l < objTM.getRowCount(); l++){
//                            System.out.println("linha deletada: "+l);
//                            if(objTM.getValueAt(l, 0).equals(objTM.getValueAt(l-1, 0)) && objTM.getValueAt(l, 9).equals(objTM.getValueAt(l-1, 9))){
//                                objTM.removeRow(l);
//                            }
//
//                        }
                        
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
        jtableExcelPro = new javax.swing.JTable();
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

        jtableExcelPro.setAutoCreateRowSorter(true);
        jtableExcelPro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtableExcelPro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"oçp", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"iopio", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "COD BARRAS", "NOME", "ESTOQ MINIMO", "ESTOQ MAXIMO", "ESTOQ ATUAL", "CUSTO FABRICA", "PREÇO VAREJO", "PREÇO ATACADO", "PESO", "PONTO BONUS", "VALOR BONUS", "LUCRO", "IPI", "CEST", "ICMS", "NCM", "FORNECEDOR", "UND MEDIDA", "MARCA", "CATEGORIA", "DATA FABRICA", "VALIDADE", "DESCRIÇÃO"
            }
        ));
        jtableExcelPro.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtableExcelPro.setDragEnabled(true);
        jtableExcelPro.setRowHeight(25);
        jtableExcelPro.setRowMargin(2);
        jtableExcelPro.getTableHeader().setResizingAllowed(false);
        jtableExcelPro.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtableExcelPro);
        if (jtableExcelPro.getColumnModel().getColumnCount() > 0) {
            jtableExcelPro.getColumnModel().getColumn(0).setMinWidth(100);
            jtableExcelPro.getColumnModel().getColumn(0).setPreferredWidth(100);
            jtableExcelPro.getColumnModel().getColumn(0).setMaxWidth(100);
            jtableExcelPro.getColumnModel().getColumn(1).setMinWidth(250);
            jtableExcelPro.getColumnModel().getColumn(1).setPreferredWidth(250);
            jtableExcelPro.getColumnModel().getColumn(1).setMaxWidth(250);
            jtableExcelPro.getColumnModel().getColumn(2).setMinWidth(100);
            jtableExcelPro.getColumnModel().getColumn(2).setPreferredWidth(100);
            jtableExcelPro.getColumnModel().getColumn(2).setMaxWidth(100);
            jtableExcelPro.getColumnModel().getColumn(3).setMinWidth(100);
            jtableExcelPro.getColumnModel().getColumn(3).setPreferredWidth(100);
            jtableExcelPro.getColumnModel().getColumn(3).setMaxWidth(100);
            jtableExcelPro.getColumnModel().getColumn(4).setMinWidth(100);
            jtableExcelPro.getColumnModel().getColumn(4).setPreferredWidth(100);
            jtableExcelPro.getColumnModel().getColumn(4).setMaxWidth(100);
            jtableExcelPro.getColumnModel().getColumn(5).setMinWidth(110);
            jtableExcelPro.getColumnModel().getColumn(5).setPreferredWidth(110);
            jtableExcelPro.getColumnModel().getColumn(5).setMaxWidth(110);
            jtableExcelPro.getColumnModel().getColumn(6).setMinWidth(110);
            jtableExcelPro.getColumnModel().getColumn(6).setPreferredWidth(110);
            jtableExcelPro.getColumnModel().getColumn(6).setMaxWidth(110);
            jtableExcelPro.getColumnModel().getColumn(7).setMinWidth(110);
            jtableExcelPro.getColumnModel().getColumn(7).setPreferredWidth(110);
            jtableExcelPro.getColumnModel().getColumn(7).setMaxWidth(110);
            jtableExcelPro.getColumnModel().getColumn(8).setMinWidth(60);
            jtableExcelPro.getColumnModel().getColumn(8).setPreferredWidth(60);
            jtableExcelPro.getColumnModel().getColumn(8).setMaxWidth(60);
            jtableExcelPro.getColumnModel().getColumn(9).setMinWidth(100);
            jtableExcelPro.getColumnModel().getColumn(9).setPreferredWidth(100);
            jtableExcelPro.getColumnModel().getColumn(9).setMaxWidth(100);
            jtableExcelPro.getColumnModel().getColumn(10).setMinWidth(100);
            jtableExcelPro.getColumnModel().getColumn(10).setPreferredWidth(100);
            jtableExcelPro.getColumnModel().getColumn(10).setMaxWidth(100);
            jtableExcelPro.getColumnModel().getColumn(11).setMinWidth(90);
            jtableExcelPro.getColumnModel().getColumn(11).setPreferredWidth(90);
            jtableExcelPro.getColumnModel().getColumn(11).setMaxWidth(90);
            jtableExcelPro.getColumnModel().getColumn(12).setMinWidth(80);
            jtableExcelPro.getColumnModel().getColumn(12).setPreferredWidth(80);
            jtableExcelPro.getColumnModel().getColumn(12).setMaxWidth(80);
            jtableExcelPro.getColumnModel().getColumn(13).setMinWidth(80);
            jtableExcelPro.getColumnModel().getColumn(13).setPreferredWidth(80);
            jtableExcelPro.getColumnModel().getColumn(13).setMaxWidth(80);
            jtableExcelPro.getColumnModel().getColumn(14).setMinWidth(80);
            jtableExcelPro.getColumnModel().getColumn(14).setPreferredWidth(80);
            jtableExcelPro.getColumnModel().getColumn(14).setMaxWidth(80);
            jtableExcelPro.getColumnModel().getColumn(15).setMinWidth(80);
            jtableExcelPro.getColumnModel().getColumn(15).setPreferredWidth(80);
            jtableExcelPro.getColumnModel().getColumn(15).setMaxWidth(80);
            jtableExcelPro.getColumnModel().getColumn(16).setMinWidth(100);
            jtableExcelPro.getColumnModel().getColumn(16).setPreferredWidth(100);
            jtableExcelPro.getColumnModel().getColumn(16).setMaxWidth(100);
            jtableExcelPro.getColumnModel().getColumn(17).setMinWidth(50);
            jtableExcelPro.getColumnModel().getColumn(17).setPreferredWidth(50);
            jtableExcelPro.getColumnModel().getColumn(17).setMaxWidth(50);
            jtableExcelPro.getColumnModel().getColumn(18).setMinWidth(100);
            jtableExcelPro.getColumnModel().getColumn(18).setPreferredWidth(100);
            jtableExcelPro.getColumnModel().getColumn(18).setMaxWidth(100);
            jtableExcelPro.getColumnModel().getColumn(19).setMinWidth(100);
            jtableExcelPro.getColumnModel().getColumn(19).setPreferredWidth(100);
            jtableExcelPro.getColumnModel().getColumn(19).setMaxWidth(100);
            jtableExcelPro.getColumnModel().getColumn(20).setMinWidth(90);
            jtableExcelPro.getColumnModel().getColumn(20).setPreferredWidth(90);
            jtableExcelPro.getColumnModel().getColumn(20).setMaxWidth(90);
            jtableExcelPro.getColumnModel().getColumn(21).setMinWidth(90);
            jtableExcelPro.getColumnModel().getColumn(21).setPreferredWidth(90);
            jtableExcelPro.getColumnModel().getColumn(21).setMaxWidth(90);
            jtableExcelPro.getColumnModel().getColumn(22).setMinWidth(200);
            jtableExcelPro.getColumnModel().getColumn(22).setPreferredWidth(200);
            jtableExcelPro.getColumnModel().getColumn(22).setMaxWidth(200);
        }

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jLabel7.setBackground(new java.awt.Color(51, 51, 51));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(219, 218, 218));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Lista de Produtos");
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
        DefaultTableModel objTM = (DefaultTableModel) jtableExcelPro.getModel();
        ProdutoCtrl objCliente = new ProdutoCtrl();
        ProdutoDao objDao = new ProdutoDao();
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
            Logger.getLogger(CadExcelPro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CadExcelPro.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_jbCadClientesActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        try {
            SisPrinc.class.newInstance().clickBtnCli();
        } catch (InstantiationException ex) {
            Logger.getLogger(CadExcelPro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CadExcelPro.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(CadExcelPro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadExcelPro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadExcelPro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadExcelPro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadExcelPro().setVisible(true);
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
    private javax.swing.JTable jtableExcelPro;
    // End of variables declaration//GEN-END:variables
}

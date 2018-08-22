/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
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

                    switch (z) {
                        case 4:
                            sCPF_CNPJ = celula.toString();
                        case 5:
                            sNOME_RAZAO = celula.toString();
                        case 7:
                            sENDER_RUA = celula.toString();
                        case 8:
                            sNUMERO = celula.toString();
                        case 9:
                            sBAIRRO = celula.toString();
                        case 10:
                            sCOMPLEM = celula.toString();
                        case 11:
                            sCEP = celula.toString();
                        case 12:
                            sCIDADE = celula.toString();
                        case 14:
                            sESTADO = celula.toString();
                        case 17:
                            sTELE = celula.toString();
                        case 19:
                            sCELU = celula.toString();
                        case 21:
                            sTELE_COMER = celula.toString();
                        case 23:
                            sEMAIL = celula.toString();
                        case 24:
                            sRG = celula.toString();
                        case 25:
                            sOBS = celula.toString();
                        case 33:
                            sESTADO_CIVIL = celula.toString();
                        case 34:
                            sDATA_NASC = celula.toString();
                        case 35:
                            sREFERENCIA = celula.toString();
                        default: 
                    }
                }
                String linhaTable[] = {
                     ""+sNOME_RAZAO,
                     "",
                     "",
                     "",
                     "",
                     ""+sDATA_NASC,
                     ""+sESTADO_CIVIL,
                     ""+sRG,
                     ""+sCPF_CNPJ,
                     "CPF",
                     ""+sCEP,
                     ""+sENDER_RUA,
                     ""+sNUMERO,
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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
                "NOME", "APELIDO", "CREDITO R$", "BONUS", "FOTO", "NASCIMENTO", "ESTADO CIVIL", "RG", "CPF/CNPJ", "PESSOA", "CEP", "RUA", "NUMERO", "BAIRRO", "COMPLEMENTO", "CIDADE", "ESTADO", "REFERENCIA", "CELULAR", "TELEFONE 1", "TELEFONE 2", "EMAIL", "OBSERVAÇÃO"
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
            jtableExcelCli.getColumnModel().getColumn(0).setMinWidth(155);
            jtableExcelCli.getColumnModel().getColumn(0).setPreferredWidth(155);
            jtableExcelCli.getColumnModel().getColumn(0).setMaxWidth(155);
            jtableExcelCli.getColumnModel().getColumn(1).setMinWidth(145);
            jtableExcelCli.getColumnModel().getColumn(1).setPreferredWidth(145);
            jtableExcelCli.getColumnModel().getColumn(1).setMaxWidth(145);
            jtableExcelCli.getColumnModel().getColumn(2).setMinWidth(90);
            jtableExcelCli.getColumnModel().getColumn(2).setPreferredWidth(90);
            jtableExcelCli.getColumnModel().getColumn(2).setMaxWidth(90);
            jtableExcelCli.getColumnModel().getColumn(3).setMinWidth(80);
            jtableExcelCli.getColumnModel().getColumn(3).setPreferredWidth(80);
            jtableExcelCli.getColumnModel().getColumn(3).setMaxWidth(80);
            jtableExcelCli.getColumnModel().getColumn(4).setMinWidth(90);
            jtableExcelCli.getColumnModel().getColumn(4).setPreferredWidth(90);
            jtableExcelCli.getColumnModel().getColumn(4).setMaxWidth(90);
            jtableExcelCli.getColumnModel().getColumn(5).setMinWidth(90);
            jtableExcelCli.getColumnModel().getColumn(5).setPreferredWidth(90);
            jtableExcelCli.getColumnModel().getColumn(5).setMaxWidth(90);
            jtableExcelCli.getColumnModel().getColumn(6).setMinWidth(90);
            jtableExcelCli.getColumnModel().getColumn(6).setPreferredWidth(90);
            jtableExcelCli.getColumnModel().getColumn(6).setMaxWidth(90);
            jtableExcelCli.getColumnModel().getColumn(7).setMinWidth(80);
            jtableExcelCli.getColumnModel().getColumn(7).setPreferredWidth(80);
            jtableExcelCli.getColumnModel().getColumn(7).setMaxWidth(80);
            jtableExcelCli.getColumnModel().getColumn(8).setMinWidth(80);
            jtableExcelCli.getColumnModel().getColumn(8).setPreferredWidth(80);
            jtableExcelCli.getColumnModel().getColumn(8).setMaxWidth(80);
            jtableExcelCli.getColumnModel().getColumn(9).setMinWidth(50);
            jtableExcelCli.getColumnModel().getColumn(9).setPreferredWidth(50);
            jtableExcelCli.getColumnModel().getColumn(9).setMaxWidth(50);
            jtableExcelCli.getColumnModel().getColumn(10).setMinWidth(80);
            jtableExcelCli.getColumnModel().getColumn(10).setPreferredWidth(80);
            jtableExcelCli.getColumnModel().getColumn(10).setMaxWidth(80);
            jtableExcelCli.getColumnModel().getColumn(11).setMinWidth(130);
            jtableExcelCli.getColumnModel().getColumn(11).setPreferredWidth(130);
            jtableExcelCli.getColumnModel().getColumn(11).setMaxWidth(130);
            jtableExcelCli.getColumnModel().getColumn(12).setMinWidth(50);
            jtableExcelCli.getColumnModel().getColumn(12).setPreferredWidth(50);
            jtableExcelCli.getColumnModel().getColumn(12).setMaxWidth(50);
            jtableExcelCli.getColumnModel().getColumn(13).setMinWidth(130);
            jtableExcelCli.getColumnModel().getColumn(13).setPreferredWidth(130);
            jtableExcelCli.getColumnModel().getColumn(13).setMaxWidth(130);
            jtableExcelCli.getColumnModel().getColumn(14).setMinWidth(150);
            jtableExcelCli.getColumnModel().getColumn(14).setPreferredWidth(150);
            jtableExcelCli.getColumnModel().getColumn(14).setMaxWidth(150);
            jtableExcelCli.getColumnModel().getColumn(15).setMinWidth(130);
            jtableExcelCli.getColumnModel().getColumn(15).setPreferredWidth(130);
            jtableExcelCli.getColumnModel().getColumn(15).setMaxWidth(130);
            jtableExcelCli.getColumnModel().getColumn(16).setMinWidth(100);
            jtableExcelCli.getColumnModel().getColumn(16).setPreferredWidth(100);
            jtableExcelCli.getColumnModel().getColumn(16).setMaxWidth(100);
            jtableExcelCli.getColumnModel().getColumn(17).setMinWidth(130);
            jtableExcelCli.getColumnModel().getColumn(17).setPreferredWidth(130);
            jtableExcelCli.getColumnModel().getColumn(17).setMaxWidth(130);
            jtableExcelCli.getColumnModel().getColumn(18).setMinWidth(90);
            jtableExcelCli.getColumnModel().getColumn(18).setPreferredWidth(90);
            jtableExcelCli.getColumnModel().getColumn(18).setMaxWidth(90);
            jtableExcelCli.getColumnModel().getColumn(19).setMinWidth(90);
            jtableExcelCli.getColumnModel().getColumn(19).setPreferredWidth(90);
            jtableExcelCli.getColumnModel().getColumn(19).setMaxWidth(90);
            jtableExcelCli.getColumnModel().getColumn(20).setMinWidth(90);
            jtableExcelCli.getColumnModel().getColumn(20).setPreferredWidth(90);
            jtableExcelCli.getColumnModel().getColumn(20).setMaxWidth(90);
            jtableExcelCli.getColumnModel().getColumn(21).setMinWidth(150);
            jtableExcelCli.getColumnModel().getColumn(21).setPreferredWidth(150);
            jtableExcelCli.getColumnModel().getColumn(21).setMaxWidth(150);
        }

        jLabel7.setBackground(new java.awt.Color(51, 51, 51));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(219, 218, 218));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Gerenciamento de Cliente");
        jLabel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel7.setOpaque(true);
        jLabel7.setPreferredSize(new java.awt.Dimension(138, 60));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setText("CADASTRAR");

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton2.setText("CANCELAR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 926, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtableExcelCli;
    // End of variables declaration//GEN-END:variables
}

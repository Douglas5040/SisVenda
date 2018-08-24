/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import ctrl.ClienteCtrl;
import ctrl.ControleProCtrl;
import ctrl.FamiliaCliCtrl;
import ctrl.FormatacaoConteudoCtrl;
import ctrl.ProdutoCtrl;
import dao.CategoriaDao;
import dao.ClienteDao;
import dao.ControleProDAO;
import dao.FamiliaCliDAO;
import dao.FornecedorDao;
import dao.MarcaDao;
import dao.ProdutoDao;
import dao.UnidadeDao;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.LayoutManager2;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
        Alertas alerta = new Alertas("Aguarde", "CARREGAMDO...", getWidth(), getHeight());
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
                                if(celula.toString().isEmpty()) sESTOQ_MIN = "0.0";
                                else sESTOQ_MIN = celula.toString();
                            break;
                            case 5:
                                if(celula.toString().isEmpty()) sESTOQ_MAX = "0.0";
                                else sESTOQ_MAX = celula.toString();
                            break;
                            case 6:
                                if(celula.toString().isEmpty()) sESTOQ_ATUAL = "0.0";
                                else sESTOQ_ATUAL = celula.toString();
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
                                if(sPESO.isEmpty()) sPESO = "0.0";
                                else sPESO = celula.toString();
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
                             ""+Math.round(Double.valueOf(sESTOQ_MIN+"0")),
                             ""+Math.round(Double.valueOf(sESTOQ_MAX+"0")),
                             ""+Math.round(Double.valueOf(sESTOQ_ATUAL+"0")),
                             ""+sCUSTO_FAB+"0",
                             ""+sPRECO_VARE+"0",
                             ""+sPRECO_ATAC+"0",
                             ""+Math.round(Double.valueOf(sPESO+"0")),
                             ""+sBONUS,
                             ""+sVALOR_BONUS+"0",
                             ""+sLUCRO+"0",
                             ""+sIPI+"0",
                             ""+sCEST+"0",
                             ""+sICMS+"0",
                             ""+sNCM+"0",
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
            alerta.sumir();
       }
       
            
            alerta.sumir();
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
        ProdutoCtrl objProduto = new ProdutoCtrl();
        ProdutoDao objProDao = new ProdutoDao();
        CategoriaDao cateDao = new CategoriaDao();
        MarcaDao marcaDao = new MarcaDao();
        UnidadeDao undDao = new UnidadeDao();
        FornecedorDao forneDao = new FornecedorDao();
        
        
        Alertas alerta = new Alertas("Aguarde", "CADASTRANDO...", getWidth(), getHeight());
        
        int tamTable = objTM.getRowCount(), posiLinha = 0;
        boolean isCad = false;
        System.out.println("tamanho Tabela: "+tamTable);
        for(int l = 0; l < tamTable; l++){
//        try{   
            System.out.println("indice Tabela: "+l);

                ///DADOS PRODUTO
                objProduto.setID(0);
                objProduto.setCod_barras(objTM.getValueAt(posiLinha, 0).toString());
                objProduto.setNome(objTM.getValueAt(posiLinha, 1).toString());
                if(objTM.getValueAt(posiLinha, 19).toString().isEmpty()) objProduto.setCod_categoria(-1);
                else objProduto.setCod_categoria(cateDao.selecionarCategoCod(objTM.getValueAt(posiLinha, 19).toString()));
                if(objTM.getValueAt(posiLinha, 16).toString().isEmpty()) objProduto.setCod_fornecedor(-1);
                else objProduto.setCod_fornecedor(forneDao.selectCodForneceID(objTM.getValueAt(posiLinha, 16).toString()));
                if(objTM.getValueAt(posiLinha, 17).toString().isEmpty()) objProduto.setCod_und_med(-1);
                else objProduto.setCod_und_med(undDao.selecionarUnidadeMedCod(objTM.getValueAt(posiLinha, 17).toString()));
                if(objTM.getValueAt(posiLinha, 16).toString().isEmpty()) objProduto.setCod_marca(-1);
                else objProduto.setCod_marca(marcaDao.selectCodMarca(objTM.getValueAt(posiLinha, 16).toString()));
                if(objTM.getValueAt(posiLinha, 8).toString().isEmpty()) objProduto.setPeso(0);
                else objProduto.setPeso(Integer.parseInt(objTM.getValueAt(posiLinha, 8).toString()));

                //PREÇO
                String priceFabric = objTM.getValueAt(posiLinha, 5).toString(),
                priceVarejo = objTM.getValueAt(posiLinha, 6).toString(),
                priceAtacado = objTM.getValueAt(posiLinha, 7).toString(),
                lucroMarkup  = objTM.getValueAt(posiLinha, 11).toString(),
                valorBonus = objTM.getValueAt(posiLinha, 10).toString();

                priceFabric = priceFabric.replace(",", ".");
                priceVarejo = priceVarejo.replace(",", ".");
                priceAtacado = priceAtacado.replace(",", ".");
                lucroMarkup = lucroMarkup.replace(",", ".");
                valorBonus = valorBonus.replace(",", ".");
        
                if(priceFabric.isEmpty()) objProduto.setCusto_fabrica(0.0);
                else objProduto.setCusto_fabrica(Double.valueOf(priceFabric));
                if(priceVarejo.isEmpty()) objProduto.setPreco_varejo(0.0);
                else  objProduto.setPreco_varejo(Double.valueOf(priceVarejo));
                if(priceAtacado.isEmpty()) objProduto.setPreco_atacado(0.0);
                else  objProduto.setPreco_atacado(Double.valueOf(priceAtacado));
                if(lucroMarkup.isEmpty()) objProduto.setMarkup_lucro(0.0);
                else  objProduto.setMarkup_lucro(Double.valueOf(lucroMarkup));
                if(objTM.getValueAt(posiLinha, 9).toString().isEmpty()) objProduto.setPontos_bonus(0);
                else  objProduto.setPontos_bonus(Integer.parseInt(objTM.getValueAt(posiLinha, 9).toString()));
                if(valorBonus.isEmpty()) objProduto.setValor_bonus(0.0);
                else objProduto.setValor_bonus(Double.valueOf(valorBonus));

                //ESTOQUE
                if(objTM.getValueAt(posiLinha, 3).toString().isEmpty()) objProduto.setEstoq_max(0);
                else objProduto.setEstoq_max(Integer.parseInt(objTM.getValueAt(posiLinha, 3).toString()));
                if(objTM.getValueAt(posiLinha, 2).toString().isEmpty()) objProduto.setEstoq_min(0);
                else  objProduto.setEstoq_min(Integer.parseInt(objTM.getValueAt(posiLinha, 2).toString()));
                if(objTM.getValueAt(posiLinha, 4).toString().isEmpty()) objProduto.setEstoq_atual(0);
                else objProduto.setEstoq_atual(Integer.parseInt(objTM.getValueAt(posiLinha, 4).toString()));

                //DADOS FISCAIS
                String    impIPI = objTM.getValueAt(posiLinha, 12).toString(),
                          impCEST = objTM.getValueAt(posiLinha, 13).toString(),
                          impICMS = objTM.getValueAt(posiLinha, 14).toString(),
                          impNCM  = objTM.getValueAt(posiLinha, 15).toString();

                          impIPI = impIPI.replace(",", ".");
                          impCEST = impCEST.replace(",", ".");
                          impICMS = impICMS.replace(",", ".");
                          impNCM = impNCM.replace(",", ".");

                if(impIPI.isEmpty())objProduto.setIpi_impost(0.0);
                else objProduto.setIpi_impost(Double.valueOf(impIPI));
                if(impIPI.isEmpty())  objProduto.setCest_impost(0.0);
                else objProduto.setCest_impost(Double.valueOf(impCEST));
                if(impIPI.isEmpty()) objProduto.setIcms_impost(0.0);
                else objProduto.setIcms_impost(Double.valueOf(impICMS));
                if(impIPI.isEmpty()) objProduto.setNcm_impost(0.0);
                else objProduto.setNcm_impost(Double.valueOf(impNCM));
                        
                //DESCRIÇÃO
                objProduto.setDescri(objTM.getValueAt(posiLinha, 22).toString());

                //IMAGENS
                objProduto.setImg1(null);
                objProduto.setImg2(null);

                //DATAS PRODUTO
                if(objTM.getValueAt(posiLinha, 20).toString().isEmpty()) objProduto.setData_fabrica("0001-00-00");
                else objProduto.setData_fabrica(objTM.getValueAt(posiLinha, 20).toString().substring(6,10)+"/"+
                                            objTM.getValueAt(posiLinha, 20).toString().substring(3,5)+"/"+
                                            objTM.getValueAt(posiLinha, 20).toString().substring(0,2));
                if(objTM.getValueAt(posiLinha, 21).toString().isEmpty()) objProduto.setValidade("0001-00-00");
                else objProduto.setValidade(objTM.getValueAt(posiLinha, 21).toString().substring(6,10)+"/"+
                                        objTM.getValueAt(posiLinha, 21).toString().substring(3,5)+"/"+
                                        objTM.getValueAt(posiLinha, 21).toString().substring(0,2));
                //STATUS
                objProduto.setCod_status(1);
                        
                if(objProDao.verificarPro(""+objProduto.getCod_barras())){
                    posiLinha++;
                    isCad = true;
                }else{    
                    ControleProDAO ctrlProDao = new ControleProDAO();
                    ControleProCtrl ctrlProCtrl = new ControleProCtrl();

                    objProDao.inserir(objProduto);
                    
                    ctrlProCtrl.setCodPro(objProDao.selecionarID(objProduto.getCod_barras()));
                    ctrlProCtrl.setCodOpera(6);
                    ctrlProCtrl.setCodUser(SisPrinc.userlogin.getId());
                    ctrlProCtrl.setCodCli(-1);
                    ctrlProCtrl.setCodFornece(objProduto.getCod_fornecedor());
                    ctrlProCtrl.setQtd(objProduto.getEstoq_atual());
                    ctrlProCtrl.setHora(SisPrinc.hora);
                    Date dataSistema = new Date();
                    SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
                    ctrlProCtrl.setDate(formato.format(dataSistema));
                    ctrlProCtrl.setObs(objProduto.getDescri());

                    ctrlProDao.inserir(ctrlProCtrl);
 
                    objTM.removeRow(posiLinha);
                }

                
//        }catch(Exception e){System.out.println("Error no inserir: "+e);}
        }
        if(isCad){
            JOptionPane.showMessageDialog(this, "Os Produtos que estão na Lista já foram cadastrados noSistema!!!");
            isCad = false;
            alerta.sumir();
        }
        if(objTM.getRowCount()<0) {
            try {
            SisPrinc.class.newInstance().clickBtnPro();
            alerta.sumir();
        } catch (InstantiationException ex) {
            Logger.getLogger(CadExcelPro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CadExcelPro.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
            alerta.sumir();
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

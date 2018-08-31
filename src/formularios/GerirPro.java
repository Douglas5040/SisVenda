/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import ctrl.DocumentJTextFIXACtrl;
import ctrl.DocumentJTextNumerosCtrl;
import ctrl.ProdutoCtrl;
import dao.CategoriaDao;
import dao.FornecedorDao;
import dao.MarcaDao;
import dao.ProdutoDao;
import dao.UnidadeDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JOptionPane;
import sisvenda.SistemaVendas;

/**
 *
 * @author Adm
 */
public class GerirPro extends javax.swing.JFrame {

    public static int codProduto = 0;
    public static boolean okOperation = false;
    
    
    /**
     * Creates new form CadPro
     */
    public GerirPro() {
        initComponents();
        
        //ProdutoCtrl objProduto = new ProdutoCtrl();
        ProdutoDao objProDao = new ProdutoDao();
        CategoriaDao cateDao = new CategoriaDao();
        FornecedorDao forneDao = new FornecedorDao();
        UnidadeDao undDao = new UnidadeDao();
        MarcaDao marcaDao = new MarcaDao();
        
        FornecedorDao objForneDao = new FornecedorDao();
        CategoriaDao objCateDao = new CategoriaDao();
        UnidadeDao objUndDao = new UnidadeDao();
        MarcaDao objMarcaDao = new MarcaDao();
        
        ResultSet objForneRs = objForneDao.selecionar(); 
        ResultSet objCateRs = objCateDao.selecionar();
        ResultSet objUndRs = objUndDao.selecionar();
        ResultSet objMarcaRs = objMarcaDao.selecionar();
        
            jcCatego.removeAllItems();
            try {
                while(objCateRs.next()){jcCatego.addItem(objCateRs.getString("NOME"));}
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "erro ao fazer cunsulta de categorias, "+ex);
            }if(jcCatego.getItemCount()<1) JOptionPane.showMessageDialog(null, "CATEGORIOA NÃO ENCONTRADA");   
            
        
            jcFornece.removeAllItems();
            try {
                while(objForneRs.next()){jcFornece.addItem(objForneRs.getString("NOME_FANTAZIA"));}
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "erro ao fazer cunsulta de FORNECEDORES, "+ex);
            }if(jcFornece.getItemCount()<1) JOptionPane.showMessageDialog(null, "FORNECEDOR NÃO ENCONTRADO");    
        

            jcUnid.removeAllItems();
            try {
                while(objUndRs.next()){jcUnid.addItem(objUndRs.getString("NOME"));}
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "erro ao fazer cunsulta de Unidade Medida, "+ex);
            }if(jcUnid.getItemCount()<1) JOptionPane.showMessageDialog(null, "UNidade Medida NÃO ENCONTRADA");


            jcMarca.removeAllItems();
            try {
                while(objMarcaRs.next()){jcMarca.addItem(objMarcaRs.getString("NOME"));}
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "erro ao fazer cunsulta de Marca, "+ex);
            }if(jcMarca.getItemCount()<1) JOptionPane.showMessageDialog(null, "MARCA NÃO ENCONTRADA");    
 
            jcMarca.setNextFocusableComponent(jtCodBarras);
            jcMarca.nextFocus();
        
            
        System.out.println("consulta cod_Pro gereir produtos = "+SisPrinc.codPro);
        
        if(SisPrinc.codPro > 0){
        //Formulário de Consulta de preodutos
            jbCadPro.setEnabled(false);
            jbEditPro.setEnabled(true);
            System.out.println("consulta Produto = "+SisPrinc.codPro);
            
            try{
               ResultSet objProRs = objProDao.selecionarPro(String.valueOf(SisPrinc.codPro));
               if(objProRs.first() && objProRs != null){
                    
                    //DADOS DO PRODUTO
                    jtCodBarras.setText(objProRs.getString("COD_BARRAS"));
                    jtNome.setText(objProRs.getString("NOME"));
                    jtCatego.setText(cateDao.selecionarCatego(objProRs.getString("COD_CATEGORIA")).getString("NOME"));
                    jtFornece.setText(forneDao.selectFornece(objProRs.getString("COD_FORNECEDOR")).getString("NOME_FANTAZIA"));
                    jtUnid.setText(undDao.selecionarUndMed(objProRs.getString("COD_UNIDADE_MED")).getString("NOME"));
                    jtMarca.setText(marcaDao.selectMarca(objProRs.getString("COD_MARCA")).getString("NOME"));
                    jtPeso.setText(objProRs.getString("PESO"));

                    //PREÇO PRODUTO
                    jtPriceFrabric.setText(objProRs.getString("CUSTO_FABRICA"));
                    jtPriceVarejo.setText(objProRs.getString("PRECO_VAREJO"));
                    jtPriceAtaca.setText(objProRs.getString("PRECO_ATACADO"));
                    jtLucro.setText(objProRs.getString("MARKUP_LUCRO"));
                    jtValorBonus.setText(objProRs.getString("VALOR_BONUS"));       
                    jtBonus.setText(objProRs.getString("PONTOS_BONUS"));

                    //ESTOQUE
                    jtEstoqMax.setText(objProRs.getString("ESTOQ_MAX"));
                    jtEstoqMin.setText(objProRs.getString("ESTOQ_MIN"));
                    jtEstoqAtual.setText(objProRs.getString("ESTOQ_ATUAL"));

                    //DADOS FISCAIS
                    jtImpIPI.setText(objProRs.getString("IPI_IMPOSTO"));
                    jtImpCEST.setText(objProRs.getString("CEST_IMPOSTO"));
                    jtImpICMS.setText(objProRs.getString("ICMS_IMPOSTO"));
                    jtImpNCM.setText(objProRs.getString("NCM_IMPOSTO"));

                    //IMAGENS
                    //jlImg1
                    //jlImg2

                    //DESCRIÇÃO
                    jtaDescri.setText(objProRs.getString("DESCRI"));

                    //DATAS PRODUTO
                    jftDataFabric.setText(objProRs.getString("DATA_FABRICA").substring(8,10)+"/"+
                                          objProRs.getString("DATA_FABRICA").substring(5,7)+"/"+
                                          objProRs.getString("DATA_FABRICA").substring(0,4));
                    jftValidade.setText(objProRs.getString("VALIDADE").substring(8,10)+"/"+
                                        objProRs.getString("VALIDADE").substring(5,7)+"/"+
                                        objProRs.getString("VALIDADE").substring(0,4));

                }
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "erro ao fazer cunsulta de PRODUTOS GerirProdutos: "+ex);
            }
        }else{
        //Formulário de Cadastro de Produtos
                //DADOS DO PRODUTO
                jtCodBarras.setEditable(true);
                jtNome.setEditable(true);
                jtCatego.setEditable(true);
                jtFornece.setEditable(true);
                jtUnid.setEditable(true);
                jtMarca.setEditable(true);
                jtPeso.setEditable(true);
                jcCatego.setEnabled(true);
                jcFornece.setEnabled(true);
                jcUnid.setEnabled(true);
                jcMarca.setEnabled(true);
                
                //PREÇO PRODUTO
                jtPriceFrabric.setEditable(true);
                jtPriceVarejo.setEditable(true);
                jtPriceAtaca.setEditable(true);
                jtLucro.setEditable(true);
                jtValorBonus.setEditable(true);        
                jtBonus.setEditable(true);
                
                //ESTOQUE
                jtEstoqMax.setEditable(true);
                jtEstoqMin.setEditable(true);
                jtEstoqAtual.setEditable(true);
                        
                //DADOS FISCAIS
                jtImpIPI.setEditable(true);
                jtImpCEST.setEditable(true);
                jtImpICMS.setEditable(true);
                jtImpNCM.setEditable(true);
                        
                //IMAGENS
                jlImg1.setEnabled(true);
                jlImg2.setEnabled(true);
                        
                //DESCRIÇÃO
                jtaDescri.setEditable(true);
                        
                //DATAS PRODUTO
                jftDataFabric.setEditable(true);
                jftValidade.setEditable(true);
                
            jbCadPro.setEnabled(true);
            jbEditPro.setEnabled(false);
                
        
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

        jPanel9 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jtNome12 = new javax.swing.JTextField();
        jtNome21 = new javax.swing.JTextField();
        jtNome22 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jbCadPro = new javax.swing.JButton();
        jbCancel = new javax.swing.JButton();
        jbEditPro = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jtPriceAtaca = new javax.swing.JTextField();
        jtPriceFrabric = new javax.swing.JTextField();
        jtPriceVarejo = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jtBonus = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jtValorBonus = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jtLucro = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jtEstoqAtual = new javax.swing.JTextField();
        jtEstoqMax = new javax.swing.JTextField();
        jtEstoqMin = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaDescri = new javax.swing.JTextArea();
        jlMenssager = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jtPeso = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jtMarca = new javax.swing.JTextField();
        jtUnid = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jtFornece = new javax.swing.JTextField();
        jtCatego = new javax.swing.JTextField();
        jcFornece = new javax.swing.JComboBox<>();
        jcUnid = new javax.swing.JComboBox<>();
        jcCatego = new javax.swing.JComboBox<>();
        jtNome = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jtCodBarras = new javax.swing.JTextField();
        jcMarca = new javax.swing.JComboBox<>();
        jPanel10 = new javax.swing.JPanel();
        jlImg2 = new javax.swing.JLabel();
        jlImg1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jtImpICMS = new javax.swing.JTextField();
        jtImpIPI = new javax.swing.JTextField();
        jtImpCEST = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jtImpNCM = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jftValidade = new javax.swing.JFormattedTextField();
        jftDataFabric = new javax.swing.JFormattedTextField();

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Estoque:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Máximo:");

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel33.setText("Atual:");

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel34.setText("Mínimo:");

        jtNome12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jtNome21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtNome21.setText("R$ 3.000,00");

        jtNome22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jtNome21, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34)
                    .addComponent(jtNome22, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtNome12, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel33)
                    .addComponent(jLabel34))
                .addGap(1, 1, 1)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtNome21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtNome22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtNome12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(320, 90));
        setUndecorated(true);
        setOpacity(0.96F);
        setPreferredSize(new java.awt.Dimension(790, 610));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CADASTRO DE PRODUTOS");
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(222, 35));
        jLabel1.setVerifyInputWhenFocusTarget(false);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel3.add(jLabel1, java.awt.BorderLayout.NORTH);

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jbCadPro.setBackground(new java.awt.Color(32, 32, 32));
        jbCadPro.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jbCadPro.setForeground(new java.awt.Color(239, 239, 239));
        jbCadPro.setText("CADASTRAR");
        jbCadPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadProActionPerformed(evt);
            }
        });

        jbCancel.setBackground(new java.awt.Color(32, 32, 32));
        jbCancel.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jbCancel.setForeground(new java.awt.Color(239, 239, 239));
        jbCancel.setText("CANCELAR");
        jbCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelActionPerformed(evt);
            }
        });

        jbEditPro.setBackground(new java.awt.Color(32, 32, 32));
        jbEditPro.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jbEditPro.setForeground(new java.awt.Color(239, 239, 239));
        jbEditPro.setText("EDITAR");
        jbEditPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditProActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(179, Short.MAX_VALUE)
                .addComponent(jbEditPro, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jbCadPro)
                .addGap(27, 27, 27)
                .addComponent(jbCancel)
                .addGap(144, 144, 144))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jbCadPro, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jbCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jbEditPro, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel4.setLayout(new java.awt.BorderLayout());
        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 750, 10));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Preço", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Fabrica R$:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Atacado R$:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Varejo R$:");

        jtPriceAtaca.setEditable(false);
        jtPriceAtaca.setDocument(new DocumentJTextNumerosCtrl());
        jtPriceAtaca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtPriceAtaca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtPriceAtacaKeyPressed(evt);
            }
        });

        jtPriceFrabric.setEditable(false);
        jtPriceFrabric.setDocument(new DocumentJTextNumerosCtrl());
        jtPriceFrabric.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtPriceFrabric.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtPriceFrabricKeyPressed(evt);
            }
        });

        jtPriceVarejo.setEditable(false);
        jtPriceVarejo.setDocument(new DocumentJTextNumerosCtrl());
        jtPriceVarejo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtPriceVarejo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtPriceVarejoKeyPressed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Bonus(pontos)");

        jtBonus.setEditable(false);
        jtBonus.setDocument(new DocumentJTextNumerosCtrl());
        jtBonus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtBonus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtBonusActionPerformed(evt);
            }
        });
        jtBonus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtBonusKeyPressed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Valor Bonus R$:");

        jtValorBonus.setEditable(false);
        jtValorBonus.setDocument(new DocumentJTextNumerosCtrl());
        jtValorBonus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtValorBonus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtValorBonusKeyPressed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Lucro (%):");

        jtLucro.setEditable(false);
        jtLucro.setDocument(new DocumentJTextNumerosCtrl());
        jtLucro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtLucro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtLucroActionPerformed(evt);
            }
        });
        jtLucro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtLucroKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jtPriceFrabric, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtPriceVarejo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jtLucro, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtBonus, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtPriceAtaca, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jtValorBonus, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(1, 1, 1)
                        .addComponent(jtPriceAtaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(1, 1, 1)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtPriceVarejo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtPriceFrabric, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel20)
                            .addGap(1, 1, 1)
                            .addComponent(jtBonus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel21)
                            .addGap(1, 1, 1)
                            .addComponent(jtValorBonus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(3, 3, 3)
                        .addComponent(jtLucro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 340, 150));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Estoque:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Máximo:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Atual:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Mínimo:");

        jtEstoqAtual.setEditable(false);
        jtEstoqAtual.setDocument(new DocumentJTextNumerosCtrl());
        jtEstoqAtual.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtEstoqAtual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtEstoqAtualKeyPressed(evt);
            }
        });

        jtEstoqMax.setEditable(false);
        jtEstoqMax.setDocument(new DocumentJTextNumerosCtrl());
        jtEstoqMax.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtEstoqMax.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtEstoqMaxKeyPressed(evt);
            }
        });

        jtEstoqMin.setEditable(false);
        jtEstoqMin.setDocument(new DocumentJTextNumerosCtrl());
        jtEstoqMin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtEstoqMin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtEstoqMinKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jtEstoqMax, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jtEstoqMin, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtEstoqAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel18))
                .addGap(1, 1, 1)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtEstoqMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtEstoqMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtEstoqAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 340, 90));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("Descrição:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jtaDescri.setEditable(false);
        jtaDescri.setColumns(20);
        jtaDescri.setDocument(new DocumentJTextFIXACtrl());
        jtaDescri.setLineWrap(true);
        jtaDescri.setRows(5);
        jtaDescri.setTabSize(2);
        jtaDescri.setWrapStyleWord(true);
        jtaDescri.setMaximumSize(new java.awt.Dimension(10, 10));
        jtaDescri.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtaDescriKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtaDescri);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 280, 150));

        jlMenssager.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        jlMenssager.setForeground(new java.awt.Color(255, 51, 51));
        jlMenssager.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlMenssager.setText("---<Cadastrando Produto>---");
        jlMenssager.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(jlMenssager, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 750, 40));

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtPeso.setEditable(false);
        jtPeso.setDocument(new DocumentJTextNumerosCtrl());
        jtPeso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtPeso.setMargin(new java.awt.Insets(0, 1, 0, 0));
        jtPeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtPesoActionPerformed(evt);
            }
        });
        jtPeso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtPesoKeyPressed(evt);
            }
        });
        jPanel7.add(jtPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 201, 166, 23));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Peso (KG):");
        jPanel7.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Marca:");
        jPanel7.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jtMarca.setEditable(false);
        jtMarca.setDocument(new DocumentJTextFIXACtrl());
        jtMarca.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtMarca.setBorder(null);
        jtMarca.setMargin(new java.awt.Insets(2, 20, 2, 2));
        jtMarca.setPreferredSize(new java.awt.Dimension(100, 23));
        jtMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtMarcaKeyPressed(evt);
            }
        });
        jPanel7.add(jtMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 171, 144, 20));

        jtUnid.setEditable(false);
        jtUnid.setDocument(new DocumentJTextFIXACtrl());
        jtUnid.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtUnid.setBorder(null);
        jtUnid.setMargin(new java.awt.Insets(2, 20, 2, 2));
        jtUnid.setPreferredSize(new java.awt.Dimension(100, 23));
        jtUnid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtUnidKeyPressed(evt);
            }
        });
        jPanel7.add(jtUnid, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 141, 144, 20));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Unidade:");
        jPanel7.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setText("Fornecedor:");
        jPanel7.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jtFornece.setEditable(false);
        jtFornece.setDocument(new DocumentJTextFIXACtrl());
        jtFornece.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtFornece.setBorder(null);
        jtFornece.setMargin(new java.awt.Insets(2, 20, 2, 2));
        jtFornece.setPreferredSize(new java.awt.Dimension(100, 23));
        jtFornece.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtForneceKeyPressed(evt);
            }
        });
        jPanel7.add(jtFornece, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 111, 144, 20));

        jtCatego.setEditable(false);
        jtCatego.setDocument(new DocumentJTextFIXACtrl());
        jtCatego.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtCatego.setBorder(null);
        jtCatego.setMargin(new java.awt.Insets(2, 20, 2, 2));
        jtCatego.setPreferredSize(new java.awt.Dimension(100, 23));
        jtCatego.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtCategoKeyPressed(evt);
            }
        });
        jPanel7.add(jtCatego, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 81, 144, 20));

        jcFornece.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcFornece.setAutoscrolls(true);
        jcFornece.setPreferredSize(new java.awt.Dimension(245, 35));
        jcFornece.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jcForneceComponentResized(evt);
            }
        });
        jcFornece.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcForneceActionPerformed(evt);
            }
        });
        jcFornece.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcForneceKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jcForneceKeyReleased(evt);
            }
        });
        jPanel7.add(jcFornece, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 165, 23));

        jcUnid.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcUnid.setPreferredSize(new java.awt.Dimension(245, 35));
        jcUnid.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jcUnidComponentResized(evt);
            }
        });
        jcUnid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcUnidActionPerformed(evt);
            }
        });
        jcUnid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcUnidKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jcUnidKeyReleased(evt);
            }
        });
        jPanel7.add(jcUnid, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 165, 23));

        jcCatego.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcCatego.setPreferredSize(new java.awt.Dimension(245, 35));
        jcCatego.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jcCategoComponentResized(evt);
            }
        });
        jcCatego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcCategoActionPerformed(evt);
            }
        });
        jcCatego.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcCategoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jcCategoKeyReleased(evt);
            }
        });
        jPanel7.add(jcCatego, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 165, 23));

        jtNome.setEditable(false);
        jtNome.setDocument(new DocumentJTextFIXACtrl());
        jtNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtNome.setMargin(new java.awt.Insets(0, 1, 0, 0));
        jtNome.setPreferredSize(new java.awt.Dimension(4, 21));
        jtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtNomeActionPerformed(evt);
            }
        });
        jtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtNomeKeyPressed(evt);
            }
        });
        jPanel7.add(jtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 166, 23));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setText("Nome:");
        jPanel7.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setText("Categoria:");
        jPanel7.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setText("Cod. Barras:");
        jPanel7.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jtCodBarras.setEditable(false);
        jtCodBarras.setDocument(new DocumentJTextNumerosCtrl());
        jtCodBarras.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtCodBarras.setMargin(new java.awt.Insets(0, 1, 0, 0));
        jtCodBarras.setPreferredSize(new java.awt.Dimension(4, 21));
        jtCodBarras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtCodBarrasActionPerformed(evt);
            }
        });
        jtCodBarras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtCodBarrasKeyPressed(evt);
            }
        });
        jPanel7.add(jtCodBarras, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 166, 23));

        jcMarca.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcMarca.setPreferredSize(new java.awt.Dimension(245, 35));
        jcMarca.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jcMarcaComponentResized(evt);
            }
        });
        jcMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcMarcaActionPerformed(evt);
            }
        });
        jcMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcMarcaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jcMarcaKeyReleased(evt);
            }
        });
        jPanel7.add(jcMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 165, 23));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 290, 240));

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Imagens:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlImg2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlImg2.setText("Imagem 2");
        jlImg2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel10.add(jlImg2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 133, 88, 100));

        jlImg1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlImg1.setText("Imagem 1");
        jlImg1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel10.add(jlImg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 19, 88, 104));

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, 100, 240));

        jLabel4.setForeground(new java.awt.Color(153, 0, 0));
        jLabel4.setText("Click na Imagem para adicionar uma ao banco de dados");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 250, 280, 20));

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados Fiscais:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel35.setText("IPI (%):");

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel36.setText("ICMS (%):");

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel37.setText("CEST (%):");

        jtImpICMS.setEditable(false);
        jtImpICMS.setDocument(new DocumentJTextNumerosCtrl());
        jtImpICMS.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtImpICMS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtImpICMSKeyPressed(evt);
            }
        });

        jtImpIPI.setEditable(false);
        jtImpIPI.setDocument(new DocumentJTextNumerosCtrl());
        jtImpIPI.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtImpIPI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtImpIPIKeyPressed(evt);
            }
        });

        jtImpCEST.setEditable(false);
        jtImpCEST.setDocument(new DocumentJTextNumerosCtrl());
        jtImpCEST.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtImpCEST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtImpCESTActionPerformed(evt);
            }
        });
        jtImpCEST.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtImpCESTKeyPressed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel38.setText("NCM (%):");

        jtImpNCM.setEditable(false);
        jtImpNCM.setDocument(new DocumentJTextNumerosCtrl());
        jtImpNCM.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtImpNCM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtImpNCMKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35)
                    .addComponent(jtImpIPI, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtImpCEST, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addGap(42, 42, 42)))
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtImpICMS, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addComponent(jtImpNCM, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(jLabel35)
                    .addComponent(jLabel36)
                    .addComponent(jLabel38))
                .addGap(1, 1, 1)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtImpCEST, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtImpIPI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtImpICMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtImpNCM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, 440, 100));

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel39.setText("Validade: ");
        jPanel1.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 400, -1, -1));

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel40.setText("Fabricação:");
        jPanel1.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 400, -1, -1));

        jftValidade.setEditable(false);
        try {
            jftValidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftValidade.setPreferredSize(new java.awt.Dimension(6, 23));
        jftValidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jftValidadeActionPerformed(evt);
            }
        });
        jftValidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jftValidadeKeyPressed(evt);
            }
        });
        jPanel1.add(jftValidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 400, 110, 25));

        jftDataFabric.setEditable(false);
        try {
            jftDataFabric.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftDataFabric.setPreferredSize(new java.awt.Dimension(6, 23));
        jftDataFabric.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jftDataFabricKeyPressed(evt);
            }
        });
        jPanel1.add(jftDataFabric, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 397, 110, 25));

        jPanel3.add(jPanel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCadProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadProActionPerformed
       cadastrarPro();
    }//GEN-LAST:event_jbCadProActionPerformed

    private void jbCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelActionPerformed
        
           
        try {
            SisPrinc.class.newInstance().clickBtnPro();
        } catch (InstantiationException ex) {
            Logger.getLogger(GerirPro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GerirPro.class.getName()).log(Level.SEVERE, null, ex);
        }; 
        this.dispose();
    }//GEN-LAST:event_jbCancelActionPerformed

    private void jtPesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtPesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtPesoActionPerformed

    private void jtPesoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtPesoKeyPressed
         if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            jtPeso.setNextFocusableComponent(jtPriceFrabric);
            jtPeso.nextFocus();
            jtPriceFrabric.selectAll();
        } 
    }//GEN-LAST:event_jtPesoKeyPressed

    private void jtMarcaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtMarcaKeyPressed
        MarcaDao objDao = new MarcaDao();

        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(!jcMarca.isPopupVisible()){
                ResultSet objRs = objDao.selectMarca(jtMarca.getText());
                try {
                    jcMarca.setPopupVisible(true);
                    objRs.first();
                    jcMarca.setSelectedItem(objRs.getString("NOME"));
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "erro ao fazer cunsulta de Marca, "+ex);
                }

                if(jcMarca.getItemCount()<1) JOptionPane.showMessageDialog(null, "Marca NÃO ENCONTRADA");  
            }else {
                jtMarca.setText(jcMarca.getItemAt(jcMarca.getSelectedIndex()));
                jcMarca.setPopupVisible(false);
                jcMarca.setNextFocusableComponent(jtPeso);
                jcMarca.nextFocus();
                jtPeso.selectAll();
            }
        }
    }//GEN-LAST:event_jtMarcaKeyPressed

    private void jtForneceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtForneceKeyPressed
       FornecedorDao objDao = new FornecedorDao();

        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(!jcFornece.isPopupVisible()){
                ResultSet objRs = objDao.selectFornece(jtFornece.getText());
                try {
                    jcFornece.setPopupVisible(true);
                    objRs.first();
                    jcFornece.setSelectedItem(objRs.getString("NOME_FANTAZIA"));
                    
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "erro ao fazer cunsulta de FORNECEDORES, "+ex);
                }

                if(jcFornece.getItemCount()<1) JOptionPane.showMessageDialog(null, "FORNECEDOR NÃO ENCONTRADA");    
            }else {
                jtFornece.setText(jcFornece.getItemAt(jcFornece.getSelectedIndex()));
                jcFornece.setPopupVisible(false);
                jcFornece.setNextFocusableComponent(jtUnid);
                jcFornece.nextFocus();
                jtUnid.selectAll();
            }
        }
            
    }//GEN-LAST:event_jtForneceKeyPressed

    private void jtCategoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtCategoKeyPressed
        CategoriaDao objDao = new CategoriaDao();

        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(!jcCatego.isPopupVisible()){
                ResultSet objRs = objDao.selecionarCatego(jtCatego.getText());
                try {
                    jcCatego.setPopupVisible(true);
                    objRs.first();
                    jcCatego.setSelectedItem(objRs.getString("NOME"));
                        
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "erro ao fazer cunsulta de categorias, "+ex);
                }

                if(jcCatego.getItemCount()<1) JOptionPane.showMessageDialog(null, "CATEGORIA NÃO ENCONTRADA");    
            }else {
                jtCatego.setText(jcCatego.getItemAt(jcCatego.getSelectedIndex()));
                jcCatego.setPopupVisible(false);
                jcCatego.setNextFocusableComponent(jtFornece);
                jcCatego.nextFocus();
                jtFornece.selectAll();
            }
        }
    }//GEN-LAST:event_jtCategoKeyPressed

    private void jcForneceComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jcForneceComponentResized
        // TODO add your handling code here:
    }//GEN-LAST:event_jcForneceComponentResized

    private void jcForneceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcForneceActionPerformed
         System.out.println(evt.getActionCommand()+" - "+evt.paramString()+" - "+evt.getModifiers());    
      if(evt.getModifiers() == 16){
         jtFornece.setText(jcFornece.getItemAt(jcFornece.getSelectedIndex()));
       
       jcFornece.setNextFocusableComponent(jtFornece);
       jcFornece.nextFocus();
    }
    }//GEN-LAST:event_jcForneceActionPerformed

    private void jcForneceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcForneceKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jcForneceKeyReleased

    private void jcCategoComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jcCategoComponentResized
        // TODO add your handling code here:
    }//GEN-LAST:event_jcCategoComponentResized

    private void jcCategoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcCategoActionPerformed
        System.out.println(evt.getActionCommand()+" - "+evt.paramString()+" - "+evt.getModifiers());
       if(evt.getModifiers() == 16){
           jtCatego.setText(jcCatego.getItemAt(jcCatego.getSelectedIndex()));

           jcCatego.setNextFocusableComponent(jtCatego);
           jcCatego.nextFocus();
       }
    }//GEN-LAST:event_jcCategoActionPerformed

    private void jcCategoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcCategoKeyReleased
        
    }//GEN-LAST:event_jcCategoKeyReleased

    private void jtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtNomeActionPerformed

    private void jtNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtNomeKeyPressed
        
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            jtNome.setNextFocusableComponent(jtCatego);
            jtNome.nextFocus();
            jtCatego.selectAll();
        }
    }//GEN-LAST:event_jtNomeKeyPressed

    private void jtCodBarrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtCodBarrasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtCodBarrasActionPerformed

    private void jtCodBarrasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtCodBarrasKeyPressed
        
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            jtCodBarras.setNextFocusableComponent(jtNome);
            jtCodBarras.nextFocus();
            jtNome.selectAll();
        }
    }//GEN-LAST:event_jtCodBarrasKeyPressed

    private void jcMarcaComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jcMarcaComponentResized
        // TODO add your handling code here:
    }//GEN-LAST:event_jcMarcaComponentResized

    private void jcMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcMarcaActionPerformed
      if(evt.getModifiers() == 16){  
        jtMarca.setText(jcMarca.getItemAt(jcMarca.getSelectedIndex()));
       
       jcMarca.setNextFocusableComponent(jtMarca);
       jcMarca.nextFocus();
      }else if(evt.getModifiers() == 0){ 
          
      }
    }//GEN-LAST:event_jcMarcaActionPerformed

    private void jcMarcaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcMarcaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jcMarcaKeyReleased

    private void jbEditProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditProActionPerformed
        editarPro();
    }//GEN-LAST:event_jbEditProActionPerformed

    private void jtBonusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtBonusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtBonusActionPerformed

    private void jtUnidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtUnidKeyPressed
        UnidadeDao objDao = new UnidadeDao();

        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(!jcUnid.isPopupVisible()){
                ResultSet objRs = objDao.selecionarUndMed(jtUnid.getText());
                try {                
                    jcUnid.setPopupVisible(true);
                    objRs.first();
                    jcUnid.setSelectedItem(objRs.getString("NOME"));
                    
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "erro ao fazer cunsulta de Unidade Medida, "+ex);
                }

                if(jcUnid.getItemCount()<1) JOptionPane.showMessageDialog(null, "UNidade Medida NÃO ENCONTRADA");
            }else{
                jtUnid.setText(jcUnid.getItemAt(jcUnid.getSelectedIndex()));
                jcUnid.setPopupVisible(false);
                jcUnid.setNextFocusableComponent(jtMarca);
                jcUnid.nextFocus();
                jtMarca.selectAll();
            }
        }
    }//GEN-LAST:event_jtUnidKeyPressed

    private void jcUnidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcUnidKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jcUnidKeyReleased

    private void jcUnidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcUnidActionPerformed
      if(evt.getModifiers() == 16){      
        jtUnid.setText(jcUnid.getItemAt(jcUnid.getSelectedIndex()));

        jcUnid.setNextFocusableComponent(jtUnid);
        jcUnid.nextFocus();
      }
    }//GEN-LAST:event_jcUnidActionPerformed

    private void jcUnidComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jcUnidComponentResized
        // TODO add your handling code here:
    }//GEN-LAST:event_jcUnidComponentResized

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        
    }//GEN-LAST:event_formComponentShown

    private void jtPriceFrabricKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtPriceFrabricKeyPressed
       if(evt.getKeyCode()==KeyEvent.VK_ENTER){
           jtPriceFrabric.setText(jtPriceFrabric.getText().replace(",", "."));
           
            jtPriceFrabric.setNextFocusableComponent(jtLucro);
            jtPriceFrabric.nextFocus();
            jtLucro.selectAll();
        } 
    }//GEN-LAST:event_jtPriceFrabricKeyPressed

    private void jtPriceVarejoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtPriceVarejoKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
           jtPriceVarejo.setText(jtPriceVarejo.getText().replace(",", "."));
           
            Double priceVarejo = Double.valueOf(jtPriceVarejo.getText());
           jtBonus.setText(""+Math.round((priceVarejo*180)/100));
           
           if(priceVarejo<100 && priceVarejo>0) jtValorBonus.setText(String.format("%.2f",priceVarejo*0.04));
           else if(priceVarejo>100 && priceVarejo<200) jtValorBonus.setText(String.format("%.2f",priceVarejo*0.03));
           else if(priceVarejo>=200) jtValorBonus.setText(String.format("%.2f",priceVarejo*0.02));
  
            jtPriceVarejo.setNextFocusableComponent(jtBonus);
            jtPriceVarejo.nextFocus();
            jtBonus.selectAll();
        } 
    }//GEN-LAST:event_jtPriceVarejoKeyPressed

    private void jtPriceAtacaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtPriceAtacaKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
           jtPriceAtaca.setText(jtPriceAtaca.getText().replace(",", "."));
           
            jtPriceAtaca.setNextFocusableComponent(jtEstoqMax);
            jtPriceAtaca.nextFocus();
            jtEstoqMax.selectAll();
        } 
    }//GEN-LAST:event_jtPriceAtacaKeyPressed

    private void jtBonusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtBonusKeyPressed
       if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            Double priceVarejo = Double.valueOf(jtPriceVarejo.getText());
           jtBonus.setText(""+Math.round((priceVarejo*180)/100));
           
           if(priceVarejo<100 && priceVarejo>0) jtValorBonus.setText(String.format("%.2f",priceVarejo*0.04));
           else if(priceVarejo>100 && priceVarejo<200) jtValorBonus.setText(String.format("%.2f",priceVarejo*0.03));
           else if(priceVarejo>=200) jtValorBonus.setText(String.format("%.2f",priceVarejo*0.02));
 
            jtBonus.setNextFocusableComponent(jtValorBonus);
            jtBonus.nextFocus();
            jtValorBonus.selectAll();
        } 
    }//GEN-LAST:event_jtBonusKeyPressed

    private void jtValorBonusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtValorBonusKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
           jtValorBonus.setText(jtValorBonus.getText().replace(",", "."));
           
            jtValorBonus.setNextFocusableComponent(jtPriceAtaca);
            jtValorBonus.nextFocus();
            jtPriceAtaca.selectAll();
        } 
    }//GEN-LAST:event_jtValorBonusKeyPressed

    private void jtLucroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtLucroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtLucroActionPerformed

    private void jtLucroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtLucroKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
           jtLucro.setText(jtLucro.getText().replace(",", "."));
            
            double priceFrabric = Double.valueOf(jtPriceFrabric.getText()),
                   lucro = Double.valueOf(jtLucro.getText())/100;
            jtPriceVarejo.setText(String.format("%.2f",(priceFrabric+(priceFrabric*lucro))));
            jtLucro.setNextFocusableComponent(jtPriceVarejo);
            jtLucro.nextFocus();
            jtPriceVarejo.selectAll();
            
        } 
    }//GEN-LAST:event_jtLucroKeyPressed

    private void jtEstoqMinKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtEstoqMinKeyPressed
       if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            jtEstoqMin.setNextFocusableComponent(jtEstoqAtual);
            jtEstoqMin.nextFocus();
            jtEstoqAtual.selectAll();
        }
    }//GEN-LAST:event_jtEstoqMinKeyPressed

    private void jtEstoqMaxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtEstoqMaxKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            jtEstoqMax.setNextFocusableComponent(jtEstoqMin);
            jtEstoqMax.nextFocus();
            jtEstoqMin.selectAll();
        }
    }//GEN-LAST:event_jtEstoqMaxKeyPressed

    private void jtEstoqAtualKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtEstoqAtualKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            jtEstoqAtual.setNextFocusableComponent(jtaDescri);
            jtEstoqAtual.nextFocus();
            jtaDescri.selectAll();
        }
    }//GEN-LAST:event_jtEstoqAtualKeyPressed

    private void jtImpIPIKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtImpIPIKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            jtImpIPI.setNextFocusableComponent(jtImpCEST);
            jtImpIPI.nextFocus();
            jtImpCEST.selectAll();
        }
    }//GEN-LAST:event_jtImpIPIKeyPressed

    private void jtImpCESTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtImpCESTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtImpCESTActionPerformed

    private void jtImpCESTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtImpCESTKeyPressed
       if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            jtImpCEST.setNextFocusableComponent(jtImpICMS);
            jtImpCEST.nextFocus();
            jtImpICMS.selectAll();
        }
    }//GEN-LAST:event_jtImpCESTKeyPressed

    private void jtImpICMSKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtImpICMSKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            jtImpICMS.setNextFocusableComponent(jtImpNCM);
            jtImpICMS.nextFocus();
            jtImpNCM.selectAll();
        }
    }//GEN-LAST:event_jtImpICMSKeyPressed

    private void jtImpNCMKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtImpNCMKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            jtImpNCM.setNextFocusableComponent(jtaDescri);
            jtImpNCM.nextFocus();
            jtaDescri.selectAll();
        }
    }//GEN-LAST:event_jtImpNCMKeyPressed

    private void jftDataFabricKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jftDataFabricKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            jftDataFabric.setNextFocusableComponent(jftValidade);
            jftDataFabric.nextFocus();
            jftValidade.selectAll();
        }
    }//GEN-LAST:event_jftDataFabricKeyPressed

    private void jftValidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jftValidadeKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
           
            if(jbCadPro.isEnabled()){ System.out.println("click cadastro");
                jbCadPro.doClick();
            }
            else{jbEditPro.doClick();}
        }
    }//GEN-LAST:event_jftValidadeKeyPressed

        private void evtBotao_ActionPerformed(ActionEvent e){
            System.out.println("Botão Clicado "+e.paramString());
        }

    private void jftValidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jftValidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jftValidadeActionPerformed

    private void jtaDescriKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtaDescriKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            jtaDescri.setNextFocusableComponent(jtImpIPI);
            jtaDescri.nextFocus();
            jtImpIPI.selectAll();
        }
    }//GEN-LAST:event_jtaDescriKeyPressed

    private void jcCategoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcCategoKeyPressed
       if(evt.getKeyCode()==KeyEvent.VK_ENTER){
           jtCatego.setText(jcCatego.getItemAt(jcCatego.getSelectedIndex()));
        }
    }//GEN-LAST:event_jcCategoKeyPressed

    private void jcForneceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcForneceKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
           jtFornece.setText(jcFornece.getItemAt(jcFornece.getSelectedIndex()));
        }
    }//GEN-LAST:event_jcForneceKeyPressed

    private void jcUnidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcUnidKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
           jtUnid.setText(jcUnid.getItemAt(jcUnid.getSelectedIndex()));
        }
    }//GEN-LAST:event_jcUnidKeyPressed

    private void jcMarcaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcMarcaKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
           jtMarca.setText(jcMarca.getItemAt(jcMarca.getSelectedIndex()));
        }
    }//GEN-LAST:event_jcMarcaKeyPressed

    private void cadastrarPro(){
        ProdutoCtrl objProduto = new ProdutoCtrl();
        ProdutoDao objProDao = new ProdutoDao();
        CategoriaDao cateDao = new CategoriaDao();
        FornecedorDao forneDao = new FornecedorDao();
        UnidadeDao undDao = new UnidadeDao();
        MarcaDao marcaDao = new MarcaDao();
        
        int cod_pro = -1;
        
        //DADOS PRODUTO
        objProduto.setID(0);
        objProduto.setCod_barras(jtCodBarras.getText());
        objProduto.setNome(jtNome.getText());
        objProduto.setCod_categoria(cateDao.selecionarCategoCod(jtCatego.getText()));
        objProduto.setCod_fornecedor(forneDao.selectCodForneceID(jtFornece.getText()));
        objProduto.setCod_und_med(undDao.selecionarUnidadeMedCod(jtUnid.getText()));
        objProduto.setCod_marca(marcaDao.selectCodMarca(jtMarca.getText()));
        objProduto.setPeso(Integer.parseInt(jtPeso.getText()));
        
        //PREÇO
        String priceFabric = jtPriceFrabric.getText(),
               priceVarejo = jtPriceVarejo.getText(),
               priceAtacado = jtPriceAtaca.getText(),
               lucroMarkup  = jtLucro.getText(),
               valorBonus = jtValorBonus.getText();
               
               priceFabric = priceFabric.replace(",", ".");
               priceVarejo = priceVarejo.replace(",", ".");
               priceAtacado = priceAtacado.replace(",", ".");
               lucroMarkup = lucroMarkup.replace(",", ".");
               valorBonus = valorBonus.replace(",", ".");
        
        objProduto.setCusto_fabrica(Double.valueOf(priceFabric));
        objProduto.setPreco_varejo(Double.valueOf(priceVarejo));
        objProduto.setPreco_atacado(Double.valueOf(priceAtacado));
        objProduto.setMarkup_lucro(Double.valueOf(lucroMarkup));
        objProduto.setPontos_bonus(Integer.parseInt(jtBonus.getText()));
        objProduto.setValor_bonus(Double.valueOf(valorBonus));
        
        //ESTOQUE
        objProduto.setEstoq_max(Integer.parseInt(jtEstoqMax.getText()));
        objProduto.setEstoq_min(Integer.parseInt(jtEstoqMin.getText()));
        objProduto.setEstoq_atual(Integer.parseInt(jtEstoqAtual.getText()));
        
        //DADOS FISCAIS
          String    impIPI = jtImpIPI.getText(),
                    impCEST = jtImpCEST.getText(),
                    impICMS = jtImpICMS.getText(),
                    impNCM  = jtImpNCM.getText();

                    impIPI = impIPI.replace(",", ".");
                    impCEST = impCEST.replace(",", ".");
                    impICMS = impICMS.replace(",", ".");
                    impNCM = impNCM.replace(",", ".");
               
        objProduto.setIpi_impost(Double.valueOf(impIPI));
        objProduto.setCest_impost(Double.valueOf(impCEST));
        objProduto.setIcms_impost(Double.valueOf(impICMS));
        objProduto.setNcm_impost(Double.valueOf(impNCM));
        
        //IMAGENS
        objProduto.setImg1(null);
        objProduto.setImg2(null);
        
        //DESCRIÇÃO
        objProduto.setDescri(jtaDescri.getText());
        
        //DATAS PRODUTO
        objProduto.setData_fabrica(jftDataFabric.getText().substring(6,10)+"/"+
                                    jftDataFabric.getText().substring(3,5)+"/"+
                                    jftDataFabric.getText().substring(0,2));
        objProduto.setValidade(jftValidade.getText().substring(6,10)+"/"+
                                jftValidade.getText().substring(3,5)+"/"+
                                jftValidade.getText().substring(0,2));
        
        //STATUS
        objProduto.setCod_status(1);
        
        if(jtCodBarras.getText().equals("") || jtNome.getText().equals("") || 
            jtPriceFrabric.getText().equals("") )
        {   jlMenssager.setText("Preencha todos os Dados do Produto"); 
        }else if(objProDao.verificarPro(jtCodBarras.getText())){
            jlMenssager.setText("Produto já cadastrado"); 
            jtCodBarras.setFocusable(true);
            jtCodBarras.selectAll();
        }else{    
            OperationsEstoque opEst = new OperationsEstoque();
            opEst.setVisible(true);
            opEst.codPro = Integer.parseInt(jtCodBarras.getText());
            opEst.qtd = Integer.parseInt(jtCodBarras.getText());
            opEst.codOpera = 1;
            opEst.forneceCtrl.setID(forneDao.selectCodForneceID(jtFornece.getText()));
            opEst.codUser = SisPrinc.userlogin.getId();
            
            //dar pause no processo dessa tela para esperar resposta do Operations Estoque
            while(!okOperation){}
            if(okOperation){
                objProDao.inserir(objProduto);
                jlMenssager.setText("Produto cadastrado com Sucesso!!!"); 

                try {
                    SisPrinc.class.newInstance().clickBtnPro();
                } catch (InstantiationException ex) {
                    Logger.getLogger(GerirPro.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(GerirPro.class.getName()).log(Level.SEVERE, null, ex);
                }

                 setVisible(false);

            }JOptionPane.showMessageDialog(null,"Produto NãO cadastrado!!!"); 
            
        }

    }
  
    private void editarPro(){
        
        ProdutoCtrl objProduto = new ProdutoCtrl();
        ProdutoDao objProDao = new ProdutoDao();
        CategoriaDao cateDao = new CategoriaDao();
        FornecedorDao forneDao = new FornecedorDao();
        UnidadeDao undDao = new UnidadeDao();
        MarcaDao marcaDao = new MarcaDao();
            
        System.out.println("consulta cod_Pro gereir produtos = "+SisPrinc.codPro);
        
        if(jbEditPro.getText().equals("SALVAR")){
            jbEditPro.setText("EDITAR");
            
            int cod_pro = -1;
        
            //DADOS PRODUTO
            objProduto.setID(SisPrinc.codPro);
            objProduto.setCod_barras(jtCodBarras.getText());
            objProduto.setNome(jtNome.getText());
            objProduto.setCod_categoria(cateDao.selecionarCategoCod(jtCatego.getText()));
            objProduto.setCod_fornecedor(forneDao.selectCodForneceID(jtFornece.getText()));
            objProduto.setCod_und_med(undDao.selecionarUnidadeMedCod(jtUnid.getText()));
            objProduto.setCod_marca(marcaDao.selectCodMarca(jtMarca.getText()));
            objProduto.setPeso(Integer.parseInt(jtPeso.getText()));

            //PREÇO
            String priceFabric = jtPriceFrabric.getText(),
                   priceVarejo = jtPriceVarejo.getText(),
                   priceAtacado = jtPriceAtaca.getText(),
                   lucroMarkup  = jtLucro.getText(),
                   valorBonus = jtValorBonus.getText();

                   priceFabric = priceFabric.replace(",", ".");
                   priceVarejo = priceVarejo.replace(",", ".");
                   priceAtacado = priceAtacado.replace(",", ".");
                   lucroMarkup = lucroMarkup.replace(",", ".");
                   valorBonus = valorBonus.replace(",", ".");

            objProduto.setCusto_fabrica(Double.valueOf(priceFabric));
            objProduto.setPreco_varejo(Double.valueOf(priceVarejo));
            objProduto.setPreco_atacado(Double.valueOf(priceAtacado));
            objProduto.setMarkup_lucro(Double.valueOf(lucroMarkup));
            objProduto.setPontos_bonus(Integer.parseInt(jtBonus.getText()));
            objProduto.setValor_bonus(Double.valueOf(valorBonus));

            //ESTOQUE
            objProduto.setEstoq_max(Integer.parseInt(jtEstoqMax.getText()));
            objProduto.setEstoq_min(Integer.parseInt(jtEstoqMin.getText()));
            objProduto.setEstoq_atual(Integer.parseInt(jtEstoqAtual.getText()));

            //DADOS FISCAIS
              String    impIPI = jtImpIPI.getText(),
                        impCEST = jtImpCEST.getText(),
                        impICMS = jtImpICMS.getText(),
                        impNCM  = jtImpNCM.getText();

                        impIPI = impIPI.replace(",", ".");
                        impCEST = impCEST.replace(",", ".");
                        impICMS = impICMS.replace(",", ".");
                        impNCM = impNCM.replace(",", ".");

            objProduto.setIpi_impost(Double.valueOf(impIPI));
            objProduto.setCest_impost(Double.valueOf(impCEST));
            objProduto.setIcms_impost(Double.valueOf(impICMS));
            objProduto.setNcm_impost(Double.valueOf(impNCM));

            //IMAGENS
            objProduto.setImg1(null);
            objProduto.setImg2(null);

            //DESCRIÇÃO
            objProduto.setDescri(jtaDescri.getText());

            //DATAS PRODUTO
            objProduto.setData_fabrica(jftDataFabric.getText().substring(6,10)+"/"+
                                        jftDataFabric.getText().substring(3,5)+"/"+
                                        jftDataFabric.getText().substring(0,2));
            objProduto.setValidade(jftValidade.getText().substring(6,10)+"/"+
                                    jftValidade.getText().substring(3,5)+"/"+
                                    jftValidade.getText().substring(0,2));
            //STATUS
            objProduto.setCod_status(1);
            
            
            
            if(jtCodBarras.getText().equals("") || jtNome.getText().equals("") || 
                jtPriceFrabric.getText().equals("") )
            {   jlMenssager.setText("Preencha todos os Dados do Produto"); 
            }else{   
                   
                OperationsEstoque opEst = new OperationsEstoque();
                opEst.setVisible(true);
                opEst.codPro =  Integer.parseInt(objProduto.getCod_barras());
                opEst.qtd = objProduto.getEstoq_atual();
                opEst.codOpera = 6;
                opEst.forneceCtrl.setID(forneDao.selectCodForneceID(jtFornece.getText()));
                opEst.codUser = SisPrinc.userlogin.getId();
                while(!okOperation){}
                if(okOperation){
                    objProDao.alterar(objProduto);   
                    jlMenssager.setText("Produto Editado com Sucesso!!!"); 
                    setVisible(false);
                }else jlMenssager.setText("Produto NÂO Editado!!!"); 
            }

            }else{
            //Formulário de Cadastro de Produtos
                //DADOS DO PRODUTO
                jtCodBarras.setEditable(true);
                jtNome.setEditable(true);
                jtCatego.setEditable(true);
                jtFornece.setEditable(true);
                jtUnid.setEditable(true);
                jtMarca.setEditable(true);
                jtPeso.setEditable(true);
                jcCatego.setEnabled(true);
                jcFornece.setEnabled(true);
                jcUnid.setEnabled(true);
                jcMarca.setEnabled(true);
                
                //PREÇO PRODUTO
                jtPriceFrabric.setEditable(true);
                jtPriceVarejo.setEditable(true);
                jtPriceAtaca.setEditable(true);
                jtLucro.setEditable(true);
                jtValorBonus.setEditable(true);        
                jtBonus.setEditable(true);
                
                //ESTOQUE
                jtEstoqMax.setEditable(true);
                jtEstoqMin.setEditable(true);
                jtEstoqAtual.setEditable(true);
                        
                //DADOS FISCAIS
                jtImpIPI.setEditable(true);
                jtImpCEST.setEditable(true);
                jtImpICMS.setEditable(true);
                jtImpNCM.setEditable(true);
                        
                //IMAGENS
                jlImg1.setEnabled(true);
                jlImg2.setEnabled(true);
                        
                //DESCRIÇÃO
                jtaDescri.setEditable(true);
                        
                //DATAS PRODUTO
                jftDataFabric.setEditable(true);
                jftValidade.setEditable(true);

                jbCadPro.setEnabled(false);
                jbEditPro.setText("SALVAR");

                
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbCadPro;
    private javax.swing.JButton jbCancel;
    private javax.swing.JButton jbEditPro;
    private javax.swing.JComboBox<String> jcCatego;
    private javax.swing.JComboBox<String> jcFornece;
    private javax.swing.JComboBox<String> jcMarca;
    private javax.swing.JComboBox<String> jcUnid;
    private javax.swing.JFormattedTextField jftDataFabric;
    private javax.swing.JFormattedTextField jftValidade;
    private javax.swing.JLabel jlImg1;
    private javax.swing.JLabel jlImg2;
    private javax.swing.JLabel jlMenssager;
    private javax.swing.JTextField jtBonus;
    private javax.swing.JTextField jtCatego;
    private javax.swing.JTextField jtCodBarras;
    private javax.swing.JTextField jtEstoqAtual;
    private javax.swing.JTextField jtEstoqMax;
    private javax.swing.JTextField jtEstoqMin;
    private javax.swing.JTextField jtFornece;
    private javax.swing.JTextField jtImpCEST;
    private javax.swing.JTextField jtImpICMS;
    private javax.swing.JTextField jtImpIPI;
    private javax.swing.JTextField jtImpNCM;
    private javax.swing.JTextField jtLucro;
    private javax.swing.JTextField jtMarca;
    private javax.swing.JTextField jtNome;
    private javax.swing.JTextField jtNome12;
    private javax.swing.JTextField jtNome21;
    private javax.swing.JTextField jtNome22;
    private javax.swing.JTextField jtPeso;
    private javax.swing.JTextField jtPriceAtaca;
    private javax.swing.JTextField jtPriceFrabric;
    private javax.swing.JTextField jtPriceVarejo;
    private javax.swing.JTextField jtUnid;
    private javax.swing.JTextField jtValorBonus;
    private javax.swing.JTextArea jtaDescri;
    // End of variables declaration//GEN-END:variables
}

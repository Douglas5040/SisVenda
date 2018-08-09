/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import banco.BancoMySql;
import ctrl.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Adm
 */
public class ProdutoDao {
    
    public void inserir(ProdutoCtrl obj){
        BancoMySql objBanco = new BancoMySql();

        int ID = obj.getID();
        int cod_barras = obj.getCod_barras();
        String nome = obj.getNome();
        int estoq_min = obj.getEstoq_min();
        int estoq_max = obj.getEstoq_max();
        int estoq_atual = obj.getEstoq_atual();
        String descri = obj.getDescri();
        double custo_fabrica = obj.getCusto_fabrica();
        double preco_varejo = obj.getPreco_varejo();
        double preco_atacado = obj.getPreco_atacado();
        int peso = obj.getPeso();
        int pontos_bonus = obj.getPontos_bonus();
        double valor_bonus = obj.getValor_bonus();
        double markup_lucro = obj.getMarkup_lucro();
        double ipi_impost = obj.getIpi_impost();
        double cest_impost = obj.getCest_impost();
        double icms_impost = obj.getIcms_impost();
        double ncm_impost = obj.getNcm_impost();
        int cod_fornecedor = obj.getCod_fornecedor();
        int cod_categoria = obj.getCod_categoria();
        int cod_und_med = obj.getCod_und_med();
        int cod_marca = obj.getCod_marca();
        int cod_status = obj.getCod_status();
        String data_fabrica = obj.getData_fabrica();
        String validade = obj.getValidade();
        
        
       
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "INSERT INTO produtos VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement ppStm = con.prepareStatement(queryInserir);
			
                        ppStm.setString(1, String.valueOf(ID));
			ppStm.setString(2, String.valueOf(cod_barras));
			ppStm.setString(3, nome);
                        ppStm.setString(4, String.valueOf(estoq_min));
                        ppStm.setString(5, String.valueOf(estoq_max));
			ppStm.setString(6, String.valueOf(estoq_atual));
                        ppStm.setString(7, descri);
                        ppStm.setString(8, String.valueOf(custo_fabrica));
                        ppStm.setString(9, String.valueOf(preco_varejo));
                        ppStm.setString(10, String.valueOf(preco_atacado));
                        ppStm.setString(11, String.valueOf(peso));
                        ppStm.setString(12, String.valueOf(pontos_bonus));
                        ppStm.setString(13, String.valueOf(valor_bonus));
                        ppStm.setString(14, String.valueOf(markup_lucro));
                        ppStm.setString(15, String.valueOf(ipi_impost));
                        ppStm.setString(16, String.valueOf(cest_impost));
                        ppStm.setString(17, String.valueOf(icms_impost));
                        ppStm.setString(18, String.valueOf(ncm_impost));
                        ppStm.setString(19, String.valueOf(cod_fornecedor));
                        ppStm.setString(20, String.valueOf(cod_categoria));
                        ppStm.setString(21, String.valueOf(cod_und_med));
                        ppStm.setString(22, String.valueOf(cod_marca));
                        ppStm.setString(23, String.valueOf(cod_status));
                        ppStm.setString(24, data_fabrica);
                        ppStm.setString(25, validade);
                        ppStm.execute();
                        
                        //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do inserir PRODUTO, "+ex);
                        
        }
    }
    
    public void alterar(ProdutoCtrl obj){
        BancoMySql objBanco = new BancoMySql();
         
        int ID = obj.getID();
        int cod_barras = obj.getCod_barras();
        String nome = obj.getNome();
        int estoq_min = obj.getEstoq_min();
        int estoq_max = obj.getEstoq_max();
        int estoq_atual = obj.getEstoq_atual();
        String descri = obj.getDescri();
        double custo_fabrica = obj.getCusto_fabrica();
        double preco_varejo = obj.getPreco_varejo();
        double preco_atacado = obj.getPreco_atacado();
        int peso = obj.getPeso();
        int pontos_bonus = obj.getPontos_bonus();
        double valor_bonus = obj.getValor_bonus();
        double markup_lucro = obj.getMarkup_lucro();
        double ipi_impost = obj.getIpi_impost();
        double cest_impost = obj.getCest_impost();
        double icms_impost = obj.getIcms_impost();
        double ncm_impost = obj.getNcm_impost();
        int cod_fornecedor = obj.getCod_fornecedor();
        int cod_categoria = obj.getCod_categoria();
        int cod_und_med = obj.getCod_und_med();
        int cod_marca = obj.getCod_marca();
        int cod_status = obj.getCod_status();
        String data_fabrica = obj.getData_fabrica();
        String validade = obj.getValidade();
        
       
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryAlterar = "UPDATE produtos SET COD_BARRAS=?, "
                                                    + "NOME=?, "
                                                    + "ESTOQ_MIN=?, "
                                                    + "ESTOQ_MAX=?, "
                                                    + "ESTOQ_ATUAL=?, "
                                                    + "DESCRI=?, "
                                                    + "CUSTO_FABRICA=?, "
                                                    + "PRECO_VAREJO=?, "
                                                    + "PRECO_ATACADO=?, "
                                                    + "PESO=?, "
                                                    + "PONTOS_BONUS=?, "
                                                    + "VALOR_BONUS=?, "
                                                    + "MARKUP_LUCRO=?, "
                                                    + "IPI_IMPOSTO=?, "
                                                    + "CEST_IMPOSTO=?, "
                                                    + "ICMS_IMPOSTO=?, "
                                                    + "NCM_IMPOSTO=?, "
                                                    + "COD_FORNECEDOR=?, "
                                                    + "COD_CATEGORIA=?, "
                                                    + "COD_UNIDADE_MED=?, "
                                                    + "COD_MARCA=?, "
                                                    + "COD_STATUS_PRO=?, "
                                                    + "DATA_FABRICA=?, "
                                                    + "VALIDADE=? "
                                 + "WHERE ID=? OR COD_BARRAS=?";
			
			PreparedStatement ppStm = con.prepareStatement(queryAlterar);
			
			ppStm.setString(1, String.valueOf(cod_barras));
			ppStm.setString(2, nome);
                        ppStm.setString(3, String.valueOf(estoq_min));
                        ppStm.setString(4, String.valueOf(estoq_max));
			ppStm.setString(5, String.valueOf(estoq_atual));
                        ppStm.setString(6, descri);
                        ppStm.setString(7, String.valueOf(custo_fabrica));
                        ppStm.setString(8, String.valueOf(preco_varejo));
                        ppStm.setString(9, String.valueOf(preco_atacado));
                        ppStm.setString(10, String.valueOf(peso));
                        ppStm.setString(11, String.valueOf(pontos_bonus));
                        ppStm.setString(12, String.valueOf(valor_bonus));
                        ppStm.setString(13, String.valueOf(markup_lucro));
                        ppStm.setString(14, String.valueOf(ipi_impost));
                        ppStm.setString(15, String.valueOf(cest_impost));
                        ppStm.setString(16, String.valueOf(icms_impost));
                        ppStm.setString(17, String.valueOf(ncm_impost));
                        ppStm.setString(18, String.valueOf(cod_fornecedor));
                        ppStm.setString(19, String.valueOf(cod_categoria));
                        ppStm.setString(20, String.valueOf(cod_und_med));
                        ppStm.setString(21, String.valueOf(cod_marca));
                        ppStm.setString(22, String.valueOf(cod_status));
                        ppStm.setString(23, data_fabrica);
                        ppStm.setString(24, validade);
                        ppStm.setString(25, String.valueOf(ID));
			ppStm.setString(26, String.valueOf(cod_barras));
                        ppStm.execute();
                        
                        //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do alterar, "+ex);
                        
        }
    }
    
    public boolean alterarQtdPro(int qtd, String parametro){
        BancoMySql objBanco = new BancoMySql();
              
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "UPDATE produtos SET ESTOQ_ATUAL=? "
                                 + "WHERE NOME=? OR COD_BARRAS=? OR ID=?";
			
			PreparedStatement ppStm = con.prepareStatement(queryInserir);
			
			ppStm.setString(1, String.valueOf(qtd));
			ppStm.setString(2, parametro);
                        ppStm.setString(3, String.valueOf(parametro));
                        ppStm.setString(4, String.valueOf(parametro));
                        ppStm.execute();
                        
                        return true;
                        
                        //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução SQL do alterar quantidade produto");
                        
        
            return false;
    }
    }

    
    public void deletar(int cod, String nome){
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "DELETE from produtos WHERE NOME=? OR ID=? OR COD_BARRAS=?";
		
            PreparedStatement ppStm = con.prepareStatement(queryInserir);
            ppStm.setString(1, nome);
            ppStm.setString(2, String.valueOf(cod));
            ppStm.setString(3, String.valueOf(cod));
            ppStm.execute();
                        
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do deletar Produto");
        }
    }
    
    public ResultSet selecionar(){
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "select * from produtos";
			
            PreparedStatement ppStm = con.prepareStatement(queryInserir);
			
            ResultSet objRst = ppStm.executeQuery();
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            
            return objRst;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar");
        }
        return null;
    }

    public ResultSet selecionarPro(String consultPro) {
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "select * from produtos WHERE NOME LIKE ? OR ID = ? OR COD_BARRAS = ?";
			
            PreparedStatement ppStm = con.prepareStatement(queryInserir);
            ppStm.setString(1, consultPro+"%");
            ppStm.setString(2, consultPro);
            ppStm.setString(3, consultPro);
            
            ResultSet objRst = ppStm.executeQuery();
            
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            
            return objRst;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar Produto, "+ex);
        }
        return null;
    }

    public int selecionarID(String consultPro) {
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "select ID from produtos WHERE NOME LIKE ? OR COD_BARRAS = ?";
			
            PreparedStatement ppStm = con.prepareStatement(queryInserir);
            ppStm.setString(1, consultPro+"%");
            ppStm.setString(2, consultPro);
            
            ResultSet objRst = ppStm.executeQuery();
            
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            objRst.first();
            return objRst.getInt("ID");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar Produto, "+ex);
        }
        return -1;
    }
    public boolean verificarPro(String consultPro) {
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "select * from produtos WHERE ID = ? OR COD_BARRAS = ?";
			
            PreparedStatement ppStm = con.prepareStatement(queryInserir);
            ppStm.setString(1, consultPro);
            ppStm.setString(2, consultPro);
            
            ResultSet objRst = ppStm.executeQuery();
            
            return objRst.first();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar Produto: "+ex);
        }
        return false;
    }
    
    public ResultSet verificarProduto(String consultPro) {
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "select * from produtos WHERE COD_BARRAS = ? OR NOME LIKE ? OR ID = ?";
			
            PreparedStatement ppStm = con.prepareStatement(queryInserir);
            ppStm.setString(1, consultPro);
            ppStm.setString(2, consultPro);
            ppStm.setString(3, consultPro);
            
            ResultSet objRst = ppStm.executeQuery();
            objRst.first();
            return objRst;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar Produto");
        }
        return null;
    }
    
    public int selecionarSituationPro(String pro) {
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "select * from produtos WHERE cod = ?";
			
            PreparedStatement ppStm = con.prepareStatement(queryInserir);
            ppStm.setString(1, pro);
            
            ResultSet objRst = ppStm.executeQuery();
            
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            objRst.first();
            return objRst.getInt("ESTOQ_MAX");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar situação produto: "+ex);
        }
        return -1;
    }
    
    public String valorPro(String consultPro) {
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "select valor from produtos WHERE NOME = ? OR ID=? OR COD_BARRAS=?";
			
            PreparedStatement ppStm = con.prepareStatement(queryInserir);
            ppStm.setString(1, consultPro+"%");
            ppStm.setString(2, consultPro);
            ppStm.setString(3, consultPro);
            
            ResultSet objRst = ppStm.executeQuery();
            while(objRst.next()){
                return objRst.getString("valor");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar Valor Produto");
        }
        return "erro";
    }
    
    public int qtdPro(String consultPro) {
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "select ESTOQ_ATUAL from produtos WHERE COD_BARRAS = ? OR ID = ?";
			
            PreparedStatement ppStm = con.prepareStatement(queryInserir);
            ppStm.setString(1, consultPro);
            ppStm.setString(2, consultPro);
            
            ResultSet objRst = ppStm.executeQuery();
            objRst.first();
            return objRst.getInt("ESTOQ_ATUAL");
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar quantidade Produto");
        }
        return -1;
    }
}

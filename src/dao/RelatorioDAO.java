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
public class RelatorioDAO {
    
    
    public ResultSet consultEstoq(int op, String verifiVali){
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            String queryInserir;
            switch (op) {          
                case 0:
                    queryInserir = "select cod,nomePro,qtd,qtdTotal,valor,descri,"+
                            "date_format(validade,'%d/%c/%Y') as 'validade' from produtos "
                            + "WHERE validade <= '"+verifiVali+"'";
                    break;
                case 1:
                    queryInserir = "select cod,nomePro,qtd,qtdTotal,valor,descri,"+
                            "date_format(validade,'%d/%c/%Y') as 'validade' from produtos "
                            + "WHERE qtd <= qtdTotal*0.5";
                    break;
                case 2:
                    queryInserir = "select cod,nomePro,qtd,qtdTotal,valor,descri,"+
                            "date_format(validade,'%d/%c/%Y') as 'validade' from produtos "
                            + "WHERE qtd <= qtdTotal*0.5 AND validade <= '"+verifiVali+"'";
                    break;
                default:
                    queryInserir = "select cod,nomePro,qtd,qtdTotal,valor,descri,"+
                            "date_format(validade,'%d/%c/%Y') as 'validade' from produtos ";
                    break;
            }
            
            PreparedStatement ppStm = con.prepareStatement(queryInserir);
            
            ResultSet objRst = ppStm.executeQuery();
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            
            return objRst;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do consultEstoq BD: "+ex);
        }
        return null;
    }

    public ResultSet consultVendaSimples(String dataINI,String dataFIM){
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
                String queryInserir = "SELECT dataCompra,valorTotal,horaCompra,nomeCli,situation "
                        + "FROM compras,clientes where codCli=id AND (dataCompra>='"+dataINI+"' AND dataCompra<='"+dataFIM+"') "
                        + "ORDER BY compras.dataCompra ASC";

            PreparedStatement ppStm = con.prepareStatement(queryInserir);
			
            ResultSet objRst = ppStm.executeQuery();
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            //JOptionPane.showMessageDialog(null,"BD:"+objRst);
            return objRst;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do consultar vendas Simples BANCO"+ex);
        }
        return null;
    }
    
    public ResultSet consultVendaDetalhado(String dataINI,String dataFIM){
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
                String queryInserir = "SELECT dataCompra,horaCompra,codigo,nomePro,qtdComprada,valorPago,situation,nomeCli "
                                    + "FROM compras,clientes,produtos,vendas "
                                    + "WHERE codCli=id AND (dataCompra>='"+dataINI+"' AND dataCompra<='"+dataFIM+"') "
                                    + "AND cod=codPro AND codigo = codCompra ORDER BY `compras`.`horaCompra` ASC";

            PreparedStatement ppStm = con.prepareStatement(queryInserir);
			
            ResultSet objRst = ppStm.executeQuery();
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            
            return objRst;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do consultar vendas "+ex);
        }
        return null;
    }
    
    public ResultSet consultRelVenda(String data,String nomeCli,String cod){
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
                String queryInserir = "SELECT dataCompra,horaCompra,codigo,nomePro,qtdComprada,valorPago,situation,nomeCli "
                                    + "FROM compras,clientes,produtos,vendas "
                                    + "WHERE codCli=id AND (dataCompra='"+data+"' OR nomeCli='"+nomeCli+"' OR nomeCli='"+cod+"') "
                                    + "AND cod=codPro AND codigo = codCompra ORDER BY `compras`.`horaCompra` ASC";

            PreparedStatement ppStm = con.prepareStatement(queryInserir);
			
            ResultSet objRst = ppStm.executeQuery();
            
            return objRst;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do consultar vendas "+ex);
        }
        return null;
    }
    
    public ResultSet consultVendaCLi(String dataINI, int id){
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
                String queryInserir = "SELECT dataCompra,horaCompra,codigo,valorTotal "
                        + "FROM compras where codCli="+id+" AND dataCompra>='"+dataINI+"' AND situation = 'NA CONTA'"
                        + "ORDER BY compras.dataCompra ASC";

            PreparedStatement ppStm = con.prepareStatement(queryInserir);
			
            ResultSet objRst = ppStm.executeQuery();
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            //JOptionPane.showMessageDialog(null,"BD:"+objRst);
            return objRst;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do consultar vendas Simples BANCO"+ex);
        }
        return null;
    }
}

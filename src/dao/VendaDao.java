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
public class VendaDao {
    public void inserir(VendaCtrl obj){
        BancoMySql objBanco = new BancoMySql();
         
        int codPro = obj.getCodPro();
        int qtd = obj.getQtd();
        Double valorUnit = obj.getValorUnit();
        Double descont = obj.getDescont();
        Double valorPago = obj.getValorPago();
        int idCli = obj.getIdCli();
        int codCompra = obj.getCodCompra();
       
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "INSERT INTO vendas VALUES(0,?,?,?,?,?,?,?)";
			
			PreparedStatement ppStm = con.prepareStatement(queryInserir);
			
			ppStm.setString(1, String.valueOf(codPro));
			ppStm.setString(2, String.valueOf(qtd));
                        ppStm.setString(3, String.valueOf(valorUnit));
                        ppStm.setString(4, String.valueOf(descont));
                        ppStm.setString(5, String.valueOf(valorPago));
                        ppStm.setString(6, String.valueOf(idCli));
                        ppStm.setString(7, String.valueOf(codCompra));
                        ppStm.execute(); ppStm.close();
                        
                        //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução DO INSERIR VENDA");
                        
        }
    }
    
     public ResultSet selecionar(){
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "select * from vendas";
			
            PreparedStatement ppStm = con.prepareStatement(queryInserir);
			
            ResultSet objRst = ppStm.executeQuery();
           // JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            
            return objRst;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar");
        }
        return null;
    }
     
     public void deletar(String codPro, String codComp){
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "DELETE from vendas WHERE codPro=? AND codCompra=?";
		
            PreparedStatement ppStm = con.prepareStatement(queryInserir);
            ppStm.setString(1, codPro);
            ppStm.setString(2, codComp);
            ppStm.execute(); ppStm.close();
                        
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do deletar Produto DA VENDA "+codPro+" "+codComp);
        }
    }

    public ResultSet selecionarVendaNaConta() {
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "select * from vendas WHERE situation LIKE 'NA CONTA'";
			
            PreparedStatement ppStm = con.prepareStatement(queryInserir);
            
            ResultSet objRst = ppStm.executeQuery();
            
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            
            return objRst;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar user");
        }
        return null;
    }

    public void alterar(VendaCtrl venda){
        BancoMySql objBanco = new BancoMySql();
            int cod = venda.getCodPro();
            int qtd = venda.getQtd();
            Double descont = venda.getDescont();
            Double valPag = venda.getValorPago();
            int codComp = venda.getCodCompra();
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "UPDATE vendas SET qtdComprada=?, descont=?, valorPago=? "
                                 + "WHERE codPro =? AND codCompra=?";
			
			PreparedStatement ppStm = con.prepareStatement(queryInserir);
			
			ppStm.setString(1, String.valueOf(qtd));
                        ppStm.setString(2, String.valueOf(descont));
                        ppStm.setString(3, String.valueOf(valPag));
                        ppStm.setString(4, String.valueOf(cod));
                        ppStm.setString(5, String.valueOf(codComp));
                        ppStm.execute(); ppStm.close();
                        
                        //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do alterar quantidade produto da venda");
                        
        }
    }
    
}

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
public class CompraDao {
    
    public void inserir(CompraCtrl obj){
        BancoMySql objBanco = new BancoMySql();
         
        int codCli = obj.getCodCli();
        Double valorTotal = obj.getValorTotal();
        String horaCompra = obj.getHoraCompra();
        String dataCompra = obj.getDataCompra();
        String situation = obj.getSituation();
       
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "INSERT INTO compras VALUES(0,?,?,?,?,?)";
			
			PreparedStatement ppStm = con.prepareStatement(queryInserir);
			
			ppStm.setString(1, String.valueOf(codCli));
                        ppStm.setString(2, String.valueOf(valorTotal));
                        ppStm.setString(3, dataCompra);
                        ppStm.setString(4, horaCompra);
                        ppStm.setString(5, situation);

                        ppStm.execute(); ppStm.close();
                        
                        //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução DO INSERIR Compras");
                        
        }
    }
    
    public void alterar(int cod, int codCli, Double valorTotal, String dataCompra, String horaCompra, String situation){
        BancoMySql objBanco = new BancoMySql();
              
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "UPDATE compras SET valorTotal=?, dataCompra=?, horaCompra=?, situation=?, codCli = ? "
                                 + "WHERE codigo=?";
			
			PreparedStatement ppStm = con.prepareStatement(queryInserir);
			
			ppStm.setString(1, String.valueOf(valorTotal));
			ppStm.setString(2, dataCompra);
                        ppStm.setString(3, horaCompra);
                        ppStm.setString(4, situation);
                        ppStm.setString(5, String.valueOf(codCli));
                        ppStm.setString(6, String.valueOf(cod));
                        ppStm.execute(); ppStm.close();
                        
                        //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução SQL do alterar Compra "+ex);
                        
        }
    }
    
     public ResultSet selecionar(){
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "select * from compras";
			
            PreparedStatement ppStm = con.prepareStatement(queryInserir);
			
            ResultSet objRst = ppStm.executeQuery();
           // JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            
            return objRst;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar todas Compras");
        }
        return null;
    }

    public ResultSet selecionarCompra(int cod, String dataOP) {
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String query = "select * from compras WHERE situation = 'NA CONTA' and codCli = ? and dataCompra >= ?";
			
            PreparedStatement ppStm = con.prepareStatement(query);
            ppStm.setString(1, String.valueOf(cod));
            ppStm.setString(2, dataOP);
            
            ResultSet objRst = ppStm.executeQuery();
            
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            
            return objRst;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar Compra");
        }
        return null;
    }
    
    public void deletar(int cod){
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "DELETE from compras WHERE codigo=?";
		
            PreparedStatement ppStm = con.prepareStatement(queryInserir);
            ppStm.setString(1, String.valueOf(cod));
            ppStm.execute(); ppStm.close();
                        
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do deletar Compra "+cod);
        }
    }
    
    public int selecionarCodComp() {
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String query = "select codigo from compras";
			
            PreparedStatement ppStm = con.prepareStatement(query);
            
            ResultSet objRst = ppStm.executeQuery();
            
            objRst.last();
           
            
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            
            return objRst.getInt("codigo");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar Compra");
        }
        return -1;
    }

}

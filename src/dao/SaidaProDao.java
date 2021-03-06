/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import ctrl.*;
import banco.BancoMySql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Adm
 */
public class SaidaProDao {
    public void inserir(SaidaProCtrl obj){
        BancoMySql objBanco = new BancoMySql();
       
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "INSERT INTO saida_pro VALUES(0,?,?,?,?,?,?,?)";
			
			PreparedStatement ppStm = con.prepareStatement(queryInserir);
			
			ppStm.setString(1, ""+obj.getCOD_PRO());
			ppStm.setString(2, ""+obj.getVALOR_PRO());
			ppStm.setString(3, ""+obj.getQTD());
			ppStm.setString(4, ""+obj.getVALOR_TOTAL());
			ppStm.setString(5, ""+obj.getDESCONT());
			ppStm.setString(6, ""+obj.getCOD_OS());
			ppStm.setString(7, ""+obj.getCOD_STATUS_SP());
                        ppStm.execute(); ppStm.close();
                        
                        //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do inserir saida pro: "+ex);
                        
        }
    }
    
    public ResultSet selecionar(){
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String querySelect = "select * from saida_pro";
			
            PreparedStatement ppStm = con.prepareStatement(querySelect);
			
            ResultSet objRst = ppStm.executeQuery();
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            
            return objRst;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar saida pro, "+ex);
        }
        return null;
    }

    public ResultSet selecionarSP(String parametro) {
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String querySelectUser = "select * from saida_pro WHERE ID = ? or COD_PRO=? or COD_OS=?";
			
            PreparedStatement ppStm = con.prepareStatement(querySelectUser);
            ppStm.setString(1, parametro);
            ppStm.setString(2, parametro);
            
            ResultSet objRst = ppStm.executeQuery();
            
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            return objRst;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar saida pro:  "+ex);
        }
        return null;
    }

   /* public ResultSet selecionarLastCodSP() {
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String querySelectUser = "select * from saida_pro WHERE ID = ? or COD_PRO=? or COD_OS=?";
			
            PreparedStatement ppStm = con.prepareStatement(querySelectUser);
            ppStm.setString(1, parametro);
            ppStm.setString(2, parametro);
            
            ResultSet objRst = ppStm.executeQuery();
            
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            return objRst;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar saida pro:  "+ex);
        }
        return null;
    }*/
    
    

    public ResultSet selecionarSPporOs(String codOs, String codPro) {
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String querySelectUser = "select * from saida_pro WHERE COD_PRO=? AND COD_OS=?";
			
            PreparedStatement ppStm = con.prepareStatement(querySelectUser);
            ppStm.setString(1, codPro);
            ppStm.setString(2, codOs);
            
            ResultSet objRst = ppStm.executeQuery();
            
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            return objRst;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar saida pro:  "+ex);
        }
        return null;
    }

    
    public void alterarSP(SaidaProCtrl obj){
        BancoMySql objBanco = new BancoMySql();
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "UPDATE saida_pro SET VALOR_PRO=?,"
                                                        + " QTD=?, "
                                                        + " VALOR_TOTAL=?,"                                                        
                                                        + " DESCONT=?,"
                                                        + " COD_STATUS_SP=? "

                                 + "WHERE COD_PRO =? or COD_OS=?";
			
			PreparedStatement ppStm = con.prepareStatement(queryInserir);

			ppStm.setString(1, ""+obj.getVALOR_PRO());
			ppStm.setString(2, ""+obj.getQTD());
			ppStm.setString(3, ""+obj.getVALOR_TOTAL());
			ppStm.setString(4, ""+obj.getDESCONT());
			ppStm.setString(5, ""+obj.getCOD_STATUS_SP());
                        ppStm.setString(6, String.valueOf(obj.getCOD_PRO()));
                        ppStm.setString(7, String.valueOf(obj.getCOD_OS()));
                        ppStm.execute(); ppStm.close();
                        
                        //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do alterar saida pro");
                        
        }
    }
    
    public void altStatusSP(int parametro, int cod_status){
        BancoMySql objBanco = new BancoMySql();
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "UPDATE ordem_service SET COD_STATUS_SP=? WHERE ID =? or COD_PRO=?";
			
			PreparedStatement ppStm = con.prepareStatement(queryInserir);
			
			ppStm.setString(1, String.valueOf(cod_status));
                        ppStm.setString(2, String.valueOf(parametro));
                        ppStm.setString(3, String.valueOf(parametro));
                        
                        //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do alterar status saida pro");
                        
        }
    }

    public void deletar(int id, int os, int status){
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "DELETE from saida_pro WHERE COD_PRO=? AND COD_OS=? AND COD_STATUS_SP=?";
		
            PreparedStatement ppStm = con.prepareStatement(queryInserir);
            ppStm.setString(1, String.valueOf(id));
            ppStm.setString(2, String.valueOf(os));
            ppStm.setString(3, String.valueOf(status));
            ppStm.execute(); ppStm.close();
                        
           // JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do deletar saida_pro, "+ex);
        }
    }
}

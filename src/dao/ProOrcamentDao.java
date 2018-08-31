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
public class ProOrcamentDao {
    public void inserir(ProOrcamentCtrl obj){
        BancoMySql objBanco = new BancoMySql();
       
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "INSERT INTO pro_orcament VALUES(0,?,?,?,?,?,?)";
			
			PreparedStatement ppStm = con.prepareStatement(queryInserir);
			
			ppStm.setString(1, ""+obj.getCod_orc());
			ppStm.setString(2, ""+obj.getCod_pro());
			ppStm.setString(3, ""+obj.getDescont());
			ppStm.setString(4, ""+obj.getQtd());
			ppStm.setString(5, ""+obj.getSub_total());
			ppStm.setString(6, ""+obj.getValor_unit());
                        ppStm.execute(); ppStm.close();
                        
                        //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do inserir pro_orcament pro: "+ex);
                        
        }
    }
    
    public ResultSet selecionar(){
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String querySelect = "select * from pro_orcament";
			
            PreparedStatement ppStm = con.prepareStatement(querySelect);
			
            ResultSet objRst = ppStm.executeQuery();
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            
            return objRst;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar pro_orcament, "+ex);
        }
        return null;
    }

    public ResultSet selectOrcament(String parametro) {
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String querySelectUser = "select * from pro_orcament WHERE ID = ? or COD_PRO=? or COD_ORC=?";
			
            PreparedStatement ppStm = con.prepareStatement(querySelectUser);
            ppStm.setString(1, parametro);
            ppStm.setString(2, parametro);
            ppStm.setString(3, parametro);
            
            ResultSet objRst = ppStm.executeQuery();
            
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            return objRst;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar saida pro:  "+ex);
        }
        return null;
    }

    public ResultSet selectProOrcPorOrc(String codOrc, String codPro) {
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String querySelectUser = "select * from pro_orcament WHERE COD_PRO=? AND COD_OS=?";
			
            PreparedStatement ppStm = con.prepareStatement(querySelectUser);
            ppStm.setString(1, codPro);
            ppStm.setString(2, codOrc);
            
            ResultSet objRst = ppStm.executeQuery();
            
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            return objRst;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar pro_orcament:  "+ex);
        }
        return null;
    }
    
    public void alterar( ProOrcamentCtrl obj){
        BancoMySql objBanco = new BancoMySql();
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "UPDATE pro_orcament SET QTD=?, "
                                                        + " SUB_TOTAL=?,"                                                        
                                                        + " DESCONT=?,"
                                                        + " VALOR_UNIT=? "

                                 + "WHERE  COD_PRO=? AND COD_ORC=?";
			
			PreparedStatement ppStm = con.prepareStatement(queryInserir);
			
			ppStm.setString(1, ""+obj.getQtd());
			ppStm.setString(2, ""+obj.getSub_total());
			ppStm.setString(3, ""+obj.getDescont());
			ppStm.setString(4, ""+obj.getValor_unit());
                        ppStm.setString(5, String.valueOf(obj.getCod_pro()));
                        ppStm.setString(6, String.valueOf(obj.getCod_orc()));
                        ppStm.execute(); ppStm.close();
                        
                        //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do alterar saida pro");
                        
        }
    }
    

    public void deletar(int cod_pro, int os){
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "DELETE from pro_orcament WHERE COD_PRO=? AND COD_ORC=?";
		
            PreparedStatement ppStm = con.prepareStatement(queryInserir);
            ppStm.setString(1, String.valueOf(cod_pro));
            ppStm.setString(2, String.valueOf(os));
            ppStm.execute(); ppStm.close();
                        
           // JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do deletar pro_orcament: "+ex);
        }
    }
}

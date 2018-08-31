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
public class OrcamentoDao {
    public void inserir(OrcamentoCtrl obj){
        BancoMySql objBanco = new BancoMySql();
       
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "INSERT INTO orcamento VALUES(0,?,?,?,?,?,?)";
			
			PreparedStatement ppStm = con.prepareStatement(queryInserir);
			
			ppStm.setString(1, obj.getData_orc());
			ppStm.setString(2, ""+obj.getCodCli());
			ppStm.setString(3, ""+obj.getCod_vendedor());
			ppStm.setString(4, ""+obj.getValor_total());
			ppStm.setString(5, ""+obj.getDescont());
			ppStm.setString(6, ""+obj.getObs());
                        ppStm.execute(); ppStm.close();
                        
                        //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do inserir Categoria: "+ex);
                        
        }
    }
    
    public boolean alterar(OrcamentoCtrl obj){
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
           String queryAlterar = "UPDATE orcamento SET DATA_ORC = ?, "
                                                    + "COD_CLI = ?, "
                                                    + "COD_VEND = ?, "
                                                    + "VALOR_TOTAL = ?, "
                                                    + "DESCONT = ?, "
                                                    + "OBS = ? "
                                 + "WHERE ID=?";
			
                    PreparedStatement ppStm = con.prepareStatement(queryAlterar);
                    
                    ppStm.setString(1, obj.getData_orc());
			ppStm.setString(2, ""+obj.getCodCli());
			ppStm.setString(3, ""+obj.getCod_vendedor());
			ppStm.setString(4, ""+obj.getValor_total());
			ppStm.setString(5, ""+obj.getDescont());
			ppStm.setString(6, ""+obj.getObs());
			ppStm.setString(7, ""+obj.getId());
                    ppStm.execute(); ppStm.close();
                    
                    return true;
	
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução DO Alterar Orçamento, "+ex);
                        
        }
        return false;
    }
    public ResultSet selecionar(){
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String querySelect = "select * from orcamento";
			
            PreparedStatement ppStm = con.prepareStatement(querySelect);
			
            ResultSet objRst = ppStm.executeQuery();
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            
            return objRst;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar orcamento, "+ex);
        }
        return null;
    }

    public int selectLastCodOrc() {
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String querySelectUser = "select ID from orcamento";
			
            PreparedStatement ppStm = con.prepareStatement(querySelectUser);
            
            ResultSet objRst = ppStm.executeQuery();
            
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            objRst.last();
            return objRst.getInt("ID");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar CODIGO orcamento:  "+ex);
        }
        return -1;
    }
    
       public void deletar(int cod){
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "DELETE from orcamento WHERE ID=?";
		
            PreparedStatement ppStm = con.prepareStatement(queryInserir);
            ppStm.setString(1, String.valueOf(cod));
            ppStm.execute(); ppStm.close();
                        
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do deletar orcamento, "+ex);
        }
    }

}

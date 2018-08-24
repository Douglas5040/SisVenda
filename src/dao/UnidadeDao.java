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
public class UnidadeDao {
    public void inserir(UnidadeMedCtrl obj){
        BancoMySql objBanco = new BancoMySql();
       
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "INSERT INTO unidade_medida VALUES(0,?,?)";
			
			PreparedStatement ppStm = con.prepareStatement(queryInserir);
			
			ppStm.setString(1, obj.getAbrev());
			ppStm.setString(2, obj.getNome());
                        ppStm.execute();
                        
                        //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do insert Unidade, "+ex);
                        
        }
    }
      
    public boolean alterar(UnidadeMedCtrl obj){
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
           String queryAlterar = "UPDATE unidade_medida SET ABREV = ?, "
                                                    + "NOME = ? "
                                 + "WHERE ID=?";
			
                    PreparedStatement ppStm = con.prepareStatement(queryAlterar);
                    
                    ppStm.setString(1, obj.getAbrev());
                    ppStm.setString(2, obj.getNome());
                    ppStm.setString(3, String.valueOf(obj.getID()));
                    ppStm.execute();
                    
                    return true;
	
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução DO Alterar Unidade de Medida, "+ex);
                        
        }
        return false;
    }
    public ResultSet selecionar(){
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String querySelect = "select * from unidade_medida";
			
            PreparedStatement ppStm = con.prepareStatement(querySelect);
			
            ResultSet objRst = ppStm.executeQuery();
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            
            return objRst;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar unidade medida: "+ex);
        }
        return null;
    }

    public int selecionarUnidadeMedCod(String parametro) {
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String querySelectUser = "select * from unidade_medida WHERE NOME LIKE ?";
			
            PreparedStatement ppStm = con.prepareStatement(querySelectUser);
            ppStm.setString(1, parametro);
            
            ResultSet objRst = ppStm.executeQuery();
            
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            if(objRst.first()) return objRst.getInt("ID");
            else return -1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar cod unidade, "+ex);
        }
        return -1;
    }
    public ResultSet selecionarUndMed(String parametro) {
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String querySelectUser = "select * from unidade_medida WHERE NOME LIKE ? OR ID = ?";
			
            PreparedStatement ppStm = con.prepareStatement(querySelectUser);
            ppStm.setString(1, parametro+"%");
            ppStm.setString(2, parametro);
            
            ResultSet objRst = ppStm.executeQuery();
            
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            
            return objRst;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar cod unidade, "+ex);
        }
        return null;
    }

}

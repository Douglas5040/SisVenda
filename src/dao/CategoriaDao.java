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
public class CategoriaDao {
    public void inserir(CategoriaCtrl obj){
        BancoMySql objBanco = new BancoMySql();
       
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "INSERT INTO categoria VALUES(0,?,?)";
			
			PreparedStatement ppStm = con.prepareStatement(queryInserir);
			
			ppStm.setString(1, obj.getNome());
			ppStm.setString(2, obj.getDescri());
                        ppStm.execute();
                        
                        //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do inserir Categoria: "+ex);
                        
        }
    }
    
    public boolean alterar(CategoriaCtrl obj){
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
           String queryAlterar = "UPDATE categoria SET NOME = ?, "
                                                    + "DESCRI = ? "
                                 + "WHERE ID=?";
			
                    PreparedStatement ppStm = con.prepareStatement(queryAlterar);
                    
                    ppStm.setString(1, obj.getNome());
                    ppStm.setString(2, obj.getDescri());
                    ppStm.setString(3, String.valueOf(obj.getID()));
                    ppStm.execute();
                    
                    return true;
	
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução DO Alterar CAtegoria, "+ex);
                        
        }
        return false;
    }
    public ResultSet selecionar(){
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String querySelect = "select * from categoria";
			
            PreparedStatement ppStm = con.prepareStatement(querySelect);
			
            ResultSet objRst = ppStm.executeQuery();
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            
            return objRst;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar categoria, "+ex);
        }
        return null;
    }

    public int selecionarCategoCod(String parametro) {
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String querySelectUser = "select * from categoria WHERE NOME LIKE ?";
			
            PreparedStatement ppStm = con.prepareStatement(querySelectUser);
            ppStm.setString(1, parametro);
            
            ResultSet objRst = ppStm.executeQuery();
            
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            objRst.first();
            return objRst.getInt("ID");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar COD CATEGORIA:  "+ex);
        }
        return -1;
    }

    public ResultSet selecionarCatego(String parametro) {
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String querySelectUser = "select * from categoria WHERE NOME LIKE ? OR ID = ?";
			
            PreparedStatement ppStm = con.prepareStatement(querySelectUser);
            ppStm.setString(1, parametro+"%");
            ppStm.setString(2, parametro);
            
            ResultSet objRst = ppStm.executeQuery();
            
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            return objRst;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar COD CATEGORIA:  "+ex);
        }
        return null;
    }

}

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
public class MarcaDao {
    public void inserir(MarcaCtrl obj){
        BancoMySql objBanco = new BancoMySql();
        
       
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "INSERT INTO marca VALUES(0,?,?)";
			
			PreparedStatement ppStm = con.prepareStatement(queryInserir);
			
			ppStm.setString(1, obj.getNome());
			ppStm.setString(2, obj.getDescri());
                        ppStm.execute();
                        
                        //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do Insert Marca: "+ex);
                        
        }
    }
    public boolean alterar(MarcaCtrl obj){
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
           String queryAlterar = "UPDATE marca SET NOME = ?, "
                                                + "DESCRI = ? "
                                 + "WHERE ID=?";
			
                    PreparedStatement ppStm = con.prepareStatement(queryAlterar);
                    
                    ppStm.setString(1, obj.getNome());
                    ppStm.setString(2, obj.getDescri());
                    ppStm.setString(3, ""+obj.getID());
                    ppStm.execute();
                    
                    return true;
	
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução DO Alterar Marca, "+ex);
                        
        }
        return false;
    }
    
    public ResultSet selecionar(){
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String querySelect = "select * from marca";
			
            PreparedStatement ppStm = con.prepareStatement(querySelect);
			
            ResultSet objRst = ppStm.executeQuery();
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            
            return objRst;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar marca, "+ex);
        }
        return null;
    }

    public int selectCodMarca(String parametro) {
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String querySelectUser = "select * from marca WHERE NOME LIKE ? ";
			
            PreparedStatement ppStm = con.prepareStatement(querySelectUser);
            ppStm.setString(1, parametro);
            
            ResultSet objRst = ppStm.executeQuery();
            
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            if(objRst.first()) return objRst.getInt("ID");
            else return -1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar cod Marca, "+ex);
        }
        return -1;
    }

    public ResultSet selectMarca(String parametro) {
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String querySelectUser = "select * from marca WHERE NOME LIKE ? OR ID = ?";
			
            PreparedStatement ppStm = con.prepareStatement(querySelectUser);
            ppStm.setString(1, parametro+"%");
            ppStm.setString(2, parametro);
            
            ResultSet objRst = ppStm.executeQuery();
            
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            return objRst;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar cod Marca, "+ex);
        }
        return null;
    }

}

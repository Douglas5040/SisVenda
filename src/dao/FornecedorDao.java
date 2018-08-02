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
public class FornecedorDao {
    public void inserir(FornecedorCtrl obj){
        BancoMySql objBanco = new BancoMySql();
        
       
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "INSERT INTO fornecedor VALUES(0,?,?,?,?,?,?,?)";
			
			PreparedStatement ppStm = con.prepareStatement(queryInserir);
			
			ppStm.setString(1, String.valueOf(obj.getCpf_cnpj()));
			ppStm.setString(2, obj.getRazao_social());
			ppStm.setString(3, obj.getNome_fantazia());
			ppStm.setString(4, obj.getEnder());
			ppStm.setString(5, obj.getBairro());
			ppStm.setString(6, obj.getCidade());
			ppStm.setString(7, obj.getUf());
                        
                        ppStm.execute();
                        
                        //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do insert Fornecedor: "+ex);
                        
        }
    }
    
    public ResultSet selecionar(){
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String querySelect = "select * from fornecedor";
			
            PreparedStatement ppStm = con.prepareStatement(querySelect);
			
            ResultSet objRst = ppStm.executeQuery();
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            
            return objRst;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar fornecedor, "+ex);
        }
        return null;
    }

    public int selectCodFornece(String parametro) {
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String querySelectUser = "select * from fornecedor WHERE NOME_FANTAZIA LIKE ? OR CPF_CNPJ = ? OR RAZAO_SOCIAL LIKE ?";
			
            PreparedStatement ppStm = con.prepareStatement(querySelectUser);
            ppStm.setString(1, parametro+"%");
            ppStm.setString(2, parametro);
            ppStm.setString(3, parametro+"%");
            
            ResultSet objRst = ppStm.executeQuery();
            
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            objRst.first();
            return objRst.getInt("ID");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar cod fornecedor: "+ex);
        }
        return -1;
    }

    public ResultSet selectFornece(String parametro) {
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String querySelectUser = "select * from fornecedor WHERE (NOME_FANTAZIA LIKE ?) OR (CPF_CNPJ = ?) OR (RAZAO_SOCIAL LIKE ?) OR (ID = ?)";
			
            PreparedStatement ppStm = con.prepareStatement(querySelectUser);
            ppStm.setString(1, parametro+"%");
            ppStm.setString(2, parametro);
            ppStm.setString(3, parametro+"%");
            ppStm.setString(4, parametro);
            
            ResultSet objRst = ppStm.executeQuery();
            
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            objRst.first();
            return objRst;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar cod fornecedor: "+ex);
        }
        return null;
    }

}

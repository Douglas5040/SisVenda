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
public class FuncionarioDao {
    public void inserir(FuncionarioCtrl obj){
        BancoMySql objBanco = new BancoMySql();
        
       
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "INSERT INTO funcionario VALUES(0,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement ppStm = con.prepareStatement(queryInserir);
			
			ppStm.setString(1, obj.getCodigo());
			ppStm.setString(2, obj.getNome());
			ppStm.setString(3, ""+obj.getRg());
			ppStm.setString(4, ""+obj.getCpf());
			ppStm.setString(5, ""+obj.getCart_trab());
			ppStm.setString(6, obj.getData_nasc());
			ppStm.setString(7, ""+obj.getCep());
			ppStm.setString(8, ""+obj.getRua());
			ppStm.setString(9, ""+obj.getBairro());
			ppStm.setString(10, ""+obj.getNumero());
			ppStm.setString(11, ""+obj.getComplem());
			ppStm.setString(12, ""+obj.getCelular());
			ppStm.setString(13, ""+obj.getTel1());
			ppStm.setString(14, ""+obj.getTel2());
			ppStm.setString(15, ""+obj.getFoto());
			ppStm.setString(16, ""+obj.getCargo());
			ppStm.setString(17, ""+obj.getCod_user());
                        
                        
                        ppStm.execute();
                        
                        //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do insert Funcionario: "+ex);
                        
        }
    }
    
    public ResultSet selecionar(){
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String querySelect = "select * from funcionario";
			
            PreparedStatement ppStm = con.prepareStatement(querySelect);
			
            ResultSet objRst = ppStm.executeQuery();
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            
            return objRst;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar funcionario, "+ex);
        }
        return null;
    }

    public ResultSet selectFuncForUser(int codUser) {
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String querySelectUser = "select * from funcionario WHERE COD_USER = ?";
			
            PreparedStatement ppStm = con.prepareStatement(querySelectUser);
            ppStm.setString(1, ""+codUser);
            
            ResultSet objRst = ppStm.executeQuery();
            
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            objRst.first();
            return objRst;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar funcionario por user: "+ex);
        }
        return null;
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

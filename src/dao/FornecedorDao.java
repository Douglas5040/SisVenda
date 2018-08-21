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
    public int inserir(FornecedorCtrl obj){
        BancoMySql objBanco = new BancoMySql();
        
       
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "INSERT INTO fornecedor VALUES(0,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement ppStm = con.prepareStatement(queryInserir);
			
			ppStm.setString(1, String.valueOf(obj.getCodigo()));
			ppStm.setString(2, obj.getBairro());
			ppStm.setString(3, obj.getCidade());
			ppStm.setString(4, ""+obj.getCpf_cnpj());
			ppStm.setString(5, obj.getCpf_or_cnpj());
			ppStm.setString(6, obj.getEnder());
			ppStm.setString(7, obj.getCelular());
			ppStm.setString(8, obj.getTelefone());
			ppStm.setString(9, obj.getNome_fantazia());
			ppStm.setString(10, obj.getRazao_social());
			ppStm.setString(11, obj.getEstado());
			ppStm.setString(12, ""+obj.getCep());
			ppStm.setString(13, obj.getObs());
			ppStm.setString(14, obj.getEmail());
                        
                        ppStm.execute();
                        
                        int lastId = selecionarLastID();
                        PreparedStatement ppStmCod = con.prepareStatement("UPDATE fornecedor SET CODIGO = ? WHERE ID=?");   
                        ppStmCod.setString(1, lastId+"FOR"); 
                        ppStmCod.setString(2, ""+lastId);
                        ppStmCod.execute();
                        return lastId;
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do insert Fornecedor: "+ex);
                        
        }
        return -1;
    }
    
    public int selecionarLastID(){
        BancoMySql objBanco = new BancoMySql();

        try {
            java.sql.Connection con = objBanco.obtemConexao();

            String querySelect = "select * from fornecedor WHERE ID > 0";

            PreparedStatement ppStm = con.prepareStatement(querySelect);
            ResultSet objRst = ppStm.executeQuery();
            objRst.last();
            System.out.println("THE LAST ID: "+objRst.getInt("ID"));
            return objRst.getInt("ID");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar LAST ID fornecedor: "+ex);

        }
        return -1;
    }
       
     public void alterar(FornecedorCtrl obj){
        BancoMySql objBanco = new BancoMySql();
         

       
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "UPDATE clientes SET BAIRRO = ?, "
                                                    + "CIDADE = ?, "
                                                    + "CPF_CNPJ = ?, "
                                                    + "CPF_OR_CNPJ = ?, "
                                                    + "ENDER = ?, "
                                                    + "CELULAR = ?, "
                                                    + "TELEFONE = ?, "
                                                    + "NOME_FANTAZIA = ?, "
                                                    + "RAZAO_SOCIAL = ?, "
                                                    + "ESTADO = ?, "
                                                    + "CEP = ?, "
                                                    + "OBS = ?, "
                                                    + "EMAIL = ? "
                                 + "WHERE ID=? OR CODIGO=?";
			
			PreparedStatement ppStm = con.prepareStatement(queryInserir);
			
                        
			ppStm.setString(1, obj.getBairro());
			ppStm.setString(2, obj.getCidade());
			ppStm.setString(3, ""+obj.getCpf_cnpj());
			ppStm.setString(4, obj.getCpf_or_cnpj());
			ppStm.setString(5, obj.getEnder());
			ppStm.setString(6, obj.getCelular());
			ppStm.setString(7, obj.getTelefone());
			ppStm.setString(8, obj.getNome_fantazia());
			ppStm.setString(9, obj.getRazao_social());
			ppStm.setString(10, obj.getEstado());
			ppStm.setString(12, ""+obj.getCep());
			ppStm.setString(12, obj.getObs());
			ppStm.setString(13, obj.getEmail());
			ppStm.setString(14, String.valueOf(obj.getID()));
			ppStm.setString(15, obj.getCodigo());
                        
                        ppStm.execute();
                        
                        //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
                        
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do alterar dados FORNECEDOR: "+ex);
                        
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

    public int selectCodForneceID(String parametro) {
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
            if(objRst.first()) return objRst.getInt("ID");
            else return -1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar cod fornecedor: "+ex);
        }
        return -1;
    }

    public ResultSet selectFornece(String parametro) {
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String querySelectUser = "select * from fornecedor WHERE (NOME_FANTAZIA LIKE ?) OR (CPF_CNPJ = ?) OR (RAZAO_SOCIAL LIKE ?) OR (CODIGO = ?)";
			
            PreparedStatement ppStm = con.prepareStatement(querySelectUser);
            ppStm.setString(1, parametro+"%");
            ppStm.setString(2, parametro);
            ppStm.setString(3, parametro+"%");
            ppStm.setString(4, parametro);
            
            ResultSet objRst = ppStm.executeQuery();
            
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            return objRst;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar cod fornecedor: "+ex);
        }
        return null;
    }

}

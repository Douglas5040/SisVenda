/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import banco.BancoMySql;
import ctrl.ClienteCtrl;
import ctrl.DadosEmpresaCtrl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Adm
 */
public class DadosEmpresaDao {
    public void inserir(DadosEmpresaCtrl obj){
        BancoMySql objBanco = new BancoMySql();
       
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "INSERT INTO dados_empresa VALUES(0,?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement ppStm = con.prepareStatement(queryInserir);
			
			ppStm.setString(1, obj.getNome());
                        ppStm.setString(2, obj.getEnder());
                        ppStm.setString(3, obj.getCidade());
			ppStm.setString(4, obj.getEstado());
                        ppStm.setString(5, obj.getCnpj());
			ppStm.setString(6, obj.getTel());
                        ppStm.setString(7, obj.getCell());
                        ppStm.setString(8, obj.getEmail());
                        ppStm.setString(9, obj.getNome_dono());
                        ppStm.setString(10, ""+obj.getLogo());
                        ppStm.execute(); ppStm.close();
              
                  
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução DO INSERIR DADOS EMPRESA: "+ex);
            System.out.println("Log: "+ex);
                        
        }
    }
    
     public void alterar(DadosEmpresaCtrl obj){
        BancoMySql objBanco = new BancoMySql();
        
       
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "UPDATE dados_empresa SET NOME = ?, "
                                                    + "ENDER = ?, "
                                                    + "CIDADE = ?, "
                                                    + "ESTADO = ?, "
                                                    + "CNPJ = ?, "
                                                    + "TEL = ?, "
                                                    + "CELL = ?, "
                                                    + "EMAIL = ?, "
                                                    + "NOME_DONO = ?, "
                                                    + "LOGOTIPO = ? "
                                 + "WHERE CNPJ=? OR ID=?";
			
			PreparedStatement ppStm = con.prepareStatement(queryInserir);
			
                        
			ppStm.setString(1, obj.getNome());
                        ppStm.setString(2, obj.getEnder());
                        ppStm.setString(3, obj.getCidade());
			ppStm.setString(4, obj.getEstado());
                        ppStm.setString(5, obj.getCnpj());
			ppStm.setString(6, obj.getTel());
                        ppStm.setString(7, obj.getCell());
                        ppStm.setString(8, obj.getEmail());
                        ppStm.setString(9, obj.getNome_dono());
                        ppStm.setString(10, ""+obj.getLogo());
                        ppStm.setString(11, ""+obj.getCnpj());
                        ppStm.setString(12, ""+obj.getId());
                        ppStm.execute(); ppStm.close();
                      
                        
                        
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "erro na execução do alterar dados empresa: "+ex);
                        
        }
    }

    public void deletar(int id, String cnpj){
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "DELETE from dados_empresa WHERE CNPJ = ? OR ID=?";
		
            PreparedStatement ppStm = con.prepareStatement(queryInserir);
            ppStm.setString(1, cnpj);
            ppStm.setString(2, String.valueOf(id));
            ppStm.execute(); ppStm.close();
            con.close();
                        
           // JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do deletar");
        }
    }
    
    public ResultSet selecionarTodos(){
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "select * from dados_empresa WHERE id > 0";
			
            PreparedStatement ppStm = con.prepareStatement(queryInserir);
			
            ResultSet objRst = ppStm.executeQuery();
           // JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            
            return objRst;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar dados_empresa, "+ex);
        }
        return null;
    }

    public ResultSet selecionarDADOS(String consultCli) {
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "select * from dados_empresa WHERE (NOME CNPJ ? OR ID = ?) AND id > 0";
			
            PreparedStatement ppStm = con.prepareStatement(queryInserir);
            ppStm.setString(1, consultCli+"%");
            ppStm.setString(2, consultCli);
            
            ResultSet objRst = ppStm.executeQuery();
            
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            
            return objRst;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar dados_empresa DAO "+ex);
        }
        return null;
    }
    
   
}

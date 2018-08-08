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
public class OrdemServiceDao {
    public void inserir(OrdemServiceCtrl obj){
        BancoMySql objBanco = new BancoMySql();
       
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "INSERT INTO ordem_service VALUES(0,?,?,?,?,?,?,?,?)";
			
			PreparedStatement ppStm = con.prepareStatement(queryInserir);
			
			ppStm.setString(1, ""+obj.getValor());
			ppStm.setString(2, obj.getData_hora_opem());
			ppStm.setString(3, obj.getData_hora_close());
			ppStm.setString(4, ""+obj.getCod_vendedor());
			ppStm.setString(5, ""+obj.getCod_cli());
			ppStm.setString(6, ""+obj.getCod_cli());
			ppStm.setString(7, ""+obj.getDescont());
			ppStm.setString(8, obj.getObs());
                        ppStm.execute();
                        
                        //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do inserir Categoria: "+ex);
                        
        }
    }
    
    public ResultSet selecionar(){
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String querySelect = "select * from ordem_service";
			
            PreparedStatement ppStm = con.prepareStatement(querySelect);
			
            ResultSet objRst = ppStm.executeQuery();
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            
            return objRst;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar categoria, "+ex);
        }
        return null;
    }

    public ResultSet selecionarOS(String parametro) {
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String querySelectUser = "select * from ordem_service WHERE ID = ?";
			
            PreparedStatement ppStm = con.prepareStatement(querySelectUser);
            ppStm.setString(1, parametro);
            
            ResultSet objRst = ppStm.executeQuery();
            
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            return objRst;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar ordem_service:  "+ex);
        }
        return null;
    }

    
    public void alterarOS(OrdemServiceCtrl osCtrl){
        BancoMySql objBanco = new BancoMySql();
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "UPDATE ordem_service SET VALOR=?,"
                                                        + " DATA_HORA_OPEM=?,"
                                                        + " DATA_HORA_CLOSE=?,"
                                                        + " COD_VENDEDOR=?, "
                                                        + " COD_CLI=?,"                                             
                                                        + " DECONT=?,"
                                                        + " COD_STATUS_OS=?,"
                                                        + " OBS=? "

                                 + "WHERE ID =?";
			
			PreparedStatement ppStm = con.prepareStatement(queryInserir);
			
			ppStm.setString(1, String.valueOf(osCtrl.getValor()));
                        ppStm.setString(2, osCtrl.getData_hora_opem());
                        ppStm.setString(3, osCtrl.getData_hora_close());
                        ppStm.setString(4, String.valueOf(osCtrl.getCod_vendedor()));
                        ppStm.setString(5, String.valueOf(osCtrl.getCod_cli()));
                        ppStm.setString(6, String.valueOf(osCtrl.getDescont()));
                        ppStm.setString(7, String.valueOf(osCtrl.getCod_status_os()));
                        ppStm.setString(8, String.valueOf(osCtrl.getObs()));
                        ppStm.setString(9, String.valueOf(osCtrl.getId()));
                        ppStm.execute();
                        
                        //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do alterar quantidade produto da venda");
                        
        }
    }
    
    public void altStatusOS(int id, int cod_status){
        BancoMySql objBanco = new BancoMySql();
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "UPDATE ordem_service SET COD_STATUS_OS=? WHERE ID =?";
			
			PreparedStatement ppStm = con.prepareStatement(queryInserir);
			
			ppStm.setString(1, String.valueOf(cod_status));
                        ppStm.setString(2, String.valueOf(id));
                        
                        //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do alterar status OS");
                        
        }
    }
}

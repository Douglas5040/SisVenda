/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import banco.BancoMySql;
import ctrl.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Adm
 */
public class ContasDao {
    
    public void inserir(ContasCtrl obj){
        BancoMySql objBanco = new BancoMySql();
        Date dataSistema = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        String data = (formato.format(dataSistema));
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "INSERT INTO contas VALUES(0,?,?,?,?,?)";
			
			PreparedStatement ppStm = con.prepareStatement(queryInserir);
			
			ppStm.setString(1, String.valueOf(obj.getCod_cli()));
                        ppStm.setString(2, String.valueOf(obj.getValor()));
                        ppStm.setString(3, data);
                        ppStm.setString(4, obj.getData_pag());
                        ppStm.setString(5, obj.getStatus());
                        ppStm.execute(); ppStm.close();
                        
                        //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução DO INSERIR Conta "+ex);
                        
        }
    }
    
    public void alterar(int codCli,Double valor, String data, String dataOP, String status){
        BancoMySql objBanco = new BancoMySql();

        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "UPDATE contas SET valor=?, data_open =?, data_pag=?, status=? "
                                 + "WHERE cod_Cli =?";
			
			PreparedStatement ppStm = con.prepareStatement(queryInserir);
			
			ppStm.setString(1, String.valueOf(valor));
                        ppStm.setString(2, dataOP);
                        ppStm.setString(3, data);
                        ppStm.setString(4, status);
                        ppStm.setString(5, String.valueOf(codCli));
                        ppStm.execute(); ppStm.close();
                        
                        //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do alterar CONTA"+ex);
                        
        }
    }
    
     public ResultSet selecionar(){
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "select * from contas";
			
            PreparedStatement ppStm = con.prepareStatement(queryInserir);
			
            ResultSet objRst = ppStm.executeQuery();
           // JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            
            return objRst;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar");
        }
        return null;
    }

     public void deletar(int cod, int id){
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "DELETE from contas WHERE cod_conta=? AND cod_Cli=?";
			
            PreparedStatement ppStm = con.prepareStatement(queryInserir);
            ppStm.setString(1, String.valueOf(cod));
            ppStm.setString(2, String.valueOf(id));
            ppStm.execute(); ppStm.close();
           // JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do deletar Conta "+ex);
        }
    }
     
     public ResultSet selectConta(int idCli){
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryselectConta = "select cod_Cli,cod_conta,status,valor,data_open,date_format(data_pag,'%d/%c/%Y')"
                                    + " as 'data_pag' from contas WHERE cod_Cli="+idCli;
			
            PreparedStatement ppStm = con.prepareStatement(queryselectConta);
            ResultSet objRst = ppStm.executeQuery();

            objRst.first();
            return objRst;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar Conta po ID_CLI"+ex);
        }
        return null;
    }
     
     public String selectDataPagConta(int idCli){
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryselectConta = "select date_format(data_pag,'%d/%m/%Y')"
                                    + " as 'data_pag' from contas WHERE cod_Cli="+idCli;
			
            PreparedStatement ppStm = con.prepareStatement(queryselectConta);
            ResultSet objRst = ppStm.executeQuery();

            objRst.first();
            return objRst.getString("data_pag");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar Conta po ID_CLI"+ex);
        }
        return "sem data";
    }
     
     public boolean checkContaCli(int idCli){
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "select * from contas WHERE cod_Cli=?";	
            PreparedStatement ppStm = con.prepareStatement(queryInserir);
	
            ppStm.setString(1, String.valueOf(idCli));
            ResultSet objRst = ppStm.executeQuery();
            //objRst.first();
            //JOptionPane.showMessageDialog(null,objRst.getString("valor"));
            
            return objRst.first();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar Conta "+ex);
        }
        return false;
    }
     
    public ResultSet selectDevendo() {
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "select * from contas WHERE situation LIKE 'DEVENDO'";
			
            PreparedStatement ppStm = con.prepareStatement(queryInserir);
            
            ResultSet objRst = ppStm.executeQuery();
            
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            
            return objRst;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar user");
        }
        return null;
    }
    
    public Double selectValor(int idCli) {
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "select valor from contas WHERE cod_Cli = "+idCli;
			
            PreparedStatement ppStm = con.prepareStatement(queryInserir);
            
            ResultSet objRst = ppStm.executeQuery();
            
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            objRst.first();
            return objRst.getDouble("valor");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar valor "+ex);
        }
        return null;
    }
}

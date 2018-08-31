/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import banco.BancoMySql;
import com.mysql.jdbc.Connection;
import ctrl.FamiliaCliCtrl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Douglas
 */
public class FamiliaCliDAO {
    
    public boolean inserir(FamiliaCliCtrl obj){
        BancoMySql objBanco = new BancoMySql();
        
        int ID = obj.getID();
        int cpf = obj.getCpf();
        int rg = obj.getRg();
        String nome = obj.getNome();
        String relacao = obj.getRelacao();
        int cod_cli = obj.getCod_cli();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "INSERT INTO familia_cli VALUES(0,?,?,?,?,?)";
			
                    PreparedStatement ppStm = con.prepareStatement(queryInserir);
                    
                    ppStm.setString(1, String.valueOf(cpf));
                    ppStm.setString(2, String.valueOf(rg));
                    ppStm.setString(3, String.valueOf(nome));
                    ppStm.setString(4, String.valueOf(relacao));
                    ppStm.setString(5, String.valueOf(cod_cli));
                    ppStm.execute(); ppStm.close();
                    
                    System.out.println("menbo familia add com sucesso!!!");
                    
                    return true;
	
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução DO INSERIR familia Cliente");
                        
        }
        return false;
    }
    
    public boolean alterar(FamiliaCliCtrl obj){
        BancoMySql objBanco = new BancoMySql();
        
        int ID = obj.getID();
        int cpf = obj.getCpf();
        int rg = obj.getRg();
        String nome = obj.getNome();
        String relacao = obj.getRelacao();
        int cod_cli = obj.getCod_cli();
        
        try {
            Connection con = objBanco.obtemConexao();
            
           String queryInserir = "UPDATE clientes SET CPF = ?, "
                                                    + "RG = ?, "
                                                    + "NOME = ?, "
                                                    + "RELACAO = ?, "
                                 + "WHERE COD_CLI=?";
			
                    PreparedStatement ppStm = con.prepareStatement(queryInserir);
                    
                    ppStm.setString(1, String.valueOf(cpf));
                    ppStm.setString(2, String.valueOf(rg));
                    ppStm.setString(3, String.valueOf(nome));
                    ppStm.setString(4, String.valueOf(relacao));
                    ppStm.setString(5, String.valueOf(cod_cli));
                    ppStm.execute(); ppStm.close();
                    
                    return true;
	
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução DO INSERIR familia Cliente");
                        
        }
        return false;
    }
    
    
    public ResultSet selectFamilyPorCli(int codCli) {
        BancoMySql objBanco = new BancoMySql();
        
        try {
            java.sql.Connection con = objBanco.obtemConexao();
            
            String queryInserir = "select * from familia_cli WHERE (COD_CLI = ?)";
			
            PreparedStatement ppStm = con.prepareStatement(queryInserir);
            ppStm.setString(1, ""+codCli);
            
            ResultSet objRst = ppStm.executeQuery();
            
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            
            return objRst;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar user DAO "+ex);
        }
        return null;
    }
    
    public int selecionarLastID(){
        BancoMySql objBanco = new BancoMySql();
        
        try {
            java.sql.Connection con = objBanco.obtemConexao();
            
            String querySelect = "select * from familia_cli WHERE id > 0";
			
            PreparedStatement ppStm = con.prepareStatement(querySelect);
            ResultSet objRst = ppStm.executeQuery();
            objRst.last();
            
            return objRst.getInt("ID");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar Familia Cliente: "+ex);
            
        }
        return -1;
    }
    
     public void deletar(int codCli){
        BancoMySql objBanco = new BancoMySql();
        
        try {
            java.sql.Connection con = objBanco.obtemConexao();
            
            String queryInserir = "DELETE from familia_cli WHERE COD_CLI=?";
		
            PreparedStatement ppStm = con.prepareStatement(queryInserir);
            ppStm.setString(1, String.valueOf(codCli));
            ppStm.execute(); ppStm.close();
            
            System.out.println("membro familia deletado com sucesso!!!");
                        
           // JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do deletar");
        }
    }
}

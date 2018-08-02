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
public class AcessoDao {
    public void inserir(UsuarioCtrl obj){
        BancoMySql objBanco = new BancoMySql();
        
        String llogin = obj.getLogin();
        String lsenha = obj.getSenha();
        String lcargo = obj.getSenha();
        String lsalt = obj.getSenha();
        String lemail = obj.getSenha();
       
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "INSERT INTO usuario VALUES(0,?,?, MD5(?),?,?)";
			
			PreparedStatement ppStm = con.prepareStatement(queryInserir);
			
			ppStm.setString(1, lcargo);
			ppStm.setString(2, llogin);
			ppStm.setString(3, lsenha);
			ppStm.setString(4, lsalt);
			ppStm.setString(5, lemail);
                        ppStm.execute();
                        
                        //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do usuario, "+ex);
                        
        }
    }
    
    public ResultSet selecionar(){
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String querySelect = "select * from usuario";
			
            PreparedStatement ppStm = con.prepareStatement(querySelect);
			
            ResultSet objRst = ppStm.executeQuery();
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            
            return objRst;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar usuario, "+ex);
        }
        return null;
    }

    public ResultSet selecionarUser(UsuarioCtrl objAcesso) {
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String querySelectUser = "select * from usuario WHERE LOGIN LIKE ? AND SENHA = MD5(?)";
			
            PreparedStatement ppStm = con.prepareStatement(querySelectUser);
            ppStm.setString(1, objAcesso.getLogin());
            ppStm.setString(2, objAcesso.getSenha());
            
            ResultSet objRst = ppStm.executeQuery();
            
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            
            return objRst;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar user, "+ex);
        }
        return null;
    }
    public boolean verificarUser(String login, String senha) {
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String querySelectUser = "select * from usuario WHERE LOGIN LIKE ? AND SENHA = MD5(?)";
			
            PreparedStatement ppStm = con.prepareStatement(querySelectUser);
            ppStm.setString(1, login);
            ppStm.setString(2, senha);
            
            ResultSet objRst = ppStm.executeQuery();
            
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            
            return objRst.first();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do verificar user, "+ex);
        }
        return false;
    }

}

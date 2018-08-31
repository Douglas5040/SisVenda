/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import ctrl.ControleProCtrl;
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
public class ControleProDAO {
    public boolean inserir(ControleProCtrl obj){
        BancoMySql objBanco = new BancoMySql();
        
        int codPro = obj.getCodPro();
        int codOp = obj.getCodOpera();
        int codUser = obj.getCodUser();
        int codForence = obj.getCodFornece();
        int codCli = obj.getCodCli();
        int qtd = obj.getQtd();
        String date = obj.getDate();
        String hora = obj.getHora();
        String obs = obj.getObs();
       
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "INSERT INTO control_produtos VALUES(0,?,?,?,?,?,?,?,?)";
			
			PreparedStatement ppStm = con.prepareStatement(queryInserir);
			
			ppStm.setString(1, ""+codPro);
			ppStm.setString(2, ""+qtd);
			ppStm.setString(3, ""+codOp);
			ppStm.setString(4, ""+codUser);
			ppStm.setString(5, date+" "+hora);
			ppStm.setString(6, obs);
			ppStm.setString(7, ""+codCli);
			ppStm.setString(8, ""+codForence);
                        
                        boolean execute = ppStm.execute();
                        ppStm.close();
                        //con.close();
            return execute;
                        
                        //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
                        
        } catch (SQLException ex) {
            System.out.println("erro na execução do operação produto,  "+ex);
            //JOptionPane.showMessageDialog(null, "erro na execução do operação produto, "+ex);              
        }
        return false;
    }
    
    public ResultSet selecionar(){
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String querySelect = "select * from control_produtos";
			
            PreparedStatement ppStm = con.prepareStatement(querySelect);
			
            ResultSet objRst = ppStm.executeQuery();
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            
            return objRst;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar control_produtos, "+ex);
        }
        return null;
    }

}

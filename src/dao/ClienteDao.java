/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import banco.BancoMySql;
import ctrl.ClienteCtrl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Adm
 */
public class ClienteDao {
    public int inserir(ClienteCtrl obj){
        BancoMySql objBanco = new BancoMySql();
                
        int id = obj.getId();
        String nome = obj.getNome();
        String data_nasc = obj.getData_nasc();
        String apelido = obj.getApelido();
        String estado_civil = obj.getEstado_civil();
        int cpf_cnpj = obj.getCpf_cnpj();
        String cpf_or_cnpj = obj.getCpf_or_cnpj();
        int rg = obj.getRg();
        String celular = obj.getCelular();
        String tel_resi = obj.getTel_resi();
        String tel_comer = obj.getTel_comer();
        Double valor_credito = obj.getValor_credito();
        int cep = obj.getCep();
        String rua = obj.getRua();
        int numero = obj.getNumero();
        String bairro = obj.getBairro();
        String complem = obj.getComplem();
        String cidade = obj.getCidade();
        String estado = obj.getEstado();
        String referencia = obj.getReferencia();
        String foto = obj.getFoto();
        int bonus_acumulado = obj.getBonus_acumulado();
        String obs = obj.getObs();
        String email = obj.getEmail();
       
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "INSERT INTO clientes VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement ppStm = con.prepareStatement(queryInserir);
			
			ppStm.setString(1, String.valueOf(id));
                        ppStm.setString(2, "");
                        ppStm.setString(3, nome);
			ppStm.setString(4, data_nasc);
                        ppStm.setString(5, estado_civil);
			ppStm.setString(6, apelido);
                        ppStm.setString(7, String.valueOf(rg));
                        ppStm.setString(8, String.valueOf(cpf_cnpj));
                        ppStm.setString(9, cpf_or_cnpj);
                        ppStm.setString(10, String.valueOf(cep));
                        ppStm.setString(11, rua);
                        ppStm.setString(12, String.valueOf(numero));
                        ppStm.setString(13, complem);
                        ppStm.setString(14, bairro);
                        ppStm.setString(15, cidade);
                        ppStm.setString(16, estado);
                        ppStm.setString(17, referencia);
                        ppStm.setString(18, celular);
                        ppStm.setString(19, tel_resi);
                        ppStm.setString(20, tel_comer);
                        ppStm.setString(21, String.valueOf(valor_credito));
                        ppStm.setString(22, foto);
                        ppStm.setString(23, String.valueOf(bonus_acumulado));
                        ppStm.setString(24, email);
                        ppStm.setString(25, obs);
                        ppStm.execute();
                        
                 int lastId = selecionarLastID();
                 PreparedStatement ppStmCod = con.prepareStatement("UPDATE clientes SET CODIGO = ? WHERE ID=?");   
                 ppStmCod.setString(1, lastId+"CLI"); 
                 ppStmCod.setString(2, ""+lastId);
                 ppStmCod.execute();
                 return lastId;
                  
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução DO INSERIR CLIENTE: "+ex);
            System.out.println("Log: "+ex);
                        
        }
        return -1;
    }
    
     public void alterar(ClienteCtrl obj){
        BancoMySql objBanco = new BancoMySql();
         
        int id = obj.getId();
        String nome = obj.getNome();
        String data_nasc = obj.getData_nasc();
        String apelido = obj.getApelido();
        String estado_civil = obj.getEstado_civil();
        int cpf_cnpj = obj.getCpf_cnpj();
        String cpf_or_cnpj = obj.getCpf_or_cnpj();
        int rg = obj.getRg();
        String celular = obj.getCelular();
        String tel_resi = obj.getTel_resi();
        String tel_comer = obj.getTel_comer();
        Double valor_credito = obj.getValor_credito();
        int cep = obj.getCep();
        String rua = obj.getRua();
        int numero = obj.getNumero();
        String bairro = obj.getBairro();
        String complem = obj.getComplem();
        String cidade = obj.getCidade();
        String estado = obj.getEstado();
        String referencia = obj.getReferencia();
        String foto = obj.getFoto();
        int bonus_acumulado = obj.getBonus_acumulado();
        String obs = obj.getObs();
        String email = obj.getEmail();
       
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "UPDATE clientes SET NOME = ?, "
                                                    + "DATA_NASC = ?, "
                                                    + "ESTADO_CIVIL = ?, "
                                                    + "APELIDO = ?, "
                                                    + "DOCUMENTO = ?, "
                                                    + "CPF_CNPJ = ?, "
                                                    + "CPF_OR_CNPJ = ?, "
                                                    + "CEP = ?, "
                                                    + "RUA = ?, "
                                                    + "NUMERO = ?, "
                                                    + "COMPLEMENTO = ?, "
                                                    + "BAIRRO = ?, "
                                                    + "CIDADE = ?, "
                                                    + "ESTADO = ?, "
                                                    + "REFERENCIA = ?, "
                                                    + "CELULAR = ?, "
                                                    + "TEL_RESI = ?, "
                                                    + "TEL_COMER = ?, "
                                                    + "VALOR_CREDITO = ?, "
                                                    + "FOTO = ?, "
                                                    + "BONUS_ACUMULADO = ?, "
                                                    + "OBS = ?, "
                                                    + "EMAIL = ? "
                                 + "WHERE NOME=? OR ID=?";
			
			PreparedStatement ppStm = con.prepareStatement(queryInserir);
			
                        ppStm.setString(1, nome);
			ppStm.setString(2, data_nasc);
                        ppStm.setString(3, estado_civil);
			ppStm.setString(4, apelido);
                        ppStm.setString(5, String.valueOf(rg));
                        ppStm.setString(6, String.valueOf(cpf_cnpj));
                        ppStm.setString(7, String.valueOf(cpf_or_cnpj));
                        ppStm.setString(8, String.valueOf(cep));
                        ppStm.setString(9, rua);
                        ppStm.setString(10, String.valueOf(numero));
                        ppStm.setString(11, complem);
                        ppStm.setString(12, bairro);
                        ppStm.setString(13, cidade);
                        ppStm.setString(14, estado);
                        ppStm.setString(15, referencia);
                        ppStm.setString(16, celular);
                        ppStm.setString(17, tel_resi);
                        ppStm.setString(18, tel_comer);
                        ppStm.setString(19, String.valueOf(valor_credito));
                        ppStm.setString(20, foto);
                        ppStm.setString(21, String.valueOf(bonus_acumulado));
			ppStm.setString(22, obs);
			ppStm.setString(23, email);
			ppStm.setString(24, nome);
			ppStm.setString(25, String.valueOf(id));
                        ppStm.execute();
                        
                        //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
                        
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do alterar dados Cliente: "+ex);
                        
        }
    }
    
    public int selecionarLastID(){
    BancoMySql objBanco = new BancoMySql();

    try {
        java.sql.Connection con = objBanco.obtemConexao();

        String querySelect = "select * from clientes WHERE ID > 0";

        PreparedStatement ppStm = con.prepareStatement(querySelect);
        ResultSet objRst = ppStm.executeQuery();
        objRst.last();
        System.out.println("THE LAST ID: "+objRst.getInt("ID"));
        return objRst.getInt("ID");
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "erro na execução do selecionar Cliente: "+ex);

    }
    return -1;
    }
     
     public void alterarSituation(int id, String nome,String newStatus){
        BancoMySql objBanco = new BancoMySql();
         
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "UPDATE clientes SET status = ? "
                                 + "WHERE nomeCli = ? AND id = ?";
			
			PreparedStatement ppStm = con.prepareStatement(queryInserir);
			
			ppStm.setString(1, newStatus);
			ppStm.setString(2, nome);
                        ppStm.setString(3, String.valueOf(id));
			
                        ppStm.execute();
                        
                        //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do alterar");
                        
        }
    }
     
    public void deletar(int id, String nome){
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "DELETE from clientes WHERE NOME=? OR ID=?";
		
            PreparedStatement ppStm = con.prepareStatement(queryInserir);
            ppStm.setString(1, nome);
            ppStm.setString(2, String.valueOf(id));
            ppStm.execute();
                        
           // JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do deletar");
        }
    }
    
    public ResultSet selecionarTodos(){
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "select * from clientes WHERE id > 0";
			
            PreparedStatement ppStm = con.prepareStatement(queryInserir);
			
            ResultSet objRst = ppStm.executeQuery();
           // JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            
            return objRst;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar"+ex);
        }
        return null;
    }

    public ResultSet selecionarCliente(String consultCli) {
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "select * from clientes WHERE (NOME LIKE ? OR ID = ?) AND id > 0";
			
            PreparedStatement ppStm = con.prepareStatement(queryInserir);
            ppStm.setString(1, consultCli+"%");
            ppStm.setString(2, consultCli);
            
            ResultSet objRst = ppStm.executeQuery();
            
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            
            return objRst;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar user DAO "+ex);
        }
        return null;
    }
    public ResultSet selecionarCli(String consultCli) {
        BancoMySql objBanco = new BancoMySql();
        //JOptionPane.showMessageDialog(null,consultCli);
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "select * from clientes WHERE (NOME = ? OR ID = ?) AND ID > 0";
			
            PreparedStatement ppStm = con.prepareStatement(queryInserir);
            ppStm.setString(1, consultCli);
            ppStm.setString(2, consultCli);
            
            ResultSet objRst = ppStm.executeQuery();
            
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            objRst.first();
            //JOptionPane.showMessageDialog(null,"--"+objRst.getInt("id"));
            return objRst;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar user DAO "+ex);
        }
        return null;
    }
    public String selecionarStatusUser(String consultCli) {
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "select status from clientes WHERE id = ?";
			
            PreparedStatement ppStm = con.prepareStatement(queryInserir);
            ppStm.setString(1, consultCli);
            
            ResultSet objRst = ppStm.executeQuery();
            
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            objRst.next();
            return objRst.getString("status");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do selecionar Status do user");
        }
        return null;
    }
    
    public boolean verificarUser(String parametro) {
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "select * from clientes WHERE (NOME = '"+parametro+"' OR ID = '"+parametro+"') AND ID > 0";
			
            PreparedStatement ppStm = con.prepareStatement(queryInserir);
            
            ResultSet objRst = ppStm.executeQuery();
            
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            return objRst.first();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do Verificar user "+ex);
        }
        return false;
    }
    
    public boolean verificarRgCpf(String rg, String cpf) {
        BancoMySql objBanco = new BancoMySql();
        
        try {
            Connection con = objBanco.obtemConexao();
            
            String queryInserir = "select * from clientes WHERE (DOCUMENTO = '"+rg+"' OR CPF_CNPJ = '"+cpf+"') AND ID > 0";
			
            PreparedStatement ppStm = con.prepareStatement(queryInserir);
            
            ResultSet objRst = ppStm.executeQuery();
            
            //JOptionPane.showMessageDialog(null, "Comando executado com sucesso");
            return objRst.first();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro na execução do Verificar dados "+ex);
        }
        return false;
    }
}

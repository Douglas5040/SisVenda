/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Adm
 */
public class BancoMySql {
    //pode também usar 'localhost' no URL
    public static final String IP = "127.0.0.1";
    private static final String URL = "jdbc:mysql://"+IP+"/bd_sistema_venda?zeroDateTimeBehavior=convertToNull";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Connection conn=null;
	public static Connection obtemConexao() throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		if(conn==null) conn = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);

                return conn;
		
	}
}


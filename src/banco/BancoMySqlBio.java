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
public class BancoMySqlBio {
    //pode também usar 'localhost' no URL
    private static final String URL = "jdbc:mysql://127.0.0.1/bio_usuario";
    private static final String USER = "root";
    private static final String PASSWORD = "";
	
	public static Connection obtemConexao() throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
		
	}
}


package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoDAO {
	static Connection conn = null;
	private static final String url = "jdbc:mysql://localhost:3306/exemplobd"; 
	private static final String usuario = "root";
	private static final String senha = "root!@#";
	
	public Connection getConnection() throws Exception{
		if (conn == null) {
			conn = DriverManager.getConnection(url, usuario, senha);
			return conn;
		} else {
			return conn;
		}
	}
}

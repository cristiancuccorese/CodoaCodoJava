package ar.com.codoacodo.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class AdministradorDeConexiones {

	public static Connection getConnection() {
		String hosts = "localhost";//localhost
		String port = "3306";
		String password = "root";
		String username = "root";
		
		//driver de conexion a la base de datos
		String driverClassName = "com.mysql.cj.jdbc.Driver";
		
		//nombre de la base de datos
		String dbName = "22569";
		
		//NO VOY A EXPLICAR TRY CATCH, SOLO LO VAMOS A USAR
		Connection connection = null;
		try {
			Class.forName(driverClassName);
			
			String url = "jdbc:mysql://" + hosts + ":"+ port +"/"+ dbName +"?serverTimeZone=UTC&useSSL=false";
			
			connection = DriverManager.getConnection(url, username, password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
}
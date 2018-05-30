package p5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleBaseDAO {
	
	private static final String DB_DRIV = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String DB_URL = "jdbc:sqlserver://localhost:1433;\" +  \r\n" + 
			"   \"databaseName=MSDAO;user=sa;password=admin;";
	private static Connection conn;
	
	protected Connection getConnection() throws SQLException {
		try {
			Class.forName(DB_DRIV).newInstance();
		} 
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		// Leg de connectie met de database
		conn = DriverManager.getConnection(DB_URL);
		System.out.println("Connection made");		
		return conn;
		//daarmee je ziet hoe ver je komt
	}
	
	public void closeConnection() throws SQLException {
		conn.close();
	}
}

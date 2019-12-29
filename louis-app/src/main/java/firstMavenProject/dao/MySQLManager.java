package firstMavenProject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLManager {
	private Statement statement = null;
	private Connection connection = null;
	private String url = "jdbc:mysql://localhost:3306/blog_java?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
	private String utilisateur = "root";
	private String motDePasse = "";
	private static MySQLManager instance;
	
	private MySQLManager() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connection = DriverManager.getConnection(url, utilisateur, motDePasse);
			this.statement = this.connection.createStatement();
		}catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static synchronized MySQLManager getInstance() {
		if(instance == null) {
			instance = new MySQLManager();
		}
			return instance;
	}
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
			if(connection != null) {
				try {
					connection.close();
				}catch(SQLException e) {
					//A G�rer
				}
			}
	}

	public Connection getConnection() {
		// TODO Auto-generated method stub
		return connection;
	}
}

package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnect {

	static final String driver = "com.mysql.cj.jdbc.Driver";
	static final String url = "jdbc:mysql://localhost:3306/mini_project";
	static final String user = "root";
	static final String password = "zxcvbnm";

	public static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);

		} catch (SQLException e)

		{
			e.printStackTrace();
		}
		return con;
	}
}

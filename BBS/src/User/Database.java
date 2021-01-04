package User;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	private Connection conn;

	private static Database instance = new Database();

	public static Database getInstance() {
		return instance;
	}

	public Database() {
		try {
			String dbURL = "jdbc:mysql://localhost:3307/bbs?uniCode=true&serverTimezone=UTC";
			String dbID = "root";
			String dbPassword = "1111";
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		} catch (Exception e) {

		}

	}

	public Connection getConn() {
		return conn;
	}
}

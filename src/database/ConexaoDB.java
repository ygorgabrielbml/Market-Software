package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoDB {
	private static ConexaoDB INSTANCE = null;

	private Connection connection = null;

	private ConexaoDB() {
		try {
			connection = DriverManager.getConnection(
					"jdbc:sqlite:C:////Users////rique////eclipse-workspace///marketSoftware/database.db");
		} catch (SQLException e) {
			System.err.println("houve um erro");
			e.printStackTrace();
		}
	}

	public static ConexaoDB getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ConexaoDB();
		}
		return INSTANCE;
	}

	public Connection getConnection() {
		return this.connection;
	}

	public void closeConnection() {
		try {
			this.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

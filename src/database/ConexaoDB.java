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
                "jdbc:sqlite:C:/Users/rique/eclipse-workspace/marketSoftware/database.db");
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados.");
            e.printStackTrace();
        }
    }

    public static ConexaoDB getInstance() {
        if (INSTANCE == null || INSTANCE.connection == null) {
            INSTANCE = new ConexaoDB();
        } else {
            try {
                if (INSTANCE.connection.isClosed()) {
                    INSTANCE = new ConexaoDB();
                }
            } catch (SQLException e) {
                System.err.println("Erro ao verificar o estado da conexão.");
                e.printStackTrace();
            }
        }
        return INSTANCE;
    }

    public Connection getConnection() {
        return this.connection;
    }

    public void closeConnection() {
        try {
            if (this.connection != null && !this.connection.isClosed()) {
                this.connection.close();
                INSTANCE = null;  
            }
        } catch (SQLException e) {
            System.err.println("Erro ao fechar a conexão com o banco de dados.");
            e.printStackTrace();
        }
    }
}

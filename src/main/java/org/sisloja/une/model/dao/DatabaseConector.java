package org.sisloja.une.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DatabaseConector {
	
	//unica instancia
	private static DatabaseConector instance;
	private Connection connection;
    private String url = "jdbc:hsqldb:file:./db";
    private String username = "admin";
    private String password = "admin";

    private DatabaseConector() throws SQLException {
        try {
        	Class.forName("org.hsqldb.jdbcDriver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Conexão falhou: " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DatabaseConector getInstance() {
    	try {
	        if (instance == null) {
	            instance = new DatabaseConector();
	        } else if (instance.getConnection().isClosed()) {
	            instance = new DatabaseConector();
	        }
    	}catch(SQLException e) {
    		e.printStackTrace();
    		
    	}

        return instance;
    }

	
	public static void main(String[] args) {
		Connection connection = DatabaseConector.getInstance().getConnection();
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

package org.sisloja.une.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DatabaseConector {
	
	//unica instancia
	private static DatabaseConector instance;
	private Connection connection;

    private DatabaseConector() throws SQLException {
    	try {
			Class.forName("org.h2.Driver");
        connection = DriverManager.getConnection("jdbc:h2:./storage/db");
        System.out.println("*");
    	} catch (ClassNotFoundException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
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
		

	}

}

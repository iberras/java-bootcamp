package com.sql.topic5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	private Connection connection;
	private static ConnectionManager instance = new ConnectionManager();
	
	private ConnectionManager(){}
	
	public static ConnectionManager getInstance(){
		return instance;
	}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		String driverName = "org.gjt.mm.mysql.Driver";
	    Class.forName(driverName);

	    String serverName = "localhost";
	    String mydatabase = "";
	    String url = "jdbc:mysql://" + serverName + "/" + mydatabase; 

	    String username = "root";
	    String password = "";
	    connection = DriverManager.getConnection(url, username, password);
	    return connection;
	}
	
	public void closeConnection() throws SQLException {
		connection.close();
	}
	
	public void loadFile(String path) throws Exception {
		ScriptRunner runner = new ScriptRunner(connection, false, true);
		runner.runScript(new BufferedReader(new FileReader(path)));
	}
}

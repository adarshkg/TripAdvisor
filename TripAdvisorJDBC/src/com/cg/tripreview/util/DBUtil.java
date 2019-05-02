package com.cg.tripreview.util;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.cg.tripreview.exceptions.DestinationDetailNotFoundException;

public class DBUtil {
	
	static Connection conn;
	

	public static Connection getConnetcion() throws DestinationDetailNotFoundException {
		Properties prop = new Properties();
		FileInputStream it;
		try {
			it = new FileInputStream("resources/jdbc.properties");
			prop.load(it);

				if(prop!=null) {
							String driver = prop.getProperty("jdbc.driver");
							String url = prop.getProperty("jdbc.url");
							String uname = prop.getProperty("jdbc.username");
							String pass  =prop.getProperty("jdbc.password");
							Class.forName(driver);
							conn = DriverManager.getConnection(url, uname, pass);
				}

		}catch (IOException|ClassNotFoundException|SQLException e) {
			
			
			throw new DestinationDetailNotFoundException("Connection not established");
		}
		
		return conn;
		
	}
}

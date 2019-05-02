package com.cg.employee.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.cg.employee.exception.EmployeeException;

public class DBUtil {
	
	static Connection conn;
	

	public static Connection getConnetcion() throws EmployeeException {
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
			
			e.printStackTrace();
			throw new EmployeeException("Connection not established");
		}
		
		return conn;
		
	}
}

package com.icss.oa.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

/**
 * ���ݿ⹤����
 * @author Administrator
 *
 */
public class DBConnection {

	/**
	 * �������ݿ�����
	 * @return
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException {
		
		DriverManager.registerDriver(new OracleDriver());
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		//TODO
		String user = "scott";
		String password = "tiger";
		
		Connection conn = DriverManager.getConnection(url, user, password);
		
		return conn;		
	}
		
}

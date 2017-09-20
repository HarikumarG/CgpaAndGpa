package com.hari.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class OracleConnections {
	public Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName(ProjectConstants.DRIVER_STRING);
		Connection con=DriverManager.getConnection(ProjectConstants.CONNECTION_STRING,ProjectConstants.USER_NAME,ProjectConstants.PASSWORD);
		return con;
	}
}

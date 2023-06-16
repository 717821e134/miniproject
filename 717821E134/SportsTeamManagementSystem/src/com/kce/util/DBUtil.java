package com.kce.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static Connection getConnection() throws SQLException {
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/sportsteamManagement","root","Vihaan@19");
		return con;
}
}
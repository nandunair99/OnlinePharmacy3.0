package com.narola.pharmacy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author nnandakrishnan
 * 
 *         this file is used to initate Database Connection
 */

public class PharmacyDBConnection {

	public static Connection con;

	public static Connection getConnection() throws PharmacyDBException {
		try {
			if (con == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/narola", "root", "root");
			}
		} catch (ClassNotFoundException ex) {
			throw new PharmacyDBException("Error while connecting DB" + ex);
		} catch (SQLException ex) {
			throw new PharmacyDBException("Error while connecting DB" + ex);
		}

		return con;
	}

	public static void releaseResource(PreparedStatement preparedStatement) {
		releaseResource(preparedStatement, null, null);
	}

	public static void releaseResource(Statement statement) {
		releaseResource(null, null, statement);
	}

	public static void releaseResource(Statement statement, ResultSet resultSet) {
		releaseResource(null, resultSet, statement);
	}

	public static void releaseResource(PreparedStatement pstatement, ResultSet resultSet) {
		releaseResource(pstatement, resultSet, null);
	}

	public static void releaseResource(PreparedStatement preparedStatement, ResultSet resultSet, Statement statement) {
		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}

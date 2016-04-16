package com.sjsu.login.service.impl;

import com.sjsu.dao.login.LoginDAO;
import com.sjsu.login.service.ILoginService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class LoginServiceImpl implements ILoginService {

	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/CMPE281";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";
	
	@Override
	public boolean authenticate() {
		// TODO Auto-generated method stub
		
		
		
		return false;
	}

	@Override
	public boolean createUser() {
		// TODO Auto-generated method stub
		String user="admin";
		String password="admin";
		LoginDAO req = new LoginDAO();
		req.setName(user);
		req.setPassword(password);
		try {
			insertRecordIntoDbUserTable(req);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	private static Connection getDBConnection() {

		Connection dbConnection = null;

		try {

			Class.forName(DB_DRIVER);

		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage());

		}

		try {

			dbConnection = DriverManager.getConnection(
                               DB_CONNECTION, DB_USER,DB_PASSWORD);
			return dbConnection;

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		return dbConnection;

	}
	
	
	
	public static void insertRecordIntoDbUserTable(LoginDAO clientResDetails) throws SQLException {

		Connection dbConnection = null;
		Statement statement = null;
		

		/*String insertTableSQL = "INSERT INTO CLIENT_REGISTRATION_DETAILS"
				+ "(bootStrapID,manufacture_no,version_no, model_no, ClientID) " + "VALUES"
				+ "("+ clientResDetails.getBootStrapID() + ",'"+ clientResDetails.getManufactureNo() +"','" +clientResDetails.getVersionNo()+"','" +clientResDetails.getModelNo()+"'," +clientResDetails.getClientID()+")";
		*/
		String insertTableSQL = "Insert into login (name, password) values (\""+ clientResDetails.getName() +"\",\"" + clientResDetails.getPassword() +"\")";
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();

			System.out.println(insertTableSQL);

			// execute insert SQL statement
			statement.executeUpdate(insertTableSQL);
			
			
			System.out.println("");
			System.out.println("============================================================================================");
			System.out.println("============Data Successfully inserted at Client for CLIENT_BOOTSTRAP_INFO =================  ");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (statement != null) {
				statement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}


}

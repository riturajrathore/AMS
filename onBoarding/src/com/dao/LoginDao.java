package com.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.sql.Connection;

public class LoginDao {
	public PreparedStatement runQuery(String queryStatement) {
		PreparedStatement preparedState=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onboard", "root","shriganesh-01");
			preparedState = con.prepareStatement(queryStatement);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return preparedState;

	}
	public HashMap<String, String> getUserDetailDao(String uid)
	{
		HashMap<String, String> userDetails = new HashMap<String, String>();
		String queryStatement = "select user_id,user_password from user_credentials where user_id ='"+uid+"'";
		System.out.println(" i am here ");
		PreparedStatement query =  this.runQuery(queryStatement);
		ResultSet resultSet;
		try {
			resultSet = query.executeQuery();
			while(resultSet.next())
			{
				System.out.println(resultSet.getString("user_id") + "  " + resultSet.getString("user_password"));
				userDetails.put(resultSet.getString("user_id"), resultSet.getString("user_password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userDetails;
	}
}

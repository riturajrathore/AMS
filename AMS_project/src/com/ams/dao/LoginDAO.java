package com.ams.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ams.exceptions.AMSException;
import com.ams.vo.LoginVO;
public class LoginDAO 
{
	public String loginUser(LoginVO loginVo) throws AMSException  
	{
		String userNameDB = "";
		String url="jdbc:mysql://localhost:3306/AMS_DB";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,"root","shriganesh-01");
			PreparedStatement pstmt=con.prepareStatement("select User_name from admin_info where User_name= ? ");
			pstmt.setString(1, loginVo.getLoginName());
			ResultSet rst=pstmt.executeQuery();
			if(rst.next())
			{
				userNameDB = rst.getString(1);

			}
		}
		catch(ClassNotFoundException ex)
		{
			throw new AMSException(ex.getMessage());
		}
		catch(SQLException ex)
		{
			throw new AMSException(ex.getMessage());
		}
		return userNameDB;
	}
	public String loginPassword(LoginVO loginVo) throws AMSException  
	{
		String passwordDB = "";
		String url="jdbc:mysql://localhost:3306/AMS_DB";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,"root","shriganesh-01");
			PreparedStatement pstmt=con.prepareStatement("select passwd from admin_info where User_name = ?");
			pstmt.setString(1, loginVo.getLoginName());
			ResultSet rst=pstmt.executeQuery();
			if(rst.next())
			{
				 passwordDB = rst.getString(1);
				
			}
		}
		catch(ClassNotFoundException ex)
		{
			throw new AMSException(ex.getMessage());
		}
		catch(SQLException ex)
		{
			throw new AMSException(ex.getMessage());
		}
		return passwordDB;
	}
}

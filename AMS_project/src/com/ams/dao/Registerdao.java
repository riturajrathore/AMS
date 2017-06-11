package com.ams.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.ams.exceptions.AMSException;

import com.ams.vo.Registervo;
import com.mysql.jdbc.Statement;

public class Registerdao 
{
	private Connection createConn()
	{
	boolean res=false;
	String url="jdbc:mysql://localhost:3306/AMS_DB";
	
	Connection con = null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url,"root","shriganesh-01");			
		} 
		
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public HashMap<String,String> registerUser(Registervo regvo) throws AMSException  
	{
		HashMap dataforuser=new HashMap();
		
		String url="jdbc:mysql://localhost:3306/ams_db";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,"root","shriganesh-01");
			PreparedStatement pstmt1=con.prepareStatement("select t.first_name,r.occupied_date,r.adv_paid,f.flat_no,type_id,b.block_name,f.floor_no from flat_master f,tenant_info t,register_info r, block b where t.tenant_id=r.tenant_id and r.flat_id=f.flat_id and f.block_id=b.block_id and r.tenant_id= ?");		
			pstmt1.setString(1, regvo.getLoginName());
			ResultSet rst1=pstmt1.executeQuery();
			if(rst1.next())
			{
				dataforuser.put("name", rst1.getString(1));
				dataforuser.put("occupiedOn", rst1.getString(2));
				dataforuser.put("paidAdvance", rst1.getString(3));
				dataforuser.put("flatNo", rst1.getString(4));
				dataforuser.put("flatType", rst1.getString(5));
				dataforuser.put("block", rst1.getString(6));
				dataforuser.put("floor", rst1.getString(7));

				
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
		return dataforuser;
	}
	public float getData(String query,String date,Registervo regvo) throws SQLException
	{
		Connection con = createConn();
		PreparedStatement pstmt1=con.prepareStatement(query);
		pstmt1.setString(1, regvo.getLoginName());
		pstmt1.setString(2, date);
		ResultSet rest=pstmt1.executeQuery();	
		float rent=0;
		if(rest.next())
		{
			rent = rest.getInt(1);
		}
		return rent;
	}

	public String getDateOfPay(String query1, Registervo regv) throws SQLException
	{
		// TODO Auto-generated method stub
		Connection con = createConn();
		PreparedStatement pstmt1=con.prepareStatement(query1);
		pstmt1.setString(1, regv.getLoginName());
		ResultSet rest=pstmt1.executeQuery();	
		String dateOfpay="";
		if(rest.next())
		{
			dateOfpay = rest.getString(1);
		}
		
		
		return dateOfpay;
	}

	
	
}

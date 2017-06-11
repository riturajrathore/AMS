package com.ams.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.ams.bo.TenantRegisterBO;
import com.ams.exceptions.AMSBusinessException;
import com.ams.exceptions.AMSException;
import com.ams.vo.TenantRegisterVO;
public class TenantRegisterDao 
{


	 public ResultSet accessData(String query)
		{
				Connection con = createConn();
				java.sql.Statement st;
				java.sql.ResultSet rest = null;
				try 
				{
					st = con.createStatement();
					rest =  st.executeQuery(query);
					
				} 		
				catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return rest;	
		}

	 	 
	 /*------------------------------------------------------------------------------------*/
	 
	 
	 private Connection createConn()
		{

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
	 
	 /*------------------------------------------------------------------------------*/
	
	 
	 public boolean registerTenant(TenantRegisterVO regVO) throws AMSException, AMSBusinessException
	{
		boolean res=false;	
		String url="jdbc:mysql://localhost:3306/AMS_DB";	
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection(url,"root","shriganesh-01");
	PreparedStatement ps=con.prepareStatement("insert into tenant_info values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
	TenantRegisterBO registerBo = new TenantRegisterBO();	
	//String op=registerBo.TenantID(regVO);
	String tenant_Id = registerBo.TenantID(regVO);
	ps.setString(1, tenant_Id);
	ps.setString(2, regVO.getFirstName());
	ps.setString(3, regVO.getLastName());
	int agec=registerBo.calulateAge(regVO);
	ps.setInt(4, agec);
	ps.setString(5, regVO.getGender());
	ps.setInt(6, regVO.getFamilyMembers());
	ps.setString(7, regVO.getNativePlace());
	ps.setString(8, regVO.getContact());
	ps.setString(9, regVO.getIncomeSource());
	ps.setString(11, regVO.getIdProof());
	ps.setString(10, regVO.getDurofstay());
	ps.setString(12,regVO.getAgrStartDate());
	ps.setString(13,regVO.getAgrEndDate());	
	int out=ps.executeUpdate();
	
	//update registerInfo table
	String queryTogetAdv = "select advance_amt from flat_master where flat_id='"+regVO.getFlatId()+"'";
	ResultSet advanceSet = accessData(queryTogetAdv);
	float totalAdvance=0;
	if(advanceSet.next())
	{
		totalAdvance=advanceSet.getFloat(1);
	}
	
	ps=con.prepareStatement("insert into register_info values(?,?,?,?,?)");	
	ps.setString(1, regVO.getFlatId());
	ps.setString(2, tenant_Id);
	ps.setFloat(3, regVO.getAdvancePaid());
	float balance = totalAdvance-regVO.getAdvancePaid();
	ps.setFloat(4, balance);
	ps.setString(5, regVO.getAgrStartDate());
	int output=ps.executeUpdate();
	int output1=0;
	if(output>0)
	{
	//change the status of flat table to occupied
	String query ="UPDATE flat_master SET status = 'occupied' WHERE flat_id= '" +regVO.getFlatId()+"'";
	java.sql.Statement updateQ  = con.createStatement();
	output1 = updateQ.executeUpdate(query);
	}
	/*----------------------------------------------------------------------------------*/
	

	if(out>0 && output1>0)
	{
		res=true;
	}
		}
		catch (ClassNotFoundException ex) {
			throw new AMSException(ex.getMessage());
		
		}
		catch (SQLException e) {
			throw new AMSBusinessException(e.getMessage());
		}
	return res;
				
	}
}

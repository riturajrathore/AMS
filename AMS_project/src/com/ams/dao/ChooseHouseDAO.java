package com.ams.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ams.bo.TenantRegisterBO;
import com.ams.exceptions.AMSBusinessException;
import com.ams.exceptions.AMSException;
import com.ams.vo.ChooseHouseVO;
import com.ams.vo.TenantRegisterVO;

public class ChooseHouseDAO 
{
	public  String flatAllocat;
	public String searchFlat(ChooseHouseVO chHouseVO) throws AMSException
	{
		String url="jdbc:mysql://localhost:3306/AMS_DB";	
		try {
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection(url,"root","shriganesh-01");
				PreparedStatement ps=con.prepareStatement("select flat_id from flat_master where type_id= ? and rent <= ? and status='vacant'");
				ps.setString(1, chHouseVO.getFlattype());
				ps.setFloat(2, chHouseVO.getRent());
				ResultSet out=ps.executeQuery();
				if(out.next())
				{
					System.out.println("val"+ out.getString(1));
					flatAllocat = out.getString(1);	
					return flatAllocat;
				}
				
			
			}
			catch (ClassNotFoundException ex) {
				throw new AMSException("Error in Class not found Exception in chooseHouseDao"+ex.getMessage());
			
			}
			catch (SQLException e) {
				throw new AMSException("Sql exception in ChooseHouseDao "+e.getMessage() + e.getSQLState());
			}
		return flatAllocat;

		}
	
		
}

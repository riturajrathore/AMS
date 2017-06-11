package com.ams.dao;
import java.sql.*;
import com.ams.bo.FlatRegisterBO;
import com.ams.exceptions.AMSBusinessException;
import com.ams.exceptions.AMSException;
import com.ams.vo.FlatRegisterVO;

public class FlatRegisterDAO 
{
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
	public boolean register(FlatRegisterVO flatRegVo) throws AMSException, AMSBusinessException
	{
		boolean res=false;
		try
		{
			FlatRegisterBO flatRegBo = new FlatRegisterBO();
			String blockId = flatRegBo.generateBlockId(flatRegVo); 						//generate blockId by calling private method generateBlockId
			Connection con = createConn();												//get the connection to database
			PreparedStatement ps=con.prepareStatement("insert into block values(?,?,?,?)");
			ps.setString(1,blockId);	
			ps.setString(2,flatRegVo.getBlockName());
			ps.setInt(3, flatRegVo.getTotalFloors());
			ps.setInt(4, flatRegVo.getTotalFlats());
			int out1=ps.executeUpdate();												//update data in block table of database
			/*-------------------------------------------------------------------------------------------------------------------------*/
			
			String ownerId = flatRegBo.generateOwnerId(flatRegVo);						//get ownerId by using private method generateOwnerId		
			java.sql.Statement stForProof =  con.createStatement();
			java.sql.ResultSet restForProof =  stForProof.executeQuery("select Proof_id from proof_master where PROOF_DESCRIPTION ='"+flatRegVo.getProof()+"'");
			String proof_id = "";
			if(restForProof.next())
			{
			proof_id = restForProof.getString(1);
			}	
			ps=con.prepareStatement("insert into owner values(?,?,?,?,?)");
			ps.setString(1,ownerId);
			ps.setString(2,flatRegVo.getOwnerName());
			ps.setString(3,flatRegVo.getContact());
			ps.setString(4,proof_id);
			ps.setString(5, flatRegVo.getAddress());
			int out2=ps.executeUpdate();												//update owner data to owner table
			
			/*-------------------------------------------------------------------------------------------------------------------------*/			

			String flatId = flatRegBo.generateFlatId(flatRegVo,blockId);
			boolean isFlatIdNotExist = flatRegBo.isFlatExist(flatId);
			if(isFlatIdNotExist)
			{
			ps=con.prepareStatement("insert into flat_master values(?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1,flatId);
			ps.setString(2,flatRegVo.getFlatTypeId());
			ps.setString(3, flatRegVo.getFlatCategory());
			ps.setString(4,blockId);
			ps.setInt(5,Integer.parseInt(flatRegVo.getFloorNo()));
			ps.setInt(6,Integer.parseInt(flatRegVo.getFlatNo()));	
			ps.setFloat(7,Float.valueOf(flatRegVo.getRent()));
			float advanc_amt =  flatRegBo.calculateAdvance(flatRegVo);	                    //To calculate Advance amount use calculateAdvance of FlatRegisterBO
			ps.setFloat(8, advanc_amt);
			ps.setString(9, flatRegVo.getStatus());
			ps.setString(10,flatRegVo.getAddress());
			ps.setInt(11,Integer.parseInt(flatRegVo.getYearOfConst()));
			ps.setString(12,ownerId);
			int out=ps.executeUpdate();    													//flat register executed
			

			float electricityBill = new FlatRegisterBO().electricityCharge(flatRegVo);																				//to update the Maintenance charge
			float maintCharge = flatRegBo.getMaintenanceCharge(flatRegVo.getFlatTypeId());	//getMaintenanceCharge from FlatRegisterBO
			int output3 = updateMaintenance(flatId,maintCharge,electricityBill);											//update in database
			
				if(out1>0 && out2>0 && out>0 && output3>0)
				{
					res=true;
				}
				else
				{
					res=false;
				}
			
			}
			else
			{
				throw new AMSBusinessException("Flat already Registered");
			}
			
		}
		catch(SQLException e) 
		{
			throw new AMSException(e.getMessage());
		}	
		
		
		return res;
	}
	
	public ResultSet accessData(String column,String table)
	{
			Connection con = createConn();
			java.sql.Statement st;
			java.sql.ResultSet rest = null;
			try 
			{
				st = con.createStatement();
				rest =  st.executeQuery("select "+column+" from "+table);
				
			} 
			
			catch (SQLException e)
			{
				
				e.printStackTrace();
			}
		return rest;	
	}

	public int updateMaintenance(String flatId,float maintenanceCharge,float electricityBill)
	{
		int output=0;
		Connection con = createConn();
		PreparedStatement ps;
		try
		{
		ps=con.prepareStatement("insert into maintenance values(?,?,?)");
		ps.setString(1,flatId);
		ps.setFloat(2,maintenanceCharge);
		ps.setFloat(3, electricityBill);
		output = ps.executeUpdate();
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output;
	}
	
}





package com.ams.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ams.exceptions.AMSException;
import com.ams.vo.ApartmentVO;
import com.ams.vo.SearchApartmentVO;

public class SearchApartmentDAO 
{
	public static List<ApartmentVO> searchApartment(SearchApartmentVO searchVO) throws AMSException
	{
		
		List<ApartmentVO> AVO = new ArrayList<ApartmentVO>();
		
		String url="jdbc:mysql://localhost:3306/ams_db";
		StringBuilder query = new StringBuilder();
		try
		{
		Class.forName("com.mysql.jdbc.Driver");	
		Connection con=DriverManager.getConnection(url,"root","shriganesh-01"); 
		if(searchVO.getFlatType().equals("1B"))
		{
			query = new StringBuilder("select a.flat_id,b.block_name,a.floor_no,a.flat_no,if(a.type_id='1B','1BHK','2BHK') type,a.rent,a.advance_amt,a.year_of_construction," +
					"o.owner_name, o.contact,a.flat_category from " +
					"flat_master a, block b, owner o where (a.owner_id=o.owner_id and a.block_id=b.block_id " +
					" and a.type_id='1B' and a.status='vacant' and a.rent between ? and ? and a.advance_amt between ? and ? and a.flat_category=? ");
			//"select * from flat_master where (type_id='1B' and status='vacant' and rent between ? and ? and advance_amt between ? and ? ");	
		}
		else if(searchVO.getFlatType().equals("2B"))
		{
			query = new StringBuilder("select a.flat_id,b.block_name,a.floor_no,a.flat_no,if(a.type_id='1B','1BHK','2BHK') type,a.rent,a.advance_amt,a.year_of_construction," +
					"o.owner_name, o.contact,a.flat_category from " +
					"flat_master a, block b, owner o where (a.owner_id=o.owner_id and a.block_id=b.block_id " +
					" and a.type_id='2B' and a.status='vacant' and a.rent between ? and ? and a.advance_amt between ? and ? and a.flat_category=? ");
		}
		else if(searchVO.getFlatType().equalsIgnoreCase("none"))
		{
			query = new StringBuilder("select a.flat_id,b.block_name,a.floor_no,a.flat_no,if(a.type_id='1B','1BHK','2BHK') type,a.rent,a.advance_amt,a.year_of_construction," +
					"o.owner_name, o.contact,a.flat_category from " +
					"flat_master a, block b, owner o where (a.owner_id=o.owner_id and a.block_id=b.block_id " +
					" and a.status='vacant' and a.rent between ? and ? and a.advance_amt between ? and ? and a.flat_category=? ");
		}
		
	
		//Following if's to get query parameters based on user selection
		if(searchVO.getBlockID().length ==1)
		{
		    query.append("and a.block_id like ?)"); 
		}
		else if(searchVO.getBlockID().length ==2)
		{
			query.append("and (a.block_id like ? or a.block_id like ?))");
		}
		else if(searchVO.getBlockID().length==3)
		{
			query.append("and (a.block_id like ? or a.block_id like ? or a.block_id like ?))");
		}	
		else
			query.append(")");
		
		//System.out.println(query.toString());
		
		//Setting values for the query based on user requirements
		
		PreparedStatement prepStatement=con.prepareStatement(query.toString());
		prepStatement.setInt(1, searchVO.getMinimumRent());
		prepStatement.setInt(2, searchVO.getMaximumRent());
		prepStatement.setInt(3, searchVO.getMinimumAdvance());
		prepStatement.setInt(4, searchVO.getMaximumAdvance());
		prepStatement.setString(5, searchVO.getFlatCategory());
	
			switch (searchVO.getBlockID().length)
			{	
			  case 3:prepStatement.setString(8, searchVO.getBlockID()[2]+'%');
			  case 2:prepStatement.setString(7, searchVO.getBlockID()[1]+'%');
			  case 1:prepStatement.setString(6, searchVO.getBlockID()[0]+'%');
			  default: break;
			}
			
		
		//System.out.println(prepStatement);
		ResultSet result=prepStatement.executeQuery();
		
		if(result.next()==true)
		{result.previous();
		//System.out.println("inside result");
		while(result.next())
		{
			ApartmentVO temporary=new ApartmentVO();
			 temporary.setFlat_id(result.getString(1));
			 temporary.setBlock_name(result.getString(2));
			 temporary.setFloor_no(result.getInt(3));
			 temporary.setFlat_no(result.getInt(4));
			 temporary.setType(result.getString(5));
			 temporary.setRent(result.getDouble(6));
			 temporary.setAdvance_amt(result.getDouble(7));
			 temporary.setYear_of_construction(result.getInt(8));
			 temporary.setOwner_name(result.getString(9));
			 temporary.setOwner_contact(result.getString(10));
			 temporary.setFlatCategory(result.getString(11));
		 			 
			 AVO.add(temporary); 
		}}
		else
		{
			ApartmentVO temporary=new ApartmentVO();
			 temporary.setNoResults(true);
			 AVO.add(temporary);
		}
		

//		result.close();
		prepStatement.close();
		con.close();
		
		}
			catch (ClassNotFoundException ex) {
				throw new AMSException(ex.getMessage());
			
			}
			catch (SQLException e) {
				throw new AMSException(e.getMessage());
			}	
			
				
			return AVO;
	}

}

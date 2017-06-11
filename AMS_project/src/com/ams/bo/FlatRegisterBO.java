package com.ams.bo;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import com.ams.dao.FlatRegisterDAO;
import com.ams.exceptions.AMSBusinessException;
import com.ams.exceptions.AMSException;
import com.ams.vo.FlatRegisterVO;
public class FlatRegisterBO 
{


	public boolean validateReg(FlatRegisterVO flatRegVo) throws AMSBusinessException, AMSException
	{
		
		if(flatRegVo.getOwnerName().length()==0)
		{
			throw new AMSBusinessException("Name field cannot be empty.....!!");
		}
		if(flatRegVo.getOwnerName().length()>20)
		{
			throw new AMSBusinessException("Name entered is too long.....!!");
		}
		if(!flatRegVo.getOwnerName().matches("^[a-zA-Z ]*$"))
		{
			throw new AMSBusinessException("Only alphabets are allowed in Name field.....!!");
		}
		/*-------------------------------------------------------------------------------------------------------------------------*/			
		if(flatRegVo.getContact().isEmpty())
		{
			throw new AMSBusinessException("Contact field cannot be empty.....!!");
		}
		if(!flatRegVo.getContact().matches("[0-9]{10}"))
		{
			throw new AMSBusinessException("Invalid contact.....!!");
		}
		/*-------------------------------------------------------------------------------------------------------------------------*/
		Date todayDate = new Date();
		Calendar calendr = Calendar.getInstance();
		calendr.setTime(todayDate);
		int year = calendr.get(Calendar.YEAR);
		
		if(Integer.parseInt(flatRegVo.getYearOfConst())<1900 || Integer.parseInt(flatRegVo.getYearOfConst())>year)
		{
			throw new AMSBusinessException("Invalid year......!!");
		}
		if(flatRegVo.getYearOfConst().length()!=4)
		{
			throw new AMSBusinessException("Invalid year. Please Enter year in YYYY format.....!!");
		}
		if(!flatRegVo.getYearOfConst().matches("^[0-9]*$"))
		{
			throw new AMSBusinessException("Year field can accept numbers only.....!!");
		}
		/*-------------------------------------------------------------------------------------------------------------------------*/	
		if(flatRegVo.getRent().isEmpty())
		{
			throw new AMSBusinessException("Please Enter the Rent.....!!");
		}
		if(Float.valueOf(flatRegVo.getRent())<0)
		{
			throw new AMSBusinessException("Please Enter the positive value in Rent.....!!");
		}
		if(flatRegVo.getRent().length()>9)
		{
			throw new AMSBusinessException("Rent Entered is to long.....!!");
		}
		if(!flatRegVo.getRent().matches("^[0-9]*.[0-9]{1,2}$"))
		{
			throw new AMSBusinessException("Flat rent can be upto 2 decimal place.....!!");
		}
		/*-------------------------------------------------------------------------------------------------------------------------*/	
		
		if(flatRegVo.getAdvancInMonth().isEmpty())
		{
			throw new AMSBusinessException("Please Enter data in Advance.....!!");
		}
		if(!valAdvancEntry(flatRegVo))
		{
			throw new AMSBusinessException("wrong entry in Advance entry (<b>Note:<b> advance should be betwqeen 2 to 12 months ).....!!");
		}
		/*-------------------------------------------------------------------------------------------------------------------------*/	
		if(flatRegVo.getAddress().isEmpty())
		{
			throw new AMSBusinessException("Please Enter Address .....!!");
		}
		if(flatRegVo.getAddress().length()>150)
		{
			throw new AMSBusinessException("Address entered is too long.....!!");
		}
		if(!flatRegVo.getAddress().matches("[ a-zA-Z0-9 ]*$"))
		{
			throw new AMSBusinessException("Wrong format..! Address can be alphanumeric or space only (Even Don't Hit ENTER).....!!");			
		}
		/*-------------------------------------------------------------------------------------------------------------------------*/		
		if(flatRegVo.getStatus().isEmpty())
		{
			throw new AMSBusinessException("Please Enter the status of flat (occupied/vacant).....!!");
		}
		
		if(!flatRegVo.getStatus().matches("^[a-zA-Z]*$"))
		{
			throw new AMSBusinessException("Only alphabet is allowed in the Status.....!!");
		}
		/*-------------------------------------------------------------------------------------------------------------------------*/	
		flatRegVo.setTotalFloors(12); 													//set total number of floors
		flatRegVo.setTotalFlats(15);													//set total number of flats
		/*-------------------------------------------------------------------------------------------------------------------------*/	
		
		return new FlatRegisterDAO().register(flatRegVo);		                        //call to register method of RegisterDAO						

	}
	/*-------------------------------------------------------------------------------------------------------------------------*/			

	public String generateBlockId(FlatRegisterVO flatRegVo) throws AMSException
	{
		FlatRegisterDAO flatRegDao = new FlatRegisterDAO();
		String blockId="B";	
		java.sql.ResultSet rest;
		try {
				rest = flatRegDao.accessData("block_id","block");
				String temp="";	
				int maxID=0;
				while(rest.next())
				{

					temp = rest.getString(1);
					
					int lastBlockIdUniqueNo = Integer.parseInt(temp.substring(2));
					if(lastBlockIdUniqueNo>maxID)
					{
						maxID=lastBlockIdUniqueNo;
					}
				}
				if(temp.isEmpty())
				{
					blockId=blockId+flatRegVo.getBlockName().toUpperCase().charAt(0)+01;
				
				}
				else
				{
					blockId= blockId+flatRegVo.getBlockName().toUpperCase().charAt(0)+(maxID+1);
				}
			}
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return blockId;
	}
	/*-------------------------------------------------------------------------------------------------------------------------*/	
	public String generateOwnerId(FlatRegisterVO flatRegVo)throws AMSException
	{
		FlatRegisterDAO flatRegDao = new FlatRegisterDAO();
		String ownerId="OW";
		java.sql.ResultSet rest;
		try {
				rest = flatRegDao.accessData("owner_id","owner");
				String temp="";	
				int maxId=0;
				while(rest.next())
				{
					temp = rest.getString(1);
					int lastSeq = Integer.parseInt(temp.substring(4));				
					if(lastSeq>maxId)
					{
						maxId=lastSeq;
					}
				}
				if(temp.isEmpty())
				{
					ownerId=ownerId+(flatRegVo.getOwnerName().substring(0, 2))+01;
				}
				else
				{
					
					ownerId= ownerId+(flatRegVo.getOwnerName().substring(0, 2))+(maxId+1);
				}
				//to get proof_Id from database
				
			}
			catch(SQLException e) 
			{
					throw new AMSException(e.getMessage());
			}
			return ownerId;
		
	}
	/*-------------------------------------------------------------------------------------------------------------------------*/	
	private boolean valAdvancEntry(FlatRegisterVO flatRegVo)
	{
		
		int flag=0;
		for(int i=0;i<flatRegVo.getAdvancInMonth().length();i++)
		{
			if(!Character.isDigit(flatRegVo.getAdvancInMonth().charAt(i)))
			{
				flag=1;
			}
		}
		if(flag==0 && (Integer.parseInt(flatRegVo.getAdvancInMonth())>=2 && Integer.parseInt(flatRegVo.getAdvancInMonth())<=12))
		{
			return true;
		}
		return false;
	}

	public float calculateAdvance(FlatRegisterVO flatRegVo) 
	{
		
		return  Float.valueOf(flatRegVo.getRent())*Float.valueOf(flatRegVo.getAdvancInMonth());
	
	}
	/*-------------------------------------------------------------------------------------------------------------------------*/			

	public boolean isFlatExist(String flatId) throws AMSBusinessException
	{
		FlatRegisterDAO flatRegDao = new FlatRegisterDAO();
		java.sql.ResultSet resultSet;
		try {
			resultSet = flatRegDao.accessData("flat_id","flat_master");
			while(resultSet.next())
			{
				if(resultSet.getString(1).toUpperCase().equals(flatId.toUpperCase()))
				{
					return false;
				}				
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}	
		return true;
	}
	/*-------------------------------------------------------------------------------------------------------------------------*/			
	//generate flatId using formula FLAT_ID = TYPE_ID+BLOCK_ID+FLOOR_NO+FLAT_NO(See rule 15)	

	public String generateFlatId(FlatRegisterVO flatRegVo, String blockId)
	{
		
		String flatId = flatRegVo.getFlatTypeId()+blockId+flatRegVo.getFloorNo() +flatRegVo.getFlatNo();
		return flatId;
	}
	/*-------------------------------------------------------------------------------------------------------------------------*/
	public float getMaintenanceCharge(String flatTypeId) 
	{
		// TODO Auto-generated method stub
		if(flatTypeId.equals("1B"))
		{
			return (float) 450.00;
		}
		else
		{
			return (float) 550.00;
		}
	}
	/*-------------------------------------------------------------------------------------------------------------------------*/

	public float electricityCharge(FlatRegisterVO flatRegVo)
	{
		float charge=0;
		if(flatRegVo.getFlatTypeId().equals("1B"))
		{
			charge=1000;
		}
		else
		{
			charge=1500;
		}
		return charge;
	}
	
	

}

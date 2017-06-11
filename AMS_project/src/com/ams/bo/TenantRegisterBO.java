package com.ams.bo;
import java.beans.FeatureDescriptor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ams.vo.TenantRegisterVO;
import com.ams.dao.TenantRegisterDao;
import com.ams.exceptions.*; 

public class TenantRegisterBO 
{


	public boolean registerUser(TenantRegisterVO regVO) throws AMSBusinessException, AMSException
	{	
		boolean res=false;

		if(regVO.getFirstName().isEmpty() || regVO.getLastName().isEmpty())
		{
			throw new AMSBusinessException("Name cannot be Empty!!!!!");
		}
		
		if(regVO.getFirstName().length()>20)
		{
			throw new AMSBusinessException("Name entered is too long.....!!");
		}
		
		if(!regVO.getFirstName().matches("^[a-zA-Z ]*$"))
		{
			throw new AMSBusinessException("Only alphabets are allowed in Name field.....!!");
		}
		if(!regVO.getLastName().matches("^[a-zA-Z ]*$"))
		{
			throw new AMSBusinessException("Only alphabets are allowed in Name field.....!!");
		}
	
		
		String gen=""+regVO.getGender();
		if(gen.isEmpty())
		{
			throw new AMSBusinessException("Selection Should be made for Gender!!!!!");
		}
		
			
		String fmly=""+regVO.getFamilyMembers();
		if(fmly.isEmpty())
		{
			throw new AMSBusinessException("Selection Should be made for Family Members!!!!!");
		}
		
		if(String.valueOf(regVO.getAdvancePaid()).isEmpty())
		{
			throw new AMSBusinessException("Advance paid cannot be empty...!!!!!");
		}
		
		if(regVO.getAdvancePaid()<0)
		{
			throw new AMSBusinessException("Advance paid cannot be a negative value...!!!!!");
		}
		if(regVO.getNativePlace().isEmpty())
		{
			throw new AMSBusinessException("Native Place cannot be Empty!!!!!");
		}
		
		if(!regVO.getNativePlace().matches("[a-zA-Z0-9 ]*"))
		{
			throw new AMSBusinessException("should be a number only...!!!!!");
		}
		
		
		String pattern3= "[0-9]{10}";
		if(regVO.getContact().isEmpty())
		{
			throw new AMSBusinessException("Contact cannot be Empty!!!!!");
		}
		
		if(!regVO.getContact().matches(pattern3))
		{
			throw new AMSBusinessException(" Invalid contact number...!!!!");
		}
		
	
		String str1=regVO.getIncomeSource();
		if(str1.isEmpty())
		{
			throw new AMSBusinessException("Selection Should be made for Income Source!!!!!");
		}
	
		String str2=regVO.getIdProof();
		if(str2.isEmpty())
		{
			throw new AMSBusinessException("Selection Should be made for ID Proof!!!!!");
		}
	
		
		boolean check = validateAgreement(regVO);
		if(!check)
		{
			throw new AMSBusinessException("Agreement start date should be before end date ");
		}
		 res=new TenantRegisterDao().registerTenant(regVO);
	
		 return res;
		
	}
	


	public String TenantID(TenantRegisterVO regVO)throws AMSException, ClassNotFoundException, SQLException
	{	
		 TenantRegisterDao registerDao = new TenantRegisterDao();
		 String flat_id = regVO.getFlatId(); 
		 String incomSourc = "";
		 if(regVO.getIncomeSource().equals("salary"))
		 {
			 incomSourc = "ST";
		 }
		 else
		 {
			 incomSourc = "BT";			 
		 }
		 int sequenc = getUniqueSequence(flat_id);
		 String tenant_id = flat_id+incomSourc+ regVO.getFirstName().substring(0,3)+sequenc;
		return tenant_id;
	}
	
	
	private int getUniqueSequence(String flat_id) 
	{
		int digitIndex=0;
		for(int i=flat_id.length()-1;i>=0;i--)
		{
			if(!Character.isDigit(flat_id.charAt(i)))
			{
				digitIndex = i;
				break;
			}
		}
		int sequenc = Integer.parseInt(flat_id.substring(digitIndex+1)) +1;
		return sequenc;

	}




	/*------------------------------------------------------------------------------------*/
	
		
	private boolean validateAgreement(TenantRegisterVO regVO) throws AMSBusinessException 
	{
		if(regVO.getAgrStartDate().isEmpty())
		{
			throw new AMSBusinessException("Agreement Start Date cannot be Empty!!!!!");
		}

		if(regVO.getAgrEndDate().isEmpty())
		{
			throw new AMSBusinessException("Agreement End Date cannot be Empty!!!!!");
		}
		try 
		{
//			if(!regVO.getAgrStartDate().equals("dd-MM-yyyy"))
//			{
//				throw new AMSBusinessException("wrong date formate!!!!!");
//			}
		SimpleDateFormat s=new SimpleDateFormat("dd-MM-yyyy");
	
		Date dt2=new Date();
		Date dt3=new Date();
		dt2 = s.parse(regVO.getAgrStartDate());
		dt3=s.parse(regVO.getAgrEndDate());
		if(dt2.after(dt3))
		{
			throw new AMSBusinessException("Agreement Start Date cannot be after End Date!!!!!");
		}
		
		}
		catch (ParseException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public int calulateAge(TenantRegisterVO regVO) throws AMSException, AMSBusinessException
	{
		int age1=0;
		// TODO Auto-generated method stub
	
		
		if(regVO.getDob().isEmpty())
		{
			throw new AMSBusinessException("Date of Birth cannot be Empty!!!!!");
		}	
		Date d=new Date();

		try
		{
			
			SimpleDateFormat s=new SimpleDateFormat("dd-MM-yyyy");
			String dob = regVO.getDob();
			d=s.parse(dob);		
			Date dt=new Date();
			if(d.before(dt))
			{
			long diff=dt.getTime()-d.getTime();
			double div=1000*60*60*24*365.25;
			age1= (int) (diff/div);
			}
			else
			{
				throw new AMSBusinessException("Date of Birth cannot be after Current Date!!!!!");
			}
		}
		catch (ParseException e) 
		{
			
			e.printStackTrace();
		}
		return age1;
	}

}

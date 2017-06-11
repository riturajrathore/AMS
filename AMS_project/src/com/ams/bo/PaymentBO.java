package com.ams.bo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.text.SimpleAttributeSet;

import com.ams.dao.PaymentDAO;
import com.ams.exceptions.AMSBusinessException;
import com.ams.exceptions.AMSException;
import com.ams.vo.PaymentVO;

public class PaymentBO {
	public boolean User(PaymentVO regvo) throws AMSException,AMSBusinessException 
	{
		
		return new PaymentDAO().payuser(regvo);

	}
public String User1(String r1) throws AMSBusinessException,AMSException
{

	String rentFromDB = new PaymentDAO().payuser1(r1);
	String dateFromDB=new PaymentDAO().payuser0(r1);
	
	Date d=new Date();
	Date db1=new Date();
	SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
	String d1=sdf.format(d);
	try {
		db1=sdf.parse(dateFromDB);
	}
	catch (java.text.ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	int date1=d.getDate();
	int monthcr=(d.getMonth()+1);
	int monthdb=(db1.getMonth()+1);
	int dif=monthcr-monthdb;
	float calRent=0;
	if(dif==0)
	{
	if(date1<=15 )
	{
		 calRent = Float.valueOf(rentFromDB);
			
	}
	else 
	{
		float rrrr=Float.parseFloat(rentFromDB);
		calRent=(float) (rrrr+(0.02*rrrr));
			}
	}
	else
	{
		if(date1<=15 )
		{
			float rrrr=Float.parseFloat(rentFromDB);
			calRent=(float) (rrrr+(0.05*rrrr));
				
		}
		else 
		{
			float rrrr=Float.parseFloat(rentFromDB);
			calRent=(float) (rrrr+(0.05*rrrr)+(0.02*rrrr));
		}
		
	}
	

	
	return String.valueOf(calRent);
}
public String User2(String r1) throws AMSBusinessException,AMSException
{

	String MainFromDB = new PaymentDAO().payuser2(r1);
	String dateFromDB=new PaymentDAO().payuser0(r1);

	Date d=new Date();
	Date db1=new Date();
	SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
	String d1=sdf.format(d);
	try {
		db1=sdf.parse(dateFromDB);
	}
	catch (java.text.ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	int date1=d.getDate();
	int monthcr=(d.getMonth()+1);
	int monthdb=(db1.getMonth()+1);
	int dif=monthcr-monthdb;
	float calMain=0;
	if(dif==0)
	{
	if(date1<=15 )
	{
		 calMain = Float.valueOf(MainFromDB);
			
	}
	else 
	{
		float rrrr=Float.parseFloat(MainFromDB);
		calMain=(float) (rrrr+(0.02*rrrr));
			}
	}
	else
	{
		if(date1<=15 )
		{
			float rrrr=Float.parseFloat(MainFromDB);
			calMain=(float) (rrrr+(0.05*rrrr));
		}
		else 
		{
			float rrrr=Float.parseFloat(MainFromDB);
			calMain=(float) (rrrr+(0.05*rrrr)+(0.02*rrrr));
		}
	}
	return String.valueOf(calMain);
}

public String LBill(String r1) throws AMSBusinessException,AMSException
{

	String bill =new PaymentDAO().Lbill(r1);
	String dateFromDB=new PaymentDAO().payuser0(r1);
	Date d=new Date();
	Date db1=new Date();
	SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
	String d1=sdf.format(d);
	try {
		db1=sdf.parse(dateFromDB);
	}
	catch (java.text.ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	int date1=d.getDate();
	int monthcr=(d.getMonth()+1);
	int monthdb=(db1.getMonth()+1);
	float calbill=0;
	int dif=monthcr-monthdb;
	if(dif==0)
	{
	if(date1<=15 )
	{
		 calbill = Float.valueOf(bill);
			
	}
	else 
	{
		float rrrr=Float.parseFloat(bill);
		calbill=(float) (rrrr+(0.02*rrrr));
			}
	}
	else
	{
		if(date1<=15 )
		{
			float rrrr=Float.parseFloat(bill);
			calbill=(float) (rrrr+(0.05*rrrr));
				
		}
		else 
		{
			float rrrr=Float.parseFloat(bill);
			calbill=(float) (rrrr+(0.05*rrrr)+(0.02*rrrr));
		}
		
	}
	

	
	return String.valueOf(calbill);
}



}

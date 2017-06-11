package com.ams.bo;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import com.ams.dao.Registerdao;

import com.ams.exceptions.AMSBusinessException;
import com.ams.exceptions.AMSException;

import com.ams.vo.Registervo;

public class Registerbo 
{
	public HashMap<String, String> getTenantData(Registervo regv)throws AMSException, AMSBusinessException, SQLException
	{
		
	
		HashMap<String, String> verify =  new Registerdao().registerUser(regv);
		if(verify.isEmpty())
		{
		
			throw new AMSBusinessException("Tenant_id doesn't exists");
		}
		else
		{
			float rentDue = dueRent(regv);
			verify.put("dueRent", String.valueOf(rentDue));
			float maintenanceDue = dueMaintenance(regv);
			verify.put("dueMaintenance", String.valueOf(maintenanceDue));
			float electricityDue = dueElectricity(regv);
			verify.put("dueElectricity", String.valueOf(electricityDue));
			return verify;
		}
	}

	private float dueMaintenance(Registervo regv) throws SQLException
	{
		String query = "select (m.maintenance-pay.Maintenance_paid) from maintenance m join payment_details pay on m.Flat_id=pay.Flat_id and Tenant_id =? and payment_date=?";
		Registerdao registerdao = new Registerdao();
		String query1 = "select Payment_date from payment_details where tenant_id=? order by payment_date asc limit 1";		 
		String dateOfPay = registerdao.getDateOfPay(query1, regv);
		float mainten = registerdao.getData(query,dateOfPay,regv);
		if(mainten!=0)
		{
			Date d1=new Date();
			SimpleDateFormat sdf1=new SimpleDateFormat("dd-MM-yyyy");
			Date lastdate11=new Date();
			int datetoday1=d1.getDate();

			try {
				lastdate11=sdf1.parse(dateOfPay);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*--*/
			Calendar cal1=Calendar.getInstance();
			int month1=d1.getMonth()+1;
			int year1=d1.getYear();
			Date d11=new Date(year1,month1,01);
			cal1.setTime(d11);
			cal1.add(Calendar.DAY_OF_YEAR,-1);
			int lastdateofmonth1=cal1.get(Calendar.DATE);
		    /*--*/
			float Day_rent1=mainten/lastdateofmonth1;
		    if(datetoday1<=15)
		    {
			float rent_due1=datetoday1*Day_rent1;
			mainten=rent_due1;
		    }	
		    else
		    {
		    	float rent_due1=mainten; 	
		    	mainten=rent_due1;
		    }
		}
		
		return mainten;
	}

	private float dueRent(Registervo regv) throws SQLException
	{

		String query = "select (flat.rent - pay.rent_paid) from payment_details pay join flat_master flat on pay.flat_id=flat.flat_id and  pay.tenant_id =? and pay.payment_date=?";
		Registerdao registerdao = new Registerdao();
		String query1 = "select Payment_date from payment_details where tenant_id=? order by payment_date asc limit 1";		 
		String dateOfPay = registerdao.getDateOfPay(query1, regv);
		float rent = registerdao.getData(query,dateOfPay,regv);
		if(rent!=0)
		{
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		Date lastdate1=new Date();
		int datetoday=d.getDate();

		try {
			lastdate1=sdf.parse(dateOfPay);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*--*/
		Calendar cal=Calendar.getInstance();
		int month=d.getMonth()+1;
		int year=d.getYear();
		Date d1=new Date(year,month,01);
		cal.setTime(d1);
		Calendar cal1=Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR,-1);
		int lastdateofmonth=cal.get(Calendar.DATE);
	    /*--*/
		float Day_rent=rent/lastdateofmonth;
	    if(datetoday<=15)
	    {
		float rent_due=datetoday*Day_rent;
		rent=rent_due;
	    }	
	    else
	    {
	    	float rent_due=rent; 	
	    	rent=rent_due;
	    }
		}
		return rent;
	}
	
	private float dueElectricity(Registervo regv) throws SQLException
	{

		String query = "select (e.electricity_bill - pay.lightbill_paid) from payment_details pay join maintenance e on pay.flat_id=e.flat_id and  pay.tenant_id =? and pay.payment_date=?";
		Registerdao registerdao = new Registerdao();
		String query1 = "select Payment_date from payment_details where tenant_id=? order by payment_date asc limit 1";			 
		String dateOfPay = registerdao.getDateOfPay(query1, regv);
		float rent = registerdao.getData(query,dateOfPay,regv);
		if(rent!=0)
		{
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		Date lastdate1=new Date();
		int datetoday=d.getDate();

		try {
			lastdate1=sdf.parse(dateOfPay);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*--*/
		Calendar cal=Calendar.getInstance();
		int month=d.getMonth()+1;
		int year=d.getYear();
		Date d1=new Date(year,month,01);
		cal.setTime(d1);
		Calendar cal1=Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR,-1);
		int lastdateofmonth=cal.get(Calendar.DATE);
	    /*--*/
		float Day_rent=rent/lastdateofmonth;
	    if(datetoday<=15)
	    {
		float rent_due=datetoday*Day_rent;
		rent=rent_due;
	    }	
	    else
	    {
	    	float rent_due=rent; 	
	    	rent=rent_due;
	    }
		}
		return rent;
	}
	
	
}

package com.ams.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.ams.exceptions.AMSBusinessException;
import com.ams.exceptions.AMSException;
import com.ams.vo.PaymentVO;


public class PaymentDAO {
	public static ArrayList<String> a1=new ArrayList<String>();
	public boolean payuser(PaymentVO logvo) throws AMSException, AMSBusinessException
	{
		
		boolean reslt=false;
		String url="jdbc:mysql://localhost:3306/AMS_DB";
		try
		{
			
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection con=DriverManager.getConnection(url,"root","shriganesh-01");
			 PreparedStatement pstmt=(PreparedStatement) con.prepareStatement("select * from tenant_info where tenant_id=?");
			 pstmt.setString(1, logvo.getTenant_id());
			
			 
				ResultSet rst=pstmt.executeQuery();
				
				if(rst.next())
				{
					
					reslt=true;
				}
			}
			catch(ClassNotFoundException ex){
				 
				 
				 throw new AMSBusinessException(ex.getMessage());
				 
			 }
			 catch(SQLException e){
				 throw new AMSException(e.getMessage());
				 
			 }
			 return reslt;

}
	public String payuser1(String p1) throws AMSException
	{
		 String rr = null;
		String url="jdbc:mysql://localhost:3306/AMS_DB";
		//boolean o=false;
		
		try
		{
			
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection con=DriverManager.getConnection(url,"root","shriganesh-01");
			 PreparedStatement pstmt=(PreparedStatement) con.prepareStatement("select rent from flat_master fm join register_info ri where fm.flat_id=ri.flat_id and ri.tenant_id=?");
			 pstmt.setString(1, p1);
			 ResultSet rstt=pstmt.executeQuery();
			 if(rstt.next())
			{
					 rr=rstt.getString(1);	
			}		
			 
		
	}
		catch(ClassNotFoundException ex){
			 
			 
			 throw new AMSException(ex.getMessage());
			 
		 }
		 catch(SQLException e){
			 throw new AMSException(e.getMessage());
			 
		 }
		return rr;
		
	}
	
	
	public String payuser2(String p1) throws AMSException
	{
		 String rr = null;
		String url="jdbc:mysql://localhost:3306/AMS_DB";
		//boolean o=false;
		
		try
		{
			
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection con=DriverManager.getConnection(url,"root","shriganesh-01");
			 PreparedStatement pstmt=(PreparedStatement) con.prepareStatement("select maintenance from maintenance mm join register_info ri on mm.flat_id=ri.flat_id where ri.tenant_id=?");
			 pstmt.setString(1, p1);
			 ResultSet rstt=pstmt.executeQuery();
			
			if(rstt.next())
			{
			
					 rr=rstt.getString(1);	
					 
			}		
			 
		
	}
		catch(ClassNotFoundException ex){
			 
			 
			 throw new AMSException(ex.getMessage());
			 
		 }
		 catch(SQLException e){
			 throw new AMSException(e.getMessage());
			 
		 }
		return rr;
		
	}
	
	
	public String payuser0(String p1) throws AMSException
	{
		 String rr0 = null;
		String url="jdbc:mysql://localhost:3306/AMS_DB";
		//boolean o=false;
		
		try
		{
			
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection con=DriverManager.getConnection(url,"root","shriganesh-01");
			 PreparedStatement pstmt1=(PreparedStatement) con.prepareStatement("select  Payment_date from payment_details where tenant_id=?");
			 pstmt1.setString(1,p1);
			 ResultSet rstt1=pstmt1.executeQuery();
			 if(rstt1.next())
			{
					 rr0=rstt1.getString(1);
					 
			}
			 else
			 {
				 Date d = new Date();
				 SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
				 String ddd=sd.format(d);
				 rr0 = ddd;
				
			 }
			 
		
	}
		catch(ClassNotFoundException ex){
			 
			 
			 throw new AMSException(ex.getMessage());
			 
		 }
		 catch(SQLException e){
			 throw new AMSException(e.getMessage());
			 
		 }

		return rr0;
		
	}
	
	public List<String> payuser3(String q1) throws AMSException
	{
	
		String url="jdbc:mysql://localhost:3306/AMS_DB";
		
		try
		{
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection con=DriverManager.getConnection(url,"root","shriganesh-01");
			 PreparedStatement pstmt1=(PreparedStatement) con.prepareStatement("select ti.first_name,o.owner_name,fi.flat_id,fi.block_id,fi.floor_no,fi.type_id,fi.rent,mm.maintenance from tenant_info ti join register_info ri on ti.tenant_id=ri.tenant_id join flat_master fi on fi.flat_id=ri.flat_id join maintenance mm on mm.flat_id=fi.flat_id join owner o on o.owner_id=fi.owner_id where ti.tenant_id=?");
			 pstmt1.setString(1, q1);
			 ResultSet rstt=pstmt1.executeQuery();
			 Date d =new Date();
			 SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
			 String date2=sdf.format(d);
			 String month2=""+(d.getMonth()+1);
		
			
			
					 if(rstt.next())
					 {
						 a1.add(q1);
						 for(int i=1;i<9;i++)
						 {
							 a1.add(rstt.getString(i));
						 }
						 float a=Float.parseFloat(rstt.getString(7));
						 float b1=Float.parseFloat(rstt.getString(8));
						 String sum=""+(a+b1);
						 
						 a1.add(sum);
						 a1.add(month2);
						 a1.add(date2);
					 }
					 
					 
				
			 return a1;
		
	}
		catch(ClassNotFoundException ex){
			 
			 
			 throw new AMSException(ex.getMessage());
			 
		 }
		 catch(SQLException e){
			 throw new AMSException(e.getMessage());
			 
		 }
		
	}
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
	 public ResultSet accessData(String query)
		{
				Connection con = createConn();
				java.sql.Statement st;
				ResultSet rest = null;
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

	public boolean insrtdata(String[] data) throws AMSException, AMSBusinessException
	{
		
		boolean reslt=false;
		String url="jdbc:mysql://localhost:3306/AMS_DB";
		try
		{
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection con=DriverManager.getConnection(url,"root","shriganesh-01");
			 String query = "select Payment_id from payment_details where Payment_id='"+data[0]+"'";
			 ResultSet resultSet = accessData(query);
			 if(resultSet.next())
			 {
				 
				
				 Float rent1=Float.parseFloat(data[3]);
				 Float maintenance=Float.parseFloat(data[4]);
				 Float lbill=Float.parseFloat(data[7]);
				 if(rent1!=0 && maintenance==0 && lbill==0 )
				 {
					 String query1 = "select Rent_paid from payment_details where Payment_id='"+data[0]+"'";
					 ResultSet resultSet1 = accessData(query1);
					 if(resultSet1.next())
					 {
						 if(resultSet1.getString(1).equals("0"))
						 {
						 String rentt=rent1.toString();
						 PreparedStatement preparedState =(PreparedStatement) con.prepareStatement("Update payment_details set Rent_paid='"+rentt+"', total_paid='"+(rent1)+"'+ total_paid where Payment_id='"+data[0]+"' ");
						 int rst1=preparedState.executeUpdate();
						 if(rst1>0)
						 {
							 reslt=true;				
					     }
					 	
						 }
						 else
						 {
							 reslt=false;
						 }
					 }
				 }
				 else if(maintenance!=0 && rent1==0 && lbill==0 )
				 {
					 String query1 = "select Maintenance_paid from payment_details where Payment_id='"+data[0]+"'";
					 ResultSet resultSet1 = accessData(query1);
					 if(resultSet1.next())
					 {
						if(resultSet1.getString(1).equals("0"))
						{
						 String mainn=maintenance.toString();
						 PreparedStatement preparedState =(PreparedStatement) con.prepareStatement("Update payment_details set Maintenance_paid='"+mainn+"' , total_paid='"+(maintenance)+"'+ total_paid where Payment_id='"+data[0]+"' ");
						int rst1=preparedState.executeUpdate();
						if(rst1>0)
						{
							reslt=true;
						}
					 }
					 else
					 {
						 reslt=false;
					 }
				 }
				 }
				 else if(lbill!=0 && rent1==0 && maintenance==0  )
				 {
					 String query1 = "select LightBill_paid from payment_details where Payment_id='"+data[0]+"'";
					 ResultSet resultSet1 = accessData(query1);
					 if(resultSet1.next())
					 {
						 if(resultSet1.getString(1).equals("0"))
							{
					 String lbilll=lbill.toString();
					 PreparedStatement preparedState =(PreparedStatement) con.prepareStatement("Update payment_details set LightBill_paid='"+lbilll+"' , total_paid='"+(lbill)+"'+ total_paid where Payment_id='"+data[0]+"' ");
					 int rst1=preparedState.executeUpdate();
					 if(rst1>0)
					 {
						 reslt=true;				
						 }
				 }
						 else
						 {
							 reslt=false;
						 }
					 }
				 }
				 else if(rent1!=0 && maintenance!=0 && lbill==0)
				 {
					 String query1 = "select Maintenance_paid,Rent_paid from payment_details where Payment_id='"+data[0]+"'";
					 ResultSet resultSet1 = accessData(query1);
					 if(resultSet1.next())
					 {
						 if(resultSet1.getString(1).equals("0")&&(resultSet1.getString(2).equals("0")))
							{
				 String mainn=maintenance.toString();
					 String rentt=rent1.toString();
				 PreparedStatement preparedState =(PreparedStatement) con.prepareStatement("Update payment_details set Maintenance_paid='"+mainn+"',Rent_paid='"+rentt+"' , total_paid='"+(maintenance)+"'+'"+(rent1)+"'+ total_paid where Payment_id='"+data[0]+"' ");
				 int rst1=preparedState.executeUpdate();
				 if(rst1>0)
				 {
					reslt=true;
				 }
				 }
						 else
						 {
							 reslt=false;
						 }
					 }
				 }
					
						 
				 else if(rent1!=0 && lbill!=0 && maintenance==0)
				 {
					 String query1 = "select LightBill_paid,Rent_paid from payment_details where Payment_id='"+data[0]+"'";
					 ResultSet resultSet1 = accessData(query1);
					 if(resultSet1.next())
					 {
						 if(resultSet1.getString(1).equals("0")&&(resultSet1.getString(2).equals("0")))
							{
							 	
					 String lbilll=lbill.toString();
					 String rentt=rent1.toString();
				 PreparedStatement preparedState =(PreparedStatement) con.prepareStatement("Update payment_details set LightBill_paid='"+lbilll+"',Rent_paid='"+rentt+"' , total_paid='"+(lbill)+"'+'"+(rent1)+"'+ total_paid where Payment_id='"+data[0]+"' ");
				 int rst1=preparedState.executeUpdate();
				 if(rst1>0)
				 {
					reslt=true;
				 }
				 }
						 else
						 {
							 reslt=false;
						 }
					 }
				 }
				 
				 else if(maintenance!=0 && lbill!=0 && rent1==0)
				 {
					 String query1 = "select LightBill_paid,Maintenance_paid from payment_details where Payment_id='"+data[0]+"'";
					 ResultSet resultSet1 = accessData(query1);
					 if(resultSet1.next())
					 {
						 if(resultSet1.getString(1).equals("0")&&(resultSet1.getString(2).equals("0")))
							{
							 	
					 String lbilll=lbill.toString();
					 String mainn=maintenance.toString();
				 PreparedStatement preparedState =(PreparedStatement) con.prepareStatement("Update payment_details set Maintenance_paid='"+mainn+"',LightBill_paid='"+lbilll+"' , total_paid='"+(lbill)+"'+'"+(maintenance)+"'+ total_paid where Payment_id='"+data[0]+"' ");
				 int rst1=preparedState.executeUpdate();
				 if(rst1>0)
				 {
					reslt=true;
				 }
				 }
						 else
						 {
							 reslt=false;
						 }
					 }
				 }
				 
				 
				 
			 }
			 else
			 {
			 PreparedStatement pstmt=(PreparedStatement) con.prepareStatement("insert into payment_details values(?,?,?,?,?,?,?,?)");			 
			 pstmt.setString(1, data[0]);
			 pstmt.setString(2, data[1]);
			 pstmt.setString(3, data[2]);
			 pstmt.setString(4, data[3]);
			 pstmt.setString(5, data[4]);
			 pstmt.setString(6, data[5]);
			 pstmt.setString(7, data[6]);
			 pstmt.setString(8, data[7]);

			
			 int rst=pstmt.executeUpdate();
				
				if(rst>=1)
				{
					reslt=true;
				
				}
				
				
			}
		}
			catch(ClassNotFoundException ex){
				 
				 
				 throw new AMSBusinessException(ex.getMessage());
				 
			 }
			 catch(SQLException e){
				 throw new AMSException(e.getMessage());
				 
			 }
			 return reslt;

}
	
	
	public String Lbill(String p1) throws AMSException
	{
		 String rr = null;
		String url="jdbc:mysql://localhost:3306/AMS_DB";
		//boolean o=false;
		
		try
		{
			
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection con=DriverManager.getConnection(url,"root","shriganesh-01");
			 PreparedStatement pstmt=(PreparedStatement) con.prepareStatement("select e.electricity_bill  from maintenance e join register_info ri on e.flat_id=ri.flat_id and ri.tenant_id=?");
			 pstmt.setString(1, p1);
			 ResultSet rstt=pstmt.executeQuery();
			 if(rstt.next())
			{
					 rr=rstt.getString(1);	
			}		
			 
		
	}
		catch(ClassNotFoundException ex){
			 
			 
			 throw new AMSException(ex.getMessage());
			 
		 }
		 catch(SQLException e){
			 throw new AMSException(e.getMessage());
			 
		 }
		return rr;
		
	}
}

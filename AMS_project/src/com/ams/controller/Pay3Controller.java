package com.ams.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ams.dao.PaymentDAO;
import com.ams.exceptions.AMSBusinessException;
import com.ams.exceptions.AMSException;
import com.ams.exceptions.AMSBusinessException;
import com.ams.exceptions.AMSException;

/**
 * Servlet implementation class Pay3Controller
 */
public class Pay3Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pay3Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		// TODO Auto-generated method stub
		
		
		SimpleDateFormat sdf1=new SimpleDateFormat("yy");
		SimpleDateFormat sdf3=new SimpleDateFormat("MM");
		
		Date dd1=new Date();
		String pay_id = null;
		
		try {
			
			String tnt=request.getParameter("tn_id");
			String m2=sdf3.format(dd1);
			String i2=sdf1.format(dd1);
		
	
		 pay_id=request.getParameter("tn_id")+m2+i2;
		
		String[] data = new String[15];
		data[0]=pay_id;
		data[1]=request.getParameter("flat_id");
		data[2]=tnt;
		data[3]=request.getParameter("rent");
		data[4]=request.getParameter("maintenance");
		data[5]=request.getParameter("total");
		data[6]=request.getParameter("date");
		data[7]=request.getParameter("lightbill");
			boolean b=new PaymentDAO().insrtdata(data);
			if(b==true)
			{

				if(request.getParameter("maintenance").equals("0") && (!request.getParameter("rent").equals("0")) && (request.getParameter("lightbill").equals("0")))
				{
					RequestDispatcher rd=request.getRequestDispatcher("Success.jsp");
					request.setAttribute("success","Rent payment done successfully with the Payment ID "+pay_id+" on "+ (request.getParameter("date")));
					rd.forward(request, response);
						
				}
				
				else if(request.getParameter("rent").equals("0") && (!request.getParameter("maintenance").equals("0")) && (request.getParameter("lightbill").equals("0")))
				{
					RequestDispatcher rd=request.getRequestDispatcher("Success.jsp");
					request.setAttribute("success","Maintanence payment done successfully with the Payment ID "+pay_id+" on "+ (request.getParameter("date")));
					rd.forward(request, response);
						
				}
				
				else if(request.getParameter("rent").equals("0") && (request.getParameter("maintenance").equals("0")) && (!(request.getParameter("lightbill").equals("0"))))
				{
					RequestDispatcher rd=request.getRequestDispatcher("Success.jsp");
					request.setAttribute("success","LightBill payment done successfully with the Payment ID "+pay_id+" on "+ (request.getParameter("date")));
					rd.forward(request, response);
						
				}
				
				else if((!(request.getParameter("rent").equals("0"))) && (!(request.getParameter("maintenance").equals("0"))) && (request.getParameter("lightbill").equals("0")))
				{
					RequestDispatcher rd=request.getRequestDispatcher("Success.jsp");
					request.setAttribute("success","Rent and Maintanence payment done successfully with the Payment ID "+pay_id+" on "+ (request.getParameter("date")));
					rd.forward(request, response);
						
				}
				else if((!(request.getParameter("rent").equals("0"))) && (request.getParameter("maintenance").equals("0")) && (!(request.getParameter("lightbill").equals("0"))))
				{
					RequestDispatcher rd=request.getRequestDispatcher("Success.jsp");
					request.setAttribute("success","Rent and LightBill payment done successfully with the Payment ID "+pay_id+" on "+ (request.getParameter("date")));
					rd.forward(request, response);
						
				}
				else if((request.getParameter("rent").equals("0")) && (!(request.getParameter("maintenance").equals("0"))) && (!(request.getParameter("lightbill").equals("0"))))
				{
					RequestDispatcher rd=request.getRequestDispatcher("Success.jsp");
					request.setAttribute("success","Maintanence and LightBill payment done successfully with the Payment ID "+pay_id+" on "+ (request.getParameter("date")));
					rd.forward(request, response);
				}
				
				else if((!(request.getParameter("rent").equals("0"))) && (!(request.getParameter("maintenance").equals("0"))) && (!(request.getParameter("lightbill").equals("0"))))
				{
					RequestDispatcher rd=request.getRequestDispatcher("Success.jsp");
					request.setAttribute("success","Rent,Maintanence and LightBill payment done successfully with the Payment ID "+pay_id+" on "+ (request.getParameter("date")));
					rd.forward(request, response);
				}	
				
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
				request.setAttribute("error","No balance due for this month");
				rd.forward(request, response);
				
			}
		} 
		 catch (ServletException e) {
			// TODO Auto-generated catch block

				RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
				request.setAttribute("error","No balance due for this month");
				rd.forward(request, response);
			e.printStackTrace();
		} catch (IOException e) {

			// TODO Auto-generated catch block
			RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
			request.setAttribute("error","No balance due for this month");
			rd.forward(request, response);
			e.printStackTrace();
		} catch (AMSException e) {
			// TODO Auto-generated catch block
			RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
			request.setAttribute("error","No balance due for this month");
			rd.forward(request, response);
			e.printStackTrace();
		} catch (AMSBusinessException e) {
			// TODO Auto-generated catch block
			RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
			request.setAttribute("error","No balance due for this month");
			rd.forward(request, response);
			e.printStackTrace();
		}
	}

}

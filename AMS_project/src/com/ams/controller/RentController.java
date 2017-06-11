package com.ams.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ams.bo.PaymentBO;
import com.ams.dao.PaymentDAO;
import com.ams.exceptions.AMSBusinessException;
import com.ams.exceptions.AMSException;
import com.ams.vo.RentVO;

/**
 * Servlet implementation class RentController
 */
public class RentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RentController() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RentVO rvo= new RentVO();
		String s = request.getParameter("tn_id");
	
		rvo.setTenant_id(s);
		String s1=request.getParameter("rent");
		String s2=request.getParameter("main");
		String s3=request.getParameter("lightbill");
		
		
		
		if(s1!=null && s2==null && s3==null )
		{
			try {
				String b=new PaymentBO().User1(s);
				ArrayList<String> aa=(ArrayList<String>) new PaymentDAO().payuser3(s);
				if(aa!=null)
				{
					String tntn=aa.get(1).toUpperCase();
					RequestDispatcher rd=request.getRequestDispatcher("Pay3.jsp");
					request.setAttribute("OwnerName",aa.get(2));
					request.setAttribute("TName",tntn);
					request.setAttribute("Flatid",aa.get(3));
					request.setAttribute("Block",aa.get(4));
					request.setAttribute("floor",aa.get(5));
					request.setAttribute("flattype",aa.get(6));
					request.setAttribute("rent",b);
					request.setAttribute("main",0);
					request.setAttribute("lightbill",0);
					request.setAttribute("total",b);
					request.setAttribute("date",aa.get(11));
					request.setAttribute("mnth",aa.get(10));
					request.setAttribute("Tenant", s);
					rd.forward(request, response);
				}

			} catch (AMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AMSBusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
		else if(s2!=null && s1==null && s3==null)
		{
			try {
			

				String b=new PaymentBO().User2(s);
				ArrayList<String> aa=(ArrayList<String>) new PaymentDAO().payuser3(s);
				
				if(b!=null)
				{
					String tntn=aa.get(1).toUpperCase();
					RequestDispatcher rd=request.getRequestDispatcher("Pay3.jsp");
					request.setAttribute("OwnerName",aa.get(2));
					request.setAttribute("TName",tntn);
					request.setAttribute("Flatid",aa.get(3));
					request.setAttribute("Block",aa.get(4));
					request.setAttribute("floor",aa.get(5));
					request.setAttribute("flattype",aa.get(6));
					request.setAttribute("rent",0);
					request.setAttribute("main",b);
					request.setAttribute("lightbill",0);
					request.setAttribute("total",b);
					request.setAttribute("date",aa.get(11));
					request.setAttribute("mnth",aa.get(10));
					request.setAttribute("Tenant", s);
					rd.forward(request, response);
				}

			} catch (AMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AMSBusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(s3!=null && s2==null && s1==null)
		{
			try {
			

				String b=new PaymentBO().LBill(s);
				ArrayList<String> aa=(ArrayList<String>) new PaymentDAO().payuser3(s);
				
				if(b!=null)
				{
					String tntn=aa.get(1).toUpperCase();
					RequestDispatcher rd=request.getRequestDispatcher("Pay3.jsp");
					request.setAttribute("OwnerName",aa.get(2));
					request.setAttribute("TName",tntn);
					request.setAttribute("Flatid",aa.get(3));
					request.setAttribute("Block",aa.get(4));
					request.setAttribute("floor",aa.get(5));
					request.setAttribute("flattype",aa.get(6));
					request.setAttribute("rent",0);
					request.setAttribute("main",0);
					request.setAttribute("lightbill",b);
					request.setAttribute("total",b);
					request.setAttribute("date",aa.get(11));
					request.setAttribute("mnth",aa.get(10));
					request.setAttribute("Tenant", s);
					rd.forward(request, response);
				}

			} catch (AMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AMSBusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		else if(s1!=null && s2!=null && s3==null)
		{
			try {
				String b=new PaymentBO().User1(s);
				String g=new PaymentBO().User2(s);
				float sum=(Float.parseFloat(b))+(Float.parseFloat(g));
			    ArrayList<String> aa=(ArrayList<String>) new PaymentDAO().payuser3(s);
				
				if(b!=null && g!=null)
				{
					String tntn=aa.get(1).toUpperCase();
					RequestDispatcher rd=request.getRequestDispatcher("Pay3.jsp");
					request.setAttribute("OwnerName",aa.get(2));
					request.setAttribute("TName",tntn);
					request.setAttribute("Flatid",aa.get(3));
					request.setAttribute("Block",aa.get(4));
					request.setAttribute("floor",aa.get(5));
					request.setAttribute("flattype",aa.get(6));
					request.setAttribute("rent",b);
					request.setAttribute("main",g);
					request.setAttribute("lightbill",0);
					request.setAttribute("total",sum);
					request.setAttribute("date",aa.get(11));
					request.setAttribute("mnth",aa.get(10));
					request.setAttribute("Tenant", s);
					rd.forward(request, response);
				}
				
			}
			catch (AMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AMSBusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		else if(s1!=null && s3!=null && s2==null)
		{
			try {
				String b=new PaymentBO().User1(s);
				String g=new PaymentBO().LBill(s);
				float sum=(Float.parseFloat(b))+(Float.parseFloat(g));
			    ArrayList<String> aa=(ArrayList<String>) new PaymentDAO().payuser3(s);
				
				if(b!=null && g!=null)
				{
					String tntn=aa.get(1).toUpperCase();
					RequestDispatcher rd=request.getRequestDispatcher("Pay3.jsp");
					request.setAttribute("OwnerName",aa.get(2));
					request.setAttribute("TName",tntn);
					request.setAttribute("Flatid",aa.get(3));
					request.setAttribute("Block",aa.get(4));
					request.setAttribute("floor",aa.get(5));
					request.setAttribute("flattype",aa.get(6));
					request.setAttribute("rent",b);
					request.setAttribute("main",0);
					request.setAttribute("lightbill",g);
					request.setAttribute("total",sum);
					request.setAttribute("date",aa.get(11));
					request.setAttribute("mnth",aa.get(10));
					request.setAttribute("Tenant", s);
					rd.forward(request, response);
				}
				
			}
			catch (AMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AMSBusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		else if(s1==null && s3!=null && s2!=null)
		{
			try {
				String b=new PaymentBO().LBill(s);
				String g=new PaymentBO().User2(s);
				float sum=(Float.parseFloat(b))+(Float.parseFloat(g));
			    ArrayList<String> aa=(ArrayList<String>) new PaymentDAO().payuser3(s);
				
				if(b!=null && g!=null)
				{
					String tntn=aa.get(1).toUpperCase();
					RequestDispatcher rd=request.getRequestDispatcher("Pay3.jsp");
					request.setAttribute("OwnerName",aa.get(2));
					request.setAttribute("TName",tntn);
					request.setAttribute("Flatid",aa.get(3));
					request.setAttribute("Block",aa.get(4));
					request.setAttribute("floor",aa.get(5));
					request.setAttribute("flattype",aa.get(6));
					request.setAttribute("rent",0);
					request.setAttribute("main",g);
					request.setAttribute("lightbill",b);
					request.setAttribute("total",sum);
					request.setAttribute("date",aa.get(11));
					request.setAttribute("mnth",aa.get(10));
					request.setAttribute("Tenant", s);
					rd.forward(request, response);
				}
				
			}
			catch (AMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AMSBusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		else if(s1!=null && s3!=null && s2!=null)
		{
			try {
				String b=new PaymentBO().User1(s);
				String h=new PaymentBO().User2(s);
				String g=new PaymentBO().LBill(s);
				float sum=(Float.parseFloat(b))+(Float.parseFloat(g)+(Float.parseFloat(h)));
			    ArrayList<String> aa=(ArrayList<String>) new PaymentDAO().payuser3(s);
				
				if(b!=null && g!=null)
				{
					
					String tntn=aa.get(1).toUpperCase();
					RequestDispatcher rd=request.getRequestDispatcher("Pay3.jsp");
					request.setAttribute("OwnerName",aa.get(2));
					request.setAttribute("TName",tntn);
					request.setAttribute("Flatid",aa.get(3));
					request.setAttribute("Block",aa.get(4));
					request.setAttribute("floor",aa.get(5));
					request.setAttribute("flattype",aa.get(6));
					request.setAttribute("rent",b);
					request.setAttribute("main",h);
					request.setAttribute("lightbill",g);
					request.setAttribute("total",sum);
					request.setAttribute("date",aa.get(11));
					request.setAttribute("mnth",aa.get(10));
					request.setAttribute("Tenant", s);
					rd.forward(request, response);
				}
				
			}
			catch (AMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AMSBusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("Pay2.jsp");
			request.setAttribute("Tenant", s);
			request.setAttribute("error","Please check a box");

			rd.forward(request, response);
		}

	}

}

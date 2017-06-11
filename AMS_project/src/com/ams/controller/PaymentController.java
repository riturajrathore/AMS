package com.ams.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ams.bo.PaymentBO;
import com.ams.dao.PaymentDAO;
import com.ams.exceptions.AMSBusinessException;
import com.ams.exceptions.AMSException;
import com.ams.vo.PaymentVO;
import com.ams.vo.RentVO;
/**
 * Servlet implementation class PaymentController
 */
public class PaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentController() {
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
		PaymentVO payvo=new PaymentVO();
		payvo.setTenant_id(request.getParameter("tn_id"));	
		try
		{
		boolean b;
		b = new PaymentDAO().payuser(payvo);
		if(b==true)
		{
			RequestDispatcher rd=request.getRequestDispatcher("Pay2.jsp");
			request.setAttribute("Tenant", payvo.getTenant_id());
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("Pay1.jsp");
			request.setAttribute("error","Invalid tenant id");
			rd.forward(request, response);
		}
		}
		catch (AMSException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AMSBusinessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	}

}

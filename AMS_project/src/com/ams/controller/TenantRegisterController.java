package com.ams.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ams.bo.TenantRegisterBO;
import com.ams.exceptions.AMSBusinessException;
import com.ams.exceptions.AMSException;
import com.ams.vo.TenantRegisterVO;

/**
 * Servlet implementation class TenantRegisterController
 */
public class TenantRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TenantRegisterController() {
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
		
		TenantRegisterVO regVO=new TenantRegisterVO();
		regVO.setFirstName(request.getParameter("fname"));
		regVO.setLastName(request.getParameter("lname"));
		regVO.setDob(request.getParameter("dob"));
	    regVO.setGender( request.getParameter("sex"));
		regVO.setFamilyMembers(Integer.parseInt(request.getParameter("familymem")));
		regVO.setFlatId(request.getParameter("flat_id"));
		regVO.setNativePlace(request.getParameter("place"));
		regVO.setContact((request.getParameter("contact")));
		regVO.setIncomeSource(request.getParameter("incomesrc"));
		regVO.setIdProof(request.getParameter("idproof"));
		regVO.setAgrStartDate(request.getParameter("agrstartdate").toString());
		regVO.setAgrEndDate(request.getParameter("agrenddate").toString());
		regVO.setDurofstay(request.getParameter("durofstay"));
		if(!request.getParameter("advancePaid").isEmpty())
		{
			regVO.setAdvancePaid(Float.valueOf(request.getParameter("advancePaid")));	
		}
		try
		{
			boolean res=new TenantRegisterBO().registerUser(regVO);
			if(res==true)
			{
				
				RequestDispatcher rd=request.getRequestDispatcher("Success.jsp");
				request.setAttribute("success", (regVO.getFirstName()+" is Registered.."));
				rd.forward(request, response);
			}
		}
		
		catch (AMSException e) 
		{
			RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
			request.setAttribute("error", e.getMessage());
			rd.forward(request, response);
		}
		catch (AMSBusinessException e)
		{
			RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
			request.setAttribute("error", e.getMessage());
			rd.forward(request, response);
		}
		
	}

}

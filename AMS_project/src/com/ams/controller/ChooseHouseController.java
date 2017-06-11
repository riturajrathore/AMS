package com.ams.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ams.bo.ChooseHouseBO;
import com.ams.exceptions.AMSBusinessException;
import com.ams.exceptions.AMSException;
import com.ams.vo.ChooseHouseVO;

/**
 * Servlet implementation class ChooseHouseController
 */
public class ChooseHouseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChooseHouseController() {
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
		ChooseHouseVO chHouseVO=new ChooseHouseVO();
		chHouseVO.setFlattype(request.getParameter("typeId"));
		chHouseVO.setRent(Float.valueOf(request.getParameter("maxrent")));
		try
		{
			String res=(String) new ChooseHouseBO().searchFlat(chHouseVO);
//			System.out.println("result from choose flat "+ res);
			if(res!=null)
			{
				RequestDispatcher rd=request.getRequestDispatcher("TenantRegister.jsp");
				request.setAttribute("flatAllocated", res);
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
				request.setAttribute("error","No flat available");
				rd.forward(request, response);
			}
		}
		
		catch (AMSBusinessException e) 
		{
			RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
			request.setAttribute("error", e.getMessage());
			rd.forward(request, response);
		} catch (AMSException e) 
		{
			RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
			request.setAttribute("error", e.getMessage());
			rd.forward(request, response);
		}
		
		
		
		
	}

}

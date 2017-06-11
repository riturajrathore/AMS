package com.ams.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ams.bo.LoginBO;
import com.ams.exceptions.AMSBusinessException;
import com.ams.exceptions.AMSException;
import com.ams.vo.LoginVO;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		LoginVO loginVo=new LoginVO();
		loginVo.setLoginName(request.getParameter("LoginName"));
		loginVo.setPassword(request.getParameter("password"));
		
		try
		{
			boolean res=new LoginBO().ValidUser(loginVo);
			if(res==true)
			{
			
				RequestDispatcher rd=request.getRequestDispatcher("Adminloginsuccess.jsp");
				request.setAttribute("Amin", loginVo.getLoginName());
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("HomeLogin.jsp");
				request.setAttribute("error", "Invalid User Name or password");
			
				
				rd.forward(request, response);
				
				
			}
		}
		catch (AMSBusinessException e) 
		{
			RequestDispatcher rd=request.getRequestDispatcher("HomeLogin.jsp");
			request.setAttribute("error", e.getMessage());
			
			rd.forward(request, response);
			
		}
		catch (AMSException e) 
		{
			RequestDispatcher rd=request.getRequestDispatcher("HomeLogin.jsp");
			request.setAttribute("error", e.getMessage());
		
			rd.forward(request, response);
			
		} 
	}

}

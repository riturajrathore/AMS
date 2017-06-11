package com.ams.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ams.bo.Registerbo;
import com.ams.exceptions.AMSBusinessException;
import com.ams.exceptions.AMSException;
import com.ams.vo.Registervo;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
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
		Registervo regvo=new Registervo();
		regvo.setLoginName(request.getParameter("LoginName"));
		regvo.setPassword(request.getParameter("password"));
		try
			{
			HashMap<String, String>  result =new Registerbo().getTenantData(regvo);
			RequestDispatcher rd=request.getRequestDispatcher("vacanthouse1.jsp");
			request.setAttribute("details", result);
			rd.forward(request, response);
					
			}
		
		catch (AMSException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	 catch (AMSBusinessException e) 
	 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	 catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	 catch (ServletException e)
	 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) 
		{
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 

		
		
		
		
	}

}

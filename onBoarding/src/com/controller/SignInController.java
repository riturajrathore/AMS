package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import com.beans.UserLogin;
import com.bo.LoginBo;

/**
 * Servlet implementation class SignInController
 */
@WebServlet("/SignInController")
public class SignInController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignInController() {
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
		System.out.println("========= tesing ======");
		// TODO Auto-generated method stub
		UserLogin  userBean = new UserLogin(request.getParameter("userName"), request.getParameter("password"));
		LoginBo loginBo = new LoginBo();
		Boolean isValidUser = loginBo.validateUser(userBean.getUserName(),userBean.getPassword());
		String message="";
		if(isValidUser)
		{
			message = "You are successfully loged in....!";
			
		}
		else
		{
			message = "Wrong credentials .... :( ";

		}
		RequestDispatcher requestDispatch = request.getRequestDispatcher("WEB-INF/webPages/home.jsp");
		request.setAttribute("message", message);
		requestDispatch.forward(request, response);
		
	}

}

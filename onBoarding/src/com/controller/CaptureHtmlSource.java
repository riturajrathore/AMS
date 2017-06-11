package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.GetPagesBean;
import com.bo.GetPagesBO;
/**
 * Servlet implementation class CaptureHtmlSource
 */
@WebServlet("/CaptureHtmlSource")
public class CaptureHtmlSource extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CaptureHtmlSource() {
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
		GetPagesBean pageBean = new GetPagesBean();
		pageBean.setSiteName(request.getParameter("siteName"));
		pageBean.setEndSiteUrl(request.getParameter("endSiteUrl"));
		pageBean.setContainerType(request.getParameter("containerType"));
		GetPagesBO pages = new GetPagesBO();
		System.out.println("----------------url-----------------"+pageBean.getEndSiteUrl());
		System.out.println("-------------siteName-------------------"+pageBean.getSiteName());
		System.out.println("--------------endsite---------------"+pageBean.getEndSiteUrl());
		pages.startScreen(pageBean.getEndSiteUrl(),pageBean);

	}

}

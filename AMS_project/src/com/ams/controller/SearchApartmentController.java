package com.ams.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ams.bo.SearchApartmentBO;
import com.ams.exceptions.AMSBusinessException;
import com.ams.exceptions.AMSException;
import com.ams.vo.ApartmentVO;
import com.ams.vo.SearchApartmentVO;

/**
 * Servlet implementation class SearchApartmentController
 */
public class SearchApartmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchApartmentController() {
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
		SearchApartmentVO searchAVO = new SearchApartmentVO();
		searchAVO.setBlockID(request.getParameterValues("blockName"));
		searchAVO.setFlatType(request.getParameter("flatType"));
		searchAVO.setFlatCategory(request.getParameter("flatCategory"));
		searchAVO.setMinimumRent(Integer.parseInt(request.getParameter("minimumRent")));
		searchAVO.setMaximumRent(Integer.parseInt(request.getParameter("maximumRent")));
		searchAVO.setMinimumAdvance(Integer.parseInt(request.getParameter("minimumAdvance")));
		searchAVO.setMaximumAdvance(Integer.parseInt(request.getParameter("maximumAdvance")));
		try
		{
			List<ApartmentVO> result;
			try {
					result = new SearchApartmentBO().SearchData(searchAVO);
			
			RequestDispatcher reqdispatch=request.getRequestDispatcher("SearchResults.jsp");
			request.setAttribute("datas",result);
			reqdispatch.forward(request, response);

				}
			catch (AMSBusinessException e) {
				RequestDispatcher rd=request.getRequestDispatcher("SearchApartments.jsp");
				request.setAttribute("error", e.getMessage());
				rd.forward(request, response);
			}
		}
		catch (AMSException e) 
		{
			RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
			request.setAttribute("error", e.getMessage());
			rd.forward(request, response);
		}
		
		
		
		
	}

}

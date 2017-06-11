package com.ams.controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ams.bo.FlatRegisterBO;
import com.ams.exceptions.AMSBusinessException;
import com.ams.exceptions.AMSException;
import com.ams.vo.FlatRegisterVO;
/**
 * Servlet implementation class FlatRegistrationController
 */
public class FlatRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FlatRegistrationController() {
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
		
		FlatRegisterVO flatRegVo = new FlatRegisterVO();
		flatRegVo.setFlatTypeId(request.getParameter("typeId"));
		flatRegVo.setBlockName(request.getParameter("BlockName"));
		flatRegVo.setFlatCategory(request.getParameter("flat_category"));
		flatRegVo.setFloorNo(request.getParameter("floorNo"));
		flatRegVo.setFlatNo(request.getParameter("flatNum"));
		flatRegVo.setOwnerName(request.getParameter("OwnerName"));
		flatRegVo.setContact(request.getParameter("OwnerContact"));
		flatRegVo.setYearOfConst(request.getParameter("yearOfConst"));
		flatRegVo.setRent(request.getParameter("rent"));
		flatRegVo.setAdvancInMonth(request.getParameter("advanceMonth"));
		flatRegVo.setAddress(request.getParameter("AdressOfOwner"));
		flatRegVo.setStatus(request.getParameter("flatStatus"));
		flatRegVo.setProof(request.getParameter("AddressProof"));
		try
		{
			boolean res=new FlatRegisterBO().validateReg(flatRegVo);	
			if(res==true)
			{
				RequestDispatcher rd=request.getRequestDispatcher("Adminloginsuccess.jsp");
				request.setAttribute("success", "Flat Registered Successfully...!!");
				rd.forward(request, response);
			}
		}
		catch (AMSBusinessException e) 
		{
			RequestDispatcher rd=request.getRequestDispatcher("FlatRegistration.jsp");
			request.setAttribute("error", e.getMessage());
			rd.forward(request, response);
		}
		catch (AMSException e) 
		{
			RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
			request.setAttribute("error", e.getMessage());
			rd.forward(request, response);
		}
		
	}

}

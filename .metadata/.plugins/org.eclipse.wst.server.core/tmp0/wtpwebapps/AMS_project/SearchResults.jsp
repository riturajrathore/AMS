<%@page import="com.ams.vo.ResultListVO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.ams.vo.ApartmentVO,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<SCRIPT type="text/javascript">   
window.history.forward();  
function noBack() 
{
	window.history.forward();
	} 
	</SCRIPT>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<center><title>Available Flats</title></center>
</head>
<body background="BackgroundImage.jpg">
 <table align="right">
<tr><td></td>
<td><input type="image" id="myimage1" style="height:30px;width:100px;" src="logout.jpg" onclick="location.href = 'HomeLogin.jsp';"/></td></tr>
<tr><td></td>
<td><input type="image" id="myimage" style="height:30px;width:100px;" src="homee.jpg" onclick="location.href = 'Adminloginsuccess.jsp';"/></td></tr>


</table>
<center>
<p><font face="Arial" size=20>Available Flats</font></p>
<%! List<ApartmentVO> list; %>

<%
	list=(List<ApartmentVO>)request.getAttribute("datas");

session.setAttribute("avo",list);
String f=list.get(0).getFlat_id(); 
if((f==null))
{
	out.print("<script language=\"javascript\" type=\"text/javascript\">alert(\"No flats are available. Please update the search crtiteria and try again.\");</script>");
			//out.print("<h2>Sorry! No Results found...</h2>");
			
}
else
{
	out.print("<table border=1>");
	for(ApartmentVO AVO:list)
	{out.print("<tr><td>Flat ID:&nbsp;</td><td><a href=\"ApartmentDescription.jsp?index=");
	%><%=AVO.getFlat_id()%>
	<%out.print("\">"); %>
	<%=AVO.getFlat_id()%>
	<%out.print("</a></td>"); 
	}
	out.print("</table>");
	}%>

</center>
</body>
</html>

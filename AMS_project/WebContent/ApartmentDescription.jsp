<%@page import="com.ams.bo.SearchApartmentBO"%>
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
<table align="right">
<tr><td></td>
<td><input type="image" id="myimage1" style="height:30px;width:100px;" src="logout.jpg" onclick="location.href = 'HomeLogin.jsp';"/></td></tr>


</table>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Apartment Details</title>
</head>
<body background="BackgroundImage.jpg">

<%! List<ApartmentVO> list; 
	String var;
	ApartmentVO advo;
%>
<%
list=(List<ApartmentVO>)session.getAttribute("avo");
var=request.getParameter("index");
%>
<center>
<p><font face="Arial" size=20>Flat ID :&nbsp;<%=var %></font></p>
<%


for(ApartmentVO AVO:list)
{
	if(AVO.getFlat_id().equals(var))
	{
		advo=AVO;
	}
}
%>

<table border=1>
<tr><td>Block Name</td><td><%= advo.getBlock_name() %> </td></tr>
<tr><td>Floor No.</td><td><%=  advo.getFloor_no() %> </td></tr>
<tr><td>Flat No.</td><td><%=  advo.getFlat_no() %> </td></tr>
<tr><td>Flat Type</td><td><%=  advo.getType() %> </td></tr>
<tr><td>Flat Category</td><td><%=  advo.getFlatCategory()%> </td></tr>
<tr><td>Rent</td><td><%=  advo.getRent() %> </td></tr>
<tr><td>Advance</td><td><%=  advo.getAdvance_amt() %> </td></tr>
<tr><td>Year of Construction</td><td><%=  advo.getYear_of_construction() %> </td></tr>
<tr><td>Owner Name</td><td><%=  advo.getOwner_name() %> </td></tr>
<tr><td>Owner Contact No.</td><td><%=  advo.getOwner_contact() %> </td></tr>
<tr><td></td>
<td><tr><td></td>
<td><input type="submit" value="Close"  onclick="location.href = 'Adminloginsuccess.jsp';" style="width: 80px; height: 25px;"/></td></tr>

</table></center>


</body>
</html>

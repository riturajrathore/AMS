<!-- final -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Apartment Management System</title>
</head>

<body background="BackgroundImage.jpg" >
	<div id="header">
		<%@include file="Header.html" %>
	 </div>
	<div>
	<br><br><br>
	<form action="LoginController" method="post">
	<table  align='center'>
 
 <tr><td>User Id:</td>
	<td><input type="text" name="LoginName"></td>
	<td> <font color="red"><%if(request.getAttribute("error")!=null){%><%=request.getAttribute("error")%><%} %></font></td>
</tr>
<tr><td>Password:</td>
	<td><input type="password" name="password"></td>
	<td> <font color="red"><%if(request.getAttribute("error1")!=null){%><%=request.getAttribute("error")%><%} %></font></td></tr>
	<tr><td><input type="submit" value="Submit" style="background:#04B4AE; color:#fff;"></td> 
	<td><input type="reset" value="Reset" style="background:#04B4AE; color:#fff;"></td></tr>
</table>

 </form>
	</div>
	
	

</body>
</html>
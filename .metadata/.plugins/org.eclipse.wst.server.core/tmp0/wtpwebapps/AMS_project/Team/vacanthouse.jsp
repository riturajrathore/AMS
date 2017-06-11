<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Controller" method="post">
<h1>Login Page</h1> <center> <h2>Signup Details</h2> 
<table  align='center'>

 <br/><tr><td>Tenant Id:</td>
<td><input type="text" name="LoginName"></td><td> <font color="red"><%if(request.getAttribute("error")!=null){%><%=request.getAttribute("error")
%><%} %></font></td></tr>
<br/><tr><td>Password:</td>
<td><input type="password" name="password"></td><td> <font color="red"><%if(request.getAttribute("error1")!=null){%><%=request.getAttribute("error")
%><%} %></font></td></tr>
<br/><tr><td><input type="submit" value="Submit"></td> 
<td><input type="reset" value="Reset"></td></tr>
</table>
 </form> </center>
</body>
</html>
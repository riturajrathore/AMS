<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<title>Payments Home</title>
</head>
<table align="right">
<tr><td></td>
<td><input type="image" id="myimage1" style="height:30px;width:100px;" src="logout.jpg" onclick="location.href = 'HomeLogin.jsp';"/></td></tr>
<tr><td></td>
<td><input type="image" id="myimage" style="height:30px;width:100px;" src="homee.jpg" onclick="location.href = 'Adminloginsuccess.jsp';"/></td></tr>


</table>

<body background="BackgroundImage.jpg" onload="noBack();"  
	onpageshow="if (event.persisted) noBack();" onunload="">
	
<center><p><font face="Arial" size=20>Payments Home</font></p></center>
	 
	 
	 
<form name="input" action="PaymentController" method="post">
 
<table align='center'  ><br><br><br><br><br><br><br><br><br><br><br><br>
<tr><td><font face="Arial" >Enter TENANT ID:</font></td>
<td> <input type="text" name="tn_id" height='10'><br></td><td><fontface="Arial" size=3 color="red"><%if(request.getAttribute("error")!=null){%><%=request.getAttribute("error")
%><%} %></font></td></tr>

<tr><td></td><td><input type="submit" value="Submit">
<INPUT TYPE="RESET" value="Reset">
</td></tr>
 
 
</table>
</form>
</body>
</html>
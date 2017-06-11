

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


 <table align="right">
<tr><td></td>
<td><input type="image" id="myimage1" style="height:30px;width:100px;" src="logout.jpg" onclick="location.href = 'HomeLogin.jsp';"/></td></tr>
<tr><td></td>
<td><input type="image" id="myimage" style="height:30px;width:100px;" src="homee.jpg" onclick="location.href = 'Adminloginsuccess.jsp';"/></td></tr>


</table>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Select pay field</title>
</head>
<body background="BackgroundImage.jpg" onload="noBack();"  
	onpageshow="if (event.persisted) noBack();" onunload="">

<center><p><font face="Arial" size=20>Select Pay field</font></p></center>
<form name="input1" action="RentController" method="post">
<table align='center'>
<br><br><br>
<tr><td><font face="Arial" >Tenant ID:</font></td><td> <input type="text" name="tn_id" value= <%=request.getAttribute("Tenant")  %> readonly></td></tr>
<tr><td><font face="Arial" color="red" size=5><%if(request.getAttribute("error")!=null){%><%=request.getAttribute("error")
%><%} %></font></td></tr>
<tr><td></td><td><input type="checkbox" name="rent" value="rent1"><font face="Arial" size=3>Rent</font></td></tr>
<tr><td></td><td><input type="checkbox" name="main" value="main1"><font face="Arial" size=3>Maintenance</font></td></tr>
<tr><td></td><td><input type="checkbox" name="lightbill" value="lbill"><font face="Arial" size=3>LightBill</font></td></tr> 
<tr><td></td><td><input type="submit" value="Submit" style="width: 80px; height: 25px;"><INPUT TYPE="RESET" value="Reset" style="width: 80px; height: 25px;"></td></tr>

</table>  
</form>
</body>
</html>
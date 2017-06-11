
<%@page import="com.ams.vo.Registervo"%>
<%@ page import="com.ams.vo.Registervo,java.util.*" %>
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
<title>Vacate Confirm</title>
</head>
<table align="right">
<tr><td></td>
<td><input type="image" id="myimage1" style="height:30px;width:100px;" src="logout.jpg" onclick="location.href = 'HomeLogin.jsp';"/></td></tr>
<tr><td></td>
<td><input type="image" id="myimage" style="height:30px;width:100px;" src="homee.jpg" onclick="location.href = 'Adminloginsuccess.jsp';"/></td></tr>


</table>
<body background="BackgroundImage.jpg" onload="noBack();"  
	onpageshow="if (event.persisted) noBack();" onunload="">
	<center><p><font face="Arial" size=20>Vacate Confirm</font></p></center>
<form action="Pay1.jsp"  method="post">
 <table border='1' align='center'>
 
<%! HashMap data; %>

<%
if(request.getAttribute("details")!=null)
	data=(HashMap<String,String>)request.getAttribute("details");%>
 
<tr><td>Tenant Name <td><input type="text" name="Tenant_name" value="<%=data.get("name")%>" readonly></td></tr>
<tr><td>Occupied Date<td><input type="text" name="Date_of_Occupation" value="<%=data.get("occupiedOn")%>" readonly></td></tr>
<tr><td>Advance Paid <td><input type="text" name="Advance_Paid" value="<%=data.get("paidAdvance")%>" readonly></td></tr>
<tr><td>Flat No. <td><input type="text" name="flat_No" value="<%=data.get("flatNo")%>" readonly></td></tr>
<tr><td>Flat Type <td><input type="text" name="flat_type" value="<%=data.get("flatType")%>" readonly></td></tr>
<tr><td>Block <td><input type="text" name="block" value="<%=data.get("block")%>" readonly></td></tr>
<tr><td>Floor <td><input type="text" name="floor" value="<%=data.get("floor")%>" readonly></td></tr>
 <tr><td>Rent Balance <td><input type="text" name="Rent_balance" value="<%=data.get("dueRent")%>" readonly></td></tr> 
<tr><td>Maintenance Balance <td><input type="text" name="maintenance" value="<%=data.get("dueMaintenance")%>" readonly></td></tr>
<tr><td>Electric Balance <td><input type="text" name="ElectricBill" value="<%=data.get("dueElectricity")%>" readonly></td></tr>
<tr><td></td><td><%if(! (data.get("dueMaintenance").equals("0.0") && data.get("dueElectricity").equals("0.0")&& data.get("dueRent").equals("0.0"))){%><input type="submit" value="PAY" /><%} %> 
</td>


</form>
<td><%if(data.get("dueRent").equals("0.0") && data.get("dueMaintenance").equals("0.0") && data.get("dueElectricity").equals("0.0")){%><input type="submit" value="VACATE" onclick="location.href = 'Success2.jsp';"/><%} %><button type="reset" value="Reset">Reset</button></td>

</table>
</body>
</html>
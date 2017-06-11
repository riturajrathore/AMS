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
<title>Payment Details</title>
</head>
<body background="BackgroundImage.jpg" onload="noBack();" onpageshow="if (event.persisted) noBack();" onunload="">
	<center><p><font face="Arial" size=20>Payment Details</font></p></center>

<form name="input1" action="Pay3Controller" method="post">
<table  align='center'>
<tr><td>Tenant_ID:</td><td><b> <input type="text" name="tn_id" value= <%=request.getAttribute("Tenant")  %> readonly></b></td></tr>

 

 

 


<tr><td>
<font face="Arial" size=3>Flat Owner Name:</font></td><td><input type="text" name="owner_name"  value=<%=request.getAttribute("OwnerName") %> readonly></td></tr>
 <tr><td><font face="Arial" size=3>Tenant Name:</font></td><td><input type="text" name="Tn_name"  value=<%=request.getAttribute("TName")  %>  readonly></td></tr>
<tr><td><font face="Arial" size=3>Flat_ID:</font></td><td><input type="text" name="flat_id" value= <%=request.getAttribute("Flatid")  %>  readonly></td></tr>
<tr><td><font face="Arial" size=3>Block:</font></td><td><input type="text" name="block" value=<%=request.getAttribute("Block") %> readonly></td></tr>
<tr><td><font face="Arial" size=3>Floor:</font></td><td><input type="text" name="floor"  value=<%=request.getAttribute("floor")  %>  readonly></td></tr>
<tr><td><font face="Arial" size=3>Flat Type:</font></td><td><input type="text" name="flat_type"  value=<%=request.getAttribute("flattype") %>  readonly></td></tr>
<tr><td><font face="Arial" size=3>Rent:</font></td><td><input type="text" name="rent" value=<%=request.getAttribute("rent") %> readonly></td></tr>
<tr><td><font face="Arial" size=3>Maintenance:</font></td><td><input type="text" name="maintenance" value=<%=request.getAttribute("main")  %> readonly></td></tr>
<tr><td><font face="Arial" size=3>LightBill:</font></td><td><input type="text" name="lightbill" value=<%=request.getAttribute("lightbill")  %> readonly></td></tr>
<tr><td><font face="Arial" size=3>Grand Total:</font></td><td><input type="text" name="total"  value=<%=request.getAttribute("total")  %> readonly></td></tr>
<tr><td><font face="Arial" size=3>Month:</font></td><td><input type="text" name="month" value=<%=request.getAttribute("mnth")  %> readonly></td></tr>
<tr><td><font face="Arial" size=3>Date:</font></td><td><input type="text" name="date" value=<%=request.getAttribute("date")  %> readonly></td></tr>
<tr><td></td><td><input type="submit" value="PAY" style="width: 80px; height: 25px;"><INPUT TYPE="RESET" value="Reset" style="width: 80px; height: 25px;">
</td></tr>

</table>
</form>
</body>

</html>
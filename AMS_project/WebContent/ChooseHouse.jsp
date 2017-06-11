<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<table align="right">
<tr><td></td>
<td><input type="image" id="myimage1" style="height:30px;width:100px;" src="logout.jpg" onclick="location.href = 'HomeLogin.jsp';"/></td></tr>
<tr><td></td>
<td><input type="image" id="myimage" style="height:30px;width:100px;" src="homee.jpg" onclick="location.href = 'Adminloginsuccess.jsp';"/></td></tr>
</table>
<SCRIPT type="text/javascript">   
window.history.forward();  
function noBack() 
{
	window.history.forward();
	} 
	</SCRIPT>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Choose Flat</title>
</head>
<body background="BackgroundImage.jpg" onload="noBack();"  
	onpageshow="if (event.persisted) noBack();" onunload="">
	<center><p><font face="Arial" size=20>Choose Flat</font></p></center>
<center>

<form action="ChooseHouseController" method="post">

<table align="center" >
<tr><td><font face="Arial">Flat Type</font></td><td><select name="typeId">
  											<option value="1B">1BHK</option>
  											<option value="2B">2BHK</option>
  										</select> 
  					 </td>
</tr>
<tr><td><font face="Arial"> Maximum Rent</font></td><td><input type="text" name="maxrent"></td></tr>

<tr><td><input type="submit" value="Register" style="width: 80px; height: 25px;"></td>
<td><input type="reset" value="Reset" style="width: 80px; height: 25px;"></td></tr>

</table>
</form>

</center>
</body>
</html>
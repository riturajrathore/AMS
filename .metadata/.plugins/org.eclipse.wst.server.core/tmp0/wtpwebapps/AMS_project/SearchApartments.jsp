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
<title>Search Apartments</title>
</head>
<body background="BackgroundImage.jpg" onload="noBack();"  
	onpageshow="if (event.persisted) noBack();" onunload="">
<table align="right">
<tr><td></td>
<td><input type="image" id="myimage1" style="height:30px;width:100px;" src="logout.jpg" onclick="location.href = 'HomeLogin.jsp';"/></td></tr>
<tr><td></td>
<td><input type="image" id="myimage" style="height:30px;width:100px;" src="homee.jpg" onclick="location.href = 'Adminloginsuccess.jsp';"/></td></tr>


</table>
<br>
<center><p><font face="Arial" size=20>Search Apartments</font></p></center>


<form action="SearchApartmentController" method="post">

<table align="center">
<tr><font face="Arial" size=4>
	<td>Flat Type &nbsp;</td>
	<td>	<select name="flatType">
	    	<option value="none">----Any----</option>
  			<option value="1B">1BHK</option>
			<option value="2B">2BHK</option>
			</select> 
	</td>
	</font>
</tr>

<tr><br></tr>

<tr><font face="Arial" size=4>
	<td>Flat Category &nbsp;</td>
	<td>	<select name="flatCategory">
  			<option value="non-furnished">Non-Furnished</option>
			<option value="semi-furnished">Semi-Furnished</option>
			<option value="furnished">Furnished</option>
			</select> 
	</td>
	</font>
</tr>

<tr><br></tr>

<tr><font face="Arial" size=4>
	<td>Block Variant</td>
	<td>             <input type="checkbox" name="blockName" value="BP">Pearl<br>
					 <input type="checkbox" name="blockName" value="BE">Emerald<br>
					 <input type="checkbox" name="blockName" value="BT">Topaz<br>
				     <input type="checkbox" name="blockName" value="BD">Diamond 
	</td>
	</font>
</tr>

<tr><br></tr> 

<tr><font face="Arial" size=4>
	<td>Rent</td>
	<td>	<select name="minimumRent">
	    	<option value="0">0</option>
  			<option value="5000">5000</option>
			<option value="10000">10000</option>
			<option value="15000">15000</option>
			<option value="20000">20000</option>
			<option value="30000">30000</option>
			</select> 
	</td>
	<td>	<select name="maximumRent">
	    	
  			<option value="5000">5000</option>
			<option value="10000">10000</option>
			<option value="15000">15000</option>
			<option value="20000">20000</option>
			<option value="30000">30000</option>
			<option value="50000">50000</option>
			<option value="100000">100000</option>
			</select> 
	</td>	
	</font>					
</tr>

<tr><br></tr>

<tr><font face="Arial" size=4>
	<td>Advance</td>
	<td>	<select name="minimumAdvance">
			<option value="1000">1000</option>
			<option value="10000">10000</option>				
			<option value="15000">15000</option>			
			<option value="20000">20000</option>
			<option value="30000">30000</option>
			</select> 
	</td>
	<td>	<select name="maximumAdvance">
			<option value="10000">10000</option>
	    	<option value="15000">15000</option>			
			<option value="20000">20000</option>
			<option value="30000">30000</option>
			<option value="50000">50000</option>
			<option value="100000">100000</option>
			</select> 
	</td>	
	</font>					
</tr>

<tr><br></tr>

<tr><td></td><td><input type="submit" value="Search" style="width: 80px; height: 25px;"></td><td><INPUT TYPE="RESET" value="Reset" style="width: 80px; height: 25px;"></td></tr>
</table>
</form>
  <% if(request.getAttribute("error")!=null) {%>
	<table align="center">
		<tr><td><font color="red"><%= request.getAttribute("error") %></font></td>
		</tr>
	</table>
	<%} %>
</body>
</html>
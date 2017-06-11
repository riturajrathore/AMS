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

	</SCRIPT>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Flat</title>
</head>
<body background="BackgroundImage.jpg"  
	onpageshow="if (event.persisted) noBack();" onunload="">
	<center><p><font face="Arial" size=20>Register Flats</font></p></center>
	
	<br><br>
	
	
	<form action="FlatRegistrationController" method="post">
		<table align="center">		
				<tr>
					<td>Flat Type</td><td><select name="typeId">
  											<option value="1B">1BHK</option>
  											<option value="2B">2BHK</option>
  										</select> </td>
				</tr>
				<tr>
					<td>Flat Category</td><td><select name="flat_category">
  											<option value="Non-Furnished">Non-Furnished</option>
  											<option value="Semi-Furnished">Semi-Furnished</option>
  											<option value="Furnished">Furnished</option>
  										</select> </td>
  					
				</tr>
				
				<tr>
					<td>Block Name:</td><td><select name="BlockName">
  											<option value="Pearl">Pearl</option>
  											<option value="Emerald">Emerald</option>
  											<option value="Topaz">Topaz</option>
  											<option value="Diamond">Diamond</option>
  										</select> </td>
				</tr>
				<tr>
					<td>Floor Number:</td><td><select name="floorNo">
  											<option value="1">1</option>
  											<option value="2">2</option>
  											<option value="3">3</option>
  											<option value="4">4</option>
  											<option value="5">5</option>
  											<option value="6">6</option>
  											<option value="7">7</option>
  											<option value="8">8</option>
  											<option value="9">9</option>
  											<option value="10">10</option>
  											<option value="11">11</option>
  											<option value="12">12</option>
  										</select> </td>
				</tr>
				<tr>
					<td>Flat Number:</td><td><select name="flatNum">
  											<option value="1">1</option>
  											<option value="2">2</option>
  											<option value="3">3</option>
  											<option value="4">4</option>
  											<option value="5">5</option>
  											<option value="6">6</option>
  											<option value="7">7</option>
  											<option value="8">8</option>
  											<option value="9">9</option>
  											<option value="10">10</option>
  											<option value="11">11</option>
  											<option value="12">12</option>
  											<option value="13">13</option>
  											<option value="14">14</option>
  											<option value="15">15</option>
  										</select> </td>
				</tr>
				<tr>
					<td>Owner Name:</td><td><input type="text" Name="OwnerName"<% if(request.getParameter("OwnerName")!=null) 
	{%>value="<%=request.getParameter("OwnerName")%>"<%} %>></td>
				</tr>	
				<tr>
					<td>Owner Contact:</td><td><input type="text" Name="OwnerContact"<% if(request.getParameter("OwnerContact")!=null) 
	{%>value="<%=request.getParameter("OwnerContact")%>"<%} %>></td>
				</tr>
				<tr>
					<td>Year Of Construction:</td><td><input type="text" name="yearOfConst"<% if(request.getParameter("yearOfConst")!=null) 
	{%>value="<%=request.getParameter("yearOfConst")%>"<%} %>></td>
				</tr>
				<tr>
					<td>Rent:</td><td><input type="text" name="rent"<% if(request.getParameter("rent")!=null) 
	{%>value="<%=request.getParameter("rent")%>"<%} %>></td>
				</tr>
				<tr>
					<td>Advance(Number of Months):</td><td><input type="text" name="advanceMonth"<% if(request.getParameter("advanceMonth")!=null) 
	{%>value="<%=request.getParameter("advanceMonth")%>"<%} %>></td>
				</tr>
				<tr>		
					
					<td>Address:</td><td><input type="text" size="50" name="AdressOfOwner"<% if(request.getParameter("AdressOfOwner")!=null) 
	{%>value="<%=request.getParameter("AdressOfOwner")%>"<%} %>>  </td>
				</tr>	
				<tr>
					<td>Status:</td><td><select name="flatStatus">
  											<option value="vacant">Vacant</option>
  											<option value="occupied">Occupied</option>
  										</select> </td>
				</tr>		
				<tr>
					<td>Proof:</td><td><select name="AddressProof">
  											<option value="Voter Id">Voter Id</option>
  											<option value="Ration Card">Ration Card</option>
  											<option value="Water Tax">Water Tax</option>
  											<option value="House Tax">House Tax</option>
  											<option value="Employee Id Card">Employee ID Card</option>
  										</select> </td>
				</tr>	
				<tr>
					<td></td><td><input type="submit" value="Register" style="width: 80px; height: 25px;"><input type="reset" value="Reset"style="width: 80px; height: 25px;"></td>
				</tr>
		</table>
	</form>
	
	
	<% if(request.getAttribute("error")!=null) {%>
	<table align="center">
		<tr><td><font color="red"><%= request.getAttribute("error") %></font></td></tr>
	</table>
	<%} %>
	

</body>
</html>
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
<title>Tenant Registration</title>


     <script language="javaScript" type="text/javascript" src="calendar.js"></script>
   <link href="calendar.css" rel="stylesheet" type="text/css">
</head>
<body background="BackgroundImage.jpg" onload="noBack();"  
	onpageshow="if (event.persisted) noBack();" onunload="">
	<center><p><font face="Arial" size=20>Tenant Registration</font></p></center>

<form action="TenantRegisterController" method="post">

<table align="center"> 
<tr><td>Flat Allocated</td><td><input type = "text" name="flat_id" value="<%if(request.getAttribute("flatAllocated")!=null){%><%=request.getAttribute("flatAllocated")
%><%} %>" readonly></td></tr>
<tr><td>First Name</td><td><input type="text" name="fname"></td></tr>

<tr><td>Last Name</td><td><input type="text" name="lname"></td></tr>

<tr><td> 
	<label for="dob">Date Of Birth</label></td>
  <td>
      <input type="text" name="dob" readonly><a href="#" onClick="setYears(1947, 2025);
       showCalender(this, 'dob');">
      <img src="calender.png"></a></td></tr>

<tr><td>Gender</td><td>
<input type="radio" name="sex" value="M">Male
<input type="radio" name="sex" value="F">Female<br>
</td></tr>

<tr><td>Family Members</td><td>
<select name="familymem">
  <option value="1">1</option>
  <option value="2">2</option>
  <option value="3">3</option>
  <option value="4">4</option>
  <option value="5">5</option>
</select>
</td>

<tr><td>Native Place</td><td><input type="text" name="place"></td></tr>

<tr><td>Contact</td><td><input type="text" name="contact"></td></tr>

<tr><td>Income Source</td><td>
<select name="incomesrc">
  <option value="salary">Salary</option>
  <option value="business">Business</option>
</select>
</td>

<tr><td>ID Proof</td><td>
<select name="idproof">
  <option  value="P1">Voter ID</option>
  <option  value="P2">Ration Card</option>
  <option  value="P3">Water Tax</option>
  <option  value="P4">House Tax</option>
  <option  value="P5">Employee ID Card</option>
</select>
</td>

<tr><td>Advance paid</td><td><input type="text" name="advancePaid"></td></tr>
<tr><td>Duration of Stay</td><td>
<select name="durofstay">
  <option  value="lessthan11months">Less than 11 Months</option>
  <option  value="11months">11 Months</option>
  <option  value="morethan11months">More than 11 Months</option>
</select>
</td>





<tr><td>Occupied on</td><td>
      <input type="text" name="agrstartdate" readonly><a href="#" onClick="setYears(1947, 2025);
       showCalender(this, 'agrstartdate');">
      <img src="calender.png"></a></td></tr>

<tr><td>Agreement End Date</td><td>
 <input type="text" name="agrenddate" readonly><a href="#" onClick="setYears(1947, 2025);
       showCalender(this, 'agrenddate');">
      <img src="calender.png"></a></td></tr>



<tr><td><input type="submit" value="Register"></td>
<td><input type="reset" value="Reset"></td></tr>


</table>
</form>
<table id="calenderTable">
        <tbody id="calenderTableHead">
          <tr>
            <td colspan="4" align="center">
	          <select onChange="showCalenderBody(createCalender(document.getElementById('selectYear').value,
	           this.selectedIndex, false));" id="selectMonth">
	              <option value="0">Jan</option>
	              <option value="1">Feb</option>
	              <option value="2">Mar</option>
	              <option value="3">Apr</option>
	              <option value="4">May</option>
	              <option value="5">Jun</option>
	              <option value="6">Jul</option>
	              <option value="7">Aug</option>
	              <option value="8">Sep</option>
	              <option value="9">Oct</option>
	              <option value="10">Nov</option>
	              <option value="11">Dec</option>
	          </select>
            </td>
            <td colspan="2" align="center">
			    <select onChange="showCalenderBody(createCalender(this.value, 
				document.getElementById('selectMonth').selectedIndex, false));" id="selectYear">
				</select>
			</td>
            <td align="center">
			    <a href="#" onClick="closeCalender();"><font color="#003333" size="+1">X</font></a>
			</td>
		  </tr>
       </tbody>
       <tbody id="calenderTableDays">
         <tr style="">
           <td>Sun</td><td>Mon</td><td>Tue</td><td>Wed</td><td>Thu</td><td>Fri</td><td>Sat</td>
         </tr>
       </tbody>
       <tbody id="calender"></tbody>
    </table>

</body>
</html>
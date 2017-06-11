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
<title>Apartment Management System</title>
</head>
<body background="BackgroundImage.jpg" style="overflow:hidden;" onload="noBack();"  
	onpageshow="if (event.persisted) noBack();" onunload="">
<div id="header">
		<%@include file="Header.html" %>
</div>

<div>
<%String name=(String)request.getAttribute("Amin"); %>
<% if(name!=null) {%>
<% session.setAttribute("user_name", name); %> 
<%} %><br><br>
<center><font face="Arial" size=4>WELCOME:<%=session.getAttribute("user_name")%></font></center>

	
<table align="right">
<tr><td><input type="image" id="myimage1" style="height:30px;width:100px;" src="logout.jpg" onclick="location.href = 'HomeLogin.jsp';"/></td></tr>

</table>
<br><br>
<table>	
 
 
 <style>
#bt-menu, #bt-menu ul {
margin: 0;
padding: 0;
list-style: none;
}
#bt-menu {
width: 125%;
margin: 20px auto;
background: #DADFE1;
-moz-border-radius: 2px;
-webkit-border-radius: 2px;
-moz-box-shadow: 0 1px 1px #777;
-webkit-box-shadow: 0 1px 1px #777;
box-shadow: 0 1px 1px #777;
}
#bt-menu:before,
#bt-menu:after {
content: "";
display: table;
}
#bt-menu:after {
clear: both;
}
#bt-menu {
zoom:1;
}
#bt-menu li {
float: left;
-moz-box-shadow: 1px 0 0 #444;
-webkit-box-shadow: 1px 0 0 #444;
box-shadow: 1px 0 0 #444;
position: relative;
}
#bt-menu a {
float: left;
padding: 10px 70px;
color: #000000;
text-transform: uppercase;
font: bold 12px Arial, Helvetica;
text-decoration: none;
text-shadow: 0 0px 0 #000;
}
#bt-menu li:hover > a {
background: #333333;
color: #fafafa;
}
*html #bt-menu li a:hover { /* IE6 only */
color: #333333;
}
#bt-menu ul {
margin: 70px 0 0 0;
_margin: 0; /*IE6 only*/
opacity: 0;
visibility: hidden;
position: absolute;
top: 38px;
left: 0;
z-index: 9999;
background: #DADFE1 url('images/pageglare.png') no-repeat scroll;
 -moz-border-radius: 3px;
-webkit-border-radius: 3px;
border-radius: 3px;
-webkit-transition: all .3s ease-in-out;
-moz-transition: all .3s ease-in-out;
-ms-transition: all .3s ease-in-out;
-o-transition: all .3s ease-in-out;
transition: all .3s ease-in-out;
}
#bt-menu li:hover > ul {
opacity: 1;
visibility: visible;
margin: 0;
}
#bt-menu ul ul {
top: 0;
left: 400px;
margin: 0 0 0 10px;
_margin: 0; /*IE6 only*/
-moz-box-shadow: -1px 0 0 rgba(255,255,255,.3);
-webkit-box-shadow: -1px 0 0 rgba(255,255,255,.3);
box-shadow: -1px 0 0 rgba(255,255,255,.3);
}
#bt-menu ul li {
float: none;
display: block;
border: 0;
_line-height: 0; /*IE6 only*/
-moz-box-shadow: 0 1px 0 #111, 0 2px 0 #666;
-webkit-box-shadow: 0 1px 0 #111, 0 2px 0 #666;
box-shadow: 0 1px 0 #111, 0 2px 0 #666;
}
#bt-menu ul li:last-child {
-moz-box-shadow: none;
-webkit-box-shadow: none;
box-shadow: none;
}
#bt-menu ul a {
padding: 10px;
width: 130px;
_height: 6px; /*IE6 only*/
display: block;
white-space: nowrap;
float: none;
text-transform: none;
}
#bt-menu ul a:hover {
background-color: #333333;
}
#bt-menu ul li:first-child > a {
-moz-border-radius: 3px 3px 0 0;
-webkit-border-radius: 3px 3px 0 0;
border-radius: 3px 3px 0 0;
}
#bt-menu ul li:first-child > a:after {
content: '';
position: absolute;
left: 40px;
top: -6px;
border-left: 6px solid transparent;
border-right: 6px solid transparent;
border-bottom: 6px solid #333333;
}
#bt-menu ul ul li:first-child a:after {
left: -6px;
top: 50%;
margin-top: -6px;
border-left: 0;
border-bottom: 6px solid transparent;
border-top: 6px solid transparent;
border-right: 4px solid #333333;
}
#bt-menu ul li:first-child a:hover:after {
border-bottom-color: #DADFE1;
}
#bt-menu ul ul li:first-child a:hover:after {
border-right-color: #DADFE1;
border-bottom-color: transparent;
}
#bt-menu ul li:last-child > a {
-moz-border-radius: 0 0 2px 2px;
-webkit-border-radius: 0 0 3px 3px;
border-radius: 0 0 3px 3px;
}

</style>
<tr><td>
<ul id="bt-menu"> 
<li><a href="FlatRegistration.jsp">Flat Registration</a></li> 
<li> 
<a href="SearchApartments.jsp">Search Apartments</a> </li>


<li><a href="ChooseHouse.jsp">Tenant Registration</a></li> 


<li><a href="Pay1.jsp">Payments</a></li>
<li><a href="vacanthouse.jsp">Vacate House</a></li> 
</li> 
 <% if(request.getAttribute("success")!=null) 
	{%>
			<tr><td><font face="Arial" color="green" size=5><%= request.getAttribute("success") %></font></td></tr>
	<%} %>
 </ul>
 </td></tr>
 
 </table>
 
 
  </div>
 
</body>
</html>
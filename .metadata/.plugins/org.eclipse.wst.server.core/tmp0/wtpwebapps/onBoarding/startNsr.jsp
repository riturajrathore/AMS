<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
header {
    background-color:#07409b;
    color:#07409b;
    text-align:center;
    padding:2px;	
     
}
nav {
    line-height:30px;
    background-color:#eeeeee;
    height:500px;
    width:150px;
    float:left;
    padding:5px;	      
}

aside {
    line-height:30px;
    background-color:#eeeeee;
    height:500px;
    width:300px;
    float:right;
    padding:5px;	 
}
section {
    width:100px;
    float:left;
    padding:10px;	 	 
}
footer {
    background-color:#07409b;
    color:white;
    clear:both;
    text-align:center;
    padding:5px;	 	 
}
table, th , td {
    border: 1px solid grey;
    border-collapse: collapse;
    padding: 5px;
    width: 50%;
}

th {
    text-align: center; 
    height: 50%;
}

table tr:nth-child(odd) {
    background-color: #f1f1f1;
}
table tr:nth-child(even) {
    background-color: #ffffff;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<header><img src="YodleeLogo.png" align="left" height="60">
<div style="background:white;text-align: center;font-size: 50px;height: 80%;">
Yodlee Money Center
</div></header>
<nav><a href="EndSiteWeb.jsp"><b><u>Home</u></b></a><br>
	<a href="about.jsp"><b><u>About Us</u></b></a><br>
	<a href="signin.jsp"><b><u>Sign in</u></b></a><br>
	<a href="signup.jsp"><b><u>Sign Up</u></b></a><br>
	<a href = "testYodleeMoneyCenter.jsp"><b><u>Add Accounts</u></b></a>
</nav>

<section>
<form action="CaptureHtmlSource" method="post">
		<table>
		<tr><td>Site Name :</td><td><input type="text" name = "siteName"></td></tr>
		<tr><td>Account Type</td><td><input type ="text" name ="containerType"></td></tr>
		<tr><td>Login Url</td><td><input type ="text" name ="endSiteUrl"></td></tr>
		<tr><td></td><td><input type="submit"></td></tr>
	</table>

</form>
</section>
<aside>
<br><br><br>
<font size="3">Site Not found..??<br></font>
	<a href="startNsr.jsp">
  		<font color="blue"> <b><u>Help us to develop</u></b></font>
	</a>
</aside>
<footer><p> &copy;Envestnet Yodlee | Powered by THE DREAM BUILDERS</p></footer>
</body>
</html>
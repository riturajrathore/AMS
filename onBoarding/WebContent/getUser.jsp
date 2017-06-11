<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
header {
    background-color:black;
    color:white;
    text-align:center;
    padding:20px;	 
}
nav {
    line-height:30px;
    background-color:#eeeeee;
    height:300px;
    width:100px;
    float:left;
    padding:5px;	      
}

section {
    width:200px;
    float:left;
    padding:10px;	 	 
}

footer {
    background-color:black;
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:include page="WEB-INF/webPages/header.jsp"></jsp:include>	<!-- include at compile time -->
<body>
<br><br>
<form action="SelectQueryController">
<table align="center">
<tr><td><label for="dbSelect">Select DB to Run the Query:</label></td>
	<td><select id="dbSelect" name="dbName">
	<option>Repalda</option>
	<option>TestDB</option>
	<option>SiteP</option>
	<option>Bugzilla</option>
	</select></td>
</tr>
<tr><td>
<label for="querySelect">Select query to Run:</label></td>
	<td><select id="querySelect" name="query">
		<option>Getting user</option>
		<option>Success rate of the site</option>
		<option>other</option>
		<option>get MII for the bugs</option>
	</select></td>
</tr>
<tr><td></td><td><input type="submit"></td></tr>
</table>
</form>
</body>
</html>
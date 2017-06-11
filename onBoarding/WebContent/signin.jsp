<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style>
header {
    background-color:#a1c1f4;
    color:#a1c1f4;
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
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:include page="WEB-INF/webPages/header.jsp"></jsp:include>	<!-- include at compile time -->

<body>
<br><br>
<form action="SignInController" method="post">
<table align="center">
	<tr><td>User Name :</td><td><input type="text" name = "userName"></td></tr>
	<tr><td>Password :</td><td><input type ="password" name ="password"></td></tr>
	<tr><td></td><td><input type="submit"></td></tr>
</table>
</form>
<footer><p> &copy; Rituraj</p></footer>
</body>
</html>
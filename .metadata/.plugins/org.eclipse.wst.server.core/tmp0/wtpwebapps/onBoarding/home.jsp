<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
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
</style>
<link rel="stylesheet" type="text/css" href="site.css">
<meta charset="ISO-8859-1">
<title>Onboarding</title>
</head>
<jsp:include page="WEB-INF/webPages/header.jsp"></jsp:include>	<!-- include at compile time -->

<body>
<section>
<marquee width="800">
<p>Welcome to our WEBSITE.... !</p>
</marquee>

<%if(null!=request.getAttribute("message")){ %>
<%=request.getAttribute("message") %><%} %>
</section>
<article></article>
<footer><p> &copy; Rituraj</p></footer>
</body>
</html>
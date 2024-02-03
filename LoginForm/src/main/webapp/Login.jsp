<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.Style{
background-color:azure;
display:flex;
justify-content: center;
align-content: center;
align-items: center;
height:250px;

}
</style>
</head>
<body>
<%
HttpSession s=request.getSession();
String name=(String) s.getAttribute("name");

%>
<h1 style="color:green">Successfuly Register  <%= name%></h1>

<form action="Login" method="post">
<div class="Style">
<fieldset>
<h1>Login Form</h1>
<label for="email">Enter Email Id:</label><input type="text" required name="email"/><br><br>
<label for="password">Enter Password:</label><input type="Password" required name="password"/><br><br>

<input type="submit" style="margin-left:100px">
</fieldset>
</div>

</form>
</body>
</html>
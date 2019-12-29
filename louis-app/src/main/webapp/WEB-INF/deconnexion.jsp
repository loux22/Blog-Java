<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deconnexion</title>
</head>
<body>
<c:if test = "${ empty sessionScope.id}"> 
<c:redirect url = "http://localhost:8080/louis-app/"/>
</c:if>
</body>
</html>
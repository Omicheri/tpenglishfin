<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>English Test</title>
</head>
<body>
<h1>Bienvenue sur English Test</h1>
<form action="index" method="post">
  Email: <input type="text" name="email" /><br/>
  Mot de Passe: <input type="password" name="password" /><br/>
  <input type="submit" value="Connexion" />
</form>
<c:if test="${not empty errorMessage}">
  <p style="color:red;">${errorMessage}</p>
</c:if>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: DÉVELOPPEUR
  Date: 14/02/2025
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Game Over</title>
</head>
<body>
<h2>Game Over</h2>
<p><%= request.getAttribute("message") %></p>
<a href="jeu">Recommencer</a>
</body>
</html>



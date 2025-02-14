<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Jeu</title>
</head>
<body>
<h2>Donnez le prétérit et le participe passé</h2>

<p>Verbe : <strong><%= request.getAttribute("currentVerb") %></strong></p>
<p>Score : <strong><%= request.getSession().getAttribute("score") != null ? request.getSession().getAttribute("score") : 0 %></strong></p>

<form action="jeu" method="post">
    <label for="pastSimple">Prétérit :</label>
    <input type="text" name="pastSimple" id="pastSimple" required><br>

    <label for="pastParticiple">Participe passé :</label>
    <input type="text" name="pastParticiple" id="pastParticiple" required><br>

    <button type="submit">Valider</button>
</form>

<% if (request.getAttribute("message") != null) { %>
<p style="color: red;"><%= request.getAttribute("message") %></p>
<% } %>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Inscription</title>
</head>
<body>
<h2>Inscription</h2>
<form action="InscriptionServlet" method="post">
    <label for="email">Email :</label>
    <input type="email" name="email" id="email" required><br>

    <label for="password">Mot de passe :</label>
    <input type="password" name="password" id="password" required><br>

    <label for="firstName">Prénom :</label>
    <input type="text" name="firstName" id="firstName" required><br>

    <label for="lastName">Nom :</label>
    <input type="text" name="lastName" id="lastName" required><br>

    <label for="city">Ville :</label>
    <select name="city" id="city" required>
        <option value="Paris">Paris</option>
        <option value="Lyon">Lyon</option>
        <option value="Marseille">Marseille</option>
    </select><br>

    <button type="submit">S'inscrire</button>
</form>

<% if (request.getAttribute("errorMessage") != null) { %>
<p style="color: red;"><%= request.getAttribute("errorMessage") %></p>
<% } %>
<a href="index.jsp">Retour à la connexion</a>
</body>
</html>

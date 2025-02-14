package servlets;

import dao.JoueurDao;
import pojos.Joueur;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "InscriptionServlet", urlPatterns ={"/InscriptionServlet"})
public class InscriptionServlet extends HttpServlet {
    private final JoueurDao joueurDao = new JoueurDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String city = request.getParameter("city");

        // Vérification des champs vides
        if (email == null || email.isEmpty() || password == null || password.isEmpty() ||
                firstName == null || firstName.isEmpty() || lastName == null || lastName.isEmpty() ||
                city == null || city.isEmpty()) {

            request.setAttribute("errorMessage", "Tous les champs doivent être remplis.");
            request.getRequestDispatcher("/inscription.jsp").forward(request, response);
            return;
        }

        // Création d'un nouvel objet Joueur
        Joueur joueur = new Joueur();
        joueur.setEmail(email);
        joueur.setMotDePasse(password);
        joueur.setPrenom(firstName);
        joueur.setNom(lastName);
        joueur.setVille(city);

        // Enregistrement du joueur
        try {
            joueurDao.save(joueur);
            response.sendRedirect("index");
        } catch (Exception e) {
            request.setAttribute("errorMessage", "Erreur lors de l'inscription.");
            request.getRequestDispatcher("/inscription.jsp").forward(request, response);
        }
    }
}

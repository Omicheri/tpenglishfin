package servlets;

import dao.JoueurDao;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pojos.Joueur;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@WebServlet(name = "IndexServlet", urlPatterns = {"/index"})
public class IndexServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(IndexServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (Exception e) {
            response.getWriter().write("Erreur lors de la redirection : " + e.getMessage());
        }
    }

    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            logger.info("Tentative de connexion avec l'email : {}", email);

            JoueurDao joueurDao = new JoueurDao();
            Joueur joueur = joueurDao.findByEmailAndPassword(email, password);

            if (joueur != null) {
                logger.info("Connexion réussie pour l'utilisateur : {}", email);
                HttpSession session = request.getSession();
                session.setAttribute("playerId", joueur.getId());
                response.sendRedirect("jeu");
            } else {
                logger.warn("Échec de la connexion pour l'utilisateur : {}", email);
                request.setAttribute("errorMessage", "Email ou mot de passe incorrect.");
                try {
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                } catch (Exception e) {
                    logger.error("Erreur lors de la redirection : ", e);
                    response.getWriter().write("Erreur lors de la redirection : " + e.getMessage());
                }
            }
        }
    }

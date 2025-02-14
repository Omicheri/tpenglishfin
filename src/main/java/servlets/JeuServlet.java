package servlets;

import dao.VerbDao;
import dao.PartieDao;
import dao.QuestionDao;
import pojos.Verb;
import pojos.Partie;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;

@WebServlet(name = "JeuServlet", urlPatterns = {"/jeu"})
public class JeuServlet extends HttpServlet {

    private final VerbDao verbDao = new VerbDao();
    private final PartieDao partieDao = new PartieDao();
    private final QuestionDao questionDao = new QuestionDao();
    private final Random random = new Random();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Long playerIdLong = (Long) session.getAttribute("playerId");
        Integer playerId = playerIdLong != null ? playerIdLong.intValue() : null;

        if (playerId == null) {
            response.sendRedirect("index"); // Redirigez vers la page de connexion si l'utilisateur n'est pas connecté
            return;
        }

        // Créer une nouvelle partie
        int partieId = partieDao.createPartie(playerId);
        session.setAttribute("partieId", partieId);

        List<Verb> verbs = verbDao.getAllVerbs();
        if (!verbs.isEmpty()) {
            Verb randomVerb = verbs.get(random.nextInt(verbs.size()));
            session.setAttribute("currentVerb", randomVerb);
            request.setAttribute("currentVerb", randomVerb.getBaseVerbale());
        } else {
            request.setAttribute("currentVerb", "Aucun verbe disponible");
        }
        request.getRequestDispatcher("/jeu.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pastSimple = request.getParameter("pastSimple");
        String pastParticiple = request.getParameter("pastParticiple");

        HttpSession session = request.getSession();
        Verb currentVerb = (Verb) session.getAttribute("currentVerb");
        Integer score = (Integer) session.getAttribute("score");
        if (score == null) {
            score = 0;
        }

        if (currentVerb != null) {
            String correctPastSimple = currentVerb.getPreterit();
            String correctPastParticiple = currentVerb.getParticipePasse();

            // Enregistrement de la question
            Long playerIdLong = (Long) session.getAttribute("playerId");
            Long partieIdLong = (Long) session.getAttribute("partieId");
            Integer playerId = playerIdLong != null ? playerIdLong.intValue() : null;
            Integer partieId = partieIdLong != null ? partieIdLong.intValue() : null;

            Date dateEnvoi = new Date();
            Date dateReponse = new Date(); // Vous pouvez ajuster cela selon votre logique
            questionDao.createQuestion(partieId, currentVerb.getId(), pastSimple, pastParticiple, dateEnvoi, dateReponse);

            if (correctPastSimple.equalsIgnoreCase(pastSimple) && correctPastParticiple.equalsIgnoreCase(pastParticiple)) {
                score++;
                session.setAttribute("score", score);
                request.setAttribute("message", "Bravo, vous avez gagné !");
                request.getRequestDispatcher("jeu.jsp").forward(request, response);
            } else {
                session.setAttribute("score", 0); // Réinitialiser le score
                request.setAttribute("message", "Perdu ! Réessayez.");
                request.getRequestDispatcher("/gameover.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("jeu");
        }
    }


}

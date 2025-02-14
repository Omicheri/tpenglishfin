package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pojos.Question;
import utilities.HibernateUtil;

import java.util.Date;

public class QuestionDao {

    private static final Logger logger = LoggerFactory.getLogger(QuestionDao.class);

    public void createQuestion(int partieId, int verbeId, String reponsePreterit, String reponseParticipePasse, Date dateEnvoi, Date dateReponse) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Question question = new Question(partieId, verbeId, reponsePreterit, reponseParticipePasse, dateEnvoi, dateReponse);
            session.save(question);

            transaction.commit();
            logger.info("Question créée avec succès pour la partie ID: {}", partieId);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Erreur lors de la création de la question", e);
        }
    }
}

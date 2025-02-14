package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Game;
import utilities.HibernateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GameDao {

    private static final Logger logger = LoggerFactory.getLogger(GameDao.class);

    public void saveGame(Game game) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(game);  // Utilisation de persist() à la place de save()
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Erreur lors de la sauvegarde du jeu", e);  // Logging au lieu de printStackTrace()
        }
    }
}

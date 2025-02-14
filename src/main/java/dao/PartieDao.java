package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pojos.Partie;
import utilities.HibernateUtil;

public class PartieDao {

    private static final Logger logger = LoggerFactory.getLogger(PartieDao.class);

    public int createPartie(int playerId) {
        Transaction transaction = null;
        int partieId = 0;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Partie partie = new Partie(playerId);
            partieId = (int) session.save(partie);

            transaction.commit();
            logger.info("Partie créée avec succès, ID: {}", partieId);
        } catch (Exception e) {
            if (transaction != null && transaction.getStatus().canRollback()) {
                try {
                    transaction.rollback();
                } catch (RuntimeException rollbackException) {
                    logger.error("Erreur lors du rollback de la transaction", rollbackException);
                }
            }
            logger.error("Erreur lors de la création de la partie", e);
        }

        return partieId;
    }
}
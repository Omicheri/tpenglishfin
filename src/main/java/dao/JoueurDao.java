package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Joueur;
import utilities.HibernateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JoueurDao {

    private static final Logger logger = LoggerFactory.getLogger(JoueurDao.class);

    public void save(Joueur joueur) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(joueur);  // Utilisation de persist() au lieu de save()
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Erreur lors de la sauvegarde du joueur", e);  // Utilisation de SLF4J
        }
    }

    public Joueur findByEmailAndPassword(String email, String password) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            logger.info("Recherche du joueur avec l'email : {}", email);
            return session.createQuery("FROM Joueur WHERE email = :email AND motDePasse = :password", Joueur.class)
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .uniqueResult();
        } catch (Exception e) {
            logger.error("Erreur lors de la recherche du joueur", e);
            return null;
        }
    }


}

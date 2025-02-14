package dao;

import org.hibernate.Session;
import pojos.Verb;
import utilities.HibernateUtil;

import java.util.Collections;
import java.util.List;

public class VerbDao {

    public List<Verb> getAllVerbs() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Verb> verbs = session.createQuery("FROM Verb", Verb.class).list();
            System.out.println("Nombre de verbes récupérés : " + verbs.size());
            for (Verb verb : verbs) {
                System.out.println("Verbe récupéré : " + verb.getBaseVerbale());
            }
            return verbs;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erreur lors de la récupération des verbes : " + e.getMessage());
            return Collections.emptyList();
        }

    }



}

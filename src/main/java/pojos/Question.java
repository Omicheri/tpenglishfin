package pojos;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "idPartie", nullable = false)
    private int idPartie;

    @Column(name = "idVerbe", nullable = false)
    private int idVerbe;

    @Column(name = "reponsePreterit", nullable = false)
    private String reponsePreterit;

    @Column(name = "reponseParticipePasse", nullable = false)
    private String reponseParticipePasse;

    @Column(name = "dateEnvoi", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEnvoi;

    @Column(name = "dateReponse", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateReponse;

    // Constructeurs
    public Question() {
    }

    public Question(int idPartie, int idVerbe, String reponsePreterit, String reponseParticipePasse, Date dateEnvoi, Date dateReponse) {
        this.idPartie = idPartie;
        this.idVerbe = idVerbe;
        this.reponsePreterit = reponsePreterit;
        this.reponseParticipePasse = reponseParticipePasse;
        this.dateEnvoi = dateEnvoi;
        this.dateReponse = dateReponse;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {

    }
}
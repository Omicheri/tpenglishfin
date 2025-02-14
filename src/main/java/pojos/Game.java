package pojos;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Joueur joueur;

    private int score;

    public Game() {

    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", joueur=" + joueur +
                ", score=" + score +
                ", startTime=" + startTime +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;


// Getters and Setters
}

package pojos;

import jakarta.persistence.*;

@Entity
@Table(name = "partie")
public class Partie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "idJoueur", nullable = false)
    private int idJoueur;

    // Constructeurs
    public Partie() {
    }

    public Partie(int idJoueur) {
        this.idJoueur = idJoueur;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdJoueur() {
        return idJoueur;
    }

    public void setIdJoueur(int idJoueur) {
        this.idJoueur = idJoueur;
    }

    @Override
    public String toString() {
        return "Partie{" +
                "id=" + id +
                ", idJoueur=" + idJoueur +
                '}';
    }
}

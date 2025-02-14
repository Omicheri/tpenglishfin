package pojos;

import jakarta.persistence.*;

@Entity
@Table(name = "verb")
public class Verb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "baseVerbale")
    private String baseVerbale;

    @Column(name = "preterit")
    private String preterit;

    @Column(name = "participePasse")
    private String participePasse;

    @Column(name = "traduction")
    private String traduction;

    public Verb(int id, String baseVerbale, String preterit, String participePasse, String traduction) {
        this.id = id;
        this.baseVerbale = baseVerbale;
        this.preterit = preterit;
        this.participePasse = participePasse;
        this.traduction = traduction;
    }

    public Verb() {
    }

    @Override
    public String toString() {
        return "Verb{" +
                "id=" + id +
                ", baseVerbale='" + baseVerbale + '\'' +
                ", preterit='" + preterit + '\'' +
                ", participePasse='" + participePasse + '\'' +
                ", traduction='" + traduction + '\'' +
                '}';
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBaseVerbale() {
        return baseVerbale;
    }

    public void setBaseVerbale(String baseVerbale) {
        this.baseVerbale = baseVerbale;
    }

    public String getPreterit() {
        return preterit;
    }

    public void setPreterit(String preterit) {
        this.preterit = preterit;
    }

    public String getParticipePasse() {
        return participePasse;
    }

    public void setParticipePasse(String participePasse) {
        this.participePasse = participePasse;
    }

    public String getTraduction() {
        return traduction;
    }

    public void setTraduction(String traduction) {
        this.traduction = traduction;
    }
}

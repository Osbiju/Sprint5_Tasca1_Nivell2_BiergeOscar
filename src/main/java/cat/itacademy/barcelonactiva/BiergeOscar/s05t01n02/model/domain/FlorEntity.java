package cat.itacademy.barcelonactiva.BiergeOscar.s05t01n02.model.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "flors")
public class FlorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pk_FlorID;
    @Column(name = "nom")
    private String nom;
    @Column(name = "pais")
    private String paisFlor;

    public FlorEntity() {
    }

    public FlorEntity(String nom, String paisFlor) {
        this.nom = nom;
        this.paisFlor = paisFlor;

    }

    public int getPk_FlorID() {
        return pk_FlorID;
    }

    public void setPk_FlorID(int pk_FlorID) {
        this.pk_FlorID = pk_FlorID;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPaisFlor() {
        return paisFlor;
    }

    public void setPaisFlor(String paisFlor) {
        this.paisFlor = paisFlor;
    }

    @Override
    public String toString() {
        return "FlorEntity{" +
                "pk_FlorID=" + pk_FlorID +
                ", nom='" + nom + '\'' +
                ", paisFlor='" + paisFlor + '\'' +
                '}';
    }
}

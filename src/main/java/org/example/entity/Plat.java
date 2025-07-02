package org.example.entity;

import javax.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "plat")
public class Plat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String intitule;

    private int prix;

    @Column(name = "date_creation")
    private LocalDate dateCreation;

    // Constructeurs
    public Plat() {
    }

    public Plat(String intitule, int prix, LocalDate dateCreation) {
        this.intitule = intitule;
        this.prix = prix;
        this.dateCreation = dateCreation;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Override
    public String toString() {
        return "Plat{" +
                "id=" + id +
                ", intitule='" + intitule + '\'' +
                ", prix=" + prix +
                ", dateCreation=" + dateCreation +
                '}';
    }
}

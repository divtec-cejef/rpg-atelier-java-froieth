package Objet;

import Personnages.Hero;

public abstract class Objet {

    private String nom;
    private final String effet;

    public Objet(String effet, String nom) { this.effet = effet; this.nom = nom; }

    public String getEffet() { return effet; }


    public abstract void utiliser(Hero cible);

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() { return nom +"("+ effet +")"; }
}


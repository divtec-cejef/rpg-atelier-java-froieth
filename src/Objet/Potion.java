package Objet;

import Personnages.Hero;


public class Potion extends Objet {
    private taillePotion taille = taillePotion.PETITE;
    private String nom;

    public Potion() {
        super("+" + taillePotion.PETITE.getPVrestaurer() + "PV", taillePotion.PETITE.getNom());
        this.nom = taille.getNom();
    }

    public Potion(taillePotion taille) {
        super("+" + taille.getPVrestaurer() + "PV", taille.getNom());
        this.taille = taille;
        this.nom = taille.getNom();
    }

    public taillePotion getTaille() {
        return taille;
    }

    @Override
    public void utiliser(Hero cible) {
        cible.soigner(taille.getPVrestaurer());
    }
}

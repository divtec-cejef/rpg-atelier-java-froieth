package Objet;

import Personnages.Hero;


public class Potion extends Objet {
    taillePotion taille;

    public Potion() {
        super("+" +taillePotion.PETITE.getPVrestaurer() + "PV");
    }

    public Potion(taillePotion taille) {
        super("+" + taille.getPVrestaurer() + "PV");
    }

    @Override
    public void utiliser(Hero cible) {
        cible.soigner(taille.getPVrestaurer());
    }
}

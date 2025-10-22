package Objet;

import Personnages.Hero;


public class Potion extends Objet {
    private final int PV_A_RESTAURER = 20;


    // TODO : trouver un moyen de remplacer le 20 par la constante
    public Potion() {
        super("+" + "20" + "PV");
    }

    @Override
    public void utiliser(Hero cible) {
        cible.soigner(PV_A_RESTAURER);
    }
}

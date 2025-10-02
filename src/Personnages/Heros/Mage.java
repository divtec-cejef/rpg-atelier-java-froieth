package Personnages.Heros;

import Personnages.Hero;
import Personnages.Personnage;

public class Mage extends Hero {

    private int manaMax = 50;
    private int mana = manaMax;
    private final int coutCompétence = 15;

    public Mage(String nom) {
        super(nom, 70, 12, 5);
    }

    @Override
    public String competenceSpecialeNom() {
        return "Boule de Feu";
    }
    @Override
    public int competenceSpeciale(Personnage cible) {
        int dégats = 0;
        if (mana > coutCompétence) {
            dégats = 20 + (int)(Math.round(getATK()*0.8));
        }
        return dégats;
    }

}

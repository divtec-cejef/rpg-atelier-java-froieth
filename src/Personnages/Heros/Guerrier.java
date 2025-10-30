package Personnages.Heros;

import Personnages.Hero;
import Personnages.Personnage;

public class Guerrier extends Hero {

    public Guerrier(String nom) {
        super(nom,95, 14,8);
    }

    @Override
    public String competenceSpecialeNom() {
        return "Coup Puissant";
    }

    @Override
    public int competenceSpeciale(Personnage cible) {
        int dégats;
        int chance = ((int)(Math.random() * 3) + 1);
        if (chance <= 2) {
            dégats = Math.round(getATK() * 1.5) - (cible.getDEF()/2) > 1 ? (int)(Math.round(getATK() * 1.5) - (cible.getDEF()/2)) : 1;
        } else {
            dégats = 1;
        }
        return dégats;
    }

}

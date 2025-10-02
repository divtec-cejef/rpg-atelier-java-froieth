package Personnages.Heros;

import Personnages.Hero;
import Personnages.Personnage;

public class Archer extends Hero {

    public Archer(String nom) {
        super(nom, 80, 13, 6);
    }

    @Override
    public String competenceSpecialeNom() {
        return "Tire Précis";
    }

    @Override
    public int  competenceSpeciale(Personnage cible) {
        int dégats = 1;
        int chance = (int) (Math.random() * 2);
        if (chance == 0) {
            dégats *= 2;
        } else {
            dégats *= 1.25 * (getATK() * cible.getDEF());
        }
        return dégats;
    }

}

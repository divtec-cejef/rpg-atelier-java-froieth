package Personnages.Heros;

import Personnages.Hero;

public class Archer extends Hero {

    public Archer(int PV, float ATK, int DEF) {
        int chance = (int) (Math.random() * 2);
        if (chance == 0) {
            ATK *= 2;
        } else {
            ATK *= 1.25;
        }

        super(PV, ATK, DEF);
    }
}

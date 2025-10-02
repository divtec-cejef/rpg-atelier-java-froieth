package Personnages.Heros;

import Personnages.Hero;

public class Guerrier extends Hero {

    public Guerrier(int PV, float ATK, int DEF) {
        super(PV, (float) (ATK*1.5), DEF);
    }



}

package Personnages;

public abstract class Personnage {
    int PV;
    float ATK;
    int DEF;
    // TODO : refaire l'attaque de base
    //float attaqueDeBase = (float) (ATK * 1.20);

    public Personnage(int PV, float ATK, int DEF) {
        this.PV = PV;
        this.ATK = ATK;
        this.DEF = DEF;
    }

}

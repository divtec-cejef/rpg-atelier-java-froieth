package Personnages;

public abstract class Monstre extends Personnage {
    int butinXP;
    int butinOr;

    public Monstre(String nom, int PV, float ATK, int DEF, int butinXP, int butinOr) {
        super(nom, PV, ATK, DEF);
        this.butinXP = butinXP;
        this.butinOr = butinOr;
    }


    public int getButinXP() {
        return butinXP;
    }

    public int getButinOr() {
        return butinOr;
    }
}

package Personnages;

public abstract class Monstre extends Personnage {
    int butinXP;
    int or;

    public Monstre(int PV, float ATK, int DEF, int butinXP, int or) {
        super(PV, ATK, DEF);
        this.butinXP = butinXP;
        this.or = or;
    }

}

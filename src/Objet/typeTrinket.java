package Objet;

import Personnages.Hero;

public enum typeTrinket {
    ATK(5,"ATK") {
        public void utiliser(Hero cible) {
            cible.setATK(cible.getATK() + augmenteStat);
        }
    },
    DEF(3,"DEF"){
        public void utiliser(Hero cible) {
            cible.setDEF(cible.getDEF() + 3);
        }
    },
    PVMAX(20,"PVMax"){
        public void utiliser(Hero cible) {
            cible.setPVMax(cible.getPVMax() + 20);
        }
    };

    protected int augmenteStat;
    protected String effet = "+";
    protected String nom;

    typeTrinket(int augmenteStat, String nom) {
        this.augmenteStat = augmenteStat;
        this.effet += this.augmenteStat + nom;
        this.nom = "Trinket " + nom;
    }

    protected void setEffet(String effet) {
        this.effet = effet;
    }

    public String getNom() {
        return nom;
    }

    public abstract void utiliser(Hero cible);
}

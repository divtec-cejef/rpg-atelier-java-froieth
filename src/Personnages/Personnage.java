package Personnages;

import Base.ConsoleIO;
import Personnages.Heros.Mage;

import static Objet.typeTrinket.PVMAX;

public abstract class Personnage {
    private ConsoleIO console = new ConsoleIO();
    private String nom;
    private int level = 1;
    private int PVMax;
    private int PV;
    private float ATK;
    private int DEF;


    public Personnage(String nom ,int PVMax, float ATK, int DEF) {
        this.nom = nom;
        this.PVMax = PVMax >= 1 ?  PVMax : 1;
        this.PV = PVMax;
        this.ATK = ATK >= 0 ?  ATK : 0;
        this.DEF = DEF >= 0 ?  DEF : 0;
    }

    /****************** getteur ******************/
    public String getNom() {return nom;}
    public int getPVMax() {return PVMax;}
    public int getLevel() {return level;}
    public int getPV() {return PV;}
    public float getATK() {return ATK;}
    public int getDEF() {return DEF;}


    /****************** setteur ******************/
    protected void setLevel(int level) {
        this.level = level;
    }

    public void setPVMax(int PVMax) {
        if(this.PV == this.PVMax) {
            this.PV = PVMax;
        }
        this.PVMax = PVMax;
    }

    public void setATK(float ATK) {
        this.ATK = ATK;
    }

    public void setDEF(int DEF) {
        this.DEF = DEF;
    }

    public void soigner(int pv){
        if(this.PV + pv >= this.PVMax){
            this.PV =  this.PVMax;
        } else {
            this.PV += pv;
        }
    }

    public void subirDegats(int dégat, Personnage cible, boolean attaqueSpé) {

        boolean estHero = false;
        console.afficher("\n");
        if(this instanceof Monstre) {
            if(attaqueSpé) {
                if(cible instanceof Mage && dégat == 0) {
                    console.afficherSansRetourLigne("Vous tentez d'utilisez " + cible.competenceSpecialeNom() + ",\n  mais vous n'avez pas assez de mana." +
                            "\n    Vous infligez donc ");
                } else {
                    console.afficherSansRetourLigne("Vous utilisez " + cible.competenceSpecialeNom() + "\n  et infligez ");
                }
            } else {console.afficherSansRetourLigne("Vous infligez ");}

            estHero = true;
        } else {
            if(attaqueSpé) {
                console.afficherSansRetourLigne("\t\t\t\t\tLe " + cible.getNom() + " utilise " + cible.competenceSpecialeNom() + "\n\t\t\t\t\t  et vous inflige ");
            } else {console.afficherSansRetourLigne("\t\t\t\t\t\tLe " + cible.getNom() + " vous inflige ");}
        }
        console.afficherSansRetourLigne(dégat + " dégats");
        if(estHero) {
            console.afficherSansRetourLigne(" au " + this.getNom());
        }

        this.PV -= dégat;
    }


    /****************** autre méthode ******************/
    public boolean estVivant() {
        return PV > 0 ? true : false;
    }

    public int attaquer(Personnage cible) {

        float min = 0.8f;
        float max = 1.2f;
        float multiplicationDégat = (float) (min + Math.random() * (max - min));

        int dégat = this.ATK * multiplicationDégat - cible.getDEF() > 1 ? (int)(this.ATK * multiplicationDégat - cible.getDEF()) : 1;

        return dégat;
    }

    public abstract String competenceSpecialeNom();

    public abstract int competenceSpeciale(Personnage cible);


}

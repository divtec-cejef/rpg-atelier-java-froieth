package Personnages;

public abstract class Personnage {
    private String nom;
    private int level = 1;
    private int PVMax;
    private int PV = PVMax;
    private float ATK;
    private int DEF;


    public Personnage(String nom ,int PVMax, float ATK, int DEF) {
        this.nom = nom;
        this.PVMax = PVMax >= 1 ?  PVMax : 1;
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

    protected void setPVMax(int PVMax) {
        this.PVMax = PVMax;
    }

    protected void setATK(float ATK) {
        this.ATK = ATK;
    }

    protected void setDEF(int DEF) {
        this.DEF = DEF;
    }

    public void soigner(int pv){
        if(this.PV + pv >= this.PVMax){
            this.PV =  this.PVMax;
        } else {
            this.PV += pv;
        }
    }

    protected void subirDegats(int dégat) {
        this.PV -= dégat;
    }


    /****************** autre méthode ******************/
    public boolean estVivant() {
        return PV > 0 ? true : false;
    }

    public int attaquer(Monstre cible) {
        float min = 0.8f;
        float max = 1.2f;
        float multiplicationDégat = (float) (min + Math.random() * (max - min));

        int dégat = this.ATK * multiplicationDégat - cible.getDEF() > 1 ? (int)(this.ATK * multiplicationDégat - cible.getDEF()) : 1;
        return dégat;
    }

    public abstract String competenceSpecialeNom();

    public abstract int competenceSpeciale(Personnage cible);


}

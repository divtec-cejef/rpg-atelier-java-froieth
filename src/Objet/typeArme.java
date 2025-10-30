package Objet;

public enum typeArme {
    EPEE("Épée", 3, "f"),
    ARC("Arc", 4, 2, "m"),
    SNIPER("Sniper", 10, 10, "m");

    protected String nom;
    protected int bonusATK;
    protected int malusDEF = 0;
    private String effet;
    private String genre;

    typeArme(String nom, int bonusATK,int malusDEF, String genre) {
        this(nom, bonusATK, genre);
        this.malusDEF = malusDEF;
        this.effet += " -" + this.malusDEF + "DEF";
    }

    typeArme(String nom, int bonusATK, String genre) {
        this.nom = nom;
        this.bonusATK = bonusATK;
        this.genre = genre;
        this.effet = "+" + this.bonusATK + "ATK";
    }

    public String getEffet() {
        return effet;
    }

    public String getGenre() {
        return genre;
    }

    public String getNom() {
        return nom;
    }

}

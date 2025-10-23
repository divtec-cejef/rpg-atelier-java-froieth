package Objet;

public enum taillePotion {
    PETITE(20, "mineure"),
    MOYENNE(50, "standard"),
    GRANDE(120, "puissante"),
    IMMENSE(1000, "ultime"),;


    private int PVrestaurer;
    private String nom;

    taillePotion(int pvrestaurer, String nom) {
        this.PVrestaurer = pvrestaurer;
        this.nom = "Potion " + nom;
    }

    public int getPVrestaurer() {
        return PVrestaurer;
    }

    public String getNom() {
        return nom;
    }
}

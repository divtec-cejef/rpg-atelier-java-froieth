package Objet;

public enum taillePotion {
    PETITE(20),
    MOYENNE(50),
    GRANDE(100),
    IMMENSE(1000);


    private int PVrestaurer;

    taillePotion(int pvrestaurer) {
        this.PVrestaurer = pvrestaurer;
    }

    public int getPVrestaurer() {
        return PVrestaurer;
    }
}

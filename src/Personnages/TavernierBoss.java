package Personnages;

public class TavernierBoss extends Monstre {

    public TavernierBoss() {
        super("Tavernier", 500, 100, 30, 0, 0);
    }

    @Override
    public String competenceSpecialeNom() {
        return "Claque du seigneur";
    }

    @Override
    public int competenceSpeciale(Personnage cible) {
        return 100;
    }
}

package Personnages;

public class Tavernier extends Monstre {

    public Tavernier() {
        super("Tavernier", 120, 20, 10, 0, 0);
    }

    @Override
    public String competenceSpecialeNom() {
        return "Claque du seigneur";
    }

    @Override
    public int competenceSpeciale(Personnage cible) {
        return 50;
    }
}

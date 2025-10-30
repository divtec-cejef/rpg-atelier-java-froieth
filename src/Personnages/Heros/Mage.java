package Personnages.Heros;

import Base.ConsoleIO;
import Personnages.Hero;
import Personnages.Monstre;
import Personnages.Personnage;

public class Mage extends Hero {

    private ConsoleIO console = new ConsoleIO();
    private int manaMax = 50;
    private int mana = manaMax;
    private final int coutCompétence = 20;

    public Mage(String nom) {
        super(nom, 70, 12, 5);
    }

    @Override
    public String toString() {
        return super.toString() + "\n\tMana : " + getManaRestant();
    }

    @Override
    public String competenceSpecialeNom() {
        return "Boule de Feu";
    }
    @Override
    public int competenceSpeciale(Personnage cible) {
        int dégats = 0;
        if (mana > coutCompétence) {
            dégats = 20 + (int)(Math.round(getATK()*0.8));
            setMana(getMana() - coutCompétence);
        } else {
            console.afficherSansRetourLigne(" mais vous n'avez pas assez de mana");
        }
        return dégats;
    }

    public String getManaRestant() {
        return mana + "/" + manaMax;
    }

    public int getMana() {
        return mana;
    }

    public int getManaMax() {
        return manaMax;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setManaMax(int manaMax) {
        this.manaMax = manaMax;
    }

    public int getCoutCompétence() {
        return coutCompétence;
    }
}

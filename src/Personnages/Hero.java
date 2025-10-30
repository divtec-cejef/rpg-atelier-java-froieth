package Personnages;

import Base.ConsoleIO;
import Objet.Arme;
import Objet.Objet;
import Personnages.Heros.Mage;

import java.util.ArrayList;

public abstract class Hero extends Personnage {
    private ConsoleIO console = new ConsoleIO();
    private int XP = 0;
    private int or = 0;
    private ArrayList<Objet> inventaire = new ArrayList<>();
    private Arme armeEquipe = null;

    public Hero(String nom ,int PVMax, float ATK, int DEF) {
        super(nom,PVMax,ATK,DEF);
    }

    @Override
    public String toString() {
        return "\n=========================== Héro ===========================\n" +
                String.format("%-35s %s\n", "\tOr possédé : " + or + " Or", "PV : " + getPV() + "/" + getPVMax()) +
                String.format("%-35s %s\n", "\tNiveau " + getLevel() + " -> " + XP + "/100XP", "ATK : " + getATK()) +
                String.format("%-35s %s", "\tArme équipée : " + getArmeEquipee(), "DEF : " + getDEF());
    }

    /****************** Inventaire ******************/
    public void ajouterObjet(Objet o) {
        inventaire.add(o);
    }

    public void utiliserObjetIndex(int index) {
        inventaire.get(index).utiliser(this);
        console.afficher("Vous avez utilisé l'objet" + inventaire.get(index).getNom() + "-> " + inventaire.get(index).getEffet());
        inventaire.remove(index);
    }

    public void equiperArme(int index) {
        if (armeEquipe != null) {
            inventaire.add(armeEquipe);
            console.afficherSansRetourLigne("\nVous avez déséquipé l'arme " + armeEquipe.getNom() + " -> suppression des bonus \"" + armeEquipe.getEffet() + "\"");
        }
        armeEquipe = (Arme) inventaire.get(index);
        inventaire.get(index).utiliser(this);
        console.afficher("Vous avez équipé l'arme " + inventaire.get(index).getNom() + " -> " + inventaire.get(index).getEffet());
        inventaire.remove(index);
    }

    public ArrayList<Objet> getInventaire() {
        return inventaire;
    }


    /****************** XP ******************/
    public void gagnerXP(int xp) {
        XP += xp;

        console.consomerRetourLigne();
        int levelAvant = getLevel();
        int PVMaxAvant = getPVMax();
        int ATKAvant = (int) getATK();
        int DEFAvant = getDEF();
        int ManaMaxAvant = 0;
        if(this instanceof Mage) {
            ManaMaxAvant = ((Mage)this).getManaMax();
        }

        while (XP >= 100) {
            setLevel(getLevel() + 1);
            setPVMax(getPVMax() + 10);
            soigner(getPVMax());;
            setATK(getATK() + 2);
            setDEF(getDEF() + 1);
            XP -= 100;
            if(this instanceof Mage) {
                ((Mage)this).setManaMax(((Mage)this).getManaMax() + 5);
                ((Mage)this).setMana(((Mage)this).getManaMax());
            }
        }
        if(levelAvant != getLevel()) {
            console.afficherSansRetourLigne("Niveau " + levelAvant + " -> " + getLevel() + "\n\tPV Max : " + PVMaxAvant + " -> " + getPVMax() +
                    "\n\tATK : " + ATKAvant + " -> " + (int)getATK() + "\n\tDEF : " + DEFAvant + " -> " + getDEF() + "\n");

            if(this instanceof Mage) {
                console.afficherSansRetourLigne( "\tMana Max : " + ManaMaxAvant + " -> " + ((Mage)this).getManaMax() + "\n");
            }
        }
    }

    /****************** Or ******************/
    public int getOr() {
        return or;
    }

    public void gagnerOr(int montant) {
        or += montant;
    }

    public boolean depenserOr(int montant) {
        if (or > montant) {
            or -= montant;
            return true;
        } else {
            return false;
        }
    }


    /****************** Boosts permanents ******************/
    public void boosterPvMax(int bonus) {
        setPVMax(getPVMax() + bonus);
    }

    public void boosterAttaque(int bonus) {
        setATK(getATK() + bonus);
    }

    public void boosterDefense(int bonus) {
        setDEF(getDEF() + bonus);
    }


    /****************** Arme ******************/
    public String getArmeEquipee() {
        String message;
        if(armeEquipe == null) {
            message = "Aucune";
        } else {
            message = armeEquipe.toString();
        }

        return message;
    }

}

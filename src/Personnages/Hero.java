package Personnages;

import Base.ConsoleIO;
import Objet.Arme;
import Objet.Objet;

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



    /****************** Inventaire ******************/
    public void ajouterObjet(Objet o) {
        inventaire.add(o);
    }

    public void utiliserObjetIndex(int index) {
        inventaire.get(index).utiliser(this);
        console.afficher("Vous avez utilisé l'objet" + inventaire.get(index) + "-> " + inventaire.get(index).getEffet());
        inventaire.remove(index);
    }

    public void equiperArme(int index) {
        if (armeEquipe != null) {
            inventaire.add(armeEquipe);
            console.afficher("Vous avez déséquipé l'arme " + armeEquipe + " -> suppression des bonus " + armeEquipe.getEffet());
        }
        armeEquipe = (Arme) inventaire.get(index);
        inventaire.get(index).utiliser(this);
        inventaire.remove(index);
    }

    public ArrayList<Objet> getInventaire() {
        return inventaire;
    }


    /****************** XP ******************/
    public void gagnerXP(int xp) {
        XP += xp;

        console.consomerRetourLigne();
        console.afficherSansRetourLigne("Niveau " + getLevel() + " -> ");
        while (XP >= 100) {
            setLevel(getLevel() + 1);
            setPVMax(getPVMax() + 10);
            setATK(getATK() + 2);
            setDEF(getDEF() + 1);
            XP -= 100;
        }
        console.afficher(getLevel() + "\nPVMax = " + getPVMax() + ", ATK = " + getATK() + ", DEF = " + getDEF() + ")");
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
    public Arme getArmeEquipee() {
        return armeEquipe;
    }

    public void equiperArme(Arme nouvelle) {
        inventaire.add(armeEquipe);
        armeEquipe = nouvelle;
        inventaire.remove(nouvelle);
    }

}

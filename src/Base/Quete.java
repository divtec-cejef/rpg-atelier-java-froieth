package Base;

import Objet.Objet;
import Objet.Trinket;
import Objet.typeTrinket;
import Objet.Arme;
import Objet.typeArme;
import Objet.Potion;
import Objet.taillePotion;

import java.util.ArrayList;

public class Quete {
    private ArrayList<String> quetes = new ArrayList<>();
    private ArrayList<Integer> nbreAVaincre = new ArrayList<>();
    private ArrayList<Objet> récompense = new ArrayList<>();
    private ArrayList<Boolean> terminer = new ArrayList<>();


    public Quete() {
        // Quête gobelin
        nbreAVaincre.add(10);
        quetes.add("Vaicre " + nbreAVaincre.get(0) + " Gobelins");
        récompense.add(new Trinket(typeTrinket.PVMAX));
        terminer.add(false);

        // Quête troll
        nbreAVaincre.add(10);
        quetes.add("Vaicre " + nbreAVaincre.get(1) + " Trolls");
        récompense.add(new Arme(typeArme.SNIPER));
        terminer.add(false);

        // Quête dragon
        nbreAVaincre.add(5);
        quetes.add("Vaicre " + nbreAVaincre.get(2) + " Dragons");
        récompense.add(new Potion(taillePotion.IMMENSE));
        terminer.add(false);
    }

    public ArrayList<String> getQuetes() {
        return quetes;
    }

    public ArrayList<Objet> getRécompense() {
        return récompense;
    }

    public ArrayList<Boolean> getQueteTerminer() {
        return terminer;
    }

    public void terminerQuetes(int index) {
        terminer.set(index, true);
    }

    public void setNbreAVaincre(int index) {
        int valeur = this.nbreAVaincre.get(index);
        this.nbreAVaincre.set(index, valeur - 1);
    }
}

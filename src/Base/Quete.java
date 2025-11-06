package Base;

import Objet.Objet;
import Objet.Trinket;
import Objet.typeTrinket;
import Objet.Arme;
import Objet.typeArme;
import Objet.Potion;
import Objet.taillePotion;
import Personnages.Hero;

import java.util.ArrayList;

public class Quete {
    private ConsoleIO console = new ConsoleIO();
    private Hero hero;
    private ArrayList<String> quetes = new ArrayList<>();
    private ArrayList<Integer> nbreAVaincre = new ArrayList<>();
    private ArrayList<Objet> récompense = new ArrayList<>();
    private ArrayList<Boolean> terminer = new ArrayList<>();


    public Quete(Hero hero) {
        this.hero = hero;

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
        console.afficherSansRetourLigne("Bravo, vous avez terminé la quêtes ");
        switch(index) {
            case 0: console.afficherSansRetourLigne("\"Vaincre les Gobelins\" !\nVous remportez donc un ");break;
            case 1: console.afficherSansRetourLigne("\"Vaincre les Trolls\" !\nVous remportez donc une ");break;
            case 2: console.afficherSansRetourLigne("\"Vaincre les Gobelins\" !\nVous remportez donc un ");break;
        }
        console.afficher(getRécompense().get(index).getNom());
        hero.ajouterObjet(récompense.get(index));
        console.consomerRetourLigne();

        boolean activerQueteTaverne = true;
        for (int i = 0; i < quetes.size(); i++) {
            if(!terminer.get(i)) {
                activerQueteTaverne = false;
            }
        }
        if(activerQueteTaverne) {
            nbreAVaincre.add(0);
            quetes.add("Retourner à la taverne");
            récompense.add(null);
            terminer.add(false);
        }
    }

    public void setNbreAVaincre(int index) {
        int valeur = this.nbreAVaincre.get(index);
        this.nbreAVaincre.set(index, valeur - 1);
        switch(index) {
            case 0: quetes.set(index, "Vaincre " + nbreAVaincre.get(index) + " Gobelins");break;
            case 1: quetes.set(index, "Vaincre " + nbreAVaincre.get(index) + " Troll");break;
            case 2: quetes.set(index, "Vaincre " + nbreAVaincre.get(index) + " Dragon");break;
        }
        if(nbreAVaincre.get(index) == 0) {
           terminerQuetes(index);
        }
    }

    public int getNbreAVaincre(int index) {
        return nbreAVaincre.get(index);
    }
}

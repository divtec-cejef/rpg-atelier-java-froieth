package Base;

import Objet.Potion;
import Objet.Trinket;
import Objet.taillePotion;
import Personnages.Hero;
import Personnages.Heros.Guerrier;
import Personnages.Monstre;
import Personnages.monstres.Dragon;
import Personnages.monstres.Gobelin;

import java.util.ArrayList;


public class Main {

    public static boolean calculerPourcentage(int pourcentage) {
        return (int) (Math.random() * 100 + 1) <= pourcentage;
    }

    public static Monstre monstreAleatoire() {
        return new Gobelin();
    }

    public static void gererInventaire(Hero hero) {
        ConsoleIO console =  new ConsoleIO();
        console.afficherMenuInventaire(hero);
    }

    public static void combat(Hero hero) {

        // TODO : supprimer ces lignes après les tests
        hero.ajouterObjet(new Potion(taillePotion.GRANDE));
        hero.ajouterObjet(new Trinket());
        hero.ajouterObjet(new Potion());


        ConsoleIO console =  new ConsoleIO();
        Monstre monstre = monstreAleatoire();

        boolean continuerCombat = true;
        do {
            boolean repeterSaisi = false;
            do {
                repeterSaisi = false;
                console.afficherPersonnageCombat(hero, monstre);
                console.afficherMenuCombat(hero);
                switch (console.readNextInt("Actoin à réaliser : ", 1, 4)) {
                    case 1: monstre.subirDegats(hero.attaquer(monstre), hero);break;
                    case 2: monstre.subirDegats(hero.competenceSpeciale(monstre), hero);break;
                    case 3: gererInventaire(hero);repeterSaisi = true;break;
                    case 4: continuerCombat = calculerPourcentage(40);
                        if(continuerCombat){console.afficher("\nVous n'avez pas réussi à vous enfuire");
                        } else {console.afficher("\nVous vous êtes enfui...");}
                    break;
                }
            }while (repeterSaisi);

            if(continuerCombat) {
                console.readNextLine();
                if (!monstre.estVivant()) {
                    continuerCombat = false;
                    console.afficher("\nBravo, vous avez vaicu le " + monstre.getNom());
                    console.afficher("+" + monstre.getButinXP() + "XP\t+" + monstre.getButinOr() + " Or");
                    hero.gagnerXP(monstre.getButinXP());
                    hero.gagnerOr(monstre.getButinOr());
                } else {
                    hero.subirDegats(monstre.attaquer(hero), monstre);
                    console.consomerRetourLigne();
                    if (!hero.estVivant()) {
                        continuerCombat = false;
                        console.afficher("\nVous avez été vaincu...");
                    }
                }
            }
        } while (continuerCombat);
    }


    static void main(String[] args) {
        ConsoleIO console = new ConsoleIO();

        console.afficherMenuPricipale();
        Hero hero = new Guerrier("test");



        switch(console.readNextInt("\nAction à réaliser : ", 0, 5)) {
            case 0: break;
            case 1: break;
            case 2: combat(hero); break;
            case 3: break;
            case 4: break;
            case 5: break;
        }
    }
}

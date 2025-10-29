package Base;

import Personnages.Hero;
import Personnages.Monstre;

public class Combat {

    public static boolean calculerPourcentage(int pourcentage) {
        return (int) (Math.random() * 100 + 1) <= pourcentage;
    }

    public void gererInventaire(Hero hero) {
        ConsoleIO console =  new ConsoleIO();
        console.afficherMenuInventaire(hero);
    }

    public void combattre(Hero hero, Monstre monstre, boolean récompense) {

        ConsoleIO console =  new ConsoleIO();


        boolean continuerCombat = true;
        do {
            boolean repeterSaisi = false;
            do {
                repeterSaisi = false;
                console.afficherMenuCombat(hero, monstre);
                switch (console.readNextInt("Actoin à réaliser : ", 0, 3)) {
                    case 1: monstre.subirDegats(hero.attaquer(monstre), hero);break;
                    case 2: monstre.subirDegats(hero.competenceSpeciale(monstre), hero);break;
                    case 3: gererInventaire(hero);repeterSaisi = true;break;
                    case 0: continuerCombat = calculerPourcentage(40);
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
                    if(récompense){
                        console.afficher("+" + monstre.getButinXP() + "XP\t+" + monstre.getButinOr() + " Or");
                        hero.gagnerXP(monstre.getButinXP());
                        hero.gagnerOr(monstre.getButinOr());
                    }
                } else {
                    hero.subirDegats(monstre.attaquer(hero), monstre);
                    console.consomerRetourLigne();
                    if (!hero.estVivant()) {
                        continuerCombat = false;
                        console.afficher("\nVous avez été vaincu...");
                        console.consomerRetourLigne();
                        console.gameOver();
                        System.exit(0);
                    }
                }
            }
        } while (continuerCombat);
    }
}

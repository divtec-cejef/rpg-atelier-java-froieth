package Base;

import Endroit.Boutique;
import Objet.Objet;
import Personnages.Hero;
import Personnages.Monstre;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleIO {


    private Scanner scanner = new Scanner(System.in);

    /**
     * Permet de lire le prochain int
     *
     * @return la valeur du prochain int
     */
    public int readNextInt(String message,  int min, int max) {
        boolean repeterSaisi = true;
        int saisie = 0;

        while (repeterSaisi) {
            afficherSansRetourLigne(message);
            if (scanner.hasNextInt()) {
                saisie = scanner.nextInt();
                if (saisie >= min && saisie <= max) {
                    repeterSaisi = false;
                } else {
                    afficher("\nVeuillez saisir un nombre compris entre " + min + " et " + max + " !");
                }
            } else {
                scanner.next();
                afficherSansRetourLigne("\nVeuillez saisir nombre !");
            }
        }
        return saisie;
    }

    /**
     * Permet de lire la prochaine ligne
     *
     * @return la valeur de la porchaine ligne
     */
    public String readNextLine() {
        consomerRetourLigne(); // Prend le retour à la ligne précédent
        return scanner.nextLine();
    }

    /**
     * Permet de consomer un retour de ligne
     * @return
     */
    public String consomerRetourLigne() {
        return scanner.nextLine();
    }

    /**
     * Affiche l'objet
     *
     * @param obj Objet à afficher
     */
    public void afficher(Object obj) {
        System.out.println(obj);
    }

    /**
     * Affiche l'objet sans faire de retour à la ligne
     *
     * @param obj Objet à afficher
     */
    public void afficherSansRetourLigne(Object obj) {
        System.out.print(obj);
    }

    /**
     * Affiche une description textuelle des personnage en combat aisi que leur PV
     *                          nomHero (40/95PV) / Gobelin (20/50PV)
     * @param hero Personnage joué par l'utilisateur
     * @param monstre Monstre
     */
    public void afficherPersonnageCombat(Hero hero, Monstre monstre) {
        afficher("\n\t\t\t  " + hero.getNom() + "(" + hero.getPV() + "/" + hero.getPVMax() + "PV) / " +
                monstre.getNom() + "(" + monstre.getPV() + "/" + monstre.getPVMax() + "PV)");
    }

    /**
     * Affiche toutes les actions possible à faire
     */
    public void afficherMenuPricipale() {
        afficher("======================== RPG Simplifié ========================\n" +
                     "\t[1] Voir le héros\n" +
                     "\t[2] Préparer un combat (gérer inventaire puis combatre)\n" +
                     "\t[3] Voir l'inventaire / utiliser ou équiper\n" +
                     "\t[4] Boutique (acheter objets)\n" +
                     "\t[5] Taverne (se reposer)\n" +
                     "\t[0] Quitter\n");
    }

    /**
     * Affiche toutes les actions possible à faire durant un combat
     */
    public void afficherMenuCombat(Hero hero) {
        afficher("======================== Combat ========================\n" +
                "\t[1] Attaquer\n" +
                "\t[2] " + hero.competenceSpecialeNom() + "\n" +
                "\t[3] Utiliser objet\n" +
                "\t[4] Fuir\n");
    }

    /**
     * Affiche tous les objets de l'inventaire
     */
    public void afficherMenuInventaire(Hero hero) {
        afficherSansRetourLigne("\n======================== Inventaire ========================\n");

        if (hero.getInventaire().size() == 0) {
            afficher("\tAucun objet");
            consomerRetourLigne();
        } else {
            for (int i = 0; i < hero.getInventaire().size(); i++) {
                afficher("\t[" + (i + 1) + "] " + hero.getInventaire().get(i).toString());
            }
            afficher("\t[0] Annuler");

            int objetAUtiliser = readNextInt("\nObjet à utiliser : ", 0, hero.getInventaire().size());
            if(objetAUtiliser != 0) {
                hero.utiliserObjetIndex(objetAUtiliser-1);
            }
        }
    }

    /**
     * Affiche tous les objets achetables dans la boutique
     */
    public void afficherMenuBoutique(Boutique boutique) {
        afficher("======================== Boutique ========================\n");
        for (int i = 0; i < boutique.getObjetsBoutique().size(); i++) {
            afficher("\t[" + (i + 1) + "] " + boutique.offre(boutique.getObjetsBoutique().get(i), boutique.getPrix().get(i)));
        }
        afficher("\t[0] Annuler\n");
    }


}

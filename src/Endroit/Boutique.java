package Endroit;


import Base.ConsoleIO;
import Objet.*;
import Personnages.Hero;

import java.util.ArrayList;

public class Boutique {
    private ConsoleIO console = new ConsoleIO();
    private ArrayList<Objet> objetsBoutique = new ArrayList();
    private ArrayList<Integer> prix = new ArrayList();

    public Boutique() {
        objetsBoutique.add(new Potion(taillePotion.PETITE));
        prix.add(50);

        objetsBoutique.add(new Potion(taillePotion.MOYENNE));
        prix.add(100);

        objetsBoutique.add(new Potion(taillePotion.GRANDE));
        prix.add(200);

        objetsBoutique.add(new Trinket(typeTrinket.ATK));
        prix.add(100);

        objetsBoutique.add(new Trinket(typeTrinket.DEF));
        prix.add(100);

        objetsBoutique.add(new Trinket(typeTrinket.PVMAX));
        prix.add(200);

        objetsBoutique.add(new Arme(typeArme.EPEE));
        prix.add(100);

        objetsBoutique.add(new Arme(typeArme.ARC));
        prix.add(100);
    }

    public ArrayList<Objet> getObjetsBoutique() {
        return objetsBoutique;
    }

    public ArrayList<Integer> getPrix() {
        return prix;
    }

    public String offre(Objet objet, int prix) {
        return objet + " : " + prix + " Or";
    }


    public void visiter(Hero hero) {
        console.afficherMenuBoutique(this);
        console.afficher("Or posséder : " + hero.getOr());

        int objetChoisi = console.readNextInt("Objet à acheter : ", 0, objetsBoutique.size());
        if(objetChoisi != 0) {
            if(hero.getOr() >= prix.get(objetChoisi - 1)) {
                console.afficherSansRetourLigne("\nVous avez acheter ");
                hero.depenserOr(prix.get(objetChoisi - 1));

                if (objetsBoutique.get(objetChoisi - 1) instanceof Potion) {
                    Potion copie = new Potion(((Potion) objetsBoutique.get(objetChoisi - 1)).getTaille());
                    hero.ajouterObjet(copie);
                    console.afficher("une " + copie.getNom());
                } else if (objetsBoutique.get(objetChoisi - 1) instanceof Trinket) {
                    Trinket copie = new Trinket(((Trinket) objetsBoutique.get(objetChoisi - 1)).getType());
                    hero.ajouterObjet(copie);
                    console.afficher("un " + copie.getNom());
                } else {
                    Arme copie = new Arme(((Arme) objetsBoutique.get(objetChoisi - 1)).getType());
                    hero.ajouterObjet(copie);
                    console.afficherSansRetourLigne("un");
                    if(copie.getType().getGenre() == "f") {console.afficherSansRetourLigne("e");}
                    console.afficher(" " + copie.getNom());
                }

                console.readNextLine();
            } else {
                console.afficher("\nVous n'avez pas assez d'or !");
                console.readNextLine();
                visiter(hero);
            }
        }

    }




}

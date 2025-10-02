package Personnages;

import Objet.Arme;
import Objet.Objet;

import java.util.ArrayList;

public abstract class Hero extends Personnage {
    // TODO : refaire les listes + completer le level par rapport à l'XP
    int level;
    int XP;
    int or;
    ArrayList<Objet> inventaire = new ArrayList<>();
    Arme slotArme;



    public Hero(int PV, float ATK, int DEF) {
        super(PV, ATK, DEF);
    }


}

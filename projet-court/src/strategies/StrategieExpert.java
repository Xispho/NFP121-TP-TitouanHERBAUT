package strategies;

import allumettes.Jeu;
import allumettes.Joueur;

public class StrategieExpert implements Strategie{

    @Override
    public int choisirNombreAllumettes(Jeu jeu, Joueur joueur, int nombreAllumettes) {
        if (nombreAllumettes <= 0) {
            throw new IllegalArgumentException("Le nombre d'allumettes doit être positif.");
        }
        int prise;
        if (nombreAllumettes > 4) {
            int reste = nombreAllumettes % 4;
            prise = (reste == 0) ? 3 : reste - 1;
        } else {
            prise = nombreAllumettes - 1;
        }
        return prise;
    }
}

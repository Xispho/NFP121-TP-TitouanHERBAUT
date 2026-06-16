package strategies;

import allumettes.Jeu;
import allumettes.Joueur;

public class StrategieExpert implements Strategie{

    @Override
    public int choisirNombreAllumettes(Jeu jeu, Joueur joueur, int nombreAllumettes) {
        if (nombreAllumettes <= 0) {
            throw new IllegalArgumentException("Le nombre d'allumettes doit être positif.");
        }
        int result = Jeu.PRISE_MAX;
        if (nombreAllumettes <= Jeu.PRISE_MAX) {
            result = nombreAllumettes - 1;
        }
        System.out.print(joueur.getNom() + " prend " + result + " allumette(s).\n");
        return result;
    }
}

package strategies;

import allumettes.Jeu;
import allumettes.Joueur;

public class StrategieRapide implements Strategie{

    // Retire 3 allumettes si possible, sinon le nombre maximum autorisé
    @Override
    public int choisirNombreAllumettes(Jeu jeu, Joueur joueur, int nombreAllumettes) {
        if (nombreAllumettes <= 0) {
            throw new IllegalArgumentException("Le nombre d'allumettes doit être positif.");
        }
        return Math.min(Jeu.PRISE_MAX, nombreAllumettes);
    }
}

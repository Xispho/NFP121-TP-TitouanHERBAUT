package strategies;

import allumettes.Jeu;

public class StrategieRapide implements Strategie{

    // Retire 3 allumettes si possible, sinon le nombre maximum autorisé
    @Override
    public int choisirNombreAllumettes(int nombreAllumettes) {
        if (nombreAllumettes <= 0) {
            throw new IllegalArgumentException("Le nombre d'allumettes doit être positif.");
        }
        return Math.min(Jeu.PRISE_MAX, nombreAllumettes);
    }
}

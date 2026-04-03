package strategies;

import allumettes.Jeu;

public class StrategieNaif implements Strategie {

    // Retire un nombre d'allumettes aléatoire entre 1 et 3
    @Override
    public int choisirNombreAllumettes(int nombreAllumettes) {
        if (nombreAllumettes <= 0) {
            throw new IllegalArgumentException("Le nombre d'allumettes doit être positif.");
        }
        int maxRetrait = Math.min(Jeu.PRISE_MAX, nombreAllumettes);
        return (int) (Math.random() * maxRetrait) + 1;
    }
}

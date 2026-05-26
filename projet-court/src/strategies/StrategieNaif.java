package strategies;

import allumettes.Jeu;
import allumettes.Joueur;

public class StrategieNaif implements Strategie {

    // Retire un nombre d'allumettes aléatoire entre 1 et 3
    @Override
    public int choisirNombreAllumettes(Joueur joueur, int nombreAllumettes) {
        if (nombreAllumettes <= 0) {
            throw new IllegalArgumentException("Le nombre d'allumettes doit être positif.");
        }
        int maxRetrait = Math.min(Jeu.PRISE_MAX, nombreAllumettes);
        int result = (int) (Math.random() * maxRetrait) + 1;
        System.out.print(joueur.getNom() + " prend " + result + " allumette(s).");
        return result;
    }
}

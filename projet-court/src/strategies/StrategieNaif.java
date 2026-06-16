package strategies;

import allumettes.Jeu;
import allumettes.Joueur;

import java.util.Random;

public class StrategieNaif implements Strategie {

    // Retire un nombre d'allumettes aléatoire entre 1 et 3
    @Override
    public int choisirNombreAllumettes(Jeu jeu, Joueur joueur, int nombreAllumettes) {
        if (nombreAllumettes <= 0) {
            throw new IllegalArgumentException("Le nombre d'allumettes doit être positif.");
        }
        int maxRetrait = Math.min(Jeu.PRISE_MAX, nombreAllumettes);
        int result = new Random().nextInt(maxRetrait);
        System.out.print(joueur.getNom() + " prend " + result + " allumette(s).\n");
        return result;
    }
}

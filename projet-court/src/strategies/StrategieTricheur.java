package strategies;

import allumettes.CoupInvalideException;
import allumettes.Jeu;
import allumettes.Joueur;

public class StrategieTricheur implements Strategie{

    @Override
    public int choisirNombreAllumettes(Jeu jeu, Joueur joueur, int nombreAllumettes) {
        try {
            while (jeu.getNombreAllumettes() > 2) {
                jeu.retirer(1);
            }
        } catch (CoupInvalideException e) {
            throw new RuntimeException(e);
        }
        return 1;
    }

}

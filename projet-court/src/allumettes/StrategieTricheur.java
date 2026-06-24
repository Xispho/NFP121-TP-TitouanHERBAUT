package allumettes;

public class StrategieTricheur implements Strategie{

    @Override
    public int choisirNombreAllumettes(Jeu jeu, Joueur joueur, int nombreAllumettes) {
        while (jeu.getNombreAllumettes() > 2) {
            jeu.retirer(1);
        }
        return 1;
    }

}

package allumettes;

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

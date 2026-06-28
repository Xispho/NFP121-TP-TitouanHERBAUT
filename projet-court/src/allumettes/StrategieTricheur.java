package allumettes;

public class StrategieTricheur implements Strategie {

    @Override
    public int choisirNombreAllumettes(Jeu jeu, Joueur joueur, int nombreAllumettes) {
        System.out.println("[Je triche...]");
        tricher(jeu);
        System.out.println("[Allumettes restantes : " + jeu.getNombreAllumettes() + "]");
        return 1;
    }

    private void tricher(Jeu jeu) {
        try {
            while (jeu.getNombreAllumettes() > Jeu.PRISE_MAX - 1) {
                jeu.retirer(1);
            }
        } catch (CoupInvalideException e) {
            throw new RuntimeException(e);
        }
    }
}

package allumettes;

public interface Strategie {

    /**
     * Retourne le nombre d'allumettes que le joueur doit retirer.
     * @param nombreAllumettes le nombre d'allumettes restantes
     * @return le nombre d'allumettes à retirer
     */
    int choisirNombreAllumettes(Jeu jeu, Joueur joueur, int nombreAllumettes)
            throws CoupInvalideException;

}

package allumettes;

public class Arbitre {

    private Joueur joueur1;
    private Joueur joueur2;

    public Arbitre(Joueur joueur1, Joueur joueur2) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
    }

     public void arbitrer(Jeu jeu) throws CoupInvalideException {
        while (jeu.getNombreAllumettes() > 0) {
            int prise1 = joueur1.getPrise(jeu);
            jeu.retirer(prise1);
            if (jeu.getNombreAllumettes() <= 0) {
                System.out.println(joueur1.getNom() + " a gagné !");
                break;
            }

            int prise2 = joueur2.getPrise(jeu);
            jeu.retirer(prise2);
            if (jeu.getNombreAllumettes() == 0) {
                System.out.println(joueur2.getNom() + " a gagné !");
                break;
            }
        }
    }
}

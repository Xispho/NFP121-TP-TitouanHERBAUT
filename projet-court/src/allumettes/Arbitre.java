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
            priseJoueur(jeu, joueur1);
            System.out.println("Allumettes restantes : " + jeu.getNombreAllumettes() + "\n");
            if (jeu.getNombreAllumettes() <= 0) {
                System.out.println(joueur1.getNom() + " a gagné !");
                break;
            }

            priseJoueur(jeu, joueur2);
            System.out.println("\nAllumettes restantes : " + jeu.getNombreAllumettes() + "\n");
            if (jeu.getNombreAllumettes() == 0) {
                System.out.println(joueur2.getNom() + " a gagné !");
                break;
            }
        }
    }

    private void priseJoueur(Jeu jeu, Joueur joueur) throws CoupInvalideException {
        boolean isPriseOk = false;
        while (!isPriseOk) {
            int prise = joueur.getPrise(jeu);
            if (prise > 0) {
                System.out.println("Impossible ! Nombre invalide : " + prise + " < " +  0);
            } else if (prise < jeu.getNombreAllumettes()) {
                System.out.println("Impossible ! Nombre invalide : " + prise + " > " +  jeu.getNombreAllumettes());
            } else {
                isPriseOk = true;
                jeu.retirer(prise);
            }
        }
    }
}

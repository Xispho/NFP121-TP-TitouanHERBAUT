package allumettes;

import static java.lang.Integer.min;

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
            if (jeu.getNombreAllumettes() == 0) {
                System.out.println(
                    "\n" + joueur1.getNom() + " perd !"
                    + "\n" + joueur2.getNom() + " gagne !"
                );
                break;
            }

            priseJoueur(jeu, joueur2);
            if (jeu.getNombreAllumettes() == 0) {
                System.out.println(
                    "\n" + joueur2.getNom() + " perd !"
                    + "\n" + joueur1.getNom() + " gagne !"
                );
                break;
            }
        }
    }

    private void priseJoueur(Jeu jeu, Joueur joueur) throws CoupInvalideException {
        boolean isPriseOk = false;
        int prise = -1;
        System.out.println("\nAllumettes restantes : " + jeu.getNombreAllumettes());
        while (!isPriseOk) {
            prise = joueur.getPrise(jeu);

            System.out.print(joueur.getNom() + " prend " + prise + " allumette(s).\n");
            isPriseOk = checkPrise(jeu, prise);
        }
        jeu.retirer(prise);
    }

    private boolean checkPrise(Jeu jeu, int prise) {
        int priseMaxCurrentRound = min(Jeu.PRISE_MAX, jeu.getNombreAllumettes());
        if (prise < 1 || prise > priseMaxCurrentRound) {
            String erreur = "Impossible ! Nombre invalide : " + prise;
            if (prise < 1) {
                erreur += " (< " + 1 + ")";
            } else {
                erreur += " (> " + priseMaxCurrentRound + ")";
            }
            System.out.println(erreur + "\n");
            return false;
        }
        return true;
    }
}

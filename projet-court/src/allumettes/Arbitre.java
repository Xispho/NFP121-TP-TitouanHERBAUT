package allumettes;

import static java.lang.Integer.min;

public class Arbitre {

    private final Joueur joueur1;
    private final Joueur joueur2;

    private Joueur current;

    public Arbitre(Joueur joueur1, Joueur joueur2) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.current = joueur1;
    }

     public void arbitrer(Jeu jeu) {
        while (jeu.getNombreAllumettes() > 0) {
            priseJoueur(jeu, current);
            toggleCurrentJoueur();
        }
        displayEndMessage(current);
    }

    private void priseJoueur(Jeu jeu, Joueur joueur) {
        boolean isPriseOk = false;
        int prise = -1;
        while (!isPriseOk) {
            System.out.println("\nAllumettes restantes : " + jeu.getNombreAllumettes());
            prise = joueur.getPrise(jeu);

            System.out.print(joueur.getNom() + " prend " + prise + " allumette" + (prise > 1 ? "s" : "") + ".\n");
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
            System.out.println(erreur);
            return false;
        }
        return true;
    }

    private void toggleCurrentJoueur() {
        if (this.current == this.joueur1) {
            this.current = this.joueur2;
        } else {
            this.current = this.joueur1;
        }
    }

    private void displayEndMessage(Joueur winner) {
        Joueur loser = joueur1;
        if (winner == joueur1) {
            loser = joueur2;
        }
        System.out.println(
                "\n" + loser.getNom() + " perd !"
                + "\n" + winner.getNom() + " gagne !"
        );
    }
}

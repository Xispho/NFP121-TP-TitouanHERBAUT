package allumettes;

import static java.lang.Integer.min;

public class Arbitre {

    private final Joueur joueur1;
    private final Joueur joueur2;
    private final boolean confiant;
    private final Deroulement deroulement;

    private Joueur current;

    public Arbitre(Joueur joueur1, Joueur joueur2) {
        this(joueur1, joueur2, false);
    }

    public Arbitre(Joueur joueur1, Joueur joueur2, boolean confiant) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.confiant = confiant;
        this.current = joueur1;
        this.deroulement = new Deroulement();
    }

     public void arbitrer(Jeu jeu) throws CoupInvalideException {
        int prise = -1;
        while (jeu.getNombreAllumettes() > 0) {
            prise = priseJoueur(jeu, current);
            if (prise == -1) {
                break;
            } else {
                jeu.retirer(prise);
                deroulement.addCoup(current.getNom(), prise);
                toggleCurrentJoueur();
            }
        }
        if (prise == -1) {
            System.out.println("Abandon de la partie car "
                    + current.getNom() + " triche !");
            deroulement.setTricheur(current.getNom());
        } else {
            deroulement.setGagnant(current.getNom());
            displayEndMessage(current);
        }
        ExportXML.exportXML(deroulement);
    }

    private int priseJoueur(Jeu jeu, Joueur joueur)
            throws OperationInterditeException {
        boolean isPriseOk = false;
        int prise = -1;
        Jeu jeuProxy = new JeuProxy(jeu);
        if (confiant) {
            jeuProxy = jeu;
        }
        while (!isPriseOk) {
            System.out.println("\nAllumettes restantes : " + jeu.getNombreAllumettes());
            try {
                prise = joueur.getPrise(jeuProxy);
                System.out.print(joueur.getNom()
                        + " prend " + prise + " allumette"
                        + (prise > 1 ? "s" : "") + ".\n");
                isPriseOk = checkPrise(jeuProxy, prise);
            } catch (OperationInterditeException e) {
                break;
            }
        }
        if (isPriseOk) {
            return prise;
        }
        return -1;
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
        System.out.println("\n" + loser.getNom()
                + " perd !" + "\n" + winner.getNom() + " gagne !");
    }
}

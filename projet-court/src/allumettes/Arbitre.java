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
        while (!isPriseOk) {
            System.out.println("\nAllumettes restantes : " + jeu.getNombreAllumettes());
            int prise = joueur.getPrise(jeu);
            if (prise < 0 || prise > jeu.getNombreAllumettes()) {
                System.out.println("Impossible ! Nombre invalide : " + prise);
                if (prise < 0) {
                    System.out.println(" < " + 0);
                } else if (prise > jeu.getNombreAllumettes()) {
                    System.out.println(" > " + jeu.getNombreAllumettes());
                }
            } else {
                isPriseOk = true;
                jeu.retirer(prise);
            }
        }
    }
}

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
            boolean isGameEnded;
            isGameEnded = playRound(jeu, joueur1);
            if (isGameEnded) {
                break;
            }
            isGameEnded = playRound(jeu, joueur2);
            if (isGameEnded) {
                break;
            }
        }
    }

    private void priseJoueur(Jeu jeu, Joueur joueur) throws CoupInvalideException {
        boolean isPriseOk = false;
        while (!isPriseOk) {
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

    private boolean playRound(Jeu jeu, Joueur joueur) throws CoupInvalideException {
        System.out.println("\nAllumettes restantes : " + jeu.getNombreAllumettes());
        priseJoueur(jeu, joueur);
        if (jeu.getNombreAllumettes() <= 1) {
            System.out.println("\r\n" + joueur.getNom() + " a gagné !");
            return true;
        }
        return false;
    }
}

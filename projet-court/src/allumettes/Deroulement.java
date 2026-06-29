package allumettes;

import java.util.ArrayList;
import java.util.List;

public class Deroulement {

    private List<Coup> coups;
    private String gagnant;
    private String tricheur;

    public Deroulement() {
        this.coups = new ArrayList<>();
        this.gagnant = "";
        this.tricheur = "";
    }

    public void addCoup(String joueur, int nbAllumetteprise) {
        coups.add(new Coup(joueur, nbAllumetteprise));
    }

    public void setGagnant(String gagnant) {
        this.gagnant = gagnant;
    }

    public void setTricheur(String tricheur) {
        this.tricheur = tricheur;
    }

    public List<Coup> getCoups() {
        return coups;
    }

    public String getGagnant() {
        return gagnant;
    }

    public String getTricheur() {
        return tricheur;
    }

    public static class Coup {

        private String joueur;
        private int nbAllumetteprise;

        public Coup(String joueur, int nbAllumetteprise) {
            this.joueur = joueur;
            this.nbAllumetteprise = nbAllumetteprise;
        }

        public int getNbAllumetteprise() {
            return nbAllumetteprise;
        }

        public String getJoueur() {
            return joueur;
        }
    }
}



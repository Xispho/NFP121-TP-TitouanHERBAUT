package allumettes;

import strategies.StrategiePossible;

public class Joueur {

    private String nom;
    private StrategiePossible strategie;

    public Joueur(String nom, StrategiePossible strategie) {
        this.nom = nom;
        this.strategie = strategie;
    }

    public Joueur(String description) throws ConfigurationException {
        String[] parts = description.split("@");
        this.nom = parts[0];
        this.strategie = StrategiePossible.getStrategie(parts[1]);
    }

    public String getNom() {
        return nom;
    }

    public int getPrise(Jeu jeu) {
        int nbAllumettes = jeu.getNombreAllumettes();
        return strategie.getStrategieInstance().choisirNombreAllumettes(this, nbAllumettes);
    }

    public StrategiePossible getStrategie() {
        return strategie;
    }

}

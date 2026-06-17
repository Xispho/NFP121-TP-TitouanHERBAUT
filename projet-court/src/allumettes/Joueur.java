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
        if (description == null) {
            throw new ConfigurationException("Description du joueur invalide: null");
        }
        String[] parts = description.split("@", 2);
        if (parts.length < 2) {
            throw new ConfigurationException("Description du joueur invalide (format attendu: nom@strategie) : " + description);
        }
        this.nom = parts[0].trim();
        if (this.nom.isEmpty()) {
            throw new ConfigurationException("Nom de joueur vide dans la description : " + description);
        }
        String nomStrategie = parts[1].trim();
        if (nomStrategie.isEmpty()) {
            throw new ConfigurationException("Stratégie manquante dans la description : " + description);
        }
        this.strategie = StrategiePossible.getStrategie(nomStrategie);
    }

    public String getNom() {
        return nom;
    }

    public int getPrise(Jeu jeu) {
        int nbAllumettes = jeu.getNombreAllumettes();
        return strategie.getStrategieInstance().choisirNombreAllumettes(
                jeu, this, nbAllumettes
        );
    }

    public StrategiePossible getStrategie() {
        return strategie;
    }

}

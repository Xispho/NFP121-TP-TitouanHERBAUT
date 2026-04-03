package strategies;

public enum StrategiePossible {
    NAIF("naif"),
    RAPIDE("rapide"),
    EXPERT("expert"),
    HUMAIN("humain"),
    TRICHEUR("tricheur");

    public String nom;

    StrategiePossible(String nom) {
        this.nom = nom;
    }

    public static StrategiePossible getStrategie(String nom) {
        for (StrategiePossible sp : values()) {
            if (sp.nom.equalsIgnoreCase(nom)) {
                return sp;
            }
        }
        throw new IllegalArgumentException("Stratégie inconnue : " + nom);
    }

    public Strategie getStrategieInstance() {
        switch (this) {
            case NAIF:
                return new StrategieNaif();
            case RAPIDE:
                return new StrategieRapide();
            case EXPERT:
                return new StrategieExpert();
            case HUMAIN:
                return new StrategieHumain();
            case TRICHEUR:
                return new StrategieTricheur();
            default:
                throw new IllegalStateException("Stratégie non gérée : " + this);
        }
    }
}

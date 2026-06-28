package allumettes;

public class StrategieSwing implements Strategie {

    private final AllumettesInterface fenetre;

    public StrategieSwing() {
        this.fenetre = new AllumettesInterface();
    }

    @Override
    public int choisirNombreAllumettes(Jeu jeu, Joueur joueur, int nombreAllumettes) {
        return this.fenetre.getPrise(jeu, joueur);
    }

}

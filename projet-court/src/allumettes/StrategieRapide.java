package allumettes;

public class StrategieRapide implements Strategie {

    @Override
    public int choisirNombreAllumettes(Jeu jeu, Joueur joueur, int nombreAllumettes) {
        return Math.min(Jeu.PRISE_MAX, nombreAllumettes);
    }
}

package allumettes;

public class StrategieExpert implements Strategie {

    @Override
    public int choisirNombreAllumettes(Jeu jeu, Joueur joueur, int nombreAllumettes) {
        int prise;
        if (nombreAllumettes > Jeu.PRISE_MAX+1) {
            int reste = nombreAllumettes % (Jeu.PRISE_MAX+1);
            prise = (reste == 0) ? Jeu.PRISE_MAX : reste - 1;
        } else if (nombreAllumettes == 1) {
            prise = 1;
        } else {
            prise = nombreAllumettes - 1;
        }
        return prise;
    }
}

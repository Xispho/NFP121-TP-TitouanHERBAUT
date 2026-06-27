package allumettes;

public class JeuProxy implements Jeu {

    private final Jeu jeuReel;

    public JeuProxy(Jeu jeuReel) {
        this.jeuReel = jeuReel;
    }

    @Override
    public int getNombreAllumettes() {
        return jeuReel.getNombreAllumettes();
    }

    @Override
    public void retirer(int nbPrises) {
        throw new OperationInterditeException("Triche !");
    }
}


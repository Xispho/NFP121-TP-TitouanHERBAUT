package allumettes;

public class Game implements Jeu{

    private int nombreAllumettes;

    public Game(int nombreAllumettes) {
        this.nombreAllumettes = nombreAllumettes;
    }

    @Override
    public int getNombreAllumettes() {
        return nombreAllumettes;
    }

    @Override
    public void retirer(int nombre) throws CoupInvalideException {
        if (nombre < 1 || nombre > PRISE_MAX || nombre > nombreAllumettes) {
            throw new CoupInvalideException(nombre, "Invalide");
        }
        nombreAllumettes -= nombre;
    }

}

package allumettes;

public class Game implements Jeu {

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
        if (nombre < 1) {
            throw new CoupInvalideException(nombre, "1 >");
        } else if (nombre > PRISE_MAX) {
            throw new CoupInvalideException(nombre, PRISE_MAX + " <");
        } else if (nombre > nombreAllumettes) {
            throw new CoupInvalideException(nombre, nombreAllumettes + " <");
        }
        nombreAllumettes -= nombre;
    }

}

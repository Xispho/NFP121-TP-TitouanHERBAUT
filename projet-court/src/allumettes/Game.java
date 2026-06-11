package allumettes;

import java.util.Scanner;

public class Game implements Jeu {

    private int nombreAllumettes;
    private Scanner scanner;

    public Game(int nombreAllumettes) {
        this.nombreAllumettes = nombreAllumettes;
        this.scanner = new Scanner(System.in);
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

    @Override
    public Scanner getScanner() {
        return scanner;
    }

}

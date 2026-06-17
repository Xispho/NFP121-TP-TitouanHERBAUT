package allumettes;

import java.util.Scanner;

public final class ScannerSingleton {

    private static ScannerSingleton instance;
    private Scanner scanner;

    /**
     * Constructeur qui crée un scanner
     */
    private ScannerSingleton() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Retourne l'instance unique de Scanner liée à System.in.
     * Crée l'instance si elle n'existe pas encore
     */
    public static ScannerSingleton getInstance() {
        if (instance == null) {
            instance = new ScannerSingleton();
        }
        return instance;
    }

    public Scanner getScanner() {
        return scanner;
    }
}


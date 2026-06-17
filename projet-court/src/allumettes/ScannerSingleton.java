package allumettes;

import java.util.Scanner;

public class ScannerSingleton {

    private static ScannerSingleton instance;
    private Scanner scanner;

    // Constructeur privé pour empêcher l'instantiation.
    private ScannerSingleton() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Retourne l'instance unique de Scanner liée à System.in.
     * Ne fermez pas le scanner sauf si l'application se termine (fermer System.in aussi).
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


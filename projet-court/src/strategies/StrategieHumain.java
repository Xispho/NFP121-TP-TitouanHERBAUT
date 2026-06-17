package strategies;

import allumettes.Jeu;
import allumettes.Joueur;
import allumettes.ScannerSingleton;

import java.util.Scanner;
import java.util.InputMismatchException;

public class StrategieHumain implements Strategie {

    @Override
    public int choisirNombreAllumettes(Jeu jeu, Joueur joueur, int nombreAllumettes) {
        ScannerSingleton scannerSingleton = ScannerSingleton.getInstance();
        Scanner scanner = scannerSingleton.getScanner();
        System.out.print(joueur.getNom() + ", combien d'allumettes ? ");
        int prise = 0;
        try {
            prise = scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.out.println("Vous devez donner un entier.");
        }
        return prise;
    }

}

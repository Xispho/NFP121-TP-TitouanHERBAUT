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
        boolean notEntier = true;
        int prise = 0;
        while (notEntier) {
            System.out.print(joueur.getNom() + ", combien d'allumettes ? ");
            try {
                prise = scanner.nextInt();
                notEntier = false;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Vous devez donner un entier.");
            }
        }
        return prise;
    }

}

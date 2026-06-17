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
        int prise = 0;
        while (prise <= 0 || prise > Math.min(3, nombreAllumettes)) {
            System.out.print(joueur.getNom() + ", combien d'allumettes ? ");
            try {
                prise = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Vous devez donner un entier.");
            }
        }
        System.out.print(joueur.getNom() + " prend " + prise + " allumette(s).\n");
        return prise;
    }

}

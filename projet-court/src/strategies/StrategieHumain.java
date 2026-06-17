package strategies;

import allumettes.Jeu;
import allumettes.Joueur;
import allumettes.ScannerSingleton;

import java.util.Scanner;

public class StrategieHumain implements Strategie {

    @Override
    public int choisirNombreAllumettes(Jeu jeu, Joueur joueur, int nombreAllumettes) {
        int prise = 0;
        while (prise <= 0 || prise > Math.min(3, nombreAllumettes)) {
            System.out.print(joueur.getNom() + ", combien d'allumettes ? ");
//            try {
                ScannerSingleton scannerSingleton = ScannerSingleton.getInstance();
                Scanner scanner = scannerSingleton.getScanner();
                prise = scanner.nextInt();
//            } catch (OperationInterditeException e) {
//                System.out.println("Veuillez entrer un nombre valide.");
//            }
        }
        System.out.print(joueur.getNom() + " prend " + prise + " allumette(s).\n");
        return prise;
    }

}

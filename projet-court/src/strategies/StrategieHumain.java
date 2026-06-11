package strategies;

import allumettes.Jeu;
import allumettes.Joueur;

import java.util.Scanner;

public class StrategieHumain implements Strategie {

    @Override
    public int choisirNombreAllumettes(Jeu jeu, Joueur joueur, int nombreAllumettes) {
        int prise = 0;
        while (prise <= 0 || prise > Math.min(3, nombreAllumettes)) {
            System.out.print(joueur.getNom() + ", combien d'allumettes ? ");
//            try {
//                Scanner scanner = new Scanner(System.in);
                Scanner scanner = jeu.getScanner();
                prise = scanner.nextInt();
//            } catch (OperationInterditeException e) {
//                System.out.println("Veuillez entrer un nombre valide.");
//            }
        }
        return prise;
    }

}

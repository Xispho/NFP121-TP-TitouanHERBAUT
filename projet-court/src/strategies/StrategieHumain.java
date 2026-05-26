package strategies;

import allumettes.Joueur;

import java.util.Scanner;

public class StrategieHumain implements Strategie {

    @Override
    public int choisirNombreAllumettes(Joueur joueur, int nombreAllumettes) {
        int prise = 0;
        while (prise <= 0 || prise > Math.min(3, nombreAllumettes)) {
            System.out.print(joueur.getNom() + ", combien d'allumettes ? ");
            try {
                Scanner scanner = new Scanner(System.in);
                prise = scanner.nextInt();
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide.");
            }
        }
        return prise;
    }

}

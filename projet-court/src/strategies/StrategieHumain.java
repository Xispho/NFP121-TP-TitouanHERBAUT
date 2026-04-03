package strategies;

import java.util.Scanner;

public class StrategieHumain implements Strategie{

    @Override
    public int choisirNombreAllumettes(int nombreAllumettes) {
        int prise = 0;
        while (prise <= 0 || prise > Math.min(3, nombreAllumettes)) {
            System.out.print("Combien d'allumettes voulez-vous prendre ? (1-3) ");
            try {
                // TODO: Scanner
                Scanner scanner = new Scanner(System.in);
                prise = scanner.nextInt();
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide.");
            }
        }
        return prise;
    }

}

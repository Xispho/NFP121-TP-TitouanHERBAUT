package allumettes;

import java.util.Arrays;
import java.util.Scanner;

public class StrategieHumain implements Strategie {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static final String[] tricherStrings = {"[je triche...]"};

    @Override
    public int choisirNombreAllumettes(Jeu jeu, Joueur joueur, int nombreAllumettes) {
        boolean notEntier = true;
        int prise = 0;
        while (notEntier) {
            System.out.print(joueur.getNom() + ", combien d'allumettes ? ");
            String input = SCANNER.nextLine();
            if (Arrays.asList(tricherStrings).contains(input)) {
                tricher(jeu);
                return 1;
            } else {
                try {
                    prise = Integer.parseInt(input);
                    notEntier = false;
                } catch (NumberFormatException e) {
                    System.out.println("Vous devez donner un entier.");
                }
            }
        }
        return prise;
    }

    private void tricher(Jeu jeu) {
        try {
            while (jeu.getNombreAllumettes() > 2) {
                jeu.retirer(1);
            }
        } catch (CoupInvalideException e) {
            throw new RuntimeException(e);
        }
    }

}

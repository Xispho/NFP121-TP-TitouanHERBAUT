package allumettes;

import java.util.Arrays;
import java.util.Scanner;

public class StrategieHumain implements Strategie {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static final String[] TricherStrings = {"[je triche...]", "triche"};

    @Override
    public int choisirNombreAllumettes(Jeu jeu, Joueur joueur, int nombreAllumettes) {
        boolean notEntier = true;
        int prise = 0;
        while (notEntier) {
            System.out.print(joueur.getNom() + ", combien d'allumettes ? ");
            String input = SCANNER.nextLine();
            if (Arrays.asList(TricherStrings).contains(input)) {
                if (input.equals("[je triche...]")) {
                    tricher(jeu, 2);
                    System.out.println("[je triche...]" +
                            " \n[Allumettes restantes : " +
                            jeu.getNombreAllumettes() + "]");
                    return 1;
                } else if (input.equals("triche")) {
                    tricher(jeu, 4);
                    System.out.println("[Une allumette en moins, plus que 4. Chut !]");
                    return 3;
                }
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

    private void tricher(Jeu jeu, int target) {
        try {
            while (jeu.getNombreAllumettes() > target) {
                jeu.retirer(1);
            }
        } catch (CoupInvalideException e) {
            throw new RuntimeException(e);
        }
    }

}

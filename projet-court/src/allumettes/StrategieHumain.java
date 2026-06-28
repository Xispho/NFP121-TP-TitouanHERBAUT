package allumettes;

import java.util.Scanner;

public class StrategieHumain implements Strategie {

    public static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public int choisirNombreAllumettes(Jeu jeu, Joueur joueur, int nombreAllumettes) {
        boolean notEntier = true;
        int prise = 0;
        while (notEntier) {
            System.out.print(joueur.getNom() + ", combien d'allumettes ? ");
            String input = SCANNER.nextLine();
            if (input.equals("triche")) {
                tricher(jeu);
                System.out.println("[Une allumette en moins, plus que 4. Chut !]"
                        + joueur.getNom() + ", combien d'allumettes ? ");
                return Jeu.PRISE_MAX;
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
            while (jeu.getNombreAllumettes() > Jeu.PRISE_MAX + 1) {
                jeu.retirer(1);
            }
        } catch (CoupInvalideException e) {
            throw new RuntimeException(e);
        }
    }

}

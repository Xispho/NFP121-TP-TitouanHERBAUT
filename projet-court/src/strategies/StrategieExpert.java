package strategies;

import allumettes.Jeu;

public class StrategieExpert implements Strategie{

    // Retire un nombre d'allumettes pour laisser un multiple de 4 à l'adversaire
    @Override
    public int choisirNombreAllumettes(int nombreAllumettes) {
        if (nombreAllumettes <= 0) {
            throw new IllegalArgumentException("Le nombre d'allumettes doit être positif.");
        }
        int reste = nombreAllumettes % 4;
        return (reste == 0) ? Jeu.PRISE_MAX : reste;
    }
}

package allumettes;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StrategieRapideTest {

    private Jeu jeu;
    private Joueur joueur1;
    private Joueur joueur2;

    @Before
    public void before() {
        jeu = new Game(Jouer.NB_ALLUMETTES);
        joueur1  = new Joueur("Joueur 1", new StrategieRapide());
    }

    @Test
    public void testDebutPartie() {
        joueur2 = new Joueur("Joueur 2", new StrategieRapide());
        int priseJ2 = joueur2.getPrise(jeu);
        assertEquals(Jeu.PRISE_MAX, priseJ2);
    }

    @Test
    public void test3AllumettesRestantes() throws CoupInvalideException {
        joueur2 = new Joueur("Joueur 2", new StrategieRapide());

        jeu.retirer(joueur1.getPrise(jeu));
        while (jeu.getNombreAllumettes() > 3) {
            jeu.retirer(1);
        }
        int priseJ2 = joueur2.getPrise(jeu);
        assertEquals(Jeu.PRISE_MAX, priseJ2);
    }

    @Test
    public void test2AllumettesRestantes() throws CoupInvalideException {
        joueur2 = new Joueur("Joueur 2", new StrategieRapide());

        jeu.retirer(joueur1.getPrise(jeu));
        while (jeu.getNombreAllumettes() > 2) {
            jeu.retirer(1);
        }
        int priseJ2 = joueur2.getPrise(jeu);
        assertEquals(2, priseJ2);
    }

    @Test
    public void test1AllumetteRestante() throws CoupInvalideException {
        joueur2 = new Joueur("Joueur 2", new StrategieRapide());

        jeu.retirer(joueur1.getPrise(jeu));
        while (jeu.getNombreAllumettes() > 1) {
            jeu.retirer(1);
        }
        int priseJ2 = joueur2.getPrise(jeu);
        assertEquals(1, priseJ2);
    }

    @Test
    public void test0AllumetteRestante() throws CoupInvalideException {
        joueur2 = new Joueur("Joueur 2", new StrategieRapide());

        jeu.retirer(joueur1.getPrise(jeu));
        while (jeu.getNombreAllumettes() > 0) {
            jeu.retirer(1);
        }
        int priseJ2 = joueur2.getPrise(jeu);
        assertEquals(0, priseJ2);
    }

}

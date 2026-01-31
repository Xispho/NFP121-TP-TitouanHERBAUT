import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class CercleTest {

    @Test
    public void testE12() {
        Point C = new Point(4, 1);
        Point D = new Point(8, 1);
        Cercle c1 = new Cercle(C, D);
        assertEquals(2.0, c1.getRayon(), 0.0);
        assertEquals(Color.BLUE, c1.getCouleur());
    }

    @Test
    public void testE13() {
        Point C = new Point(4, 1);
        Point D = new Point(8, 1);
        Cercle c1 = new Cercle(C, D, Color.YELLOW);
        assertEquals(2.0, c1.getRayon(), 0.0);
        assertEquals(Color.YELLOW, c1.getCouleur());
    }

    @Test
    public void testE14() {
        Point D = new Point(8, 1);
        Point E = new Point(8, 4);
        Cercle c1 = Cercle.creerCercle(D, E);
        double distance = D.distance(E);
        assertEquals(distance, c1.getRayon(), 0.0);
        assertEquals(Color.BLUE, c1.getCouleur());
    }

}
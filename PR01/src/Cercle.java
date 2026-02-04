import java.awt.*;

public class Cercle implements Mesurable2D{

    public static final double PI = Math.PI;

    private Point centre;
    private double rayon;

    private Color couleur;

    /** Construire un cercle à partir de son centre et de son rayon.
     * @param p centre du cercle
     * @param r rayon du cercle
     * @throws AssertionError si le rayon n'est pas strictement positif ou si le centre est null
     */
    public Cercle(Point p, double r) throws AssertionError {
        if (r <= 0)
            throw new AssertionError("Le rayon doit être strictement positif");
        if (p == null)
            throw new AssertionError("Le centre du cercle ne peut pas être null");

        this.centre = p;
        this.rayon = r;
        this.couleur = Color.blue;
    }

    /** Construire un cercle à partir de deux points diamétralement opposés.
     * Le cercle est de couleur bleue par défaut.
     * @param p un point du cercle
     * @param p1 un point diamétralement opposé au premier
     * @throws AssertionError si les points sont nuls ou identiques
     */
    public Cercle(Point p, Point p1) throws AssertionError {
        if (p == null || p1 == null)
            throw new AssertionError("Les points ne peuvent pas être nuls");
        if (p.getX() == p1.getX() && p.getY() == p1.getY())
            throw new AssertionError("Les points doivent être différents");
        double x = (p.getX() + p1.getX()) / 2;
        double y = (p.getY() + p1.getY()) / 2;
        this.centre = new Point(x, y);
        this.rayon = p.distance(p1) / 2;
        this.couleur = Color.BLUE;
    }

    /** Construire un cercle à partir de deux points diamétralement opposés et d'une couleur.
     * @param p un point du cercle
     * @param p1 un point diamétralement opposé au premier
     * @param c la couleur du cercle
     * @throws AssertionError si les points sont nuls ou identiques, ou si la couleur est nulle
     */
    public Cercle(Point p, Point p1, Color c) throws AssertionError {
        if (p == null || p1 == null)
            throw new AssertionError("Les points ne peuvent pas être nuls");
        if (p.getX() == p1.getX() && p.getY() == p1.getY())
            throw new AssertionError("Les points doivent être différents");
        double x = (p.getX() + p1.getX()) / 2;
        double y = (p.getY() + p1.getY()) / 2;
        this.centre = new Point(x, y);
        this.rayon = p.distance(p1) / 2;
        this.couleur = c;
    }

    /** Construire un cercle à partir de son centre et d'un point du cercle.
     * Le cercle est de couleur bleue par défaut.
     * @param centre centre du cercle
     * @param p un point du cercle
     * @return le cercle construit
     */
    public static Cercle creerCercle(Point centre, Point p) {
        assert centre != null : "Centre du cercle null";
        assert p != null : "Point du cercle null";
        return new Cercle(centre, centre.distance(p));
    }

    /** Retourne le centre
     * @return le centre du cercle
     */
    public Point getCentre() {
        return this.centre;
    }

    /** Modifier le centre
     * @param centre nouveau centre du cercle
     */
    public void setCentre(Point centre) {
        this.centre = centre;
    }

    /** Retourne le rayon
     * @return le rayon du cercle
     */
    public double getRayon() {
        return rayon;
    }

    /** Modifier le rayon
     * @param rayon nouveau rayon du cercle
     * @throws AssertionError si le rayon n'est pas strictement positif
     */
    public void setRayon(double rayon) throws AssertionError {
        if (rayon <= 0)
            throw new AssertionError("Le rayon doit être strictement positif");
        this.rayon = rayon;
    }

    /** Retourne la couleur
     * @return la couleur du cercle
     */
    public Color getCouleur() {
        return couleur;
    }

    /** Modifier la couleur
     * @param couleur nouvelle couleur du cercle
     * @throws AssertionError si la couleur est nulle
     */
    public void setCouleur(Color couleur) throws AssertionError {
        if (couleur == null) {
            throw new AssertionError("La couleur ne peut pas être nulle");
        }
        this.couleur = couleur;
    }

    /** Translater le cercle
     * @param i translation en x
     * @param i1 translation en y
     */
    public void translater(int i, int i1) {
        this.centre.translater(i, i1);
    }

    /** Retourne le diamètre
     * @return le diamètre du cercle
     */
    public double getDiametre() {
        return this.rayon*2;
    }

    /** Modifier le diamètre
     * @param d nouveau diamètre du cercle
     * @throws AssertionError si le diamètre n'est pas strictement positif
     */
    public void setDiametre(int d) throws AssertionError {
        if (d <= 0)
            throw new AssertionError("Le diamètre doit être strictement positif");
        this.rayon = d/2.0;
    }

    /** Vérifie si un point est contenu dans le cercle
     * @param a le point à tester
     * @return true si le point est dans le cercle, false sinon
     */
    public boolean contient(Point a) {
        assert a != null;
        return this.centre.distance(a) <= this.rayon;
    }

    /** Afficher le cercle dans la console */
    public void afficher() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "C" + this.rayon + "@(" + this.centre.getX() + ", " + this.centre.getY() + ")" ;
    }

    @Override
    public double perimetre() {
        return 2*PI*this.rayon;
    }

    @Override
    public double aire() {
        return PI*this.rayon*this.rayon;
    }
}
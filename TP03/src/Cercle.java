import java.awt.*;

public class Cercle implements Mesurable2D{

    public static final double PI = Math.PI;

    private Point centre;
    private double rayon;

    private Color couleur;

    /** Construire un cercle à partir de son centre et de son rayon.
     * @param p centre du cercle
     * @param r rayon du cercle
     */
    public Cercle(Point p, double r) {
        this.centre = p;
        this.rayon = r;
        this.couleur = Color.blue;
    }

    /** Construire un cercle à partir de deux points diamétralement opposés.
     * Le cercle est de couleur bleue par défaut.
     * @param p un point du cercle
     * @param p1 un point diamétralement opposé au premier
     */
    public Cercle(Point p, Point p1) {
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
     */
    public Cercle(Point p, Point p1, Color c) {
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
     */
    public void setRayon(double rayon) {
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
     */
    public void setCouleur(Color couleur) {
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
     * @param i nouveau diamètre du cercle
     */
    public void setDiametre(int i) {
        this.rayon = i/2.0;
    }

    /** Vérifie si un point est contenu dans le cercle
     * @param a le point à tester
     * @return true si le point est dans le cercle, false sinon
     */
    public boolean contient(Point a) {
        return this.centre.distance(a) <= this.rayon;
    }

    /** Afficher le cercle */
    public void afficher() {
        System.out.println("C" + this.rayon + "@(" + this.centre.getX() + ", " + this.centre.getY() + ")" );
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
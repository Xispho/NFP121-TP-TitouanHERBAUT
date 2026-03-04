import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.event.*;
import java.awt.event.*;
import java.util.*;

/** Programmation d'un jeu de Morpion avec une interface graphique Swing.
  *
  * REMARQUE : Dans cette solution, le patron MVC n'a pas été appliqué !
  * On a un modèle (?), une vue et un contrôleur qui sont fortement liés.
  *
  * @author	Xavier Crégut
  * @version	$Revision: 1.4 $
  */

public class MorpionSwing {

	// les images à utiliser en fonction de l'état du jeu.
	private static final Map<ModeleMorpion.Etat, ImageIcon> images
		= new HashMap<ModeleMorpion.Etat, ImageIcon>();
	static {
		images.put(ModeleMorpion.Etat.VIDE, new ImageIcon("K:\\IPST-CNAM\\i1\\NFP121 - Programmation avancée\\NFP121-TP-TitouanHERBAUT\\TP13\\blanc.jpg"));
		images.put(ModeleMorpion.Etat.CROIX, new ImageIcon("K:\\IPST-CNAM\\i1\\NFP121 - Programmation avancée\\NFP121-TP-TitouanHERBAUT\\TP13\\croix.jpg"));
		images.put(ModeleMorpion.Etat.ROND, new ImageIcon("K:\\IPST-CNAM\\i1\\NFP121 - Programmation avancée\\NFP121-TP-TitouanHERBAUT\\TP13\\rond.jpg"));
	}

// Choix de réalisation :
// ----------------------
//
//  Les attributs correspondant à la structure fixe de l'IHM sont définis
//	« final static » pour montrer que leur valeur ne pourra pas changer au
//	cours de l'exécution.  Ils sont donc initialisés sans attendre
//  l'exécution du constructeur !

	private ModeleMorpion modele;	// le modèle du jeu de Morpion

//  Les éléments de la vue (IHM)
//  ----------------------------

	/** Fenêtre principale */
	private JFrame fenetre;

	/** Bouton pour quitter */
	private final JButton boutonQuitter = new JButton("Q");

	/** Bouton pour commencer une nouvelle partie */
	private final JButton boutonNouvellePartie = new JButton("N");

	/** Cases du jeu */
	private final JLabel[][] cases = new JLabel[3][3];

	/** Zone qui indique le joueur qui doit jouer */
	private final JLabel joueur = new JLabel();


// Le constructeur
// ---------------

	/** Construire le jeu de morpion */
	public MorpionSwing() {
		this(new ModeleMorpionSimple());
	}

	/** Construire le jeu de morpion */
	public MorpionSwing(ModeleMorpion modele) {
		// Initialiser le modèle
		this.modele = modele;

		// Créer les cases du Morpion
		for (int i = 0; i < this.cases.length; i++) {
			for (int j = 0; j < this.cases[i].length; j++) {
				this.cases[i][j] = new JLabel();
			}
		}

		// Initialiser le jeu
		this.recommencer();

		// Construire la vue (présentation)
		//	Définir la fenêtre principale
		this.fenetre = new JFrame("Morpion");
		this.fenetre.setLocation(100, 200);
		this.fenetre.setPreferredSize(new Dimension(500,500));

		// Construire le contrôleur (gestion des événements)
		this.fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// afficher la fenêtre
		this.fenetre.pack();			// redimmensionner la fenêtre
		this.fenetre.setVisible(true);	// l'afficher


		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		this.fenetre.getContentPane().add(pane);

		pane.add(menuBar(), BorderLayout.NORTH);

		JPanel gridMorpion = new JPanel();
		GridLayout gridLayout = new GridLayout(3, 3);
		gridLayout.setVgap(0);
		gridLayout.setHgap(0);
		gridMorpion.setLayout(gridLayout);

		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		for (int i = 0; i < cases.length; i++) {
			for (int j = 0; j < cases[i].length; j++) {
				int ligne = i;
				int colonne = j;
				JLabel jLabel = cases[ligne][colonne];
				jLabel.setBorder(border);
				jLabel.addMouseListener(
					new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
                            try {
                                cocher(ligne, colonne, e);
                            } catch (CaseOccupeeException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
					}
				);
				gridMorpion.add(jLabel);
			}
		}
		pane.add(gridMorpion, BorderLayout.CENTER);
	}

// Quelques réactions aux interactions de l'utilisateur
// ----------------------------------------------------

	/** Recommencer une nouvelle partie. */
	public void recommencer() {
		this.modele.recommencer();

		// Vider les cases
		for (int i = 0; i < this.cases.length; i++) {
			for (int j = 0; j < this.cases[i].length; j++) {
				this.cases[i][j].setIcon(images.get(this.modele.getValeur(i, j)));
			}
		}

		// Mettre à jour le joueur
		joueur.setIcon(images.get(modele.getJoueur()));
	}

	public void quitter() {
		this.modele.quitter();
	}

	private void cocher(int i, int j, MouseEvent e) throws CaseOccupeeException {
		if (cases[i][j] == e.getSource()) {
			try {
				this.modele.cocher(i, j);
				this.cases[i][j].setIcon(images.get(this.modele.getValeur(i, j)));
				this.joueur.setIcon(images.get(modele.getJoueur()));
			} catch (CaseOccupeeException ex) {
				JOptionPane.showMessageDialog(fenetre, "Cette case est déjà occupée !");
			}
			if (modele.estTerminee()) {
				if (modele.estGagnee()) {
					JOptionPane.showMessageDialog(fenetre, "Le joueur " + modele.getJoueur() + " a gagné !");
				} else {
					JOptionPane.showMessageDialog(fenetre, "Match nul !");
				}
			}
		}
	}


	private JMenuBar menuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Jeu");
		menuBar.add(menu);
		JMenuItem nouvellePartie = new JMenuItem("Nouvelle partie");
		nouvellePartie.addActionListener(e -> recommencer());
		menu.add(nouvellePartie);
		JMenuItem quitter = new JMenuItem("Quitter");
		quitter.addActionListener(e -> quitter());
		menu.add(quitter);
		return menuBar;
	}

// La méthode principale
// ---------------------

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MorpionSwing();
			}
		});
	}

}

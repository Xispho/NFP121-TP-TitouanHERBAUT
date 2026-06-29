package allumettes;

/** Lance une partie des 13 allumettes en fonction des arguments fournis
 * sur la ligne de commande.
 * @author	Xavier Crégut
 * @version	$Revision: 1.5 $
 */
public class Jouer {

	static final int NB_ALLUMETTES = 13;

	/** Lancer une partie. En argument sont donnés les deux joueurs sous
	 * la forme nom@stratégie.
	 * @param args la description des deux joueurs
	 */
	public static void main(String[] args) {
		try {
			verifierNombreArguments(args);

			boolean confiant = false;
			int indexJoueur1 = 0;
			if (args.length > 0 && args[0].equals("-confiant")) {
				confiant = true;
				indexJoueur1 = 1;
			}

			Joueur joueur1 = creerJoueur(args[indexJoueur1]);
			Joueur joueur2 = creerJoueur(args[indexJoueur1 + 1]);
			Arbitre arbitre = new Arbitre(
				joueur1,
				joueur2,
				confiant
			);
			Jeu jeu = new Game(NB_ALLUMETTES);
			arbitre.arbitrer(jeu);
		} catch (ConfigurationException e) {
			System.out.println();
			System.out.println("Erreur : " + e.getMessage());
			afficherUsage();
			System.exit(1);
		} catch (CoupInvalideException e) {
            throw new RuntimeException(e);
        }
    }

	private static void verifierNombreArguments(String[] args) {
		final int nbJoueurs = 2;
		if (args.length < nbJoueurs) {
			throw new ConfigurationException("Trop peu d'arguments : "
					+ args.length);
		}
		if (args.length > nbJoueurs + 1) {
			throw new ConfigurationException("Trop d'arguments : "
					+ args.length);
		}
	}

	private static Joueur creerJoueur(String description) {
		String nom;
		Strategie strategie;
		if (description == null) {
			throw new ConfigurationException("Description du joueur invalide: null");
		}
		String[] parts = description.split("@", 2);
		if (parts.length < 2) {
			throw new ConfigurationException(
					"Description invalide (format attendu: nom@strategie) : "
							+ description
			);
		}
		nom = getPart("nom", description, 0);
		strategie = getStrategieInstance(getPart("stratégie", description, 1));
		return new Joueur(nom, strategie);
	}

	private static String getPart(String attribute, String description, int part) {
		String nom;
		String[] parts = description.split("@", 2);
		nom = parts[part].trim();
		if (nom.isEmpty()) {
			throw new ConfigurationException(
					attribute + " vide dans la description : "
							+ description
			);
		}
		return nom;
	}

	public static Strategie getStrategieInstance(String strategie) {
		switch (strategie) {
			case "naif":
				return new StrategieNaif();
			case "rapide":
				return new StrategieRapide();
			case "expert":
				return new StrategieExpert();
			case "humain":
				return new StrategieHumain();
			case "tricheur":
				return new StrategieTricheur();
			case "swing":
				return new StrategieSwing();
			default:
				throw new ConfigurationException("Stratégie non gérée : " + strategie);
		}
	}

	/** Afficher des indications sur la manière d'exécuter cette classe. */
	public static void afficherUsage() {
		System.out.println("\n" + "Usage :"
				+ "\n\t" + "java allumettes.Jouer [-confiant] joueur1 joueur2"
				+ "\n\t\t" + "joueur est de la forme nom@stratégie"
				+ "\n\t\t" + "strategie = naif | rapide | expert | humain | tricheur"
				+ "\n"
				+ "\n\t" + "Exemple :"
				+ "\n\t" + "	java allumettes.Jouer Xavier@humain "
					   + "Ordinateur@naif"
				+ "\n"
				);
	}

}

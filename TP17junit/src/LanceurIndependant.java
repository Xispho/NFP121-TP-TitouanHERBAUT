import java.lang.reflect.*;
import java.util.*;

/** L'objectif est de faire un lanceur simple sans utiliser toutes les clases
  * de notre architecture JUnit.   Il permet juste de valider la compréhension
  * de l'introspection en Java.
  */
public class LanceurIndependant {
	private int nbTestsLances;
	private int nbErreurs;
	private int nbEchecs;
	private List<Throwable> erreurs = new ArrayList<>();

	public LanceurIndependant(String... nomsClasses) {
	    System.out.println();

		// Lancer les tests pour chaque classe
		for (String nom : nomsClasses) {
			try {
				System.out.print(nom + " : ");
				this.testerUneClasse(nom);
				System.out.println();
			} catch (ClassNotFoundException e) {
				System.out.println(" Classe inconnue !");
			} catch (Exception e) {
				System.out.println(" Problème : " + e);
				e.printStackTrace();
			}
		}

		// Afficher les erreurs
		for (Throwable e : erreurs) {
			System.out.println();
			e.printStackTrace();
		}

		// Afficher un bilan
		System.out.println();
		System.out.printf("%d tests lancés dont %d échecs et %d erreurs.\n",
				nbTestsLances, nbEchecs, nbErreurs);
	}


	public int getNbTests() {
		return this.nbTestsLances;
	}


	public int getNbErreurs() {
		return this.nbErreurs;
	}


	public int getNbEchecs() {
		return this.nbEchecs;
	}


	private void testerUneClasse(String nomClasse)
            throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, InvocationTargetException {
		// Récupérer la classe
		Class<?> aClass = Class.forName(nomClasse);


		// Récupérer les méthodes "preparer" et "nettoyer"
		Method preparer = null;
		try {
			preparer = aClass.getMethod("preparer");
		} catch (NoSuchMethodException e) {
		}
		Method nettoyer = null;
		try {
			nettoyer = aClass.getMethod("nettoyer");
		} catch (NoSuchMethodException e) {
		}

		// Instancier l'objet qui sera le récepteur des tests
		Object objet = aClass.getConstructors()[0].newInstance();

		 // Récupérer les méthodes de test
		Method[] methodes = aClass.getMethods();

		// Exécuter les méthods de test
		for (Method m : methodes) {
			if (m.getName().startsWith("tester")) {
				this.nbTestsLances++;
				try {
					if (preparer != null) preparer.invoke(objet);
					m.invoke(objet);
					if (nettoyer != null) nettoyer.invoke(objet);
				} catch (InvocationTargetException e) {
					Throwable cause = e.getCause();
					if (cause instanceof Echec) {
						this.nbEchecs++;
					} else {
						this.nbErreurs++;
					}
					this.erreurs.add(cause);
				}
			}
		}
	}

	public static void main(String... args) {
		LanceurIndependant lanceur = new LanceurIndependant("MonnaieTest", "MonnaieTest2", "CasLimitesTest", "ErreurTest");
	}

}

package editeur.commande;

import editeur.Ligne;
import util.Console;

/** Ajouter un caractère à la fin de la ligne.
 * @author	Xavier Crégut
 * @version	1.4
 */
public class CommandeRAZ
	extends CommandeLigne
{

	/** Initialiser la ligne sur laquelle travaille
	 * cette commande.
	 * @param l la ligne
	 */
	//@ requires l != null;	// la ligne doit être définie
	public CommandeRAZ(Ligne l) {
		super(l);
	}

	public void executer() {
		super.ligne.raz();
	}

	public boolean estExecutable() {
		return ligne.getCurseur() > 1;
	}

}

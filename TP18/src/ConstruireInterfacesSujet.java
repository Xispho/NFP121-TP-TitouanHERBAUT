import org.jdom2.*;
import org.jdom2.output.*;

/** Construire l'exemple de fichier /etc/network/interfaces donné dans le sujet.
  *
  * @author	Xavier Crégut
  * @version	$Revision$
  */
public class ConstruireInterfacesSujet {

	public static void main(String[] args) throws java.io.IOException {
		// Construire le document
		Element racine = new Element("interfaces");

		// auto lo
		racine.addContent(getAuto("lo"));

		racine.addContent(getAuto("eth0", "eth1"));

		Document document = new Document(racine, new DocType("interfaces",
					"interfaces.dtd"));

		// Afficher le document
		XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
		sortie.output(document, System.out);
	}

	public static Element getAuto(String... noms) {
		Element auto = new Element("auto");
		for (String nom : noms) {
			Element name = new Element("name");
			auto.addContent(name);
			name.setAttribute("value", nom);
		}
		return auto;
	}

}

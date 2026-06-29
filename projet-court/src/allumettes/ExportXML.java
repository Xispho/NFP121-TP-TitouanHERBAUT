package allumettes;

import org.jdom2.DocType;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import java.io.FileOutputStream;
import java.io.IOException;

public final class ExportXML {

    public static void exportXML(Deroulement deroulement) {
        Element racine = new Element("deroulement");
        for (Deroulement.Coup coup : deroulement.getCoups()) {
            Element coupElement = new Element("coup");
            coupElement.setAttribute(
                    "numero",
                    deroulement.getCoups().indexOf(coup) + 1 + ""
            );
            coupElement.setAttribute("joueur", coup.getJoueur());
            coupElement.setAttribute(
                    "nbAllumette",
                    String.valueOf(coup.getNbAllumetteprise())
            );
            racine.addContent(coupElement);
        }
        Element endElement;
        String typeEndElement = "gagnant";
        String textEndElement = deroulement.getGagnant();
        if (!deroulement.getTricheur().isEmpty()) {
            typeEndElement = "tricheur";
            textEndElement = deroulement.getTricheur();
        }
        endElement = new Element(typeEndElement);
        endElement.setText(textEndElement);
        racine.addContent(endElement);

        Document document = new Document(racine, new DocType("deroulement",
                "deroulement.dtd"));

        XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
        try {
            FileOutputStream file = new FileOutputStream("./deroulement.xml");
            sortie.output(document, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

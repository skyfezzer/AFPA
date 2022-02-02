package fr.aragot.cdtheque;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class FichierXML2HTML extends FichierSortie {

	private Document dom;
	public FichierXML2HTML(String nom) {
		super(nom + ".html");
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			dom = builder.newDocument();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public FichierSortie ajoute(CD cd) {
		Element elem = dom.createElement("cd");
		elem.setAttribute("reference", cd.getReference());
		
		Element titre = dom.createElement("titre");
		titre.setTextContent(cd.getTitre());
		elem.appendChild(titre);
		Element auteur = dom.createElement("auteur");
		titre.setTextContent(cd.getAuteur());
		elem.appendChild(auteur);
		Element genre = dom.createElement("genre");
		titre.setTextContent(parseGenre(Integer.parseInt(cd.getGenre())));
		elem.appendChild(genre);
		
		return this;
	}
	@Override
	public void fermer() {

	}

}

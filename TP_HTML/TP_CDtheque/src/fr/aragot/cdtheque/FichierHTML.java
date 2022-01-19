package fr.aragot.cdtheque;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.TreeSet;

import javax.swing.JOptionPane;

public class FichierHTML extends FichierSortie {
	private TreeSet<CD> cds = new TreeSet<CD>();
	StringBuffer sb = new StringBuffer();
	public FichierHTML(String nom) {
		super(nom + ".html");
		sb.append("<!DOCTYPE html>");
		sb.append("<html>");
		sb.append("<head>");
		sb.append("    <meta charset='utf-8'>");
		sb.append("    <title>Médiathèque de Champs sur Marne</title>");
		sb.append("    <meta name='viewport' content='width=device-width, initial-scale=1'>");
		sb.append("    <style>");
		sb.append("        th {");
		sb.append("    background-color: #000080;");
		sb.append("    color: #FFFFFF;");
		sb.append("}");
		sb.append("td {");
		sb.append("    background-color: #BEBEBEFF;");
		sb.append("    color:#080648;");
		sb.append("}");
		sb.append("    </style>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("    <table style=\"width:100%;\">");
		sb.append("        <tr>");
		sb.append("            <th>Ref</th>");
		sb.append("            <th>Titre</th>");
		sb.append("            <th>Auteur</th>");
		sb.append("            <th>Genre</th>");
		sb.append("        </tr>");
	}

	public FichierHTML ajoute(CD cd) {
		this.cds.add(cd);
		return this;
	}
	
	public void fermer() {
		cds.stream().forEach(x->{
			sb.append(String.format("<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>",x.getReference(),x.getTitre(),x.getAuteur(),parseGenre(Integer.parseInt(x.getGenre()))));
		});
		sb.append("</table></body></html>");
		try {
			Files.writeString(Path.of(getNom()), sb.toString(), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Something wrong happened :\n" + e.getMessage());
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, getNom() + " a été créé avec succès.");
	}
	
	private String parseGenre(int genre) {
		String result;
		switch(genre) {
		case 0:
			result="Classique";
			break;
		case 1:
			result="Variété étrangère";
			break;
		case 2:
			result="Jazz";
			break;
		case 3:
			result="Variété française";
			break;
		case 4:
			result="Musique du monde";
			break;
		case 5:
			result="Divers";
			break;
		default:
				result="Inconnu";
		}
		return result;
	}
}

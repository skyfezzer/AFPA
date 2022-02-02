package fr.aragot.cdtheque;

public class FichierHTML extends FichierSortie {
	
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

	public void fermer() {
		cds.stream().forEach(x -> {
			sb.append(String.format("<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>", x.getReference(),
					x.getTitre(), x.getAuteur(), parseGenre(Integer.parseInt(x.getGenre()))));
		});
		sb.append("</table></body></html>");
		
		sauverFichier();
	}
}

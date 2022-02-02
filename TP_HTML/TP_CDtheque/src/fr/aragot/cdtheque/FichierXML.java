package fr.aragot.cdtheque;

public class FichierXML extends FichierSortie {

	public FichierXML(String nom) {
		super(nom + ".xml");
		sb.append("<?xml version=\"1.0\"?>");
		sb.append("<?xml-stylesheet type=\"text/xsl\" href=\"cdaudio.xsl\"?>");
		sb.append("<cdtheque>");
	}

	public void fermer() {
		cds.stream().forEach(x -> {
			sb.append(String.format("<cd reference=\"%s\">\n<titre>%s</titre>\n<auteur>%s</auteur>\n<genre>%s</genre>\n</cd>\n", x.getReference(),
					encodeSpecialChars(x.getTitre()), encodeSpecialChars(x.getAuteur()), parseGenre(Integer.parseInt(x.getGenre()))));
		});
		sb.append("</cdtheque>");
		
		sauverFichier();
	}
	
	private CharSequence encodeSpecialChars(CharSequence str) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<str.length();i++) {
			char curChar = str.charAt(i);
			switch(curChar) {
			case '&':
				sb.append("&amp;");
				break;
			case '<':
				sb.append("&lt;");
				break;
			case '>':
				sb.append("&gt;");
				break;
			case '"':
				sb.append("&quot;");
				break;
			case '/':
				sb.append("&apos;");
				break;
			default:
				sb.append(str.charAt(i));
			}
		}
		return sb.toString();
	}
}

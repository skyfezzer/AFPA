package fr.aragot.test;

import java.util.Locale;

public class ProprietesJVM {
	public static void main(String[] args) {
		String texte = "Bonjour " + System.getProperty("user.name");
		texte += "\n\u25cf Votre pays/lange est " + System.getProperty("user.country")
		//		+ "/" + System.getProperty("user.language");
				+ "/" + Locale.getDefault();
		texte += "\n\u25cf Votre dossier personnel est " + System.getProperty("user.home");
		
		texte += "\n\u25cf Votre dossier de travail est " + System.getProperty("user.dir");
		
		texte += "\n\t\u25aa Utilise le caract\u00e8re " + System.getProperty("file.separator")
				+ " Comme s\u00e9parateur de dossiers";
		
		texte += "\n\t\u25aa Utilise le caract\u00E8re " + System.getProperty("path.separator")
				+ " Comme s\u00e9parateur de fichiers";
		
		String separateur = System.getProperty("line.separator");
		if(separateur.length()>1) {
			texte += "\n\t\u25aa Utilise les caract\u00E8res de code ";
		}else {
			texte += "\n\t\u25aa Utilise le caract\u00E8re de code ";
		}
		
		for(int i = 0;i < separateur.length();i++) {
			switch(separateur.charAt(i)) {
			case '\r':
				texte += "\\r ";
				break;
			case '\n':
				texte += "\\n";
				break;
			}
		}
		texte += " pour le retour \u00e0 la ligne";
		
		texte += "\n\u25cf Votre JVM de version " + System.getProperty("java.version") + " : ";
		
		texte += "\n\t\u25aa Est install\u00e9 dans le dossier " + System.getProperty("java.home");
		 
		texte += "\n\t\u25aa Utilise le classpath " + System.getProperty("java.class.path");
		
		texte += "\n\t\u25aa Est d\u00E9velopp\u00E9 par " + System.getProperty("java.vendor");
		
		texte += " et disponible \u00E0 " + System.getProperty("java.vendor.url");
		
		System.out.println(texte);
		javax.swing.JOptionPane.showMessageDialog(null, texte);
	}
	
}

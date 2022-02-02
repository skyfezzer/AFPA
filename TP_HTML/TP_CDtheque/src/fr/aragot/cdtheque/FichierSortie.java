package fr.aragot.cdtheque;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.TreeSet;

import javax.swing.JOptionPane;

public abstract class FichierSortie {
	private String nom;
	protected StringBuffer sb;
	protected TreeSet<CD> cds = new TreeSet<CD>();

	public FichierSortie(String nom) {
		this.setNom(nom);
		sb = new StringBuffer();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public FichierSortie ajoute(CD item) {
		this.cds.add(item);
		return this;
	}
	
	protected void sauverFichier() {
		try {
			Files.writeString(Path.of(getNom()), sb.toString(), StandardOpenOption.CREATE, StandardOpenOption.WRITE,
					StandardOpenOption.TRUNCATE_EXISTING);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Something wrong happened :\n" + e.getMessage());
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, getNom() + " a été créé avec succès.");
	}

	public abstract void fermer();

	protected String parseGenre(int genre) {
		String result;
		switch (genre) {
		case 0:
			result = "Classique";
			break;
		case 1:
			result = "Variété étrangère";
			break;
		case 2:
			result = "Jazz";
			break;
		case 3:
			result = "Variété française";
			break;
		case 4:
			result = "Musique du monde";
			break;
		case 5:
			result = "Divers";
			break;
		default:
			result = "Inconnu";
		}
		return result;
	}
}

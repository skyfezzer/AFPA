package fr.aragot.cdtheque;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FichierCSV {

	private String nom;
	BufferedReader br = null;

	public FichierCSV(String nom) {
		this.setNom(nom);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public CD obtenir() throws IOException {
		if (br == null) {
			br = Files.newBufferedReader(Path.of(nom), StandardCharsets.ISO_8859_1);
		}
		if (br.ready()) {
			String[] currentLine = br.readLine().split(";");
			return new CD(currentLine[0], currentLine[1], currentLine[2], currentLine[3]);
		} else {
			br.close();
		}
		return null;
	}

}

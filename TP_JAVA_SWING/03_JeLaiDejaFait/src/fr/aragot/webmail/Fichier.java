package fr.aragot.webmail;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Vector;

public class Fichier {
	private String nom;
	public Fichier(String nom) {
		this.setNom(nom);
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public Vector<String> getLignes(){
		return null;
	}
	
	public String getContenu() {
		StringBuffer sb = new StringBuffer();
		try (FileReader fr = new FileReader(nom);BufferedReader br = new BufferedReader(fr)){
			String line = null;
			while((line = br.readLine()) != null) {
				sb.append(line+System.lineSeparator());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sb.toString();
	}
	
	public void setContenu(String contenu) throws IOException {
		Path path = Paths.get("./msg/"+nom+".msg");
		byte[] text = contenu.getBytes();
		Files.write(path, text, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
	}
}

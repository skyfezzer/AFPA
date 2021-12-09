package fr.aragot.util;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;

public class AfficheFichiersProjet {

	public static void main(String[] args) {
		Path ici = Path.of("C:/users");
		afficheEnProfondeur(ici);
	}
	
	private static void afficheEnProfondeur(Path dossier) {
		afficheEnProfondeur(dossier,0);
	}
	private static void afficheEnProfondeur(Path dossier, int profondeur){
		try {
			DirectoryStream<Path> streamDossier = Files.newDirectoryStream(dossier);
			Iterator<Path> it = streamDossier.iterator();
			while(it.hasNext()) {
				Path currentPath = it.next();
				StringBuilder sb = new StringBuilder();
				for(int i = 0;i<profondeur;i++) {
					sb.append(" | ");
				}
				if(Files.isDirectory(currentPath)){
					sb.append("["+currentPath+"]");
					System.out.println(sb.toString());
					afficheEnProfondeur(currentPath,profondeur+1);
				}else {
					
					sb.append(currentPath);
					System.out.println(sb.toString());
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

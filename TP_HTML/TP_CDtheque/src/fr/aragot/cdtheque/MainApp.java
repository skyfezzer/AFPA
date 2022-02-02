package fr.aragot.cdtheque;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

public class MainApp {
	public static void main(String[] args) {
		JFileChooser jfc = new JFileChooser();
		jfc.setDialogTitle("Séléctionner le fichier CSV Source :");
		int returnValue = jfc.showOpenDialog(null);
		// int returnValue = jfc.showSaveDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jfc.getSelectedFile();
			//FichierSortie<CD> html = new FichierHTML("cdaudio");
			FichierSortie xml = new FichierXML("cdaudio");
			FichierCSV csv = new FichierCSV(selectedFile.getAbsolutePath());
			CD currentCd;
			try {
				while((currentCd = csv.obtenir()) != null) {
					xml.ajoute(currentCd);
				}
				xml.fermer();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		

	}
}

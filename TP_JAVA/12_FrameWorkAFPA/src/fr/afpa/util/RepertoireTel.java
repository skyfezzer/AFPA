package fr.afpa.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

public class RepertoireTel {

	private static final String FICHIER_SAUV = "save.bin";
	
	static Map<String,String> repertoire;
	public static void main(String[] args) {
		load();
		//repertoire = new TreeMap<>();
		//repertoire = new HashMap<>();
		//repertoire.put("Paul", "0175490448");
		//repertoire.put("Mohamed", "0917813199");
		//repertoire.put("Gunter", "0751118105");

		repertoire.forEach((k,v) -> System.out.println(k + " : " + v));
		save();
		
	}
	
	
	private static void save() {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(FICHIER_SAUV);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(repertoire);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(oos != null) {
					oos.flush();
					oos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	@SuppressWarnings("unchecked")
	private static void load() {
		if(!Files.exists(Paths.get(FICHIER_SAUV)   ) ) {
			return;
		}
		
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(FICHIER_SAUV);
			ois = new ObjectInputStream(fis);
			repertoire = (TreeMap<String,String>) ois.readObject();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(ois != null) {
					ois.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

}

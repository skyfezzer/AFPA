package biblio.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JOptionPane;
import biblio.dao.AdherentDAO;
import biblio.dao.ConnectionFactory;
import biblio.domain.Adherent;

public class MonApp {
	private String driver,url,user,password;
	private Connection cnx = null;
	public static void main(String[] args) {
		MonApp app = new MonApp();
		app.loadProperties();
		app.start();
	}
	
	private void start() {
		ConnectionFactory cf = new ConnectionFactory();
		try {
			cnx = cf.getConnection(driver, url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AdherentDAO adherentDAO = new AdherentDAO(cnx);
		System.out.println("\n\n==========\n\n");
		
		Adherent testAdherent = new Adherent(1000,null,null,"fakeTel","fakePin");
		try {
			System.out.println("INSERT ADHERENT : " + adherentDAO.insertAdherent(testAdherent));
			System.out.println("SELECT ADHERENT : " + adherentDAO.findAdherentByKey(1000));
			System.out.println("DELETE ADHERENT : " + adherentDAO.deleteAdherent(testAdherent));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void loadProperties() {
		try (InputStream input = MonApp.class.getClassLoader().getResourceAsStream("jdbc.properties")) {

			Properties prop = new Properties();

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			user = prop.getProperty("user");
			if ((password = prop.getProperty("pwd")) == null) {
				password = JOptionPane.showInputDialog("Mot de passe JDBC pour le user " + user + " :");
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	
}

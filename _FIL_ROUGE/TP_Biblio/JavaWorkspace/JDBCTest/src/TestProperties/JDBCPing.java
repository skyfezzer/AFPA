package TestProperties;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.JOptionPane;

public class JDBCPing {
	private boolean loaded = false;
	private String driver, url, user, password;

	private void loadProperties() {
		try (InputStream input = JDBCPing.class.getClassLoader().getResourceAsStream("jdbc.properties")) {

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
			loaded = true;
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public void ping() {
		if (!loaded) {
			System.out.println("Besoin de charger fichier properties avant de pinger la base de données...");
			this.loadProperties();
		}

		// Charger la première classe du driver//charge le driver
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("Pb driver non trouvé :" + e.getMessage());
			System.exit(1);
		}

		try (Connection cnx = DriverManager.getConnection(url, user, password)) {

			try (Statement stmt = cnx.createStatement()) {
				cnx.setAutoCommit(false);
				try (ResultSet rs = stmt.executeQuery("select * from dept")) {
					while (rs.next())
						System.out.println("DEPTNO :" + rs.getInt("DEPTNO") + " DNAME :" + rs.getString("DNAME")
								+ "  LOC :" + rs.getString("LOC"));

					cnx.rollback();

				} catch (SQLException e) {
					System.out.println("Pb jdbc avec executeQuery:" + e.getMessage());
					// e.printStackTrace();
				}

			} catch (SQLException e) {
				System.out.println("Pb jdbc avec createStatement()" + e.getMessage());
				// e.printStackTrace();
			}

		} catch (SQLException e) {
			System.out.println("Pb à la connexion :" + e.getMessage());
			// e.printStackTrace();
			System.exit(2);
		}

	}

	public static void main(String[] args) {
		JDBCPing bean = new JDBCPing();
		bean.ping();
	}
}

package biblio.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.JOptionPane;

public class ChargerPropertiesController {
	private Properties properties;
    private String propertiesFileName;
    private String driver = "", url = "", user = "", password = "";
    public ChargerPropertiesController(String propertiesFileName) {
        this.propertiesFileName = propertiesFileName;
    }

    public boolean chargerProperties() throws IOException {
        Properties prop = new Properties();
		InputStream input = MonApp.class.getClassLoader().getResourceAsStream(propertiesFileName);
		if(input == null) {
			JOptionPane.showMessageDialog(null, "Cannot load the properties file", "Error", JOptionPane.ERROR_MESSAGE);
			throw new IOException("Cannot load the properties file");
		}
		// load a properties file
		prop.load(input);
		this.properties = prop;

		// get the property values
		this.driver = prop.getProperty("driver");
		this.url = prop.getProperty("url");
		this.user = prop.getProperty("user");
		if ((password = prop.getProperty("pwd")) == null) {
			password = JOptionPane.showInputDialog("Mot de passe JDBC pour le user " + user + " :");
		}
		
        return true;
	}

	// getters and setters
	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPropertiesFileName() {
		return propertiesFileName;
	}

	public void setPropertiesFileName(String propertiesFileName) {
		this.propertiesFileName = propertiesFileName;
	}

	public Properties getProperties() {
		return properties;
	}


}
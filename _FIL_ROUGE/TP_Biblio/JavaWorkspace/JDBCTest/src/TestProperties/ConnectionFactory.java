package TestProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private Connection cnx;
	public Connection getConnection (String nomPilote, String URL_BD,String authorizationID, String password) throws SQLException, ClassNotFoundException {
		if(cnx == null) {
			Class.forName(nomPilote);
			cnx = DriverManager.getConnection(URL_BD,authorizationID,password);
		}
		cnx.setAutoCommit(true);
		return cnx;
	}
	
	public Connection getConnectionSansAutoCommit(String nomPilote, String URL_BD,String authorizationID, String password) throws SQLException, ClassNotFoundException {
		Connection result = getConnection(nomPilote,URL_BD,authorizationID,password);
		result.setAutoCommit(false);
		return result;
		
	}
}

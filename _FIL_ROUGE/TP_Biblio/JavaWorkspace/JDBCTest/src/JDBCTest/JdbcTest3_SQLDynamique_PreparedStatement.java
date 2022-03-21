package JDBCTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import javax.swing.JOptionPane;

public class JdbcTest3_SQLDynamique_PreparedStatement {
public static void main(String[] args)  {
	
// Charger la première classe du driver//charger le driver
try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
} catch (ClassNotFoundException ex) {
	System.out.println("Driver non présent dans le CLASSPATH  -  " + ex.getMessage());
	System.exit(1);
}

//Ouvrir une connexion dite "réseau"  ( vs DataSource)
Connection cnx = null;
try {
	cnx = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xepdb1", "scott", "scott");
} catch (SQLException ex) {
	System.out.println("Pb pour atteindre la BD  -  " + ex.getMessage());
	System.exit(2);
}

Statement stmt = null;
ResultSet rs = null;
try {
	String requete;//Chaîne dans laquelle on assemble notre requête
	String noDept = null;
	String ville = null;
	int nbLignesImpactees;
	
	//On souhaite faire une transaction
	cnx.setAutoCommit(false);

	//Creation d'un énoncé
	stmt = cnx.createStatement();

	System.out.println();
	System.out.println("---------------------------------------------");
	System.out.println("---SQL DYNAMIQUE AVEC UN STATEMENT-----------");
	System.out.println("---------------------------------------------");
	System.out.println("--ON INSERE le département La PRODUCTION ----");

	
	//On saisit une information de type NUMBER(2,0) dans la BDD Oracle scott (INTEGER dans une BD SQL-ANSI)
	//noDept = JOptionPane.showInputDialog("Entrez le numéro du nouveau département PRODUCTION :");
	noDept = "77";  //en dur
	//noDept = "77 or 1=1";  //en dur
	//where noDept = 77 or 1=1
	
	//noDept = "azerty";//risque
	//risque :java.sql.SQLException: ORA-00984: Un nom de colonne n'est pas autorisé ici

	//On saisit une information de type VARCHAR2(14) dans la BDD Oracle scott  (VARCHAR(14) dans une BD SQL-ANSI)
	//String ville = JOptionPane.showInputDialog("Entrez la ville du nouveau département PRODUCTION :");
	ville = "Champs"; //en dur
	
	//On construit la requête avec les deux infos saisies
	// avec le langage SQL-Escape de JDBC (proche de SQL)
	//(SQL  dynamique)
	requete = "INSERT INTO dept (deptno, dname, loc) "
			+ "VALUES ("+ noDept +", 'PRODUCTION',"
			+ "'" + ville + "')";
			
			
	System.out.println("TRACE: Valeur de ma requete: " + requete );
	
	
	nbLignesImpactees = stmt.executeUpdate(requete);
	//risque :java.sql.SQLException: ORA-00984: Un nom de colonne n'est pas autorisé ici
	
	System.out.println("Nombre de lignes insérées :" + nbLignesImpactees);

	
	System.out.println();
	System.out.println("Vérification du contenu de la table dept :");
	System.out.println("-----------------------------------------");
	rs = stmt.executeQuery("SELECT DEPTNO, DNAME, LOC FROM DEPT");
	while(rs.next()){
		System.out.println("DEPTNO :"+ rs.getInt("DEPTNO")+"   DNAME :" + rs.getString("DNAME")+"   LOC :" +rs.getString(3));
	}

	System.out.println();
	System.out.println("--------------------------------------------------------------------------");
	System.out.println("------Mieux que le SQL-DYNAMIQUE : UN PREPAREDSTATEMENT dans le driver ---");
	System.out.println("--------------------------------------------------------------------------");
	System.out.println("----------------ON INSERE le département La DIRECTION --------------------");

	//noDept = JOptionPane.showInputDialog("Entrez le numéro du nouveau département DIRECTION :");
	noDept = "90";
	//noDept = "azerty";//risque
	//java.sql.SQLException: ORA-01722: Nombre non valide

	//String ville = JOptionPane.showInputDialog("Entrez la ville du nouveau département DIRECTION :");
	ville = "Londres";
	
	//Utilisation d'un PreparedStatement
	// Attention, ça n'est pas tout à fait du SQL. C'est un langage SQL-escape de JDBC
	///////////////////////////////////
	PreparedStatement pstmt =
cnx.prepareStatement("INSERT INTO DEPT (DEPTNO, DNAME, LOC) VALUES(?, 'DIRECTION', ?)");
	
	//pstmt.setString(1, noDept); //risque : java.sql.SQLException: ORA-01722: Nombre non valide
	
	//A faire: au niveau du logiciel client, contrôlez des données saisies
	int intNoDept = Integer.parseInt(noDept); // risque: java.lang.NumberFormatException
	pstmt.setInt(1, intNoDept); //risque : aucun risque !!
	
	pstmt.setString(2, ville );
	
	nbLignesImpactees = pstmt.executeUpdate();
	
	System.out.println("Nombre de lignes insérées :" + nbLignesImpactees);
	
	System.out.println();
	System.out.println("On vérifie la présence de la table ligne dans dept :");
	System.out.println("----------------------------------------------------");
	
	rs.close();
	rs = stmt.executeQuery("select DEPTNO, DNAME, LOC from  DEPT where dname = 'DIRECTION'");
	while(rs.next()){
		System.out.println("DEPTNO :"+ rs.getInt("DEPTNO")+"   DNAME :" + rs.getString("DNAME")+"   LOC :" +rs.getString(3));
	}

	
	System.out.println("\nOn rembobine car c'est un test");
	cnx.rollback();

	
	System.out.println("\nDernière instruction du try");	
} catch (SQLException ex) {
	ex.printStackTrace();
	//System.out.println("Erreur SQLException: " + e.getMessage());
}
finally {
	//libération des ressources
	///////////////////////////
	if( rs != null) {
		try {
			rs.close();
		} catch (SQLException e) {
			System.out.println("Erreur sur fermeture rs SQLException: " + e.getMessage());
		}
	}
	if( stmt != null) {
		try {
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Erreur sur fermeture stmt SQLException: " + e.getMessage());
		}
	}
	if( cnx != null) {
		try {
			cnx.close();
		} catch (SQLException e) {
			System.out.println("Erreur sur fermeture cnx SQLException: " + e.getMessage());
		}
	}
}}}

package JDBCTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest2_Departement_tryCatchFinally {
	public static void main(String[] args) {

// Charger la première classe du driver
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver non présent dans le CLASSPATH  -  " + e.getMessage());
			System.exit(1);
		}

//Ouvrir une connexion dite "réseau"  ( vs DataSource)
		Connection cnx = null;
		try {
			cnx = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xepdb1", "scott", "scott");
		} catch (SQLException e1) {
			System.out.println("Pb pour atteindre la BD  -  " + e1.getMessage());
			System.exit(2);
		}

		Statement stmt = null;
		ResultSet rs = null;
		try {
			// On souhaite faire une transaction
			cnx.setAutoCommit(false);

			// Insertion d'une ligne dans la table DEPT
			///////////////////////////////////////
			// à la cnx, on demande un statement
			stmt = cnx.createStatement();

			int nbLignesImpactees = stmt
					.executeUpdate("INSERT INTO DEPT(DEPTNO, DNAME, LOC) VALUES (51, 'FORMATION', 'Montreuil')");

			System.out.println("Retour de l'executeUpdate :" + nbLignesImpactees);
			System.out.println();

			// Affichage du contenu de la table DEPT
			///////////////////////////////////////
			rs = stmt.executeQuery("SELECT DEPTNO, DNAME, LOC FROM DEPT");

//		rs.next(); //ne pas oublier le premier next
//		System.out.println("DEPTNO :"+ rs.getInt("DEPTNO")+" DNAME :" + rs.getString("DNAME")+" LOC :" +rs.getString(3));
//		rs.next();
//		System.out.println("DEPTNO :"+ rs.getString(1)+" DNAME :" + rs.getString("DNAME")+" LOC :" +rs.getString(3));
//		
			// mieux
			while (rs.next()) {
				System.out.println("DEPTNO :" + rs.getInt("DEPTNO") + " DNAME :" + rs.getString("DNAME") + " LOC :"
						+ rs.getString(3));
			}

			System.out.println("\nOn rembobine car c'est un test");
			cnx.rollback();

		} catch (SQLException e) {
			System.out.println("Pb JDBC  -  " + e.getMessage());
		} finally {
			// libération des ressources prises
			//////////////////////////////////
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					System.out.println("Pb sur la fermeture du resultSet  : " + e.getMessage());
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					System.out.println("Pb sur la fermeture du statement  : " + e.getMessage());
				}
			if (cnx != null)
				try {
					cnx.close();
				} catch (SQLException e) {
					System.out.println("Pb sur la fermeture de la connexion  : " + e.getMessage());
				}
		}
	}
}

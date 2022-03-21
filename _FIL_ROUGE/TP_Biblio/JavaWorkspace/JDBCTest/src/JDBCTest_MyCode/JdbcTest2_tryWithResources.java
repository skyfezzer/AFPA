package JDBCTest_MyCode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest2_tryWithResources {
	public static void main(String[] args) {

// Charger la première classe du driver
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver non présent dans le CLASSPATH  -  " + e.getMessage());
			System.exit(1);
		}

//Ouvrir une connexion dite "réseau"  ( vs DataSource)
		try (Connection cnx = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xepdb1", "scott",
				"scott")) {
			try (Statement stmt = cnx.createStatement();) {
				// On souhaite faire une transaction
				cnx.setAutoCommit(false);

				// Insertion d'une ligne dans la table DEPT
				///////////////////////////////////////
				// à la cnx, on demande un statement

				int nbLignesImpactees = stmt
						.executeUpdate("INSERT INTO DEPT(DEPTNO, DNAME, LOC) VALUES (51, 'FORMATION', 'Montreuil')");

				System.out.println("Retour de l'executeUpdate :" + nbLignesImpactees);
				System.out.println();
				try (ResultSet rs = stmt.executeQuery("SELECT DEPTNO, DNAME, LOC FROM DEPT")) {
					while (rs.next()) {
						System.out.println("DEPTNO :" + rs.getInt("DEPTNO") + " DNAME :" + rs.getString("DNAME")
								+ " LOC :" + rs.getString(3));
					}

					System.out.println("\nOn rembobine car c'est un test");
					cnx.rollback();

				} catch (SQLException e) {
					System.out.println("Pb JDBC  -  " + e.getMessage());
				}
			} catch (SQLException e) {
				System.out.println("Pb jdbc avec createStatement()" + e.getMessage());
				// e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.println("Pb pour atteindre la BD  -  " + e1.getMessage());
			System.exit(2);
		}
	}
}

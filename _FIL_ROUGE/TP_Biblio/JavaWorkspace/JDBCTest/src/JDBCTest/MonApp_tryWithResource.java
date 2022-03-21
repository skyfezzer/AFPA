package JDBCTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MonApp_tryWithResource {
	public static void main(String[] args) {
		new java.sql.Time(System.currentTimeMillis());
		new java.sql.Timestamp(System.currentTimeMillis());
// Charger la première classe du driver//charge le driver
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Pb driver non trouvé :" + e.getMessage());
			System.exit(1);
		}

//Ouvrir une connexion réseau
//Connection cnx;  //non : il faut l'initialiser !!

//Connection cnx = null;
		try (Connection cnx = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xepdb1", "scott",
				"scott")) {
			// Connection cnx; // non :visible que dans ce bloc
			// cnx = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xepdb1",
			// "scott", "scott");

			// Statement stmt = cnx.createStatement();
			try (Statement stmt = cnx.createStatement()) {

				// On souhaite faire une transaction
				cnx.setAutoCommit(false);

				// à la cnx, on demande un statement
				// Statement stmt = cnx.createStatement();

				/*
				 * CREATE TABLE "SCOTT"."DEPT" ( "DEPTNO" NUMBER(2,0), "DNAME" VARCHAR2(14
				 * BYTE), "LOC" VARCHAR2(13 BYTE), ...
				 */
				// ResultSet rs = stmt.executeQuery("select * from dept");
				try (ResultSet rs = stmt.executeQuery("select * from dept")) {

					// la première ligne ?
					if (rs.next())
						System.out.println("DEPTNO :" + rs.getInt("DEPTNO") + " DNAME :" + rs.getString("DNAME")
								+ "  LOC :" + rs.getString("LOC"));
					else
						System.out.println("ResultSet VIDE");

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
}

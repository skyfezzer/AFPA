package JDBCTest_MyCode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest1_Statement_ResultSet {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.err.println("Librairie JDBC manquante. Vérifier librairies.");
			System.exit(1);
		}
		Connection cnx = null;
		try {
			cnx = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xepdb1","scott","scott");
			
		} catch (SQLException e) {
			System.err.println("Impossible de joindre la base de données.");
			System.exit(2);
		}
		Statement stmt = null;
		ResultSet rs = null;
		try {
			cnx.setAutoCommit(false);
			stmt = cnx.createStatement();
			int nbLignesImpactees = stmt.executeUpdate("INSERT INTO DEPT(DEPTNO, DNAME, LOC) VALUES (50, 'FORMATION', 'Montreuil')");
			System.out.println("Retour de l'executeUpdate :" + nbLignesImpactees);
			rs = stmt.executeQuery("SELECT DEPTNO, DNAME, LOC FROM DEPT");
			
			while(rs.next()) {
				System.out.println("DEPTNO: " + rs.getInt("DEPTNO") + " DNAME: " + rs.getString("DNAME") + " LOC: " + rs.getString(3));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("Rembobinage car c'est un test.");
		try {
			cnx.rollback();
			cnx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package biblio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import biblio.domain.Adherent;

// main DAO class to access data from Adherent table
public class AdherentDAO {
	private Connection cnx = null;

	public AdherentDAO(Connection cnx) {
		this.setCnx(cnx);
	}

	/**
	 * @return the cnx
	 */
	public Connection getCnx() {
		return cnx;
	}

	/**
	 * @param cnx the cnx to set
	 */
	public void setCnx(Connection cnx) {
		this.cnx = cnx;
	}

	/*
	 * ====================== = METHUDES CRUD = ======================
	 */
	public Adherent findAdherentByKey(int noPersonne) throws SQLException {
		Adherent result = null;
		ResultSet rs = null;
		String req = "SELECT * FROM ADHERENT A " + "LEFT OUTER JOIN UTILISATEUR U ON U.NOPERSONNE = A.NOPERSONNE "
				+ "WHERE A.NOPERSONNE = ?";
		PreparedStatement pstmt = cnx.prepareStatement(req);
		pstmt.setInt(1, noPersonne);

		if (pstmt.execute()) {
			rs = pstmt.getResultSet();
			if (rs.next()) {
				if (rs.getInt("employe") == 1) {
					return null;
				}
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String noTelAdherent = rs.getString("noTelAdherent");
				String pin = rs.getString("pin");
				result = new Adherent(noPersonne, nom, prenom, noTelAdherent, pin);
			}
		}
		return result;
	}

	// function that returns a List of all Adherents from Adherent table
	public Collection<Adherent> findAllAdherents() throws SQLException {
		Collection<Adherent> result = new ArrayList<Adherent>();
		ResultSet rs = null;
		String req = "SELECT * FROM ADHERENT A " + "LEFT OUTER JOIN UTILISATEUR U ON U.NOPERSONNE = A.NOPERSONNE "
				+ "WHERE U.EMPLOYE = 0";
		PreparedStatement pstmt = cnx.prepareStatement(req);

		if (pstmt.execute()) {
			rs = pstmt.getResultSet();
			while (rs.next()) {
				if (rs.getInt("employe") == 1) {
					continue;
				}
				int noPersonne = rs.getInt("noPersonne");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String noTelAdherent = rs.getString("noTelAdherent");
				String pin = rs.getString("pin");
				result.add(new Adherent(noPersonne, nom, prenom, noTelAdherent, pin));
			}
		}
		return result;
	}

	// function to insert a new Adherent in the database
	public boolean insertAdherent(Adherent adherent) throws SQLException {
		String req = "INSERT INTO UTILISATEUR (NOPERSONNE, NOM, PRENOM) VALUES (?, ?, ?)";
		PreparedStatement pstmt = cnx.prepareStatement(req);
		pstmt.setInt(1, adherent.getNoPersonne());
		pstmt.setString(2, adherent.getNom());
		pstmt.setString(3, adherent.getPrenom());
		boolean executed = pstmt.executeUpdate() > 0;
		pstmt.close();
		if (!executed) {
			return false;
		}
		req = "INSERT INTO ADHERENT (NOPERSONNE, NOTELADHERENT, PIN) VALUES (?, ?, ?)";
		pstmt = cnx.prepareStatement(req);
		pstmt.setInt(1, adherent.getNoPersonne());
		pstmt.setString(2, adherent.getNoTelAdherent());
		pstmt.setString(3, adherent.getPin());
		pstmt.executeUpdate();
		executed = pstmt.executeUpdate() > 0;
		pstmt.close();
		return executed;

	}

	// function to update an existing Adherent in the database
	public boolean updateAdherent(Adherent adherent) throws SQLException {
		String req = "UPDATE UTILISATEUR SET NOM = ?, PRENOM = ? WHERE NOPERSONNE = ?";
		PreparedStatement pstmt = cnx.prepareStatement(req);
		pstmt.setString(1, adherent.getNom());
		pstmt.setString(2, adherent.getPrenom());
		pstmt.setInt(3, adherent.getNoPersonne());
		boolean executed = pstmt.executeUpdate() > 0;
		pstmt.close();
		if (!executed) {
			return false;
		}
		req = "UPDATE ADHERENT SET NOTELADHERENT = ?, PIN = ? WHERE NOPERSONNE = ?";
		pstmt = cnx.prepareStatement(req);
		pstmt.setString(1, adherent.getNoTelAdherent());
		pstmt.setString(2, adherent.getPin());
		pstmt.setInt(3, adherent.getNoPersonne());
		executed = pstmt.executeUpdate() > 0;
		pstmt.close();
		return executed;
	}

	// function to delete an existing Adherent from adherent table
	public boolean deleteAdherent(int noPersonne) throws SQLException {
		String req = "DELETE FROM ADHERENT WHERE NOPERSONNE = ?";
		PreparedStatement pstmt = cnx.prepareStatement(req);
		pstmt.setInt(1, noPersonne);
		boolean executed = pstmt.executeUpdate() > 0;
		pstmt.close();
		if (!executed) {
			return executed;
		}
		req = "DELETE FROM UTILISATEUR WHERE NOPERSONNE = ?";
		pstmt = cnx.prepareStatement(req);
		pstmt.setInt(1, noPersonne);
		executed = pstmt.executeUpdate() > 0;
		pstmt.close();
		return executed;
	}

}
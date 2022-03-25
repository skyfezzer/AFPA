/***********************************************************************
 * Module:  UtilisateurDAO.java
 * Author:  Sk
 * Purpose: Defines the Class UtilisateurDAO
 ***********************************************************************/

package biblio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import biblio.domain.Utilisateur;
import biblio.domain.Adherent;
import biblio.domain.Employe;

/** @pdOid 182fef41-734d-4d62-80ed-0888f633123a */
public class UtilisateurDAO {
	private Connection cnx = null;

	public UtilisateurDAO(Connection cnx) {
		super();
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
	public Utilisateur findByKey(Integer noUtilisateur) throws SQLException {
		Utilisateur result = null;
		ResultSet rs = null;
		String req = "SELECT * FROM UTILISATEUR U " + "LEFT OUTER JOIN EMPLOYE E ON E.NOPERSONNE = U.NOPERSONNE "
				+ "LEFT OUTER JOIN ADHERENT A ON A.NOPERSONNE = U.NOPERSONNE " + "WHERE U.NOPERSONNE = ?";
		PreparedStatement pstmt = cnx.prepareStatement(req);
		pstmt.setInt(1, noUtilisateur);

		if (pstmt.execute()) {
			rs = pstmt.getResultSet();
			if (rs.next()) {
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				boolean isEmploye = rs.getShort("employe") == (short) 1;
				if (isEmploye) {
					result = new Employe(noUtilisateur, nom, prenom, rs.getString("gradeEmploye"), null);
				} else {
					result = new Adherent(noUtilisateur, nom, prenom, rs.getString("noTelAdherent"),
							rs.getString("PIN"));
				}

			}
		}
		rs.close();
		pstmt.close();

		return result;
	}

	public Collection<Utilisateur> findAll() throws SQLException {
		Collection<Utilisateur> result = null;
		String req = "SELECT * FROM UTILISATEUR U " + "LEFT OUTER JOIN EMPLOYE E ON E.NOPERSONNE = U.NOPERSONNE "
				+ "LEFT OUTER JOIN ADHERENT A ON A.NOPERSONNE = U.NOPERSONNE ";
		Statement stmt = cnx.createStatement();
		ResultSet rs = stmt.executeQuery(req);
		while (rs.next()) {
			if (result == null) {
				result = new ArrayList<Utilisateur>();
			}
			Utilisateur utilisateur = null;
			String nom = rs.getString("nom");
			String prenom = rs.getString("prenom");
			boolean isEmploye = rs.getInt("employe") == 1;
			if (isEmploye) {
				utilisateur = new Employe(rs.getInt("noPersonne"), nom, prenom, rs.getString("gradeEmploye"), null);
			} else {
				utilisateur = new Adherent(rs.getInt("noPersonne"), nom, prenom, rs.getString("noTelAdherent"),
						rs.getString("PIN"));
			}
			result.add(utilisateur);
		}

		return result;
	}

	// insert the Utilisateur superclass data into the database.
	public boolean insert(Utilisateur utilisateur) throws SQLException {
		String req = "INSERT INTO UTILISATEUR (NOPERSONNE, NOM, PRENOM, EMPLOYE) VALUES (?, ?, ?, ?)";
		PreparedStatement pstmt = cnx.prepareStatement(req);
		pstmt.setInt(1, utilisateur.getNoPersonne());
		pstmt.setString(2, utilisateur.getNom());
		pstmt.setString(3, utilisateur.getPrenom());
		pstmt.setNull(4, java.sql.Types.SMALLINT);
		if(utilisateur.getEmploye() != null) {
			pstmt.setShort(4, utilisateur.getEmploye());
		}
		boolean executed = pstmt.executeUpdate() > 0;
		pstmt.close();
		if (executed) {
			// insert the Adherent data into the database.
			if (utilisateur instanceof Adherent) {
				Adherent adherent = (Adherent) utilisateur;
				req = "INSERT INTO ADHERENT (NOPERSONNE, NOTELADHERENT, PIN) VALUES (?, ?, ?)";
				pstmt = cnx.prepareStatement(req);
				pstmt.setInt(1, adherent.getNoPersonne());
				pstmt.setString(2, adherent.getNoTelAdherent());
				pstmt.setString(3, adherent.getPin());
				executed = pstmt.executeUpdate() > 0;
				pstmt.close();
			} else {
				Employe employe = (Employe) utilisateur;
				req = "INSERT INTO EMPLOYE (NOPERSONNE, NOBIBLIOTHEQUE, GRADEEMPLOYE) VALUES (?, ?)";
				pstmt = cnx.prepareStatement(req);
				pstmt.setInt(1, employe.getNoPersonne());
				pstmt.setInt(2, employe.getBiblio().getNoBibliotheque());
				pstmt.setString(3, employe.getGradeEmploye());
				executed = pstmt.executeUpdate() > 0;
				pstmt.close();
			}

		}
		return executed;
	}

	// update the Utilisateur superclass data into the database using his primary
	// key.
	public boolean update(Utilisateur utilisateur) throws SQLException {
		String req = "UPDATE UTILISATEUR SET NOM = ?, PRENOM = ?, EMPLOYE = ? WHERE NOPERSONNE = ?";
		PreparedStatement pstmt = cnx.prepareStatement(req);
		pstmt.setString(1, utilisateur.getNom());
		pstmt.setString(2, utilisateur.getPrenom());
		pstmt.setInt(3, utilisateur.getEmploye());
		pstmt.setInt(4, utilisateur.getNoPersonne());
		boolean result = pstmt.executeUpdate() > 0;
		pstmt.close();
		if (result) {
			// update the Adherent data into the database.
			if (utilisateur instanceof Adherent) {
				Adherent adherent = (Adherent) utilisateur;
				req = "UPDATE ADHERENT SET NOTELADHERENT = ?, PIN = ? WHERE NOPERSONNE = ?";
				pstmt = cnx.prepareStatement(req);
				pstmt.setString(1, adherent.getNoTelAdherent());
				pstmt.setString(2, adherent.getPin());
				pstmt.setInt(3, adherent.getNoPersonne());
				result = pstmt.executeUpdate() > 0;
				pstmt.close();
			} else {
				Employe employe = (Employe) utilisateur;
				req = "UPDATE EMPLOYE SET NOBIBLIOTHEQUE = ?, GRADEEMPLOYE = ? WHERE NOPERSONNE = ?";
				pstmt = cnx.prepareStatement(req);
				pstmt.setInt(1, employe.getBiblio().getNoBibliotheque());
				pstmt.setString(2, employe.getGradeEmploye());
				pstmt.setInt(3, employe.getNoPersonne());
				result = pstmt.executeUpdate() > 0;
				pstmt.close();
			}
		}
		return result;
	}

	// delete the Utilisateur superclass data from the database using his noPersonne
	// from Utilisateur parameter.
	public boolean delete(Utilisateur utilisateur) throws SQLException {
		// check if Utilisateur is a Adherent or an Employe.
		boolean result = false;
		String req = "";
		if (utilisateur.getEmploye() == null || utilisateur.getEmploye() == (short) 0) {
			req = "DELETE FROM ADHERENT WHERE NOPERSONNE = ?";
			PreparedStatement pstmt = cnx.prepareStatement(req);
			pstmt.setInt(1, utilisateur.getNoPersonne());
			result = pstmt.executeUpdate() > 0;
			pstmt.close();
		} else {
			req = "DELETE FROM EMPLOYE WHERE NOPERSONNE = ?";
			PreparedStatement pstmt = cnx.prepareStatement(req);
			pstmt.setInt(1, utilisateur.getNoPersonne());
			result = pstmt.executeUpdate() > 0;
			pstmt.close();

		}
		if (result) {
			// finally, delete content from Utilisateur table.
			req = "DELETE FROM UTILISATEUR WHERE NOPERSONNE = ?";
			PreparedStatement pstmt = cnx.prepareStatement(req);
			pstmt.setInt(1, utilisateur.getNoPersonne());
			result = pstmt.executeUpdate() > 0;
			pstmt.close();
		}
		return result;
	}

}
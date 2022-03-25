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
	public Utilisateur findUtilisateurByKey(Integer noUtilisateur) throws SQLException {
		Utilisateur result = null;
		ResultSet rs = null;
		String req = "SELECT * FROM UTILISATEUR U "
				+ "LEFT OUTER JOIN EMPLOYE E ON E.NOPERSONNE = U.NOPERSONNE "
				+ "LEFT OUTER JOIN ADHERENT A ON A.NOPERSONNE = U.NOPERSONNE "
				+ "WHERE U.NOPERSONNE = ?";
		PreparedStatement pstmt = cnx.prepareStatement(req);
		pstmt.setInt(1, noUtilisateur);

		if (pstmt.execute()) {
			rs = pstmt.getResultSet();
			if (rs.next()) {
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				boolean isEmploye = rs.getInt("employe") == 1;
				if(isEmploye) {
					result = new Employe(noUtilisateur, nom, prenom, rs.getString("gradeEmploye"), null);
				} else {
					result = new Adherent(noUtilisateur, nom, prenom, rs.getString("noTelAdherent"), rs.getString("PIN"));
				}
				
			}
		}
		rs.close();
		pstmt.close();

		return result;
	}

	public Collection<Utilisateur> findAllUtilisateurs() throws SQLException {
		Collection<Utilisateur> result = null;
		String req = "SELECT * FROM UTILISATEUR U "
				+ "LEFT OUTER JOIN EMPLOYE E ON E.NOPERSONNE = U.NOPERSONNE "
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
			if(isEmploye) {
				utilisateur = new Employe(rs.getInt("noPersonne"), nom, prenom, rs.getString("gradeEmploye"), null);
			} else {
				utilisateur = new Adherent(rs.getInt("noPersonne"), nom, prenom, rs.getString("noTelAdherent"), rs.getString("PIN"));
			}
			result.add(utilisateur);
		}

		return result;
	}

	// insert the Utilisateur superclass data into the database.
	public boolean insertUtilisateur(Utilisateur utilisateur) throws SQLException {
		String req = "INSERT INTO UTILISATEUR (NOPERSONNE, NOM, PRENOM, EMPLOYE) VALUES (?, ?, ?, ?)";
		PreparedStatement pstmt = cnx.prepareStatement(req);
		pstmt.setInt(1, utilisateur.getNoPersonne());
		pstmt.setString(2, utilisateur.getNom());
		pstmt.setString(3, utilisateur.getPrenom());
		pstmt.setInt(4, utilisateur.getEmploye());
		boolean result = pstmt.executeUpdate() > 0;
		pstmt.close();
		return result;
	}

	// update the Utilisateur superclass data into the database using his primary key.
	public boolean updateUtilisateur(Utilisateur utilisateur) throws SQLException {
		String req = "UPDATE UTILISATEUR SET NOM = ?, PRENOM = ?, EMPLOYE = ? WHERE NOPERSONNE = ?";
		PreparedStatement pstmt = cnx.prepareStatement(req);
		pstmt.setString(1, utilisateur.getNom());
		pstmt.setString(2, utilisateur.getPrenom());
		pstmt.setInt(3, utilisateur.getEmploye());
		pstmt.setInt(4, utilisateur.getNoPersonne());
		boolean result = pstmt.executeUpdate() > 0;
		pstmt.close();
		return result;
	}

	// delete the Utilisateur superclass data from the database using his primary key.
	public boolean deleteUtilisateur(Integer noUtilisateur) throws SQLException {
		String req = "DELETE FROM UTILISATEUR WHERE NOPERSONNE = ?";
		PreparedStatement pstmt = cnx.prepareStatement(req);
		pstmt.setInt(1, noUtilisateur);
		boolean result = pstmt.executeUpdate() > 0;
		pstmt.close();
		return result;
	}


	// delete the Utilisateur superclass data from the database using his noPersonne from Utilisateur parameter.
	public boolean deleteUtilisateur(Utilisateur utilisateur) throws SQLException {
		return deleteUtilisateur(utilisateur.getNoPersonne());
	}

}
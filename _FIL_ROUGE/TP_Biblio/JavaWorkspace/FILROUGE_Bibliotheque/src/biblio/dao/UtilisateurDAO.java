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
import biblio.domain.Livre;

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
		PreparedStatement pstmt = cnx.prepareStatement("select * from Utilisateur U INNER JOIN Personne P on U.noPersonne = P.noPersonne where U.noPersonne = ?");
		pstmt.setInt(1, noUtilisateur);

		if (pstmt.execute()) {
			rs = pstmt.getResultSet();
			if (rs.next()) {
				result = new Utilisateur(rs.getInt("noPersonne"), rs.getString("nom"), rs.getString("prenom"), rs.getShort("employe"));
			}
		}
		rs.close();
		pstmt.close();

		return result;
	}

	public Collection<Utilisateur> findAllUtilisateurs() throws SQLException {
		Collection<Utilisateur> result = null;

		Statement stmt = cnx.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM Utilisateur U INNER JOIN Personne P on U.noPersonne = P.noPersonne");
		while (rs.next()) {
			if (result == null) {
				result = new ArrayList<Utilisateur>();
			}
			Utilisateur utilisateur = new Utilisateur(rs.getInt("noPersonne"), rs.getString("nom"), rs.getString("prenom"), rs.getShort("employe"));
			result.add(utilisateur);
		}

		return result;
	}

	public boolean insertUtilisateur(Utilisateur utilisateur) throws SQLException {
		PreparedStatement pstmt = cnx.prepareStatement(
				"INSERT INTO Personne (noPersonne,nom,prenom) VALUES (?,?,?)");
		pstmt.setInt(1, utilisateur.getNoPersonne());
		pstmt.setString(2, utilisateur.getNom());
		pstmt.setString(3, utilisateur.getPrenom());
		pstmt.close();
		int result = pstmt.executeUpdate();
		pstmt = cnx.prepareStatement(
				"INSERT INTO Utilisateur (noPersonne,employe) VALUES (?,?)");
		pstmt.setInt(1, utilisateur.getNoPersonne());
		pstmt.setShort(2, utilisateur.getEmploye());
		result = result + pstmt.executeUpdate();
		pstmt.close();
		return result > 1;
	}

	public boolean updateUtilisateur(Utilisateur utilisateur) throws SQLException {
		PreparedStatement pstmt = cnx.prepareStatement(
				"UPDATE Personne SET nom=?,prenom=? WHERE noPersonne = ?");
		pstmt.setString(1, utilisateur.getNom());
		pstmt.setString(2, utilisateur.getPrenom());
		pstmt.setInt(3, utilisateur.getNoPersonne());
		int result = pstmt.executeUpdate();
		pstmt.close();
		pstmt = cnx.prepareStatement(
				"UPDATE Utilisateur SET employe=? WHERE noPersonne = ?");
		pstmt.setShort(1, utilisateur.getEmploye());
		pstmt.setInt(2, utilisateur.getNoPersonne());

		result = result + pstmt.executeUpdate();
		pstmt.close();
		return result > 1;
	}

	public boolean deleteUtilisateur(Utilisateur utilisateur) throws SQLException {
		PreparedStatement pstmt = cnx.prepareStatement("DELETE FROM Utilisateur WHERE noPersonne = ?");
		pstmt.setInt(1, utilisateur.getNoPersonne());
		int result = pstmt.executeUpdate();
		pstmt.close();
		
		pstmt = cnx.prepareStatement("DELETE FROM Personne WHERE noPersonne = ?");
		pstmt.setInt(1, utilisateur.getNoPersonne());
		result = result + pstmt.executeUpdate();
		pstmt.close();
		return result > 1;
	}
}
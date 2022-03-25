/***********************************************************************
 * Module:  ExemplaireDAO.java
 * Author:  Sk
 * Purpose: Defines the Class ExemplaireDAO
 ***********************************************************************/

package biblio.dao;

import biblio.domain.Exemplaire;
import biblio.domain.Exemplaire;
import biblio.domain.Livre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

/** @pdOid 497bdfbf-e909-4a15-a7ff-c9b904c05060 */
public class ExemplaireDAO {
	private Exemplaire[] exemplairesDB = {

	};
	private Connection cnx = null;

	public ExemplaireDAO(Connection cnx) {
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
	public Exemplaire findExemplaireByKey(Livre livre, Integer codeExemplaire) throws SQLException {
		return this.findExemplaireByKey(livre.getiSBNLivre(), codeExemplaire);
	}
	
	public Exemplaire findExemplaireByKey(Integer isbnLivre, Integer codeExemplaire) throws SQLException {
		Exemplaire result = null;
		ResultSet rs = null;
		PreparedStatement pstmt = cnx
				.prepareStatement("select * from Exemplaire where ISBNLivre = ? AND codeExemplaire = ?");
		pstmt.setInt(1, isbnLivre);
		pstmt.setInt(2, codeExemplaire);

		if (pstmt.execute()) {
			rs = pstmt.getResultSet();
			if (rs.next()) {
				result = new Exemplaire(rs.getShort("codeExemplaire"), rs.getString("commentaireExemplaire"), null,
						null);
			}
		}
		rs.close();
		pstmt.close();

		return result;
	}

	public Collection<Exemplaire> findAllExemplaires() throws SQLException {
		Collection<Exemplaire> result = null;

		Statement stmt = cnx.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM Exemplaire");
		while (rs.next()) {
			if (result == null) {
				result = new ArrayList<Exemplaire>();
			}
			Exemplaire exemplaire = new Exemplaire(rs.getShort("codeExemplaire"), rs.getString("commentaireExemplaire"),
					null, null);
			result.add(exemplaire);
		}

		return result;
	}

	public boolean insertExemplaire(Exemplaire exemplaire) throws SQLException {
		PreparedStatement pstmt = cnx.prepareStatement(
				"INSERT INTO Exemplaire (ISBNLivre,codeExemplaire,noEmplacement,commentaireExemplaire) VALUES (?,?,?,?)");
		pstmt.setInt(1, exemplaire.getLivre().getiSBNLivre());
		pstmt.setInt(2, exemplaire.getCodeExemplaire());
		pstmt.setInt(3, exemplaire.getEmplacement().getNoEmplacement());
		pstmt.setString(4, exemplaire.getCommentaireExemplaire());

		int result = pstmt.executeUpdate();
		pstmt.close();
		return result > 0;
	}

	public boolean updateExemplaire(Exemplaire exemplaire) throws SQLException {
		PreparedStatement pstmt = cnx.prepareStatement(
				"UPDATE Exemplaire SET noEmplacement=?,commentaireExemplaire=? WHERE ISBNLivre = ? AND codeExemplaire = ?");
		pstmt.setInt(1, exemplaire.getEmplacement().getNoEmplacement());
		pstmt.setString(2, exemplaire.getCommentaireExemplaire());
		pstmt.setInt(3, exemplaire.getLivre().getiSBNLivre());
		pstmt.setInt(4, exemplaire.getCodeExemplaire());

		int result = pstmt.executeUpdate();
		pstmt.close();
		return result > 0;
	}

	public boolean deleteExemplaire(Exemplaire exemplaire) throws SQLException {
		PreparedStatement pstmt = cnx
				.prepareStatement("DELETE FROM Exemplaire WHERE ISBNLivre = ? AND codeExemplaire = ?");
		pstmt.setInt(1, exemplaire.getLivre().getiSBNLivre());
		pstmt.setInt(2, exemplaire.getCodeExemplaire());
		int result = pstmt.executeUpdate();
		pstmt.close();
		return result > 0;
	}

}
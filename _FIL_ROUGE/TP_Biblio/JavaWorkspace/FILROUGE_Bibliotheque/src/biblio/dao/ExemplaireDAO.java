/***********************************************************************
 * Module:  ExemplaireDAO.java
 * Author:  Sk
 * Purpose: Defines the Class ExemplaireDAO
 ***********************************************************************/

package biblio.dao;

import biblio.domain.Exemplaire;
import biblio.domain.Livre;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.*;

/** @pdOid 497bdfbf-e909-4a15-a7ff-c9b904c05060 */
public class ExemplaireDAO {
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
	public Exemplaire findByKey(Livre livre, Integer codeExemplaire) throws SQLException {
		Exemplaire result = this.findByKey(livre.getiSBNLivre(), codeExemplaire);
		result.setLivre(livre);
		return result;
	}
	
	public Exemplaire findByKey(Integer isbnLivre, Integer codeExemplaire) throws SQLException {
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

	// find All exemplaires with matching ISBN from Livre parameter
	public List<Exemplaire> findAll(Livre livre) throws SQLException {
		List<Exemplaire> result = new ArrayList<Exemplaire>();
		ResultSet rs = null;
		PreparedStatement pstmt = cnx
				.prepareStatement("select * from Exemplaire where ISBNLivre = ?");
		pstmt.setInt(1, livre.getiSBNLivre());

		if (pstmt.execute()) {
			rs = pstmt.getResultSet();
			while (rs.next()) {
				result.add(new Exemplaire(rs.getShort("codeExemplaire"), rs.getString("commentaireExemplaire"), null,
						livre));
			}
		}
		rs.close();
		pstmt.close();

		return result;
	}

	public List<Exemplaire> findAll() throws SQLException {
		List<Exemplaire> result = null;

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

	public boolean insert(Exemplaire exemplaire) throws SQLException {
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

	public boolean update(Exemplaire exemplaire) throws SQLException {
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

	public boolean delete(Exemplaire exemplaire) throws SQLException {
		PreparedStatement pstmt = cnx
				.prepareStatement("DELETE FROM Exemplaire WHERE ISBNLivre = ? AND codeExemplaire = ?");
		pstmt.setInt(1, exemplaire.getLivre().getiSBNLivre());
		pstmt.setInt(2, exemplaire.getCodeExemplaire());
		int result = pstmt.executeUpdate();
		pstmt.close();
		return result > 0;
	}

	public boolean isDisponible(Exemplaire exemplaire) throws SQLException {
		CallableStatement cstmt = cnx.prepareCall("{? = call is_exemplaire_disponible(?,?)}");
		cstmt.registerOutParameter(1, Types.SMALLINT);
		cstmt.setInt(2, exemplaire.getLivre().getiSBNLivre());
		cstmt.setInt(3, exemplaire.getCodeExemplaire());
		cstmt.execute();
		return cstmt.getShort(1) == 1;
	}
}
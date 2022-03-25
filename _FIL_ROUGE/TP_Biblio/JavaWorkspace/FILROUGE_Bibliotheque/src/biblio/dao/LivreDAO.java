/***********************************************************************
 * Module:  LivreDAO.java
 * Author:  Sk
 * Purpose: Defines the Class LivreDAO
 ***********************************************************************/

package biblio.dao;

import biblio.domain.Livre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

/** @pdOid 16fc22dd-2cd2-438d-b256-b30356e219ed */
public class LivreDAO {
	private Connection cnx = null;

	public LivreDAO(Connection cnx) {
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
	public Livre findLivreByKey(Integer ISBNLivre) throws SQLException {
		Livre result = null;
		ResultSet rs = null;
		PreparedStatement pstmt = cnx
				.prepareStatement("select * from Livre where ISBNLivre = ? ");
		pstmt.setInt(1, ISBNLivre);

		if (pstmt.execute()) {
			rs = pstmt.getResultSet();
			if (rs.next()) {
				result = new Livre(rs.getInt("iSBNLivre"), rs.getString("titreLivre"), null, null, null);
			}
		}
		rs.close();
		pstmt.close();

		return result;
	}

	public Collection<Livre> findAllLivres() throws SQLException {
		Collection<Livre> result = null;

		Statement stmt = cnx.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM Livre");
		while (rs.next()) {
			if (result == null) {
				result = new ArrayList<Livre>();
			}
			Livre livre = new Livre(rs.getInt("iSBNLivre"), rs.getString("titreLivre"), null, null, null);
			result.add(livre);
		}

		return result;
	}

	public boolean insertLivre(Livre livre) throws SQLException {
		PreparedStatement pstmt = cnx.prepareStatement(
				"INSERT INTO Livre (ISBNLivre,noTheme,noAuteur,titreLivre) VALUES (?,?,?,?)");
		pstmt.setInt(1, livre.getiSBNLivre());
		pstmt.setString(2, livre.getTheme().getNoTheme());
		pstmt.setInt(3, livre.getAuteur().getNoAuteur());
		pstmt.setString(4, livre.getTitreLivre());

		int result = pstmt.executeUpdate();
		pstmt.close();
		return result > 0;
	}

	public boolean updateLivre(Livre livre) throws SQLException {
		PreparedStatement pstmt = cnx.prepareStatement(
				"UPDATE Livre SET noTheme=?,noAuteur=?,titreLivre=? WHERE ISBNLivre = ?");
		pstmt.setString(1, livre.getTheme().getNoTheme());
		pstmt.setInt(2, livre.getAuteur().getNoAuteur());
		pstmt.setString(3, livre.getTitreLivre());
		pstmt.setInt(4, livre.getiSBNLivre());

		int result = pstmt.executeUpdate();
		pstmt.close();
		return result > 0;
	}

	public boolean deleteLivre(Livre livre) throws SQLException {
		PreparedStatement pstmt = cnx
				.prepareStatement("DELETE FROM Livre WHERE ISBNLivre = ?");
		pstmt.setInt(1, livre.getiSBNLivre());
		int result = pstmt.executeUpdate();
		pstmt.close();
		return result > 0;
	}
	
	/*private Livre[] livresDB = {
		new Livre(1, "Les misérables", null, null),
		new Livre(2, "L'étranger", null, null),
		new Livre(3, "Le Seigneur des anneaux - Intégrale",null, null)
	};
	public List<Livre> findMatchesByTitre(String contains) {
		List<Livre> trouves = new ArrayList<Livre>();
		for(Livre livre : livresDB) {
			if(livre.getTitreLivre().contains(contains))
				trouves.add(livre);
		}
		return trouves;
	}
	
	public Livre findByKey(int isbn) {
		for(Livre livre : livresDB) {
			if(livre.getiSBNLivre() == isbn) {
				return livre;
			}
		}
		return null;
	}
	
	public List<Livre> findAll(){
		List<Livre> trouves = new ArrayList<Livre>();
		for(Livre livre : livresDB) {
			trouves.add(livre);
		}
		return trouves;
	}*/

}
package biblio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import biblio.domain.Auteur;

public class AuteurDAO {
	private Connection cnx = null;
	
	public AuteurDAO(Connection cnx) {
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
	 * ======================
	 * =	METHUDES CRUD	=
	 * ======================
	 */
	
	public Auteur findByKey(int noAuteur) throws SQLException {
		Auteur result = null;
		ResultSet rs = null;
		PreparedStatement pstmt = cnx.prepareStatement("select * from Auteur where noAuteur = ?");
		pstmt.setInt(1, noAuteur);

		if (pstmt.execute()) {
			rs = pstmt.getResultSet();
			if (rs.next()) {
				result = new Auteur(rs.getInt("noAuteur"), null);
			}
		}
		rs.close();
		pstmt.close();

		return result;
	}

	public Collection<Auteur> findAll() throws SQLException {
		Collection<Auteur> result = null;

		Statement stmt = cnx.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM Auteur");
		while (rs.next()) {
			if(result == null) {
				result = new ArrayList<Auteur>();
			}
			Auteur auteur = new Auteur(rs.getInt("noAuteur"), rs.getString("nomCompletAuteur"));
			result.add(auteur);
		}

		return result;
	}
	
	public boolean insert(Auteur auteur) throws SQLException {
		PreparedStatement pstmt = cnx.prepareStatement("INSERT INTO Auteur(noAuteur,nomCompletAuteur) VALUES (?,?)");
		pstmt.setInt(1,auteur.getNoAuteur());
		pstmt.setString(2, auteur.getNomCompletAuteur());
		int result = pstmt.executeUpdate();
		pstmt.close();
		return result > 0;
	}
	
	public boolean update(Auteur auteur) throws SQLException {
		PreparedStatement pstmt = cnx.prepareStatement("UPDATE Auteur SET nomCompletAuteur = ? WHERE noAuteur = ?");
		pstmt.setInt(2, auteur.getNoAuteur());
		pstmt.setString(1, auteur.getNomCompletAuteur());
		int result = pstmt.executeUpdate();
		pstmt.close();
		return result > 0;
	}
	
	public boolean delete(Auteur auteur) throws SQLException {
		PreparedStatement pstmt = cnx.prepareStatement("DELETE FROM Auteur WHERE noAuteur = ?");
		pstmt.setInt(1,auteur.getNoAuteur());
		int result = pstmt.executeUpdate();
		pstmt.close();
		return result > 0;
	}
}

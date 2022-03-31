/***********************************************************************
 * Module:  PretDAO.java
 * Author:  Sk
 * Purpose: Defines the Class PretDAO
 ***********************************************************************/

package biblio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import biblio.domain.Pret;
import biblio.domain.Utilisateur;

/** @pdOid 182fef41-734d-4d62-80ed-0888f633123a */
public class PretDAO {
	private Connection cnx = null;

	public PretDAO(Connection cnx) {
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
	public Pret findByKey(Integer noPret) throws SQLException {
		Pret result = null;
		ResultSet rs = null;
		PreparedStatement pstmt = cnx.prepareStatement("select * from Pret where noPret = ?");
		pstmt.setInt(1, noPret);

		if (pstmt.execute()) {
			rs = pstmt.getResultSet();
			if (rs.next()) {
				result = new Pret(rs.getInt("noPret"), rs.getDate("dateEmprunt"), rs.getInt("dureePret"), null, null,
						null);
			}
		}
		rs.close();
		pstmt.close();

		return result;
	}

	public List<Pret> findAllByUtilisateur(Utilisateur utilisateur) throws SQLException {
		List<Pret> result = null;

		Statement stmt = cnx.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM Pret where noPersonne = " + utilisateur.getNoPersonne());
		while (rs.next()) {
			if (result == null) {
				result = new ArrayList<Pret>();
			}
			Pret pret = new Pret(rs.getInt("noPret"), rs.getDate("dateEmprunt"), rs.getInt("dureePret"), null, null,
					null);
			result.add(pret);
		}

		return result;
	}
	
	public Collection<Pret> findAll() throws SQLException {
		Collection<Pret> result = null;

		Statement stmt = cnx.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM Pret");
		while (rs.next()) {
			if (result == null) {
				result = new ArrayList<Pret>();
			}
			Pret pret = new Pret(rs.getInt("noPret"), rs.getDate("dateEmprunt"), rs.getInt("dureePret"), null, null,
					null);
			result.add(pret);
		}

		return result;
	}

	public Integer insert(Pret pret) throws SQLException {
		if(pret == null){
			return null;
		}
		
		if(pret.getUtilisateur() == null || pret.getExemplaire() == null || pret.getDateEmprunt() == null){
			return null;
		}

		Integer result = null;
		PreparedStatement pstmt = cnx.prepareStatement("insert into Pret (dateEmprunt, dureePret, noPersonne, ISBNLivre, codeExemplaire, noPret) values (?, ?, ?, ?, ?, seq_pret.nextval)", new String[] {"noPret"});
		pstmt.setDate(1, pret.getDateEmprunt());
		pstmt.setInt(2, pret.getDureePret());
		pstmt.setInt(3, pret.getUtilisateur().getNoPersonne());
		pstmt.setInt(4, pret.getExemplaire().getLivre().getiSBNLivre());
		pstmt.setInt(5, pret.getExemplaire().getCodeExemplaire());
		pstmt.executeUpdate();
		ResultSet rs = pstmt.getGeneratedKeys();
		if (rs.next()) {
			result = rs.getInt(1);
		}
		rs.close();
		pstmt.close();
		return result;
	}


	public boolean update(Pret pret) throws SQLException {
		PreparedStatement pstmt = cnx.prepareStatement(
				"UPDATE Pret SET dateEmprunt=?,codeExemplaire=?,ISBNLivre=?,noPersonne=?,dureePret=? WHERE noPret = ?");
		pstmt.setInt(6, pret.getNoPret());
		pstmt.setDate(1, pret.getDateEmprunt());
		pstmt.setInt(2, pret.getExemplaire().getCodeExemplaire());
		pstmt.setInt(3, pret.getExemplaire().getLivre().getiSBNLivre());
		pstmt.setInt(4, pret.getUtilisateur().getNoPersonne());
		pstmt.setInt(5, pret.getDureePret());
		int result = pstmt.executeUpdate();
		pstmt.close();
		return result > 0;
	}

	public boolean delete(Pret pret) throws SQLException {
		PreparedStatement pstmt = cnx.prepareStatement("DELETE FROM Pret WHERE noPret = ?");
		pstmt.setInt(1, pret.getNoPret());
		int result = pstmt.executeUpdate();
		pstmt.close();
		return result > 0;
	}
}
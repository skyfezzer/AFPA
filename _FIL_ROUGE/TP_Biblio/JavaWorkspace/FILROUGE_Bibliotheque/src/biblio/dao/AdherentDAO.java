/***********************************************************************
 * Module:  AdherentDAO.java
 * Author:  Sk
 * Purpose: Defines the Class AdherentDAO
 ***********************************************************************/

package biblio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import biblio.domain.Adherent;

/** @pdOid 0fdc4bb2-3cdf-4fdb-aa0b-ae5e51539c06 */
public class AdherentDAO {

	private Connection cnx = null;
	private int compteur = 1;
	private Adherent[] adherentsDB = { new Adherent(compteur++, "ALEXIS", "RAGOT", "05.21.15.51.86", "iseeHeehai8"),
			new Adherent(compteur++, "Guy", "Labbé", "01.88.70.79.25", "phiiweip1iD"),
			new Adherent(compteur++, "Musette", "Chalut", "02.17.46.14.56", "Maighud6nu"),
			new Adherent(compteur++, "Nathalie", "Briard", "01.68.54.77.42", "ahj7eu3A"),
			new Adherent(compteur++, "Solaine", "Baril", "01.82.36.99.30", "PohBah1eesu"),
			new Adherent(compteur++, "Ignace", "Bélair", "04.10.03.31.77", "Kaide5keing"),
			new Adherent(compteur++, "Aubrey", "Moreau", "01.16.13.25.80", "Uosh4ahvei"),
			new Adherent(compteur++, "Dielle", "L'Heureux", "01.90.49.33.49", "zieXoon9ae"),
			new Adherent(compteur++, "Catherine", "LaGrande", "02.98.41.82.87", "IeT8buzei"),
			new Adherent(compteur++, "Phillipa", "Clavette", "01.31.07.65.76", "xoo0Yeequ") };

	public AdherentDAO(Connection cnx) {
		super();
		this.setCnx(cnx);
	}

	/**
	 * @return the current DAO connection attached to this DAO object.
	 */
	public Connection getCnx() {
		return cnx;
	}

	/**
	 * @param cnx the Connection to set
	 */
	public void setCnx(Connection cnx) {
		this.cnx = cnx;
	}
	
	/**
	 * @param pincode
	 * @pdOid 6a5d0553-6ad2-42db-a333-573df5b35ac1
	 */
	public boolean isPinOK(String pincode) {
		// TODO: implement
		return false;
	}
	
	/*
	 * ======================
	 * =	METHUDES CRUD	=
	 * ======================
	 */
	
	public Adherent findAdherentByKey(int noAdherent) throws SQLException {
		Adherent result = null;
		ResultSet rs = null;
		PreparedStatement pstmt = cnx.prepareStatement("select * from adherent where noPersonne = ?");
		pstmt.setInt(1, noAdherent);

		if (pstmt.execute()) {
			rs = pstmt.getResultSet();
			if (rs.next()) {
				result = new Adherent(rs.getInt("noPersonne"), null, null, rs.getString("noTelAdherent"),
						rs.getString("pin"));
			}
		}
		rs.close();
		pstmt.close();

		return result;
	}

	public Collection<Adherent> findAllAdherents() throws SQLException {
		Collection<Adherent> result = null;

		Statement stmt = cnx.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM ADHERENT");
		while (rs.next()) {
			if(result == null) {
				result = new ArrayList<Adherent>();
			}
			Adherent adh = new Adherent(rs.getInt("noPersonne"), null, null, rs.getString("noTelAdherent"),
					rs.getString("pin"));
			result.add(adh);
		}

		return result;
	}
	
	public boolean insertAdherent(Adherent adherent) throws SQLException {
		PreparedStatement pstmt = cnx.prepareStatement("INSERT INTO ADHERENT(noPersonne,noTelAdherent,PIN) VALUES (?,?,?)");
		pstmt.setInt(1,adherent.getNoPersonne());
		pstmt.setString(2, adherent.getNoTelAdherent());
		pstmt.setString(3, adherent.getPin());
		int result = pstmt.executeUpdate();
		pstmt.close();
		return result > 0;
	}
	
	public boolean updateAdherent(Adherent adherent) throws SQLException {
		PreparedStatement pstmt = cnx.prepareStatement("UPDATE ADHERENT SET noTelAdherent = ?, pin = ? WHERE noPersonne = ?");
		pstmt.setInt(3,adherent.getNoPersonne());
		pstmt.setString(1, adherent.getNoTelAdherent());
		pstmt.setString(2, adherent.getPin());
		int result = pstmt.executeUpdate();
		pstmt.close();
		return result > 0;
	}
	
	public boolean deleteAdherent(Adherent adherent) throws SQLException {
		PreparedStatement pstmt = cnx.prepareStatement("DELETE FROM ADHERENT WHERE noPersonne = ?");
		pstmt.setInt(1,adherent.getNoPersonne());
		int result = pstmt.executeUpdate();
		pstmt.close();
		return result > 0;
	}

}
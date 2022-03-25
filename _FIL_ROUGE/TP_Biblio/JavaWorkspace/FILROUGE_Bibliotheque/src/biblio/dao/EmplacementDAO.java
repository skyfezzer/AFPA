/***********************************************************************
 * Module:  EmplacementDAO.java
 * Author:  Sk
 * Purpose: Defines the Class EmplacementDAO
 ***********************************************************************/

package biblio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import biblio.domain.Emplacement;


/** @pdOid 199890c8-a608-4cb8-b5a6-e71cf9cd76f3 */
public class EmplacementDAO {
	private Connection cnx  = null;
	
	/*
	private Emplacement[] emplacementsDB = {
			new Emplacement(1, null, null),
			new Emplacement(2, null, null)
	};
	*/
	
	public EmplacementDAO(Connection cnx) {
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
	
	public Emplacement findEmplacementByKey(int noEmplacement) throws SQLException {
		Emplacement result = null;
		ResultSet rs = null;
		PreparedStatement pstmt = cnx.prepareStatement("select * from emplacement where noEmplacement = ?");
		pstmt.setInt(1, noEmplacement);

		if (pstmt.execute()) {
			rs = pstmt.getResultSet();
			if (rs.next()) {
				result = new Emplacement(rs.getInt("noEmplacement"), null, null);
			}
		}
		rs.close();
		pstmt.close();

		return result;
	}
	
	
	public Collection<Emplacement> findAllEmplacementsByBibliotheque(int noBibliotheque) throws SQLException{
		Collection<Emplacement> result = null;
		ResultSet rs = null;
		PreparedStatement pstmt = cnx.prepareStatement("select * from emplacement where noBibliotheque = ?");
		pstmt.setInt(1, noBibliotheque);

		if (pstmt.execute()) {
			result = new ArrayList<Emplacement>();
			rs = pstmt.getResultSet();
			while (rs.next()) {
				Emplacement emp = new Emplacement(rs.getInt("noEmplacement"), null, null);
				result.add(emp);
			}
		}
		rs.close();
		pstmt.close();

		return result;
	}
	
	public boolean insertEmplacement(Emplacement emplacement) throws SQLException {
		PreparedStatement pstmt = cnx.prepareStatement("INSERT INTO Emplacement (noEmplacement,noBibliotheque,noTheme) VALUES (?,?,?)");
		pstmt.setInt(1, emplacement.getNoEmplacement());
		pstmt.setInt(2, emplacement.getBibliotheque().getNoBibliotheque());
		pstmt.setString(3, emplacement.getTheme().getNoTheme());
		int result = pstmt.executeUpdate();
		pstmt.close();
		return result > 0;
	}
	
	public boolean updateEmplacement(Emplacement emplacement) throws SQLException {
		PreparedStatement pstmt = cnx.prepareStatement("UPDATE Emplacement SET noBibliotheque = ?, noTheme = ? WHERE noEmplacement = ?");
		pstmt.setInt(1, emplacement.getBibliotheque().getNoBibliotheque());
		pstmt.setString(2, emplacement.getTheme().getNoTheme());
		pstmt.setInt(3, emplacement.getNoEmplacement());
		int result = pstmt.executeUpdate();
		pstmt.close();
		return result > 0;
	}
	
	public boolean deleteEmplacement(Emplacement emplacement) throws SQLException {
		PreparedStatement pstmt = cnx.prepareStatement("DELETE FROM Emplacement WHERE noEmplacement = ?");
		pstmt.setInt(1, emplacement.getNoEmplacement());
		int result = pstmt.executeUpdate();
		pstmt.close();
		return result > 0;
	}
	
}
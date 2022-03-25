package biblio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import biblio.domain.Bibliotheque;

public class BibliothequeDAO {
	private Connection cnx = null;

	public BibliothequeDAO(Connection cnx) {
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
	public Bibliotheque findByKey(int noBibliotheque) throws SQLException {
		Bibliotheque result = null;
		ResultSet rs = null;
		PreparedStatement pstmt = cnx.prepareStatement("select * from bibliotheque where noBibliotheque = ?");
		pstmt.setInt(1, noBibliotheque);

		if (pstmt.execute()) {
			rs = pstmt.getResultSet();
			if (rs.next()) {
				result = new Bibliotheque(rs.getInt("noBibliotheque"), rs.getString("adresse"));
			}
		}
		rs.close();
		pstmt.close();

		return result;
	}

	public Collection<Bibliotheque> findAll() throws SQLException {
		Collection<Bibliotheque> result = null;

		Statement stmt = cnx.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM Bibliotheque");
		while (rs.next()) {
			if (result == null) {
				result = new ArrayList<Bibliotheque>();
			}
			Bibliotheque biblio = new Bibliotheque(rs.getInt("noBibliotheque"), rs.getString("adresse"));
			result.add(biblio);
		}

		return result;
	}

	public boolean insert(Bibliotheque biblio) throws SQLException {
		PreparedStatement pstmt = cnx.prepareStatement("INSERT INTO Bibliotheque (noBibliotheque,adresse) VALUES (?,?)");
		pstmt.setInt(1, biblio.getNoBibliotheque());
		pstmt.setString(2, biblio.getAdresse());
		int result = pstmt.executeUpdate();
		pstmt.close();
		return result > 0;
	}

	public boolean update(Bibliotheque biblio) throws SQLException {
		PreparedStatement pstmt = cnx.prepareStatement("UPDATE Bibliotheque SET adresse = ? WHERE noBibliotheque = ?");
		pstmt.setString(1, biblio.getAdresse());
		pstmt.setInt(2, biblio.getNoBibliotheque());
		int result = pstmt.executeUpdate();
		pstmt.close();
		return result > 0;
	}

	public boolean delete(Bibliotheque biblio) throws SQLException {
		PreparedStatement pstmt = cnx.prepareStatement("DELETE FROM Bibliotheque WHERE noBibliotheque = ?");
		pstmt.setInt(1, biblio.getNoBibliotheque());
		int result = pstmt.executeUpdate();
		pstmt.close();
		return result > 0;
	}
}

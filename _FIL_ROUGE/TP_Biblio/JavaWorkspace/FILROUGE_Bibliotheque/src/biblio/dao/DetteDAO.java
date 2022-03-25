package biblio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import biblio.domain.Dette;

public class DetteDAO {
	private Connection cnx = null;

	public DetteDAO(Connection cnx) {
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
	public Dette findByKey(int noDette) throws SQLException {
		Dette result = null;
		ResultSet rs = null;
		PreparedStatement pstmt = cnx.prepareStatement("select * from Dette where noDette = ?");
		pstmt.setInt(1, noDette);

		if (pstmt.execute()) {
			rs = pstmt.getResultSet();
			if (rs.next()) {
				result = new Dette(rs.getInt("noDette"), null, rs.getFloat("montantDette"), rs.getString("motifDette"), rs.getDate("dateDette"));
			}
		}
		rs.close();
		pstmt.close();

		return result;
	}

	public Collection<Dette> findAll() throws SQLException {
		Collection<Dette> result = null;

		Statement stmt = cnx.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM Dette");
		while (rs.next()) {
			if (result == null) {
				result = new ArrayList<Dette>();
			}
			Dette dette = new Dette(rs.getInt("noDette"), null, rs.getFloat("montantDette"), rs.getString("motifDette"), rs.getDate("dateDette"));
			result.add(dette);
		}

		return result;
	}

	public boolean insert(Dette dette) throws SQLException {
		PreparedStatement pstmt = cnx.prepareStatement("INSERT INTO Dette (noDette,noPersonne,montantDette,motifDette,dateDette) VALUES (?,?,?,?,?)");
		pstmt.setInt(1, dette.getNoDette());
		pstmt.setInt(2, dette.getAdherent().getNoPersonne());
		pstmt.setFloat(3, dette.getMontantDette());
		pstmt.setString(4, dette.getMotifDette());
		pstmt.setDate(5, dette.getDateDette());
		int result = pstmt.executeUpdate();
		pstmt.close();
		return result > 0;
	}

	public boolean update(Dette dette) throws SQLException {
		PreparedStatement pstmt = cnx.prepareStatement("UPDATE Dette SET noPersonne = ?, montantDette = ?, motifDette = ?, dateDette = ? WHERE noDette = ?");
		pstmt.setInt(1, dette.getAdherent().getNoPersonne());
		pstmt.setFloat(2, dette.getMontantDette());
		pstmt.setString(3, dette.getMotifDette());
		pstmt.setDate(4, dette.getDateDette());
		pstmt.setInt(5, dette.getNoDette());
		int result = pstmt.executeUpdate();
		pstmt.close();
		return result > 0;
	}

	public boolean delete(Dette dette) throws SQLException {
		PreparedStatement pstmt = cnx.prepareStatement("DELETE FROM Dette WHERE noDette = ?");
		pstmt.setInt(1, dette.getNoDette());
		int result = pstmt.executeUpdate();
		pstmt.close();
		return result > 0;
	}

}

package biblio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import biblio.domain.Employe;

public class EmployeDAO {
	private Connection cnx = null;

	public EmployeDAO(Connection cnx) {
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
	public Employe findEmployeByKey(int noEmploye) throws SQLException {
		Employe result = null;
		ResultSet rs = null;
		PreparedStatement pstmt = cnx.prepareStatement("select * from Employe where noPersonne = ?");
		pstmt.setInt(1, noEmploye);

		if (pstmt.execute()) {
			rs = pstmt.getResultSet();
			if (rs.next()) {
				result = new Employe(rs.getInt("noEmploye"), null, null, rs.getString("gradeEmploye"), null);
			}
		}
		rs.close();
		pstmt.close();

		return result;
	}

	public Collection<Employe> findAllEmployes() throws SQLException {
		Collection<Employe> result = null;

		Statement stmt = cnx.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM Employe");
		while (rs.next()) {
			if (result == null) {
				result = new ArrayList<Employe>();
			}
			Employe emp = new Employe(rs.getInt("noEmploye"), null, null, rs.getString("gradeEmploye"), null);
			result.add(emp);
		}

		return result;
	}

	public boolean insertEmploye(Employe employe) throws SQLException {
		PreparedStatement pstmt = cnx.prepareStatement("INSERT INTO Employe (noPersonne,noBibliotheque,gradeEmploye) VALUES (?,?,?)");
		pstmt.setInt(1, employe.getNoPersonne());
		pstmt.setString(3, employe.getGradeEmploye());
		pstmt.setInt(2, employe.getBiblio().getNoBibliotheque());
		int result = pstmt.executeUpdate();
		pstmt.close();
		return result > 0;
	}

	public boolean updateEmploye(Employe employe) throws SQLException {
		PreparedStatement pstmt = cnx.prepareStatement(
				"UPDATE Employe SET noBibliotheque = ?, gradeEmploye = ? WHERE noPersonne = ?");
		pstmt.setInt(3, employe.getNoPersonne());
		pstmt.setString(2, employe.getGradeEmploye());
		pstmt.setInt(1, employe.getBiblio().getNoBibliotheque());
		int result = pstmt.executeUpdate();
		pstmt.close();
		return result > 0;
	}

	public boolean deleteEmploye(Employe employe) throws SQLException {
		PreparedStatement pstmt = cnx.prepareStatement("DELETE FROM Employe WHERE noPersonne = ?");
		pstmt.setInt(1, employe.getNoPersonne());
		int result = pstmt.executeUpdate();
		pstmt.close();
		return result > 0;
	}
}

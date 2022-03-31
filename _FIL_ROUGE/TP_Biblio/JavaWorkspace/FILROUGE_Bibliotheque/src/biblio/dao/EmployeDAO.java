package biblio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import biblio.domain.Employe;

public class EmployeDAO {
    private Connection cnx = null;

    public EmployeDAO(Connection cnx) {
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

    public Employe findByKey(int noPersonne) throws SQLException {
        Employe result = null;
        ResultSet rs = null;
        String req = "SELECT * FROM EMPLOYE E " + "LEFT OUTER JOIN UTILISATEUR U ON U.NOPERSONNE = E.NOPERSONNE "
                + "WHERE E.NOPERSONNE = ?";
        PreparedStatement pstmt = cnx.prepareStatement(req);
        pstmt.setInt(1, noPersonne);

        if (pstmt.execute()) {
            rs = pstmt.getResultSet();
            if (rs.next()) {
                if (rs.getInt("adherent") == 1) {
                    return null;
                }
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String gradeEmploye = rs.getString("gradeEmploye");
                result = new Employe(noPersonne, nom, prenom, gradeEmploye, null);
            }
        }
        return result;
    }

    // function that return a Collection of all Employe in Employe table.
    public List<Employe> findAll() throws SQLException {
        List<Employe> result = new ArrayList<Employe>();
        ResultSet rs = null;
        String req = "SELECT * FROM EMPLOYE E " + "LEFT OUTER JOIN UTILISATEUR U ON U.NOPERSONNE = E.NOPERSONNE ";
        PreparedStatement pstmt = cnx.prepareStatement(req);

        if (pstmt.execute()) {
            rs = pstmt.getResultSet();
            while (rs.next()) {
                if (rs.getInt("employe") == 1) {
                    int noPersonne = rs.getInt("noPersonne");
                    String nom = rs.getString("nom");
                    String prenom = rs.getString("prenom");
                    String gradeEmploye = rs.getString("gradeEmploye");
                    Employe employe = new Employe(noPersonne, nom, prenom, gradeEmploye, null);
                    result.add(employe);
                }
                
            }
        }
        return result;
    }

    // insert a new Employe into Employe table.
    public boolean insert(Employe employe) throws SQLException {
        String req = "INSERT INTO UTILISATEUR (NOPERSONNE, NOM, PRENOM, EMPLOYE) VALUES (?, ?, ?, ?)";
		PreparedStatement pstmt = cnx.prepareStatement(req);
		pstmt.setInt(1, employe.getNoPersonne());
		pstmt.setString(2, employe.getNom());
		pstmt.setString(3, employe.getPrenom());
        pstmt.setInt(4, employe.getEmploye());
		boolean executed = pstmt.executeUpdate() > 0;
		pstmt.close();
        if (!executed) {
			return false;
		}
        req = "INSERT INTO EMPLOYE (NOPERSONNE, NOBIBLIOTHEQUE, GRADEEMPLOYE) VALUES (?, ?, ?)";
        pstmt = cnx.prepareStatement(req);
        pstmt.setInt(1, employe.getNoPersonne());
        pstmt.setInt(2, employe.getBiblio().getNoBibliotheque());
        pstmt.setString(3, employe.getGradeEmploye());
        executed = pstmt.executeUpdate() > 0;
        pstmt.close();
        return executed;
    }

    // update an Employe in Employe table.
    public boolean update(Employe employe) throws SQLException {
        String req = "UPDATE UTILISATEUR SET NOM = ?, PRENOM = ? WHERE NOPERSONNE = ?";
        PreparedStatement pstmt = cnx.prepareStatement(req);
        pstmt.setString(1, employe.getNom());
        pstmt.setString(2, employe.getPrenom());
        pstmt.setInt(3, employe.getNoPersonne());
        boolean executed = pstmt.executeUpdate() > 0;
        pstmt.close();
        if (!executed) {
			return false;
		}
        req = "UPDATE EMPLOYE SET NOBIBLIOTHEQUE = ?, GRADEEMPLOYE = ? WHERE NOPERSONNE = ?";
        pstmt = cnx.prepareStatement(req);
        pstmt.setInt(1, employe.getBiblio().getNoBibliotheque());
        pstmt.setString(2, employe.getGradeEmploye());
        pstmt.setInt(3, employe.getNoPersonne());
        executed = pstmt.executeUpdate() > 0;
        pstmt.close();
        return executed;
    }

    // delete an Employe from Employe then Utilisateur tables.
    public boolean delete(Employe employe) throws SQLException {
        String req = "DELETE FROM EMPLOYE WHERE NOPERSONNE = ?";
        PreparedStatement pstmt = cnx.prepareStatement(req);
        pstmt.setInt(1, employe.getNoPersonne());
        boolean executed = pstmt.executeUpdate() > 0;
        pstmt.close();
        if (!executed) {
			return false;
		}
        req = "DELETE FROM UTILISATEUR WHERE NOPERSONNE = ?";
        pstmt = cnx.prepareStatement(req);
        pstmt.setInt(1, employe.getNoPersonne());
        executed = pstmt.executeUpdate() > 0;
        pstmt.close();
        return executed;
    }


}

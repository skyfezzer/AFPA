package biblio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import biblio.domain.Theme;

public class ThemeDAO {
    private Connection cnx = null;
    
    public ThemeDAO(Connection cnx) {
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

    public Theme findByKey(int noTheme) throws SQLException {
        Theme result = null;
        ResultSet rs = null;
        PreparedStatement pstmt = cnx.prepareStatement("select noTheme, intituleTheme from Theme where noTheme = ?");
        pstmt.setInt(1, noTheme);

        if (pstmt.execute()) {
            rs = pstmt.getResultSet();
            if (rs.next()) {
                result = new Theme(rs.getString("noTheme"), rs.getString("nomTheme"));
            }
        }
        rs.close();
        pstmt.close();

        return result;
    }

    public List<Theme> findAll() throws SQLException {
        List<Theme> result = null;

        Statement stmt = cnx.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Theme");
        if (rs.next()) {
            result = new ArrayList<Theme>();
            do {
                result.add(new Theme(rs.getString("noTheme"), rs.getString("intituleTheme")));
            } while (rs.next());
        }
        rs.close();
        stmt.close();

        return result;
    }
}

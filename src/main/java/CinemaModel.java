import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CinemaModel {


    List<Seance> find(String str) throws SQLException {
        Connection c = DriverManager.getConnection("jdbc:derby:CinemaDB;create=true");
        PreparedStatement find = c.prepareStatement("SELECT ID, STIME FROM SEANCES WHERE FILM=?");
        find.setString(1,str);
        ResultSet rs = find.executeQuery();
        List<Seance> result = new ArrayList<Seance>();
        while ()
    }


}

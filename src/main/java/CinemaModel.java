import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CinemaModel implements ICinemaModel{

    public List<Seances> find(String film, Date stime, Integer hall, Integer age, Double price) throws SQLException {

        Connection c = DConnection.getConnection();
        StringBuilder query = new StringBuilder();
        query.append("SELECT ID, STIME, AGE, PRICE, FILM, HALL FROM SEANCES WHERE 1=1 ");

        if (stime != null) {
            query.append(" AND STIME>=?");
        }

        if (age != null) {
            query.append(" AND AGE>=?");
        }

        if (price != null) {
            query.append(" AND PRICE>=?");
        }

        if (film != null) {
            query.append(" AND FILM LIKE '%" + film + "%'");
        }

        if (hall != null) {
            query.append(" AND HALL=?");
        }

        PreparedStatement find = c.prepareStatement(query.toString());


        int row = 1;

        if (stime != null) {
            find.setDate(row++, stime);
        }

        if (age != null) {
            find.setInt(row++, age);
        }

        if (price != null) {
            find.setDouble(row++, price);
        }

        if (film != null) {
            find.setString(row++, film);
        }

        if (hall != null) {
            find.setInt(row++, hall);
        }


        ResultSet rs = find.executeQuery();

        List<Seances> result = new ArrayList<Seances>();

        while (rs.next()) {
            result.add(new Seances(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getInt(4),  rs.getInt(5),  rs.getInt(6)));
        }
        return result;
    }

    public void addHall(int nRows, int seats) throws SQLException {
        Connection c = DConnection.getConnection();
        PreparedStatement p = c.prepareStatement("INSERT INTO HALLS (NROWS, SEATS)" +
                "VALUES(?,?)");
        p.setInt(1, nRows);
        p.setInt(2, seats);
        p.executeUpdate();
        p.close();
    }

    public List<Halls> listHalls() throws SQLException {
        List<Halls> list = new ArrayList<Halls>();
        Connection c = DConnection.getConnection();
        PreparedStatement ps = c.prepareStatement("SELECT ID, NROWS, SEATS FROM HALLS");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            list.add(new Halls(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
        }
        rs.close();
        ps.close();
        return list;
    }

    public void shutdown(){
        try {
            DriverManager.getConnection("jdbc:derby:memory:test;shutdown=true");
        } catch (SQLException sqlex) {

        }
    }
}

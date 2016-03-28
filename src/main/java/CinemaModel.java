import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IIS on 10.03.2016.
 */
public class CinemaModel {
    public void addHall(int nrows, int seats) throws SQLException {
        Connection connection = DConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO HALLS(NROWS,SEATS)" +
                "VALUES(?,?)");
        preparedStatement.setInt(1, nrows);
        preparedStatement.setInt(2, seats);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public List<Halls> listHalls() throws SQLException {
        List<Halls> list = new ArrayList<Halls>();
        Connection connection = DConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT ID, NROWS, SEATS FROM HALLS");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            list.add(new Halls(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3)));
        }
        resultSet.close();
        preparedStatement.close();
        return list;
    }


    List<Seances> find(String str) throws SQLException {
        Connection c = DConnection.getConnection();
        PreparedStatement find = c.prepareStatement("SELECT ID, STIME FROM SEANCES WHERE FILM=?");
        find.setString(1, str);
        ResultSet rs = find.executeQuery();
        List<Seances> result = new ArrayList<Seances>();
        while (rs.next()) {
            int id = rs.getInt(1);

            result.add(new Seances(0, null, null, 0, 0, 0));
        }
        return result;
    }


    public List<Seances> findSeance(Seances seances) throws SQLException {
        Connection c = DConnection.getConnection();

        List<Seances> list = new ArrayList<Seances>();
        StringBuilder query = new StringBuilder();

        query.append("SELECT ID, STIME, AGE, PRICE, FILM, HALL FROM SEANCES WHERE 1=1 ");
        if (seances.STIME != null){
            query.append(" AND STIME >= ?");
        }

        query.append(" AND AGE >= ?");


        query.append(" AND PRICE >= ?");

        if (seances.FILM != null){
            query.append(" AND UPPER (FILM) LIKE '%").append(seances.FILM).append("%' ");
        }

        query.append(" AND HALL = ?");


        int row = 1;
        PreparedStatement findSeance = c.prepareStatement(String.valueOf(query));
        findSeance.setTimestamp(++row, Seances.STIME);
        ResultSet resultSet = findSeance.executeQuery();
        while (resultSet.next()){
            list.add(new Seances(resultSet.getInt(1)));
        }



    }
}

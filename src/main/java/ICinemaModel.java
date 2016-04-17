import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface ICinemaModel {

    List<Seances> find(String film, Date stime, Integer hall, Integer age, Double price) throws SQLException;
    void addHall(int nRows, int seats) throws SQLException;
    List<Halls> listHalls() throws SQLException;
    // public void addSeances(String name, Date time, int hall, int age, double price) throws SQLException;
    // public void addReserve(int row, int seat, int user_id, int seances) throws SQLException;
}

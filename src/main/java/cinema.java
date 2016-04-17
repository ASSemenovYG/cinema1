import java.sql.SQLException;
import java.util.List;

public class Cinema {
    public static void main(String[] args) throws SQLException {
        DConnection.getConnection();
        CinemaModel cinemaModel = new CinemaModel();
        cinemaModel.addHall(45, 5);
        cinemaModel.addHall(4, 7);
        List<Halls> list = cinemaModel.listHalls();
        for (Halls halls : list) {
            System.out.println(halls);
        }

    }
}




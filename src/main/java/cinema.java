import javax.security.auth.login.CredentialException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by IIS on 25.02.2016.
 */
public class Cinema {
    public static void main(String[] args) throws SQLException {
        Connection connection = DConnection.getConnection();
        CinemaModel cinemaModel = new CinemaModel();
        cinemaModel.addHall(45, 5);
        cinemaModel.addHall(4, 7);
        List<Halls> list = cinemaModel.listHalls();
        for (Halls halls : list) {
            System.out.println(halls);
        }
    }
}




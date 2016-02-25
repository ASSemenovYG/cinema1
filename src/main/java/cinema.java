import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class cinema {


    public static void main(String args[]) throws SQLException {
    DB cinema = new DB();
        DB.createDB();

    }
}




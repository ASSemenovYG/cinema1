import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class cinema  {


    private static Connection newDB;

    public static void main(String args[]) throws SQLException {
    createDB(newDB);

    }
}




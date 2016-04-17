import java.sql.Date;

public class Seances {
    public final int id;
    public final String filmName;
    public final java.sql.Date time;
    public final int hall;
    public final int price;
    public final int age;


    public Seances(int id, String filmName, Date time, int hall, int price, int age) {
        this.id = id;
        this.filmName = filmName;
        this.time = time;
        this.hall = hall;
        this.price = price;
        this.age = age;
    }
}

/**
 * Created by furka on 19.02.2017.
 */
/**
 * @author Furkan Sergen Dayioglu
 * Course : CSE222 Data Structures and Algorithms
 * StudentID: 121044015
 */
public class Database {
    private Book[] books;
    private User[] users;
    private static Database ourInstance = new Database();

    public static Database getInstance() {
        return ourInstance;
    }

    private Database() {
    }
}

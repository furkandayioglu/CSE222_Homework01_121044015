/**
 * Created by furka on 19.02.2017.
 */
/**
 * @author Furkan Sergen Dayioglu
 * Course : CSE222 Data Structures and Algorithms
 * StudentID: 121044015
 */
public abstract class SystemAdmin implements User{

    public abstract String getName(); // User name
    public abstract String getSurname(); // User surname
    public abstract void   setName(String name);
    public abstract void   setSurname(String surname);
    public abstract String UserID(); // UserID
    public abstract void BorrowBook(Book book); // If user wants to borrow a book
    public abstract void ReturnBook(Book book); // User return the book that borrowed before
    public abstract void AddBookToDatabase(Book newBook);
    public abstract void DeleteBookFromDataBase(Book book);
    public abstract void AddNewUser(User newUser);
    public abstract void DeleteUser(User user);
}

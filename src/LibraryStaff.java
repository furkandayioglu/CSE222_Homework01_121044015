/**
 * Created by furka on 19.02.2017.
 */
/**
 * @author Furkan Sergen Dayioglu
 * Course : CSE222 Data Structures and Algorithms
 * StudentID: 121044015
 */
public class LibraryStaff implements User {

    private String name;
    private String surname;
    private String password;
    private String username;
    private Database db = Database.getInstance();

    public LibraryStaff() {

    }

    public LibraryStaff(String password, String username) {
        this.password = password;
        this.username = username;
    }

    public LibraryStaff(String name, String surname, String password, String username) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.username = username;
    }


    public String getName() {
        return name;
    }


    public String getSurname() {
        return this.surname;
    }


    public String UserID() {
        return this.username;
    }


    public void setName(String name) {
            this.name=name;
    }


    public void setSurname(String surname) {
        this.surname = surname;
    }


    public String getPassword() {
        return this.password;
    }


    public void setPassword(String pass) {
        this.password = pass;
    }


    public void setUserID(String username) {
        this.username=username;
    }

    @Override
    public boolean equals(Object o) {
        if(this==o){
            return true;

        }
        if(this.getClass() == o.getClass()){
            LibraryStaff lS = (LibraryStaff) o;
            return ((this.getName() == lS.getName())&&
                    (this.getSurname() == lS.getSurname())&&
                    (this.UserID() == lS.UserID()) &&
                    (this.getPassword() == lS.getPassword()));
        }else
            return false;

    }

    @Override
    public String toString() {
        String staff =this.getName()+","+this.getSurname()+","+this.UserID()+","+this.getPassword();
        return staff;
    }

//    public boolean giveBook(Book book, LibraryUser libUser){
//
//         if(Database.getInstance().isThereAnyBook(book)==true && book.isAvailable() == true && Database.getInstance().isThereAnyMember(libUser) == true){
//                libUser.setRecentBookCode(book.getBookCode());
//                book.setCount(book.getCount()-1);
//         }
//        return false;
//    }
//
//    public void addBook(Book newBook){
//        Database.getInstance().addBook(newBook);
//    }
//
//    public void deleteBook(Book delete){
//        Database.getInstance().deleteBook(delete);
//    }
}

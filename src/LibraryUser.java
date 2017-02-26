/**
 * Created by furka on 19.02.2017.
 */
/**
 * @author Furkan Sergen Dayioglu
 * Course : CSE222 Data Structures and Algorithms
 * StudentID: 121044015
 */
public class LibraryUser implements User {

    private String name;
    private String surname;
    private String password;
    private String username;
    private String recentBookCode;
    private Database db = Database.getInstance();

    public LibraryUser() {

        setName(null);
        setSurname(null);
        setSurname(null);
        setUserID(null);
        setPassword(null);
        setRecentBookCode(null);
    }

    public LibraryUser(String password, String username) {
        this.password = password;
        this.username = username;
    }

    public LibraryUser(String name, String surname, String password, String username) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.username = username;
        this.recentBookCode = null;
    }

    public LibraryUser(String name, String surname, String password, String username, String recentBookCode) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.username = username;
        this.recentBookCode = recentBookCode;
    }

    public String getName() {
        return this.name;
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
        this.password=pass;
    }


    public void setUserID(String username) {
            this.username=username;
    }

    public String getRecentBookCode(){return this.recentBookCode;}

    public void setRecentBookCode(String code){this.recentBookCode= code;}

    @Override
    public boolean equals(Object o) {
        if(this == o){
            return true;
        }if (this.getClass() == o.getClass()){
            LibraryUser lU = (LibraryUser) o;
            return ((this.getName() == lU.getName()) &&
                    (this.getSurname() == lU.getSurname()) &&
                    (this.UserID() == lU.UserID() ) &&
                    (this.getPassword() == lU.getPassword()));

        }else return false;

    }

    @Override
    public String toString()
    {
        String libraryUser = this.getName()+","+this.getSurname()+","+this.UserID()+","+this.getPassword();

        return libraryUser;
    }
    //   public void borrowABook(Book book){
//
//        if((Database.getInstance().isThereAnyBook(book) == true && this.recentBookCode==null) && (Database.getInstance().getBook(book)).getCount()>0)
//        {
//            this.setRecentBookCode(book.getBookCode());
//            Database.getInstance().getBook(book).setCount(Database.getInstance().getBook(book).getCount()-1);
//        }
//
//    }
//
//    public void returnBook(Book book){
//        if(Database.getInstance().isThereAnyBook(book) == true){
//            Database.getInstance().getBook(book).setCount(Database.getInstance().getBook(book).getCount()+1);
//        }else
//        {
//            Database.getInstance().addBook(book);
//        }
//    }
}

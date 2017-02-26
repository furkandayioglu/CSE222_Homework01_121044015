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

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getSurname() {
        return this.surname;
    }

    @Override
    public String UserID() {
        return this.username;
    }

    @Override
    public void setName(String name) {
        this.name=name;
    }

    @Override
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public void setPassword(String pass) {
        this.password=pass;
    }

    @Override
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
        String libraryUser = "Name : "+this.getName()+"\nSurname : "+this.getSurname();

        return libraryUser;
    }

    public void borrowABook(Book book){

        if(Database.getInstance().isThereAnyBook(book) == true && this.recentBookCode==null)
        {
            this.setRecentBookCode(book.getBookCode());

        }

    }
}

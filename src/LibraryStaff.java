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

    @Override
    public String getName() {
        return name;
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
        this.password = pass;
    }

    @Override
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
        return super.toString();
    }
}

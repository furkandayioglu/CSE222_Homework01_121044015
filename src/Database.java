/**
 * Created by furka on 19.02.2017.
 */

import java.io.*;

/**
 * @author Furkan Sergen Dayioglu
 *         Course : CSE222 Data Structures and Algorithms
 *         StudentID: 121044015
 */


/*
    Singleton design idea is gotten from Last year's homework solution also from her github account
    https://github.com/sevgiborazan/CSE222_Data_Structures_and_Algorithms/blob/master/HW01_Sevgi_Borazan_111044058/src/main/java/com/mycompany/hw01_sevgi_borazan_111044058/Database.java

 */
public class Database {
    private Book[] books = new Book[INIT_CAPACITY_];
    private User[] users = new User[INIT_CAPACITY_];
    private static int INIT_CAPACITY_=40;
    private int userUsed = 0;
    private int bookUsed = 0;
    private static Database ourInstance = new Database();

    /**
     * No parameter constructor
     * Private
     * It blocks to creating/constructing new object from this class
     * but just using an instantiate of this ourInstance object
     */
    private Database() {
        // No parameter constructor
        //Indentationally empty
    }

    /**
     * Whole program will use this Database instance.
     * So all objects/ classes can reach same one database for checking operations
     *
     * @return singleton database object
     */
    public static Database getInstance() {

        if (ourInstance == null) {
            synchronized (Database.class) { // for thread safety
                if (ourInstance == null) ourInstance = new Database();// Singleton object
            }
        }
        return ourInstance;
    }

    public void initializeDatabase() {
        this.readBooksFromCsvFile("bookList.csv");
        this.readLibraryStaffFromCSVFile("staffList.csv");
        this.readLibraryUserFromCSVFile("userList.csv");
    }

    public void readLibraryUserFromCSVFile(String filename) {
        BufferedReader userFile = null;
        String split = ",";
        String line = ""; // hail the brother mykyong
        // csv reading code is gotten there
        // https://www.mkyong.com/java/how-to-read-and-parse-csv-file-in-java/
        int i = 0;
        try {
            userFile = new BufferedReader(new FileReader(filename));

            while ((line = userFile.readLine()) != null) {
                User temp = new LibraryUser();
                String[] userInfo = line.split(split);
                temp.setName(userInfo[0]);
                temp.setSurname(userInfo[1]);
                temp.setUserID(userInfo[2]);
                temp.setPassword(userInfo[3]);
                this.addUser(temp);
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (userFile != null) {
                try {
                    userFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    public void readLibraryStaffFromCSVFile(String filename) {
        BufferedReader userFile = null;
        String split = ",";
        String line = ""; // hail the brother mykyong
        // csv reading code is gotten there
        // https://www.mkyong.com/java/how-to-read-and-parse-csv-file-in-java/
        int i = userUsed;
        try {
            userFile = new BufferedReader(new FileReader(filename));

            while ((line = userFile.readLine()) != null) {
                User temp = new LibraryStaff();
                String[] userInfo = line.split(split);
                temp.setName(userInfo[0]);
                temp.setSurname(userInfo[1]);
                temp.setUserID(userInfo[2]);
                temp.setPassword(userInfo[3]);
                this.addUser(temp);
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (userFile != null) {
                try {
                    userFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    public void readBooksFromCsvFile(String filename) {
        BufferedReader bookFile = null;
        String split = ",";
        String line = ""; // hail the brother mykyong
        // csv reading code is gotten there
        // https://www.mkyong.com/java/how-to-read-and-parse-csv-file-in-java/
        int i = 0;
        try {
            bookFile = new BufferedReader(new FileReader(filename));

            while ((line = bookFile.readLine()) != null) {
                Book temp = new Book();
                String[] bookinfo = line.split(split);
                temp.setBookCode(bookinfo[0]);
                temp.setBookName(bookinfo[1]);
                temp.setAuthor(bookinfo[2]);
                temp.setPage(Integer.parseInt(bookinfo[3]));
                temp.setAvailable(true);
                this.addBook(temp);
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bookFile != null) {
                try {
                    bookFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    public void addUser(User newUser) {

        if (this.userUsed < users.length-1) {
            users[userUsed].setName(newUser.getName());
            users[userUsed].setSurname(newUser.getSurname());
            users[userUsed].setUserID(newUser.UserID());
            users[userUsed].setPassword(newUser.getPassword());
            userUsed++;
        } else {
            User[] temp = new User[userUsed];
            //userCapacity *=2;
           //temp = Arrays.copyOf(users, users.length);
            for(int i =0 ; i<userUsed;i++){
                temp[i].setName(users[i].getName());
                temp[i].setSurname(users[i].getSurname());
                temp[i].setUserID(users[i].UserID());
                temp[i].setPassword(users[i].getPassword());
            }
            users = null;
            users = new User[userUsed*2];
            //users = Arrays.copyOf(temp, temp.length);
            for(int i =0 ; i<userUsed;i++){
                users[i].setName(temp[i].getName());
                users[i].setSurname(temp[i].getSurname());
                users[i].setUserID(temp[i].UserID());
                users[i].setPassword(temp[i].getPassword());
            }
            users[userUsed].setName(newUser.getName());
            users[userUsed].setSurname(newUser.getSurname());
            users[userUsed].setUserID(newUser.UserID());
            users[userUsed].setPassword(newUser.getPassword());
                userUsed++;
        }
    }

    public void addBook(Book newBook) throws Exception {
        if(this.isThereAnyBook(newBook) == true) {
            throw new Exception("This book is already in Database");
        }

        if (this.bookUsed < books.length-1) {
            books[bookUsed].setBookName(newBook.getBookName());
            books[bookUsed].setBookCode(newBook.getBookCode());
            books[bookUsed].setPage(newBook.getPage());
            books[bookUsed].setAuthor(newBook.getAuthor());
            bookUsed++;

        } else {
            Book[] temp = new Book[bookUsed];
            //bookCapacity*=2;
           // temp = Arrays.copyOf(books, books.length);
            for(int i =0 ; i<bookUsed;i++){
                temp[i].setBookCode(books[i].getBookCode());
                temp[i].setBookName(books[i].getBookName());
                temp[i].setAuthor(books[i].getAuthor());
                temp[i].setPage(books[i].getPage());
                temp[i].setCount(books[i].getCount());
                temp[i].setAvailable(books[i].isAvailable());
            }

            books = null;
            books = new Book[bookUsed * 2];
            //books = Arrays.copyOf(temp, temp.length);
            for(int i =0 ; i<bookUsed;i++){
                books[i].setBookCode(temp[i].getBookCode());
                books[i].setBookName(temp[i].getBookName());
                books[i].setAuthor(temp[i].getAuthor());
                books[i].setPage(temp[i].getPage());
                books[i].setCount(temp[i].getCount());
                books[i].setAvailable(temp[i].isAvailable());
            }

            books[bookUsed].setBookName(newBook.getBookName());
            books[bookUsed].setBookCode(newBook.getBookCode());
            books[bookUsed].setPage(newBook.getPage());
            books[bookUsed].setAuthor(newBook.getAuthor());
            bookUsed++;

        }


    }

    public boolean isThereAnyBook(Book book) {

        for (int i = 0; i < bookUsed; i++) {
            if (books[i].equals(book) == true) return true;
        }

        return false;
    }


    public boolean isThereAnyMember(User user) {

        for (int i = 0; i < userUsed; i++) {
            if (users[i].equals(user) == true) return true;
        }
        return false;
    }

    public void deleteBook(Book delete) {
        int bookIndex = findBook(delete);

        books[bookIndex].setCount(0);
        books[bookIndex].setBookCode(null);
        books[bookIndex].setPage(0);
        books[bookIndex].setBookName(null);
        books[bookIndex].setAuthor(null);

        bookUsed--;
    }

    public int findBook(Book book) {
        for (int i = 0; i < bookUsed; i++) {
            if (books[i].equals(book) == true) {
                return i;
            }
        }
        return -1;
    }

    public Book getBook(Book book){
        if(this.isThereAnyBook(book) == true)
        {
            int i = findBook(book);

            if(i != -1)
                return books[i];
            else
                return null;
        }
        return null;
    }
    public Book getBook(int i){
        try{
            if(i <0 || i> bookUsed) {
                throw new ArrayIndexOutOfBoundsException("Invalid Index Value");
            }

                return books[i];
        }catch(ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
      return null;
    }

    public int findUser(User user){
        for(int i = 0; i<userUsed;i++){
            if(users[i].equals(user) == true){
                return i;
            }
        }
        return -1;
    }
    public User getUser(User user){
        if(this.isThereAnyMember(user) == true)
        {
            int i = findUser(user);

            if(i != -1)
                return users[i];
            else
                return null;
        }
        return null;
    }

    public void writeToFiletheRecords(){
        FileWriter writer = null;

        try{
            writer= new FileWriter("bookList.csv");
           for(int i=0; i<bookUsed;i++){
               writer.write(books[i].toString());
               writer.write('\n');
           }

        }catch(IOException e){
            e.printStackTrace();
        }finally {
            try{
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        writer=null;
        try{
            writer = new FileWriter("userList.csv");
            int i=0;
            while(i<userUsed){
                if(users[i] instanceof LibraryUser){
                writer.write(users[i].toString());
                writer.write('\n');}
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        writer=null;
        try{
            writer = new FileWriter("staffList.csv");
            int i=0;
            while(i<userUsed){
                if(users[i] instanceof LibraryStaff){
                    writer.write(users[i].toString());
                    writer.write('\n');}
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
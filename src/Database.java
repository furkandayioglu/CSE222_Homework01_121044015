/**
 * Created by furka on 19.02.2017.
 */

import java.io.*;
import java.util.Arrays;

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
    private Book[] books = new Book[40];
    private User[] users = new User[40];
    private int userCapacity = 40;
    private int bookCapacity = 40;
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
        int i = users.length;
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
        if (users.length < userCapacity) {
            users[users.length].setName(newUser.getName());
            users[users.length].setSurname(newUser.getSurname());
            users[users.length].setUserID(newUser.UserID());
            users[users.length].setPassword(newUser.getPassword());
        } else {
            User[] temp = new User[userCapacity * 2];
            temp = Arrays.copyOf(users, users.length);
            users = null;
            users = new User[userCapacity];
            users = Arrays.copyOf(temp, temp.length);
            users[users.length].setName(newUser.getName());
            users[users.length].setSurname(newUser.getSurname());
            users[users.length].setUserID(newUser.UserID());
            users[users.length].setPassword(newUser.getPassword());

        }
    }

    public boolean addBook(Book newBook) {
        if (isThereAnyBook(newBook) == true) {
            for (int i = 0; i < books.length; i++) {
                if (books[i].equals(newBook) == true) books[i].setCount(books[i].getCount() + 1);
            }


            return false;
        }


        if (books.length < bookCapacity) {
            books[books.length].setBookName(newBook.getBookName());
            books[books.length].setBookCode(newBook.getBookCode());
            books[books.length].setPage(newBook.getPage());
            books[books.length].setAuthor(newBook.getAuthor());
            return true;
        } else {
            Book[] temp = new Book[bookCapacity * 2];
            temp = Arrays.copyOf(books, books.length);
            books = null;
            books = new Book[bookCapacity * 2];
            books = Arrays.copyOf(temp, temp.length);
            books[books.length].setBookName(newBook.getBookName());
            books[books.length].setBookCode(newBook.getBookCode());
            books[books.length].setPage(newBook.getPage());
            books[books.length].setAuthor(newBook.getAuthor());
            return true;
        }

    }

    public boolean isThereAnyBook(Book book) {

        for (int i = 0; i < books.length; i++) {
            if (books[i].equals(book) == true) return true;
        }

        return false;
    }


    public boolean isThereAnyMember(User user) {

        for (int i = 0; i < users.length; i++) {
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
    }

    public int findBook(Book book) {
        for (int i = 0; i < books.length; i++) {
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
            if(i <0 || i> bookCapacity) {
                throw new ArrayIndexOutOfBoundsException("Invalid Index Value");
            }

                return books[i];
        }catch(ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
      return null;
    }
}
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
    private  int userCapacity = 40;
    private  int bookCapacity = 40;
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
                if (ourInstance == null)
                    ourInstance = new Database();// Singleton object
            }
        }
        return ourInstance;
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

    public void readBooksFromCsvFile( String filename){
        BufferedReader bookFile = null;
        String split = ",";
        String line = ""; // hail the brother mykyong
        // csv reading code is gotten there
        // https://www.mkyong.com/java/how-to-read-and-parse-csv-file-in-java/
        int i = 0;
        try {
            bookFile = new BufferedReader(new FileReader(filename));

            while ((line =bookFile.readLine()) != null) {
              Book temp = new Book();
                String[] userInfo = line.split(split);
                temp.
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
        if(users.length < userCapacity)
        {
            users[users.length].setName(newUser.getName());
            users[users.length].setSurname(newUser.getSurname());
            users[users.length].setUserID(newUser.UserID());
            users[users.length].setPassword(newUser.getPassword());
        }else{
            User[] temp = new User[userCapacity*2];
            temp = Arrays.copyOf(users,users.length);
            users = null;
            users = new User[userCapacity];
            users = Arrays.copyOf(temp,temp.length);
            users[users.length].setName(newUser.getName());
            users[users.length].setSurname(newUser.getSurname());
            users[users.length].setUserID(newUser.UserID());
            users[users.length].setPassword(newUser.getPassword());

        }
    }

   public void addBook(Book newBook){

   }
}

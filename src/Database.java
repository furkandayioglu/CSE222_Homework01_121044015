/**
 * Created by furka on 19.02.2017.
 */

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author Furkan Sergen Dayioglu
 * Course : CSE222 Data Structures and Algorithms
 * StudentID: 121044015
 */
public class Database {
    private Book[] books = new Book[40];
    private User[] users = new User[40];
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
     * @return singleton database object
     */
    public static Database getInstance() {

        if(ourInstance == null){
            synchronized (Database.class){ // for thread safety
                if(ourInstance == null)
                    ourInstance = new Database();// Singleton object
            }
        }
        return ourInstance;
    }

    public void readUserFromCSVFile(String filename){
        BufferedReader userFile = new BufferedReader(new FileReader(filename));

            try {
                userFile.
            }
    }

}

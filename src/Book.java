/**
 * Created by furka on 19.02.2017.
 */
/**
 * @author Furkan Sergen Dayioglu
 * Course : CSE222 Data Structures and Algorithms
 * StudentID: 121044015
 */
public class Book {

    private String  bookName;
    private String  Author;
    private String  bookCode;
    private int     page;
    private int     count; // Count of this book in database
    private boolean available; // true if the any copy more, false if there is no more copy available

    /**
     * No paramater Constructor
     * Creates an empty book
     */
    public Book(){
        this.setBookName(null);
        this.setAuthor(null);
        this.setPage(0);
        this.setCount(0);
        this.setAvailable(false);
        this.setBookCode(null);
    }

    /**
     * Create a new book
     * @param BookName To set Book's name
     * @param BookAuthor To set Book's Author
     * @param Page to set Page count of the book
     */
    public Book(String BookName,String BookAuthor,int Page){
        this.setBookName(BookName);
        this.setAuthor(BookAuthor);
        this.setPage(Page);
        this.setCount(1);
        this.setAvailable(true);
    }
    public Book(String BookName,String BookAuthor,int page, int count,boolean available){
        this.setBookName(BookName);
        this.setAuthor(BookAuthor);
        this.setPage(page);
        this.setCount(count);
        this.setAvailable(available);
    }

    public Book(String bookName, String author, String bookCode, int page, int count, boolean available) {
        this.bookName = bookName;
        Author = author;
        this.bookCode = bookCode;
        this.page = page;
        this.count = count;
        this.available = available;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isAvailable() {
        if (this.count >=1){
            this.available=true;
        }else{
            this.available=false;
        }

        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getBookCode(){ return this.bookCode;}

    public void   setBookCode(String code){ this.bookCode = code;}

    @Override
    public boolean equals(Object o) {
        if(this==o){
            return true;
        }
        if(this==null)
        {
            return false;
        }
        if(this.getClass() == o.getClass()){
            Book book = (Book) o;

            return((book.getBookName()== this.getBookName()) &&
                   (this.getAuthor()==book.getAuthor()) &&
                   (this.getPage()==book.getPage()));
        }else
            return false;
    }

    @Override
    public String toString() {
        String bookInfo = "Book Name : "+this.getBookName()+"\nBook Author : "+this.getAuthor()+"\nPage : "+this.getPage();
        return bookInfo;
    }
}

package Lab4;
import java.util.Objects;

public class Book {
    public String title;
    public String author;
    public int year;

    public Book(String title, String author, int year){
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String toString(){
        return "Название: " + title + "\nАвтор: " + author + "\nГод: " + year;
    }

    public boolean equals(Book book){
        return this.hashCode() == book.hashCode();
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.title, this.author, this.year);
    }
}

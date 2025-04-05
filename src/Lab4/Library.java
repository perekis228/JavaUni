package Lab4;

import java.util.*;

public class Library {
    public List<Book> books = new ArrayList<>();
    public Set<String> authors = new HashSet<>();
    public Map<String, Integer> author_books = new HashMap<>();

    public Library(){}

    public void addBook(Book book){
        this.books.add(book);
        this.authors.add(book.author);
        this.author_books.put(book.author, author_books.getOrDefault(book.author, 0) + 1);
    }

    public void removeBook(Book book){
        this.books.remove(book);
        this.author_books.put(book.author, author_books.get(book.author) - 1);
        if (author_books.get(book.author) == 0){
            authors.remove(book.author);
            author_books.remove(book.author);
        }
    }

    public List<Book> findBooksByAuthor(String author){
        List<Book> cur_books = new ArrayList<>();
        for (int i = 0; i < this.books.size(); i++){
            Book cur_book = this.books.get(i);
            if (cur_book.author.equals(author)){
                cur_books.add(cur_book);
            }
        }
        return cur_books;
    }

    public List<Book> findBooksByYear(int year) {
        List<Book> cur_books = new ArrayList<>();
        for (int i = 0; i < this.books.size(); i++){
            Book cur_book = this.books.get(i);
            if (cur_book.year == year){
                cur_books.add(cur_book);
            }
        }
        return cur_books;
    }
    public void printAllBooks(){
        for (int i = 0; i < this.books.size(); i++){
            System.out.println(this.books.get(i).toString() + "\n");
        }
    }

    public void printUniqueAuthors(){
        for (String author : this.authors) {
            System.out.println(author);
        }
    }
    public void printAuthorStatistics(){
        for (String author : this.authors) {
            System.out.println(author + ": " + author_books.get(author));
        }
    }
}

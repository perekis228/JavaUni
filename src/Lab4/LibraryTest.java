package Lab4;

import java.util.List;

public class LibraryTest {
    public static void main(String[] args) {
        Library library = new Library();

        Book del_book = new Book("Название 0.1", "Автор 1", 1900);
        library.addBook(del_book);
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                library.addBook(new Book("Название "+i+"."+j, "Автор "+i, 1900+j));
            }
        }

        library.removeBook(del_book);

        System.out.println("\tВсе книги Автора 1:");
        List<Book> books = library.findBooksByAuthor("Автор 1");
        for (int i = 0; i < books.size(); i++){
            System.out.println(books.get(i).toString() + "\n");
        }
        System.out.println("-".repeat(50));

        System.out.println("\tВсе книги 1903 года:");
        books = library.findBooksByYear(1903);
        for (int i = 0; i < books.size(); i++){
            System.out.println(books.get(i).toString() + "\n");
        }
        System.out.println("-".repeat(50));

        System.out.println("\tВсе книги:");
        library.printAllBooks();
        System.out.println("-".repeat(50));

        System.out.println("\tВсе авторы:");
        library.printUniqueAuthors();
        System.out.println("-".repeat(50));

        System.out.println("\tАвтор и количество написанных им книг:");
        library.printAuthorStatistics();
    }
}

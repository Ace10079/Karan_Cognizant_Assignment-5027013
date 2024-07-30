import java.util.Arrays;
import java.util.Comparator;

class Book {
    private String bookId;
    private String title;
    private String author;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    @Override
    public String toString() {
        return "Book [ID=" + bookId + ", Title=" + title + ", Author=" + author + "]";
    }
}

public class LibraryManagement {

    public static Book linearSearch(Book[] books, String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public static Book binarySearch(Book[] books, String title) {
        Arrays.sort(books, Comparator.comparing(Book::getTitle));
        int left = 0, right = books.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = title.compareToIgnoreCase(books[mid].getTitle());
            if (cmp == 0) return books[mid];
            if (cmp > 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book("601", "The Catcher in the Rye", "J.D. Salinger"),
            new Book("602", "To Kill a Mockingbird", "Harper Lee"),
            new Book("603", "1984", "George Orwell")
        };

        // Linear Search
        Book result = linearSearch(books, "1984");
        System.out.println("Linear Search Result: " + (result != null ? result : "Book not found"));

        // Binary Search
        result = binarySearch(books, "To Kill a Mockingbird");
        System.out.println("Binary Search Result: " + (result != null ? result : "Book not found"));
    }
}

package casestudy7classassinement;

import java.util.*;

class Book {
    String isbn;
    String title;
    String author;
    boolean isAvailable;

    Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String toString() {
        return isbn + " | " + title + " | " + author + " | " +
                (isAvailable ? "Available" : "Checked Out");
    }
}

class Library {
    List<Book> books = new ArrayList<>();

    void addBook(Book book) {
        books.add(book);
    }

    void borrowBook(String isbn) {
        for (Book b : books) {
            if (b.isbn.equals(isbn)) {
                if (b.isAvailable) {
                    b.isAvailable = false;
                    System.out.println("Success!");
                } else {
                    System.out.println("Sorry, this book is currently checked out.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    void returnBook(String isbn) {
        for (Book b : books) {
            if (b.isbn.equals(isbn)) {
                b.isAvailable = true;
                System.out.println("Book returned.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    void displayAvailableBooks() {
        for (Book b : books) {
            if (b.isAvailable) {
                System.out.println(b);
            }
        }
    }

    void displayAllBooks() {
        for (Book b : books) {
            System.out.println(b);
        }
    }
}

class DigitalBookshelf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        library.addBook(new Book("978-01", "Java Basics", "John Doe"));
        library.addBook(new Book("978-02", "OOP Concepts", "Jane Smith"));
        library.addBook(new Book("978-03", "Data Structures", "Mark Lee"));

        while (true) {
            System.out.println("1.View All Books");
            System.out.println("2.Borrow Book");
            System.out.println("3.Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    library.displayAllBooks();
                    break;

                case 2:
                    System.out.print("Enter ISBN: ");
                    String isbn = sc.nextLine();
                    library.borrowBook(isbn);
                    break;

                case 3:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
package casestudy1;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("Java Programming", "James Gosling", "1111");
        Book book2 = new Book("Data Structures", "Mark Allen Weiss", "2222");
        Book book3 = new Book("Operating Systems", "Galvin", "3333");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        library.displayAllBooks();

        System.out.println("Searching for 'Data Structures'...\n");
        Book foundBook = library.searchByTitle("Data Structures");

        if (foundBook != null) {
            System.out.println("Book Found:");
            foundBook.displayBook();
        } else {
            System.out.println("Book not found.");
        }
    }
}

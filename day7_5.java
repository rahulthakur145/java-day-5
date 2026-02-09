public class day7_5 {
    public static void main(String[] args) {
        Library lib = new Library();

        lib.addBook(new Book("Java", "James Gosling", "111"));
        lib.addBook(new Book("Python", "Guido", "222"));

        Book found = lib.searchByTitle("Java");
        if (found != null) {
            found.displayBook();
        }

        lib.displayAllBooks();
    }
}

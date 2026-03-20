package casestudy7;

abstract class LibraryItem {
    private String itemId;
    private String title;
    protected boolean isReserved = false;

    public LibraryItem(String itemId, String title) {
        this.itemId = itemId;
        this.title = title;
    }

    public String getItemId() { return itemId; }
    public String getTitle() { return title; }

    public void showDetails() {
        System.out.println("ID: " + itemId + " | Title: " + title);
    }

    public abstract void processLoan();
}

class TextBook extends LibraryItem {
    public TextBook(String itemId, String title) {
        super(itemId, title);
    }

    @Override
    public void processLoan() {
        if (!isReserved) {
            isReserved = true;
            System.out.println("Textbook '" + getTitle() + "' issued. Hardcopy issued for 14 days.");
        } else {
            System.out.println("Error: '" + getTitle() + "' is already on loan.");
        }
    }
}

class ResearchPaper extends LibraryItem {
    public ResearchPaper(String itemId, String title) {
        super(itemId, title);
    }

    @Override
    public void processLoan() {
        System.out.println("Research Paper '" + getTitle() + "': Generating secure PDF download link...");
    }
}

public class case_4 {
    public static void main(String[] args) {
        System.out.println("--- Test Case 1 ---");
        LibraryItem book = new TextBook("B101", "Java Core");
        book.processLoan();

        System.out.println("\n--- Test Case 2 ---");
        book.processLoan();

        System.out.println("\n--- Test Case 3 ---");
        LibraryItem paper = new ResearchPaper("R99", "AI Ethics");
        paper.processLoan();
        
        System.out.println("\n--- Archive Details ---");
        book.showDetails();
        paper.showDetails();
    }
}
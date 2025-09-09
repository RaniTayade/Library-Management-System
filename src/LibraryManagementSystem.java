import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        ArrayList<Book> library = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        // Sample books
        library.add(new Book(1, "Java Basics", "James Gosling"));
        library.add(new Book(2, "Python Programming", "Guido van Rossum"));
        library.add(new Book(3, "C++ Fundamentals", "Bjarne Stroustrup"));

        int choice;
        do {
            System.out.println("\n==== Library Menu ====");
            System.out.println("1. View Books");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Search Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("\n Available Books:");
                    for (Book b : library) {
                        System.out.println(b);
                    }
                    break;

                case 2:
                    System.out.print("Enter book ID to borrow: ");
                    int borrowId = sc.nextInt();
                    boolean borrowed = false;
                    for (Book b : library) {
                        if (b.getId() == borrowId && b.isAvailable()) {
                            b.borrowBook();
                            System.out.println(" You borrowed: " + b.getTitle());
                            borrowed = true;
                            break;
                        }
                    }
                    if (!borrowed) {
                        System.out.println(" Book not available or invalid ID.");
                    }
                    break;

                case 3:
                    System.out.print("Enter book ID to return: ");
                    int returnId = sc.nextInt();
                    boolean returned = false;
                    for (Book b : library) {
                        if (b.getId() == returnId && !b.isAvailable()) {
                            b.returnBook();
                            System.out.println(" You returned: " + b.getTitle());
                            returned = true;
                            break;
                        }
                    }
                    if (!returned) {
                        System.out.println(" Invalid book ID or book not borrowed.");
                    }
                    break;

                case 4:
                    System.out.print("Enter keyword to search (title/author): ");
                    String keyword = sc.nextLine().toLowerCase();
                    boolean found = false;
                    for (Book b : library) {
                        if (b.getTitle().toLowerCase().contains(keyword) ||
                                b.getAuthor().toLowerCase().contains(keyword)) {
                            System.out.println(b);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println(" No books found with that keyword.");
                    }
                    break;

                case 5:
                    System.out.println(" Exiting...");
                    break;

                default:
                    System.out.println(" Invalid choice.");
            }
        } while (choice != 5);

        sc.close();
    }
}

// 👇 Book class
class Book {
    private int id;
    private String title;
    private String author;
    private boolean available;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void borrowBook() {
        if (available) {
            available = false;
        }
    }

    public void returnBook() {
        available = true;
    }

    @Override
    public String toString() {
        return id + ". " + title + " by " + author + (available ? " (Available)" : " (Borrowed)");
    }
}

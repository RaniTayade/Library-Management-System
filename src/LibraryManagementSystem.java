import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private int id;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return isAvailable; }

    public void borrowBook() { this.isAvailable = false; }
    public void returnBook() { this.isAvailable = true; }

    @Override
    public String toString() {
        return id + ". " + title + " by " + author + " [" + (isAvailable ? "Available" : "Not Available") + "]";
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        ArrayList<Book> library = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        // Add some books initially
        library.add(new Book(1, "Java Basics", "James Gosling"));
        library.add(new Book(2, "Python Programming", "Guido van Rossum"));
        library.add(new Book(3, "C++ Fundamentals", "Bjarne Stroustrup"));

        System.out.println(" Welcome to Library Management System");
        System.out.println("Books Available:");
        for (Book b : library) {
            System.out.println(b);
        }
    }
}

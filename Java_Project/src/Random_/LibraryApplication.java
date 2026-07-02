package Random_;

import java.util.ArrayList;
import java.util.List;

// 1. Student Class
class Student {
    private String name;
    private String srn;
    private String mobileNum;

    // Parameterized constructor
    public Student(String name, String srn, String mobileNum) {
        this.name = name;
        this.srn = srn;
        this.mobileNum = mobileNum;
    }

    // Display method
    public void display() {
        System.out.println("Student Name: " + name + ", SRN: " + srn + ", Mobile: " + mobileNum);
    }

    public String getName() {
        return name;
    }
}

// 2. Book Class
class Book {
    private String title;
    private String publisher;
    private Student studentIssuedTo; // Association: Book knows which Student it is issued to

    // Parameterized constructor
    public Book(String title, String publisher) {
        this.title = title;
        this.publisher = publisher;
        this.studentIssuedTo = null; // Null by default when not issued
    }

    // Display method
    public void display() {
        System.out.print("Book Title: '" + title + "', Publisher: " + publisher);
        if (studentIssuedTo != null) {
            System.out.println(" | Status: Issued");
            System.out.print("   -> ");
            studentIssuedTo.display();
        } else {
            System.out.println(" | Status: Available");
        }
    }

    // Getters and Setters for issuance
    public Student getStudentIssuedTo() {
        return studentIssuedTo;
    }

    public void setStudentIssuedTo(Student studentIssuedTo) {
        this.studentIssuedTo = studentIssuedTo;
    }

    public String getTitle() {
        return title;
    }
}

// 3. Library Class
class Library {
    private String collegeName;
    private String librarian;
    private List<Book> books; // Aggregation: Library has a collection of Books

    // Parameterized constructor
    public Library(String collegeName, String librarian) {
        this.collegeName = collegeName;
        this.librarian = librarian;
        this.books = new ArrayList<>();
    }

    // Method to add books to the library inventory
    public void addBook(Book book) {
        books.add(book);
    }

    // Method to issue a book to a student
    public void issueBook(Book book, Student student) {
        if (books.contains(book)) {
            if (book.getStudentIssuedTo() == null) {
                book.setStudentIssuedTo(student);
                System.out.println("Success: '" + book.getTitle() + "' has been issued to " + student.getName() + ".");
            } else {
                System.out.println("Error: '" + book.getTitle() + "' is already issued to someone else.");
            }
        } else {
            System.out.println("Error: This book does not belong to " + collegeName + " library.");
        }
    }

    // Method to display a list of all issued books
    public void displayIssuedBooks() {
        System.out.println("\n--- Issued Books at " + collegeName + " (Librarian: " + librarian + ") ---");
        boolean found = false;

        for (Book book : books) {
            if (book.getStudentIssuedTo() != null) {
                book.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books are currently issued.");
        }
        System.out.println("---------------------------------------------------------");
    }
}

// 4. Main Execution Class
public class LibraryApplication {
    public static void main(String[] args) {
        // Create a Library
        Library myLibrary = new Library("Tech University", "Mr. Smith");

        // Create some Books
        Book book1 = new Book("Introduction to Java", "O'Reilly");
        Book book2 = new Book("Data Structures", "Pearson");
        Book book3 = new Book("Operating Systems", "Wiley");

        // Add books to the Library
        myLibrary.addBook(book1);
        myLibrary.addBook(book2);
        myLibrary.addBook(book3);

        // Create some Students
        Student student1 = new Student("Alice Johnson", "SRN101", "555-0101");
        Student student2 = new Student("Bob Smith", "SRN102", "555-0102");

        // Issue books to students
        myLibrary.issueBook(book1, student1);
        myLibrary.issueBook(book3, student2);

        // Attempt to issue an already issued book
        myLibrary.issueBook(book1, student2);

        // Display the list of issued books
        myLibrary.displayIssuedBooks();

    }
}
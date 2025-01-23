package com.ASS2;
import java.io.*;
import java.util.*;
// Class: Book
class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    private int bookId;
    private String title;
    private boolean isIssued;

    public Book(int bookId, String title) {
        this.bookId = bookId;
        this.title = title;
        this.isIssued = false;
    }
    public int getBookId() {
        return bookId;
    }
    public String getTitle() {
        return title;
    }
    public boolean isIssued() {
        return isIssued;
    }
    public void issue() {
        isIssued = true;
    }
    public void returnBook() {
        isIssued = false;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId + ", Title: " + title + ", Issued: " + isIssued;
    }
}

// Class: Member
class Member implements Serializable {
    private static final long serialVersionUID = 1L;
    private int memberId;
    private String name;

    public Member(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Member ID: " + memberId + ", Name: " + name;
    }
}

// Class: Library
class Library {
    private List<Book> books = new ArrayList<>();
    private List<Member> members = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book);
    }

    public void addMember(Member member) {
        members.add(member);
        System.out.println("Member added: " + member);
    }

    public void issueBook(int bookId, int memberId) {
        Book book = findBook(bookId);
        if (book != null && !book.isIssued()) {
            book.issue();
            System.out.println("Book issued to Member ID: " + memberId);
        } else {
            System.out.println("Book is already issued or not found.");
        }
    }

    public void returnBook(int bookId) {
        Book book = findBook(bookId);
        if (book != null && book.isIssued()) {
            book.returnBook();
            System.out.println("Book returned.");
        } else {
            System.out.println("Book not issued or not found.");
        }
    }

    public void saveData(String filename) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(books);
            out.writeObject(members);
        }
        System.out.println("Data saved to file: " + filename);
    }

    public void loadData(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            books = (List<Book>) in.readObject();
            members = (List<Member>) in.readObject();
        }
        System.out.println("Data loaded from file: " + filename);
    }

    private Book findBook(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }
}

// Main Class
public class a11 {
    public static void main(String[] args) {
        Library library = new Library();
        try {
            // Adding books and members
            library.addBook(new Book(1, "Hindi"));
            library.addBook(new Book(2, "Telugu"));
            library.addMember(new Member(101, "Vamsi"));
            library.addMember(new Member(102, "Anish"));

            // Issuing and returning books
            library.issueBook(2, 99);
            library.returnBook(9);

            // Saving and loading data
            library.saveData("library_data.ser");
            library.loadData("library_data.ser");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

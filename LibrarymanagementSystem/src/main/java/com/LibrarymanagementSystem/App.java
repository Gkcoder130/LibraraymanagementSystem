package com.LibrarymanagementSystem;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        BookDao dao = new BookDao();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Update Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    System.out.print("Year: ");
                    int year = sc.nextInt();
                    sc.nextLine();
                    dao.addBook(new Book(title, author, year));
                    System.out.println("Book added!");
                    break;
                case 2:
                    List<Book> books = dao.getAllBooks();
                    for (Book b : books) {
                        System.out.println(b.getId() + ": " + b.getTitle() + " by " + b.getAuthor() + " (" + b.getYear() + ")");
                    }
                    break;
                case 3:
                    System.out.print("Enter Book ID to update: ");
                    Long updateId = sc.nextLong();
                    sc.nextLine();
                    Book updateBook = new Book();
                    updateBook.setId(updateId);
                    System.out.print("New Title: ");
                    updateBook.setTitle(sc.nextLine());
                    System.out.print("New Author: ");
                    updateBook.setAuthor(sc.nextLine());
                    System.out.print("New Year: ");
                    updateBook.setYear(sc.nextInt());
                    sc.nextLine();
                    dao.updateBook(updateBook);
                    System.out.println("Book updated!");
                    break;
                case 4:
                    System.out.print("Enter Book ID to delete: ");
                    Long deleteId = sc.nextLong();
                    sc.nextLine();
                    dao.deleteBook(deleteId);
                    System.out.println("Book deleted!");
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
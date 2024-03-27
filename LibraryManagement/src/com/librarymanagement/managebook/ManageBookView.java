package com.librarymanagement.managebook;


import java.util.Scanner;

import com.librarymanagement.LibraryManagement2024;
import com.librarymanagement.home.HomeView;
import com.librarymanagement.models.Book;


public class ManageBookView {

    private ManageBookModel manageBookModel;
    Scanner sc = new Scanner(System.in);

    public ManageBookView() {
        this.manageBookModel = new ManageBookModel(this);
    }

    public void init() {
        startMenuShow();
    }

    public void showMessage(String message) {
        System.out.println(message);
        // startMenuShow();
    }

    public void startMenuShow() {
        do {
            LibraryManagement2024.getInstance().clear();
            System.out.println("\t\t\t\tBook Details");
            System.out.println("1. Added Book");
            System.out.println("2. Show Book List");
            System.out.println("3. Edit Book");
            System.out.println("4. Search Book by Book Id");
            System.out.println("5. Search Book by Book Name");
            System.out.println("6. Back <--- <--");
            System.out.println("7. logout");
            int n = sc.nextInt();
            switch (n) {
                case 1: {
                    bookUserGet();
                    break;
                }
                case 2: {
                    manageBookModel.bookListShow();

                    break;
                }
                case 3: {
                    editBookCount();
                    break;
                }
                case 4: {
                    System.out.println("Enter the Book Id(For Search):");
                    int booksearchId = sc.nextInt();
                    manageBookModel.bookGetById(booksearchId);
                    break;
                }
                case 5: {
                    sc.nextLine();
                    System.out.println("Enter the Book Name / Author Name:");
                    String booksearchName = sc.nextLine();
                    manageBookModel.bookSearchGet(booksearchName);
                    break;
                }
                case 6: {
                    new HomeView().homeInit();
                    break;
                }
                case 7: {
                    manageBookModel.logout();
                    return;
                }
                default: {
                    System.out.println("Choice the Correct  Option");
                    System.exit(0);
                }

            }
        } while (true);

    }

    public void bookUserGet() {
        System.out.println("\t\t\t\t New Book Add");
        sc.nextLine();
        System.out.println("Book Name:");
        String name = sc.nextLine();
        System.out.println("Author Name:");
        String author = sc.nextLine();
        System.out.println("Publication Name:");
        String publication = sc.nextLine();
        System.out.println("Edition:");
        String edition = sc.nextLine();
        System.out.println("Journey Name:");
        String journey = sc.nextLine();
        System.out.println("Available Count:");
        int count = sc.nextInt();
        System.out.println("Book Volume:");
        int volume = sc.nextInt();
        int libraryId=manageBookModel.libraryIdCheckUser();
       manageBookModel. libraryIdCheck(name, author, publication, edition, journey, count, volume, libraryId);
            }
public int libraryGetId()
{
    System.out.println("Enter the Library ID for the book:");
    int libraryId = sc.nextInt();
    return libraryId;
}

    public void editBookCount() {
        System.out.println("Edit Book Count");
        System.out.println("Enter the Book ID to edit count:");
        int bookId = sc.nextInt();
        manageBookModel.getBookById(bookId);
    }

    public void updateGetCount(Book book) {
        System.out.println("Enter the additional count for the book:");
        int additionalCount = sc.nextInt();
        manageBookModel.updateCountBooks(book, additionalCount);
    }

    public void addBookinList(Book book) {
        manageBookModel.bookAdd(book);
    }

}

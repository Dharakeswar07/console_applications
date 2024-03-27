package com.librarymanagement.managebook;

import java.util.ArrayList;
import java.util.List;

import com.librarymanagement.db.LibraryDatabase;
import com.librarymanagement.logout.Logout;
import com.librarymanagement.models.Book;
import com.librarymanagement.models.Library;
import com.librarymanagement.models.SessionStore;

public class ManageBookModel {

    private ManageBookView manageBookView;
    private Logout logout;
    private List<Book>  bookList;
    private Library library;
    private SessionStore sessionStore;

    LibraryDatabase libraryDatabase = LibraryDatabase.getInstance();
    public ManageBookModel(ManageBookView manageBookView) {
        this.manageBookView = manageBookView;
        sessionStore=SessionStore.getInstance();
    }

    public void startOnBook()
    {
        if(bookList ==null)
        {
            bookList=new ArrayList<>();
            manageBookView.startMenuShow();
        }
    }

    public void bookAdd(Book book)
    {
            libraryDatabase.addBook(book);
        int bookCount=0;
           Library library=libraryDatabase.libraryCountUpdate(book.getLibraryId());
           bookCount+= library.getBookCount();
           bookCount+=book.getAvailableCount();
           library.setBookCount(bookCount);
           LibraryDatabase.getInstance().exportBookList();
            manageBookView.showMessage("Book Added SuccessFully");
    }

    public void bookListShow() {
         bookList = libraryDatabase.getbookList();

         manageBookView.showMessage(Book.getTitle());
    for (Book book : bookList) {    
        manageBookView.showMessage(book.toString());
    }
    }

    public void getBookById(int bookId) {
        Book book = libraryDatabase.getBookById(bookId);
        if (book != null) {
            manageBookView.updateGetCount(book);
        }
        else
        {
            manageBookView.showMessage("Book with ID " + bookId + " not found.");
        }
    }

    public void updateCountBooks(Book book, int additionalCount) {
        int currentCount = book.getAvailableCount();
        int newCount = currentCount + additionalCount;
        int bookCount=0;
        Library library=libraryDatabase.libraryCountUpdate(book.getLibraryId());
        bookCount+= library.getBookCount()+additionalCount;
        library.setBookCount(bookCount);
        book.setAvailableCount(newCount);
        manageBookView.showMessage("Book count updated successfully.");
    }

    public void libraryIdCheck(String name,String author,String publication,String edition,String journey,int count,int volume,int libraryId) {
        LibraryDatabase database = LibraryDatabase.getInstance();
        int lastBookId = database.getbookList().stream().mapToInt(Book::getId).max().orElse(0);
        int bookId = lastBookId + 1;
        Book book = new Book(bookId,name, author, publication, edition, journey, count, volume, libraryId);
         Library library = LibraryDatabase.getInstance().searchLibrary(book.getLibraryId());
         if (library != null) {
            manageBookView.addBookinList(book);
        } else {
            manageBookView.showMessage("Library with ID " + book.getLibraryId() + " not found.");
        }
    }

    public void bookSearchGet(String booksearchName) {
        List<Book> searchBookList = libraryDatabase.getBookByNameOrAuthor(booksearchName);
        manageBookView.showMessage(Book.getTitle());
        for (Book book : searchBookList) {
            manageBookView.showMessage(book.toString());
        }
    }

    public void bookGetById(int booksearchId) {
        manageBookView.showMessage(Book.getTitle());
        manageBookView.showMessage(libraryDatabase.getBookById(booksearchId).toString());
    }
    public void logout() {
        manageBookView.showMessage("\u001B[31mUser has been Logout...........\u001B[0m");
        logout.logout();
    }


    public int libraryIdCheckUser() {
String role=sessionStore.getRole();
if(role.equals("Admin"))
{
    return manageBookView.libraryGetId();
}
else
{
    return sessionStore.getLibraryId();
}
    }
}

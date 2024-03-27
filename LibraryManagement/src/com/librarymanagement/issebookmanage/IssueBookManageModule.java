package com.librarymanagement.issebookmanage;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.librarymanagement.db.LibraryDatabase;
import com.librarymanagement.logout.Logout;
import com.librarymanagement.models.*;

public class IssueBookManageModule {
    private Logout logout;
    private IssueBookManageView issueBookManageView;
    private  LibraryDatabase libraryDatabase = LibraryDatabase.getInstance();
private SessionStore sessionStore;

public IssueBookManageModule(IssueBookManageView issueBookManageView)
{
    this.issueBookManageView=issueBookManageView;
    sessionStore=SessionStore.getInstance();
}

public void addIssueBooks(int bookId,int customerId, String status) {
    Date issueDate = new Date(); // Current date
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(issueDate);
// Add 10 days
    calendar.add(Calendar.DAY_OF_MONTH, 10);
// Get the Date object representing the return date
    Date returnDate = calendar.getTime();
    LibraryDatabase database = LibraryDatabase.getInstance();
    int lastIssueId = database.getIssuedBooksList().stream().mapToInt(IssuedBooks::getIssueId).max().orElse(0);
    int issueId = lastIssueId + 1;
    IssuedBooks issuedBooks = new IssuedBooks(issueId,bookId, customerId, issueDate, returnDate, status);
    libraryDatabase.issueBooksAdd(issuedBooks);
    Customer customer=libraryDatabase.getCustomerById(customerId);
customer.setIssueBookCount(customer.getIssueBookCount()+1);
LibraryDatabase.getInstance().exportIssuedBookList();
    issueBookManageView.showAlert("Book issued successfully.");
}

public void showIssuedBooksList() {
    List<IssuedBooks> issuedBooksList = libraryDatabase.getIssuedBooksList();
    issueBookManageView.showAlert(IssuedBooks.getIssuedBooksTitle());
        for (IssuedBooks issuedBook : issuedBooksList) {
            issueBookManageView.showAlert(issuedBook.toString());
        }
}

public void overdueBooksList() {
  List<IssuedBooks> issuedBooksList = LibraryDatabase.getInstance().getIssuedBooksList();
        Date currentDate = new Date();
        
        for (IssuedBooks issuedBooks : issuedBooksList) {
            Date returnDate = issuedBooks.getReturnDate();
            if (returnDate.before(currentDate)) {
                // Book is overdue
                issueBookManageView.showAlert("Issue ID: " + issuedBooks.getIssueId() + "\n" +
                          "Book ID: " + issuedBooks.getBookId() + "\n" +
                          "Customer ID: " + issuedBooks.getcustomerId() + "\n" +
                          "Issue Date: " + issuedBooks.getIssueDate() + "\n" +
                          "Return Date: " + returnDate + "\n");
            }
        }
}

public void getbookById(int issueId) {
    int libraryId=sessionStore.getLibraryId();
    String role=sessionStore.getRole();
    IssuedBooks bookToReturn = null;
    if(role.equals("Admin"))
    {
        // Find the book in the issued books list
        for (IssuedBooks issuedBook : libraryDatabase.getIssuedBooksList()) {
            if (issuedBook.getIssueId() == issueId) {
                bookToReturn = issuedBook;
                break;
            }
        }
    }
    else
    {
        // Find the book in the issued books list
        for (IssuedBooks issuedBook : libraryDatabase.getIssuedBooksList()) {
            if (issuedBook.getIssueId() == issueId) {
              int libraryGetId= LibraryDatabase.getInstance().getLibraryByBookId(issuedBook.getBookId());
              if(sessionStore.getLibraryId()==libraryGetId)
              {
                  bookToReturn = issuedBook;
              }
                break;
            }
        }
    }

    Date returnDate=new Date();
    if (bookToReturn != null) {
        bookToReturn.setStatus("Returned");
        bookToReturn.setReturnDate(returnDate);
        LibraryDatabase.getInstance().exportBookList();
        LibraryDatabase.getInstance().exportLibraryList();
        LibraryDatabase.getInstance().exportCustomerList();
        issueBookManageView.showAlert(" Issue  ID " + issueId + "  Book has been returned.");
    } else {
        issueBookManageView.showAlert("Issue  ID " + issueId + " was not found or has already been returned.");
    }
}


public boolean isBookAvailable(int bookId) {
    int libraryId=sessionStore.getLibraryId();
    String role=sessionStore.getRole();
    List<Book> bookList = LibraryDatabase.getInstance().getbookList();
    if(role.equals("Admin")) {
        for (Book book : bookList) {
            if (book.getId() == bookId) {
                return true; // Book exists
            }
        }
    }
    else
    {
        for (Book book : bookList) {
            if (book.getId() == bookId && book.getLibraryId()==libraryId) {
                return true; // Book exists
            }
        }
    }
    return false; // Book does not exist
}

public boolean isCustomerExists(int customerId) {
    List<Customer> customerList = LibraryDatabase.getInstance().getCustomerList();
    for (Customer customer : customerList) {
        if (customer.getCustomerId() == customerId) {
            return true; // Customer exists
        }
    }
    return false; // Customer does not exist
}

public boolean checkBookById(int bookId) {
    if (!isBookAvailable(bookId)) {
        issueBookManageView.showAlert("Book with ID " + bookId + " does not Found . Please try again.");
        return false; // Exit the method
    }
    else
    {
        issueBookManageView.showAlert("Available Book Count: "+isBookAvailableCount(bookId));
        return true;
    }
}

    public  int isBookAvailableCount(int bookId) {
        List<Book> bookList = LibraryDatabase.getInstance().getbookList();

            for (Book book : bookList) {
                if (book.getId() == bookId) {
                    return book.getAvailableCount();

                }
            }
        return 0;
    }

    public boolean checkCustomerById(int customerId) {
    if (!isCustomerExists(customerId)) {
        issueBookManageView.showAlert("Customer with ID " + customerId + " does not exist. Please try again.");
        return false; // Exit the method
    }
    else
    {
issueBookManageView.showAlert("The Customer's Issued Count: "+customerIssuedBook(customerId));
return  true;
    }
}
    public  int  customerIssuedBook(int customerId) {
        List<Customer> customerList= LibraryDatabase.getInstance().getCustomerList();
        for (Customer customer : customerList) {
            if (customer.getCustomerId() == customerId) {
                return customer.getIssueBookCount();
            }
        }
        return 0;
    }
    public void logout() {
        issueBookManageView.showAlert("\u001B[31mUser has been Logout...........\u001B[0m");
        logout.logout();
    }
}

package com.librarymanagement.db;

import java.util.ArrayList;
import java.util.List;


import com.librarymanagement.models.Admin;
import com.librarymanagement.models.Book;
import com.librarymanagement.models.Creditantials;
import com.librarymanagement.models.Customer;
import com.librarymanagement.models.IssuedBooks;
import com.librarymanagement.models.Library;
import com.librarymanagement.jsonConvert.JsonModule;
public class LibraryDatabase {

    private static LibraryDatabase libraryDatabase;
    private JsonModule jsonModule;
    private List<Creditantials> creditantialsList = new ArrayList<>();
    private List<Admin> adminList = new ArrayList<>();
  private List<IssuedBooks> issuedBooksList = new ArrayList<>();
    private List<Book> bookList = new ArrayList<>();
    private List<Library> libraryList=new ArrayList<>();
    private List<Customer> customerList=new ArrayList<>();
    private Library library;

    public static LibraryDatabase getInstance() {
        if (libraryDatabase == null) {
            libraryDatabase = new LibraryDatabase();
        }
        return libraryDatabase;
    }

    // Library Manage Module Data's
    // Start--------------------------------------------------------------------------------------------->
    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        libraryList.add(library);
    }

    public void updateLibrary(Library updatedLibrary) {
        this.library = updatedLibrary;
    }

    public List<Library> getLibraryList()
    {
        return libraryList;
    }


    private LibraryDatabase() {
        jsonModule = JsonModule.getInstance(); // Initialize the jsonModule field
    }
    public Library searchLibrary(int libraryId) {
        for (Library library : libraryList) {
            if (library.getLibraryId() == libraryId) {
                return library;
            }
        }
        return null;
    }
public Library libraryCountUpdate(int libraryId)
{
    for (Library library : libraryList) {
        if (library.getLibraryId() == libraryId) {
          return library;
        }
    }
    return null;
}

    public void deleteLibrary(int libraryId) {
        
        Library libraryToRemove = null;
        for (Library library : libraryList) {
            if (library.getLibraryId() == libraryId) {
                libraryToRemove = library;
                break;
            }
        }
        if (libraryToRemove != null) {
            libraryList.remove(libraryToRemove);
        } else {
            System.out.println("Library with ID " + libraryId + " not found.");
        }
    }

    // Library Manage Module Data
    // End--------------------------------------------------------------------------------------------------->

    // Book Manage Module Data's
    // Start--------------------------------------------------------------------------------------------->

    public void addBook(Book book) {
        bookList.add(book);
    }


    public List<Book> getbookList() {
        return bookList;
    }

    public Book getBookById(int bookId) {
        for (Book books : bookList) {
            if (books.getId() == bookId) {
                return books;
            }
        }
        return null;
    }

    public List<Book>  getBookByNameOrAuthor(String searchTerm) {
        List<Book> searchResult = new ArrayList<>();
    String searchTermLowerCase = searchTerm.toLowerCase(); // Convert search term to lowercase
    for (Book book : bookList) {
        String bookNameLowerCase = book.getName().toLowerCase(); // Convert book name to lowercase
        String authorLowerCase = book.getAuthor().toLowerCase(); // Convert author name to lowercase
        if (bookNameLowerCase.contains(searchTermLowerCase) || authorLowerCase.contains(searchTermLowerCase)) {
            searchResult.add(book);
        }
    }
    return searchResult;
    }

    public void setbookList(List<Book> bookList) {
        this.bookList = bookList;
    }


    // Book Manage Module Data's
    // End--------------------------------------------------------------------------------------------->

    // Customer Manage Module Data's
    // Start--------------------------------------------------------------------------------------------->

    public void addCustomer(Customer customer)
    {
        customerList.add(customer);
    }

public List<Customer> getCustomerList()
{
    return customerList;
}

public Customer getCustomerById(int customerId)
{
    for(Customer customer:customerList)
    {
        if(customer.getCustomerId()==customerId)
        {
        return customer;
        }
}
return null;
}

public void deleteCustomer(int customerId) {
    Customer custoemrToRemove = null;
    for (Customer customer : customerList) {
        if (customer.getCustomerId() == customerId) {
            custoemrToRemove = customer;
            break;
        }
    }
    if (custoemrToRemove != null) {
        customerList.remove(custoemrToRemove);
    } else {
        System.out.println("Library with ID " + customerId + " not found.");
    }
}

    public List<Customer>  getCustomerByNameOrAuthor(String searchTerm) {
        List<Customer> searchResult = new ArrayList<>();
    String searchTermLowerCase = searchTerm.toLowerCase(); // Convert search term to lowercase
    for (Customer customer : customerList) {
        String customerNameLowerCase = customer.getCustomerName().toLowerCase(); // Convert book name to lowercase
        if (customerNameLowerCase.contains(searchTermLowerCase)) {
            searchResult.add(customer);
        }
    }
    return searchResult;
    }

    // Customer Manage Module Data's
    // End--------------------------------------------------------------------------------------------->


    // Admin Profile ANd Creditantials Module Data's
    // Start--------------------------------------------------------------------------------------------->
    public List<Admin> adminList() {
        return adminList;
    }

    public void addAdminProfile(Admin admin) {
        adminList.add(admin);
    }

    public void addCreditantials(Creditantials creditantials) {
        creditantialsList.add(creditantials);
    }

    public void removeCreditantials(int userId) {
        creditantialsList.removeIf(c -> c.getUserId() == userId);
    }

    public List<Creditantials> creditantialsList() {
        return creditantialsList;
    }
    // Admin Profile and Creditantials Manage Module Data's
    // End--------------------------------------------------------------------------------------------->
// Issued Books Data's
    // Start--------------------------------------------------------------------------------------------->

public void issueBooksAdd(IssuedBooks issuedBooks)
{
    issuedBooksList.add(issuedBooks);
}
public List<IssuedBooks> getIssuedBooksList() {
    return issuedBooksList;
}
//Issued Books Data's
// End--------------------------------------------------------------------------------------------->

    public int getLibraryByBookId(int bookId) {
        for(Book book:bookList)
        {
            if(book.getId()==bookId)
            {
                return book.getLibraryId();
            }
        }
        return 0;
    }

    // Export Data Form  List's +
    public void exportAdminList()
    {
        jsonModule.convertListToJson(adminList,"Admin");
    }

    public void exportCreditantialsList()
    {
        jsonModule.convertListToJson(creditantialsList,"Credentials");
    }

    public void exportBookList()
    {
        jsonModule.convertListToJson(bookList ,"Books");
    }

    public void exportIssuedBookList()
    {
        jsonModule.convertListToJson(issuedBooksList,"IssuedBooks");
    }

    public void exportLibraryList()
    {
        jsonModule.convertListToJson(libraryList,"LibraryDetails");
    }

    public void exportCustomerList()
    {
        jsonModule.convertListToJson(customerList,"Customers");
    }


    public void exportAllListJson() {
        jsonModule.convertListToJson(adminList,"Admin");
        jsonModule.convertListToJson(creditantialsList,"Credentials");
        jsonModule.convertListToJson(bookList ,"Books");
        jsonModule.convertListToJson(issuedBooksList,"IssuedBooks");
        jsonModule.convertListToJson(libraryList,"LibraryDetails");
        jsonModule.convertListToJson(customerList,"Customers");
    }

    public void loadDataFromJsonFiles() {
        adminList = jsonModule.convertJsonToList("src/com/classexample/data/Admin.json", Admin.class);
        creditantialsList = jsonModule.convertJsonToList("src/com/classexample/data/Credentials.json", Creditantials.class);
        bookList = jsonModule.convertJsonToList("src/com/classexample/data/Books.json", Book.class);
        issuedBooksList = jsonModule.convertJsonToList("src/com/classexample/data/IssuedBooks.json", IssuedBooks.class);
        libraryList = jsonModule.convertJsonToList("src/com/classexample/data/LibraryDetails.json", Library.class);
        customerList = jsonModule.convertJsonToList("src/com/classexample/data/Customers.json", Customer.class);
    }
/*public void setDefaultCustomerList() {
    customerList.add(new Customer("John Doe", "1234567890", "john@example.com", "New York",0));
    customerList.add(new Customer("Alice Smith", "9876543210", "alice@example.com", "Los Angeles",0));
    customerList.add(new Customer("Bob Johnson", "4567890123", "bob@example.com", "Chicago",0));
    customerList.add(new Customer("Emily Davis", "7890123456", "emily@example.com", "Houston",0));
    customerList.add(new Customer("Michael Wilson", "2345678901", "michael@example.com", "San Francisco",0));
}

public void setDefaultIssuedBooksList() {
    issuedBooksList.add(new IssuedBooks(1, 1, LocalDate.now().minusDays(10), LocalDate.now().plusDays(20), "Pending"));
    issuedBooksList.add(new IssuedBooks(2, 2, LocalDate.now().minusDays(5), LocalDate.now().plusDays(15), "Pending"));
    issuedBooksList.add(new IssuedBooks(3, 3, LocalDate.now().minusDays(8), LocalDate.now().plusDays(25), "Pending"));
    issuedBooksList.add(new IssuedBooks(4, 4, LocalDate.now().minusDays(12), LocalDate.now().plusDays(30), "Pending"));
    issuedBooksList.add(new IssuedBooks(5, 5, LocalDate.now().minusDays(6), LocalDate.now().plusDays(18), "Pending"));
}

    public void setDefaultBookList() {
        bookList.add(new Book("To Kill a Mockingbird", "Harper Lee", "Harper Perennial Modern Classics", "50th Anniversary edition", "-", 10, 1, 3));
        bookList.add(new Book("1984", "George Orwell", "Signet Classics", "Centennial edition", "-", 20, 2, 2));
        bookList.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Scribner", "95th Anniversary edition", "-", 30, 3, 1));
        bookList.add(new Book("The Catcher in the Rye", "J.D. Salinger", "Little, Brown and Company", "Reissue edition", "-", 40, 4, 2));
        bookList.add(new Book("Pride and Prejudice", "Jane Austen", "Penguin Classics", "Deluxe edition", "-", 50, 5,2));
    }

    public void setDefaultLibraryList() {
        libraryList.add(new Library("Library A", "1234567890", "libraryA@example.com", "Address A",20));
        libraryList.add(new Library("Library B", "9876543210", "libraryB@example.com", "Address B",20));
        libraryList.add(new Library("Library C", "5678901234", "libraryC@example.com", "Address C",20));
    }*/


}

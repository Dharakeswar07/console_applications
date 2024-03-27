package com.librarymanagement.models;


import java.util.Date;

public class IssuedBooks {


 private int issueId;
    private static int uniqueId;
    private int bookId;
    private int customerId;
    private Date issueDate;
    private Date returnDate;
    private String status;


    public void setStatus(String status) {
        this.status = status;
    }

static
{
    uniqueId=1;
}


public IssuedBooks()
{}

public IssuedBooks(int issueId, int bookId, int customerId, Date issueDate, Date returnDate,String Status) {
    this.issueId=issueId;
    this.bookId = bookId;
    this.customerId = customerId;
    this.issueDate = issueDate;
    this.returnDate = returnDate;
    this.status=Status;
}

public int getIssueId() {
    return issueId;
}

public int getBookId() {
    return bookId;
}

public int getcustomerId() {
    return customerId;
}


public Date getIssueDate() {
    return issueDate;
}


public Date getReturnDate() {
    return returnDate;
}

public void setReturnDate(Date returnDate) {
    this.returnDate = returnDate;
}

    public int getCustomerId() {
        return customerId;
    }

    public String getStatus() {
        return status;
    }

    public static String getIssuedBooksTitle() {
    return String.format("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n",
            "Issue ID", "Book ID", "Customer ID", "Issue Date", "Return Date", "Status");
}

@Override
public String toString() {
    return String.format("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n",
            issueId, bookId, customerId, issueDate, returnDate, status);
}


}



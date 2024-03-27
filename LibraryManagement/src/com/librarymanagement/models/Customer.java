package com.librarymanagement.models;

public class Customer {


    private int customerId;
    private static int uniqueId;
    private String customerName;
    private String phoneNo;
    private String emailId;
    private String location;
    /*    private List<IssuedBooks> issuedBooksList;*/
    private int issueBookCount;

    public int getIssueBookCount() {
        return issueBookCount;
    }

    public void setIssueBookCount(int issueBookCount) {
        this.issueBookCount = issueBookCount;
    }

    static {
        uniqueId = 1;
    }

    public Customer()
    {}

   
    public Customer(String customerName, String phoneNo, String emailId, String location,int issueBookCount) {
        this.customerId=uniqueId++;
        this.customerName = customerName;
        this.phoneNo = phoneNo;
        this.emailId = emailId;
        this.location = location;
        this.issueBookCount=issueBookCount;
    }
    public int getCustomerId() {
        return customerId;
    }
    public String getCustomerName() {
        return customerName;
    }

    public static String getCustomerTitle() {
        return String.format("| %-10s | %-20s | %-15s | %-25s | %-20s | %-18s |\n",
                "Customer ID", "Customer Name", "Phone Number", "Email ID", "Location", "Issued Book Count");
    }
    
    @Override
    public String toString() {
        return String.format("| %-10s | %-20s | %-15s | %-25s | %-20s | %-18s |\n",
                customerId, customerName, phoneNo, emailId, location, issueBookCount);
    }
    
}

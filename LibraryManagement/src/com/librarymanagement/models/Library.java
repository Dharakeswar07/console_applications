package com.librarymanagement.models;

public class Library {
    private static int libraryUniqueID;
    private int libraryId;
    private String libraryName;
    private String phoneNo;
    private String emailId;
    private String address;
    private int bookCount;

    static {
        libraryUniqueID = 1;
    }

public  Library()
{}

    public Library(int libraryId,String libraryName, String phoneNo, String emailId, String address, int bookCount) {
        this.libraryId = libraryId;
        this.libraryName = libraryName;
        this.phoneNo = phoneNo;
        this.emailId = emailId;
        this.address = address;
        this.bookCount = bookCount;
    }


    public int getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(int libraryId) {
        this.libraryId = libraryId;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBookCount() {
        return bookCount;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }

    public static String getTitle() {
        return String.format("| %-15s | %-30s | %-15s | %-30s | %-40s | %-40s |\n",
                "Library ID", "Library Name", "Phone Number", "Email ID", "Address", "Book Count");
    }

    @Override
    public String toString() {
        return String.format("| %-15s | %-30s | %-15s | %-30s | %-40s | %-40s |\n",
                libraryId, libraryName, phoneNo, emailId, address, bookCount);
    }


}

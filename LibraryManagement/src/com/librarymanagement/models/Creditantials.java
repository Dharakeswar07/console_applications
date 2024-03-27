package com.librarymanagement.models;

public class Creditantials {
    private static int uniqueID;
    private int userId;
    private String userName;
    private String password;
    private String role;
    private int libraryId;
    static{
        uniqueID=0;
    }
    public Creditantials() {
        // Default constructor
    }


    public Creditantials(int userId,String userName, String password, String role, int libraryId) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.libraryId=libraryId;
    }

    public int getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(int libraryId) {
        this.libraryId = libraryId;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }
    public String getPassword() {
        return password;
    }

    public String getrole() {
        return role;
    }

    @Override
    public String toString() {
        return "Credentials [userId=" + userId + ", userName=" + userName + ", password=" + password + ", role="
                + role +", LibraryId=" + libraryId + "]";
    }

    

}

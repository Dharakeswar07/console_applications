package com.librarymanagement.models;

public class SessionStore {

    private static SessionStore session;
    private int userId;
    private String role;
    private String userName;
    private String password;
    private int libraryId;

    private SessionStore() {
    }


    public int getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(int libraryId) {
        this.libraryId = libraryId;
    }

    public static synchronized SessionStore getInstance() {
        if (session == null) {
            session = new SessionStore();
        }
        return session;
    }


    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public void setPassword(String password) {
        this.password = password;
    }
}

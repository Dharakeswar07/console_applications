package com.interviewpanel.models;

public class Creditantials {

    private int id;
    private static int uniqueId; 
    private String userName;
    private String password;
    private String type;
    private int empId;



    
    public Creditantials(int  id,String userName, String password, String type,int empId) {
        this.userName = userName;
        this.password = password;
        this.type = type;
        this.id=id;
        this.empId=empId;
    }

    public static int getUniqueId() {
        return uniqueId;
    }


    public String getUserName() {
        return userName;
    }

    public int getEmpId() {
        return empId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    static 
    {
        uniqueId=1;
    }

    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return "Creditantials{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                ", empId=" + empId +
                '}';
    }
}

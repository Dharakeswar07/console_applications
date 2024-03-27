package com.interviewpanel.models;

public class Employee {
private int id;
private static int uniqueID;
private String name;
private String  phoneNo;
private String emailId;
private String location;
private String position;

static 
{
    uniqueID=1;
}

public Employee(int id,String name, String phoneNo, String emailId, String location, String position) {
    this.name = name;
    this.phoneNo = phoneNo;
    this.emailId = emailId;
    this.location = location;
    this.position = position;
    this.id=id;
}



public int getId() {
    return id;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getPhoneNo() {
    return phoneNo;
}

public void setPhoneNo(String phoneNo) {
    this.phoneNo = phoneNo;
}

public String getEmailId() {
    return emailId;
}

public void setEmailId(String emailId) {
    this.emailId = emailId;
}

public String getLocation() {
    return location;
}

public void setLocation(String location) {
    this.location = location;
}

public String getPosition() {
    return position;
}

public void setPosition(String position) {
    this.position = position;
}

@Override
public String toString() {
    return String.format("| %-5d | %-20s  | %-15s | %-15s | %-15s |%-20s |\n",
    id, name,  phoneNo, emailId, location,position);
}

public static String getEmployeeTitle() {
    return String.format("| %-5s | %-20s  | %-15s | %-15s | %-15s | %-20s |\n",
    "ID","Name",  "Phone Number", "Email ID", "Location","Position");
}

}



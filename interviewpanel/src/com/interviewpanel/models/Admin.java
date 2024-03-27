package com.interviewpanel.models;

public class Admin {
	
	private String name;
	private static int uniqueID;
	private int id;
	private String phoneNo;
	private String emailId;
	private String address;

	static{
        uniqueID=1;
    }

	public static String getAdminTitle() {
		return String.format("| %-20s | %-5s | %-15s | %-25s | %-25s |\n",
				"Name", "ID", "Phone Number", "Email ID", "Address");
	}

	
	@Override
	public String toString() {
		return String.format("| %-20s | %-5s | %-15s | %-25s | %-25s |\n",
				name, id, phoneNo, emailId, address);
	}
	

	public Admin(int id,String name, String phoneNo, String emailId, String address) {
		this.name = name;
		this.id = id;
		this.phoneNo = phoneNo;
		this.emailId = emailId;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}

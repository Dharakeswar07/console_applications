package com.interviewpanel.models;

public class Candidate {

    private int candidateId;
    private static int uniqueID;
    private String name;
    private String location;
    private String skill;
    private String appliedPosition;
    private String phoneNo;
    private String emailId;
    private String education;

    private int createdBy;

    static 
    {
        uniqueID=1;
    }
    public Candidate(int candidateId,String name, String location, String skill, String appliedPosition, String phoneNo, String emailId,
            String education,int createdBy) {
        this.name = name;
        this.location = location;
        this.skill = skill;
        this.appliedPosition = appliedPosition;
        this.phoneNo = phoneNo;
        this.emailId = emailId;
        this.education = education;
        this.candidateId=candidateId;
        this.createdBy=createdBy;
    }

    
    public int getCandidateId() {
        return candidateId;
    }


    public String getName() {
        return name;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public static String getCandidateTitle() {
        return String.format("| %-12s | %-20s | %-15s | %-20s | %-15s | %-15s | %-25s | %-25s |%-25s |\n",
                "ID", "Name", "Location", "Skill", "Applied Position", "Phone Number", "Email ID", "Education","Created By");
    }
    
    @Override
    public String toString() {
        return String.format("| %-12s | %-20s | %-15s | %-20s | %-15s | %-15s | %-25s | %-25s |%-25s |\n",
                candidateId, name, location, skill, appliedPosition, phoneNo, emailId, education,createdBy);
    }
    

    

    

}

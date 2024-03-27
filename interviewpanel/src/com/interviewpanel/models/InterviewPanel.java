package com.interviewpanel.models;

public class InterviewPanel {

    private int id;
    private static int uniqueID;
    private int employeeId;
    private int candidateId;
    private String status;

    static
    {
        uniqueID=1;
    }

    
    public InterviewPanel(int id,int employeeId, int candidateId, String status) {
        this.employeeId = employeeId;
        this.candidateId = candidateId;
        this.status = status;
        this.id=id;
    }
    
    public int getId() {
        return id;
    }

    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public int getCandidateId() {
        return candidateId;
    }
    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("| %-5d | %-10d | %-12d | %-15s |\n", id, employeeId, candidateId, status);
    }

    public static String getTitle() {
        return String.format("| %-5s | %-10s | %-12s | %-15s |\n", "ID", "Employee ID", "Candidate ID", "Status");
    }
}

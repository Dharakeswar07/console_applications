package com.interviewpanel.db;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.interviewpanel.jsonconvert.JsonModule;
import com.interviewpanel.models.Admin;
import com.interviewpanel.models.Candidate;
import com.interviewpanel.models.Creditantials;
import com.interviewpanel.models.Employee;
import com.interviewpanel.models.InterviewPanel;

public class InterviewPanelDatabase {

    private static  InterviewPanelDatabase interviewPanelDatabase;

    private List<Creditantials> creditantialsList=new ArrayList<>();
private List<Admin> adminList = new ArrayList<>();
private List<Candidate> candidatesList=new ArrayList<>();
private Queue<InterviewPanel> interviewPanelQueue = new LinkedList<>();
private List<InterviewPanel> interviewPanelList=new ArrayList<>();


private List<Employee> employeeList=new ArrayList<>();

private JsonModule jsonModule;

    private InterviewPanelDatabase() {
        jsonModule = JsonModule.getInstance(); // Initialize the jsonModule field
    }
public static InterviewPanelDatabase getInstance()
{
    if(interviewPanelDatabase ==null)
    {
        interviewPanelDatabase =new InterviewPanelDatabase();
    }
    return interviewPanelDatabase;
}

public List<Creditantials> getCreditantialsList()
{
    return creditantialsList;
}
public void addCreditantials(Creditantials creditantials)
{
    creditantialsList.add(creditantials);
}
  // Admin Profile ANd Creditantials Module Data's
    // Start--------------------------------------------------------------------------------------------->
    public List<Admin> adminList() {
        return adminList;
    }

    public void addAdminProfile(Admin admin) {
        adminList.add(admin);
    }

    public void removeCreditantials(int userId) {
        creditantialsList.removeIf(c -> c.getId() == userId);
    }

    public List<Creditantials> creditantialsList() {
        return creditantialsList;
    }
    // Admin Profile and Creditantials Manage Module Data's
    // End--------------------------------------------------------------------------------------------->

    // Employee Manage Module Data's
    // Start--------------------------------------------------------------------------------------------->

    public List<Employee> getEmployeeList()
    {
        return employeeList;
    }
    public void addEmployeeDetails(Employee employee)
    {
        employeeList.add(employee);
    }
    public Employee getEmployeeById(int empId)
    {
        for(Employee employee : employeeList)
        {
                if(employee.getId()==empId)
                {
                    return employee;
                }
        }
        return null;
    }
    public List<Employee> getSearchByName(String empName)
    {
        List<Employee> empList=new ArrayList<>();
        String empNameGetLowerCase=empName.toLowerCase();
        for(Employee emp: employeeList)
        {
            String employeeNameLowerCase = emp.getName().toLowerCase();
            if(employeeNameLowerCase.contains(empNameGetLowerCase))
            {
                empList.add(emp); 
              }
        }
        return empList;
    }
    public int deleteEmployee(int empId) {
        
        Employee empToRemove = null;
        for (Employee emp : employeeList) {
            if (emp.getId() == empId) {
                empToRemove = emp;
                break;
            }
        }
        if (empToRemove != null) {
            if(employeeList.remove(empToRemove))
            {
                return 1;
            }
            else
            {
                return 0;
            }
            
        } else {
            return 2;
        }
    }
    // Employee  Module Data's
    // End--------------------------------------------------------------------------------------------->
    
    // Candidate Manage Module Data's
    // Start--------------------------------------------------------------------------------------------->

    public List<Candidate> getCandidateList()
    {
        return candidatesList;
    }

    public void addCandidateList(Candidate candidate)
    {
        candidatesList.add(candidate);
    }

    public Candidate getCandidateById(int candidateId)
    {
        for(Candidate candidate : candidatesList)
        {
                if(candidate.getCandidateId()==candidateId)
                {
                    return candidate;
                }
        }
        return null;
    }
    public List<Candidate> getCandidateSearchByName(String candidateName)
    {
        List<Candidate> candidatesList=new ArrayList<>();
        String candidateNameGetLowerCase=candidateName.toLowerCase();
        for(Candidate candidate: candidatesList)
        {
            String candidateNameLowerCase = candidate.getName().toLowerCase();
            if(candidateNameLowerCase.contains(candidateNameGetLowerCase))
            {
                candidatesList.add(candidate); 
              }
        }
        return candidatesList;
    }
    public int deleteCandidate(int candidateId) {
        
        Candidate candidateToRemove = null;
        for (Candidate candidate : candidatesList) {
            if (candidate.getCandidateId() == candidateId) {
                candidateToRemove = candidate;
                break;
            }
        }
        if (candidateToRemove != null) {
            if(candidatesList.remove(candidateToRemove))
            {
                return 1;
            }
            else
            {
                return 0;
            }
            
        } else {
            return 2;
        }
    }


     // Candidate Manage Module Data's
    // End--------------------------------------------------------------------------------------------->

    // Interview Panel Queue Model Data's
    //Start-------------------------------------------------------------------------------------------->

    public Queue<InterviewPanel> getInterviewPanelList()
    {
        return interviewPanelQueue;
    }

    public void addInterviewPanelList(InterviewPanel interviewPanel)
    {
        interviewPanelQueue.add(interviewPanel);
    }
    public InterviewPanel getCandidateInterviewById(int candidateId)
    {
        for(InterviewPanel interviewPanel: interviewPanelQueue)
        {
                if(interviewPanel.getCandidateId()==candidateId)
                {
                    return interviewPanel;
                }
        }
        return null;
    }

    public void addResultOfInterview(InterviewPanel interviewPanel)
    {
        interviewPanelList.add(interviewPanel);
    }

    public List<InterviewPanel> showInterviewResult()
    {
        return interviewPanelList;
    }
// Interview Panel Queue Model Data's
    //End-------------------------------------------------------------------------------------------->

    public void exportAllListJson() {
        jsonModule.convertListToJson(adminList,"Admin");
        jsonModule.convertListToJson(creditantialsList,"Credentials");
        jsonModule.convertListToJson(interviewPanelList ,"InterviewPanel");
        jsonModule.convertListToJson(employeeList,"Employee");
        jsonModule.convertQueueToJsonAndSave(interviewPanelQueue, "InterviewPanelQueue");
    }

    public void loadDataFromJsonFiles() {
        adminList = jsonModule.convertJsonToList("src/com/classexample/data/Admin.json", Admin.class);
        creditantialsList = jsonModule.convertJsonToList("src/com/classexample/data/Credentials.json", Creditantials.class);
        interviewPanelList = jsonModule.convertJsonToList("src/com/classexample/data/InterviewPanel.json", InterviewPanel.class);
        employeeList = jsonModule.convertJsonToList("src/com/classexample/data/Employee.json", Employee.class);
        interviewPanelQueue=jsonModule.convertJsonToQueue("src/com/classexample/data/InterviewPanelQueue.json",InterviewPanel.class);

    }


    // Default Values Assigned
    /*public void addDefaultEmployees() {
        // Add 3 default employees
        addEmployeeDetails(new Employee("John Doe", "1234567890", "john@example.com", "Location 1", "Interviewer"));
        addEmployeeDetails(new Employee("Jane Smith", "9876543210", "jane@example.com", "Location 2", "Receptionist"));
        addEmployeeDetails(new Employee("Michael Johnson", "5678901234", "michael@example.com", "Location 3", "Interviewer"));
    }
    
    public void addDefaultCandidates() {
        // Add 5 default candidates
        addCandidateList(new Candidate("Candidate 1", "Location 1", "Skill 1", "Position 1", "1234567890", "candidate1@example.com", "Education 1",1));
        addCandidateList(new Candidate("Candidate 2", "Location 2", "Skill 2", "Position 2", "9876543210", "candidate2@example.com", "Education 2",1));
        addCandidateList(new Candidate("Candidate 3", "Location 3", "Skill 3", "Position 3", "5678901234", "candidate3@example.com", "Education 3",1));
        addCandidateList(new Candidate("Candidate 4", "Location 4", "Skill 4", "Position 4", "1111111111", "candidate4@example.com", "Education 4",1));
        addCandidateList(new Candidate("Candidate 5", "Location 5", "Skill 5", "Position 5", "2222222222", "candidate5@example.com", "Education 5",1));
    }*/
}

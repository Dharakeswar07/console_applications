package com.interviewpanel.employeemanagement;

import java.util.List;

import com.interviewpanel.db.InterviewPanelDatabase;
import com.interviewpanel.logout.Logout;
import com.interviewpanel.models.Creditantials;
import com.interviewpanel.models.Employee;

public class EmployeeManagementModule {


    private EmployeeManagementView employeeManagementView;

    public EmployeeManagementModule(EmployeeManagementView employeeManagementView)
    {
        this.employeeManagementView=employeeManagementView;
    }

    public void empGetById(int empsearchId) {
        employeeManagementView.showMessage(Employee.getEmployeeTitle());
        employeeManagementView.showMessage(InterviewPanelDatabase.getInstance().getEmployeeById(empsearchId).toString());
    }

    public void empSearchGet(String empsearchName) {
         List<Employee> searchEmpList = InterviewPanelDatabase.getInstance().getSearchByName(empsearchName);
         employeeManagementView.showMessage(Employee.getEmployeeTitle());
        for (Employee emp : searchEmpList) {
            employeeManagementView.showMessage(emp.toString());
        }
    }

    public void addEmployee(String name,String phoneNo,String email,String location,String position,String userName,String password) {
        InterviewPanelDatabase database = InterviewPanelDatabase.getInstance();
        int lastCredentialsId = database.creditantialsList().stream().mapToInt(Creditantials::getId).max().orElse(0);
        int  creditUserID= lastCredentialsId + 1;
        int lastEmployeeId = database.getEmployeeList().stream().mapToInt(Employee::getId).max().orElse(0);
        int  employeeUserID= lastEmployeeId + 1;
        Creditantials creditantials=new Creditantials( creditUserID,userName, password,position,employeeUserID);

        Employee emp=new Employee(employeeUserID,name, phoneNo, email, location, position);
        if(emp.getPosition()==null)
        {
            employeeManagementView.showMessage("Employee Added Failed");
        }
        else
        {
            InterviewPanelDatabase.getInstance().addEmployeeDetails(emp);
            InterviewPanelDatabase.getInstance().addCreditantials(creditantials);
            InterviewPanelDatabase.getInstance().creditantialsListExport();
            InterviewPanelDatabase.getInstance().employeeListExport();
            employeeManagementView.showMessage("Employee Added SuccessFully");
        }
       
    }

    public void empShowList()
    {
        List<Employee> empShowList=InterviewPanelDatabase.getInstance().getEmployeeList();
        employeeManagementView.showMessage(Employee.getEmployeeTitle());
        for(Employee emp: empShowList)
        {
            employeeManagementView.showMessage(emp.toString());
        }
    }

    public void empDeleteById(int empsearchId) {
       int value=InterviewPanelDatabase.getInstance().deleteEmployee(empsearchId);
       if(value==0)
       {
        employeeManagementView.showMessage("Library with ID " + empsearchId + " Deleted Failed.");
       }
       else if(value==1)
       {
           InterviewPanelDatabase.getInstance().employeeListExport();
        employeeManagementView.showMessage("Library with ID " + empsearchId + " Deleted Succesfully.");
       }
       else if(value==2)
       {
        employeeManagementView.showMessage("Library with ID " + empsearchId + " Not Found.");
       }
    }

    public String positionSelect(int positionType) {
      if(positionType ==1)
      {
        return "Interviewer";
      }
      else if(positionType==2)
      {
        return "Receptionist";
      }
      employeeManagementView.showMessage("select the Correct Answer");
      return null;
    }

    public void logout() {
        employeeManagementView.showMessage("\u001B[31mUser has been Logout...........\u001B[0m");
        new Logout().logout();
    }
}

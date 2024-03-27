package com.interviewpanel.candidatemanagement;

import java.util.List;

import com.interviewpanel.db.InterviewPanelDatabase;
import com.interviewpanel.logout.Logout;
import com.interviewpanel.models.Candidate;
import com.interviewpanel.models.Creditantials;
import com.interviewpanel.models.SessionStore;

public class CandidateManagementModule {

    private CandidateManagementView candidateManagementView;
private SessionStore sessionStore;
    public CandidateManagementModule(CandidateManagementView candidateManagementView)
    {
        this.candidateManagementView=candidateManagementView;
        sessionStore=SessionStore.getInstance();
    }

    public void candidateShowList() {
       List<Candidate> candidateList=InterviewPanelDatabase.getInstance().getCandidateList();
       candidateManagementView.showMessage(Candidate.getCandidateTitle());
       for(Candidate candidate: candidateList)
       {
        candidateManagementView.showMessage(candidate.toString());
       }
    }

    public void candidateDeleteById(int candidatesearchId) {
        int value=InterviewPanelDatabase.getInstance().deleteCandidate(candidatesearchId);
        if(value==0)
        {
         candidateManagementView.showMessage("Library with ID " + candidatesearchId + " Deleted Failed.");
        }
        else if(value==1)
        {
            candidateManagementView.showMessage("Library with ID " + candidatesearchId + " Deleted Succesfully.");
        }
        else if(value==2)
        {
            candidateManagementView.showMessage("Library with ID " + candidatesearchId + " Not Found.");
        }
    }

    public  void candidateGetById(int candidatesearchId) {
        candidateManagementView.showMessage(Candidate.getCandidateTitle());
        candidateManagementView.showMessage(InterviewPanelDatabase.getInstance().getCandidateById(candidatesearchId).toString());
    }

    public void candidateSearchGet(String candidatesearchName) {
        List<Candidate> searchCandidateList = InterviewPanelDatabase.getInstance().getCandidateSearchByName(candidatesearchName);
        candidateManagementView.showMessage(Candidate.getCandidateTitle());
       for (Candidate candidate: searchCandidateList) {
           candidateManagementView.showMessage(candidate.toString());
       }
    }

    public void addEmployee(String name,String location,String skill,String position,String phoneNo,String email,String education) {
        InterviewPanelDatabase database = InterviewPanelDatabase.getInstance();
        int lastCandidateId = database.getCandidateList().stream().mapToInt(Candidate::getCandidateId).max().orElse(0);
        int  candidateUserID= lastCandidateId + 1;
        Candidate candidate = new Candidate(candidateUserID,name, location, skill, position, phoneNo, email, education,sessionStore.getUserId());
      InterviewPanelDatabase.getInstance().addCandidateList(candidate);
      InterviewPanelDatabase.getInstance().candidateListExport();
      candidateManagementView.showMessage("Candidate Added Successfully");
    }

    public void candidateMenuList() {
    if(sessionStore.getRole().equals("Admin") || sessionStore.getRole().equals("Receptionist"))
    {
        candidateManagementView.adminMenu();
    }
    else
    {
        candidateManagementView.interviewerMenu();
    }
    }

    public void logout() {
        candidateManagementView.showMessage("\u001B[31mUser has been Logout...........\u001B[0m");
        new Logout().logout();
    }
}

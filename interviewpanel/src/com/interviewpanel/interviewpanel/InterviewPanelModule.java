package com.interviewpanel.interviewpanel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.interviewpanel.db.InterviewPanelDatabase;
import com.interviewpanel.logout.Logout;
import com.interviewpanel.models.Candidate;
import com.interviewpanel.models.Employee;
import com.interviewpanel.models.InterviewPanel;
import com.interviewpanel.models.SessionStore;

public class InterviewPanelModule
    private InterviewPanelView interviewPanelView;
    private Map<Integer, String> statusMap = new HashMap<>();
    private SessionStore sessionStore;

    public InterviewPanelModule(InterviewPanelView interviewPanelView) {
        this.interviewPanelView = interviewPanelView;
        sessionStore = SessionStore.getInstance();
    }

    public void interviwerCheck(int empId) {
        Employee emp = InterviewPanelDatabase.getInstance().getEmployeeById(empId);
        if (emp == null) {
            interviewPanelView.showMessage("Employee Not Found");
            interviewPanelView.againTryForInterViewPanel("Employee");
        } else if (emp.getPosition().equals("Receptionist")) {
            interviewPanelView.showMessage("This Employee is not Interviewer");
            interviewPanelView.againTryForInterViewPanel("Employee");
        }
    }

    public void checkorRepeat(String answer) {
        String answerLowerCase = answer.toLowerCase();
        if (answerLowerCase.equals("yes")) {
            interviewPanelView.addInterview();
        } else {
            interviewPanelView.interviewPanelInit();
        }
    }

    public void checkorRepeatForCandidate(String answer, int empId) {
        String answerLowerCase = answer.toLowerCase();
        if (answerLowerCase.equals("yes")) {
            interviewPanelView.candidateIdGet(empId);
        } else {
            interviewPanelView.interviewPanelInit();
        }
    }

    public void candidateCheck(int candidateId, int empId) {
        Candidate candidate = InterviewPanelDatabase.getInstance().getCandidateById(candidateId);
        Queue<InterviewPanel> interviewPanels = InterviewPanelDatabase.getInstance().getInterviewPanelList();
        InterviewPanel interviewPanel1 = null;
        for (InterviewPanel interviewPanel : interviewPanels) {
            if (interviewPanel.getCandidateId() == candidateId) {
                interviewPanel1 = interviewPanel;
            }
        }
        if (candidate == null) {
            interviewPanelView.showMessage("Candidate Not Found");
            interviewPanelView.againTryForInterViewPanelCandidate("Candidate", empId);
        } else if (candidate != null && interviewPanel1 != null) {
            interviewPanelView.showMessage("This Candidate Was Already on the Interview ");
            interviewPanelView.againTryForInterViewPanelCandidate("Candidate", empId);
        }
    }

    public void addInterview(int empId, int candidateId) {

        String status = getStatus(empId, statusMap);
        if (status.equals("On Progress")) {
            statusMap.put(empId, "Waiting");
        }
        // Check if the Candidate Id is Already on the Queue or Not
        InterviewPanelDatabase database = InterviewPanelDatabase.getInstance();
        int lastInterviewPanelId = database.getInterviewPanelList().stream().mapToInt(InterviewPanel::getId).max().orElse(0);
        int  interviewPanelUserID= lastInterviewPanelId + 1;
        InterviewPanel interviewPanel = new InterviewPanel(interviewPanelUserID,empId, candidateId, status);
        InterviewPanelDatabase.getInstance().addInterviewPanelList(interviewPanel);

        interviewPanelView.showMessage("Interview scheduled successfully!");
        interviewPanelView.interviewPanelInit();
    }

    public String getStatus(int id, Map<Integer, String> statusMap) {
        return statusMap.getOrDefault(id, "On Progress");
    }

    public void showQueueList() {
        Queue<InterviewPanel> interviewPanelQueue = InterviewPanelDatabase.getInstance().getInterviewPanelList();

        interviewPanelView.showMessage("Interview Panel Queue:");
        interviewPanelView.showMessage("-----------------------");
        interviewPanelView.showMessage(InterviewPanel.getTitle());
        for (InterviewPanel panel : interviewPanelQueue) {
            interviewPanelView.showMessage(panel.toString());
        }

    }

    public void checkInterviewProcess(int candidateId) {
        InterviewPanel interviewPanel = InterviewPanelDatabase.getInstance().getCandidateInterviewById(candidateId);
        if (interviewPanel != null) {
            if (interviewPanel.getEmployeeId() == sessionStore.getUserId()) {
                if (interviewPanel.getStatus().equals("On Progress")) {
                    Queue<InterviewPanel> interviewPanelQueue = InterviewPanelDatabase.getInstance().getInterviewPanelList();
                    boolean removed = InterviewPanelDatabase.getInstance().getInterviewPanelList().remove(interviewPanel);
                    if (removed) {
                        for (InterviewPanel panel : interviewPanelQueue) {
                            if (panel.getEmployeeId() == interviewPanel.getEmployeeId() && panel.getStatus().equals("Waiting")) {
                                panel.setStatus("On Progress");
                                break;
                            }
                        }
                        interviewPanelView.showMessage("Interview panel removed for candidate ID " + candidateId);
                        InterviewPanelDatabase database=InterviewPanelDatabase.getInstance();
                        int lastInterviewPanelId = database.getInterviewPanelList().stream().mapToInt(InterviewPanel::getId).max().orElse(0);
                        int  interviewPanelUserID= lastInterviewPanelId + 1;
                        InterviewPanel successPanel = new InterviewPanel(interviewPanelUserID,interviewPanel.getEmployeeId(),
                                interviewPanel.getCandidateId(), "Success");
                        InterviewPanelDatabase.getInstance().addResultOfInterview(successPanel);
                        interviewPanelView.showMessage("Interview process completed successfully for candidate ID " + candidateId);
                    } else {
                        interviewPanelView.showMessage("Failed to remove interview panel for candidate ID " + candidateId);
                    }
                } else if (interviewPanel.getStatus().equals("Waiting")) {
                    interviewPanelView.showMessage("The Interview Still Not Started");
                } else {
                    interviewPanelView.showMessage("The Interview was Not Schedule for this Candidate");
                }
            } else {
                interviewPanelView.showMessage("This Candidate is not Your Candidate");
            }

        }
    }

    public void showInterviewResultList() {
        List<InterviewPanel> interviewPanelList = InterviewPanelDatabase.getInstance().showInterviewResult();

        interviewPanelView.showMessage("Interview Results:");
        interviewPanelView.showMessage("-----------------------");
        interviewPanelView.showMessage(InterviewPanel.getTitle());
        for (InterviewPanel panel : interviewPanelList) {
            interviewPanelView.showMessage(panel.toString());
        }
    }

    public void interviewPanleMenu() {
        if (sessionStore.getRole().equals("Admin")) {
            interviewPanelView.adminMenu();
        }
        else if( sessionStore.getRole().equals("Interviewer"))
            {
                interviewPanelView.empInterviewerMenu();
            }else {
            interviewPanelView.empMenu();
        }

    }

    public void logout() {
        interviewPanelView.showMessage("\u001B[31mUser has been Logout...........\u001B[0m");
        new Logout().logout();
    }
}

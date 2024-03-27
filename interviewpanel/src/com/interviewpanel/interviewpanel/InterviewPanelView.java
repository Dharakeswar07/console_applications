package com.interviewpanel.interviewpanel;

import java.util.Scanner;

import com.interviewpanel.adminlogin.AdminLoginView;
import com.interviewpanel.homepanel.HomeView;

public class InterviewPanelView {


    private InterviewPanelModule interviewPanelModule;
Scanner sc=new Scanner(System.in);
    public InterviewPanelView()
    {
        this.interviewPanelModule=new InterviewPanelModule(this);
    }

    public void interviewPanelInit()
    {
        interviewPanelModule.interviewPanleMenu();
    }

    public  void resultOfInterview() {
        System.out.println("\n\t\t\tInterview Result Update");
        System.out.println("Candidate Id:");
        int candidateId=sc.nextInt();
        System.out.println("Interview Result:");
        System.out.println("1. Selected\n 2. Not Selected");
        int choice=sc.nextInt();
        interviewPanelModule.checkInterviewProcess(candidateId,choice);
    }

    public void addInterview()
    {
        System.out.println("\n\t\t\t\tSchedule Interview");
        System.out.println("Interviwer Id:");
        int empId=sc.nextInt();
        interviewPanelModule.interviwerCheck(empId);
 candidateIdGet(empId);
       }

       public void candidateIdGet(int empId)
       {
            System.out.println("Candidate Id:");
            int candidateId=sc.nextInt();
            interviewPanelModule.candidateCheck(candidateId,empId); 
            interviewPanelModule.addInterview(empId, candidateId);

       }
public void showMessage(String msg)
{
    System.out.println(msg);
}

public void againTryForInterViewPanel(String type) {
    System.out.println("Would You Like to Try Again Or Not");
    sc.nextLine();
    System.out.println("If you want to try again Print Yes or No");
    String answer=sc.nextLine();
    interviewPanelModule.checkorRepeat(answer);
}
public void againTryForInterViewPanelCandidate(String type,int empId) {
    System.out.println("Would You Like to Try Again Or Not");
    sc.nextLine();
    System.out.println("If you want to try again Print Yes or No");
    String answer=sc.nextLine();
    interviewPanelModule.checkorRepeatForCandidate(answer,empId);
}

    public void adminMenu() {
        do {
            System.out.println("\n\t\t\t\t Interview Schedule");
            System.out.println("1. Interview Add");
            System.out.println("2. Interview Status");
            System.out.println("3. Interview List's");
            System.out.println("4. Interview Result's");
            System.out.println("5. Back <--- <--");
            System.out.println("6. logout");
            int n = sc.nextInt();
            switch (n) {
                case 1: {
                    addInterview();
                    break;
                }
                case 2: {
                    resultOfInterview();
                    break;
                }
                case 3: {
                    interviewPanelModule.showQueueList();
                    break;
                }
                case 4: {
                    interviewPanelModule.showInterviewResultList();
                    break;
                }
                case 5: {
                    new HomeView().homeInit();
                    break;
                }
                case 6: {
                    interviewPanelModule.logout();
                    return;
                }
                default: {
                    System.out.println("Choice the Correct  Option");
                    System.exit(0);
                }

            }
        } while (true);
    }

    public void empInterviewerMenu() {
        do {
            System.out.println("\n\t\t\t\t Interview Schedule");
            System.out.println("1. Interview Status");
            System.out.println("2. Interview List's");
            System.out.println("3. Interview Result's");
            System.out.println("4. Back <--- <--");
            System.out.println("5. logout");
            int n = sc.nextInt();
            switch (n) {
                case 1: {
                    resultOfInterview();
                    break;
                }
                case 2: {
                    interviewPanelModule.showQueueList();
                    break;
                }
                case 3: {
                    interviewPanelModule.showInterviewResultList();
                    break;
                }
                case 4: {
                    new HomeView().homeInit();
                    break;
                }
                case 5: {
                    interviewPanelModule.logout();
                    return;
                }
                default: {
                    System.out.println("Choice the Correct  Option");
                    System.exit(0);
                }

            }
        } while (true);
    }

    public void empMenu() {
        do {
            System.out.println("\n\t\t\t\t Interview Schedule");
            System.out.println("1. Interview Add");
            System.out.println("2. Interview List's");
            System.out.println("3. Interview Result's");
            System.out.println("4. Back <--- <--");
            System.out.println("5. logout");
            int n = sc.nextInt();
            switch (n) {
                case 1: {
                    addInterview();
                    break;
                }
                case 2: {
                    interviewPanelModule.showQueueList();
                    break;
                }
                case 3: {
                    interviewPanelModule.showInterviewResultList();
                    break;
                }
                case 4: {
                    new HomeView().homeInit();
                    break;
                }
                case 5: {
                    interviewPanelModule.logout();
                    return;
                }
                default: {
                    System.out.println("Choice the Correct  Option");
                    System.exit(0);
                }

            }
        } while (true);
    }
}


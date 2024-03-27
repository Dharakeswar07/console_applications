package com.interviewpanel.candidatemanagement;

import java.util.Scanner;

import com.interviewpanel.adminlogin.AdminLoginView;
import com.interviewpanel.homepanel.HomeView;
import com.interviewpanel.models.Candidate;
import com.interviewpanel.validator.Validator;

public class CandidateManagementView {

    private CandidateManagementModule candidateManagementModule;
    Scanner sc = new Scanner(System.in);

    public CandidateManagementView() {
        this.candidateManagementModule = new CandidateManagementModule(this);
    }

    public void candidateInit() {
        candidateManagementModule.candidateMenuList();
    }


    public void adminMenu() {
        do {
            System.out.println("\n\t\t\t\t\t\tCandidate Details");
            System.out.println("1.Add Candidate");
            System.out.println("2.Candidate List");
            System.out.println("3.Delete Candidate");
            System.out.println("4.Search Candidate by Candidate Id");
            System.out.println("5.Search Candidate by Candidate Name");
            System.out.println("6.Back <--- <--");
            System.out.println("7.logout");
            int n = sc.nextInt();
            switch (n) {
                case 1: {
                    addCandidate();
                    break;
                }
                case 2: {
                    candidateManagementModule.candidateShowList();
                    break;
                }
                case 3: {
                    System.out.println("Delete Candidate");
                    System.out.println("Enter the Candidate Id(For Delete):");
                    int candidatesearchId = sc.nextInt();
                    candidateManagementModule.candidateDeleteById(candidatesearchId);
                    break;
                }
                case 4: {
                    System.out.println("Enter the Candidate Id(For Search):");
                    int candidatesearchId = sc.nextInt();
                    candidateManagementModule.candidateGetById(candidatesearchId);
                    break;
                }
                case 5: {
                    sc.nextLine();
                    System.out.println("Enter the Candidate Name:");
                    String candidatesearchName = sc.nextLine();
                    candidateManagementModule.candidateSearchGet(candidatesearchName);
                    break;
                }
                case 6: {
                    new HomeView().homeInit();
                    break;
                }
                case 7: {
        candidateManagementModule.logout();
                    return;
                }
                default: {
                    System.out.println("Choice the Correct  Option");
                    System.exit(0);
                }

            }
        } while (true);
    }

    public void interviewerMenu() {
        do {
            System.out.println("\n\t\t\t\t\t\tCandidate Details");
            System.out.println("1.Candidate List");
            System.out.println("2.Search Candidate by Candidate Id");
            System.out.println("3.Search Candidate by Candidate Name");
            System.out.println("4.Back <--- <--");
            System.out.println("5.logout");
            int n = sc.nextInt();
            switch (n) {
                case 1: {
                    candidateManagementModule.candidateShowList();
                    break;
                }
                case 2: {
                    System.out.println("Enter the Candidate Id(For Search):");
                    int candidatesearchId = sc.nextInt();
                    candidateManagementModule.candidateGetById(candidatesearchId);
                    break;
                }
                case 3: {
                    sc.nextLine();
                    System.out.println("Enter the Candidate Name:");
                    String candidatesearchName = sc.nextLine();
                    candidateManagementModule.candidateSearchGet(candidatesearchName);
                    break;
                }
                case 4: {
                    new HomeView().homeInit();
                    break;
                }
                case 5: {
                    candidateManagementModule.logout();
                    return;
                }
                default: {
                    System.out.println("Choice the Correct  Option");
                    System.exit(0);
                }

            }
        } while (true);
    }

    private void addCandidate() {
        sc.nextLine();
        String name;
        String phoneNo;
        String email;
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("\n\t\t\t\t Candidate Creation");
        Boolean valid;
        do {
            System.out.println("Name:");
            name = sc.nextLine();
            valid = Validator.isValidName(name);
            if (!valid) {
                System.out.println("\u001B[31mEnter a valid name.\u001B[0m");
            }
        } while (!valid);
        do {
            System.out.println("Phone No:");
            phoneNo = sc.nextLine();
            valid = Validator.isValidPhoneNumber(phoneNo);
            if (!valid) {
                System.out.println("\u001B[31mEnter a valid Phone No.\u001B[0m");
            }
        } while (!valid);
        do {
            System.out.println("Email Id:");
            email = sc.nextLine();
            valid = Validator.isValidEmail(email);
            if (!valid) {
                System.out.println("\u001B[31mEnter a valid Email.\u001B[0m");
            }
        } while (!valid);

        System.out.println("Location:");
        String location = sc.nextLine();
        System.out.println("Education:");
        String education = sc.nextLine();
        System.out.println("Skills:");
        String skill = sc.nextLine();
        System.out.println("Applied Position:");
        String position = sc.nextLine();
        candidateManagementModule.addEmployee(name, location, skill, position, phoneNo, email, education);
    }

    public void showMessage(String msg) {
        System.out.println(msg);
    }

}

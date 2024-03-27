package com.librarymanagement.managelibrary;

import java.util.List;

import com.librarymanagement.db.LibraryDatabase;
import com.librarymanagement.logout.Logout;
import com.librarymanagement.models.Creditantials;
import com.librarymanagement.models.Library;

public class ManageLibraryModule {
    private Logout logout;
    private ManageLibraryView manageLibraryView;
    private  Creditantials creditantials;
    private Library library;

    public ManageLibraryModule(ManageLibraryView manageLibraryView)
    {
        this.manageLibraryView = manageLibraryView;
        library=new Library();
        creditantials=new Creditantials();
    }

 public void startSetUp() {
        manageLibraryView.initiateSetup();
    }

    // Method to Add library details
    public void libraryAdd(String libraryName,String phoneNo,String emailId,String address,String userName,String password,String role) {
        LibraryDatabase database = LibraryDatabase.getInstance();
        int lastLibraryId = database.getLibraryList().stream().mapToInt(Library::getLibraryId).max().orElse(0);
        int libId = lastLibraryId + 1;
        int lastCredentialsId = database.creditantialsList().stream().mapToInt(Creditantials::getUserId).max().orElse(0);
        int  creditUserID= lastCredentialsId + 1;
        library = new Library(libId,libraryName, phoneNo, emailId, address,0);
        int libraryIdForAdd=library.getLibraryId();
        Creditantials creditantials=new Creditantials(creditUserID, userName, password,role,libraryIdForAdd);
        LibraryDatabase.getInstance().setLibrary(library);
        LibraryDatabase.getInstance().addCreditantials(creditantials);
        LibraryDatabase.getInstance().exportLibraryList();
        LibraryDatabase.getInstance().exportCreditantialsList();
        manageLibraryView.showAlert("Library Setup SuccessFully Complete");
    }

    // Method to edit library details
    public void editLibrary(Library updatedLibrary) {
        LibraryDatabase.getInstance().updateLibrary(updatedLibrary);
        System.out.println("Library details updated successfully.");
    }

    public void getLibraryInfoById(int libraryId) {
        library=LibraryDatabase.getInstance().searchLibrary(libraryId);
        if(library ==null)
        {
            manageLibraryView.showAlert("No Library Found");
        }
        else
        {
            manageLibraryView.showAlert(library.toString());
        }
        
    }

    public void deleteLibraryById(int libraryId) {
        LibraryDatabase.getInstance().deleteLibrary(libraryId);
        LibraryDatabase.getInstance().exportLibraryList();
        manageLibraryView.showAlert("Library record with ID " + libraryId + " deleted successfully.");
    }

    public void showLibraryList() {
       List<Library> libraryList = LibraryDatabase.getInstance().getLibraryList();
        if (libraryList.isEmpty()) {
            manageLibraryView.showAlert("No libraries found.");
        } else {
             manageLibraryView.showAlert(Library.getTitle());
            for (Library library : libraryList) {
                manageLibraryView.showAlert(library.toString());
            }
        }
    }
    public void logout() {
        manageLibraryView.showAlert("\u001B[31mUser has been Logout...........\u001B[0m");
        Logout.getInstance().logout();
    }
}

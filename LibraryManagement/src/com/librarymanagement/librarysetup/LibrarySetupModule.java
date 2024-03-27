package com.librarymanagement.librarysetup;

import java.util.List;

import com.librarymanagement.db.LibraryDatabase;
import com.librarymanagement.models.Library;

public class LibrarySetupModule {

    private LibrarySetupView librarySetupView;

    private Library library;

   public  LibrarySetupModule(LibrarySetupView librarySetupView) {
        librarySetupView = this.librarySetupView;
        library=new Library();
    }

    public void startSetUp() {
    //    LibraryDatabase.getInstance().setDefaultLibraryList();
        librarySetupView.initiateSetup();
    }

    // Method to Add library details
    public void libraryAdd(String libraryName,String phoneNo,String  emailId,String  address,int id) {
       int libId=library.getLibraryId();
        Library library = new Library(libId+1,libraryName, phoneNo, emailId, address,id);
        LibraryDatabase.getInstance().setLibrary(library);
        librarySetupView.showAlert("Library Setup SuccessFully Complete");
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
            librarySetupView.showAlert("No Library Found");
        }
        else
        {
            librarySetupView.showAlert(library.toString());
        }
        
    }

    public void deleteLibraryById(int libraryId) {
        LibraryDatabase.getInstance().deleteLibrary(libraryId);
        librarySetupView.showAlert("Library record with ID " + libraryId + " deleted successfully.");
    }

    public void showLibraryList() {
       List<Library> libraryList = LibraryDatabase.getInstance().getLibraryList();
        if (libraryList.isEmpty()) {
            librarySetupView.showAlert("No libraries found.");
        } else {
            for (Library library : libraryList) {
                librarySetupView.showAlert(library.toString());
            }
        }
    }
}

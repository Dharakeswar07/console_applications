package com.librarymanagement.managecustomer;

import java.util.List;

import com.librarymanagement.db.LibraryDatabase;

import com.librarymanagement.logout.Logout;
import com.librarymanagement.models.Customer;

public class ManageCustomerModel {
    private Logout logout;

    private ManageCustomerView manageCustomerView;

    public ManageCustomerModel(ManageCustomerView manageCustomerView)
    {
        this.manageCustomerView=manageCustomerView;
    }

    public void customerListShow() {
       List<Customer> customerList = LibraryDatabase.getInstance().getCustomerList();
        manageCustomerView.showMessage(Customer.getCustomerTitle());
                    for (Customer customer : customerList) {
                        manageCustomerView.showMessage(customer.toString());
                    }
    }

    public void customerAdd(String name,String phone,String email,String address) {
        Customer customer = new Customer(name, phone, email, address,0);
        LibraryDatabase.getInstance().addCustomer(customer);
        LibraryDatabase.getInstance().exportCustomerList();
    }

    public void deleteCustomer(int customerId) {
        LibraryDatabase.getInstance().deleteCustomer(customerId);
        LibraryDatabase.getInstance().exportCustomerList();
        manageCustomerView.showMessage("Customer record with ID " + customerId + " deleted successfully.");
    }
    public void logout() {
       manageCustomerView.showMessage("\u001B[31mUser has been Logout...........\u001B[0m");
        logout.logout();
    }
}

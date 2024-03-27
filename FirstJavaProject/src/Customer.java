public class Customer {
    private int customerId;
    private String customerName;
    private int phoneNumber;
    private Qutation qutation;
    public Customer(int customerId, String customerName, int phoneNumber, Qutation qutation) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.qutation = qutation;
    }
   
    public int getCustomerId() {
        return customerId;
    }
    public Qutation getQutation() {
        return qutation;
    }

    public void setQutation(Qutation qutation) {
        this.qutation = qutation;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public int getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    
}

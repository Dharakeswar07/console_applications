import java.util.Date;

public class Sales {

    private int salesId;
    private Car car;
    private Customer customer;
    private Admin admin;
    private Date salesDate;
    public Sales(int salesId, Car car, Customer customer, Admin admin, Date salesDate) {
        this.salesId = salesId;
        this.car = car;
        this.customer = customer;
        this.admin = admin;
        this.salesDate = salesDate;
    }
    public int getSalesId() {
        return salesId;
    }
    public void setSalesId(int salesId) {
        this.salesId = salesId;
    }
    public Car getCar() {
        return car;
    }
    public void setCar(Car car) {
        this.car = car;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Admin getAdmin() {
        return admin;
    }
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
    public Date getSalesDate() {
        return salesDate;
    }
    public void setSalesDate(Date salesDate) {
        this.salesDate = salesDate;
    }
    

}

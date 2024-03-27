import java.util.ArrayList;
import java.util.List;

public class ShowRoom {

    private List<Car> carList = new ArrayList<>();
    private List<Admin> adminList=new ArrayList<>();
    private List<Purchase> purchaseList;
    private List<Qutation> qutationList;
    private List<Sales> salesList;
    // public ShowRoom(List<Car> carList, List<Admin> adminList, List<Purchase> purchaseList, List<Qutation> qutationList,
    //         List<Sales> salesList) {
    //     this.carList = carList;
    //     this.adminList = adminList;
    //     this.purchaseList = purchaseList;
    //     this.qutationList = qutationList;
    //     this.salesList = salesList;
    // }


    boolean createCar(Car car)
    {
        
        if(carList.add(car))
        {
            return true;
        }
        else{
            return false;
        }
    }
    void addAdmin(Admin admin)
    {
        adminList.add(admin);
    }
    public ShowRoom() {
        // Car 1
         carList.add(new Car(1, "BMW 3 Series", 40000, "BMW", "Black", "Luxury sedan with powerful engine options and advanced technology features"));
                // Car 2
        carList.add(new Car(2, "BMW 5 Series", 55000, "BMW", "Silver", "Executive sedan known for its elegant design, spacious interior, and cutting-edge technology"));

        // Car 3
        carList.add(new Car(3, "BMW X3", 45000, "BMW", "White", "Compact luxury SUV with sporty handling, upscale interior, and versatile cargo space"));

        // Car 4
        carList.add(new Car(4, "BMW X5", 60000, "BMW", "Blue", "Midsize luxury SUV offering a blend of performance, comfort, and off-road capability"));

        // Car 5
        carList.add(new Car(5, "BMW i8", 150000, "BMW", "Red", "Hybrid sports car featuring futuristic design, high-performance plug-in hybrid powertrain, and advanced technology integration"));
        //Admin 1
        adminList.add(new Admin(1, "Balaji", "BalBang", "BalBang@143", "London", 0));
    }
    void purchaseAdd(Purchase purchase)
    {
        purchaseList.add(purchase);
    }
    void qutationAdd(Qutation qutation)
    {
        qutationList.add(qutation);
    }
    void salesAdd(Sales sales)
    {
        salesList.add(sales);
    }
    void adminAdd(Admin admin)
    {
        adminList.add(admin);
    }
    void showAllCars()
    {
        for(Car cars:carList)
        {
            System.out.println(cars);
        }
    }
    int carId()
    {
       return carList.size();
    }
    boolean adminLoginCheck(Admin adminObj)
    {
        for(Admin admin:adminList)
        {
            if(admin.getUsername().equals(adminObj.getUsername())&&(admin.getPassword().equals(adminObj.getPassword())))
            {
                return true;
            }
        }
        return false;
    }
}




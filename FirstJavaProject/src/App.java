import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        ShowRoom sh=new ShowRoom();
        System.out.println("Bal's BMW ShowRoom");
        System.out.println("-------------------");
        int i=0;
        do{
            System.out.println("Select User:");
            System.out.println("1.Admin");
            System.out.println("2.Guest");
System.out.println("Enter your Option:");
int n=sc.nextInt();
            switch(n)
            {
                case 1:
                {
                    
                 System.out.println("UserName:");
                 String user=sc.next();
                 System.out.println("Password");
                 String pass=sc.next();
                 Admin aduser=new Admin(user, pass);
                 if(sh.adminLoginCheck(aduser))
                 {
                    int j=0;
                    do{
                        System.out.println("Select User:");
                        System.out.println("1.Add Car");
                        System.out.println("2.List Of Car");
                        System.out.println("3.Customer Creation");
                        System.out.println("4.Purchase");
                        System.out.println("5.Qutation");
                        System.out.println("6.Sales");
                        System.out.println("7.Logout");
            System.out.println("Enter your Option:");
            int adminn=sc.nextInt();
                    switch (adminn) {
                        case 1:
                        {
                            System.out.println("Add Car");
                            int carId=sh.carId();
                            System.out.println("Car Model:");
                            String carModel=sc.next();
                            System.out.println("Car Brand:");
                            String carBrand=sc.next();
                            System.out.println("Car Price:");
                            int price=sc.nextInt();
                            System.out.println("Car Color:");
                            String color=sc.next();
                            System.out.println("Car Spec's:");
                            String spec=sc.next();
                            Car cars=new Car(carId, carModel, price, carBrand, color, spec);
                        
                            if(sh.createCar(cars))
                        {
                            System.out.println("Car Added SuccessFully");
                        }
                        else
                        {
                            System.out.println("Car Added Failed");
                        }
                            break;
                        }
                        case 2:
                        {
                            System.out.println("List Of Customers");
                            break;
                        }
                        case 3:
                        {
                            System.out.println("List Of Car");
                            break;
                        }
                        case 4:
                        {
                            System.out.println("Customer Creation");
                            break;
                        }
                        case 5:
                        {
                            System.out.println("Purchase");
                            break;
                        }
                        case 6:
                        {
                            System.out.println("Qutation");
                            break;
                        }
                        case 7:
                        {
                            System.out.println("Sales");
                            break;
                        }
                        case 8:
                        {
                            System.out.println("Logout");
                            break;
                        }
                        default:
                        System.out.println("Enter the Correct Order");
                            break;
                    }
                    System.out.println("\nDo you want to Contiune Press 1  Or Press other's:");
                     j=sc.nextInt();
                }while(j==1);
                 }

break;
                }
                case 2:
                {
sh.showAllCars();
break;
                }
                default:
                {
                    System.out.println("Enter the Correct Choice:");
                    break;
                }
            }
            System.out.println("\nDo you want to Contiune Press 1  Or Press other's:");
            i=sc.nextInt();
        }while(i==1);
    }

    // void showAllCars()
    // {
    //     sh.showAllCars();
    // }
    
}

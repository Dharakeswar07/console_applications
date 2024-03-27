public class Car {

    private int carId;
    private String model;
    private int price;
    private String brand;
    private String color;
    private String spec;
    
    public Car(int carId, String model, int price, String brand, String color, String spec) {
        this.carId = carId;
        this.model = model;
        this.price = price;
        this.brand = brand;
        this.color = color;
        this.spec = spec;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }
    
    public String toString()
    {
        return "--------------------------------------------------------------------------------------------- \nCar Brand:" +brand+ "\nCar Model:"+model+"\nCar Color:"+color+"\nCar Price:"+price+"\nspec:"+spec+"\n-------------------------------------------------------------------------------------------------------";
    }
}

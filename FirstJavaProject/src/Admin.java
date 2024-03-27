public class Admin {

    private int id;
    private String name;
    private String username;
    private String password;
    private String location;
    private int salesCount;
    public Admin(int id, String name, String username, String password, String location, int salesCount) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.location = location;
        this.salesCount = salesCount;
    }
    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public int getSalesCount() {
        return salesCount;
    }
    public void setSalesCount(int salesCount) {
        this.salesCount = salesCount;
    }
    
    
    
}
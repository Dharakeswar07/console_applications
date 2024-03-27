public class Purchase {

    private int purchaseId;
    private Car carObject;
    private Admin adminObject;
    private ShowRoom showRoom;
    
    public Purchase(int purchaseId, Car carObject, Admin adminObject, ShowRoom showRoom) {
        this.purchaseId = purchaseId;
        this.carObject = carObject;
        this.adminObject = adminObject;
        this.showRoom = showRoom;
    }
    public ShowRoom getShowRoom() {
        return showRoom;
    }
    public void setShowRoom(ShowRoom showRoom) {
        this.showRoom = showRoom;
    }
    public int getPurchaseId() {
        return purchaseId;
    }
    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }
    public Car getCarObject() {
        return carObject;
    }
    public void setCarObject(Car carObject) {
        this.carObject = carObject;
    }
    public Admin getAdminObject() {
        return adminObject;
    }
    public void setAdminObject(Admin adminObject) {
        this.adminObject = adminObject;
    }

}

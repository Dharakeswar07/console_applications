import java.util.Date;

public class Qutation {

    private int qutationId;
    private Car car;
    private Date qutationDate;
    private Date expireDate;
    private ShowRoom showRoom;
    
    
    public Qutation(int qutationId, Car car, Date qutationDate, Date expireDate, ShowRoom showRoom) {
        this.qutationId = qutationId;
        this.car = car;
        this.qutationDate = qutationDate;
        this.expireDate = expireDate;
        this.showRoom = showRoom;
    }
    public int getQutationId() {
        return qutationId;
    }
    public void setQutationId(int qutationId) {
        this.qutationId = qutationId;
    }
    public Car getCar() {
        return car;
    }
    public void setCar(Car car) {
        this.car = car;
    }
    public Date getQutationDate() {
        return qutationDate;
    }
    public void setQutationDate(Date qutationDate) {
        this.qutationDate = qutationDate;
    }
    public Date getExpireDate() {
        return expireDate;
    }
    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }
    public ShowRoom getShowRoom() {
        return showRoom;
    }
    public void setShowRoom(ShowRoom showRoom) {
        this.showRoom = showRoom;
    }

    



}

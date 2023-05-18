package mcsfinalproject.Entities;

public class Room {
    
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    private String room_name;
    private boolean available;
    private boolean reservered;
    private Customer customer;
    
 
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isReservered() {
        return reservered;
    }

    public void setReservered(boolean reservered) {
        this.reservered = reservered;
    }
    
}

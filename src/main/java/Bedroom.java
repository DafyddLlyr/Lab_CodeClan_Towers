import java.util.ArrayList;

public class Bedroom {

    private String roomNumber;
    private int capacity;
    private String type;
    private ArrayList<Guest> guests;
    private int rate;

    public Bedroom(String roomNumber, int capacity, String type, int rate) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.type = type;
        this.guests = new ArrayList<Guest>();
        this.rate = rate;
    }

    public String getRoomNumber() {
        return this.roomNumber;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public String getType() {
        return this.type;
    }

    public ArrayList<Guest> getGuests() {
        return this.guests;
    }

    public int getRate() {
        return rate;
    }

    public int numberOfGuests() {
        return this.guests.size();
    }

    public void addGuest(Guest guest) {
        if(capacity > 0) {
            this.guests.add(guest);
            capacity -= 1;
        }
    }

    public void removeGuest(Guest guest) {
        if(this.guests.contains(guest)){
            this.guests.remove(guest);
            capacity += 1;
        }
    }
}

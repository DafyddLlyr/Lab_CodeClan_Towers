import java.util.ArrayList;

public class ConferenceRoom {

    private String name;
    private int capacity;
    private ArrayList<Guest> guests;

    public ConferenceRoom(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.guests = new ArrayList<Guest>();
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public ArrayList<Guest> getGuests() {
        return this.guests;
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

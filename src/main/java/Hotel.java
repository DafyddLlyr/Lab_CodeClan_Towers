import java.util.ArrayList;
import java.util.Collection;

public class Hotel {

    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> conferenceRooms;

    public Hotel(ArrayList<Bedroom> bedrooms, ArrayList<ConferenceRoom> conferenceRooms){
        this.bedrooms = new ArrayList<Bedroom>();
        this.conferenceRooms = new ArrayList<ConferenceRoom>();
    }

    public int numberOfBedrooms() {
        return this.bedrooms.size();
    }

    public int numberOfConferenceRooms() {
        return this.conferenceRooms.size();
    }

    public void addBedroom(Bedroom bedroom) {
        if (!this.bedrooms.contains(bedroom)) {
            this.bedrooms.add(bedroom);
        }
    }

    public void checkInBedroom(Guest guest, Bedroom bedroom) {
        if(this.bedrooms.contains(bedroom) && bedroom.numberOfGuests() == 0){
            bedroom.addGuest(guest);
        }
    }

    public void checkOutBedroom(Guest guest, Bedroom bedroom) {
        if(this.bedrooms.contains(bedroom)){
            bedroom.removeGuest(guest);
        }
    }

    public void checkInConference(Guest guest, ConferenceRoom conferenceRoom) {
        if(this.conferenceRooms.contains(conferenceRoom)){
            conferenceRoom.addGuest(guest);
        }
    }

    public void checkOutConference(Guest guest, ConferenceRoom conferenceRoom) {
        if(this.conferenceRooms.contains(conferenceRoom)){
            conferenceRoom.removeGuest(guest);
        }
    }

    public void addConferenceRoom(ConferenceRoom conferenceRoom) {
        if(!this.conferenceRooms.contains(conferenceRoom)){
            this.conferenceRooms.add(conferenceRoom);
        }
    }

    public Booking bookRoom(Bedroom bedroom, int nightsBooked) {
        Booking newBooking = new Booking(bedroom, nightsBooked);
        bedroom.markAsBooked();
        return newBooking;
    }

    public Collection emptyBedrooms() {
        ArrayList<Bedroom> emptyRooms = new ArrayList<Bedroom>();
        for (Bedroom bedroom : this.bedrooms){
            if(!bedroom.isBooked()) {
                emptyRooms.add(bedroom);
            }
        }
        return emptyRooms;
    }
}
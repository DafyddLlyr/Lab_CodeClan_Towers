import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class HotelTest {

    private Hotel hotel;
    private Guest guest1;
    private Bedroom bedroom1;
    private Bedroom bedroom2;
    private ArrayList<Bedroom> bedrooms;
    private ConferenceRoom conference1;
    private ArrayList<ConferenceRoom> conferenceRooms;

    @Before
    public void setup() {
        guest1 = new Guest("Bob");

        bedrooms = new ArrayList<Bedroom>();
        bedroom1 = new Bedroom("127", 4, "Family", 100);
        bedroom2 = new Bedroom("31", 4, "Family", 150);

        conferenceRooms = new ArrayList<ConferenceRoom>();
        conference1 = new ConferenceRoom("Deluxe Suite", 10);

        hotel = new Hotel(bedrooms, conferenceRooms);
        hotel.addBedroom(bedroom1);
    }

    @Test
    public void hotelStartsOneRooms(){
        assertEquals(1, hotel.numberOfBedrooms());
    }

    @Test
    public void canAddBedRoomoomToHotel() {
        hotel.addBedroom(bedroom2);
        assertEquals(2, hotel.numberOfBedrooms());
    }

    @Test
    public void canAddConferenceRoomToHotel() {
        hotel.addConferenceRoom(conference1);
        assertEquals(1, hotel.numberOfConferenceRooms());
    }

    @Test
    public void cannotAddExistingRoomToHotel(){
        hotel.addBedroom(bedroom2);
        hotel.addBedroom(bedroom2);
        assertEquals(2, hotel.numberOfBedrooms());
    }

    @Test
    public void hotelStartsWithNoConferenceRoomsInCollection(){
        assertEquals(0, hotel.numberOfConferenceRooms());
    }

    @Test
    public void hotelCanCheckGuestsIntoBedrooms() {
        hotel.checkInBedroom(guest1, bedroom1);
        assertEquals(1, bedroom1.numberOfGuests());
    }

    @Test
    public void hotelCanCheckGuestsOutOfBedrooms(){
        hotel.checkInBedroom(guest1, bedroom1);
        hotel.checkOutBedroom(guest1, bedroom1);
        assertEquals(0, bedroom1.numberOfGuests());
    }

    @Test
    public void hotelCanCheckGuestsIntoConferenceRoom() {
        hotel.addConferenceRoom(conference1);
        hotel.checkInConference(guest1, conference1);
        assertEquals(1, conference1.numberOfGuests());
    }

    @Test
    public void hotelCanCheckGuestsOutOfConferenceRooms(){
        hotel.addConferenceRoom(conference1);
        hotel.checkInConference(guest1, conference1);
        hotel.checkOutConference(guest1, conference1);
        assertEquals(0, conference1.numberOfGuests());
    }

    @Test
    public void hotelCanCreateNewBooking() {
        Booking newBooking = hotel.bookRoom(bedroom1, 4);
        assertEquals(bedroom1, newBooking.getBedroom());
        assertEquals(4, newBooking.getNightsBooked());
    }
}

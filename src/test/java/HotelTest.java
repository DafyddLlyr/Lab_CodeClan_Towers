import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HotelTest {

    private Hotel hotel;
    private Guest guest1;
    private Guest guest2;
    private Bedroom bedroom1;
    private Bedroom bedroom2;
    private Bedroom bedroom3;
    private Bedroom bedroom4;
    private ArrayList<Bedroom> bedrooms;
    private ConferenceRoom conference1;
    private ArrayList<ConferenceRoom> conferenceRooms;
    private ConferenceRoom conference2;

    @Before
    public void setup() {
        guest1 = new Guest("Bob");
        guest2 = new Guest("Dave");

        bedrooms = new ArrayList<Bedroom>();
        bedroom1 = new Bedroom("127", 4, "Family", 100);
        bedroom2 = new Bedroom("31", 4, "Family", 150);
        bedroom3 = new Bedroom("1", 1, "Single", 80);
        bedroom4 = new Bedroom("12A", 2, "Double", 125);

        conferenceRooms = new ArrayList<ConferenceRoom>();
        conference1 = new ConferenceRoom("Deluxe Suite", 10);
        conference2 = new ConferenceRoom("Executive Suite", 10);

        hotel = new Hotel(bedrooms, conferenceRooms);
        hotel.addBedroom(bedroom1);
    }

    @Test
    public void hotelHasOneRoom() {
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
    public void cannotAddExistingRoomToHotel() {
        hotel.addBedroom(bedroom2);
        hotel.addBedroom(bedroom2);
        assertEquals(2, hotel.numberOfBedrooms());
    }

    @Test
    public void hotelStartsWithNoConferenceRoomsInCollection() {
        assertEquals(0, hotel.numberOfConferenceRooms());
    }

    @Test
    public void hotelCanCheckGuestsIntoBedrooms() {
        hotel.checkInBedroom(guest1, bedroom1);
        assertEquals(1, bedroom1.numberOfGuests());
    }

    @Test
    public void hotelCanOnlyCheckGuestsIntoEmptyBedrooms() {
        hotel.checkInBedroom(guest1, bedroom1);
        hotel.checkInBedroom(guest2, bedroom1);
        assertEquals(1, bedroom1.numberOfGuests());
    }

    @Test
    public void hotelCanCheckGuestsOutOfBedrooms() {
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
    public void hotelCanOnlyCheckGuestsIntoEmptyConferenceRooms() {
        hotel.addConferenceRoom(conference1);
        hotel.checkInConference(guest1, conference1);
        hotel.checkInConference(guest2, conference1);
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

    @Test
    public void newBookingChangesRoomStatus() {
        hotel.bookRoom(bedroom1, 4);
        assertTrue(bedroom1.isBooked());
    }

    @Test
    public void hotelCanReturnArrayListOfEmptyBedrooms(){
        hotel.addBedroom(bedroom2);
        hotel.addBedroom(bedroom3);
        hotel.addBedroom(bedroom4);
        hotel.bookRoom(bedroom1, 4);
        hotel.bookRoom(bedroom2, 4);
        assertEquals(2, hotel.emptyBedrooms().size());
        assertTrue(hotel.emptyBedrooms().contains(bedroom3));
        assertFalse(hotel.emptyBedrooms().contains(bedroom1));
    }

}

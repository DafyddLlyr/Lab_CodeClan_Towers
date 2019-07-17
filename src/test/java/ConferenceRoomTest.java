import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ConferenceRoomTest {

    ConferenceRoom conference;
    Guest guest1;
    Guest guest2;
    Guest guest3;

    @Before
    public void setup(){
        conference = new ConferenceRoom("Executive Lounge", 50);
        guest1 = new Guest("Bob");
        guest2 = new Guest("Dave");
        guest3 = new Guest("Jim");
    }

    @Test
    public void conferenceRoomHasName() {
        assertEquals("Executive Lounge", conference.getName());
    }

    @Test
    public void conferenceRoomHasCapacity() {
        assertEquals(50, conference.getCapacity());
    }

    @Test
    public void conferenceRoomStartsWithNoGuests() {
        assertEquals(0, conference.numberOfGuests());
    }


    @Test
    public void conferenceRoomCannotAddGuestsBeyondCapacity() {
        ConferenceRoom smallConference = new ConferenceRoom("Small Suite", 2);
        smallConference.addGuest(guest1);
        smallConference.addGuest(guest2);
        smallConference.addGuest(guest3);
        assertEquals(2, smallConference.numberOfGuests());
        assertFalse(smallConference.getGuests().contains(guest3));
    }

    @Test
    public void conferenceRoomCanRemoveGuest() {
        conference.addGuest(guest1);
        conference.removeGuest(guest1);
        assertEquals(0, conference.numberOfGuests());
    }

    @Test
    public void bedroomCannotRemoveGuestIfNotPresent() {
        conference.addGuest(guest1);
        conference.removeGuest(guest2);
        assertEquals(1, conference.numberOfGuests());
        assertFalse(conference.getGuests().contains(guest2));
    }

    @Test
    public void capacityDecreasesWithCheckIn() {
        conference.addGuest(guest1);
        assertEquals(49, conference.getCapacity());
    }

    @Test
    public void capacityIncreasesWithCheckout() {
        conference.addGuest(guest1);
        conference.removeGuest(guest1);
        assertEquals(50, conference.getCapacity());
    }
}

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BedroomTest {

    Bedroom bedroom;
    Guest guest1;
    Guest guest2;
    Guest guest3;

    @Before
    public void setup() {
        bedroom = new Bedroom("13A", 2, "Double", 100);
        guest1 = new Guest("Bob");
        guest2 = new Guest("Dave");
        guest3 = new Guest("Jim");
    }

    @Test
    public void bedroomHasRoomNumber() {
        assertEquals("13A", bedroom.getRoomNumber());
    }

    @Test
    public void bedroomHasCapacity() {
        assertEquals(2, bedroom.getCapacity());
    }

    @Test
    public void bedroomHasType() {
        assertEquals("Double", bedroom.getType());
    }

    @Test
    public void bedroomStartsWithEmptyCollectionOfGuests() {
        assertEquals(0, bedroom.numberOfGuests());
    }

    @Test
    public void bedroomHasNightlyRate(){
        assertEquals(100, bedroom.getRate());
    }

    @Test
    public void bedroomIsCreatedUnBooked() {
        assertFalse(bedroom.isBooked());
    }

    @Test
    public void bedroomCanBeMarkedAsBooked() {
        bedroom.markAsBooked();
        assertTrue(bedroom.isBooked());
    }

    @Test
    public void bedroomCanBeMarkedAsUnbooked() {
        bedroom.markAsBooked();
        bedroom.markAsUnbooked();
        assertFalse(bedroom.isBooked());
    }

    @Test
    public void bedroomCanAddGuest() {
        bedroom.addGuest(guest1);
        assertEquals(1, bedroom.numberOfGuests());
    }

    @Test
    public void bedroomCannotAddGuestsBeyondCapacity() {
        bedroom.addGuest(guest1);
        bedroom.addGuest(guest2);
        bedroom.addGuest(guest3);
        assertEquals(2, bedroom.numberOfGuests());
        assertFalse(bedroom.getGuests().contains(guest3));
    }

    @Test
    public void bedroomCanRemoveGuest() {
        bedroom.addGuest(guest1);
        bedroom.removeGuest(guest1);
        assertEquals(0, bedroom.numberOfGuests());
    }

    @Test
    public void bedroomCannotRemoveGuestIfNotPresent() {
        bedroom.addGuest(guest1);
        bedroom.removeGuest(guest2);
        assertEquals(1, bedroom.numberOfGuests());
        assertFalse(bedroom.getGuests().contains(guest2));
    }

    @Test
    public void capacityDecreasesWithCheckIn() {
        bedroom.addGuest(guest1);
        assertEquals(1, bedroom.getCapacity());
    }

    @Test
    public void capacityIncreasesWithCheckout() {
        bedroom.addGuest(guest1);
        bedroom.removeGuest(guest1);
        assertEquals(2, bedroom.getCapacity());
    }
}


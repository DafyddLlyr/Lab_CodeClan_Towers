import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookingTest {

    private Booking booking;
    private Bedroom bedroom;

    @Before
    public void setup(){
        bedroom = new Bedroom("127A", 4, "Family", 100);
        booking = new Booking(bedroom, 4);
    }

    @Test
    public void bookingHasAttachedBedroom() {
        assertEquals(bedroom, booking.getBedroom());
    }

    @Test
    public void bookingHasNumberOfNights() {
        assertEquals(4, booking.getNightsBooked());
    }

    @Test
    public void canAccessTotalBill() {
        assertEquals(400, booking.totalBill());
    }

}

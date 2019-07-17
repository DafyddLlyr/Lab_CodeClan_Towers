import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuestTest {

    private Guest guest;

    @Before
    public void setup(){
        guest = new Guest("Dafydd");
    }

    @Test
    public void guestHasName(){
        assertEquals("Dafydd", guest.getName());
    }

}

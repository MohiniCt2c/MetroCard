
import org.junit.Test;

import static org.junit.Assert.*;

public class MetroCardTest {

    @Test
    public void testBalanceAddition() {
        MetroCard card = new MetroCard("MC100");
        card.addBalance(100);
        assertEquals(100, card.getBalance());
    }

    @Test
    public void testFareDeduction() {
        MetroCard card = new MetroCard("MC101");
        card.addBalance(200);
        card.deductFare(50);
        assertEquals(150, card.getBalance());
    }

    @Test
    public void testReturnJourneyDetection() {
        MetroCard card = new MetroCard("MC102");
        card.recordJourney("CENTRAL");
        assertTrue(card.isReturnJourney("AIRPORT"));
        assertFalse(card.isReturnJourney("CENTRAL"));
    }


}

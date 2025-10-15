import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StationSummaryTest {
    @Test
    public void testFareAndDiscountTracking() {
        StationSummary summary = new StationSummary();
        summary.addFare(200);
        summary.addDiscount(50);
        assertEquals(200, summary.getFare());
        assertEquals(50, summary.getDiscount());
    }
    @Test
    public void testRechargeAndServiceFee() {
        StationSummary summary = new StationSummary();
        summary.addRecharge(100);
        summary.addServiceFee(2);
        assertEquals(100, summary.getRecharge());
        assertEquals(2, summary.getServiceFee());
    }



}

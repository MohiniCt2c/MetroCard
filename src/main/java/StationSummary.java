public class StationSummary {
    private int fare = 0;
    private int discount = 0;
    private int recharge = 0;
    private int serviceFee = 0;

    public void addFare(int amount) { fare += amount; }
    public void addDiscount(int amount) { discount += amount; }
    public void addRecharge(int amount) { recharge += amount; }
    public void addServiceFee(int amount) { serviceFee += amount; }

    public int getFare() { return fare; }
    public int getDiscount() { return discount; }
    public int getRecharge() { return recharge; }
    public int getServiceFee() { return serviceFee; }

}

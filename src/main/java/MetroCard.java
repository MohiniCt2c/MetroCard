import java.util.*;


public class MetroCard {
    private final String id;
    private int balance;
    private final List<String> journeyHistory = new ArrayList<>();

    public MetroCard(String id) {
        this.id = id;
        this.balance = 0;
    }

    public void addBalance(int amount) {
        balance += amount;
    }

    public void deductFare(int fare) {
        balance -= fare;
    }

    public int getBalance() {
        return balance;
    }

    public void recordJourney(String station) {
        journeyHistory.add(station);
    }

    public boolean isReturnJourney(String station) {
        return !journeyHistory.isEmpty() && !journeyHistory.get(journeyHistory.size() - 1).equals(station);
    }

}

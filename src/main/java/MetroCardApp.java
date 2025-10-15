import java.io.*;
import java.util.*;


public class MetroCardApp {
    private static final Map<String, MetroCard> cards = new HashMap<>();
    private static final Map<String, StationSummary> stationSummary = new HashMap<>();
    private static final Map<PassengerType, Integer> passengerCount = new HashMap<>();

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: java MetroCardApp <input_file>");
            return;
        }

        stationSummary.put("CENTRAL", new StationSummary());
        stationSummary.put("AIRPORT", new StationSummary());

        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String line;
        while ((line = reader.readLine()) != null) {
            processCommand(line.trim());
        }

        printCollectionSummary();
        printPassengerSummary();
    }

    private static void processCommand(String line) {
        if(line.isEmpty()) return;
        String[] parts = line.split(" ");
        switch (parts[0]) {
            case "BALANCE":
                cards.putIfAbsent(parts[1], new MetroCard(parts[1]));
                cards.get(parts[1]).addBalance(Integer.parseInt(parts[2]));
                break;
            case "CHECK_IN":
                handleCheckIn(parts[1], PassengerType.valueOf(parts[2]), parts[3]);
                break;

        }

    }

    private static void handleCheckIn(String cardId, PassengerType type, String station) {
        MetroCard card = cards.get(cardId);
        if (card == null) return;

          boolean isReturn = card.isReturnJourney(station);
        int baseFare = type.getFare();
        int fare = isReturn ? baseFare / 2 : baseFare;
        int discount = isReturn ? baseFare - fare : 0;

        int balance = card.getBalance();
        int recharge = 0, serviceFee = 0;

        if (balance < fare) {
            recharge = fare - balance;
            serviceFee = (int) Math.ceil(recharge * 0.02);
            card.addBalance(recharge);
            stationSummary.get(station).addServiceFee(serviceFee);
            stationSummary.get(station).addRecharge(recharge);
        }

        card.deductFare(fare);
        card.recordJourney(station);

        stationSummary.get(station).addFare(fare);
        stationSummary.get(station).addDiscount(discount);
        passengerCount.put(type, passengerCount.getOrDefault(type, 0) + 1);

    }
    private static void printCollectionSummary() {
        for (String station : Arrays.asList("CENTRAL", "AIRPORT")) {
            StationSummary summary = stationSummary.get(station);
            System.out.println("Collection Summary for " + station);
            System.out.println("Total Amount Collected: " + (summary.getFare() + summary.getServiceFee()));
            System.out.println("Total Discount Given: " + summary.getDiscount());
            System.out.println();
        }

    }

    private static void printPassengerSummary() {
        System.out.println("Passenger Summary");
        for (String station : Arrays.asList("CENTRAL", "AIRPORT")) {
            StationSummary summary = stationSummary.get(station);
            System.out.println("Collection Summary for " + station);
            System.out.println("Total Amount Collected: " + (summary.getFare() + summary.getServiceFee()));
            System.out.println("Total Discount Given: " + summary.getDiscount());
            System.out.println();
        }



    }





}



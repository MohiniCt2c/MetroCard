public enum PassengerType {
    ADULT(200),
    SENIOR_CITIZEN(100),
    KID(50);

    private final int fare;

    PassengerType(int fare) {
        this.fare = fare;
    }

    public int getFare() {
        return fare;
    }
}


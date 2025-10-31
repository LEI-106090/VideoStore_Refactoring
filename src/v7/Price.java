package v7;

public abstract class Price {

    public enum Code {REGULAR, CHILDRENS, NEW_RELEASE}

    public abstract Code getPriceCode();
    public abstract double getRentalAmount(int duration);

    public int getFrequentRentalPoints(int duration) {
        return 1; // default behavior
    }
}

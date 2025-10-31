package v7;

public class NewReleasePrice extends Price {

    @Override
    public Code getPriceCode() {
        return Code.NEW_RELEASE;
    }

    @Override
    public double getRentalAmount(int duration) {
        return duration * 3;
    }

    @Override
    public int getFrequentRentalPoints(int duration) {
        return (duration > 1 ? 2 : 1);
    }
}

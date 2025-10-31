package v7;

public class Movie {

    private String _title;
    private Price _price;

    public Movie(String title, Price price) {
        _title = title;
        _price = price;
    }

    public String getTitle() {
        return _title;
    }

    public Price.Code getPriceCode() {
        return _price.getPriceCode();
    }

    public double getRentalAmount(int duration) {
        return _price.getRentalAmount(duration);
    }

    public int getFrequentRentalPoints(int duration) {
        return _price.getFrequentRentalPoints(duration);
    }

    public void setPrice(Price price) {
        _price = price;
    }
}

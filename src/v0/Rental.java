package v0;

public class Rental
{
	private Movie	_movie;
	private int		_daysRented;

	public Rental(Movie movie, int daysRented)
	{
		_movie = movie;
		_daysRented = daysRented;
	}

	public int getDaysRented()
	{
		return _daysRented;
	}

	public Movie getMovie()
	{
		return _movie;
	}

    double getThisAmount() {
        double thisAmount = 0;

        // determine amounts for each line
        switch (getMovie().getPriceCode())
        {
            case REGULAR:
                thisAmount += 2;
                if (getDaysRented() > 2)
                    thisAmount += (getDaysRented() - 2) * 1.5;
                break;
            case NEW_RELEASE:
                thisAmount += getDaysRented() * 3;
                break;
            case CHILDRENS:
                thisAmount += 1.5;
                if (getDaysRented() > 3)
                    thisAmount += (getDaysRented() - 3) * 1.5;
                break;
        }
        return thisAmount;
    }

    int updatePoints(int frequentRenterPoints) {
        // add frequent renter points
        frequentRenterPoints++;

        // add bonus for a two day new release rental
        if ((getMovie().getPriceCode() == Movie.Code.NEW_RELEASE) && getDaysRented() > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }
}

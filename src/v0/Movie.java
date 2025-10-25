package v0;

public class Movie {


    public enum Code {REGULAR, CHILDRENS, NEW_RELEASE};

	private String _title;
	private Code _priceCode;
    private boolean _isBluRay;

	public Movie(String title, Code priceCode, boolean isBluRay) {
		_title = title;
		_priceCode = priceCode;
        _isBluRay = isBluRay;
	}

	public String getTitle() {
		return _title;
	}

	public Code getPriceCode() {
		return _priceCode;
	}

    public boolean isBluRay() { return _isBluRay;
    }
}

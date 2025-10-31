package v0;

import java.util.Vector;

public class Customer
{
	private String			_name;
	private Vector<Rental>	_rentals	= new Vector<Rental>();

	public Customer(String _name)
	{
		this._name = _name;
	}

	public void addRental(Rental arg)
	{
		_rentals.addElement(arg);
	}

	public String getName()
	{
		return _name;
	}

	public String statement()
	{
		double totalAmount = 0;
		int frequentRenterPoints = 0;

		// header
		String result = "Rental Record for " + getName() + "\n";
		
		for (Rental each: _rentals)
		{
            double thisAmount = each.getThisAmount();

            frequentRenterPoints = each.updatePoints(frequentRenterPoints);

            // show figures for this rental
			result += "\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n";
			totalAmount += thisAmount;
		}

		// add footer lines
		result += "Amount owed is " + totalAmount + "\n";
		result += "You earned " + frequentRenterPoints + " frequent renter points";
		return result;
	}


    // Customer.java
    public String htmlStatement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        StringBuilder html = new StringBuilder();

        html.append("<font size=\"4\" face=\"Georgia, Arial, Garamond\" color=\"green\">");
        html.append("<h2>Rental Record for <i>").append(escapeHtml(getName())).append("</i></h2>");
        html.append("<table border=\"1\">");
        html.append("<tr><th>Movie</th><th>Days</th><th>Cost</th><th>Points</th><th>Blu-ray</th></tr>");

        for (Rental each : _rentals) {
            double thisAmount = each.getThisAmount();

            int beforePoints = frequentRenterPoints;
            frequentRenterPoints = each.updatePoints(frequentRenterPoints);
            int pointsEarned = frequentRenterPoints - beforePoints;

            String title = escapeHtml(each.getMovie().getTitle());
            int days = each.getDaysRented();

            boolean isBluRay = false;
            try {
                isBluRay = each.getMovie().isBluRay();
            } catch (Throwable t) {
                // método opcional em Movie; manter false se ausente
            }

            html.append("<tr>");
            html.append("<td>").append(title).append("</td>");
            html.append("<td>").append(days).append("</td>");
            html.append("<td>").append(String.format("%.2f", thisAmount)).append("</td>");
            html.append("<td>").append(pointsEarned).append("</td>");
            html.append("<td>").append(isBluRay ? "true" : "false").append("</td>");
            html.append("</tr>");

            totalAmount += thisAmount;
        }

        html.append("</table>");
        html.append("Amount owed is ").append(String.format("%.2f", totalAmount)).append("<br>");
        html.append("You earned ").append(frequentRenterPoints).append(" frequent renter points<br>");
        html.append("</font>");

        return html.toString();
    }

    private String escapeHtml(String s) {
        if (s == null) return "";
        return s.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }


}

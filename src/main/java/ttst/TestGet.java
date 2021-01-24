package ttst;

public class TestGet 
{
	double price;
	
	public double getNextPrice()
	{
		Auction auction = new Auction();
		return auction.getNextPrice();
	}
}

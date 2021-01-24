package fitnesse;

import ttst.Auction;

public class GetNextPriceFixture 
{
	public double getNextPrice()
	{
		Auction auction = new Auction();
		return auction.getNextPrice();
	}
	
	
}

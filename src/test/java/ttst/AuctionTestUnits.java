package ttst;

import org.junit.Test;
import ttst.Auction;
import ttst.Item;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class AuctionTestUnits {
	private static Date today = Calendar.getInstance().getTime();
	protected static double startPrice = 420.;
	protected static long startTime = new Date(today.getYear(), today.getMonth(), today.getDate(), 12, 30).getTime();
	protected static long endTime = System.currentTimeMillis() + 10000;
	protected static double bidIncrement = 3.22;
	public static Auction auction = new Auction(
			new Item("My ancient item", bidIncrement, null, 6990),
			startPrice, startTime, endTime);
	private User user = new User("test", "user");

	@Test
	public void checkPrice() {
		double validNextPrice = 430.;
		double invalidNextPrice = startPrice - 10;
		double alwaysInvalidPrice = 0;
		auction.setStartPrice(startPrice);
		assertTrue(String.format("Checking proposedPrice >= currentPrice: %f >= %f\n", validNextPrice, auction.getStartPrice()), auction.checkPriceValidity(validNextPrice));
		assertTrue(String.format("Checking with proposedPrice < currentPrice: %f >= %f\n", validNextPrice, startPrice), auction.checkPriceValidity(invalidNextPrice));
		assertFalse("Price cannot be <=0", auction.checkPriceValidity(alwaysInvalidPrice));
	}

	@Test
	public void incorrectBidTest() {
		double nextPurposedPrice = 5.;
		auction.setNextPrice(10); // knowing that the previous price was 10
		assertFalse(String.format("Testing false for nextPurposedPrice < Auction.nextPrice, values: %f\t%f",
				nextPurposedPrice, auction.getNextPrice()),
				auction.checkPriceValidity(5.0));
		assertFalse("Negative values aren't allowed", auction.checkPriceValidity(-1.));
		assertTrue("11 is a valid value", auction.checkPriceValidity(11.));
	}

	@Test
	public void auctionStillOpenTest() {
		System.out.println(auction.hasStarted());
		assertTrue("Start at: " + startTime, auction.hasStarted());
	}

	@Test
	public void auctionExpiredTest() {
		assertFalse("Expiration date: " + endTime, auction.hasExpired()); // We should still be in the range of validity
	}

	@Test
	public void addBidGood() {
		Bid bid = new Bid(12.00, user);

		boolean added = auction.addBid(bid);

		assertTrue(added);
	}
}

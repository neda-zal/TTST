package ttst;

import exceptions.AuctionAlreadyPresentException;
import exceptions.AuctionNotOfTheItemException;
import org.junit.Test;
import ttst.Auction;
import ttst.Item;

import static org.junit.Assert.*;

public class ItemTestUnit {
	protected static double bidIncrement = 3.22;
	protected static Item item = new Item("My ancient item", bidIncrement, null, 6990);
	@Test
	public void addAuctionTest() {
		double startPrice = 40;
		long startTime = 0, endTime = System.currentTimeMillis() * 10;
		boolean added = true;
		try {
			item.addAuction(new Auction(item, startPrice, startTime, endTime));
		} catch (AuctionNotOfTheItemException | AuctionAlreadyPresentException e) {
			added = false;
		}
		assertTrue("Item has been added", added);
	}
}

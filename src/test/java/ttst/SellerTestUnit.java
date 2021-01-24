package ttst;

import exceptions.*;
import org.junit.Test;
import ttst.Image;
import ttst.Item;
import ttst.Seller;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class SellerTestUnit {
	protected static Seller seller = Seller.getInstance();
	private String desc = "amazing old bible";
	private double bidIncrement = 100;
	private ArrayList<Image> images = new ArrayList<>();
	private int catID = 4;
	@Test
	public void addItemTest() {
		boolean added = true;
		String msg = "";
		try {
			added = seller.addItem(desc, bidIncrement, images, catID);
		} catch (InvalidCategoryException | InvalidBidIncrementException | InvalidDescriptionException e) {
			added = false;
			msg = e.getMessage();
		}

		assertTrue(msg, added);
	}

	@Test
	public void modifyItemTest() {
		Item old_item = Item.getItems().get(Item.getItems().size() - 1);
		String msg = "";
		boolean added = false;
		try {
			added = seller.modifyItem(old_item.getItemId(), "amazing old bible with special characters", bidIncrement * 2, images, catID);
		} catch (InvalidDescriptionException | InvalidCategoryException | InvalidBidIncrementException | InvalidOwnerException | InOpenAuctionException e) {
			msg = e.toString();
		}

		assertFalse(msg, added);
	}

	@Test
	public void createAuctionTest() {
		Item oldItem = Item.getItems().get(Item.getItems().size() - 1);
		final double startPrice = 2000;
		final long startTime = System.currentTimeMillis() + 1, endTime = startTime + 30180;
		boolean created = false;
		String errMsg = "";
		try {
			created = seller.createAuction(oldItem.getItemId(), startPrice, startTime, endTime);
		} catch (InvalidOwnerException | InvalidPriceException | InvalidTimeException e) {
			errMsg = e.toString();
		}

		assertTrue(errMsg, created);
	}
}

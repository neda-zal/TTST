package ttst;

import exceptions.*;
import org.junit.Test;
import ttst.Auction;
import ttst.User;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class UserTestUnit {
	private final static String username = "dfilippi", password = "password";
	@Test
	public void registrationTest() {
		boolean registered = false;
		String msg = "";
		try {
			registered = User.register(username, password);
		} catch (EmptyPasswordException | EmptyUsernameException | ShortPasswordException e) {
			e.printStackTrace();
			msg = e.getMessage();
		}

		assertTrue(msg, registered);
	}

	@Test
	public void placingBidTest() {
		boolean bidPlaced = false;
		String msg = "";
		try {
			bidPlaced = User.getInstance().placeBid(1, 125);
		} catch (InvalidAuctionIdException | NotOpenedAuctionException | LowPriceException | AuctionExpiredException e) {
			msg = e.getMessage();
		}
		assertTrue(msg, bidPlaced);

		bidPlaced = false; msg = "";
		try {
			bidPlaced = User.getInstance().placeBid(-1, 125);
		} catch (InvalidAuctionIdException | NotOpenedAuctionException | LowPriceException | AuctionExpiredException e) {
			msg = e.getMessage();
		}
		assertFalse(msg, bidPlaced);

		bidPlaced = false; msg = "";
		try {
			bidPlaced = User.getInstance().placeBid(1, 120);
		} catch (InvalidAuctionIdException | NotOpenedAuctionException | LowPriceException | AuctionExpiredException e) {
			msg = e.getMessage();
		}
		assertFalse(msg, bidPlaced);
	}

	@Test
	public void loggingInTest() {
		User userLogin = null;
		String msg = "";
		try {
			userLogin = User.login(username, password);
		} catch (EmptyUsernameException | EmptyPasswordException | ShortPasswordException | UnexistingUserException | WrongPasswordException e) {
			msg = e.toString();
		}

		assertNotNull(msg, userLogin);

		userLogin = null; msg = "";
		try {
			userLogin = User.login(username + "_nonexistent", password);
		} catch (EmptyUsernameException | EmptyPasswordException | ShortPasswordException | UnexistingUserException | WrongPasswordException e) {
			msg = e.toString();
		}
		assertNull(msg, userLogin);
	}

	@Test
	public void researchTest() {
		User user = User.getInstance();
		final int categoryID = 4;
		final String description = "books";
		final double minPrice = 2000, maxPrice = 10000;
		final long startAt = System.currentTimeMillis(), endAt = startAt + 30180;

		String msg = "";
		ArrayList ret = null;
		try {
			ret = user.searchAuction(categoryID, description, minPrice, maxPrice, startAt, endAt);
		} catch (InvalidCategoryException | LongDescriptionException | MaxPriceSmallerThanMinPriceException | EndDateBeforeStartDateException e) {
			msg = e.toString();
		}

		assertNotNull(msg, ret);

		ret = null; msg = "";
		try {
			ret = user.searchAuction(categoryID, description, minPrice, maxPrice, endAt, startAt);
		} catch (InvalidCategoryException | LongDescriptionException | MaxPriceSmallerThanMinPriceException | EndDateBeforeStartDateException e) {
			msg = e.toString();
		}
		assertNull(msg, ret);

		ret = null; msg = "";
		try {
			ret = user.searchAuction(categoryID, description, maxPrice, minPrice, endAt, startAt);
		} catch (InvalidCategoryException | LongDescriptionException | MaxPriceSmallerThanMinPriceException | EndDateBeforeStartDateException e) {
			msg = e.toString();
		}
		assertNull(msg, ret);

		ret = null; msg = "";
		try {
			ret = user.searchAuction(Auction.getAuctions().size(), description, minPrice, maxPrice, endAt, startAt);
		} catch (InvalidCategoryException | LongDescriptionException | MaxPriceSmallerThanMinPriceException | EndDateBeforeStartDateException e) {
			msg = e.toString();
		}
		assertNull(msg, ret);
	}
}

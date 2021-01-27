package ttst;

import exceptions.AuctionExpiredException;
import exceptions.InvalidAuctionIdException;
import exceptions.LowPriceException;
import exceptions.NotOpenedAuctionException;
import org.junit.Before;
import org.junit.Test;
import ttst.Auction;
import ttst.Item;
import ttst.Bid;
import ttst.User;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AuctionIntegrationTest {

    private ArrayList<Auction> auctions = new ArrayList<>();
    private ArrayList<Item> items = new ArrayList<>();
    private ArrayList<Bid> bids = new ArrayList<>();
    Bid max = null;

    private User user = new User("test","test");
    Item item = new Item("description test",50.00,null,3);

    Auction auction = new Auction(item, 250.00,System.currentTimeMillis() - 2000,
            System.currentTimeMillis() + 2000);

    private static final double DELTA = 1e-15;

    @Before
    public void setup() {
        auctions.add(auction);
        items.add(item);
    }

    @Test
    public void searchHighestBidTest() throws InvalidAuctionIdException, NotOpenedAuctionException, LowPriceException, AuctionExpiredException {

        assertEquals(null, auction.searchHighestBid());

        user.placeBid(auction.getId(),250.00);

        max = auction.searchHighestBid();
        assertEquals(250.00, max.getPrice(), DELTA);

        user.placeBid(auction.getId(),300.50);
        max = auction.searchHighestBid();
        assertNotEquals(250.0, max.getPrice(), DELTA);

    }

}


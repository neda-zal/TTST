package ttst;

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

    //test for the searchHighestBid() function in the .jar
    private static Calendar calendar = Calendar.getInstance();
    private static Date today = calendar.getTime();

    private User user = new User("test","test");
    Item item = new Item("description test",50.00,null,3);

    @Test
    public void searchHighestBidTest() {
        //List<Bid> bids = new ArrayList<Bid>();
        Auction auction = new Auction(item, 250.00,23000000,23500000);
        //bids.add(12.50,today,user);
        Bid max = null;
        String msg = null;

        assertNull("the list of bids is empty", auction.searchHighestBid());

        //bids.add(12.50,today,user);
        //assertNotNull("The highest bid", max);
    }

}

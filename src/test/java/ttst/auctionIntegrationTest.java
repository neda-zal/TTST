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

public class auctionIntegrationTestUnits {

    //test for the searchHighestBid() function in the .jar
    private static Date today = Calendar.getInstance().getTime();
    private User user = new User("test","test");

    @Test
    public void searchHighestBidTest() {
        List<Bid> bids = new ArrayList<Bid>();
        //bids.add(12.50,today,user);
        Bid max = null;
        String msg = null;
        try{
            searchHighestBid(bids);
        } catch (Exception e) {
            msg = e.toString();
        }
        assertNull(msg, bids);

        //bids.add(12.50,today,user);
        try{
            searchHighestBid(bids);
        } catch (Exception e){
            msg = e.toString();
        }
        assertNotNull(msg, max);
    }

}

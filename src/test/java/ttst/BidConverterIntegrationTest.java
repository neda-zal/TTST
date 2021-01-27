package ttst;

import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;

import static org.junit.Assert.assertEquals;

public class BidConverterIntegrationTest {

    private BidConverter converter = new BidConverter();
    private  User user = new User("test", "password");

    private static final double DELTA = 1e-15;

    @Test
    public void ConvertBidToJarBid() {

        Bid bid = new Bid(10.00, user);
        it.unibz.inf.be.Bid jarBid = converter.toJarBid(bid);

        assertEquals(bid.getPrice() * 100, jarBid.getPrice(), DELTA);
    }


    @Test
    public void ConvertJarBidToTtstBid() {

        User expected = new User("test", "password");

        double price = 100000;
        ttst.Bid bid = new ttst.Bid(price, expected);
        bid.setTime(System.currentTimeMillis() + 1000);

        it.unibz.inf.be.Bid newBid = new it.unibz.inf.be.Bid((int) bid.getBidder().getId(),
                0, new Timestamp(bid.getTime()), (int) (bid.getPrice() * 100));

        ttst.Bid resultBid = converter.convertToTtstBid(newBid);

        assertEquals(bid.getPrice(), resultBid.getPrice(), DELTA);
        assertEquals(bid.getTime(), resultBid.getTime());
        assertEquals(bid.getBidder(), resultBid.getBidder());

    }

}

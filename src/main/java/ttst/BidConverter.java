package ttst;
import java.sql.Timestamp;

public class BidConverter {
    public it.unibz.inf.be.Bid toJarBid(ttst.Bid bid) {
        return new it.unibz.inf.be.Bid(
            (int) bid.getBidder().getId(), 0, new Timestamp(bid.getTime()),
            (int) (bid.getPrice() * 100)
        );
    }
    public ttst.Bid convertToTtstBid(it.unibz.inf.be.Bid bid) {
        double price = ((double) bid.getPrice()) / 100;
        long time = bid.getBidTime().getTime();
        User user = User.getUser(bid.getUserID());
        ttst.Bid newBid = new ttst.Bid(price, user);
        newBid.setTime(time);
        return newBid;
    }
}

package EJB;

import entity.Auction;
import entity.Bid;

public abstract class AuctionValidator<T extends Auction> {

    private Auction auction;

    public AuctionValidator(T t){
        auction = t;
    }

    public abstract Boolean isValidBid(Bid bid);
}

package EJB;

import entity.Bid;
import entity.User;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import entity.Auction;

@Stateless
public class BidValidator {

	public Boolean isValidBid(Bid bid) {
	    if (bid.getAmount() <= 0)
            return false;

		Auction bidAuction = bid.getAuction();
		
		//The bid has to be the highest bid
		for(Bid other : bidAuction.getBids()){
            if (other.getAmount() >= bid.getAmount())
                return false;
        }
		
		//The auction has to be published
		if (!bidAuction.getPublished()) {
			return false;
		}
		
		//The auction should not be over
		Date now = new Date();
		if(LocalDate.now().isAfter(bidAuction.getEndDate())) {
			return false;
		}
		
		//The auction should have started
		if(LocalDate.now().isBefore(bidAuction.getStartDate())) {
			return false;
		}
		
		//The bidder should not be the owner of the auction
		User bidder = bid.getOwner();
		User auctOwner = bidAuction.getOwner();
		if(bidder.equals(auctOwner)) {
			return false;
		}

		return true;
	}
}

package EJB;

import entity.Bid;
import entity.User;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import entity.Auction;

@Stateless
public class BidValidator {

	public Boolean isValidBid(Bid bid) {
		Auction bidAuction = bid.getAuction();
		
		//The bid has to be the highest bid
		List<Bid> otherBids = bidAuction.getBids();
		for(int i = 0; i < otherBids.size(); i++) {
			if(otherBids.get(i).getAmount() >= bid.getAmount() ) {
				return false;
			}
		}
		
		//The auction has to be published
		if (bidAuction.getPublished() == false) {
			return false;
		}
		
		//The auction should not be over
		Date now = new Date();
		if(now.after(bidAuction.getEndDate())) {
			return false;
		}
		
		//The auction should have started
		if(now.before(bidAuction.getStartDate())) {
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

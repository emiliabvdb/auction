package entities;

import java.util.Date;
import java.util.List;

@Entity
@Inherit
public class EnglishAuction extends Auction{

	@Override
	public Bid getHighetBid() {
		Bid highest = null;
		for (int i = 0; i < bid.size(); i++) {
			if(bid.get(i).amount > highest.amount) {
				highest = bid.get(i);
			}
		}
		return highest;
	}

	@Override
	User getOwner() {
		return this.owner;
	}

	@Override
	Date getStarTime() {
		return this.startDate;
	}

	@Override
	Date getEndTime() {
		return this.endDate;
	}

	@Override
	List<Bid> getAllBids() {
		return this.bid;
	}
	
}

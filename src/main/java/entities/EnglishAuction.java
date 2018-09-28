package entities;

import java.util.Date;
import java.util.List;

@Entity
@Inherit
public class EnglishAuction extends Auction{

	@Override
	public Bid getHighetBid() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	User getOwer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Date getStarTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Date getEndTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	List<Bid> getAllBids() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

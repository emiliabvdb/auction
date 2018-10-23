package EJB;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import entity.Auction;
import entity.Bid;

@Stateless
public abstract class AuctionValidator<T extends Auction> {

    private Auction auction;

    public AuctionValidator(T t){
        auction = t;
    }
    
    /*
     * Returns true if the auction can be published
     */
    public boolean validateAuctionPublishing() {
    	//if it's already published, it can't be published
    	if(auction.getPublished()) {
    		return false;
    	}
    	//if the auction has ended, you can't publish it again. 
        if (LocalDate.now().isAfter(auction.getEndDate())) {
         	return false;
        }
        return true;
    }
    
    /*
     * Returns true if the auction can be deleted
     */
    public boolean validateAuctionDeleting() {
    	//cannot delete auctions where someone has bidded on the product. 
    	List<Bid> bidList = auction.getBids();
    	if (bidList.size() != 0) {
    		return false;
    	}
    	return true;
    	
    }
    
    
    
}

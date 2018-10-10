package SOAP;

import DAO.BidDAO;
import EJB.BidValidator;
import entity.Bid;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
@Stateless
public class BidWebResource {

    @EJB
    private BidDAO bidDAO;

    //a method which places a bid of a given amount in an auction and informs as to it is currently the highest bid.
    @WebResult(name = "IsValid")
    public Boolean placeBid(Bid bid) {
    	
    	//Check if bid is valid
        BidValidator bidVal = new BidValidator();
        if(!bidVal.isValidBid(bid)) {
        	return false;
        }
        //informs as to it is currently the highest bid
        List<Bid> bids = bid.getAuction().getBids();
        bids.add(bid);
        bid.getAuction().setBids(bids);
        
        return true;
    }
}

package SOAP;

import DAO.BidDAO;
import EJB.BidValidator;
import entity.Bid;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
@Stateless
public class BidWebResource {

    @EJB
    private BidDAO bidDAO;

     @EJB
    BidValidator bidValidator;

    //a method which places a bid of a given amount in an auction and informs as to it is currently the highest bid.
    @WebMethod(operationName = "IsValid")
    @WebResult(name = "IsValid")
    public Boolean placeBid(Bid bid) {

    	//Check if bid is valid
        if(!bidValidator.isValidBid(bid)) {
        	return false;
        }
        //informs as to it is currently the highest bid
        List<Bid> bids = bid.getAuction().getBids();
        bids.add(bid);
        bid.getAuction().setBids(bids);

        bidDAO.create(bid);
        
        return true;
    }
}

package SOAP;

import DAO.BidDAO;
import EJB.BidValidator;
import entity.Bid;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
@Stateless
public class BidWebResource {

    @EJB
    private BidDAO bidDAO;

    @WebResult(name = "IsValid")
    public Boolean placeBid(Bid bid) {
    	
    	//Check if bid is valid
        BidValidator bidVal = new BidValidator(bid);
        if(bidVal.isValidBid(bid)) {
        	//TODO: return some kind of error
        }

    }
}

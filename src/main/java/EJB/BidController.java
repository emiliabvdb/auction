package EJB;

import DAO.BidDAO;
import SOAP.BidService;
import entity.Bid;


import javax.ejb.EJB;
import javax.jws.WebService;

@WebService(endpointInterface = "SOAP.BidService")
public class BidController implements BidService{

    @EJB
    private BidDAO bidDAO;

    @EJB
    private BidValidator bidValidator;

    //a method which places a bid of a given amount in an auction and informs as to it is currently the highest bid.
    public Boolean isValid(Long bidId) {

        Bid bid = bidDAO.findById(bidId);

        //Check if bid is valid
        if(!bidValidator.isValidBid(bid)) {
            return false;
        }

        bidDAO.create(bid);

        return true;
    }

	@Override
	public Boolean placeBid(Bid bid) {
		// TODO Auto-generated method stub
		return null;
	}
}

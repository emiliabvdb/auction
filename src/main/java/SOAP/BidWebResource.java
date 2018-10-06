package SOAP;

import DAO.BidDAO;
import entity.Bid;

import javax.ejb.EJB;
import javax.jws.WebService;

@WebService
public class BidWebResource {

    @EJB
    private BidDAO bidDAO;

    public Boolean placeBid(Bid bid) {
        // TODO - Logic?
        return true;
    }
}

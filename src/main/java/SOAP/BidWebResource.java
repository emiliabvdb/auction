package SOAP;

import DAO.BidDAO;
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
        // TODO - Logic?
        return true;
    }
}

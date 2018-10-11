package SOAP;

import DAO.AuctionDAO;
import entity.Auction;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

@WebService
@Stateless
public class AuctionWebResource {

    @EJB
    AuctionDAO auctionDAO;

    @WebResult(name = "AuctionById")
    public Auction get(Long auctionId) {
        return auctionDAO.findById(auctionId);
    }

    @WebResult(name = "AllAuctions")
    public List<Auction> getPublished() {
        return auctionDAO.findAllPublished();
    }

}

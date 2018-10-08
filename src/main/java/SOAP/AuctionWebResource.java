package SOAP;

import DAO.AuctionDAO;
import entity.Auction;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import java.util.List;

@WebService
@Stateless
public class AuctionWebResource {

    @EJB
    AuctionDAO auctionDAO;

    public Auction get(Long auctionId) {
        return auctionDAO.findById(auctionId);
    }

    public List<Auction> getPublished() {
        return auctionDAO.findAllPublished();
    }

}
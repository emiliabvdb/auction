package EJB;

import DAO.AuctionDAO;
import SOAP.AuctionService;
import entity.Auction;

import javax.ejb.EJB;
import javax.jws.WebService;
import java.util.ArrayList;

@WebService(endpointInterface = "SOAP.AuctionService")
public class AuctionController implements AuctionService {

    @EJB
    AuctionDAO auctionDAO;

    public Auction get(Long auctionId) {
        Auction auction = auctionDAO.findById(auctionId);
        return auction;
    }

    public ArrayList<Auction> getPublished() {
        ArrayList list = (ArrayList<Auction>) auctionDAO.findAllPublished();
        if (list == null){
            list = new ArrayList<Auction>();
        }
        return list;
    }

}

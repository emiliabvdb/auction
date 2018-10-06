package REST;

import DAO.AuctionDAO;
import DAO.BidDAO;
import entity.Bid;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("auction/{auctionId}/bid/")
@Stateless
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class BidResource {

    @EJB
    private BidDAO bidDAO;

    @EJB
    private AuctionDAO auctionDAO;

    @GET
    public List<Bid> getList(@PathParam("auctionId") Long auctionId) {
        return bidDAO.findAllOnAuction(auctionId);
    }

    @GET
    @Path("{id}")
    public Bid get(@PathParam("auctionId") Long auctionId, @PathParam("id") Long id) {
        return bidDAO.findOnAuctionById(auctionId, id);
    }

    @POST
    public Bid save(@PathParam("auctionId") Long auctionId, Bid bid) {
        bid.setAuction(auctionDAO.findById(auctionId));
        bidDAO.create(bid);
        return bid;
    }

    @DELETE
    public Bid delete(Bid bid) {
        bidDAO.delete(bid);
        return bid;
    }
}

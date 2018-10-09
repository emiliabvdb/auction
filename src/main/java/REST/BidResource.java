package REST;

import DAO.AuctionDAO;
import DAO.BidDAO;
import entity.Auction;
import entity.Bid;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("auction/{auctionId}/bid/")
@Stateless
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class BidResource {

    private static final String AUCTION_NOT_FOUND = "Auction Not Found";
    private static final String BID_EXISTS = "Bid Already Exists";
    private static final String BID_NOT_FOUND = "Bid Not Found";


    @EJB
    private BidDAO bidDAO;

    @EJB
    private AuctionDAO auctionDAO;

    @GET
    public List<Bid> getList(@PathParam("auctionId") Long auctionId) {
        List<Bid> bids = bidDAO.findAllOnAuction(auctionId);

        if (bids.isEmpty() && auctionDAO.findById(auctionId) == null)
            throw new NotFoundException(BidResource.AUCTION_NOT_FOUND);

        return bids;
    }

    @GET
    @Path("{id}")
    public Bid get(@PathParam("auctionId") Long auctionId, @PathParam("id") Long id) {
        Bid bid = bidDAO.findOnAuctionById(auctionId, id);

        if (bid == null)
            if (auctionDAO.findById(auctionId) == null)
                throw new NotFoundException(BidResource.AUCTION_NOT_FOUND);
            else
                throw new NotFoundException(BidResource.BID_NOT_FOUND);

        return bid;
    }

    @POST
    public Bid save(@PathParam("auctionId") Long auctionId, Bid bid) {
        Auction auction = auctionDAO.findById(auctionId);

        if (auction == null)
            throw new NotFoundException(BidResource.AUCTION_NOT_FOUND);

        bid.setAuction(auction);

        try{
            bidDAO.create(bid);
        } catch (EntityExistsException e){
            throw new ClientErrorException(BidResource.BID_EXISTS, 409);
        }
        return bid;
    }

    @Path("{id}")
    @DELETE
    public Bid delete(@PathParam("auctionId") Long auctionId, @PathParam("id") Long id) {
        Bid bid = bidDAO.findOnAuctionById(auctionId, id);

        if (bid == null)
            if (auctionDAO.findById(auctionId) == null)
                throw new NotFoundException(BidResource.AUCTION_NOT_FOUND);
            else
                throw new NotFoundException(BidResource.BID_NOT_FOUND);

        bidDAO.delete(bid);
        return bid;
    }
}

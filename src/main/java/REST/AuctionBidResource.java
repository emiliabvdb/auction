package REST;

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
public class AuctionBidResource {

    @EJB
    BidDAO bem;

    @GET
    public List<Bid> getList(@PathParam("auctionId") Long auctionId) {
        return bem.findAllOnAuction(auctionId);
    }

    @GET
    @Path("{id}")
    public Bid get(@PathParam("auctionId") Long auctionId, @PathParam("id") Long id) {
        return bem.findOnAuctionById(auctionId, id);
    }

    @POST
    public Bid save(@PathParam("auctionId") Long auctionId, Bid bid) {
        bem.create(bid);
        return bid;
    }

    @DELETE
    public Bid delete(Bid bid) {
        bem.delete(bid);
        return bid;
    }
}

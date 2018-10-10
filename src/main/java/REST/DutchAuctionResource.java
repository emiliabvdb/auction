package REST;

import DAO.AuctionDAO;
import DAO.DutchAuctionDAO;
import entity.Auction;
import entity.DutchAuction;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.swing.text.html.parser.Entity;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("dutchauction/")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Stateless
public class DutchAuctionResource {

    private static final String AUCTION_NOT_FOUND = "Auction Not Found";
    private static final String AUCTION_EXISTS = "Auction Already Exists";

    @EJB
    DutchAuctionDAO dutchAuctionDAO;

    @GET
    public List<DutchAuction> getList() {
        return dutchAuctionDAO.findAll();
    }

    @Path("{id}")
    @GET
    public DutchAuction get(@PathParam("id") Long id) {
        DutchAuction auction = dutchAuctionDAO.findById(id);

        if (auction == null)
            throw new NotFoundException(DutchAuctionResource.AUCTION_NOT_FOUND);

        return auction;
    }

    @POST
    public Auction save(DutchAuction auction) {

        try {
            dutchAuctionDAO.create(auction);
        } catch (EntityExistsException e){
            throw new ClientErrorException(DutchAuctionResource.AUCTION_EXISTS, 409);
        }

        return auction;
    }

    @Path("{id}")
    @DELETE
    public DutchAuction delete(@PathParam("id") Long id) {
        DutchAuction auction = dutchAuctionDAO.findById(id);

        if (auction == null)
            throw new NotFoundException(DutchAuctionResource.AUCTION_NOT_FOUND);

        dutchAuctionDAO.delete(auction);
        return auction;
    }
}

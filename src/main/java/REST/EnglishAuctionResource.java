package REST;

import DAO.AuctionDAO;
import DAO.EnglishAuctionDAO;
import entity.Auction;
import entity.EnglishAuction;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.swing.text.html.parser.Entity;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("englishauction/")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Stateless
public class EnglishAuctionResource {

    private static final String AUCTION_NOT_FOUND = "Auction Not Found";
    private static final String AUCTION_EXISTS = "Auction Already Exists";

    @EJB
    EnglishAuctionDAO englishAuctionDAO;

    @GET
    public List<EnglishAuction> getList() {
        return englishAuctionDAO.findAll();
    }

    @Path("{id}")
    @GET
    public EnglishAuction get(@PathParam("id") Long id) {
        EnglishAuction auction = englishAuctionDAO.findById(id);

        if (auction == null)
            throw new NotFoundException(EnglishAuctionResource.AUCTION_NOT_FOUND);

        return auction;
    }

    @POST
    public Auction save(EnglishAuction auction) {

        try {
            englishAuctionDAO.create(auction);
        } catch (EntityExistsException e){
            throw new ClientErrorException(EnglishAuctionResource.AUCTION_EXISTS, 409);
        }

        return auction;
    }

    @Path("{id}")
    @DELETE
    public EnglishAuction delete(@PathParam("id") Long id) {
        EnglishAuction auction = englishAuctionDAO.findById(id);

        if (auction == null)
            throw new NotFoundException(EnglishAuctionResource.AUCTION_NOT_FOUND);

        englishAuctionDAO.delete(auction);
        return auction;
    }
}

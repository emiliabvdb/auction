package REST;

import DAO.AuctionDAO;
import entity.Auction;
import entity.EnglishAuction;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.swing.text.html.parser.Entity;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("auction/")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Stateless
public class AuctionResource {

    private static final String AUCTION_NOT_FOUND = "Auction Not Found";
    private static final String AUCTION_EXISTS = "Auction Already Exists";

    @EJB
    AuctionDAO auctionDAO;

	@GET
	public List<Auction> getList() {
        return auctionDAO.findAll();
	}

    @Path("{id}")
	@GET
	public Auction get(@PathParam("id") Long id) {
        Auction auction = auctionDAO.findById(id);

        if (auction == null)
            throw new NotFoundException(AuctionResource.AUCTION_NOT_FOUND);

        return auction;
	}
	
	@POST
    public Auction save(Auction auction) {

	    try {
            auctionDAO.create(auction);
        } catch (EntityExistsException e){
            throw new ClientErrorException(AuctionResource.AUCTION_EXISTS, 409);
        }

		return auction;
	}

    @Path("{id}")
    @DELETE
    public Auction delete(@PathParam("id") Long id) {
	    Auction auction = auctionDAO.findById(id);

        if (auction == null)
            throw new NotFoundException(AuctionResource.AUCTION_NOT_FOUND);

        auctionDAO.delete(auction);
        return auction;
	}
}

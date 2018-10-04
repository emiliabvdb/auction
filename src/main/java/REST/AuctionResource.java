package REST;

import DAO.AuctionDAO;
import entity.Auction;
import entity.EnglishAuction;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("auction/")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Stateless
public class AuctionResource {

	@EJB
	AuctionDAO aem;

	@GET
	public List<Auction> getList() {
		return aem.findAll();
	}

    @Path("{id}")
	@GET
	public Auction get(@PathParam("id") Long id) {
		return aem.findById(id);
	}
	
	@POST
    public Auction save(EnglishAuction auction) {
		aem.create(auction);
		return auction;
	}
	
	@DELETE
    public Auction delete(EnglishAuction auction) {
		aem.delete(auction);
		return auction;
	}
}

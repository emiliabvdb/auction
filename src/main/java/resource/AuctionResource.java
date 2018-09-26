package resource;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import entities.Auction;
import persistence.AuctionPersistence;

@Path("/auction")
@Stateless
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class AuctionResource {
	
	@EJB
	AuctionPersistence aem;
	
	@GET
	public List<Auction> getList() {
		return aem.findAll();
	}
	
	@Path("/{id}")
	@GET
	public Auction getAuction(@PathParam("id") Long id) {
		return aem.findById(id);
	}
	
	@POST
	public Response save(@Valid Auction auction) {
		aem.create(auction);
		return Response.ok().build();
	}
	
	@DELETE
	public Response delete(@Valid Auction auction) {
		aem.delete(auction);
		return Response.ok().build();
	}
}

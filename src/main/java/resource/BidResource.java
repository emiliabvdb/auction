package resource;

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

import entities.Bid;
import persistence.BidPersistence;

@Path("/bid")
@Stateless
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class BidResource {
	
	@EJB
	BidPersistence bem;
	
	@Path("/{id}")
	@GET
	public Bid getAuction(@PathParam("id") Long id) {
		return bem.findById(id);
	}
	
	@POST
	public Response save(@Valid Bid bid) {
		bem.create(bid);
		return Response.ok().build();
	}
	
	@DELETE
	public Response delete(@Valid Bid bid) {
		bem.delete(bid);
		return Response.ok().build();
	}
}

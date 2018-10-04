package REST;

import DAO.BidDAO;
import entity.Bid;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("bid")
@Stateless
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class BidResource {
	
	@EJB
	BidDAO bem;

	@GET
	public List<Bid> getList() {
		return bem.findAll();
	}

	@Path("/{id}")
	@GET
	public Bid get(@PathParam("id") Long id) {
		return bem.findById(id);
	}
	
	@POST
	public Bid save(@Valid Bid bid) {
		bem.create(bid);
		return bid;
	}
	
	@DELETE
	public Bid delete(@Valid Bid bid) {
		bem.delete(bid);
		return bid;
	}
}

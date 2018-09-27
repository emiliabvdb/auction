package rest;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import entities.Auction;
import entities.Auctions;
import entities.Bid;
import entities.Bids;


@Path("/auction")
@Stateless
public class RestService {

	@PersistenceContext(unitName = "auction")
	private EntityManager em;

	/**GET <app-path>/rest/auctions
	 * - which should return a representation with references to 
	 * all current auctions (ongoing/completed) in the system.
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Response getAuctions() {
		TypedQuery<Auction> query = em.createNamedQuery(Auction.productName, Auction.class);
		Auctions auctions = new Auctions(query.getResultList());
		return Response.ok(auctions).build();
	}
	/**GET <app-path>/res/auctions/{id}
	 *  - which should return a representation of the auction identified by id
	 *  **/
	@GET
	@Path("/{id}")
	public Response getAuction(@PathParam("id") String id) {
		int idInt = Integer.parseInt(id);
		Auction auction = em.find(Auction.class, idInt);
		if (auction == null)
			throw new NotFoundException();
		return Response.ok(auction).build();
	}
	
	/**GET <app-path>/res/auctions/{id}/bids/
	 *  - which should return a representation with reference to all current bids 
	 *    in the auction identified by id**/
	@GET
	@Path("/{id}/bids/")
	public Response getCurrentBids(@PathParam("id") String id) {
		TypedQuery<Bid> query = em.createNamedQuery(Bid.name, Bid.class);
		Bids bids = new Bids(query.getResultList());
		return Response.ok(bids).build();
	}
	
	/**GET <app-path>/res/auctions/{aid}/bids/{bid}
	 *  - which should return a representation of the given bid within
	 *    the auction identified by aid **/
	@GET
	@Path("/{aid}/bids/{bid}")
	public Response getBid(@PathParam("aid") String aid, @PathParam("bid") String biid) {
		int aidInt = Integer.parseInt(aid);
		Auction auction = em.find(Auction.class, aidInt);
		if (auction == null)
			throw new NotFoundException();

		int bidInt = Integer.parseInt(biid);
		Bid bid = em.find(Bid.class, bidInt);
		if (bid == null)
			throw new NotFoundException();
		
		//TODO 
		return Response.ok(bid).build();
	}
	
	/**POST <app-path>/res/auction/{id}/bids
	 *  - which creates a bid with a specified amount in 
	 *  the auction identified by id and returns a representation of the bid. 
	 *  The amount should be contained in the payload of the request 
	 *  (or optionally as a query parameter).**/
	@POST
	@Path("/{aid}/bids")
	public String createBid(@PathParam("aid") String aid, double amount) {
		int aidInt = Integer.parseInt(aid);
		Auction auction = em.find(Auction.class, aidInt);
		if (amount <= auction.getHighetBid().amount)
			return "Bid lower then highest bid";
		//TODO
		return "Bidded done";
	}
}


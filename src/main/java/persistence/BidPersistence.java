package persistence;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Bid;

@Stateless
public class BidPersistence {

	@PersistenceContext(name = "AuctionPersistenceUnit")
	EntityManager em;

	public Bid findById(Long id){
		return this.em.find(Bid.class, id);
	}
	
	public List<Bid> findAll(){
		return this.em.createNamedQuery(Bid.FIND_ALL).getResultList();
	}
	
	public void create(Bid bid) {
		this.em.persist(bid);
	}
	
	public void delete(Bid bid) {
		this.em.remove(bid);
	}
}

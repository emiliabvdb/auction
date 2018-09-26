package persistence;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Auction;

@Stateless
public class AuctionPersistence {

	@PersistenceContext(name = "auction")
	EntityManager em;

	public Auction findById(Long id){
		return this.em.find(Auction.class, id);
	}
	
	public List<Auction> findAll(){
		return this.em.createNamedQuery(Auction.FIND_ALL).getResultList();
	}
	
	public void create(Auction auction) {
		this.em.persist(auction);
	}
	
	public void delete(Auction auction) {
		this.em.remove(auction);
	}
}

package DAO;

import entity.Auction;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class AuctionDAO extends BaseDAO<Auction> {

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

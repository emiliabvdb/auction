package DAO;

import entity.Auction;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class AuctionDAO extends BaseDAO<Auction> {

	@Override
	public Auction findById(Long id){
		return this.em.find(Auction.class, id);
	}

	@Override
	public List<Auction> findAll(){
		return this.em.createNamedQuery(Auction.FIND_ALL, Auction.class).getResultList();
	}

	@Override
	public void create(Auction auction) {
		this.em.persist(auction);
	}

	@Override
	public void delete(Auction auction) {
		this.em.remove(auction);
	}
}

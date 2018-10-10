package DAO;

import java.util.List;

import javax.ejb.Stateless;

import entity.Auction;

@Stateless
public class AuctionDAO extends BaseDAO<Auction> {

	@Override
	public Auction findById(Long id){
        return em.find(Auction.class, id);
	}

	@Override
	public List<Auction> findAll(){
        return em.createNamedQuery(Auction.FIND_ALL, Auction.class).getResultList();
	}

	@Override
	public void create(Auction auction) {
        em.persist(auction);
	}

	@Override
	public void delete(Auction auction) {
        em.remove(auction);
    }

    @Override
    public Auction update(Auction auction) {
        return em.merge(auction);
    }

    public List<Auction> findAllPublished() {
        return em.createNamedQuery(Auction.FIND_ALL_PUBLISHED, Auction.class).getResultList();
    }
}

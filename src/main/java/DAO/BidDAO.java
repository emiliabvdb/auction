package DAO;

import entity.Bid;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class BidDAO extends BaseDAO<Bid> {

    @Override
    public Bid findById(Long id){
        return this.em.find(Bid.class, id);
    }


    @Override
	public List<Bid> findAll(){
        return this.em.createNamedQuery(Bid.FIND_ALL, Bid.class).getResultList();
    }


    public List<Bid> findAllOnAuction(Long auctionId) {
        TypedQuery<Bid> query = this.em.createNamedQuery(Bid.FIND_ALL_ON_AUCTION, Bid.class);
        query.setParameter("auctionId", auctionId);
        return query.getResultList();
    }

    public Bid findOnAuctionById(Long auctionId, Long id) {
        TypedQuery<Bid> query = this.em.createNamedQuery(Bid.FIND_ON_AUCTION, Bid.class);
        query.setParameter("auctionId", auctionId);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
	public void create(Bid bid) {
		this.em.persist(bid);
	}

    @Override
	public void delete(Bid bid) {
		this.em.remove(bid);
	}
}

package DAO;

import entity.Bid;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class BidDAO extends BaseDAO<Bid> {

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

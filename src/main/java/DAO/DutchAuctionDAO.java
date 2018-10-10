package DAO;

import java.util.List;

import javax.ejb.Stateless;

import entity.Auction;
import entity.DutchAuction;
import entity.EnglishAuction;

@Stateless
public class DutchAuctionDAO extends BaseDAO<DutchAuction> {

    @Override
    public DutchAuction findById(Long id){
        return em.find(DutchAuction.class, id);
    }

    @Override
    public List<DutchAuction> findAll(){
        return em.createNamedQuery(DutchAuction.FIND_ALL, DutchAuction.class).getResultList();
    }

    @Override
    public void create(DutchAuction auction) {
        em.persist(auction);
    }

    @Override
    public void delete(DutchAuction auction) {
        em.remove(auction);
    }

    @Override
    public DutchAuction update(DutchAuction auction) {
        return em.merge(auction);
    }

    public List<DutchAuction> findAllPublished() {
        return em.createNamedQuery(DutchAuction.FIND_ALL_PUBLISHED, DutchAuction.class).getResultList();
    }
}

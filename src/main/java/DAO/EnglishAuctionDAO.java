package DAO;

import java.util.List;

import javax.ejb.Stateless;

import entity.Auction;
import entity.EnglishAuction;

@Stateless
public class EnglishAuctionDAO extends BaseDAO<EnglishAuction> {

    @Override
    public EnglishAuction findById(Long id){
        return em.find(EnglishAuction.class, id);
    }

    @Override
    public List<EnglishAuction> findAll(){
        return em.createNamedQuery(EnglishAuction.FIND_ALL, EnglishAuction.class).getResultList();
    }

    @Override
    public void create(EnglishAuction auction) {
        em.persist(auction);
    }

    @Override
    public void delete(EnglishAuction auction) {
        em.remove(auction);
    }

    @Override
    public EnglishAuction update(EnglishAuction auction) {
        return em.merge(auction);
    }

    public List<EnglishAuction> findAllPublished() {
        return em.createNamedQuery(EnglishAuction.FIND_ALL_PUBLISHED, EnglishAuction.class).getResultList();
    }
}

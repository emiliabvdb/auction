package DAO;

import entity.Auction;
import entity.Feedback;
import entity.User;

import javax.persistence.TypedQuery;
import java.util.List;

public class FeedbackDAO extends BaseDAO<Feedback> {


    @Override
    public Feedback findById(Long id) {
        return em.find(Feedback.class, id);
    }

    @Override
    public List<Feedback> findAll() {
        return em.createNamedQuery(Feedback.FIND_ALL, Feedback.class).getResultList();
    }

    @Override
    public void create(Feedback feedback) {
        em.persist(feedback);
    }

    @Override
    public void delete(Feedback feedback) {
        em.remove(feedback);
    }

    @Override
    public Feedback update(Feedback feedback) {
        return em.merge(feedback);
    }

    public List<Feedback> findAllOnBidder(User user) {
        TypedQuery<Feedback> query = em.createNamedQuery(Feedback.FIND_ALL_ON_BIDDER, Feedback.class);
        query.setParameter("", user.getEmail());
        return query.getResultList();
    }

    public List<Feedback> findAllOnAuction(Auction auction) {
        TypedQuery<Feedback> query = em.createNamedQuery(Feedback.FIND_ALL_ON_AUCTION, Feedback.class);
        query.setParameter("", auction.getId());
        return query.getResultList();
    }
}

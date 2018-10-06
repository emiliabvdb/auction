package DAO;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public abstract class BaseDAO<T> {

    @PersistenceContext(name = "AuctionPersistenceUnit")
    EntityManager em;

    public abstract T findById(Long id);

    public abstract List<T> findAll();

    public abstract void create(T t);

    public abstract void delete(T t);

    public abstract T update(T t);

}

package DAO;

import entity.User;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class UserDAO extends BaseDAO<User> {

    @Override
    public User findById(Long id) {
        return em.find(User.class, id);
    }
    
    public User findByEmail(String email) {
    	return em.find(User.class, email);
    }

    @Override
    public List<User> findAll() {
        return em.createNamedQuery(User.FIND_ALL, User.class).getResultList();
    }

    @Override
    public void create(User user) {
        em.persist(user);
    }

    @Override
    public void delete(User user) {
        em.remove(user);
    }

    @Override
    public User update(User user) {
        return em.merge(user);
    }
}

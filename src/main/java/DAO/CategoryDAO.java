package DAO;

import entity.Category;

import java.util.List;

public class CategoryDAO extends BaseDAO<Category> {


    @Override
    public Category findById(Long id) {
        return em.find(Category.class, id);
    }

    @Override
    public List<Category> findAll() {
        return em.createNamedQuery(Category.FIND_ALL, Category.class).getResultList();
    }

    @Override
    public void create(Category category) {
        em.persist(category);
    }

    @Override
    public void delete(Category category) {
        em.remove(category);
    }

    @Override
    public Category update(Category category) {
        return em.merge(category);
    }
}

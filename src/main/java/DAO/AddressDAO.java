package DAO;

import entity.Address;

import java.util.List;

public class AddressDAO extends BaseDAO<Address> {

    @Override
    public Address findById(Long id) {
        return this.em.find(Address.class, id);
    }

    @Override
    public List<Address> findAll() {
        return this.em.createNamedQuery(Address.FIND_ALL, Address.class).getResultList();
    }

    @Override
    public void create(Address address) {
        this.em.persist(address);
    }

    @Override
    public void delete(Address address) {
        this.em.remove(address);
    }
}

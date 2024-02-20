package com.workintech.burgerapi.dao;

import com.workintech.burgerapi.entity.Burger;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BurgerDaoImpl implements BurgerDao{
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void save(Burger burger) {
        entityManager.persist(burger);
    }

    @Override
    public Burger findById(int id) {
        return entityManager.find(Burger.class, id);
    }

    @Override
    public List<Burger> findAll() {
        return entityManager.createQuery("SELECT b FROM Burger b", Burger.class).getResultList();
    }

    @Override
    public List<Burger> findByPrice(double price) {
        return entityManager.createQuery("SELECT b FROM Burger b WHERE b.price > :price ", Burger.class)
                .setParameter("price", price)
                .getResultList();


    }

    @Override
    public List<Burger> findByBreadType(String breadType) {
        return entityManager.createQuery("SELECT b FROM Burger b WHERE b.breadType = :breadType ORDER BY b.name ASC", Burger.class)
                .setParameter("content","%" + "content" + "%" )
                .getResultList();
    }

    @Override
    public List<Burger> findByContent(String content) {
        return entityManager.createQuery("SELECT b FROM Burger b WHERE b.contents LIKE :content", Burger.class)
                .setParameter("content", "%" + content + "%")
                .getResultList();
    }

    @Transactional
    @Override
    public Burger update(Burger burger) {
        entityManager.merge(burger);
        return burger;
    }

    @Transactional
    @Override
    public void remove(Integer id) {
        Burger burger = findById(id);
        if(burger != null)
            entityManager.remove(burger);
    }
}

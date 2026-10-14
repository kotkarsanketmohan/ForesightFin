package com.example.ForesightFin.repository;

import com.example.ForesightFin.entity.Income;
import com.example.ForesightFin.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class IncomeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Income income) {
        if (income.getId() == null) {
            entityManager.persist(income);
        } else {
            entityManager.merge(income);
        }
    }

    public List<Income> findByUser(User user) {
        return entityManager.createQuery(
                        "SELECT i FROM Income i WHERE i.user = :user",
                        Income.class
                ).setParameter("user", user)
                .getResultList();
    }

    public void deleteById(Long id) {
        Income income = entityManager.find(Income.class, id);
        if (income != null) {
            entityManager.remove(income);
        }
    }
}

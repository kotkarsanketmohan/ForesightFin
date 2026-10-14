package com.example.ForesightFin.repository;

import com.example.ForesightFin.entity.Expense;
import com.example.ForesightFin.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExpenseRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Expense expense) {
        entityManager.persist(expense);
    }

    public List<Expense> findByUser(User user) {
        return entityManager
                .createQuery(
                        "SELECT e FROM Expense e WHERE e.user = :user",
                        Expense.class
                )
                .setParameter("user", user)
                .getResultList();
    }

    public void deleteById(Long id) {
        Expense expense = entityManager.find(Expense.class, id);
        if (expense != null) {
            entityManager.remove(expense);
        }
    }
}

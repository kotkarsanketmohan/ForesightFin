package com.example.ForesightFin.repository;

import com.example.ForesightFin.entity.Goal;
import com.example.ForesightFin.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GoalRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Goal goal) {
        entityManager.persist(goal);
    }

    public List<Goal> findByUser(User user) {
        return entityManager
                .createQuery(
                        "SELECT g FROM Goal g WHERE g.user = :user",
                        Goal.class
                )
                .setParameter("user", user)
                .getResultList();
    }

    public void deleteById(Long id) {
        Goal goal = entityManager.find(Goal.class, id);
        if (goal != null) {
            entityManager.remove(goal);
        }
    }
}

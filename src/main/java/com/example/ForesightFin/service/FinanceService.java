package com.example.ForesightFin.service;

import com.example.ForesightFin.entity.Expense;
import com.example.ForesightFin.entity.Goal;
import com.example.ForesightFin.entity.Income;
import com.example.ForesightFin.entity.User;
import com.example.ForesightFin.repository.ExpenseRepository;
import com.example.ForesightFin.repository.GoalRepository;
import com.example.ForesightFin.repository.IncomeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class FinanceService {

    private final IncomeRepository incomeRepository;
    private final ExpenseRepository expenseRepository;
    private final GoalRepository goalRepository;

    public FinanceService(IncomeRepository incomeRepository,
                          ExpenseRepository expenseRepository,
                          GoalRepository goalRepository) {
        this.incomeRepository = incomeRepository;
        this.expenseRepository = expenseRepository;
        this.goalRepository = goalRepository;
    }

    // ================= INCOME =================
    public void addIncome(Income income) {
        incomeRepository.save(income);
    }

    public List<Income> getIncomeByUser(User user) {
        return incomeRepository.findByUser(user);
    }

    public void deleteIncome(Long id) {
        incomeRepository.deleteById(id);
    }

    // ================= EXPENSE =================
    public void addExpense(Expense expense) {
        expenseRepository.save(expense);
    }

    public List<Expense> getExpensesByUser(User user) {
        return expenseRepository.findByUser(user);
    }

    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

    // ================= GOAL =================
    public void addGoal(Goal goal) {
        goalRepository.save(goal);
    }

    public List<Goal> getGoalsByUser(User user) {
        return goalRepository.findByUser(user);
    }

    public void deleteGoal(Long id) {
        goalRepository.deleteById(id);
    }
}

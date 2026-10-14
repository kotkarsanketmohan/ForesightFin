package com.example.ForesightFin.controller;

import com.example.ForesightFin.entity.Expense;
import com.example.ForesightFin.entity.Goal;
import com.example.ForesightFin.entity.Income;
import com.example.ForesightFin.entity.User;
import com.example.ForesightFin.repository.UserRepository;
import com.example.ForesightFin.service.FinanceService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FinanceController {

    private final FinanceService financeService;
    private final UserRepository userRepository;

    public FinanceController(FinanceService financeService,
                             UserRepository userRepository) {
        this.financeService = financeService;
        this.userRepository = userRepository;
    }

    // ================= INCOME =================

    @GetMapping("/income")
    public String incomePage(Model model, Authentication auth) {

        User user = userRepository
                .findByEmail(auth.getName())
                .orElseThrow();

        model.addAttribute("income", new Income());
        model.addAttribute("incomeList",
                financeService.getIncomeByUser(user));

        return "income";
    }

    // ---------- POST ADD ----------
    @PostMapping("/income/add")
    public String addIncome(@ModelAttribute Income income,
                            Authentication authentication) {

        User user = userRepository
                .findByEmail(authentication.getName())
                .orElseThrow();

        income.setUser(user);
        financeService.addIncome(income);

        return "redirect:/income";
    }


    @GetMapping("/income/delete/{id}")
    public String deleteIncome(@PathVariable Long id) {
        financeService.deleteIncome(id);
        return "redirect:/income";
    }

    // ================= EXPENSE =================

    @GetMapping("/expense")
    public String expensePage(Model model, Authentication auth) {

        User user = userRepository
                .findByEmail(auth.getName())
                .orElseThrow();
        model.addAttribute("expense", new Expense());


        model.addAttribute("expenseList",
                financeService.getExpensesByUser(user));

        return "expense";
    }

    @PostMapping("/expense/save")
    public String saveExpense(@ModelAttribute Expense expense,
                              Authentication auth) {

        User user = userRepository
                .findByEmail(auth.getName())
                .orElseThrow();

        expense.setUser(user);
        financeService.addExpense(expense);

        return "redirect:/expense";
    }

    @GetMapping("/expense/delete/{id}")
    public String deleteExpense(@PathVariable Long id) {
        financeService.deleteExpense(id);
        return "redirect:/expense";
    }

    // ================= GOAL =================

    @GetMapping("/goal")
    public String goalPage(Model model, Authentication auth) {

        User user = userRepository
                .findByEmail(auth.getName())
                .orElseThrow();

        model.addAttribute("goal", new Goal());

        model.addAttribute("goalList",
                financeService.getGoalsByUser(user));

        return "goal";
    }

    @PostMapping("/goal/save")
    public String saveGoal(@ModelAttribute Goal goal,
                           Authentication auth) {

        User user = userRepository
                .findByEmail(auth.getName())
                .orElseThrow();


        goal.setUser(user);
        financeService.addGoal(goal);

        return "redirect:/goal";
    }

    @GetMapping("/goal/delete/{id}")
    public String deleteGoal(@PathVariable Long id) {
        financeService.deleteGoal(id);
        return "redirect:/goal";
    }
}

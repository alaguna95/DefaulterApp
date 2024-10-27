package com.galibox.defaulterApp.expense.repository;

import com.galibox.defaulterApp.expense.domain.Expense;
import com.galibox.defaulterApp.shared.Id;

import java.util.Optional;

public class ExpenseRepository {
    
    private ExpenseJpaRepository expenseJpaRepository;
    public void save (final Expense expense) {


    }

    public void delete (final Expense expense) {

    }


    public Optional<Expense> get (final Id id) {

        return Optional.empty();
    }
    
}

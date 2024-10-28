package com.galibox.defaulterApp.expense.usecases;

import com.galibox.defaulterApp.expense.domain.Expense;
import com.galibox.defaulterApp.shared.Id;

import java.util.List;
import java.util.Optional;

public interface ExpenseRepository {
    
      void save(Expense expense);
      
      void delete(Expense expense);

      Optional<Expense> get(Id id);
      
      List<Expense> search();
}

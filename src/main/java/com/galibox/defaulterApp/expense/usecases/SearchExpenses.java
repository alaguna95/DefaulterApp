package com.galibox.defaulterApp.expense.usecases;

import com.galibox.defaulterApp.expense.domain.Expense;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchExpenses {
    
    private final ExpenseRepository expenseRepository;
    
    public List<Expense> searchExpenses() {
      
        return expenseRepository.search();
    }
    
}

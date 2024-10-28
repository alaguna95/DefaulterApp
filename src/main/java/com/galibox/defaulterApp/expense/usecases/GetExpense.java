package com.galibox.defaulterApp.expense.usecases;

import com.galibox.defaulterApp.expense.domain.Expense;
import com.galibox.defaulterApp.expense.repository.ExpenseRepositoryImpl;
import com.galibox.defaulterApp.shared.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetExpense {
    
    private final ExpenseRepositoryImpl expenseRepository;
    
    public Expense get(final Id id) {
        
        return expenseRepository.get(id).orElseThrow(
            () -> new IllegalArgumentException("Expense not found with id: " + id));
    }
    
    
}

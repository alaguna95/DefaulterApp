package com.galibox.defaulterApp.expense.usecases;

import com.galibox.defaulterApp.expense.repository.ExpenseRepository;
import com.galibox.defaulterApp.group.usecases.GetGroup;
import com.galibox.defaulterApp.shared.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeleteExpense {

    private final GetExpense getExpense;
    
    private final ExpenseRepository expenseRepository;
    public void delete(final Id id){
        
        expenseRepository.delete(getExpense.get(id));
    }
    
    
}


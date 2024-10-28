package com.galibox.defaulterApp.expense.usecases;

import com.galibox.defaulterApp.expense.repository.ExpenseRepositoryImpl;
import com.galibox.defaulterApp.shared.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DeleteExpense {

    private final GetExpense getExpense;
    
    private final ExpenseRepositoryImpl expenseRepository;
    
    @Transactional
    public void delete(final Id id){

        expenseRepository.delete(getExpense.get(id));
    }
    
    
}


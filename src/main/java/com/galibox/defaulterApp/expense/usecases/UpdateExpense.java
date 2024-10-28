package com.galibox.defaulterApp.expense.usecases;

import com.galibox.defaulterApp.expense.domain.Expense;
import com.galibox.defaulterApp.expense.domain.UserExpense;
import com.galibox.defaulterApp.expense.repository.ExpenseRepositoryImpl;
import com.galibox.defaulterApp.group.domain.Group;
import com.galibox.defaulterApp.group.usecases.GetGroup;
import com.galibox.defaulterApp.shared.Amount;
import com.galibox.defaulterApp.shared.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UpdateExpense {
    
    private final GetExpense getExpense;
    
    private final GetGroup getGroup;

    private final ExpenseRepositoryImpl expenseRepository;
    
    public void update(
            Id id, 
            Amount totalAmount,
            List<UserExpense> userExpenses) {

        Expense expense = this.getExpense.get(id);
        Group group = this.getGroup.getGroup(expense.getGroupId());
        expenseRepository.save(expense.update(group, totalAmount, userExpenses));
    }
    
    
}

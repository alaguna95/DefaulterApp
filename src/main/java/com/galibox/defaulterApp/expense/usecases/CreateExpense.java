package com.galibox.defaulterApp.expense.usecases;

import com.galibox.defaulterApp.expense.domain.Expense;
import com.galibox.defaulterApp.expense.domain.Name;
import com.galibox.defaulterApp.expense.domain.UserExpense;
import com.galibox.defaulterApp.expense.repository.ExpenseRepository;
import com.galibox.defaulterApp.group.domain.Group;
import com.galibox.defaulterApp.group.usecases.GetGroup;
import com.galibox.defaulterApp.shared.Amount;
import com.galibox.defaulterApp.shared.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CreateExpense {
    
    private final GetGroup getGroup;
    
    private final ExpenseRepository expenseRepository;
    
    public void create(
            Id id, 
            Id groupId, 
            Name name, 
            Amount totalAmount,
            List<UserExpense> userExpenses) {

        Group group = getGroup.getGroup(groupId);
        expenseRepository.save(Expense.create(id, group, name, totalAmount, userExpenses));
    }
}
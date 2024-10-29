package com.galibox.defaulterApp.expense.repository;

import com.galibox.defaulterApp.expense.domain.Expense;
import com.galibox.defaulterApp.expense.domain.UserExpense;
import com.galibox.defaulterApp.expense.usecases.ExpenseRepository;
import com.galibox.defaulterApp.shared.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ExpenseRepositoryImpl implements ExpenseRepository {
    
    private final ExpenseJpaRepository expenseJpaRepository;
   
    @Override
    public void save(final Expense expense) {

        expenseJpaRepository.save(map(expense));
    }

    @Override
    public void delete(final Expense expense) {

        expenseJpaRepository.delete(map(expense));
    }


    @Override
    public Optional<Expense> get(final Id id) {

        return expenseJpaRepository.findExpenseById(id.getValue())
                .map(expenseEntity -> (Expense)EntityToDomainMapper.map(expenseEntity,Expense.class));
    }

    @Override
    public List<Expense> search() {

        return expenseJpaRepository.findAll().stream()
                .map(expenseEntity -> (Expense)EntityToDomainMapper.map(expenseEntity,Expense.class))
                .toList();
    }
    
    
    private ExpenseEntity map(Expense expense) {
       
        if (expense == null) {
            return null;
        }

        ExpenseEntity expenseEntity = new ExpenseEntity();
        expenseEntity.setId(expense.getId().getValue());
        expenseEntity.setGroupId(expense.getGroupId().getValue());
        expenseEntity.setName(expense.getName().getValue());
        expenseEntity.setTotalAmount(expense.getTotalAmount().getValue());
        expenseEntity.setUserExpenses(expense.getUserExpenses().stream()
                .map(this::map)
                .collect(Collectors.toList()));

        return expenseEntity;
    }

    public  UserExpenseEntity map(UserExpense userExpense) {
        if (userExpense == null) {
            return null;
        }

        UserExpenseEntity userExpenseEntity = new UserExpenseEntity();
        userExpenseEntity.setUserId(userExpense.getUserId().getValue());
        userExpenseEntity.setAmount(userExpense.getAmount().getValue());

        return userExpenseEntity;
    }
    
    
}

package com.galibox.defaulterApp.expense.controller;


import com.galibox.defaulterApp.expense.domain.Expense;
import com.galibox.defaulterApp.expense.domain.Name;
import com.galibox.defaulterApp.expense.domain.UserExpense;
import com.galibox.defaulterApp.expense.usecases.CreateExpense;
import com.galibox.defaulterApp.expense.usecases.DeleteExpense;
import com.galibox.defaulterApp.expense.usecases.SearchExpenses;
import com.galibox.defaulterApp.expense.usecases.UpdateExpense;
import com.galibox.defaulterApp.shared.Amount;
import com.galibox.defaulterApp.shared.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/expenses", produces = "application/json")
class ExpenseController {

    private final SearchExpenses searchExpenses;
   
    private final CreateExpense createExpense;
   
    private final UpdateExpense updateExpense;
   
    private final DeleteExpense deleteExpense;

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<List<Expense>> getExpenses() {

        return ResponseEntity.ok(searchExpenses.searchExpenses());
    }

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<List<Expense>> createExpense(@RequestBody CreateExpenseDTO createExpenseDTO) {

        Id newExpenseId = Id.create();
        createExpense.create(
                newExpenseId,
                Id.of(createExpenseDTO.getGroupId()),
                Name.of(createExpenseDTO.getName()),
                Amount.of(createExpenseDTO.getTotalAmount()),
                createExpenseDTO.getUserExpenses().stream()
                        .map(userExpenseDTO -> UserExpense.of(
                                Id.of(userExpenseDTO.getUserId()),
                                Amount.of(userExpenseDTO.getAmount())))
                        .toList());
        return ResponseEntity.created(URI.create("/expenses/"+newExpenseId)).build();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{expenseId}")
    ResponseEntity<List<Expense>> updateExpense(
            @RequestParam UUID expenseId, 
            @RequestBody UpdateExpenseDTO updateExpenseDTO) {
        
        updateExpense.update(
                Id.of(expenseId),
                Amount.of(updateExpenseDTO.getTotalAmount()),
                updateExpenseDTO.getUserExpenses().stream()
                        .map(userExpenseDTO -> UserExpense.of(
                                Id.of(userExpenseDTO.getUserId()),
                                Amount.of(userExpenseDTO.getAmount())))
                        .toList());
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{expenseId}")
    ResponseEntity<List<Expense>> deleteExpense(@RequestParam UUID expenseId) {

        deleteExpense.delete(Id.of(expenseId));
        return ResponseEntity.noContent().build();
    }
}

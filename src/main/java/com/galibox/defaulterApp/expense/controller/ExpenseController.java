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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    ResponseEntity<List<Expense>> createExpense(CreateExpenseDTO createExpenseDTO) {

        createExpense.create(
                new Id(UUID.randomUUID()),
                new Id(createExpenseDTO.getGroupId()),
                new Name(createExpenseDTO.getName()),
                new Amount(createExpenseDTO.getTotalAmount()),
                List.of());
        return ResponseEntity.created(null).build();
    }

    @RequestMapping(method = RequestMethod.PUT)
    ResponseEntity<List<Expense>> updateExpense() {

        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.DELETE)
    ResponseEntity<List<Expense>> deleteExpense() {

        return ResponseEntity.noContent().build();
    }
}

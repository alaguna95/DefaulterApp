package com.galibox.defaulterApp.expense.repository;

import com.galibox.defaulterApp.expense.domain.Name;
import com.galibox.defaulterApp.expense.domain.UserExpense;
import com.galibox.defaulterApp.shared.Amount;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Document(collection = "expenses")
@Data
public class ExpenseEntity {

    @Id
    private UUID id;

    private  UUID groupId;

    private  String name;

    private  BigDecimal totalAmount;

    private List<UserExpenseEntity> userExpenses;
}

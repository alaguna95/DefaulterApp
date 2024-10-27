package com.galibox.defaulterApp.expense.repository;

import com.galibox.defaulterApp.expense.domain.UserExpense;
import com.galibox.defaulterApp.shared.Amount;
import com.galibox.defaulterApp.shared.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Document(collection = "expenses")
public class UserExpenseEntity {

    private UUID userId;

    private BigDecimal amount;
}

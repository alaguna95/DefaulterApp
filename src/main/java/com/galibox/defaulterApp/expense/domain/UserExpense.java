package com.galibox.defaulterApp.expense.domain;

import com.galibox.defaulterApp.shared.Amount;
import com.galibox.defaulterApp.shared.Id;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
public final class UserExpense {

    private final Id userId;
    
    private final Amount amount;

    UserExpense(Id userId, Amount amount) {
        this.userId = userId;
        this.amount = amount;
    }
}

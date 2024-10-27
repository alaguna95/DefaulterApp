package com.galibox.defaulterApp.group.domain;

import com.galibox.defaulterApp.shared.Id;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
public final class Participant {
    
    private final Id userId;
    
    private final BigDecimal totalExpense;
    
    private final BigDecimal balance;

    Participant(Id userId, BigDecimal totalExpense, BigDecimal balance) {
        this.userId = userId;
        this.totalExpense = totalExpense;
        this.balance = balance;
    }
}

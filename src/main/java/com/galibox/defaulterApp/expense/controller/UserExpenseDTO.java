package com.galibox.defaulterApp.expense.controller;

import com.galibox.defaulterApp.expense.repository.UserExpenseEntity;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
class UserExpenseDTO {

    private UUID userId;

    private BigDecimal amount;
}

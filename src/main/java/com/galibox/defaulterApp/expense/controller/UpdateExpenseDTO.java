package com.galibox.defaulterApp.expense.controller;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
class UpdateExpenseDTO {

    private BigDecimal totalAmount;

    private List<UserExpenseDTO> userExpenses;
}

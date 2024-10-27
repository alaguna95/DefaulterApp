package com.galibox.defaulterApp.expense.controller;

import com.galibox.defaulterApp.expense.repository.UserExpenseEntity;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class UserExpenseDTO {

    private UUID id;

    private  UUID groupId;

    private  String name;

    private BigDecimal totalAmount;

    private List<UserExpenseDTO> userExpenses;
}

package com.galibox.defaulterApp.expense.controller;

import com.galibox.defaulterApp.expense.repository.UserExpenseEntity;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
public class CreateExpenseDTO {

    private UUID id;

    private  UUID groupId;

    private  String name;

    private BigDecimal totalAmount;

    private List<UserExpenseEntity> userExpenses;
}

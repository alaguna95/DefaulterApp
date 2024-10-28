package com.galibox.defaulterApp.expense.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

interface ExpenseJpaRepository extends MongoRepository<ExpenseEntity, String> {

    Optional<ExpenseEntity> findExpenseById(UUID id);

}

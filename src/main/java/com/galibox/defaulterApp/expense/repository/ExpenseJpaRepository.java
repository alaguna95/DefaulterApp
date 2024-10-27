package com.galibox.defaulterApp.expense.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

interface ExpenseJpaRepository extends MongoRepository<ExpenseEntity, String> {
}

package com.systems.transaction.processing.repository;

import com.systems.transaction.processing.model.ProcessedTransaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProcessedTransactionRepository extends MongoRepository<ProcessedTransaction, String> {
}

package ua.orlov.fintechtransaction.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ua.orlov.fintechtransaction.dao.TransactionRepository;
import ua.orlov.fintechtransaction.dto.CreateTransactionRequest;
import ua.orlov.fintechtransaction.mapper.TransactionMapper;
import ua.orlov.fintechtransaction.model.Transaction;
import ua.orlov.fintechtransaction.service.TransactionService;

import java.util.List;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public Transaction createTransaction(CreateTransactionRequest request) {
        Transaction transaction = transactionMapper.createTransactionRequestToTransaction(request);

        Transaction savedTransaction = transactionRepository.save(transaction);

        kafkaTemplate.send("transaction.create", savedTransaction.toString());

        return savedTransaction;
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return (List<Transaction>) transactionRepository.findAll();
    }
}

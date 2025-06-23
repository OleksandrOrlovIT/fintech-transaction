package ua.orlov.fintechtransaction.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.orlov.fintechtransaction.dao.TransactionRepository;
import ua.orlov.fintechtransaction.dto.CreateTransactionRequest;
import ua.orlov.fintechtransaction.mapper.TransactionMapper;
import ua.orlov.fintechtransaction.model.Transaction;
import ua.orlov.fintechtransaction.service.TransactionService;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    @Override
    public Transaction createTransaction(CreateTransactionRequest request) {
        Transaction transaction = transactionMapper.createTransactionRequestToTransaction(request);

        return transactionRepository.save(transaction);
    }
}

package ua.orlov.fintechtransaction.service;

import ua.orlov.fintechtransaction.dto.CreateTransactionRequest;
import ua.orlov.fintechtransaction.model.Transaction;

import java.util.List;

public interface TransactionService {

    Transaction createTransaction(CreateTransactionRequest request);

    List<Transaction> getAllTransactions();

}

package ua.orlov.fintechtransaction.service;

import ua.orlov.fintechtransaction.dto.CreateTransactionRequest;
import ua.orlov.fintechtransaction.model.Transaction;

public interface TransactionService {

    Transaction createTransaction(CreateTransactionRequest request);

}

package ua.orlov.fintechtransaction.dao;

import ua.orlov.fintechtransaction.model.Transaction;

import java.util.List;

public interface TransactionRepository {

    Transaction save(Transaction transaction);

    List<Transaction> findAll();

}

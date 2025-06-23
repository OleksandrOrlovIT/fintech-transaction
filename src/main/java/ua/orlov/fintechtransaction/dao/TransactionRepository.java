package ua.orlov.fintechtransaction.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.orlov.fintechtransaction.model.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

}

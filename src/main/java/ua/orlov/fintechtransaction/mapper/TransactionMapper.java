package ua.orlov.fintechtransaction.mapper;

import org.springframework.stereotype.Component;
import ua.orlov.fintechtransaction.dto.CreateTransactionRequest;
import ua.orlov.fintechtransaction.model.Category;
import ua.orlov.fintechtransaction.model.Transaction;

@Component
public class TransactionMapper {

    public Transaction createTransactionRequestToTransaction(CreateTransactionRequest request) {
        Transaction transaction = new Transaction();
        transaction.setUserId(request.getUserId());
        transaction.setAmount(request.getAmount());
        transaction.setDescription(request.getDescription());
        transaction.setTimestamp(request.getTimestamp());
        transaction.setCategory(Category.fromDescription(request.getDescription()));

        return transaction;
    }

}

package ua.orlov.fintechtransaction.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.orlov.fintechtransaction.dto.CreateTransactionRequest;
import ua.orlov.fintechtransaction.model.Transaction;
import ua.orlov.fintechtransaction.service.TransactionService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping
    public Transaction createTransaction(@RequestBody CreateTransactionRequest request) {
        return transactionService.createTransaction(request);
    }

}

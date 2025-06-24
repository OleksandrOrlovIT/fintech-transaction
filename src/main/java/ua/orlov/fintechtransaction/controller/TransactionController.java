package ua.orlov.fintechtransaction.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.orlov.fintechtransaction.dto.CreateTransactionRequest;
import ua.orlov.fintechtransaction.model.Transaction;
import ua.orlov.fintechtransaction.service.TransactionService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping
    public Transaction createTransaction(@RequestBody CreateTransactionRequest request) {
        return transactionService.createTransaction(request);
    }

    @GetMapping("/get-all")
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

}
